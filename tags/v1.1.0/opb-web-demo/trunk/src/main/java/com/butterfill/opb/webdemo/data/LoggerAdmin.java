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
 * logger_admin.
 */
public interface LoggerAdmin
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

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
     * Returns the value of lastNMinutes.
     * @return The value of lastNMinutes.
     */
    java.math.BigDecimal getLastNMinutes();
    
    /**
     * Sets the value of lastNMinutes.
     * @param a The new value for lastNMinutes.
     */
    void setLastNMinutes(java.math.BigDecimal a);
    
    /**
     * Returns the value of lastNMinutesDataSourceValue.
     * This is the last value returned by the data source for lastNMinutes.
     * @return The value of lastNMinutesDataSourceValue.
     */
    java.math.BigDecimal getLastNMinutesDataSourceValue();
    
    /**
     * Returns true if the value of lastNMinutes 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if lastNMinutes has changed since it was loaded.
     */
    boolean getLastNMinutesChanged();
    
    /**
     * Returns the value of dateFormat.
     * @return The value of dateFormat.
     */
    String getDateFormat();
    
    /**
     * Sets the value of dateFormat.
     * @param a The new value for dateFormat.
     */
    void setDateFormat(String a);
    
    /**
     * Returns the value of dateFormatDataSourceValue.
     * This is the last value returned by the data source for dateFormat.
     * @return The value of dateFormatDataSourceValue.
     */
    String getDateFormatDataSourceValue();
    
    /**
     * Returns true if the value of dateFormat 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if dateFormat has changed since it was loaded.
     */
    boolean getDateFormatChanged();
    

    /**
     * 
     * Calls the database function get_logger_flags.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<LoggerFlag> getLoggerFlags(java.math.BigDecimal pLogLevel,
            String pLogUser) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getLoggerFlags using mapped parameters.
     * <ul>
     * <li>pLogLevel is mapped to logLevel</li>
     * <li>pLogUser is mapped to logUser</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<LoggerFlag> getLoggerFlags() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_logged_data.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getLoggedData(java.math.BigDecimal pLastNMinutes,
            String pDateFormat) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getLoggedData using mapped parameters.
     * <ul>
     * <li>pLastNMinutes is mapped to lastNMinutes</li>
     * <li>pDateFormat is mapped to dateFormat</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getLoggedData() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_logged_events.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getLoggedEvents(java.math.BigDecimal pLastNMinutes,
            String pDateFormat) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getLoggedEvents using mapped parameters.
     * <ul>
     * <li>pLastNMinutes is mapped to lastNMinutes</li>
     * <li>pDateFormat is mapped to dateFormat</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getLoggedEvents() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_logged_errors.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getLoggedErrors(java.math.BigDecimal pLastNMinutes,
            String pDateFormat) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getLoggedErrors using mapped parameters.
     * <ul>
     * <li>pLastNMinutes is mapped to lastNMinutes</li>
     * <li>pDateFormat is mapped to dateFormat</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> getLoggedErrors() 
            throws OpbDataAccessException; 
    

}