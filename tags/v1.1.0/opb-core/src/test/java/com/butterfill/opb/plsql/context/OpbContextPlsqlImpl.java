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


package com.butterfill.opb.plsql.context;

import com.butterfill.opb.context.OpbContext;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.plsql.util.OpbPlsqlCallHelper;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/** 
 * Encapsulates access to the opb_context PL/SQL package.
 * <br/>
 * This is the default implementation of an OpbContext.
 *
 * @author Peter Butterfill
 */
public class OpbContextPlsqlImpl implements OpbContext {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbContextPlsqlImpl.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /**
     * The name of this context.
     */
    private final String _contextName;
    
    /**
     * The data source used by this context.
     */
    private final OracleDataSource _dataSource;
    
    /**
     * The event timer used by this context.
     */
    private final OpbEventTimer _eventTimer;
    
    /**
     * The account name of the user running the JVM.
     */
    private String _localUsername;
    
    /**
     * Value that can be used to identify the host on which the JVM is running.
     */
    private String _localHost;
    
    /**
     * Creates a new instance of OpbContextPlsqlImpl with the specified name.
     * 
     * @param contextName
     *   The name of this context.
     * @param dataSource
     *   The data source that this context should use.
     *   The data source should provide a connection to an Oracle database
     *   through which the opb_context PL/SQL package can be accessed.
     * @param eventTimer
     *   The event timer that should be used by this context.
     * 
     * @throws NullPointerException
     *   If contextName, dataSource or eventTimer are null.
     */
    public OpbContextPlsqlImpl(String contextName, OracleDataSource dataSource, 
            OpbEventTimer eventTimer) throws NullPointerException {
        final String _method = 
                "OpbContext(String, OracleDataSource, OpbEventTimer)";
        
        logger.entering(CLASS_NAME, _method);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "contextName", contextName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "dataSource", dataSource);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "eventTimer", eventTimer);
        
        _contextName = contextName;
        
        _dataSource = dataSource;
        
        _eventTimer = eventTimer;
        
        try {
            // Get the account name of the user running the JVM.
            _localUsername = System.getProperty("user.name");
            
        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, _method, 
                    "Failed to get system property 'user.name'", ex);
            
        }
        
        try {
            // Save hostname / IP address to identify the JVM's host
            _localHost = InetAddress.getLocalHost().toString();
            
        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, _method, 
                    "Failed to get local host", ex);
            
        }
        
    } // End of OpbContext(String, OracleDataSource, OpbEventTimer)
    
    
    /**
     * Creates a new instance of OpbContextPlsqlImpl with the specified name
     * and calls startContext(boolean).
     * 
     * @param contextName
     *   The name of this context.
     * @param dataSource
     *   The data source that this context should use.
     *   The data source should provide a connection to an Oracle database
     *   through which the opb_context PL/SQL package can be accessed.
     * @param eventTimer
     *   The event timer that should be used by this context.
     * @param stopContextFirst 
     *   Pass in true to tell the data source to stop this context if it not
     *   stopped.
     * 
     * @see #startContext(boolean)
     * @throws NullPointerException
     *   If contextName, dataSource or eventTimer are null.
     * @throws OpbDataAccessException
     *   If the call to startContext(boolean) fails.
     */
    public OpbContextPlsqlImpl(String contextName, OracleDataSource dataSource, 
            OpbEventTimer eventTimer, boolean stopContextFirst) 
            throws NullPointerException, OpbDataAccessException {
        this(contextName, dataSource, eventTimer);
        
        final String _method = 
                "OpbContext(String, OracleDataSource, OpbEventTimer, boolean)";
        
        logger.entering(CLASS_NAME, _method);
        
        startContext(stopContextFirst);
        
    } // End of OpbContext(String, OracleDataSource, OpbEventTimer, boolean)
    
    
    /**
     * Returns a String representation of this instance and it's values.
     * 
     * @return String representation of this OpbContextPlsqlImpl.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }
    
    /**
     * Returns the name of this context.
     * @return The name of this context.
     */
    public String getContextName() {
        return _contextName;    
    }

    
    /**
     * Tells the data source this context is starting.
     * 
     * @param stopContextFirst 
     *   Pass true to tell the data source to stop this context if it not 
     *   stopped.
     * @throws com.butterfill.opb.data.OpbDataAccessException 
     *   If we fail to start this context.
     */
    public void startContext(boolean stopContextFirst) 
            throws OpbDataAccessException {
        final String _method = "startContext(boolean)";
        
        String dataSourceUrl = null;
        String dataSourceUser = null;
            
        try {
            dataSourceUrl = _dataSource.getURL();
            dataSourceUser = _dataSource.getUser();
            logger.logp(Level.FINER, CLASS_NAME, _method, 
                    "Starting context {0}. url={1}. user={2}", 
                    new Object[]{_contextName, dataSourceUrl, dataSourceUser});
            
        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, _method, 
                    "Failed to get URL or User from data source", ex);
            
        }
        
        Connection connection = null;
        
        try {
            connection = _dataSource.getConnection();
                
        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Failed to get connection from data source", ex),
                    logger, CLASS_NAME, _method);

        }

        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                    logger, CLASS_NAME, _method,
                    _eventTimer, 
                    connection, 
                    "{ CALL opb_context.start_context(?, ?, ?, ?) }",
                    "DbCall:opb_context#start_context(VARCHAR2,VARCHAR2,VARCHAR2,VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, _contextName);
            callHelper.setObject(2, Types.VARCHAR, _localHost);
            callHelper.setObject(3, Types.VARCHAR, _localUsername);
            callHelper.setObject(4, Types.VARCHAR, stopContextFirst);
            
            callHelper.execute();
            
            callHelper.callComplete();
            
            logger.logp(Level.INFO, CLASS_NAME, _method, 
                    "Started context {0}. url={1}. user={2}", 
                    new Object[]{_contextName, dataSourceUrl, dataSourceUser});
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, _method, connection);
            
        }
        
    } // End of startContext(boolean)
    
    /**
     * Tells the data source this context is stopping.
     * @throws com.butterfill.opb.data.OpbDataAccessException 
     *   If we fail to stop this context.
     */
    public void stopContext() 
    throws OpbDataAccessException {
        final String _method = "stopContext()";
        
        logger.entering(CLASS_NAME, _method);
        
        Connection connection = null;
        
        try {
            connection = _dataSource.getConnection();
                
        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Failed to get connection from data source", ex),
                    logger, CLASS_NAME, _method);

        }

        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                    logger, CLASS_NAME, _method,
                    _eventTimer, 
                    connection, 
                    "{ CALL opb_context.stop_context(?, ?, ?) }",
                    "DbCall:opb_context#stop_context(VARCHAR2,VARCHAR2,VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, _contextName);
            callHelper.setObject(2, Types.VARCHAR, _localHost);
            callHelper.setObject(3, Types.VARCHAR, _localUsername);
            
            callHelper.execute();
            
            callHelper.callComplete();
            
            String dataSourceUrl = null;
            
            try {
                dataSourceUrl = _dataSource.getURL();
            } catch (Exception ex) {
                logger.logp(Level.WARNING, CLASS_NAME, _method, 
                        "Failed to get URL of data source", ex);
            }
            
            logger.logp(Level.INFO, CLASS_NAME, _method, 
                    "Stopped context {0}. url={1}. user={2}", 
                    new Object[]{
                        _contextName, 
                        dataSourceUrl, 
                        _dataSource.getUser()});
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, _method, connection);
            
        }
        
    } // End of stopContext()
    
} // End of class OpbContextPlsqlImpl
