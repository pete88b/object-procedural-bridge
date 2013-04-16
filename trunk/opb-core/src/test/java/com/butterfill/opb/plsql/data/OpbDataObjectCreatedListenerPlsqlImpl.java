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

package com.butterfill.opb.plsql.data;

import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataObjectCreatedListener;
import com.butterfill.opb.data.OpbDataObjectCreatedListener;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbScalarResultCacheUser;
import java.util.logging.Logger;

/**
 * TODO: xxx
 * <br/>
 * This class is not thread safe.
 *
 * @author Peter Butterfill
 */
public class OpbDataObjectCreatedListenerPlsqlImpl implements OpbDataObjectCreatedListener {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbDataObjectCreatedListenerPlsqlImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    private final OpbConnectionProvider connectionProvider;

    private final OpbScalarResultCache scalarResultCache;

    /**
     * Creates a new instance of an OpbConnectionProviderPlsqlImpl.
     *
     * @param connectionProvider
     * @param scalarResultCache
     * @throws NullPointerException
     *   If any arguments are null.
     */
    public OpbDataObjectCreatedListenerPlsqlImpl(
            final OpbConnectionProvider connectionProvider, OpbScalarResultCache scalarResultCache)
            throws NullPointerException {
        final String methodName = "OpbDataObjectCreatedListenerPlsqlImpl";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "connectionProvider", connectionProvider);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "scalarResultCache", scalarResultCache);

        this.connectionProvider = connectionProvider;

        this.scalarResultCache = scalarResultCache;

    } // End of OpbConnectionProviderPlsqlImpl

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this instance.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Called when a data object is created by the data object source of this
     * session.
     * This method sets the following resources for the given data object;
     * <ul>
     * <li>OpbActiveDataObject#setOpbConnectionSource</li>
     * <li>OpbScalarResultCacheUser#setOpbScalarResultCacheProvider</li>
     * </ul>
     *
     * If dataObject is an OpbActiveDataObject, set this as the connection
     * source.
     * <br/>
     * If dataObject is a OpbScalarResultCacheUser, set this as the scalar result
     * cache provider.
     *
     * @param requestedType
     *   The type of data object requested.
     * @param dataObject
     *   A data object.
     * @param cached
     *   Pass true to indicate dataObject has been cached, false otherwise.
     * @throws NullPointerException
     *   If requestedType or dataObject are null.
     */
    public void dataObjectCreated(final Class requestedType,
            final Object dataObject, final boolean cached)
            throws NullPointerException {
        final String methodName = "dataObjectCreated(Class, Object, boolean)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "requestedType", requestedType);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "dataObject", dataObject);

        // If the data object created is an active data object, set it's connection provider.
        // Note: The OpbDataObjectSource that created dataObject will have set it's data
        // object source
        if (dataObject instanceof OpbActiveDataObject) {
            ((OpbActiveDataObject) dataObject).
                    setOpbConnectionProvider(connectionProvider);
        }

        // If the data object is a scalar result cache user, set it's cache provider.
        if (dataObject instanceof OpbScalarResultCacheUser) {
            ((OpbScalarResultCacheUser) dataObject).
                    setOpbScalarResultCache(scalarResultCache);
        }

    } // End of dataObjectCreated(Class, Object, boolean)


} // End of class OpbConnectionProviderPlsqlImpl
