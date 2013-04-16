/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * long_strings.
 */
public class LongStringsImpl implements LongStrings {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            LongStringsImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of LongStringsImpl.
     */
    public LongStringsImpl() {
        logger.entering(CLASS_NAME, "LongStringsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this LongStringsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this LongStringsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this LongStringsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this LongStringsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this LongStringsImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }


    /**
     * 
     * Calls the database function how_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            howLong(final String pData)
            throws OpbDataAccessException {
        final String methodName = "howLong(String)";
    
        logger.entering(CLASS_NAME, methodName);
    
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := long_strings.how_long(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            getLong(final Long pHowLong)
            throws OpbDataAccessException {
        final String methodName = "getLong(Long)";
    
        logger.entering(CLASS_NAME, methodName);
    
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := long_strings.get_long(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pHowLong);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

    /**
     * 
     * Calls the database procedure in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void inOut(final OpbValueWrapper<String> pData)
            throws OpbDataAccessException {
        final String methodName = "inOut(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN long_strings.in_out(?); END;");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pData.getValue());
        
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
        
    
        opbCallHelper.execute();
    
        pData.setValue(opbCallHelper.get(String.class, 1));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}