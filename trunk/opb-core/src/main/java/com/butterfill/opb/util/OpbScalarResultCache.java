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

package com.butterfill.opb.util;

import com.butterfill.opb.OpbId;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Provides basic caching functionality for objects that can be identified
 * using an OpbId.
 * <br/><br/>
 * One expected use of this class is to cache scalar results returned by
 * database functions.
 *
 * @author Peter Butterfill
 */
public class OpbScalarResultCache {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbScalarResultCache.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Holds cached results.
     */
    private Map<OpbId, Object> resultMap = new HashMap<OpbId, Object>();

    /**
     * Creates a new instance of OpbScalarResultCache.
     */
    public OpbScalarResultCache() {
        logger.entering(CLASS_NAME, "OpbScalarResultCache()");
    }

    /**
     * Returns a String representation of this OpbScalarResultCache and it's
     * values.
     * @return A string representation of this instance.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns true if a result is cached with the specified key, false
     * otherwise.
     * @param key The key to the cached result.
     * @return true if a result is cached.
     */
    public boolean isCached(final OpbId key) {
        return resultMap.containsKey(key);
    }

    /**
     * Returns the object that was cached using key.
     * If no result has been cached with the specified key,
     * null will be returned.
     *
     * @see #isCached(OpbId)
     *
     * @param <T>
     *   The type of the cached object.
     * @param classOfObject
     *   The type of object to return.
     * @param key
     *   The key to the result to return.
     * @return
     *   An object that was cached using key.
     * @throws ClassCastException
     *   If the object to return cannot be cast to the specified type.
     */
    @SuppressWarnings("unchecked")
    public <T extends Object> T getCached(final Class<T> classOfObject,
            final OpbId key)
    throws ClassCastException {
        final String methodName = "getCached(Class<T>, OpbId)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        try {
            return classOfObject.cast(resultMap.get(key));

        } catch (ClassCastException ex) {
            throw OpbExceptionHelper.throwException(
                    new ClassCastException(
                    "Failed to get cached result. required="
                    + classOfObject.getName() + ". found="
                    + resultMap.get(key).getClass().getName()),
                    logger, CLASS_NAME, methodName);

        }

    }

    /**
     * Caches the specified object for later retrieval using key.
     * @param key
     *   The key to the result.
     * @param value
     *   The result to cache.
     */
    public void cache(final OpbId key, final Object value) {
        resultMap.put(key, value);
    }

    /**
     * Clears all cached results.
     */
    public void clearCached() {
        resultMap.clear();
    }

    /**
     * Clears the result cached with key.
     * @param key
     *   The key to the result.
     * @return
     *   The object that was cached using key, or null if no object was
     *   cached using key.
     */
    public Object clearCached(final OpbId key) {
        return resultMap.remove(key);
    }

} // End of class OpbScalarResultCache
