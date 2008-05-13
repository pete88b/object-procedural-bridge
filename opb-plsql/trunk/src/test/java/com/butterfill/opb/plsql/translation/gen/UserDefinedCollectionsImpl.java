/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.0.0
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
 * user_defined_collections.
 */
public class UserDefinedCollectionsImpl implements UserDefinedCollections {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            UserDefinedCollectionsImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of UserDefinedCollectionsImpl.
     */
    public UserDefinedCollectionsImpl() {
        logger.entering(CLASS_NAME, "UserDefinedCollectionsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this UserDefinedCollectionsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this UserDefinedCollectionsImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this UserDefinedCollectionsImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this UserDefinedCollectionsImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this UserDefinedCollectionsImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this UserDefinedCollectionsImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this UserDefinedCollectionsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this UserDefinedCollectionsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this UserDefinedCollectionsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this UserDefinedCollectionsImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * 
     * Calls the database function echo_number_table.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal[] 
            echoNumberTable(final Object[] pData) 
            throws OpbDataAccessException {
        final String methodName = "echoNumberTable(java.math.BigDecimal[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal[] result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collections.echo_number_table(?); END;",
                "DbCall:user_defined_collections#echo_number_table(number_table)");
    
        opbCallHelper.registerOutArray(
                1, "NUMBER_TABLE");
    
        opbCallHelper.setArray(
                2, "NUMBER_TABLE", pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.getArray(java.math.BigDecimal[].class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function how_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            howLong(final Object[] pData,
            final OpbValueWrapper<String[]> pResults) 
            throws OpbDataAccessException {
        final String methodName = "howLong(String[], OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pResults", pResults);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collections.how_long(?, ?); END;",
                "DbCall:user_defined_collections#how_long(varchar_table, varchar_table)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setArray(
                2, "VARCHAR_TABLE", pData);
        
        opbCallHelper.registerOutArray(
                3, "VARCHAR_TABLE");
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        pResults.setValue(opbCallHelper.getArray(String[].class, 3));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

    /**
     * 
     * Calls the database procedure simple_in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void simpleInOut(final OpbValueWrapper<String[]> pData) 
            throws OpbDataAccessException {
        final String methodName = "simpleInOut(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pData", pData);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN user_defined_collections.simple_in_out(?); END;",
                "DbCall:user_defined_collections#simple_in_out(varchar_table)");
    
        opbCallHelper.setArray(
                1, "VARCHAR_TABLE", pData.getValue());
        
        opbCallHelper.registerOutArray(
                1, "VARCHAR_TABLE");
        
    
        opbCallHelper.execute();
    
        pData.setValue(opbCallHelper.getArray(String[].class, 1));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}