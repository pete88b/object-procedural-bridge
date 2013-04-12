/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.0.0
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.webdemo.data;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * logger_admin.
 */
public class LoggerAdminImpl implements LoggerAdmin {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            LoggerAdminImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of LoggerAdminImpl.
     */
    public LoggerAdminImpl() {
        logger.entering(CLASS_NAME, "LoggerAdminImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this LoggerAdminImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this LoggerAdminImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this LoggerAdminImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this LoggerAdminImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this LoggerAdminImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this LoggerAdminImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this LoggerAdminImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this LoggerAdminImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this LoggerAdminImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this LoggerAdminImpl.
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
        logLevel = null;
        logLevelDataSourceValue = null;
        
        logUser = null;
        logUserDataSourceValue = null;
        
        lastNMinutes = null;
        lastNMinutesDataSourceValue = null;
        
        dateFormat = null;
        dateFormatDataSourceValue = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling 
     * opbClearState() and then sets all field values using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>log_level is <em>mandatory</em></li>
     * <li>log_user is <em>mandatory</em></li>
     * <li>last_n_minutes is <em>mandatory</em></li>
     * <li>date_format is <em>mandatory</em></li>
     * </ul>
     * 
     * @param resultSet The result set from which this instance should be loaded.
     * @throws OpbDataAccessException If we fail to load this instance.
     */
    public void opbLoad(final java.sql.ResultSet resultSet) 
            throws OpbDataAccessException {
        final String methodName = "opbLoad(ResultSet)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure resultSet is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "resultSet", resultSet);

        // Get field values from resultSet
        try {
            // load logLevel from column log_level
            logLevel = OpbSqlHelper.getValue(
                    logLevel, resultSet, 
                    "log_level", true);
            // save the value we just loaded as the datasource value
            logLevelDataSourceValue = logLevel;
            
            // load logUser from column log_user
            logUser = OpbSqlHelper.getValue(
                    logUser, resultSet, 
                    "log_user", true);
            // save the value we just loaded as the datasource value
            logUserDataSourceValue = logUser;
            
            // load lastNMinutes from column last_n_minutes
            lastNMinutes = OpbSqlHelper.getValue(
                    lastNMinutes, resultSet, 
                    "last_n_minutes", true);
            // save the value we just loaded as the datasource value
            lastNMinutesDataSourceValue = lastNMinutes;
            
            // load dateFormat from column date_format
            dateFormat = OpbSqlHelper.getValue(
                    dateFormat, resultSet, 
                    "date_format", true);
            // save the value we just loaded as the datasource value
            dateFormatDataSourceValue = dateFormat;
            

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            logger.exiting(CLASS_NAME, methodName);

        }

    } // End of opbLoad(ResultSet resultSet)


    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal logLevel = null;
    
    /**
     * Returns the value of logLevel.
     * @return The value of logLevel.
     */
    public java.math.BigDecimal getLogLevel() {
        return logLevel;
    }
    
    /**
     * Sets the value of logLevel.
     * @param a The new value for logLevel.
     */
    public void setLogLevel(final java.math.BigDecimal a) {
        this.logLevel = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal logLevelDataSourceValue = null;
    
    /**
     * Returns the value of logLevelDataSourceValue.
     * This is the last value returned by the data source for logLevel.
     * @return The value of logLevelDataSourceValue.
     */
    public java.math.BigDecimal getLogLevelDataSourceValue() {
        return logLevelDataSourceValue;
    }
    
    /**
     * Returns true if the value of logLevel 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if logLevel has changed since it was loaded.
     */
    public boolean getLogLevelChanged() {
        return !OpbComparisonHelper.isEqual(
                    logLevel, logLevelDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String logUser = null;
    
    /**
     * Returns the value of logUser.
     * @return The value of logUser.
     */
    public String getLogUser() {
        return logUser;
    }
    
    /**
     * Sets the value of logUser.
     * @param a The new value for logUser.
     */
    public void setLogUser(final String a) {
        this.logUser = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String logUserDataSourceValue = null;
    
    /**
     * Returns the value of logUserDataSourceValue.
     * This is the last value returned by the data source for logUser.
     * @return The value of logUserDataSourceValue.
     */
    public String getLogUserDataSourceValue() {
        return logUserDataSourceValue;
    }
    
    /**
     * Returns true if the value of logUser 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if logUser has changed since it was loaded.
     */
    public boolean getLogUserChanged() {
        return !OpbComparisonHelper.isEqual(
                    logUser, logUserDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal lastNMinutes = null;
    
    /**
     * Returns the value of lastNMinutes.
     * @return The value of lastNMinutes.
     */
    public java.math.BigDecimal getLastNMinutes() {
        return lastNMinutes;
    }
    
    /**
     * Sets the value of lastNMinutes.
     * @param a The new value for lastNMinutes.
     */
    public void setLastNMinutes(final java.math.BigDecimal a) {
        this.lastNMinutes = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal lastNMinutesDataSourceValue = null;
    
    /**
     * Returns the value of lastNMinutesDataSourceValue.
     * This is the last value returned by the data source for lastNMinutes.
     * @return The value of lastNMinutesDataSourceValue.
     */
    public java.math.BigDecimal getLastNMinutesDataSourceValue() {
        return lastNMinutesDataSourceValue;
    }
    
    /**
     * Returns true if the value of lastNMinutes 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if lastNMinutes has changed since it was loaded.
     */
    public boolean getLastNMinutesChanged() {
        return !OpbComparisonHelper.isEqual(
                    lastNMinutes, lastNMinutesDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String dateFormat = null;
    
    /**
     * Returns the value of dateFormat.
     * @return The value of dateFormat.
     */
    public String getDateFormat() {
        return dateFormat;
    }
    
    /**
     * Sets the value of dateFormat.
     * @param a The new value for dateFormat.
     */
    public void setDateFormat(final String a) {
        this.dateFormat = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String dateFormatDataSourceValue = null;
    
    /**
     * Returns the value of dateFormatDataSourceValue.
     * This is the last value returned by the data source for dateFormat.
     * @return The value of dateFormatDataSourceValue.
     */
    public String getDateFormatDataSourceValue() {
        return dateFormatDataSourceValue;
    }
    
    /**
     * Returns true if the value of dateFormat 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if dateFormat has changed since it was loaded.
     */
    public boolean getDateFormatChanged() {
        return !OpbComparisonHelper.isEqual(
                    dateFormat, dateFormatDataSourceValue);
    }


    /**
     * 
     * Calls the database function get_logger_flags.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<LoggerFlag> 
            getLoggerFlags(final java.math.BigDecimal pLogLevel,
            final String pLogUser) 
            throws OpbDataAccessException {
        final String methodName = "getLoggerFlags(java.math.BigDecimal, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "logger_admin.get_logger_flags",
                pLogLevel,
                pLogUser);
    
        java.util.List<LoggerFlag> result = 
                opbDataObjectSource.getCachedResult(
                LoggerFlag.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := logger_admin.get_logger_flags(?, ?); END;",
                "DbCall:logger_admin#get_logger_flags(NUMBER, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pLogLevel);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pLogUser);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                LoggerFlag.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getLoggerFlags using mapped parameters.
     * <ul>
     * <li>pLogLevel is mapped to logLevel</li>
     * <li>pLogUser is mapped to logUser</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<LoggerFlag>
            getLoggerFlags() 
            throws OpbDataAccessException {
        final String methodName = "getLoggerFlags()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<LoggerFlag> result = getLoggerFlags(
                getLogLevel(),
                getLogUser());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_logged_data.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView> 
            getLoggedData(final java.math.BigDecimal pLastNMinutes,
            final String pDateFormat) 
            throws OpbDataAccessException {
        final String methodName = "getLoggedData(java.math.BigDecimal, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "logger_admin.get_logged_data",
                pLastNMinutes,
                pDateFormat);
    
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
                "BEGIN ? := logger_admin.get_logged_data(?, ?); END;",
                "DbCall:logger_admin#get_logged_data(NUMBER, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pLastNMinutes);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDateFormat);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getLoggedData using mapped parameters.
     * <ul>
     * <li>pLastNMinutes is mapped to lastNMinutes</li>
     * <li>pDateFormat is mapped to dateFormat</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            getLoggedData() 
            throws OpbDataAccessException {
        final String methodName = "getLoggedData()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<OpbDynamicDataView> result = getLoggedData(
                getLastNMinutes(),
                getDateFormat());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_logged_events.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView> 
            getLoggedEvents(final java.math.BigDecimal pLastNMinutes,
            final String pDateFormat) 
            throws OpbDataAccessException {
        final String methodName = "getLoggedEvents(java.math.BigDecimal, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "logger_admin.get_logged_events",
                pLastNMinutes,
                pDateFormat);
    
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
                "BEGIN ? := logger_admin.get_logged_events(?, ?); END;",
                "DbCall:logger_admin#get_logged_events(NUMBER, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pLastNMinutes);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDateFormat);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getLoggedEvents using mapped parameters.
     * <ul>
     * <li>pLastNMinutes is mapped to lastNMinutes</li>
     * <li>pDateFormat is mapped to dateFormat</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            getLoggedEvents() 
            throws OpbDataAccessException {
        final String methodName = "getLoggedEvents()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<OpbDynamicDataView> result = getLoggedEvents(
                getLastNMinutes(),
                getDateFormat());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_logged_errors.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView> 
            getLoggedErrors(final java.math.BigDecimal pLastNMinutes,
            final String pDateFormat) 
            throws OpbDataAccessException {
        final String methodName = "getLoggedErrors(java.math.BigDecimal, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "logger_admin.get_logged_errors",
                pLastNMinutes,
                pDateFormat);
    
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
                "BEGIN ? := logger_admin.get_logged_errors(?, ?); END;",
                "DbCall:logger_admin#get_logged_errors(NUMBER, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.DECIMAL, pLastNMinutes);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDateFormat);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getLoggedErrors using mapped parameters.
     * <ul>
     * <li>pLastNMinutes is mapped to lastNMinutes</li>
     * <li>pDateFormat is mapped to dateFormat</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            getLoggedErrors() 
            throws OpbDataAccessException {
        final String methodName = "getLoggedErrors()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<OpbDynamicDataView> result = getLoggedErrors(
                getLastNMinutes(),
                getDateFormat());
    
    
        return result;
    }
    

}