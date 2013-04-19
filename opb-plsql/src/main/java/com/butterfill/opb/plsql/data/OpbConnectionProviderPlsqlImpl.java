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

import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbExceptionHelper;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleConnectionCacheManager;
import oracle.jdbc.pool.OracleDataSource;

/**
 * The default connection provider for use with Oracle PL/SQL.
 * <br/>
 * This class is not thread safe.
 *
 * @author Peter Butterfill
 */
public class OpbConnectionProviderPlsqlImpl implements OpbConnectionProvider {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbConnectionProviderPlsqlImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The data source being used by this instance.
     */
    private final OracleDataSource dataSource;


    /**
     * Creates a new instance of an OpbConnectionProviderPlsqlImpl.
     *
     * @param dataSource
     *   The data source that this connection provider should use.
     * @throws NullPointerException
     *   If any arguments are null.
     */
    public OpbConnectionProviderPlsqlImpl(final OracleDataSource dataSource)
            throws NullPointerException {
        final String methodName = "OpbConnectionProviderPlsqlImpl(OracleDataSource)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "dataSource", dataSource);

        this.dataSource = dataSource;

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
     * Returns a connection from the datasource after setting auto-commit to false,
     * wrapping any exceptions thrown in an OpbDataAccessException.
     *
     * @param sourceMethod
     *   The name of the method calling this method.
     *   This is used when logging exceptions.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we can't get a connection.
     * @return
     *   A SQL connection.
     */
    private Connection getConnectionPrivate(final String sourceMethod)
            throws OpbDataAccessException {

        final String methodName = "getConnectionPrivate(String)";

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
     */
    private void refreshConnectionCachePrivate() {
        final String methodName = "refreshConnectionCachePrivate()";

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
    private void runTestQueryPrivate() {
        final String methodName = "runTestQueryPrivate()";

        logger.entering(CLASS_NAME, methodName);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.createStatement();

            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "trying SELECT 1 FROM DUAL");

            resultSet = statement.executeQuery("SELECT 1 FROM DUAL");

            if (!resultSet.next()) {
                throw OpbExceptionHelper.throwException(
                        new OpbDataAccessException(
                        "Failed to get 1st row from test query (SELECT 1 FROM DUAL)"),
                        logger, CLASS_NAME, methodName);
            }

            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "data source is ok. SELECT 1 FROM DUAL ran without error");

        } catch (Exception ex) {
            throw OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Can't query data source. "
                    + "Failed to execute test query (SELECT 1 FROM DUAL)", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, resultSet);
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, statement);
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);

        }

    }

    /**
     * Checks that the data source is OK and tries to fix it if not.
     */
    public void checkDataSource() {
        final String methodName = "checkDataSource()";

        logger.entering(CLASS_NAME, methodName);

        try {
            // run the test query
            runTestQueryPrivate();

        } catch (Exception testQueryFailed) {
            // if the test query failed, try to refresh the connection cache
            refreshConnectionCachePrivate();
            // run the test query again so we know if the connection cache refresh helped
            runTestQueryPrivate();

        }

    } // End of checkDataSource()


    // <editor-fold defaultstate="collapsed" desc="connection section">

    /**
     * The connection of this instance.
     */
    private Connection activeConnection;

    /**
     * Weak reference to the thread that is using the connection of this instance.
     */
    private WeakReference<Thread> weakRefToThreadUsingConnection;

    /**
     * Returns a SQL connection.
     * <br/><br/>
     * (1) If this method has either not been called or has not been called
     * since the last releaseConnection() call, a new connection is returned.
     * This connection will be held as the connection for this instance until
     * releaseConnection() is called.
     * <br/>
     * (2) If this method has been called since the last releaseConnection()
     * call, the connection held by the previous call to this method is
     * returned. See 1 above.
     * <br/>
     * <br/>
     * <strong>Close the connection returned by this method by calling
     * releaseConnection().</strong>
     * <br/>
     * <strong>Do not call close() on the connection returned by this method.
     * </strong>
     * <br/>
     * <br/>
     * It is expected that the connection will be held whilst a set of data
     * access operations are performed in quick succession and released when
     * this set of operations is complete.
     * <br/>
     * For a web based application, it is possible that all data access
     * operations performed for a given HTTP request will use the same
     * connection and that the connection will be released when the response
     * is complete.
     * <br/>
     * <br/>
     * The connection returned should be used by no more than one thread at a
     * time.
     * <br/>
     * This method will log a warning if a thread tries to get the
     * connection before a different thread has released the connection.
     *
     * @see #releaseConnection()
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to get a connection from the data source.
     * @return A SQL connection.
     */
    public synchronized Connection getConnection()
            throws OpbDataAccessException {
        final String methodName = "getConnection()";

        logger.entering(CLASS_NAME, methodName);

        // check for multiple threads trying to use the same connection
        if (weakRefToThreadUsingConnection == null) {
            weakRefToThreadUsingConnection =
                    new WeakReference<Thread>(Thread.currentThread());

        } else if (weakRefToThreadUsingConnection.get() == null) {
            weakRefToThreadUsingConnection =
                    new WeakReference<Thread>(Thread.currentThread());

        } else if (weakRefToThreadUsingConnection.get() != Thread.currentThread()) {
            weakRefToThreadUsingConnection =
                    new WeakReference<Thread>(Thread.currentThread());

            // warn that the connection is in use by another thread
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "Connection is in use by another thread");

        } // End of if (weakRefToThreadUsingConnection ...

        // see if this instance already has a connection that can be used
        if (activeConnection != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "connection already exists for this instance. returning");
            return activeConnection;

        }

        // get a new connection
        activeConnection = getConnectionPrivate(methodName);

        // and return it
        return activeConnection;

    } // End of getConnection()

    /**
     * Releases the connection being used by this connection provider.
     * <br/>
     * <li>If a connection is held by this instance, this method;
     *   <ul>
     *     <li>Closes the connection held by this instance</li>
     *     <li>
     *      Sets the held connection to null
     *      (so no connection is held by this instance)
     *     </li>
     *   </ul>
     * </li>
     * </ul>
     * <br>
     * If closing the connection raises an exception, warnings are logged.
     *
     */
    public synchronized void releaseConnection() {
        final String methodName = "releaseConnection()";

        logger.entering(CLASS_NAME, methodName);

        // close the active connection
        OpbSqlHelper.close(logger, CLASS_NAME, methodName, activeConnection);

        activeConnection = null;

        // clear the weak reference to the thread using the connection to
        // indicate this thread is finished with the connection
        weakRefToThreadUsingConnection = null;

        logger.exiting(CLASS_NAME, methodName);

    } // End of releaseConnection()

    // </editor-fold> End of connection Section

} // End of class OpbConnectionProviderPlsqlImpl
