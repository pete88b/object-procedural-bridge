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

package com.butterfill.opb.plsql.util;

import com.butterfill.opb.OpbException;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbBooleanHelper;
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 * Helps making calls to PL/SQL stored procedures.
 * <br/>
 * The call to be made is set when an instance if this class is created and
 * cannot be changed.
 * <br/>
 * All methods of this class, except for isCloseResourcesOnException(),
 * setCloseResourcesOnException(boolean) and toString(), are effected by the
 * value of the closeResourcesOnException property (including the constructors).
 * <br/>
 * <em>Note: Connection closing is not the responsibility of this helper.</em>
 *
 * @author Peter Butterfill
 */
public class OpbPlsqlCallHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbPlsqlCallHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Controls resource closing behaviour when an exception is raised.
     */
    private boolean closeResourcesOnException = true;

    /**
     * The logger to be used by this helper.
     */
    private Logger lggr;

    /**
     * Class name of the creator of this helper.
     */
    private String sourceClass;

    /**
     * Method name of the creator of this helper.
     */
    private String sourceMethod;

    /**
     * The SQL call this helper will help to make.
     */
    private String sqlCall;

    /**
     * The connection used by this helper.
     */
    private Connection connection;

    /**
     * The statement created for the sql call.
     */
    private OracleCallableStatement statement;


    /**
     * Performs logger initialisation for the constructors.
     *
     * @param sourceLogger The logger of the user of this helper.
     * @param sourceClass Name of the class that's using this helper.
     * @param sourceMethod Name of the method that's using this helper.
     */
    private void initLggr(final Logger sourceLogger, final String sourceClass,
            final String sourceMethod) {
        final String methodName = "initLggr(Logger, String, String)";

        logger.entering(CLASS_NAME, methodName);

        if (sourceLogger == null) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "sourceLogger is null. Returning OpbPlsqlCallHelper's logger");
           this.lggr = logger;

        } else {
           this.lggr = sourceLogger;

        }

        this.sourceClass = sourceClass;
        this.sourceMethod = sourceMethod;

    }

    /**
     * Completes initialisation of this helper for the constructors.
     * Note: call initLggr(Logger) first.
     *
     * @param connection The connection to be used by this helper.
     * @param sqlCall The SQL call that will be made by this helper.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we can't create a statement for the SQL call.
     */
    private void initHelper(final Connection connection, final String sqlCall)
            throws OpbDataAccessException {
        final String methodName =
                "initHelper(Connection, String, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                lggr, sourceClass, sourceMethod,
                "Connection", connection);

        this.sqlCall = sqlCall;

        try {
            this.statement = (OracleCallableStatement)
                    connection.prepareCall(sqlCall);
            lggr.logp(Level.FINER, sourceClass, sourceMethod,
                    "call prepared as {0}", sqlCall);

        } catch (Exception ex) {
            throw throwException("failed to create statement", ex);

        }

        // if we were able to create the statement, save the connection
        this.connection = connection;

    } // End of initHelper


    /**
     * Creates a new instance of OpbPlsqlCallHelper.
     * This method prepares the SQL call.
     *
     * @param sourceLogger
     *   The logger of the class that is creating this helper.
     * @param sourceClass
     *   The name of the class that is creating this helper.
     * @param sourceMethod
     *   The name of the method that is creating this helper.
     * @param connection
     *   A connection. Must not be null.
     * @param sqlCall
     *   The SQL call that this helper will help to make.
     * @param eventName
     *   An event name for this call.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to prepare the call.
     */
    public OpbPlsqlCallHelper(final Logger sourceLogger, final String sourceClass,
            final String sourceMethod, final Connection connection, final String sqlCall)
            throws OpbDataAccessException {
        final String methodName =
                "OpbPlsqlCallHelper( ... Connection... )";

        logger.entering(CLASS_NAME, methodName);

        initLggr(sourceLogger, sourceClass, sourceMethod);

        initHelper(connection, sqlCall);

    } // End of OpbPlsqlCallHelper()

    /**
     * Creates a new instance of OpbPlsqlCallHelper.
     * This method prepares the SQL call.
     *
     * @param sourceLogger
     *   The logger of the class that is creating this helper.
     * @param sourceClass
     *   The name of the class that is creating this helper.
     * @param sourceMethod
     *   The name of the method that is creating this helper.
     * @param connectionProvider
     *   A connection provider. Must not be null.
     * @param sqlCall
     *   The SQL call that this helper will help to make.
     * @param eventName
     *   An event name for this call.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to prepare the call.
     */
    public OpbPlsqlCallHelper(final Logger sourceLogger, final String sourceClass,
            final String sourceMethod, final OpbConnectionProvider connectionProvider,
            final String sqlCall)
            throws OpbDataAccessException {
        final String methodName =
                "OpbPlsqlCallHelper( ... OpbConnectionProvider... )";

        logger.entering(CLASS_NAME, methodName);

        initLggr(sourceLogger, sourceClass, sourceMethod);

        OpbAssert.notNull(
                lggr, sourceClass, sourceMethod,
                "ConnectionProvider", connectionProvider);

        Connection conn = null;

        try {
            conn = connectionProvider.getConnection();

        } catch (OpbException ex) {
            throwException("Failed to get connection from provider", ex);

        }

        initHelper(conn, sqlCall);

    } // End of OpbPlsqlCallHelper()


    /**
     * Returns a String representation of this OpbPlsqlCallHelper and it's values.
     * @return String representation of this OpbPlsqlCallHelper.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }


    /**
     * Returns true if resources held by this helper should be closed when a
     * method raises an exception, false otherwise.
     * <br/>
     * <strong>true is the default</strong>
     * <br/>
     * Note: This will close the statement prepared during instantiation of this
     * object.
     *
     * @return
     *   true if resources held by this helper should be closed when a
     *   method raises an exception.
     */
    public boolean isCloseResourcesOnException() {
        return closeResourcesOnException;
    }

    /**
     * Controls whether resources held by this helper should be closed
     * when a method raises an exception or not.
     *
     * @param closeResourcesOnException
     *   true to close resources held by this helper when a method raises an
     *   exception.
     */
    public void setCloseResourcesOnException(final boolean closeResourcesOnException) {
        this.closeResourcesOnException = closeResourcesOnException;
    }

    /**
     * Throws a data access exception optionally closing the statement used by
     * this helper.
     *
     * @return An com.butterfill.opb.data.OpbDataAccessException
     * @param msg The exception message.
     * @param cause The cause of the exception.
     * @throws com.butterfill.opb.data.OpbDataAccessException Always.
     */
    private OpbDataAccessException throwException(final String msg, final Exception cause)
            throws OpbDataAccessException {

        if (closeResourcesOnException) {
            OpbSqlHelper.close(lggr, sourceClass, sourceMethod, statement);
        }

        return OpbExceptionHelper.throwException(
                new OpbDataAccessException(msg + ". sqlCall=" + sqlCall, cause),
                lggr, sourceClass, sourceMethod);

    }

    /**
     * Registers the out parameter in position parameterIndex to the JDBC type
     * java.sql.Types.ARRAY with type name sqlTypeName.
     *
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @param sqlTypeName
     *   The name of the SQL type.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to register the out parameter.
     */
    public void registerOutArray(final int parameterIndex, final String sqlTypeName)
            throws OpbDataAccessException {

        lggr.logp(Level.FINER, sourceClass, sourceMethod,
                "registering out array {0} as '{1}'",
                new Object[]{parameterIndex, sqlTypeName});

        try {
            statement.registerOutParameter(
                    parameterIndex, Types.ARRAY, sqlTypeName);

        } catch (Exception ex) {
            throwException(
                    "failed to register out array " + parameterIndex +
                    " as '" + sqlTypeName + "'", ex);

        }

    }

    /**
     * Registers the out parameter in position parameterIndex to the JDBC type
     * sqlType.
     *
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @param sqlType
     *   The JDBC type.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to register the out parameter.
     */
    public void registerOutParameter(final int parameterIndex, final int sqlType)
            throws OpbDataAccessException {

        lggr.logp(Level.FINER, sourceClass, sourceMethod,
                "registering out parameter {0} as {1}",
                new Object[]{parameterIndex, sqlType});

        try {
            statement.registerOutParameter(parameterIndex, sqlType);

        } catch (Exception ex) {
            throwException(
                    "failed to register out parameter " + parameterIndex +
                    " as " + sqlType, ex);

        }

    }

    /**
     * Sets the value of parameter in position parameterIndex to the specified value.
     * <br/>
     * The parameter should be a user defined SQL collection.
     *
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @param sqlTypeName
     *   The name of the SQL type.
     * @param value
     *   The value to set. This can be null.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to set the value.
     */
    public void setArray(final int parameterIndex, final String sqlTypeName,
            final Object[] value)
            throws OpbDataAccessException {
        final String methodName = "setArray(int, String, Object[])";

        logger.entering(CLASS_NAME, methodName);

        try {
            if (logger.isLoggable(Level.FINER)) {
                String v = OpbToStringHelper.toStringFull(value);
                lggr.logp(Level.FINER, sourceClass, sourceMethod,
                        "setting array {0} ('{1}') to {2}",
                        new Object[]{parameterIndex, sqlTypeName, v});

            }

            if (value == null) {
                lggr.logp(Level.FINER, sourceClass, sourceMethod, "setting array to null");
                statement.setNull(parameterIndex, Types.ARRAY, sqlTypeName);

            } else {
                ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                        sqlTypeName, connection);
                ARRAY array = new ARRAY(descriptor, connection, value);
                statement.setObject(parameterIndex, array);

            }

        } catch (Exception ex) {
            throwException(
                    "failed to set array at " + parameterIndex +
                    ". sqlTypeName=" + sqlTypeName +
                    ". value=" + OpbToStringHelper.toStringFull(value), ex);

        }

    }

    /**
     * Sets the value of parameter in position parameterIndex to the specified
     * value.
     * <br/>
     * If value is Boolean, it is converted to String using
     * com.butterfill.opb.util.OpbBooleanHelper before setting the parameter value.
     *
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @param sqlType
     *   The JDBC type of value.
     * @param value
     *   The value to set.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to set the value.
     */
    public void setObject(final int parameterIndex, final int sqlType, final Object value)
            throws OpbDataAccessException {
        logger.entering(CLASS_NAME, "setObject(int, int, Object)");

        try {
            if (value == null) {
                lggr.logp(Level.FINER, sourceClass, sourceMethod,
                        "setting parameter {0} to null", parameterIndex);
                statement.setNull(parameterIndex, sqlType);

            } else {
                lggr.logp(Level.FINER, sourceClass, sourceMethod,
                        "setting parameter {0} to {1}",
                        new Object[]{parameterIndex, value});

                if (value instanceof Boolean) {
                    lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                            "found Boolean");

                    statement.setString(
                            parameterIndex,
                            OpbBooleanHelper.toString((Boolean) value));

                } else if (sqlType == OracleTypes.TIMESTAMP) {
                    lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                            "found TIMESTAMP");

                    if (value instanceof Timestamp) {
                        lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                                "found java.sql.Timestamp");
                        statement.setTimestamp(parameterIndex, (Timestamp) value);

                    } else if (value instanceof java.util.Date) {
                        lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                                "found java.util.Date. converting to java.sql.Timestamp");
                        statement.setTimestamp(
                                parameterIndex,
                                new Timestamp(((java.util.Date) value).getTime()));
                    }

                } else if (sqlType == OracleTypes.BINARY_DOUBLE) {
                    lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                            "found BINARY_DOUBLE");
                    statement.setBinaryDouble(parameterIndex, (Double) value);

                } else if (sqlType == OracleTypes.BINARY_FLOAT) {
                    lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                            "found BINARY_FLOAT");
                    statement.setBinaryFloat(parameterIndex, (Float) value);

                } else {
                    lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                            "doing normal setObject");
                    statement.setObject(parameterIndex, value);

                }

            }

        } catch (Exception ex) {
            throwException(
                    "failed to set value for parameter " + parameterIndex +
                    ". sqlType=" + sqlType +
                    ". value=" + value, ex);

        }

    }

    /**
     * Sets the value of parameter in position parameterIndex to the specified
     * value.
     * <br/>
     * The parameter should be a PL/SQL index-by table.
     *
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @param sqlType
     *   The JDBC type of the array elements.
     * @param value
     *   The value to set.
     * @throws NullPointerException
     *   If value is null.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to set the value.
     */
    public void setPlsqlIndexTable(final int parameterIndex, final int sqlType,
            final Object[] value)
            throws OpbDataAccessException, NullPointerException {
        final String methodName = "setPlsqlIndexTable(int, int, Object[])";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "value", value,
                "PL/SQL index-by tables cannot be set to null");

        try {
            lggr.logp(Level.FINER, sourceClass, sourceMethod,
                    "setting parameter {0} to {1}",
                    new Object[]{parameterIndex, value});

            // if you pass 0 for maxLength, call will fail with
            // wrong number or types of arguments in call
            int maxLength = (value.length == 0) ? 1 : value.length;
            int currentLength = value.length;
            int elementMaxLength = 0;

            // If it's an array of strings, we need to know how long
            // the longest string is
            if (value instanceof String[]) {
                lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                        "found String[]");

                for (String s : (String[]) value) {
                    // don't try to check the length if s is null.
                    // it would throw a null pointer exception
                    if (s != null && s.length() > elementMaxLength) {
                        elementMaxLength = s.length();

                    }

                }

            } // End of if (value instanceof String[])

            lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                    "maxLength={0}, currentLength={1}, elementMaxLength={2}",
                    new Object[]{maxLength, currentLength, elementMaxLength});

            statement.setPlsqlIndexTable(
                    parameterIndex, value, maxLength,
                    currentLength, sqlType, elementMaxLength);

        } catch (Exception ex) {
            throwException(
                    "failed to set PL/SQL index table at " + parameterIndex +
                    ". sqlType=" + sqlType +
                    ". value=" + OpbToStringHelper.toStringFull(value), ex);

        }

    }

    /**
     * Executes the statement.
     * <br/>
     * Note: This method uses com.butterfill.opb.data.OpbSqlHelper to execute the
     * statement.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to execute the statement.
     */
    public void execute() throws OpbDataAccessException {

        try {
            // Note: The SqlHelper handles logging for execute
            OpbSqlHelper.execute(
                    lggr, sourceClass, sourceMethod, statement);

        } catch (Exception ex) {
            throwException("failed to execute", ex);

        }

    }

    /**
     * Returns the array returned by the parameter in position parameterIndex.
     *
     * @param <T>
     *   The type of value to reuturn.
     * @param classOfObject
     *   The class of the value to return.
     *   If the value returned by the statement is not if this type, an
     *   exception will be thrown.
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to get the value.
     * @return
     *   The value returned by the specified parameter. This could be null.
     */
    public <T extends Object> T getArray(final Class<T> classOfObject,
            final int parameterIndex)
            throws OpbDataAccessException {
        final String methodName = "getArray(Class, int)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        lggr.logp(Level.FINER, sourceClass, sourceMethod,
                "getting array at {0}", parameterIndex);

        lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                "required Class {0}", classOfObject.getName());

        try {
            ARRAY array = statement.getARRAY(parameterIndex);

            Object result = (array == null) ? null : array.getArray();

            if (result == null) {
                lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                        "result is null");

            } else {
                lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                        "Class of result is {0}", result.getClass().getName());

            }

            return classOfObject.cast(result);

        } catch (Exception ex) {
            throw throwException(
                    "Failed to get array " + classOfObject.getName() +
                    " at index " + parameterIndex, ex);

        }

    } // End of getArray(Class, int)

    /**
     * Returns the value returned by the parameter in position parameterIndex.
     * <br/>
     * If classOfObject is Boolean, a string value will be retrieved from the
     * statement and converted to Boolean using
     * com.butterfill.opb.util.OpbBooleanHelper.
     *
     * @param <T>
     *   The type of the value to return.
     * @param classOfObject
     *   The class of the value to return.
     *   If the value returned by the statement is not if this type, an
     *   exception will be thrown.
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to get the value.
     * @return
     *   The value returned by the specified parameter.
     */
    public <T extends Object> T get(final Class<T> classOfObject,
            final int parameterIndex)
            throws OpbDataAccessException {
        final String methodName = "get(Class, int)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "classOfObject", classOfObject);

        lggr.logp(Level.FINER, sourceClass, sourceMethod,
                "getting object at {0}", parameterIndex);

        lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                "required Class {0}", classOfObject.getName());

        try {
            Object result;

            if (classOfObject == ResultSet.class) {
                result = statement.getCursor(parameterIndex);

            } else if (classOfObject == Boolean.class) {
                result = OpbBooleanHelper.toBoolean(
                            statement.getString(parameterIndex));

            } else {
                result = statement.getObject(parameterIndex);

            }

            if (result == null) {
                lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                        "result is null");
            } else {
                lggr.logp(Level.FINEST, sourceClass, sourceMethod,
                        "Class of result is {0}", result.getClass().getName());
            }

            return classOfObject.cast(result);

        } catch (Exception ex) {
            throw throwException(
                    "Failed to get " + classOfObject.getName() +
                    " at index " + parameterIndex, ex);

        }

    } // End of get(Class, int)

    /**
     * Call this method when this helper is finished with.
     * <br/>
     * This method closes the SQL statement.
     */
    public void callComplete() {

        // close the statement
        OpbSqlHelper.close(lggr, sourceClass, sourceMethod, statement);

        lggr.logp(Level.FINER, sourceClass, sourceMethod, "call complete");

    }

} // End of class OpbPlsqlCallHelper
