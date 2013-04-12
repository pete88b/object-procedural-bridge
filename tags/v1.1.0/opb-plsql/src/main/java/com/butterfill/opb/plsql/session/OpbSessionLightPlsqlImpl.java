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
import com.butterfill.opb.data.OpbDataObjectCreatedListener;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.session.OpbSessionUtils;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 * A light version of an Opb session that does not use the opb_session PL/SQL package.
 * <br/>
 * This class is not thread safe.
 *
 * @see OpbSessionPlsqlImpl
 * @author Peter Butterfill
 */
public class OpbSessionLightPlsqlImpl implements OpbSession, OpbDataObjectCreatedListener {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbSessionLightPlsqlImpl.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The username of the user of this session.
     */
    private String username;
    
    /**
     * The data source being used by this session.
     */
    private final OracleDataSource dataSource;
    
    /**
     * The data object source being used by this session.
     */
    private final OpbDataObjectSource dataObjectSource;
    
    /**
     * The group manager being used by this session.
     */
    private final OpbGroupManager groupManager;
    
    /**
     * The scalar result cache being used by this session.
     */
    private final OpbScalarResultCache scalarResultCache;
    
    /**
     * The event timer being used by this session.
     */
    private final OpbEventTimer eventTimer;
    
    
    /** 
     * Creates a new instance of an OpbSessionLightPlsqlImpl.
     * 
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
    public OpbSessionLightPlsqlImpl(final OracleDataSource dataSource,
            final OpbDataObjectSource dataObjectSource, 
            final OpbGroupManager groupManager,
            final OpbScalarResultCache scalarResultCache, 
            final OpbEventTimer eventTimer) 
            throws NullPointerException {
        final String methodName = "OpbSessionLightPlsqlImpl(String, ...)";
        
        logger.entering(CLASS_NAME, methodName);

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
        
        this.dataSource = dataSource;
        
        this.dataObjectSource = dataObjectSource;
        this.dataObjectSource.addListener(this);
        
        this.groupManager = groupManager;
        
        this.scalarResultCache = scalarResultCache;
        
        this.eventTimer = eventTimer;
        
    } // End of OpbSessionLightPlsqlImpl(String, ...)
    
    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbSession.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }
    
    /**
     * Returns null.
     * This implementation does not create sessions in the database.
     * 
     * @return null.
     */
    public String getId() {
        return null;
    }
    
    /**
     * Checks that the data source is ok and tries to fix it if not.
     */
    public void checkDataSource() {
        final String methodName = "checkDataSource()";

        logger.entering(CLASS_NAME, methodName);

        try {
            // run the test query
            OpbSessionPlsqlUtils.runTestQuery(dataSource);

        } catch (Exception testQueryFailed) {
            // if the test query failed, try to refresh the connection cache
            OpbSessionPlsqlUtils.refreshConnectionCache(dataSource);
            // run the test query again so we know if the connection cache refresh helped
            OpbSessionPlsqlUtils.runTestQuery(dataSource);

        }

    } // End of checkDataSource()


    // <editor-fold defaultstate="collapsed" desc="create/end session section">
    
    /**
     * Does nothing.
     */
    public void createSession() {
        
    } // End of createSession()
    
    /**
     * Calls releaseConnection() on this session.
     * <br/>
     * This should really be a "does nothing" method but to avoid the possibility of keeping
     * connections open that are no longer needed, this implementation calls releaseConnection().
     */
    public void endSession() {
        final String methodName = "endSession()";
        
        logger.entering(CLASS_NAME, methodName);
        
        releaseConnection(true);
        
    } // End of endSession() 
    
    // </editor-fold> End of create/end session Section
    
    
    /**
     * Checks current memory use and clears cached results if less than 10% of the available
     * JVM memory is free.
     * 
     * @see OpbDataObjectSource#clearCachedResults()
     */
    public void checkMemoryUse() {
        final String methodName = "checkMemoryUse()";
        
        logger.entering(CLASS_NAME, methodName);

        // pass null for memoryLimitForCachedObjects - never clear cached objects
        // pass 0.9F for memoryLimitForCachedResults - clear cached results if less than 10%
        // of the available JVM memory is free.
        OpbSessionUtils.checkMemoryUse(null, 0.9F, dataObjectSource);
            
    } // End of checkMemoryUse()
    
    
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
     * It is expected that the connection will be held whilst a set of data 
     * access opperations are performed in quick succession and released when 
     * this set of opperations is complete. 
     * <br/>
     * For a web based application, it is possible that all data access
     * opperations performed for a given http request will use the same 
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
     * @see #releaseConnection(boolean)
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to get a connection from the data source.
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
                    "connection already exists for this session. returning");
            return activeConnection;
            
        }
        
        // get a new connection
        activeConnection = OpbSessionPlsqlUtils.getConnection(dataSource, methodName);
        
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
     * If closing the connection raises an exception, warnings are logged.
     * <br/>
     * 
     * @param clearTempData
     *   Is ignored.
     * @see #checkMemoryUse()
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to end the active phase.
     */
    public synchronized void releaseConnection(final boolean clearTempData) 
            throws OpbDataAccessException {
        final String methodName = "releaseConnection()";
        
        logger.entering(CLASS_NAME, methodName);
                
        // check memory use in a try block so that the active connection and the
        // weak reference to the thread using the connection are always cleared
        try {
            checkMemoryUse();

        } finally {
            // close the active connection
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, activeConnection);

            activeConnection = null;
            
            // clear the weak reference to the thread using the connection to 
            // indicate this thread is finished with the connection
            weakRefToThreadUsingConnection = null;

        }

        logger.exiting(CLASS_NAME, methodName);
        
    } // End of releaseConnection()
    
    // </editor-fold> End of connection Section
    
    
    // <editor-fold defaultstate="collapsed" desc="username section">
    
    /**
     * Returns the username of the user of this session.
     * 
     * @return
     *   The username of the user of this session.
     */
    public String getUsername() {
        return username;

    }

    /**
     * Sets the username for this session.
     *
     * @param username
     *   The username for this session.
     */
    public void setUsername(final String username) {
        this.username = username;
        
    }

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
     *   Pass true to indicate dataObject has been cached, false otherwise.
     * @throws NullPointerException
     *   If requestedType or dataObject are null.
     */
    @SuppressWarnings("unchecked")
    public void dataObjectCreated(final Class requestedType, 
            final Object dataObject, final boolean cached) 
            throws NullPointerException {
        final String methodName = "dataObjectCreated(Class, Object, boolean)";
        
        logger.entering(CLASS_NAME, methodName);
        
        OpbSessionUtils.dataObjectCreated(
                requestedType, dataObject, cached,
                dataObjectSource, groupManager, this, this, this);
        
    } // End of dataObjectCreated(Class, Object, boolean)
    
    /**
     * Returns the event timer that this session is using.
     * @return The event timer that this session is using.
     */
    public OpbEventTimer getOpbEventTimer() {
        return eventTimer;

    }
    
} // End of class OpbSessionLightPlsqlImpl
