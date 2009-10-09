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

package com.butterfill.opb.session;

import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbCacheableEntity;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.groups.OpbGroupMemberWrapper;
import com.butterfill.opb.groups.OpbGroupable;
import com.butterfill.opb.timing.OpbEventTimerProvider;
import com.butterfill.opb.timing.OpbTimingEventPublisher;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbScalarResultCacheProvider;
import com.butterfill.opb.util.OpbScalarResultCacheUser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It is expected that the methods provided by this will be used by implementations of OpbSession.
 *
 * @author Butterp
 */
public final class OpbSessionUtils {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbSessionUtils.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /** 
     * Private constructor as there is no point creating an instance of this class.
     */
    private OpbSessionUtils() {
    }

    /**
     * Called when a data object is created by the data object source of this
     * session.
     * This method sets the following resources for the given data object;
     * <ul>
     * <li>OpbActiveDataObject#setOpbConnectionSource</li>
     * <li>OpbTimingEventPublisher#setOpbEventTimer</li>
     * <li>OpbGroupable#setGroupManagerMap</li>
     * </ul>
     *
     * If dataObject is an OpbActiveDataObject, set this as the connection
     * source.
     * <br/>
     * If dataObject is a OpbTimingEventPublisher, set it's event timer to be
     * the event timer of the context of this session.
     * <br/>
     * If dataObject is OpbGroupable, set it's group manager map to be a new
     * group manager map created by the group manager of this session.
     * Note: If dataObject is a OpbCacheableEntity and cached is true,
     * dataObject is wrapped in a OpbGroupMemberWrapper which returns the object
     * from cache (rather that returning dataObject directly).
     *
     * @param requestedType
     *   The type of data object requested.
     * @param dataObject
     *   A data object.
     * @param cached
     *   Pass true to indicate dataObject has been cached, false otherwise.
     * @param dataObjectSource
     *   If dataObject is OpbGroupable, an OpbCacheableEntity and has been cached -
     *   the group manager map will access dataObject via a OpbGroupMemberWrapper.
     *   The wrapper will return the cached instance of dataObject from dataObjectSource.
     * @param groupManager
     *   Used to create a group manager map for dataObject if dataObject is OpbGroupable.
     * @param connectionProvider
     *   If dataObject is an OpbActiveDataObject, it will be given this connection provider.
     * @param eventTimerProvider
     *   If dataObject is an OpbTimingEventPublisher, it will be given this event timer provider.
     * @param scalarResultCacheProvider
     *   If dataObject is an OpbScalarResultCacheUser, it will be given this scalar result cache
     *   provider.
     * @throws NullPointerException
     *   If requestedType, dataObject, dataObjectSource or groupManager are null.
     */
    @SuppressWarnings("unchecked")
    public static void dataObjectCreated(final Class requestedType,
            final Object dataObject,
            final boolean cached,
            final OpbDataObjectSource dataObjectSource,
            final OpbGroupManager groupManager,
            final OpbConnectionProvider connectionProvider,
            final OpbEventTimerProvider eventTimerProvider,
            final OpbScalarResultCacheProvider scalarResultCacheProvider)
            throws NullPointerException {
        final String methodName = "dataObjectCreated(Class, Object, boolean)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "requestedType", requestedType);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "dataObject", dataObject);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "dataObjectSource", dataObjectSource);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "groupManager", groupManager);

        // If the data object created is an active data object, set it's
        // connection provider.
        if (dataObject instanceof OpbActiveDataObject) {
            ((OpbActiveDataObject) dataObject).
                    setOpbConnectionProvider(connectionProvider);
        }

        // If the data object created is a timing event publisher, set it's
        // event timer provider.
        if (dataObject instanceof OpbTimingEventPublisher) {
            ((OpbTimingEventPublisher) dataObject).
                    setOpbEventTimerProvider(eventTimerProvider);
        }

        // If the data object is a scalar result cache user, set it's cache
        // provider.
        if (dataObject instanceof OpbScalarResultCacheUser) {
            ((OpbScalarResultCacheUser) dataObject).
                    setOpbScalarResultCacheProvider(scalarResultCacheProvider);
        }

        // If the data object is groupable, we need to set it's group manager
        // map. There are two ways to do this;
        if (dataObject instanceof OpbGroupable) {
            OpbGroupable groupable = (OpbGroupable) dataObject;

            if (cached &&
                    dataObject instanceof OpbCacheableEntity) {
                // If the data object has been cached, we can wrap access
                // to the data object in a group member wrapper.
                // This allows the data object to be removed from the group when
                // it is no longer cached.
                final OpbCacheableEntity cacheable = (OpbCacheableEntity) dataObject;

                // Note: This cast is unchecked but it is safe to suppress the
                // unchecked warning - If the data object is cacheable, the
                // requested type must be cacheable.
                final Class<OpbCacheableEntity> type = (Class<OpbCacheableEntity>) requestedType;

                final OpbGroupMemberWrapper wrapper = new OpbGroupMemberWrapper() {
                    public Object getValue() {
                        return dataObjectSource.getCached(
                                type, cacheable.getOpbId());
                    }
                    public void setValue(final Object value) {
                    }
                };

                groupable.setGroupManagerMap(
                        groupManager.newGroupManagerMap(wrapper));

            } else {
                if (cached) {
                    logger.logp(Level.WARNING, CLASS_NAME, methodName,
                            "cached=true {0}{1} data object type={2}",
                            new Object[]{
                            "but dataObject is not cacheable. requested type=",
                            requestedType.getName(),
                            dataObject.getClass().getName()});

                    logger.logp(Level.INFO, CLASS_NAME, methodName,
                            "dataObject={0}", dataObject);
                }

                // If the data object is not a cacheable entity, we don't wrap
                // access to it.
                groupable.setGroupManagerMap(
                        groupManager.newGroupManagerMap(groupable));

            } // End of if (dataObject instanceof OpbCacheableEntity)

        } // End of if (dataObject instanceof OpbGroupable)

    } // End of dataObjectCreated(...

    /**
     * Checks current memory use and clears data object caches if the limits specified allow.
     * 
     * @param memoryLimitForCachedObjects
     *   If used memory as a fraction of the JVM's max memory is greater than
     *   memoryLimitForCachedObjects, clearCached() is called on the data object source.
     * @param memoryLimitForCachedResults
     *   If used memory as a fraction of the JVM's max memory is greater than
     *   memoryLimitForCachedResults, clearCachedResults() is called on the data object source.
     * @param dataObjectSource
     *   The data object source who's caches may be cleared.
     *
     * @see OpbDataObjectSource#clearCached()
     * @see OpbDataObjectSource#clearCachedResults()
     */
    public static void checkMemoryUse(final Float memoryLimitForCachedObjects,
            final Float memoryLimitForCachedResults,
            final OpbDataObjectSource dataObjectSource) {
        final String methodName = "checkMemoryLimits()";

        logger.entering(CLASS_NAME, methodName);

        if (memoryLimitForCachedObjects == null &&
                memoryLimitForCachedResults == null) {
            logger.logp(Level.FINE, CLASS_NAME, methodName,
                    "both memory limit properties are null. returning");
            return;
        }

        Runtime runtime = Runtime.getRuntime();
        // Note: We need to put these values into floats so that the
        // division will return a float. totalMemory(), freeMemory() and
        // maxMemory() all return longs

        // how much memory is being used now
        float usedMemory = runtime.totalMemory() - runtime.freeMemory();
        // what JVM limit has been set for memory use
        float maxMemory = runtime.maxMemory();
        // calculate the used memory as a fraction of the max memory
        float usedMemoryAsFraction = usedMemory / maxMemory;

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "usedMemory={0}", usedMemory);
        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "maxMemory={0}", maxMemory);
        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "usedMemoryAsFraction={0}", usedMemoryAsFraction);
        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "LimitForCachedObjects={0}", memoryLimitForCachedObjects);
        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "LimitForCachedResults={0}", memoryLimitForCachedResults);

        if (memoryLimitForCachedObjects != null &&
                usedMemoryAsFraction > memoryLimitForCachedObjects) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "memory limit for cached objects exceeded. clearing cached objects");
            dataObjectSource.clearCached();

        } else if (memoryLimitForCachedResults != null &&
                usedMemoryAsFraction > memoryLimitForCachedResults) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "memory limit for cached results exceeded. clearing cached results");
            dataObjectSource.clearCachedResults();

        }

    } // End of checkMemoryUse()

} // End of class OpbSessionUtils
