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
 * array_demo.
 */
public class ArrayDemoImpl implements ArrayDemo {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            ArrayDemoImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of ArrayDemoImpl.
     */
    public ArrayDemoImpl() {
        logger.entering(CLASS_NAME, "ArrayDemoImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this ArrayDemoImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this ArrayDemoImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this ArrayDemoImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this ArrayDemoImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this ArrayDemoImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this ArrayDemoImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this ArrayDemoImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this ArrayDemoImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this ArrayDemoImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this ArrayDemoImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * Logs the elements of the specified collection at level 101.
     * Calls the database procedure demo_one.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void demoOne(final String[] pArray) 
            throws OpbDataAccessException {
        final String methodName = "demoOne(String[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pArray", pArray,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN array_demo.demo_one(?); END;",
                "DbCall:array_demo#demo_one(DBMS_SQL.VARCHAR2_TABLE)");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pArray);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}