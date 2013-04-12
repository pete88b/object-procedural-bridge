/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.0.0
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.webdemo.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * logger_flag.
 */
public interface LoggerFlag
        extends OpbGroupable, OpbTimingEventPublisher, 
        OpbActiveCacheableEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of rowId.
     * @return The value of rowId.
     */
    String getRowId();
    
    /**
     * Returns the value of logLevel.
     * @return The value of logLevel.
     */
    java.math.BigDecimal getLogLevel();
    
    /**
     * Sets the value of logLevel.
     * @param a The new value for logLevel.
     */
    void setLogLevel(java.math.BigDecimal a);
    
    /**
     * Returns the value of logLevelDataSourceValue.
     * This is the last value returned by the data source for logLevel.
     * @return The value of logLevelDataSourceValue.
     */
    java.math.BigDecimal getLogLevelDataSourceValue();
    
    /**
     * Returns true if the value of logLevel 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if logLevel has changed since it was loaded.
     */
    boolean getLogLevelChanged();
    
    /**
     * Returns the value of logUser.
     * @return The value of logUser.
     */
    String getLogUser();
    
    /**
     * Sets the value of logUser.
     * @param a The new value for logUser.
     */
    void setLogUser(String a);
    
    /**
     * Returns the value of logUserDataSourceValue.
     * This is the last value returned by the data source for logUser.
     * @return The value of logUserDataSourceValue.
     */
    String getLogUserDataSourceValue();
    
    /**
     * Returns true if the value of logUser 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if logUser has changed since it was loaded.
     */
    boolean getLogUserChanged();
    

    /**
     * 
     * Calls the database function del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String del(String pRowId,
            java.math.BigDecimal pOldLogLevel,
            String pOldLogUser) 
            throws OpbDataAccessException; 
    
    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pOldLogLevel is mapped to logLevelDataSourceValue</li>
     * <li>pOldLogUser is mapped to logUserDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String del() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String ins(OpbValueWrapper<String> pRowId,
            java.math.BigDecimal pLogLevel,
            String pLogUser) 
            throws OpbDataAccessException; 
    
    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pLogLevel is mapped to logLevel</li>
     * <li>pLogUser is mapped to logUser</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String ins() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String upd(String pRowId,
            java.math.BigDecimal pOldLogLevel,
            java.math.BigDecimal pLogLevel,
            String pOldLogUser,
            String pLogUser) 
            throws OpbDataAccessException; 
    
    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pOldLogLevel is mapped to logLevelDataSourceValue</li>
     * <li>pLogLevel is mapped to logLevel</li>
     * <li>pOldLogUser is mapped to logUserDataSourceValue</li>
     * <li>pLogUser is mapped to logUser</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String upd() 
            throws OpbDataAccessException; 
    

}