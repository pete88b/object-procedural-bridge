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

import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbCacheableEntity;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectCreatedListener;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.groups.OpbGroupMemberWrapper;
import com.butterfill.opb.plsql.util.OpbPlsqlCallHelper;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbScalarResultCacheUser;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.groups.OpbGroupable;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.timing.OpbTimingEventPublisher;
import com.butterfill.opb.util.OpbBooleanHelper;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleConnectionCacheManager;
import oracle.jdbc.pool.OracleDataSource;

/**
 * This is the default implementation of an OpbSession.
 * <br/>
 * This class is not thread safe.
 * 
 * @author Peter Butterfill
 */
public class OpbSessionPlsqlImpl implements OpbSession, OpbDataObjectCreatedListener {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbSessionPlsqlImpl.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The ID of this session.
     */
    private String id;
    
    /**
     * The username of the user of this session.
     */
    private String username;
    
    /**
     * The name of the context being used by this session.
     */
    private final String contextName;
    
    /**
     * The name of the data source being used by this session.
     */
    private final OracleDataSource dataSource;
    
    /**
     * The name of the data object source being used by this session.
     */
    private final OpbDataObjectSource dataObjectSource;
    
    /**
     * The name of the group manager being used by this session.
     */
    private final OpbGroupManager groupManager;
    
    /**
     * The name of the scalar result cache being used by this session.
     */
    private final OpbScalarResultCache scalarResultCache;
    
    /**
     * The name of the event timer being used by this session.
     */
    private final OpbEventTimer eventTimer;
    
    
    /** 
     * Creates a new instance of OpbSession to use the specified context.
     * 
     * @param contextName
     *   The name of the context that this session should use.
     * @param dataSource
     *   The data source that this session should use.
     * @param dataObjectSource
     *   The data object source that this session should use. 
     * @param groupManager
     *   The group manager that this session should use.
     * @param scalarResultCache
     *   The scalar result cache that this session should use.
     * @param eventTimer
     *   The event timer that this session should use. 
     * @throws NullPointerException
     *   If any arguments are null.
     */
    public OpbSessionPlsqlImpl(final String contextName, 
            final OracleDataSource dataSource,
            final OpbDataObjectSource dataObjectSource, 
            final OpbGroupManager groupManager,
            final OpbScalarResultCache scalarResultCache, 
            final OpbEventTimer eventTimer) 
            throws NullPointerException {
        final String methodName = "OpbSessionPlsqlImpl(String, ...)";
        
        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, 
                "contextName", contextName);
        
        OpbAssert.notNull(logger, CLASS_NAME, methodName, 
                "dataSource", dataSource);
        
        OpbAssert.notNull(logger, CLASS_NAME, methodName, 
                "dataObjectSource", dataObjectSource);
        
        OpbAssert.notNull(logger, CLASS_NAME, methodName, 
                "groupManager", groupManager);
        
        OpbAssert.notNull(logger, CLASS_NAME, methodName, 
                "scalarResultCache", scalarResultCache);
        
        OpbAssert.notNull(logger, CLASS_NAME, methodName, 
                "eventTimer", eventTimer);
        
        this.contextName = contextName;
        
        this.dataSource = dataSource;
        
        this.dataObjectSource = dataObjectSource;
        this.dataObjectSource.addListener(this);
        
        this.groupManager = groupManager;
        
        this.scalarResultCache = scalarResultCache;
        
        this.eventTimer = eventTimer;
        
    } // End of OpbSessionPlsqlImpl(String, ...)
    
    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbSession.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }
    
    /**
     * Returns the ID of this session.
     * Note: This will be null until createSession() has been called.
     * 
     * @see #createSession()
     * @return ID of this session.
     */
    public String getId() {
        return id;
    }
    
    /**
     * Returns a connection from the datasource, wrapping any exceptions
     * thrown in an OpbDataAccessException.
     * 
     * @param sourceMethod
     *   The name of the method calling this method.
     *   This is used when logging exceptions.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we can't get a connection.
     * @return
     *   A SQL connection.
     */
    private Connection doGetConnection(final String sourceMethod) 
            throws OpbDataAccessException {
        
        final String methodName = "doGetConnection(String)";
        
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
    
    // <editor-fold defaultstate="collapsed" desc="create/end session section">
    
    /**
     * Tries to fix the data source.
     */
    private void checkDataSource() {
        final String methodName = "checkDataSource()";
        
        logger.entering(CLASS_NAME, methodName);
        
        try {
            if (dataSource.getConnectionCachingEnabled()) {
                logger.logp(Level.FINER, CLASS_NAME, methodName, 
                        "connection caching is enabled. refreshing cache");

                OracleConnectionCacheManager connectionCacheManager =
                        OracleConnectionCacheManager
                        .getConnectionCacheManagerInstance();

                connectionCacheManager.refreshCache(
                        dataSource.getConnectionCacheName(),
                        OracleConnectionCacheManager.REFRESH_ALL_CONNECTIONS);

            }

        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName, 
                    "Failed to refresh cache", ex);

        }

        Connection connection = null;
        Statement statement = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.createStatement();

            logger.logp(Level.FINER, CLASS_NAME, methodName, 
                    "trying SELECT 1 FROM DUAL");

            statement.executeQuery(
                    "SELECT 1 FROM DUAL");

            logger.logp(Level.FINER, CLASS_NAME, methodName, 
                    "data source is ok. SELECT 1 FROM DUAL ran without error");

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Data source check failed. " +
                    "Failed to execute test query (SELECT 1 FROM DUAL)", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, statement);
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);

        }
        
    } // End of checkDataSource()
    
    /**
     * Tries to make the opb_session.create_session call.
     */
    private void doCreateSession() {
        final String methodName = "doCreateSession()";
        
        logger.entering(CLASS_NAME, methodName);
        
        Connection connection = doGetConnection(methodName);
        
        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                    logger, CLASS_NAME, methodName,
                    getOpbEventTimer(),
                    connection,
                    "{ CALL opb_session.create_session(?, ?) }",
                    "DbCall:opb_session#create_session(VARCHAR2, VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, contextName);
            callHelper.registerOutParameter(2, Types.VARCHAR);
            callHelper.execute();
            id = callHelper.get(String.class, 2);
            callHelper.callComplete();
            
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "session created with id={0}", id);
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);
            
        }
        
    }
    
    /**
     * Tells the data source to create a session and assigns this session an ID.
     * <br/>
     * Note: This does not start an active phase.
     * <br/>
     * This implementation calls opb_session.create_session(VARCHAR2, VARCHAR2).
     * If the first call fails we try to fix the data source by asking it to
     * refresh all connections and then try the create_session call again.
     * 
     * @throws com.butterfill.opb.data.OpbDataAccessException 
     *   If we fail to create the session.
     */
    public void createSession() throws OpbDataAccessException {
        final String methodName = "createSession()";
        
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.isNull(
                logger, CLASS_NAME, methodName, "this.id", id, 
                "you can't start a session that already has an ID");
        
        try {
            doCreateSession();
            
        } catch (Exception recoverableException) {
            logger.logp(
                    Level.WARNING, CLASS_NAME, methodName, 
                    "failed to create session. Checking datasource before re-try",
                    recoverableException);
            
            checkDataSource();
            
            doCreateSession();
            
        }
        
    } // End of createSession()
    
    /**
     * Tell the data source this session is ending / has ended and sets the
     * ID of this session to null.
     * Calls releaseConnection() on this session.
     * Do not attempt data access via this session after calling this method.
     *
     * @throws NullPointerException
     *   If the ID of this session is already null.
     * @throws com.butterfill.opb.data.OpbDataAccessException 
     *   If we fail to end the session.
     */
    public void endSession() 
    throws OpbDataAccessException, NullPointerException {
        final String methodName = "endSession()";
        
        logger.entering(CLASS_NAME, methodName);
        
        releaseConnection(true);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "this.id", id, 
                "you can't end a session when the session has no ID");
        
        Connection connection = doGetConnection(methodName);
        
        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                    logger, CLASS_NAME, methodName,
                    getOpbEventTimer(),
                    connection,
                    "{ CALL opb_session.end_session(?) }",
                    "DbCall:opb_session#end_session(VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, id);
            callHelper.execute();
            callHelper.callComplete();
            
            // clear the previously saved id
            id = null;
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);
            
        }
        
    } // End of endSession() 
    
    // </editor-fold> End of create/end session Section
    
    
    // <editor-fold defaultstate="collapsed" desc="memory section">
    
    /**
     * When the used memory / total memory is greater than this value, we can
     * remove cached objects.
     * The default value of null says cached objects should never be removed.
     */
    private Float memoryLimitForCachedObjects;
    
    /**
     * Returns the limit for clearing cached objects.
     * <br/>
     * When the used memory / total memory is greater than this value, this 
     * session is allowed to remove cached objects.
     * The default value of 999 says cached objects should never be removed.
     * @see #checkMemoryUse()
     * @return The limit for clearing cached objects.
     */
    public Float getMemoryLimitForCachedObjects() {
        return memoryLimitForCachedObjects;
    }
    
    /**
     * Sets the limit for clearing cached objects.
     * Set this to null to disable clearing cached objects.
     * @param limit The limit for clearing cached objects.
     */
    public void setMemoryLimitForCachedObjects(final Float limit) {
        this.memoryLimitForCachedObjects = limit;
    }
    
    /**
     * When the used memory / total memory is greater than this value, we can
     * remove cached results.
     * The default value of 0.9 say that when less than 10% of the available
     * JVM memory is free, cached results may be cleared.
     */
    private Float memoryLimitForCachedResults = 0.9F;
    
    /**
     * Returns the limit for clearing cached results.
     * <br/>
     * When the used memory / total memory is greater than this value, this
     * session is allowed to remove cached results.
     * The default value of 0.9 say that when less than 10% of the available
     * JVM memory is free, cached results may be cleared.
     * @see #checkMemoryUse()
     * @return The limit for clearing cached results.
     */
    public Float getMemoryLimitForCachedResults() {
        return memoryLimitForCachedResults;
    }

    /**
     * Sets the limit for clearing cached results.
     * Set this to null to disable clearing cached results.
     * @param limit The limit for clearing cached results.
     */
    public void setMemoryLimitForCachedResults(final Float limit) {
        this.memoryLimitForCachedResults = limit;
    }

    
    /**
     * Checks current memory use and clears data object caches if the limits
     * set in this session allow.
     * <br/>
     * <br/>
     * If used memory as a fraction of the JVM's max memory is greater than 
     * the limit set for cached objects, clearCached() is called on the data 
     * object source of this session.
     * <br/>
     * If used memory as a fraction of the JVM's max memory is greater than 
     * the limit set for cached results, clearCachedResults() is called on the 
     * data object source of this session.
     * 
     * @see #getMemoryLimitForCachedObjects()
     * @see #getMemoryLimitForCachedResults()
     * @see OpbDataObjectSource#clearCached()
     * @see OpbDataObjectSource#clearCachedResults()
     */
    public void checkMemoryUse() {
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
            
    } // End of checkMemoryLimits()
    
    // </editor-fold> End of memory section
    
    
    // <editor-fold defaultstate="collapsed" desc="connection section">
    
    /**
     * The connection of this session.
     */
    private Connection activeConnection;
    
    /**
     * Weak reference to the thread that is using the connection of this session.
     */
    private WeakReference<Thread> weakRefToThreadUsingConnection;
    
    /** 
     * Returns a sql connection.
     * <br/><br/>
     * (1) If this method has either not been called or has not been called 
     * since the last releaseConnection() call, a new connection is returned. 
     * An active phase for this connection will have been started.
     * This connection will be held as the connection for this session until
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
     * By starting an active phase, the data source knows which session will be 
     * using the connection. 
     * It is important to tell the data source when a connection is no longer in
     * use by a session. This is done by calling the release connection method. 
     * <br/>
     * It is expected that the connection will be held whilst a set of data 
     * access opperations are performed in quick succession and released when 
     * this set of opperations is complete. 
     * <br/>
     * For a web based application, it is expected that all data access 
     * opperations performed for a given http request will use the same 
     * connection and that the connection will be released when the response
     * is complete.
     * <br/>
     * This method will probably fail if this session has not been started.
     * <br/>
     * <br/>
     * The connection returned should be used by no more than one thread at a
     * time.
     * <br/>
     * This method will log a warning if more a thread tries to get the
     * connection before a different thread has released the connection.
     * 
     * @see #releaseConnection(boolean)
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to get a connection from the data source or we fail to start
     *   an active phase for this session.
     * @return A sql connection.
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
        
        // see if this session already has a connection that can be used
        if (activeConnection != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName, 
                    "connection exists (in active phase). returning");
            return activeConnection;
            
        }
        
        // get a new connection
        activeConnection = doGetConnection(methodName);
        
        // tell the database we have got a connection
        // i.e. start an active phase
        OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                getOpbEventTimer(),
                activeConnection,
                "{ CALL opb_session.starting_active_phase(?) }",
                "DbCall:opb_session#starting_active_phase(VARCHAR2)");
        
        callHelper.setObject(1, Types.VARCHAR, id);
        callHelper.execute();
        callHelper.callComplete();
        
        return activeConnection;
        
    } // End of getConnection()
    
    /**
     * Releases the connection being used by this session optionally clearing
     * any temporary data saved in the database for this session.
     * <br/><br/>
     * This method;
     * <ul>
     * <li>Calls checkMemoryUse()</li>
     * <li>And if a connection is held by this session;
     *   <ul>
     *     <li>Ends the active phase for this session</li>
     *     <li>Closes the connection held by this sesson</li>
     *     <li>
     *      Sets the held connection to null 
     *      (so no connection is held by this session)
     *     </li>
     *   </ul>
     * </li>
     * </ul>
     * <br>
     * If closing the connection raise an exception, warnings are logged.
     * <br/>
     * 
     * @param clearTempData
     *   Pass true to clear temp data, false otherwise.
     * @see #checkMemoryUse()
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to end the active phase.
     */
    public synchronized void releaseConnection(final boolean clearTempData) 
    throws OpbDataAccessException {
        final String methodName = "releaseConnection()";
        
        logger.entering(CLASS_NAME, methodName);
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, 
                "clearTempData={0}", clearTempData);
        
        // these tasks are in a try block so the weak reference to the thread
        // using the connection is always cleared
        try {
            checkMemoryUse();
            
            // if this session's connection is already null, nothing else needs to be done
            if (activeConnection == null) {
                logger.logp(Level.FINER, CLASS_NAME, methodName,
                        "connection is null, doing nothing");
                return;
            }

            // tell the data source we've released the connection, if it's not null
            // i.e. end the active phase
            try {
                OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                        logger, CLASS_NAME, methodName,
                        getOpbEventTimer(),
                        activeConnection,
                        "{ CALL opb_session.ending_active_phase(?, ?) }",
                        "DbCall:opb_session#ending_active_phase(VARCHAR2)");

                callHelper.setObject(1, Types.VARCHAR, id);
                callHelper.setObject(
                        2, Types.VARCHAR, OpbBooleanHelper.toString(clearTempData));
                callHelper.execute();
                callHelper.callComplete();

            } finally {
                // close the saved connection
                OpbSqlHelper.close(logger, CLASS_NAME, methodName, activeConnection);

                activeConnection = null;
                logger.logp(Level.FINER, CLASS_NAME, methodName,
                        "connection set to null");

            }
            
        } finally {
            // clear the weak reference to the thread using the connection to 
            // indicate this thread is finished used the connection
            weakRefToThreadUsingConnection = null;

        }
        
    } // End of releaseConnection()
    
    // </editor-fold> End of connection Section
    
    
    // <editor-fold defaultstate="collapsed" desc="username section">
    
    /**
     * Returns the username of the user of this session.
     * @see #setUsername(String)
     * @return The username of the user of this session.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for this session to the value returned by
     * trimDomain(username). 
     * Note: This method sets the username for this session in the database 
     * before setting the username on this object so if the database call fails,
     * the username of this object will not have been changed.
     *
     * @param username
     *   The username for this session.
     * @throws NullPointerException
     *   If username is null or this session has not been started.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to set the username for this session in the database.
     */
    public void setUsername(final String username) 
    throws OpbDataAccessException, NullPointerException {
        final String methodName = "setUsername(String)";
        
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "username", username);
        
        // this should not happen if createSession has been called
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "this.id", id, 
                "you can't set the username for a session with no ID");
        
        Connection connection = doGetConnection(methodName);
        
        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                getOpbEventTimer(),
                connection,
                "{ CALL opb_session.set_username(?, ?) }",
                "DbCall:opb_session#set_username(VARCHAR2,VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, id);
            callHelper.setObject(2, Types.VARCHAR, username);
            callHelper.execute();
            callHelper.callComplete();
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);
            
        }
        
        // set this last incase the database call fails
        this.username = username;
        
    } // End of setUsername(String)

    // </editor-fold> End of username Section
    
    
    // <editor-fold defaultstate="collapsed" desc="attributes section">
    
    /**
     * The set of attributes for this session.
     */
    private Map<Object, Object> attributes = new HashMap<Object, Object>();
    
    /**
     * Returns a map of attributes for this sesson.
     * @return A map of attributes for this sesson.
     */
    public Map<Object, Object> getAttributes() {
        final String methodName = "getAttributes()";
        
        logger.entering(CLASS_NAME, methodName);
        
        return attributes;
    }

    // </editor-fold> End of attributes Section
    
    /**
     * Returns the group manager that this session is using.
     * @return The group manager that this session is using.
     */
    public OpbGroupManager getGroupManager() {
        return groupManager;
    }
    
    /**
     * Returns the scalar result cache that this session is using.
     * @return The scalar result cache that this session is using.
     */
    public OpbScalarResultCache getScalarResultCache() {
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
     *   Pass true to indicate dataObject has been cached, false otehrwise.
     * @throws NullPointerException
     *   If requestedType or dataObject are null.
     */
    @SuppressWarnings("unchecked")
    public void dataObjectCreated(final Class requestedType, 
            final Object dataObject, final boolean cached) 
            throws NullPointerException {
        final String methodName = "dataObjectCreated(Class, Object, boolean)";
        
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "requestedType", requestedType);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "dataObject", dataObject);
        
        // If the data object created is an active data object, set it's 
        // connection provider.
        if (dataObject instanceof OpbActiveDataObject) {
            ((OpbActiveDataObject) dataObject).setOpbConnectionProvider(this);
        }
        
        // If the data object created is a timing event publisher, set it's
        // event timer provider.
        if (dataObject instanceof OpbTimingEventPublisher) {
            ((OpbTimingEventPublisher) dataObject).setOpbEventTimerProvider(this);
        }
        
        // If the data object is a scalar result cache user, set it's cache
        // provider.
        if (dataObject instanceof OpbScalarResultCacheUser) {
            ((OpbScalarResultCacheUser) dataObject).setOpbScalarResultCacheProvider(this);
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
                
                OpbGroupMemberWrapper wrapper = new OpbGroupMemberWrapper() {
                    public Object getValue() {
                        return getDataObjectSource().getCached(
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
        
    } // End of dataObjectCreated(Class, Object, boolean)
    
    /**
     * Returns the event timer that this session is using.
     * @return The event timer that this session is using.
     */
    public OpbEventTimer getOpbEventTimer() {
        return eventTimer;
    }
    
} // End of class OpbSessionPlsqlImpl
