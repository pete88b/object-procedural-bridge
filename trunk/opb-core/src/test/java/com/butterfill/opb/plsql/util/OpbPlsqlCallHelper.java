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
     * Controlls resource closing behaviour when an exception is raised.
     */
    private boolean _closeResourcesOnException = true;

    /**
     * The logger to be used by this helper.
     */
    private Logger _lggr;

    /**
     * Class name of the creator of this helper.
     */
    private String _sourceClass;

    /**
     * Method name of the creator of this helper.
     */
    private String _sourceMethod;

    /**
     * The sql call this helper will help to make.
     */
    private String _sqlCall;

    /**
     * The connection used by this helper.
     */
    private Connection _connection;

    /**
     * The statement created for the sql call.
     */
    private OracleCallableStatement _statement;


    /**
     * Performs logger initialisation for the constructors.
     */
    private void _initLggr(Logger sourceLogger, String sourceClass,
            String sourceMethod) {
        final String _method = "_initLggr(Logger, String, String)";

        logger.entering(CLASS_NAME, _method);

        if (sourceLogger == null) {
            logger.logp(Level.WARNING, CLASS_NAME, _method,
                    "sourceLogger is null. Returning OpbPlsqlCallHelper's logger");
            _lggr = logger;

        } else {
            _lggr = sourceLogger;

        }

        _sourceClass = sourceClass;
        _sourceMethod = sourceMethod;

    } // End of _initLggr(Logger)

    /**
     * Completes initialisation of this helper for the constructors.
     * Note: call _initLggr(Logger) first.
     */
    private void _initHelper(Connection connection,
            String sqlCall, String eventName)
            throws OpbDataAccessException {
        final String _method =
                "_initHelper(OpbEventTimer, Connection, String, String)";

        logger.entering(CLASS_NAME, _method);

        OpbAssert.notNull(
                _lggr, _sourceClass, _sourceMethod,
                "Connection", connection);

        _sqlCall = sqlCall;

        try {
            _statement = (OracleCallableStatement)
                    connection.prepareCall(sqlCall);
            _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                    "call prepared as {0}", sqlCall);

        } catch (Exception ex) {
            throw _throwException("failed to create statement", ex);

        }

        // if we were able to create the statement, save the connection
        _connection = connection;

    } // End of _initHelper(OpbEventTimer ...


    /**
     * Creates a new instance of OpbPlsqlCallHelper.
     * This method prepares the sql call.
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
     *   The sql call that this helper will help to make.
     * @param eventName
     *   An event name for this call.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to prepare the call.
     */
    public OpbPlsqlCallHelper(Logger sourceLogger, String sourceClass,
            String sourceMethod,
            Connection connection, String sqlCall, String eventName)
            throws OpbDataAccessException {
        final String _method =
                "OpbPlsqlCallHelper( ...OpbEventTimer, Connection... )";

        logger.entering(CLASS_NAME, _method);

        _initLggr(sourceLogger, sourceClass, sourceMethod);

        _initHelper(connection, sqlCall, eventName);

    } // End of OpbPlsqlCallHelper()

    /**
     * Creates a new instance of OpbPlsqlCallHelper.
     * This method prepares the sql call.
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
     *   The sql call that this helper will help to make.
     * @param eventName
     *   An event name for this call.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to prepare the call.
     */
    public OpbPlsqlCallHelper(Logger sourceLogger, String sourceClass,
            String sourceMethod,
            OpbConnectionProvider connectionProvider, String sqlCall,
            String eventName)
            throws OpbDataAccessException {
        final String _method =
                "OpbPlsqlCallHelper( ...OpbEventTimerProvider, OpbConnectionProvider... )";

        logger.entering(CLASS_NAME, _method);

        _initLggr(sourceLogger, sourceClass, sourceMethod);

        OpbAssert.notNull(
                _lggr, sourceClass, sourceMethod,
                "ConnectionProvider", connectionProvider);

        Connection connection = null;

        try {
            connection = connectionProvider.getConnection();

        } catch (OpbException ex) {
            _throwException("Failed to get connection from provider", ex);

        }

        _initHelper(connection, sqlCall, eventName);

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
        return _closeResourcesOnException;
    }

    /**
     * Controlls whether resources held by this helper should be closed
     * when a method raises an exception or not.
     *
     * @param closeResourcesOnException
     *   true to close resources held by this helper when a method raises an
     *   exception.
     */
    public void setCloseResourcesOnException(boolean closeResourcesOnException) {
        this._closeResourcesOnException = closeResourcesOnException;
    }

    /**
     * Throws a data access exception optionally closing the statement used by
     * this helper.
     */
    private OpbDataAccessException _throwException(String msg, Exception cause)
            throws OpbDataAccessException {

        if (_closeResourcesOnException) {
            OpbSqlHelper.close(_lggr, _sourceClass, _sourceMethod, _statement);

        }

        return OpbExceptionHelper.throwException(
                new OpbDataAccessException(msg + ". sqlCall=" + _sqlCall, cause),
                _lggr, _sourceClass, _sourceMethod);

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
    public void registerOutArray(int parameterIndex, String sqlTypeName)
            throws OpbDataAccessException {

        _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                "registering out array {0} as '{1}'",
                new Object[]{parameterIndex, sqlTypeName});

        try {
            _statement.registerOutParameter(
                    parameterIndex, Types.ARRAY, sqlTypeName);

        } catch (Exception ex) {
            _throwException(
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
    public void registerOutParameter(int parameterIndex, int sqlType)
            throws OpbDataAccessException {

        _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                "registering out parameter {0} as {1}",
                new Object[]{parameterIndex, sqlType});

        try {
            _statement.registerOutParameter(parameterIndex, sqlType);

        } catch (Exception ex) {
            _throwException(
                    "failed to register out parameter " + parameterIndex +
                    " as " + sqlType, ex);

        }

    }

    /**
     * Sets the value of parameter in position parameterIndex to the specified
     * value.
     * <br/>
     * The parameter should be a user defined SQL collection.
     *
     * @param parameterIndex
     *   The position of the parameter. The first parameter is 1.
     * @param sqlTypeName
     *   The name of the SQL type.
     * @param value
     *   The value to set.
     * @throws NullPointerException
     *   If value is null.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to set the value.
     */
    public void setArray(int parameterIndex, String sqlTypeName, Object[] value)
            throws OpbDataAccessException {
        final String _method = "setArray(int, String, Object[])";

        logger.entering(CLASS_NAME, _method);

        OpbAssert.notNull(
                logger, CLASS_NAME, _method, "value", value,
                "Arrays (User defined collections) cannot be set to null");

        try {
            _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                    "setting array {0} ('{1}') to {2}",
                    new Object[]{parameterIndex, sqlTypeName, value});

            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor(
                    sqlTypeName, _connection);
            ARRAY array = new ARRAY(descriptor, _connection, value);
            _statement.setObject(parameterIndex, array);

        } catch (Exception ex) {
            _throwException(
                    "failed to set array at " + parameterIndex +
                    ". sqlTypeName=" + sqlTypeName +
                    ". value=" + value, ex);

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
    public void setObject(int parameterIndex, int sqlType, Object value)
            throws OpbDataAccessException {
        logger.entering(CLASS_NAME, "setObject(int, int, Object)");

        try {
            if (value == null) {
                _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                        "setting parameter {0} to null", parameterIndex);
                _statement.setNull(parameterIndex, sqlType);

            } else {
                _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                        "setting parameter {0} to {1}",
                        new Object[]{parameterIndex, value});

                if (value instanceof Boolean) {
                    _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                            "found Boolean");

                    _statement.setString(
                            parameterIndex,
                            OpbBooleanHelper.toString((Boolean)value));

                } else if (sqlType == OracleTypes.BINARY_DOUBLE) {
                    _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                            "found BINARY_DOUBLE");
                    _statement.setBinaryDouble(parameterIndex, (Double)value);

                } else if (sqlType == OracleTypes.BINARY_FLOAT) {
                    _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                            "found BINARY_FLOAT");
                    _statement.setBinaryFloat(parameterIndex, (Float)value);

                } else {
                    _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                            "doing normal setObject");
                    _statement.setObject(parameterIndex, value);

                }

            }

        } catch (Exception ex) {
            _throwException(
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
    public void setPlsqlIndexTable(int parameterIndex, int sqlType,
            Object[] value)
            throws OpbDataAccessException, NullPointerException {
        final String _method = "setPlsqlIndexTable(int, int, Object[])";

        logger.entering(CLASS_NAME, _method);

        OpbAssert.notNull(
                logger, CLASS_NAME, _method, "value", value,
                "PL/SQL index-by tables cannot be set to null");

        try {
            _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
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
                _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                        "found String[]");

                for (String s : (String[])value) {
                    // don't try to check the length if s is null.
                    // it would throw a null pointer exception
                    if (s != null && s.length() > elementMaxLength) {
                        elementMaxLength = s.length();

                    }

                }

            } // End of if (value instanceof String[])

            _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                    "maxLength={0}, currentLength={1}, elementMaxLength={2}",
                    new Object[]{maxLength, currentLength, elementMaxLength});

            _statement.setPlsqlIndexTable(
                    parameterIndex, value, maxLength,
                    currentLength, sqlType, elementMaxLength);

        } catch (Exception ex) {
            _throwException(
                    "failed to set PL/SQL index table at " + parameterIndex +
                    ". sqlType=" + sqlType +
                    ". value=" + value, ex);

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
                    _lggr, _sourceClass, _sourceMethod, _statement);

        } catch (Exception ex) {
            _throwException("failed to execute", ex);

        }

    }

    /**
     * Returns the array returned by the parameter in position parameterIndex.
     *
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
    public <T extends Object> T getArray(Class<T> classOfObject, int parameterIndex)
            throws OpbDataAccessException {
        final String _method = "getArray(Class, int)";

        logger.entering(CLASS_NAME, _method);

        OpbAssert.notNull(
                logger, CLASS_NAME, _method, "classOfObject", classOfObject);

        _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                "getting array at {0}", parameterIndex);

        _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                "required Class {0}", classOfObject.getName());

        try {
            ARRAY array = _statement.getARRAY(parameterIndex);
            Object result = array.getArray();

            if (result == null) {
                _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                        "result is null");
            } else {
                _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                        "Class of result is {0}", result.getClass().getName());

            }

            return classOfObject.cast(result);

        } catch (Exception ex) {
            throw _throwException(
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
    public <T extends Object> T get(Class<T> classOfObject, int parameterIndex)
            throws OpbDataAccessException {
        final String _method = "get(Class, int)";

        logger.entering(CLASS_NAME, _method);

        OpbAssert.notNull(
                logger, CLASS_NAME, _method, "classOfObject", classOfObject);

        _lggr.logp(Level.FINER, _sourceClass, _sourceMethod,
                "getting object at {0}", parameterIndex);

        _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                "required Class {0}", classOfObject.getName());

        try {
            Object result;

            if (classOfObject == ResultSet.class) {
                result = _statement.getCursor(parameterIndex);

            } else if (classOfObject == Boolean.class) {
                result = OpbBooleanHelper.toBoolean(
                            _statement.getString(parameterIndex));

            } else {
                result = _statement.getObject(parameterIndex);

            }

            if (result == null) {
                _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                        "result is null");
            } else {
                _lggr.logp(Level.FINEST, _sourceClass, _sourceMethod,
                        "Class of result is {0}", result.getClass().getName());
            }

            return classOfObject.cast(result);

        } catch (Exception ex) {
            throw _throwException(
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
        OpbSqlHelper.close(_lggr, _sourceClass, _sourceMethod, _statement);

        _lggr.logp(Level.FINER, _sourceClass, _sourceMethod, "call complete");

    }

} // End of class OpbPlsqlCallHelper
