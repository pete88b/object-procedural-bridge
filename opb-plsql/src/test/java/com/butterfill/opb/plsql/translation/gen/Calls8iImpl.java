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
 * calls8i.
 */
public class Calls8iImpl implements Calls8i {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            Calls8iImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of Calls8iImpl.
     */
    public Calls8iImpl() {
        logger.entering(CLASS_NAME, "Calls8iImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this Calls8iImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this Calls8iImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this Calls8iImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this Calls8iImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this Calls8iImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this Calls8iImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this Calls8iImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this Calls8iImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this Calls8iImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this Calls8iImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * 
     * Calls the database function echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            echo(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "echo(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.echo(?); END;",
                "DbCall:calls8i#echo(varchar2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_CHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fChar(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fChar(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_CHAR(?); END;",
                "DbCall:calls8i#f_CHAR(CHAR)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.CHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_VARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fVarchar2(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fVarchar2(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_VARCHAR2(?); END;",
                "DbCall:calls8i#f_VARCHAR2(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_NUMBER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fNumber(final java.math.BigDecimal pData) 
            throws OpbDataAccessException {
        final String methodName = "fNumber(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_NUMBER(?); END;",
                "DbCall:calls8i#f_NUMBER(NUMBER)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fInteger(final Long pData) 
            throws OpbDataAccessException {
        final String methodName = "fInteger(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_INTEGER(?); END;",
                "DbCall:calls8i#f_INTEGER(INTEGER)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_RAW.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fRaw(final byte[] pData) 
            throws OpbDataAccessException {
        final String methodName = "fRaw(byte[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_RAW(?); END;",
                "DbCall:calls8i#f_RAW(RAW)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BINARY, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * FUNCTION f_LONGRAW (
     * p_data IN LONGRAW
     * )
     * RETURN VARCHAR2;.
     * Calls the database function f_DATE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fDate(final java.util.Date pData) 
            throws OpbDataAccessException {
        final String methodName = "fDate(java.util.Date)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_DATE(?); END;",
                "DbCall:calls8i#f_DATE(DATE)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.TIMESTAMP, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_blob.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.sql.Blob 
            getBlob() 
            throws OpbDataAccessException {
        final String methodName = "getBlob()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.sql.Blob result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_blob(); END;",
                "DbCall:calls8i#get_blob()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BLOB);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.sql.Blob.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_BLOB.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fBlob(final java.sql.Blob pData) 
            throws OpbDataAccessException {
        final String methodName = "fBlob(java.sql.Blob)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_BLOB(?); END;",
                "DbCall:calls8i#f_BLOB(BLOB)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BLOB, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_clob.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.sql.Clob 
            getClob() 
            throws OpbDataAccessException {
        final String methodName = "getClob()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.sql.Clob result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_clob(); END;",
                "DbCall:calls8i#get_clob()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.CLOB);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.sql.Clob.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_CLOB.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fClob(final java.sql.Clob pData) 
            throws OpbDataAccessException {
        final String methodName = "fClob(java.sql.Clob)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_CLOB(?); END;",
                "DbCall:calls8i#f_CLOB(CLOB)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.CLOB, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_BOOLEAN.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fBoolean(final Boolean pData) 
            throws OpbDataAccessException {
        final String methodName = "fBoolean(Boolean)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_BOOLEAN(?); END;",
                "DbCall:calls8i#f_BOOLEAN(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_DBMS_SQL_VARCHAR2_TABLE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fDbmsSqlVarchar2Table(final String[] pData) 
            throws OpbDataAccessException {
        final String methodName = "fDbmsSqlVarchar2Table(String[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_DBMS_SQL_VARCHAR2_TABLE(?); END;",
                "DbCall:calls8i#f_DBMS_SQL_VARCHAR2_TABLE(DBMS_SQL.VARCHAR2_TABLE)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setPlsqlIndexTable(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_DBMS_SQL_NUMBER_TABLE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fDbmsSqlNumberTable(final java.math.BigDecimal[] pData) 
            throws OpbDataAccessException {
        final String methodName = "fDbmsSqlNumberTable(java.math.BigDecimal[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pData", pData,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_DBMS_SQL_NUMBER_TABLE(?); END;",
                "DbCall:calls8i#f_DBMS_SQL_NUMBER_TABLE(DBMS_SQL.NUMBER_TABLE)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setPlsqlIndexTable(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_BINARY_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fBinaryInteger(final Long pData) 
            throws OpbDataAccessException {
        final String methodName = "fBinaryInteger(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_BINARY_INTEGER(?); END;",
                "DbCall:calls8i#f_BINARY_INTEGER(BINARY_INTEGER)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_DEC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fDec(final java.math.BigDecimal pData) 
            throws OpbDataAccessException {
        final String methodName = "fDec(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_DEC(?); END;",
                "DbCall:calls8i#f_DEC(DEC)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_DECIMAL.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fDecimal(final java.math.BigDecimal pData) 
            throws OpbDataAccessException {
        final String methodName = "fDecimal(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_DECIMAL(?); END;",
                "DbCall:calls8i#f_DECIMAL(DECIMAL)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_FLOAT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fFloat(final java.math.BigDecimal pData) 
            throws OpbDataAccessException {
        final String methodName = "fFloat(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_FLOAT(?); END;",
                "DbCall:calls8i#f_FLOAT(FLOAT)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_INT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fInt(final Long pData) 
            throws OpbDataAccessException {
        final String methodName = "fInt(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_INT(?); END;",
                "DbCall:calls8i#f_INT(INT)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_NUMERIC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fNumeric(final java.math.BigDecimal pData) 
            throws OpbDataAccessException {
        final String methodName = "fNumeric(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_NUMERIC(?); END;",
                "DbCall:calls8i#f_NUMERIC(NUMERIC)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_PLS_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fPlsInteger(final Long pData) 
            throws OpbDataAccessException {
        final String methodName = "fPlsInteger(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_PLS_INTEGER(?); END;",
                "DbCall:calls8i#f_PLS_INTEGER(PLS_INTEGER)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_POSITIVE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fPositive(final java.math.BigDecimal pData) 
            throws OpbDataAccessException {
        final String methodName = "fPositive(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_POSITIVE(?); END;",
                "DbCall:calls8i#f_POSITIVE(POSITIVE)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_SMALLINT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fSmallint(final Long pData) 
            throws OpbDataAccessException {
        final String methodName = "fSmallint(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_SMALLINT(?); END;",
                "DbCall:calls8i#f_SMALLINT(SMALLINT)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_CHARACTER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fCharacter(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fCharacter(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_CHARACTER(?); END;",
                "DbCall:calls8i#f_CHARACTER(CHARACTER)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.CHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_NCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fNchar(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fNchar(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_NCHAR(?); END;",
                "DbCall:calls8i#f_NCHAR(NCHAR)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_NVARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fNvarchar2(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fNvarchar2(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_NVARCHAR2(?); END;",
                "DbCall:calls8i#f_NVARCHAR2(NVARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_ROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fRowid(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fRowid(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_ROWID(?); END;",
                "DbCall:calls8i#f_ROWID(ROWID)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_STRING.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fString(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fString(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_STRING(?); END;",
                "DbCall:calls8i#f_STRING(STRING)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_UROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fUrowid(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fUrowid(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_UROWID(?); END;",
                "DbCall:calls8i#f_UROWID(UROWID)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function f_VARCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            fVarchar(final String pData) 
            throws OpbDataAccessException {
        final String methodName = "fVarchar(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.f_VARCHAR(?); END;",
                "DbCall:calls8i#f_VARCHAR(VARCHAR)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pData);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_CHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getChar() 
            throws OpbDataAccessException {
        final String methodName = "getChar()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_CHAR(); END;",
                "DbCall:calls8i#get_CHAR()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.CHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_VARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getVarchar2() 
            throws OpbDataAccessException {
        final String methodName = "getVarchar2()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_VARCHAR2(); END;",
                "DbCall:calls8i#get_VARCHAR2()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_NUMBER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal 
            getNumber() 
            throws OpbDataAccessException {
        final String methodName = "getNumber()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_NUMBER(); END;",
                "DbCall:calls8i#get_NUMBER()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.math.BigDecimal.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            getInteger() 
            throws OpbDataAccessException {
        final String methodName = "getInteger()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_INTEGER(); END;",
                "DbCall:calls8i#get_INTEGER()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_RAW.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public byte[] 
            getRaw() 
            throws OpbDataAccessException {
        final String methodName = "getRaw()";
    
        logger.entering(CLASS_NAME, methodName);
        
        byte[] result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_RAW(); END;",
                "DbCall:calls8i#get_RAW()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BINARY);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(byte[].class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_DATE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.Date 
            getDate() 
            throws OpbDataAccessException {
        final String methodName = "getDate()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.util.Date result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_DATE(); END;",
                "DbCall:calls8i#get_DATE()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.TIMESTAMP);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.util.Date.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_BOOLEAN.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Boolean 
            getBoolean() 
            throws OpbDataAccessException {
        final String methodName = "getBoolean()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Boolean result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_BOOLEAN(); END;",
                "DbCall:calls8i#get_BOOLEAN()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Boolean.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_BINARY_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            getBinaryInteger() 
            throws OpbDataAccessException {
        final String methodName = "getBinaryInteger()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_BINARY_INTEGER(); END;",
                "DbCall:calls8i#get_BINARY_INTEGER()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_DEC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal 
            getDec() 
            throws OpbDataAccessException {
        final String methodName = "getDec()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_DEC(); END;",
                "DbCall:calls8i#get_DEC()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.math.BigDecimal.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_DECIMAL.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal 
            getDecimal() 
            throws OpbDataAccessException {
        final String methodName = "getDecimal()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_DECIMAL(); END;",
                "DbCall:calls8i#get_DECIMAL()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.math.BigDecimal.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_FLOAT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal 
            getFloat() 
            throws OpbDataAccessException {
        final String methodName = "getFloat()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_FLOAT(); END;",
                "DbCall:calls8i#get_FLOAT()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.math.BigDecimal.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_INT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            getInt() 
            throws OpbDataAccessException {
        final String methodName = "getInt()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_INT(); END;",
                "DbCall:calls8i#get_INT()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_NUMERIC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal 
            getNumeric() 
            throws OpbDataAccessException {
        final String methodName = "getNumeric()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_NUMERIC(); END;",
                "DbCall:calls8i#get_NUMERIC()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.math.BigDecimal.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_PLS_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            getPlsInteger() 
            throws OpbDataAccessException {
        final String methodName = "getPlsInteger()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_PLS_INTEGER(); END;",
                "DbCall:calls8i#get_PLS_INTEGER()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_POSITIVE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal 
            getPositive() 
            throws OpbDataAccessException {
        final String methodName = "getPositive()";
    
        logger.entering(CLASS_NAME, methodName);
        
        java.math.BigDecimal result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_POSITIVE(); END;",
                "DbCall:calls8i#get_POSITIVE()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(java.math.BigDecimal.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_SMALLINT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            getSmallint() 
            throws OpbDataAccessException {
        final String methodName = "getSmallint()";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_SMALLINT(); END;",
                "DbCall:calls8i#get_SMALLINT()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_CHARACTER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getCharacter() 
            throws OpbDataAccessException {
        final String methodName = "getCharacter()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_CHARACTER(); END;",
                "DbCall:calls8i#get_CHARACTER()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.CHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_NCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getNchar() 
            throws OpbDataAccessException {
        final String methodName = "getNchar()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_NCHAR(); END;",
                "DbCall:calls8i#get_NCHAR()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_NVARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getNvarchar2() 
            throws OpbDataAccessException {
        final String methodName = "getNvarchar2()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_NVARCHAR2(); END;",
                "DbCall:calls8i#get_NVARCHAR2()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_ROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getRowid() 
            throws OpbDataAccessException {
        final String methodName = "getRowid()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_ROWID(); END;",
                "DbCall:calls8i#get_ROWID()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_STRING.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getString() 
            throws OpbDataAccessException {
        final String methodName = "getString()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_STRING(); END;",
                "DbCall:calls8i#get_STRING()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_UROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getUrowid() 
            throws OpbDataAccessException {
        final String methodName = "getUrowid()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_UROWID(); END;",
                "DbCall:calls8i#get_UROWID()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_VARCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getVarchar() 
            throws OpbDataAccessException {
        final String methodName = "getVarchar()";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_VARCHAR(); END;",
                "DbCall:calls8i#get_VARCHAR()");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function data_types.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            dataTypes(final String pChar,
            final String pVarchar2,
            final java.math.BigDecimal pNumber,
            final Long pInteger,
            final byte[] pRaw,
            final java.util.Date pDate,
            final java.sql.Blob pBlob,
            final java.sql.Clob pClob,
            final Boolean pBoolean,
            final String[] pVarchar2Array,
            final java.math.BigDecimal[] pNumberArray) 
            throws OpbDataAccessException {
        final String methodName = "dataTypes(String, String, java.math.BigDecimal, Long, byte[], java.util.Date, java.sql.Blob, java.sql.Clob, Boolean, String[], java.math.BigDecimal[])";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pVarchar2Array", pVarchar2Array,
                "PL/SQL index-by tables cannot be set to null");
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pNumberArray", pNumberArray,
                "PL/SQL index-by tables cannot be set to null");
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.data_types(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); END;",
                "DbCall:calls8i#data_types(char, varchar2, NUMBER, INTEGER, RAW, date, blob, CLOB, VARCHAR2, dbms_sql.varchar2_table, DBMS_SQL.NUMBER_TABLE)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.CHAR, pChar);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pVarchar2);
        
        opbCallHelper.setObject(
                4, java.sql.Types.DECIMAL, pNumber);
        
        opbCallHelper.setObject(
                5, java.sql.Types.BIGINT, pInteger);
        
        opbCallHelper.setObject(
                6, java.sql.Types.BINARY, pRaw);
        
        opbCallHelper.setObject(
                7, java.sql.Types.TIMESTAMP, pDate);
        
        opbCallHelper.setObject(
                8, java.sql.Types.BLOB, pBlob);
        
        opbCallHelper.setObject(
                9, java.sql.Types.CLOB, pClob);
        
        opbCallHelper.setObject(
                10, java.sql.Types.VARCHAR, pBoolean);
        
        opbCallHelper.setPlsqlIndexTable(
                11, java.sql.Types.VARCHAR, pVarchar2Array);
        
        opbCallHelper.setPlsqlIndexTable(
                12, java.sql.Types.DECIMAL, pNumberArray);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_from_test_table.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView> 
            getFromTestTable() 
            throws OpbDataAccessException {
        final String methodName = "getFromTestTable()";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "calls8i.get_from_test_table");
    
        java.util.List<OpbDynamicDataView> result = 
                opbDataObjectSource.getCachedResult(
                OpbDynamicDataView.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_from_test_table(); END;",
                "DbCall:calls8i#get_from_test_table()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_one_of_each_sql_type.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OneOfEachSqlType> 
            getOneOfEachSqlType() 
            throws OpbDataAccessException {
        final String methodName = "getOneOfEachSqlType()";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "calls8i.get_one_of_each_sql_type");
    
        java.util.List<OneOfEachSqlType> result = 
                opbDataObjectSource.getCachedResult(
                OneOfEachSqlType.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := calls8i.get_one_of_each_sql_type(); END;",
                "DbCall:calls8i#get_one_of_each_sql_type()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OneOfEachSqlType.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

    /**
     * 
     * Calls the database procedure echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void echo(final String pData,
            final OpbValueWrapper<String> pResult) 
            throws OpbDataAccessException {
        final String methodName = "echo(String, OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pResult", pResult);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN calls8i.echo(?, ?); END;",
                "DbCall:calls8i#echo(varchar2, varchar2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pData);
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.VARCHAR);
        
    
        opbCallHelper.execute();
    
        pResult.setValue(opbCallHelper.get(String.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}