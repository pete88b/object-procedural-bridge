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
 * index_table.
 */
public class IndexTableImpl implements IndexTable {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            IndexTableImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of IndexTableImpl.
     */
    public IndexTableImpl() {
        logger.entering(CLASS_NAME, "IndexTableImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this IndexTableImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this IndexTableImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this IndexTableImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this IndexTableImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this IndexTableImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }


    /**
     * Resets all field values to their initial values.
     */
    public void opbClearState() {
        final String methodName = "opbClearState()";

        logger.entering(CLASS_NAME, methodName);

        // set all fields to their initial values
        numberArray = null;
        
        varcharArray = null;
        

    } // End of opbClearState()

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal[] numberArray = null;
    
    /**
     * Returns the value of numberArray.
     * @return The value of numberArray.
     */
    public java.math.BigDecimal[] getNumberArray() {
        return numberArray;
    }
    
    /**
     * Sets the value of numberArray.
     * @param a The new value for numberArray.
     */
    public void setNumberArray(final java.math.BigDecimal[] a) {
        this.numberArray = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String[] varcharArray = null;
    
    /**
     * Returns the value of varcharArray.
     * @return The value of varcharArray.
     */
    public String[] getVarcharArray() {
        return varcharArray;
    }
    
    /**
     * Sets the value of varcharArray.
     * @param a The new value for varcharArray.
     */
    public void setVarcharArray(final String[] a) {
        this.varcharArray = a;
    }
    

    /**
     * 
     * Calls the database procedure a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void a(final String[] pData)
            throws OpbDataAccessException {
        final String methodName = "a(String[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.a(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure a2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void a2(final java.math.BigDecimal[] pData)
            throws OpbDataAccessException {
        final String methodName = "a2(java.math.BigDecimal[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.a2(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure a3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void a3(final Long[] pData)
            throws OpbDataAccessException {
        final String methodName = "a3(Long[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.a3(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure x.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void x(final String[] pData)
            throws OpbDataAccessException {
        final String methodName = "x(String[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.x(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure x2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void x2(final java.math.BigDecimal[] pData)
            throws OpbDataAccessException {
        final String methodName = "x2(java.math.BigDecimal[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.x2(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure x3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void x3(final Long[] pData)
            throws OpbDataAccessException {
        final String methodName = "x3(Long[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.x3(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure y2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void y2(final String[] pData)
            throws OpbDataAccessException {
        final String methodName = "y2(String[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.y2(?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure z.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void z(final String[] pData,
            final Long[] pData2,
            final String[] pData3)
            throws OpbDataAccessException {
        final String methodName = "z(String[], Long[], String[])";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData2", pData2,
                "PL/SQL index-by tables cannot be set to null");
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData3", pData3,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN index_table.z(?, ?, ?); END;");
    
        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pData);
        
        opbCallHelper.setPlsqlIndexTable(
                2, java.sql.Types.BIGINT, pData2);
        
        opbCallHelper.setPlsqlIndexTable(
                3, java.sql.Types.VARCHAR, pData3);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}