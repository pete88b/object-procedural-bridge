/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.butterfill.opb.data;

import com.butterfill.opb.OpbException;
import com.butterfill.opb.OpbId;
import com.butterfill.opb.OpbObjectSource;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbExactMatchList;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Encapsulates the instantiation of data objects.
 * <br/>
 * For an Opb based application, this class should provide all methods needed
 * to create data objects.
 * <br/>
 * <br/>
 * Provides notification of the data object life cycle event;
 * <ul>
 *   <li>Data object created</li>
 * </ul>
 *
 * <p>
 * <em>In all method comments for this class:</em>
 * <br/>
 * The term cached refers to an object that has been cached by
 * getResult(Class, ResultSet, boolean) or
 * getResult(Class, ResultSet, OpbId, boolean).
 * <br/>
 * The term saved refers to an object that has been saved by
 * getInstance(Class, String).
 * </p>
 *
 * <p>
 * <em>For all methds of this class:</em>
 * <br/>
 * The actual argument for the parameter <code>classOfObject</code> should be an
 * interface.
 * <br/>
 * Methods that return objects will return objects that implement the specified
 * interface.
 * The class returned is determined by the
 * {@link com.butterfill.opb.OpbObjectSource} use by this data object source.
 * <br/>
 * Methods that remove or get objects that have been saved or cached should be
 * passed the interface that was used to initially obtain the object. e.g.
 * <pre>
 * // In real code, you would get a data object source from an OpbSession.
 * // e.g. OpbDataObjectSource dos = session.getDataObjectSource();
 * // For this example we can just create a new one.
 * OpbDataObjectSource dos =
 *         new OpbDataObjectSource(new OpbObjectSourceImpl());
 *
 * // get an object from the source
 * OpbMessages mOne = dos.getInstance(OpbMessages.class, "one");
 *
 * // At this point, mOne is saved by the data object source.
 *
 * // This will NOT remove any saved objects as the runtime type of mOne is
 * // not OpbMessages.class
 * dos.clearInstances(mOne.getClass());
 *
 * // output the runtime type of mOne
 * System.out.format("%s%n", mOne.getClass().getName());
 *
 * // This will output true as mOne is still saved
 * System.out.format("%s%n", mOne == dos.getInstance(OpbMessages.class, "one"));
 *
 * // Clear the saved objects of OpbMessages type
 * dos.clearInstances(OpbMessages.class);
 *
 * // At this point, no objects of type OpbMessages are saved.
 * // This will output false as mOne was removed
 * System.out.format("%s%n", mOne == dos.getInstance(OpbMessages.class, "one"));
 * </pre>
 * </p>
 *
 * @see OpbDataObjectCreatedListener
 *
 * @author Peter Butterfill
 */
public class OpbDataObjectSource {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbDataObjectSource.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The object source to be used by this class.
     * @see #rawInstance(Class)
     */
    private final OpbObjectSource objectSource;

    /**
     * This map contains one data object map for each type of (uniquely
     * identifiable) data object loaded.
     * The data object maps contain all data objects loaded (that have not been
     * cleared etc).
     * Data objects can be retrieved from the data object maps by their id's.
     */
    private Map<Class, Map> mapOfDataObjectMaps = new HashMap<Class, Map>();
    // dataObjectMap(Class) must be the only method to put into this map

    /**
     * This map contains one map of results for each type of data object
     * retrieved by the getResult(Class, ResultSet, OpbId) and
     * getResult(Class, ResultSet, OpbId, boolean) methods.
     * Results (lists of data objects) can be retrieved from the result maps
     * by the key specified in the
     * getResult(Class, ResultSet, OpbId [, boolean]) call.
     *
     * @see #getResult(Class, ResultSet, OpbId)
     */
    private Map<Class, Map> mapOfResultMaps = new HashMap<Class, Map>();
    // resultMap(Class<T>) must be the only method to put into this map

    /**
     * Holds all objects considered to be invalid.
     * i.e. objects that need to be re-loaded
     */
    private List<Object> listOfInvalidObjects = new OpbExactMatchList<Object>();


    /**
     * Creates a new instance of OpbDataObjectSource to use the specified
     * object source.
     *
     * @param objectSource
     *   The object source to be used by this data object source.
     */
    public OpbDataObjectSource(final OpbObjectSource objectSource) {
        final String methodName = "OpbDataObjectSource(OpbObjectSource)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "objectSource", objectSource);

        this.objectSource = objectSource;

    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbDataObjectSource.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }


    // <editor-fold defaultstate="collapsed" desc="get map section">

    /**
     * Returns the data object map for the specified type of object.
     * The first call to this method for a given class will return a newly
     * created map. Subsequent calls for the same class will return the same map
     * until clearCached() or clearCached(Class) are called.
     *
     * @param <T>
     *   The type of data object to be contained in the map returned.
     * @param c
     *   The type of data object to be contained in the map returned.
     * @return
     *   The data object map for the specified type of object.
     * @see #clearCached()
     * @see #clearCached(Class)
     */
    @SuppressWarnings("unchecked")
    private <T extends OpbCacheableEntity> Map<OpbId, T>
            dataObjectMap(final Class<T> c) {
        // This is the only method that puts elements into the map of data
        // object maps. So it's safe to suppress unchecked warnings
        if (!mapOfDataObjectMaps.containsKey(c)) {
            mapOfDataObjectMaps.put(c, new HashMap<OpbId, T>());
        }
        return mapOfDataObjectMaps.get(c);
    }

    /**
     * Returns the result map for the specified type of object.
     * The first call to this method for a given class will return a newly
     * created map. Subsequent calls for the same class will return the same map
     * until clearCached(), clearCached(Class), invalidateCached(),
     * invalidateCached(Class), invalidateCached(Class, OpbId),
     * clearCachedResults() or clearCachedResults(Class) are called.
     *
     * @param <T>
     *   The type of data object to be contained in the lists contained in the
     *   map returned.
     * @param c
     *   The type of data object to be contained in the lists contained in the
     *   map returned.
     * @return
     *   The result map for the specified type of object.
     *
     * @see #clearCached()
     * @see #clearCached(Class)
     * @see #invalidateCached()
     * @see #invalidateCached(Class)
     * @see #invalidateCached(Class, OpbId)
     * @see #clearCachedResults()
     * @see #clearCachedResults(Class)
     */
    @SuppressWarnings("unchecked")
    private <T extends OpbEntity> Map<OpbId, List<T>> resultMap(
            final Class<T> c) {
        // This is the only method that puts elements into the map of result
        // maps. So it's safe to suppress unchecked warnings
        if (!mapOfResultMaps.containsKey(c)) {
            mapOfResultMaps.put(c, new HashMap<OpbId, List<T>>());
        }
        return mapOfResultMaps.get(c);
    }

    // </editor-fold> End of get map Section


    // <editor-fold defaultstate="collapsed" desc="object life cycle section">

    /**
     * Objects that will be notified when data object life cycle events occur.
     */
    private Set<OpbDataObjectCreatedListener> dataObjectCreatedListeners =
            new HashSet<OpbDataObjectCreatedListener>();

    /**
     * Registers an objects interest in data object life cycle events.
     * This is a no-op if listener is null or listener is already registered.
     * <br/>
     * This data object source publishes the data object life cycle event;
     * <ul>
     * <li>data object created</li>
     * </ul>
     *
     * @param lsnr A data object listener.
     */
    public void addListener(final OpbDataObjectCreatedListener lsnr) {
        final String methodName = "addListener(OpbDataObjectCreatedListener)";

        logger.entering(CLASS_NAME, methodName);

        if (lsnr != null) {
            dataObjectCreatedListeners.add(lsnr);
        }

    }

    /**
     * Un-registers an objects interest in data object life cycle events.
     * If the specified listener is not currently registed, this is a no-op.
     *
     * @param lsnr A data object listener.
     */
    public void removeListener(final OpbDataObjectCreatedListener lsnr) {
        final String methodName =
                "removeListener(OpbDataObjectCreatedListener)";

        logger.entering(CLASS_NAME, methodName);

        dataObjectCreatedListeners.remove(lsnr);

    }

    /**
     * Notifies all listeners that an object has been created and lets data objects that are
     * config complete listeners know when their configuration is complete.
     *
     * @param requestedType
     *   The type of data object that has just been created.
     * @param dataObject
     *   The data object that has just been created.
     * @param cached
     *   true if the data object has been cached, false otherwise.
     */
    private void notifyListenersDataObjectCreated(final Class requestedType,
            final Object dataObject, final boolean cached) {
        final String methodName =
                "notifyListenersDataObjectCreated(Class, Object, boolean)";

        logger.entering(CLASS_NAME, methodName);

        for (OpbDataObjectCreatedListener lsnr : dataObjectCreatedListeners) {
            lsnr.dataObjectCreated(requestedType, dataObject, cached);
        }

        // let config complete listeners know when their configuration is complete
        if (dataObject instanceof OpbDataObjectConfigCompleteListener) {
            ((OpbDataObjectConfigCompleteListener) dataObject).dataObjectConfigComplete(
                    requestedType, dataObject, cached);

        }

    }

    // </editor-fold> End of object life cycle Section


    /**
     * Returns a newley created, partially configured data object instance for
     * use by the newInstance, getInstance and the getResult methods.
     * Note: This method does not notify data object lifecycle listeners.
     *
     * @param <T>
     *   The type of object to return.
     * @param c
     *   The requested type. The instance returned by this method will
     *   implement the requested type.
     * @return
     *   A newley created, partially configured data object.
     * @throws OpbException
     *   If we can't create a new instance of the specified type.
     */
    @SuppressWarnings("unchecked")
    private <T extends Object> T rawInstance(final Class<T> c)
            throws OpbException {
        final String methodName = "rawInstance(Class)";

        logger.entering(CLASS_NAME, methodName);

        // get a new instance from the object source
        T dataObject = objectSource.newInstance(c);

        // if it's an active object, set this as the data object source
        if (dataObject instanceof OpbActiveDataObject) {
            ((OpbActiveDataObject) dataObject).setOpbDataObjectSource(this);
        }

        return dataObject;

    } // End of rawInstance(Class)


    /**
     * Returns the types of data objects cached by previous <code>getResult</code> calls.
     * <br/>
     * The result of this method is not backed by this instance,
     * so changes to the result are not reflected in this instance, and vice-versa.
     *
     * @return
     *   The types of cached data objects.
     */
    public Collection<Class> getCachedTypes() {
        final String method = "getCachedTypes()";

        logger.entering(CLASS_NAME, method);

        return new HashSet<Class>(mapOfResultMaps.keySet());

    }


    // <editor-fold defaultstate="collapsed" desc="invalidate cached section">

    /**
     * Adds an object to the list of invalid objects if it's not null and
     * not already in this list.
     * This is a no-op if o is null or already in the list of invalid objects.
     * Used by the invalidateCached methods.
     *
     * @param o
     *   The object to add to the list of invalid objects.
     */
    private void addToListOfInvalidObjects(final Object o) {
        if (o != null &&
                !listOfInvalidObjects.contains(o)) {
            listOfInvalidObjects.add(o);
        }
    }

    /**
     * Invalidates all cached data objects and clears all lists cached by this
     * object source.
     * This does not affect saved instances.
     */
    public void invalidateCached() {
        logger.entering(CLASS_NAME, "invalidateCached()");

        for (Map dataObjectMap : mapOfDataObjectMaps.values()) {
            for (Object object : dataObjectMap.values()) {
                addToListOfInvalidObjects(object);
            }
        }

        mapOfResultMaps.clear();

    } // End of invalidateCached()

    /**
     * Invalidates all cached data objects of the specified type and clears all
     * lists of the specified type.
     * This does not affect saved instances.
     *
     * @param <T>
     *   The type of object to invalidate.
     * @param classOfObject
     *   Class of the object to invalidate.
     */
    public <T extends OpbCacheableEntity> void
            invalidateCached(final Class<T> classOfObject) {
        final String methodName = "invalidateCached(Class)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        for (T dataObject : dataObjectMap(classOfObject).values()) {
            addToListOfInvalidObjects(dataObject);
        }

        mapOfResultMaps.remove(classOfObject);

    }

    /**
     * Clears all lists of the specified type and invalidates the data object
     * (identified by it's class and id).
     * This does not affect saved instances.
     *
     * @param <T>
     *   The type of object to invalidate.
     * @param classOfObject
     *   Class of the object to invalidate.
     * @param id
     *   ID of object to invalidate.
     */
    public <T extends OpbCacheableEntity> void invalidateCached(
            final Class<T> classOfObject, final OpbId id) {
        final String methodName = "invalidateCached(Class, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "id={0}", id);

        mapOfResultMaps.remove(classOfObject);

        addToListOfInvalidObjects(dataObjectMap(classOfObject).get(id));

    }

    // </editor-fold> End of invalidate cahced Section


    // <editor-fold defaultstate="collapsed" desc="clear cached section">

    /**
     * Removes all cached data objects from all caches used by this object
     * source.
     * This does not affect saved instances.
     */
    public void clearCached() {
        logger.entering(CLASS_NAME, "clearCached()");

        mapOfDataObjectMaps.clear();
        mapOfResultMaps.clear();
        listOfInvalidObjects.clear();

    }

    /**
     * Remove all cached data object's of the specified type from all caches
     * used by this object source.
     * <br/>
     * This does not affect saved instances.
     *
     * @param <T>
     *   The type of object to clear.
     * @param classOfObject
     *   Class of the object to remove from cache.
     */
    public <T extends OpbEntity> void clearCached(
            final Class<T> classOfObject) {
        final String methodName = "clearCached(Class)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        // remove the map for cached data objects of the specified class
        final Map dataObjectMap = mapOfDataObjectMaps.remove(classOfObject);
        // remove the map for cached results of the specified class
        mapOfResultMaps.remove(classOfObject);

        // we kept the map for cached data objects of the specified class so we can
        // now see if any of the objects removed from cache are in the list of invalid
        // objects (if they are, we remove them now).
        if (dataObjectMap != null) {
            for (Object dataObject : dataObjectMap.values()) {
                listOfInvalidObjects.remove(dataObject);
            }
        }

    }

    /**
     * Removes the data object (identified by it's class and ID) from all
     * caches used by this object source.
     * Note: This method clears all results that contain objects of the
     * specified type.
     * This does not affect saved instances.
     *
     * @param <T>
     *   The type of object to clear.
     * @param classOfObject
     *   Class of the object to remove from cache.
     * @param id
     *   ID of object to remove from cache.
     */
    public <T extends OpbCacheableEntity> void clearCached(
            final Class<T> classOfObject, final OpbId id) {
        final String methodName = "clearCached(Class, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "id={0}", id);

        // remove all cached lists that might contain the object
        resultMap(classOfObject).clear();

        // Remove the object from it's cache.
        // Note: dataObject will be null if the specified object was not cached
        T dataObject = dataObjectMap(classOfObject).remove(id);

        // remove the object from the invalid list.
        listOfInvalidObjects.remove(dataObject);

    } // End of clearCached(Class, OpbId)

    // </editor-fold> End of clear cached Section


    //<editor-fold defaultstate="collapsed" desc="clear cached results section">

    /**
     * Clears the specified result from all caches used by this object source.
     *
     * @see #getResult(Class, ResultSet, OpbId)
     *
     * @param <T>
     *   The type of object who's results should be cleared.
     * @param classOfObject
     *   Results containing this type of object should be cleared (if they have
     *   the specified key).
     * @param key
     *   The key to the result to clear.
     */
    public <T extends OpbEntity> void clearCachedResult(
            final Class<T> classOfObject, final OpbId key) {
        final String methodName = "clearCachedResult(Class, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINER, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINER, CLASS_NAME, methodName, "key={0}", key);

        resultMap(classOfObject).remove(key);
    }

    /**
     * Remove all results from all caches used by this object source.
     * Note: This does not remove any data objects from any caches.
     */
    public void clearCachedResults() {
        logger.entering(CLASS_NAME, "clearCachedResults()");

        mapOfResultMaps.clear();
    }

    /**
     * Remove all results for object's of the specified type from all
     * caches used by this object source.
     * Note: This does not remove any data objects from any caches.
     *
     * @param <T>
     *   The type of object who's results should be cleared.
     * @param classOfObject
     *   Class of data object.
     */
    public <T extends OpbEntity> void clearCachedResults(
            final Class<T> classOfObject) {
        final String methodName = "clearCachedResults(Class<T>)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        mapOfResultMaps.remove(classOfObject);
    }

    // </editor-fold> End of clear cached results Section


    // <editor-fold defaultstate="collapsed" desc="get cached section">

    /**
     * Returns true if the specified object is cached, false otherwise.
     *
     * @param <T>
     *   The type of cached object.
     * @param classOfObject
     *   Class of the data object.
     * @param id
     *   ID of the object.
     * @return
     *   true if the specified object is cached
     */
    public <T extends OpbCacheableEntity> boolean isCached(
            final Class<T> classOfObject, final OpbId id) {
        final String methodName = "isCached(Class, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "id={0}", id);

        return dataObjectMap(classOfObject).containsKey(id);
    }

    /**
     * Returns the specified object or null if the object is not cached.
     *
     * @param <T>
     *   The type of cached object.
     * @param classOfObject
     *   Class of the data object.
     * @param id
     *   ID of the object.
     * @return
     *   A cached object or null.
     */
    public <T extends OpbCacheableEntity> T getCached(
            final Class<T> classOfObject, final OpbId id) {
        final String methodName = "getCached(Class, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "id={0}", id);

        return dataObjectMap(classOfObject).get(id);

    }

    /**
     * Returns a list containing all cached objects of the specified type.
     *
     * @param <T>
     *   The type of cached object.
     * @param classOfObject
     *   Class of the data object.
     * @return
     *   A list of data objects.
     */
    public <T extends OpbCacheableEntity> List<T> getCached(
            final Class<T> classOfObject) {
        final String methodName = "getCachedResult(Class)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        return new ArrayList<T>(
                dataObjectMap(classOfObject).values());

    }

    /**
     * Returns a result created by a previous call to
     * getResult(Class, ResultSet, OpbId [, boolean]) or null if the specified
     * result is not cached.
     * The result will not be cached if no call to getResult has been made or
     * the result has been cleared.
     *
     * @see #getResult(Class, ResultSet, OpbId)
     * @see #getResult(Class, ResultSet, OpbId, boolean)
     * @see #clearCachedResult(Class, OpbId)
     *
     * @param <T>
     *   The type of object in the result.
     * @param classOfObject
     *   Class of the data object.
     * @param key
     *   Key to the cached result.
     * @return
     *   A cached result or null if the result is not cached.
     */
    public <T extends OpbEntity> List<T> getCachedResult(
            final Class<T> classOfObject, final OpbId key) {
        final String methodName = "getCachedResult(Class, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "key={0}", key);

        return resultMap(classOfObject).get(key);
    }

    // </editor-fold> End of get cached Section


    // <editor-fold defaultstate="collapsed" desc="get result section">

    /**
     * Returns a list containing one element (of type classOfObject) for every
     * row in resultSet.
     * <br>
     * This method;
     * <ul>
     *  <li>Provides notification of the data object created event,</li>
     *  <li>Will not use the result cache,</li>
     *  <li>Will not cache the result,</li>
     *  <li>Will not use the data object cache,</li>
     *  <li>Will not cache the objects in the result and</li>
     *  <li>Closes resultSet.</li>
     * </ul>
     *
     * @param <T>
     *   The type of object that the result should contain.
     * @param classOfObject
     *   The type of object that the result should contain.
     * @param resultSet
     *   An open result set, the rows of which can be used to load objects of
     *   the specified type.
     * @throws OpbDataAccessException
     *   If we fail to create the result.
     * @throws NullPointerException
     *   If classOfObject or resultSet are null.
     * @return
     *   A result built from the specified result set.
     */
    public <T extends OpbEntity> List<T> getResult(
            final Class<T> classOfObject, final ResultSet resultSet)
            throws OpbDataAccessException, NullPointerException {
        final String methodName = "getResult(Class, ResultSet)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "resultSet", resultSet);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        try {
            List<T> result = new ArrayList<T>();
            T dataObject = null;

            while (resultSet.next()) {
                dataObject = rawInstance(classOfObject);
                dataObject.opbLoad(resultSet);
                notifyListenersDataObjectCreated(
                        classOfObject, dataObject, false);
                result.add(dataObject);

            }

            return result;

        } catch (Exception ex) {
            throw OpbExceptionHelper.throwException(
                    new OpbDataAccessException("Failed to get result", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, resultSet);

        }

    }

    /**
     * Returns a list containing one element (of type classOfObject) for every
     * row in resultSet.
     * <br>
     * This method;
     * <ul>
     * <li>Provides notification of the data object created event,</li>
     * <li>Will not use the result cache,</li>
     * <li>Will not cache the result,</li>
     * <li>May use the data object cache (see useDataObjectCache),</li>
     * <li>May cache the objects in the result (see useDataObjectCache) and</li>
     * <li>Closes resultSet.</li>
     * </ul>
     *
     * @param <T>
     *   The type of object that the result should contain.
     * @param classOfObject
     *   The type of object that the result should contain.
     * @param resultSet
     *   An open result set, the rows of which can be used to load objects of
     *   the specified type.
     * @param useDataObjectCache
     *   Pass true to use the data object cache, false otherwise.
     * @throws OpbDataAccessException
     *   If we fail to create the result.
     * @throws NullPointerException
     *   If classOfObject or resultSet are null.
     * @return
     *   A result built from the specified result set.
     */
    public <T extends OpbCacheableEntity> List<T> getResult(
            final Class<T> classOfObject, final ResultSet resultSet,
            final boolean useDataObjectCache) throws OpbDataAccessException,
            NullPointerException {
        final String methodName = "getResult(Class, ResultSet, boolean)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "resultSet", resultSet);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "useDataObjectCache={0}", useDataObjectCache);

        OpbAssert.notNull(
                logger, CLASS_NAME, "getResult(Class<T>, ResultSet, boolean)",
                "resultSet", resultSet);

        try {
            List<T> result = new ArrayList<T>();
            T dataObject = rawInstance(classOfObject);
            T cachedDataObject = null;
            Map<OpbId, T> dataObjectMap = dataObjectMap(classOfObject);

            while (resultSet.next()) {
                dataObject.opbLoad(resultSet);
                if (useDataObjectCache) {
                    if (dataObjectMap.containsKey(dataObject.getOpbId())) {
                        // if we're using the data object cache and the object
                        // we need is cached, get it from the cache
                        cachedDataObject =
                                dataObjectMap.get(dataObject.getOpbId());

                        if (listOfInvalidObjects.remove(cachedDataObject)) {
                            // if the object was on the invalid list, re-load it
                            cachedDataObject.opbLoad(resultSet);

                        }

                        // add the cached object to the result
                        result.add(cachedDataObject);

                    } else {
                        // if we're using the data object cache and the object
                        // we need is not cached, cache it now
                        dataObjectMap.put(dataObject.getOpbId(), dataObject);
                        // tell observers that a new object has been created
                        notifyListenersDataObjectCreated(
                                classOfObject, dataObject, true);
                        // add it to the result (list of data objects)
                        result.add(dataObject);
                        // create a new instance for the next row in resultSet
                        dataObject = rawInstance(classOfObject);

                    }

                } else {
                    // if we're not using the data object cache, we need to
                    // notify observers that a new data object has been created
                    notifyListenersDataObjectCreated(
                            classOfObject, dataObject, false);
                    // add it to the result (list of data objects)
                    result.add(dataObject);
                    // and create a new instance for the next row in resultSet
                    dataObject = rawInstance(classOfObject);

                }

            } // End of while (resultSet.next())

            return result;

        } catch (Exception ex) {
            throw OpbExceptionHelper.throwException(
                    new OpbDataAccessException("Failed to get result", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, resultSet);

        }

    } // End of getResult(Class, ResultSet, boolean)

    /**
     * Returns a list containing one element (of type classOfObject) for every
     * row in resultSet.
     * <br>
     * This method;
     * <ul>
     *  <li>Provides notification of the data object created event,</li>
     *  <li>Does use the result cache,</li>
     *  <li>
     *    Does cache the result (possibly replacing a previously cached result),
     *  </li>
     *  <li>Will not use the data object cache,</li>
     *  <li>Will not cache the objects in the result and</li>
     *  <li>Closes resultSet.</li>
     * </ul>
     *
     * @param <T>
     *   The type of object that the result should contain.
     * @param classOfObject
     *   The type of object that the result should contain.
     * @param resultSet
     *   An open result set, the rows of which can be used to load objects of
     *   the specified type.
     * @param key
     *   A key to identify question being asked that produced resultSet.
     *
     * @see #clearCachedResult(Class, OpbId)
     *
     * @throws OpbDataAccessException
     *   If we fail to create the result.
     * @throws NullPointerException
     *   If classOfObject or resultSet are null.
     * @return
     *   A result built from the specified result set.
     */
    public <T extends OpbEntity> List<T> getResult(
            final Class<T> classOfObject, final ResultSet resultSet,
            final OpbId key)
            throws OpbDataAccessException, NullPointerException {
        final String methodName = "getResult(Class, ResultSet, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "resultSet", resultSet);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "key={0}", key);

        List<T> result = getResult(classOfObject, resultSet);

        resultMap(classOfObject).put(key, result);

        return result;

    }

    /**
     * Returns a list containing one element (of type classOfObject) for every
     * row in resultSet.
     * <br>
     * This method;
     * <ul>
     * <li>Provides notification of the data object created event,</li>
     * <li>Does use the result cache,</li>
     * <li>
     *   Does cache the result (possibly replacing a previously cached result),
     * </li>
     * <li>May use the data object cache (see useDataObjectCache),</li>
     * <li>May cache the objects in the result (see useDataObjectCache) and</li>
     * <li>Closes resultSet.</li>
     * </ul>
     *
     * @param <T>
     *   The type of object that the result should contain.
     * @param classOfObject
     *   The type of object that the result should contain.
     * @param resultSet
     *   An open result set, the rows of which can be used to load objects of
     *   the specified type.
     * @param key
     *   A key to identify question being asked that produced resultSet.
     *  @param useDataObjectCache
     *   Pass true to use the data object cache, false otherwise.
     *
     * @see #clearCachedResult(Class, OpbId)
     *
     * @throws OpbDataAccessException
     *   If we fail to create the result.
     * @throws NullPointerException
     *   If classOfObject or resultSet are null.
     * @return
     *   A result built from the specified result set.
     */
    public <T extends OpbCacheableEntity> List<T> getResult(
            final Class<T> classOfObject, final ResultSet resultSet,
            final OpbId key, final boolean useDataObjectCache)
            throws OpbDataAccessException, NullPointerException {
        final String methodName = "getResult(Class, ResultSet, OpbId, boolean)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "resultSet", resultSet);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "key={0}", key);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "useDataObjectCache={0}", useDataObjectCache);

        List<T> result =
                getResult(classOfObject, resultSet, useDataObjectCache);

        resultMap(classOfObject).put(key, result);

        return result;

    }

    // </editor-fold> End of get result Section


    // <editor-fold defaultstate="collapsed" desc="get new section">

    /**
     * This map contains one map of data objects for each type of data
     * object retrieved by the getInstance(Class, String) method.
     * Data objects can be retrieved from the data object maps
     * by the key specified in the getInstance(Class, String) call.
     *
     * @see #getInstance(Class, String)
     */
    private Map<Class, Map> mapOfNewDataObjectMaps = new HashMap<Class, Map>();
    // newDataObjectMap(Class<T>) must be the only method to put into this map

    /**
     * Returns the new data object map for the specified type of object.
     * The first call to this method for a given class will return a newly
     * created map. Subsequent calls for the same class will return the same map
     * until clearInstances() or clearInstances(Class) are called.
     *
     * @param <T>
     *   The type of object that the map should contain.
     * @param c
     *   The type of object that the map should contain.
     * @return
     *   The new data object map for the specified type of object.
     */
    @SuppressWarnings("unchecked")
    private <T extends Object> Map<String, T> newDataObjectMap(
            final Class<T> c) {
        // This is the only method that puts elements into the map of new data
        // object maps. So it's safe to suppress unchecked warnings
        if (!mapOfNewDataObjectMaps.containsKey(c)) {
            mapOfNewDataObjectMaps.put(c, new HashMap<String, T>());
        }
        return mapOfNewDataObjectMaps.get(c);
    }

    /**
     * Returns a new instance of the specified type (Not loaded from the
     * data source).
     * If the object is an active data object, it will be configured with this
     * as it's data object source.
     * Data object lifecyle listeners will get a 'new data object created'
     * notification indicating that this data object has not been cached.
     *
     * @param <T>
     *   The type of data object to return.
     * @param classOfObject
     *   The type of data object to return.
     * @return
     *   A new data object.
     * @throws OpbException
     *   If we can't instantiate an instance of the specified class or we don't
     *   have access to instantiate an instance of the specified class.
     */
    public <T extends Object> T newInstance(final Class<T> classOfObject)
            throws OpbException {
        final String methodName = "newInstance(Class)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());

        T dataObject = rawInstance(classOfObject);

        notifyListenersDataObjectCreated(classOfObject, dataObject, false);

        return dataObject;

    }

    /**
     * Returns a new instance of the specified type (Not loaded from the
     * data source).
     * Multiple calls to this method with the same parameters will return the
     * same object until the saved data object is cleared.
     * If the object is an active data object, it will be configured with this
     * as it's data object source when it is created.
     * Data object lifecyle listeners will get a 'new data object created'
     * notification, indicating that this data object has not been cached, when
     * the instance is created.
     *
     * @param <T>
     *   The type of data object to return.
     * @param classOfObject
     *   The type of data object to return.
     * @param key
     *   The key to returning the same object for multiple calls of this method.
     * @return
     *   A new data object.
     * @throws OpbException
     *   If we can't instantiate an instance of the specified class or we don't
     *   have access to instantiate an instance of the specified class.
     * @see #clearInstances()
     * @see #clearInstances(Class)
     * @see #clearInstance(Class, String)
     */
    public <T extends Object> T getInstance(final Class<T> classOfObject,
            final String key) throws OpbException {
        final String methodName = "getInstance(Class, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "key={0}", key);

        Map<String, T> map = newDataObjectMap(classOfObject);
        if (!map.containsKey(key)) {
            // Note: newInstance handles object configuration
            map.put(key, newInstance(classOfObject));
        }
        return map.get(key);
    }

    /**
     * Removes all data objects saved by previous calls to
     * getInstance(Class, String).
     * If no data objects have been saved by a
     * previous call to getInstance(Class, String), this is a no-op.
     *
     * @see #getInstance(Class, String)
     */
    public void clearInstances() {
        logger.entering(CLASS_NAME, "clearInstances()");

        mapOfNewDataObjectMaps.clear();
    }

    /**
     * Removes all data objects of the specified type saved by previous calls to
     * getInstance(Class, String).
     * If no data objects of the specified type have been saved by a
     * previous call to getInstance(Class, String), this is a no-op.
     *
     * @param <T>
     *   The type of data object to clear.
     * @param classOfObject
     *   The type of data object to clear.
     * @see #getInstance(Class, String)
     */
    public <T extends Object> void clearInstances(
            final Class<T> classOfObject) {
        final String methodName = "clearInstances(Class)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "classOfObject={0}", classOfObject.getName());

        mapOfNewDataObjectMaps.remove(classOfObject);
    }

    /**
     * Removes the data object (identified by class and key) saved by previous
     * calls to getInstance(Class, String).
     * If no data object with the specified type and key has been saved by a
     * previous call to getInstance(Class, String), this is a no-op.
     *
     * @param <T>
     *   The type of data object to clear.
     * @param classOfObject
     *   The type of data object to clear.
     * @param key
     *   Key of the data object to clear.
     * @see #getInstance(Class, String)
     */
    public <T extends Object> void clearInstance(
            final Class<T> classOfObject, final String key) {
        final String methodName = "clearInstance(Class, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "classOfObject={0}", classOfObject.getName());
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "key={0}", key);

        newDataObjectMap(classOfObject).remove(key);
    }

    // </editor-fold> End of get new Section


} // End of class OpbDataObjectSource
