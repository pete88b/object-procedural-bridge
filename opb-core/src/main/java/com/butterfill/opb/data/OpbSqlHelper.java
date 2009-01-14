/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.butterfill.opb.data;

import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbBooleanHelper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides methods to help when working with SQL / JDBC.
 * @author Peter Butterfill
 */
public final class OpbSqlHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbSqlHelper.class.getName();
    
    /**
     * The SQL error code that indicates a column name is invalid.
     */
    private static final int INVALID_COLUMN_NAME_ERROR_CODE = 17006;

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The set of error codes used by
     * execute(Logger, String, String, CallableStatement).
     */
    private static final Set<Integer> RE_TRYABLE_ERROR_CODES =
            new HashSet<Integer>();

    // Set-up re-tryable error codes.
    static {
        // existing state of packages has been discarded
        RE_TRYABLE_ERROR_CODES.add(4061);
        // existing state of package body has been invalidated
        RE_TRYABLE_ERROR_CODES.add(4068);

    }

    /**
     * Creates a new instance of OpbSqlHelper.
     * This is private as this class contains only static methods.
     * i.e. There is no point creating an instance of this class.
     */
    private OpbSqlHelper() {
    }

    /**
     * Returns sourceLogger if it is not null. Otherwise a warning is logged
     * and the logger of this class is returned.
     * 
     * @param sourceLogger
     *   The logger of the caller of one of this classes public methods.
     * @param method
     *   The name of the method (of this class) that called this method.
     * @return 
     *   The logger that this helper should use.
     */
    private static Logger getLogger(final Logger sourceLogger, 
            final String method) {

        if (sourceLogger == null) {
            logger.logp(Level.WARNING, CLASS_NAME, method,
                    "sourceLogger is null. Returning OpbSqlHelper's logger");
            return logger;

        } else {
            return sourceLogger;

        }

    }

    /**
     * Closes the specified connection.
     * If connection is not null, any exception thrown by the close
     * opperation will be logged as a warning.
     * 
     * @param sourceLogger The logger of the caller of this method.
     * @param sourceClass The name of the class calling this method.
     * @param sourceMethod The name of the method calling this method.
     * @param connection The connecton to be closed.
     */
    public static void close(final Logger sourceLogger, 
            final String sourceClass, final String sourceMethod, 
            final Connection connection) {

        Logger lggr = getLogger(
                sourceLogger, "close(Logger, String, String, Connection)");

        try {
            if (connection == null) {
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "connection was null");
                
            } else {
                connection.close();
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "connection closed");

            }
            
        } catch (Exception ex) {
            lggr.logp(Level.WARNING, sourceClass, sourceMethod,
                    "Failed to close connection", ex);

        }

    }

    /**
     * Closes the specified result set.
     * If resultSet is not null, any exception thrown by the close
     * opperation will be logged as a warning.
     * 
     * @param sourceLogger The logger of the caller of this method.
     * @param sourceClass The name of the class calling this method.
     * @param sourceMethod The name of the method calling this method.
     * @param resultSet The result set to be closed.
     */
    public static void close(final Logger sourceLogger, 
            final String sourceClass, final String sourceMethod, 
            final ResultSet resultSet) {

        Logger lggr = getLogger(
                sourceLogger, "close(Logger, String, String, ResultSet)");

        try {
            if (resultSet == null) {
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "result set was null");
                
            } else {
                resultSet.close();
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "result set closed");
                
            }
            
        } catch (Exception ex) {
            lggr.logp(Level.WARNING, sourceClass, sourceMethod,
                    "Failed to close result set", ex);

        }

    }

    /**
     * Closes the specified statement.
     * If statement is not null, any exception thrown by the close
     * opperation will be logged as a warning.
     * 
     * @param sourceLogger The logger of the caller of this method.
     * @param sourceClass The name of the class calling this method.
     * @param sourceMethod The name of the method calling this method.
     * @param statement The statement to be closed.
     */
    public static void close(final Logger sourceLogger, 
            final String sourceClass, final String sourceMethod, 
            final Statement statement) {

        Logger lggr = getLogger(
                sourceLogger, "close(Logger, String, String, Statement)");

        try {
            if (statement == null) {
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "statement was null");
                
            } else {
                statement.close();
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "statement closed");
                
            }

        } catch (Exception nonCriticalException) {
            lggr.logp(Level.WARNING, sourceClass, sourceMethod,
                    "failed to close statement", nonCriticalException);

        }

    }

    /**
     * Returns the set of error codes that effect the behaviour of
     * execute(Logger, String, String, CallableStatement).
     * The set returned may be modified.
     * 
     * @see #execute(Logger, String, String sourceMethod, CallableStatement)
     * @return
     *   The set of error codes that when raised by execute indicate a second
     *   attemp to execute might succeed.
     */
    public static Set<Integer> getReTryableErrorCodes() {
        return RE_TRYABLE_ERROR_CODES;
    }

    /**
     * Calls execute on the given statement.
     * <br/>
     * If calling execute throws a SQLException and the error code of the
     * SQLException is in the set of retryable error codes, execute will be
     * called a second time.
     * <br/>
     * By default, the set of re-tryable error codes contains codes relating to
     * existing state discarded errors.
     * 
     * @see #getReTryableErrorCodes()
     * @param sourceLogger 
     *   The logger of the caller of this method.
     * @param sourceClass 
     *   The name of the class calling this method.
     * @param sourceMethod 
     *   The name of the method calling this method.
     * @param statement 
     *   The statement to be executed.
     * @throws NullPointerException
     *   If statement is null.
     * @throws java.sql.SQLException
     *   If execute fails.
     */
    public static void execute(final Logger sourceLogger, 
            final String sourceClass, final String sourceMethod, 
            final CallableStatement statement)
            throws NullPointerException, SQLException {

        Logger lggr = getLogger(
                sourceLogger, 
                "execute(Logger, String, String, CallableStatement)");

        OpbAssert.notNull(
                lggr, sourceClass, sourceMethod, "statement", statement);

        try {
            statement.execute();
            lggr.logp(Level.FINER, sourceClass, sourceMethod,
                    "statement.execute() complete");

        } catch (SQLException ex) {
            lggr.logp(Level.FINER, sourceClass, sourceMethod,
                    "statement.execute() failed (first attempt)");

            if (RE_TRYABLE_ERROR_CODES.contains(ex.getErrorCode())) {
                lggr.logp(Level.INFO, sourceClass, sourceMethod,
                        "statement.execute() raised error code {0}. re-trying",
                        ex.getErrorCode());

                statement.execute();

                lggr.logp(Level.INFO, sourceClass, sourceMethod,
                        "statement.execute() complete (after re-try)");

            } else {
                throw ex;

            } // End of if (RE_TRYABLE_ERROR_CODES.contains(ex.getErrorCode()))

        }

    }


    // <editor-fold defaultstate="collapsed" desc="get value section">

    /**
     * Returns the value of columnName from resultSet.
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     *
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return 
     *   The value of columnName.
     * @throws OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet.
     */
    private static Object getObject(final Object dflt, 
            final ResultSet resultSet, final String columnName, 
            final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        final String methodName = 
                "getObject(Object, ResultSet, String, boolean)";

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "resultSet", resultSet);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "columnName={0}, dftl={1}, failOnInvalidColumnName={2}",
                new Object[]{columnName, dflt, failOnInvalidColumnName});

        try {
            Object result = resultSet.getObject(columnName);
            logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "Got object from resultSet. returning {0}", result);
            return result;

        } catch (SQLException ex) {
            if (!failOnInvalidColumnName &&
                    ex.getErrorCode() == INVALID_COLUMN_NAME_ERROR_CODE) {
                logger.logp(Level.FINER, CLASS_NAME, methodName,
                        "Failed to get object from resultSet, returning dflt");
                return dflt;

            }

            throw new OpbDataAccessException(
                    "Failed to get '" + columnName + "' from result set", ex);

        }

    } // End of getObject(Object, ResultSet, String, boolean)

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a Boolean.
     * <br/>
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     * <br/>
     * The String values returned by the result set are converted to Boolean
     * using OpbBooleanHelper.
     *
     * @see OpbBooleanHelper
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @throws OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast or converted to Long.
     * @return The value of columnName.
     */
    public static Boolean getValue(final Boolean dflt, 
            final ResultSet resultSet, final String columnName, 
            final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        
        logger.entering(CLASS_NAME, "getValue(Boolean ...");

        Object value = 
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        if (value == null) {
            return null;
        }

        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        String stringValue = value.toString();

        try {
            return OpbBooleanHelper.toBoolean(stringValue);

        } catch (Exception ex) {
            throw new OpbDataAccessException(
                    "Failed to convert column " + columnName +
                    " to Boolean. value=" + stringValue, ex);

        }

    } // End of getValue(Boolean

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a Integer.
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     *
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *  The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @throws OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast or converted to Long.
     * @return 
     *   The value of columnName.
     */
    public static Integer getValue(final Integer dflt, 
            final ResultSet resultSet, final String columnName, 
            final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        
        logger.entering(CLASS_NAME, "getValue(Integer ...");

        Object value = 
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (Integer) value;

        } catch (Exception castToIntegerException) {
            String stringValue = value.toString();

            try {
                return Integer.valueOf(stringValue);

            } catch (Exception ex) {
                throw new OpbDataAccessException(
                        "Failed to convert column " + columnName +
                        " to Integer. value=" + stringValue);

            }

        }

    } // End of getValue(Integer 

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a Long.
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     *
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @throws OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast or converted to Long.
     * @return 
     *   The value of columnName.
     */
    public static Long getValue(final Long dflt, 
            final ResultSet resultSet, final String columnName, 
            final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        
        logger.entering(CLASS_NAME, "getValue(Long ...");

        Object value = 
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (Long) value;

        } catch (Exception castToLongException) {
            String stringValue = value.toString();

            try {
                return Long.valueOf(stringValue);

            } catch (Exception ex) {
                throw new OpbDataAccessException(
                        "Failed to convert column " + columnName +
                        " to Long. value=" + stringValue);

            }

        }

    } // End of getValue(Long 

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a Double.
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     *
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return 
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to Double.
     */
    public static Double getValue(final Double dflt,
            final ResultSet resultSet, final String columnName, 
            final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        final String methodName = "getValue(Double ...";

        logger.entering(CLASS_NAME, methodName);

        Object value = 
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (Double) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName +
                    " to Double. value=" + value);

        }

    } // End of getValue(Double ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a Float.
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     *
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to Float.
     */
    public static Float getValue(final Float dflt,
            final ResultSet resultSet, final String columnName, 
            final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        
        final String methodName = "getValue(Float ...";

        logger.entering(CLASS_NAME, methodName);

        Object value = 
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (Float) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName +
                    " to Float. value=" + value);

        }

    } // End of getValue(Float ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a java.sql.Timestamp.
     * Returns dflt if failOnInvalidColumnName is false and columnName can
     * not be found in resultSet.
     *
     * @param dflt
     *   Default return value. Also used for method overloading.
     * @param resultSet
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return 
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to java.sql.Timestamp.
     */
    public static java.sql.Timestamp getValue(
            final java.sql.Timestamp dflt, final ResultSet resultSet, 
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {
        
        final String methodName = "getValue(java.sql.Timestamp ...";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "resultSet", resultSet);

        try {
            return resultSet.getTimestamp(columnName);

        } catch (SQLException ex) {
            if (!failOnInvalidColumnName &&
                    ex.getErrorCode() == INVALID_COLUMN_NAME_ERROR_CODE) {
                return dflt;

            }

            throw new OpbDataAccessException(
                    "Failed to get '" + columnName +
                    "' from result set as Timestamp", ex);

        }

    } // End of getValue(java.sql.Timestamp ...


    // <editor-fold defaultstate="collapsed" desc="generated section">
    
    /**
     * Returns the value of columnName in the current row of resultSet
     * as a String.
     * Returns dflt if failOnInvalidColumnName is false and columnName can 
     * not be found in resultSet.
     *
     * @param dflt 
     *   Default return value. Also used for method overloading.
     * @param resultSet 
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName 
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in 
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to String.
     */
    public static String getValue(
            final String dflt, final ResultSet resultSet,
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {

        logger.entering(CLASS_NAME, "getValue(String ...");

        Object value =
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (String) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName + 
                    " to String. value=" + value);

        }

    } // End of getValue(String ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a java.sql.Date.
     * Returns dflt if failOnInvalidColumnName is false and columnName can 
     * not be found in resultSet.
     *
     * @param dflt 
     *   Default return value. Also used for method overloading.
     * @param resultSet 
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName 
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in 
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to java.sql.Date.
     */
    public static java.sql.Date getValue(
            final java.sql.Date dflt, final ResultSet resultSet,
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {

        logger.entering(CLASS_NAME, "getValue(java.sql.Date ...");

        Object value =
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (java.sql.Date) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName + 
                    " to java.sql.Date. value=" + value);

        }

    } // End of getValue(java.sql.Date ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a java.math.BigDecimal.
     * Returns dflt if failOnInvalidColumnName is false and columnName can 
     * not be found in resultSet.
     *
     * @param dflt 
     *   Default return value. Also used for method overloading.
     * @param resultSet 
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName 
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in 
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to java.math.BigDecimal.
     */
    public static java.math.BigDecimal getValue(
            final java.math.BigDecimal dflt, final ResultSet resultSet,
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {

        logger.entering(CLASS_NAME, "getValue(java.math.BigDecimal ...");

        Object value =
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (java.math.BigDecimal) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName + 
                    " to java.math.BigDecimal. value=" + value);

        }

    } // End of getValue(java.math.BigDecimal ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a byte[].
     * Returns dflt if failOnInvalidColumnName is false and columnName can 
     * not be found in resultSet.
     *
     * @param dflt 
     *   Default return value. Also used for method overloading.
     * @param resultSet 
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName 
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in 
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to byte[].
     */
    public static byte[] getValue(
            final byte[] dflt, final ResultSet resultSet,
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {

        logger.entering(CLASS_NAME, "getValue(byte[] ...");

        Object value =
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (byte[]) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName + 
                    " to byte[]. value=" + value);

        }

    } // End of getValue(byte[] ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a java.sql.Blob.
     * Returns dflt if failOnInvalidColumnName is false and columnName can 
     * not be found in resultSet.
     *
     * @param dflt 
     *   Default return value. Also used for method overloading.
     * @param resultSet 
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName 
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in 
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to java.sql.Blob.
     */
    public static java.sql.Blob getValue(
            final java.sql.Blob dflt, final ResultSet resultSet,
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {

        logger.entering(CLASS_NAME, "getValue(java.sql.Blob ...");

        Object value =
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (java.sql.Blob) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName + 
                    " to java.sql.Blob. value=" + value);

        }

    } // End of getValue(java.sql.Blob ...

    /**
     * Returns the value of columnName in the current row of resultSet
     * as a java.sql.Clob.
     * Returns dflt if failOnInvalidColumnName is false and columnName can 
     * not be found in resultSet.
     *
     * @param dflt 
     *   Default return value. Also used for method overloading.
     * @param resultSet 
     *   The result set from which to retrieve the value of a column.
     * @param columnName
     *   The name of the column who's value will be returned.
     * @param failOnInvalidColumnName 
     *   Controls behaviour when columnName cannot be found in resultSet.
     * @return
     *   The value of columnName.
     * @exception OpbDataAccessException
     *   If failOnInvalidColumnName is true and columnName cannot be found in 
     *   resultSet, or if we fail to get columnName from resultSet,
     *   or the value of columnName cannot be cast to java.sql.Clob.
     */
    public static java.sql.Clob getValue(
            final java.sql.Clob dflt, final ResultSet resultSet,
            final String columnName, final boolean failOnInvalidColumnName)
            throws OpbDataAccessException {

        logger.entering(CLASS_NAME, "getValue(java.sql.Clob ...");

        Object value =
                getObject(dflt, resultSet, columnName, failOnInvalidColumnName);

        try {
            return (java.sql.Clob) value;

        } catch (ClassCastException ex) {
            throw new OpbDataAccessException(
                    "Failed to cast column " + columnName + 
                    " to java.sql.Clob. value=" + value);

        }

    } // End of getValue(java.sql.Clob ...

    
    // </editor-fold> End of generated Section


    // </editor-fold> End of get value Section


} // End of class OpbSqlHelper
