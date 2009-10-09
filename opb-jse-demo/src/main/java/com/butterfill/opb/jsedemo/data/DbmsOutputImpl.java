/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.1.0
 * opb-core version: 1.1.0
 */

package com.butterfill.opb.jsedemo.data;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * dbms_output.
 */
public class DbmsOutputImpl implements DbmsOutput {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            DbmsOutputImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of DbmsOutputImpl.
     */
    public DbmsOutputImpl() {
        logger.entering(CLASS_NAME, "DbmsOutputImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this DbmsOutputImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this DbmsOutputImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this DbmsOutputImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this DbmsOutputImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this DbmsOutputImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this DbmsOutputImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this DbmsOutputImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this DbmsOutputImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this DbmsOutputImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this DbmsOutputImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * 
     * Calls the database procedure enable.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void enable(final Long bufferSize) 
            throws OpbDataAccessException {
        final String methodName = "enable(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN dbms_output.enable(?); END;",
                "DbCall:dbms_output#enable(integer)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, bufferSize);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure disable.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void disable() 
            throws OpbDataAccessException {
        final String methodName = "disable()";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN dbms_output.disable(); END;",
                "DbCall:dbms_output#disable()");
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure put.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void put(final String a) 
            throws OpbDataAccessException {
        final String methodName = "put(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN dbms_output.put(?); END;",
                "DbCall:dbms_output#put(varchar2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, a);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure put_line.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void putLine(final String a) 
            throws OpbDataAccessException {
        final String methodName = "putLine(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN dbms_output.put_line(?); END;",
                "DbCall:dbms_output#put_line(varchar2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, a);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure new_line.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void newLine() 
            throws OpbDataAccessException {
        final String methodName = "newLine()";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN dbms_output.new_line(); END;",
                "DbCall:dbms_output#new_line()");
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure get_line.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void getLine(final OpbValueWrapper<String> line,
            final OpbValueWrapper<Long> status) 
            throws OpbDataAccessException {
        final String methodName = "getLine(OpbValueWrapper, OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "line", line);
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "status", status);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN dbms_output.get_line(?, ?); END;",
                "DbCall:dbms_output#get_line(varchar2, integer)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        line.setValue(opbCallHelper.get(String.class, 1));
        status.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}