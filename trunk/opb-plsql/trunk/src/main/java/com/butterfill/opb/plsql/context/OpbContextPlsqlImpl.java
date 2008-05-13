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
    private final String contextName;
    
    /**
     * The data source used by this context.
     */
    private final OracleDataSource dataSource;
    
    /**
     * The event timer used by this context.
     */
    private final OpbEventTimer eventTimer;
    
    /**
     * The account name of the user running the JVM.
     */
    private String localUsername;
    
    /**
     * Value that can be used to identify the host on which the JVM is running.
     */
    private String localHost;
    
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
    public OpbContextPlsqlImpl(final String contextName, 
            final OracleDataSource dataSource, final OpbEventTimer eventTimer) 
            throws NullPointerException {
        final String methodName = 
                "OpbContext(String, OracleDataSource, OpbEventTimer)";
        
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "contextName", contextName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "dataSource", dataSource);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "eventTimer", eventTimer);
        
        this.contextName = contextName;
        
        this.dataSource = dataSource;
        
        this.eventTimer = eventTimer;
        
        try {
            // Get the account name of the user running the JVM.
            this.localUsername = System.getProperty("user.name");
            
        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName, 
                    "Failed to get system property 'user.name'", ex);
            
        }
        
        try {
            // Save hostname / IP address to identify the JVM's host
            this.localHost = InetAddress.getLocalHost().toString();
            
        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName, 
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
    public OpbContextPlsqlImpl(final String contextName, 
            final OracleDataSource dataSource, final OpbEventTimer eventTimer, 
            final boolean stopContextFirst) 
            throws NullPointerException, OpbDataAccessException {
        
        this(contextName, dataSource, eventTimer);
        
        final String methodName = 
                "OpbContext(String, OracleDataSource, OpbEventTimer, boolean)";
        
        logger.entering(CLASS_NAME, methodName);
        
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
        return contextName;    
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
    public void startContext(final boolean stopContextFirst) 
            throws OpbDataAccessException {
        final String methodName = "startContext(boolean)";
        
        String dataSourceUrl = null;
        String dataSourceUser = null;
            
        try {
            dataSourceUrl = dataSource.getURL();
            dataSourceUser = dataSource.getUser();
            logger.logp(Level.FINER, CLASS_NAME, methodName, 
                    "Starting context {0}. url={1}. user={2}", 
                    new Object[]{contextName, dataSourceUrl, dataSourceUser});
            
        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName, 
                    "Failed to get URL or User from data source", ex);
            
        }
        
        Connection connection = null;
        
        try {
            connection = dataSource.getConnection();
                
        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Failed to get connection from data source", ex),
                    logger, CLASS_NAME, methodName);

        }

        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                    logger, CLASS_NAME, methodName,
                    eventTimer, 
                    connection, 
                    "{ CALL opb_context.start_context(?, ?, ?, ?) }",
                    "DbCall:opb_context#start_context(VARCHAR2,VARCHAR2,VARCHAR2,VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, contextName);
            callHelper.setObject(2, Types.VARCHAR, localHost);
            callHelper.setObject(3, Types.VARCHAR, localUsername);
            callHelper.setObject(4, Types.VARCHAR, stopContextFirst);
            
            callHelper.execute();
            
            callHelper.callComplete();
            
            logger.logp(Level.INFO, CLASS_NAME, methodName, 
                    "Started context {0}. url={1}. user={2}", 
                    new Object[]{contextName, dataSourceUrl, dataSourceUser});
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);
            
        }
        
    } // End of startContext(boolean)
    
    /**
     * Tells the data source this context is stopping.
     * @throws com.butterfill.opb.data.OpbDataAccessException 
     *   If we fail to stop this context.
     */
    public void stopContext() 
    throws OpbDataAccessException {
        final String methodName = "stopContext()";
        
        logger.entering(CLASS_NAME, methodName);
        
        Connection connection = null;
        
        try {
            connection = dataSource.getConnection();
                
        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException(
                    "Failed to get connection from data source", ex),
                    logger, CLASS_NAME, methodName);

        }

        try {
            OpbPlsqlCallHelper callHelper = new OpbPlsqlCallHelper(
                    logger, CLASS_NAME, methodName,
                    eventTimer, 
                    connection, 
                    "{ CALL opb_context.stop_context(?, ?, ?) }",
                    "DbCall:opb_context#stop_context(VARCHAR2,VARCHAR2,VARCHAR2)");
            
            callHelper.setObject(1, Types.VARCHAR, contextName);
            callHelper.setObject(2, Types.VARCHAR, localHost);
            callHelper.setObject(3, Types.VARCHAR, localUsername);
            
            callHelper.execute();
            
            callHelper.callComplete();
            
            String dataSourceUrl = null;
            
            try {
                dataSourceUrl = dataSource.getURL();
            } catch (Exception ex) {
                logger.logp(Level.WARNING, CLASS_NAME, methodName, 
                        "Failed to get URL of data source", ex);
            }
            
            logger.logp(Level.INFO, CLASS_NAME, methodName, 
                    "Stopped context {0}. url={1}. user={2}", 
                    new Object[]{
                        contextName, 
                        dataSourceUrl, 
                        dataSource.getUser()});
            
        } finally {
            OpbSqlHelper.close(logger, CLASS_NAME, methodName, connection);
            
        }
        
    } // End of stopContext()
    
} // End of class OpbContextPlsqlImpl
