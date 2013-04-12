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
 * boolean_demo.
 */
public class BooleanDemoImpl implements BooleanDemo {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            BooleanDemoImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of BooleanDemoImpl.
     */
    public BooleanDemoImpl() {
        logger.entering(CLASS_NAME, "BooleanDemoImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this BooleanDemoImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this BooleanDemoImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this BooleanDemoImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this BooleanDemoImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this BooleanDemoImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this BooleanDemoImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this BooleanDemoImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this BooleanDemoImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this BooleanDemoImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this BooleanDemoImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * 
     * Calls the database function get_true.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Boolean 
            getTrue() 
            throws OpbDataAccessException {
        final String methodName = "getTrue()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Boolean result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := boolean_demo.get_true(); END;",
                "DbCall:boolean_demo#get_true()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Boolean.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

}