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

import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.util.OpbExceptionHelper;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleConnectionCacheManager;
import oracle.jdbc.pool.OracleDataSource;

/**
 * It is expected that the methods provided by this will be used by implementations of OpbSession.
 * 
 * @author Butterp
 */
public final class OpbSessionPlsqlUtils {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = 
            OpbSessionPlsqlUtils.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /** 
     * Private constructor as there is no point creating an instance of this class.
     */
    private OpbSessionPlsqlUtils() {
    }

    /**
     * Returns a connection from the datasource, wrapping any exceptions
     * thrown in an OpbDataAccessException.
     *
     * @param dataSource
     *   The data source used to get the connection returned by this method.
     * @param sourceMethod
     *   The name of the method calling this method.
     *   This is used when logging exceptions.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we can't get a connection.
     * @return
     *   A SQL connection.
     */
    public static Connection getConnection(final OracleDataSource dataSource,
            final String sourceMethod)
            throws OpbDataAccessException {

        final String methodName = "doGetConnection(OracleDataSource)";

        try {
            // get a connection
            final Connection result = dataSource.getConnection();
            // disable auto-commit
            result.setAutoCommit(false);
            // return the connection
            return result;

        } catch (Exception ex) {
            String url = null;

            try {
                url = dataSource.getURL();

            } catch (Exception nonCriticalException) {
                logger.logp(Level.FINEST, CLASS_NAME, methodName,
                        "Failed to get data source URL", nonCriticalException);

            }

            throw OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Failed to get connection from datasource. url=" + url, ex),
                    logger, CLASS_NAME, sourceMethod);

        }

    }

    /**
     * Refreshes all connections of the connection cache of the specified data source -
     * is connection caching is enabled for the specified data source.
     *
     * @param dataSource
     *   The data source who connection cache should be refreshed.
     */
    public static void refreshConnectionCache(final OracleDataSource dataSource) {
        final String methodName = "refreshConnectionCache(OracleDataSource)";

        logger.entering(CLASS_NAME, methodName);

        try {
            if (dataSource.getConnectionCachingEnabled()) {
                logger.logp(Level.FINER, CLASS_NAME, methodName,
                        "connection caching is enabled. refreshing cache");

                final OracleConnectionCacheManager connectionCacheManager =
                        OracleConnectionCacheManager.
                        getConnectionCacheManagerInstance();

                connectionCacheManager.refreshCache(
                        dataSource.getConnectionCacheName(),
                        OracleConnectionCacheManager.REFRESH_ALL_CONNECTIONS);

            }

        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "Failed to refresh cache", ex);

        }

    }

    /**
     * Runs a test query using the specified data source.
     * <p>
     *   The test query is <code>SELECT 1 FROM DUAL</code>.
     * </p>
     * @param dataSource
     *   The data source to test.
     */
    public static void runTestQuery(final OracleDataSource dataSource) {
        final String methodName = "runTestQuery(OracleDataSource)";

        logger.entering(CLASS_NAME, methodName);

        Connection connection = null;
        Statement statement = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.createStatement();

            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "trying SELECT 1 FROM DUAL");

            statement.executeQuery("SELECT 1 FROM DUAL");

            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "data source is ok. SELECT 1 FROM DUAL ran without error");

        } catch (Exception ex) {
            throw OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Can't query data source. " +
                    "Failed to execute test query (SELECT 1 FROM DUAL)", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, statement);
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);

        }

    }

} // End of class OpbSessionPlsqlUtils
