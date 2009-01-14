/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * calls8i.
 */
public interface Calls8i
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database function echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String echo(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_CHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fChar(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_VARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fVarchar2(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_NUMBER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fNumber(java.math.BigDecimal pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fInteger(Long pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_RAW.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fRaw(byte[] pData) 
            throws OpbDataAccessException; 
    
    /**
     * FUNCTION f_LONGRAW (
     * p_data IN LONGRAW
     * )
     * RETURN VARCHAR2;.
     * Calls the database function f_DATE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fDate(java.sql.Timestamp pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_blob.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.sql.Blob getBlob() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_BLOB.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fBlob(java.sql.Blob pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_clob.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.sql.Clob getClob() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_CLOB.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fClob(java.sql.Clob pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_BOOLEAN.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fBoolean(Boolean pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_DBMS_SQL_VARCHAR2_TABLE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fDbmsSqlVarchar2Table(String[] pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_DBMS_SQL_NUMBER_TABLE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fDbmsSqlNumberTable(java.math.BigDecimal[] pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_BINARY_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fBinaryInteger(Long pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_DEC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fDec(java.math.BigDecimal pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_DECIMAL.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fDecimal(java.math.BigDecimal pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_FLOAT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fFloat(java.math.BigDecimal pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_INT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fInt(Long pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_NUMERIC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fNumeric(java.math.BigDecimal pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_PLS_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fPlsInteger(Long pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_POSITIVE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fPositive(java.math.BigDecimal pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_SMALLINT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fSmallint(Long pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_CHARACTER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fCharacter(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_NCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fNchar(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_NVARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fNvarchar2(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_ROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fRowid(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_STRING.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fString(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_UROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fUrowid(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function f_VARCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String fVarchar(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_CHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getChar() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_VARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getVarchar2() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_NUMBER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal getNumber() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getInteger() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_RAW.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    byte[] getRaw() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_DATE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.sql.Timestamp getDate() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_BOOLEAN.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Boolean getBoolean() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_BINARY_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getBinaryInteger() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_DEC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal getDec() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_DECIMAL.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal getDecimal() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_FLOAT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal getFloat() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_INT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getInt() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_NUMERIC.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal getNumeric() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_PLS_INTEGER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getPlsInteger() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_POSITIVE.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal getPositive() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_SMALLINT.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getSmallint() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_CHARACTER.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getCharacter() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_NCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getNchar() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_NVARCHAR2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getNvarchar2() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_ROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getRowid() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_STRING.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getString() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_UROWID.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getUrowid() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_VARCHAR.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getVarchar() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function data_types.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String dataTypes(String pChar,
            String pVarchar2,
            java.math.BigDecimal pNumber,
            Long pInteger,
            byte[] pRaw,
            java.sql.Timestamp pDate,
            java.sql.Blob pBlob,
            java.sql.Clob pClob,
            Boolean pBoolean,
            String[] pVarchar2Array,
            java.math.BigDecimal[] pNumberArray) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_from_test_table.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getFromTestTable() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_one_of_each_sql_type.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OneOfEachSqlType> getOneOfEachSqlType() 
            throws OpbDataAccessException; 
    

    /**
     * 
     * Calls the database procedure echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void echo(String pData,
            OpbValueWrapper<String> pResult) 
            throws OpbDataAccessException;
    

}