/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.1.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * arrays_in.
 */
public class ArraysInImpl implements ArraysIn {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            ArraysInImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of ArraysInImpl.
     */
    public ArraysInImpl() {
        logger.entering(CLASS_NAME, "ArraysInImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this ArraysInImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this ArraysInImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this ArraysInImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this ArraysInImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this ArraysInImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this ArraysInImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this ArraysInImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this ArraysInImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this ArraysInImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this ArraysInImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * 
     * Calls the database procedure test_one.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void testOne(final String[] pArray) 
            throws OpbDataAccessException {
        final String methodName = "testOne(String[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pArray", pArray,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN arrays_in.test_one(?); END;",
                "DbCall:arrays_in#test_one(DBMS_SQL.VARCHAR2_TABLE)");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pArray);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure test_two.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void testTwo(final java.math.BigDecimal[] pArray) 
            throws OpbDataAccessException {
        final String methodName = "testTwo(java.math.BigDecimal[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pArray", pArray,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN arrays_in.test_two(?); END;",
                "DbCall:arrays_in#test_two(DBMS_SQL.NUMBER_TABLE)");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.DECIMAL, pArray);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}