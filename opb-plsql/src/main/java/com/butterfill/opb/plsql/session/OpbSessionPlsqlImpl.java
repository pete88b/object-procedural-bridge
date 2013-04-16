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

package com.butterfill.opb.plsql.session;

import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.plsql.data.OpbConnectionProviderPlsqlImpl;
import com.butterfill.opb.data.OpbDataObjectCreatedListenerImpl;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 * The default implementation of an OpbSession for use with Oracle PL/SQL.
 *
 * @see OpbSessionPlsqlImpl
 * @author Peter Butterfill
 */
public class OpbSessionPlsqlImpl implements OpbSession {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbSessionPlsqlImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The connection provider being used by this session.
     */
    private final OpbConnectionProvider connectionProvider;

    /**
     * The data object source being used by this session.
     */
    private final OpbDataObjectSource dataObjectSource;

    /**
     * The scalar result cache being used by this session.
     */
    private final OpbScalarResultCache scalarResultCache;


    /**
     * Creates a new instance of an OpbSessionPlsqlImpl.
     *
     * @param dataSource
     *   The data source that this session should use.
     * @param dataObjectSource
     *   The data object source that this session should use.
     * @param scalarResultCache
     *   The scalar result cache that this session should use.
     * @throws NullPointerException
     *   If any arguments are null.
     */
    public OpbSessionPlsqlImpl(final OracleDataSource dataSource,
            final OpbDataObjectSource dataObjectSource,
            final OpbScalarResultCache scalarResultCache)
            throws NullPointerException {
        final String methodName = "OpbSessionPlsqlImpl(OracleDataSource, ...)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "dataSource", dataSource);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "dataObjectSource", dataObjectSource);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "scalarResultCache", scalarResultCache);

        this.connectionProvider = new OpbConnectionProviderPlsqlImpl(dataSource);

        this.dataObjectSource = dataObjectSource;

        this.scalarResultCache = scalarResultCache;

        this.dataObjectSource.addListener(
                new OpbDataObjectCreatedListenerImpl(connectionProvider, scalarResultCache));

    } // End of OpbSessionPlsqlImpl

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbSession.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the connection provider that this session is using.
     * @return The connection provider that this session is using.
     */
    public OpbConnectionProvider getOpbConnectionProvider() {
        return connectionProvider;
    }

    /**
     * Returns the scalar result cache that this session is using.
     * @return The scalar result cache that this session is using.
     */
    public OpbScalarResultCache getOpbScalarResultCache() {
        return scalarResultCache;
    }

    /**
     * Returns the data object source that this session is using.
     * @return The data object source that this session is using.
     */
    public OpbDataObjectSource getDataObjectSource() {
        return dataObjectSource;
    }

    /**
     * Calls {@link OpbConnectionProvider#releaseConnection() }.
     * <br/>
     * This method is here to simplify connection releasing when using a
     * dependency injection container such as Spring.
     * <br/>
     * With Spring; you could configure a request scoped bean of this class, setting
     * destroy-method="releaseConnection" -
     * So the connection would be opened as it's needed but always closed at the end
     * of the request.
     */
    public void releaseConnection() {
        connectionProvider.releaseConnection();
    }

} // End of class OpbSessionPlsqlImpl
