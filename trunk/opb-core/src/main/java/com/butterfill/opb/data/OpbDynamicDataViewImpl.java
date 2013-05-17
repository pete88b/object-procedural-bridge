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
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbSqlNameToJavaNameHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used to hold and provide access to the data of a single row of a ResultSet.
 * Provides access to this data via the Map interface.
 *
 * @author Peter Butterfill
 */
public class OpbDynamicDataViewImpl implements OpbDynamicDataView {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbDynamicDataViewImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The SqlNameToJavaNameHelper used by this instance.
     */
    private final OpbSqlNameToJavaNameHelper sqlNameToJavaNameHelper =
            new OpbSqlNameToJavaNameHelper();

    /**
     * Holds values loaded by the opbLoad(ResultSet) method.
     */
    private final Map<String, Object> valuesMap = new HashMap<String, Object>();

    /**
     * Creates a new instance of OpbDynamicDataViewImpl.
     */
    public OpbDynamicDataViewImpl() {
        logger.entering(CLASS_NAME, "OpbDynamicDataViewImpl()");

    } // End of OpbDynamicDataViewImpl()

    /**
     * Returns a String representation of this instance and it's values.
     *
     * @return String representation of this OpbDynamicDataViewImpl.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Loads this 'view' with the data in the current row of the result set
     * converting column names (SQL names) to Java names.
     * <br/>
     * Java names are created by splitting the SQL name into bits separated by
     * underscores and putting the bits back together (without the underscores).
     * All characters of the Java name are lower case except for the first
     * character of any bit other than the first bit.
     *
     * <pre>
     * SQL Name     Java Name   Comment
     * ------------ ----------- ------------------------------------------------
     * name_2       name2       remove underscore
     * name2        name2
     * name_two     nameTwo     upper case first character of 2nd bit
     * nameTwo      nametwo     lower case the lot (no underscores in SQL name)
     * NAME_2       name2       SQL names are converted to lower case
     * NAME_TWO     nameTwo
     * name__2      name2       double underscore in SQL name
     * NAME___TWO   nameTwo     tripple underscore in SQL name
     * a_b_c        aBC
     * name_two_b   nameTwoB    upper case first character of 2nd and 3rd bit
     * </pre>
     *
     * @throws NullPointerException
     *   If resultSet is null.
     * @throws OpbDataAccessException
     *   If we fail to load this view.
     * @param resultSet
     *   The result set from which values can be taken to load this view.
     */
    public void opbLoad(final ResultSet resultSet)
    throws OpbDataAccessException, NullPointerException {
        final String methodName = "opbLoad(ResultSet resultSet)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "resultSet", resultSet);

        // clear any previously loaded values
        valuesMap.clear();

        logger.logp(Level.FINER, CLASS_NAME, methodName, "cleared valuesMap");

        try {
            ResultSetMetaData metadata = resultSet.getMetaData();

            logger.logp(Level.FINER, CLASS_NAME, methodName, "got metadata");

            int columnCount = metadata.getColumnCount();

            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "columnCount={0}", columnCount);

            // for every column in the result set, save the column name
            // (converted to java name) and it's value in the values map
            for (int i = 1; i <= columnCount; i++) {
                logger.logp(Level.FINER, CLASS_NAME, methodName,
                        "getting values for column {0}", i);

                valuesMap.put(
                        sqlNameToJavaNameHelper.sqlNameToJavaName(metadata.getColumnName(i)),
                        resultSet.getObject(i));

            }

            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "all values loaded");

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("Failed to load", ex),
                    logger, CLASS_NAME, methodName);

        }

        // Note: Let the code that called this method close the result set

    } // End of opbLoad(ResultSet)

    /**
     * Returns the number of columns in the resultSet passed to
     * opbLoad(ResultSet).
     * @see #opbLoad(ResultSet)
     * @return
     *   The number of columns in the resultSet passed to opbLoad(ResultSet).
     */
    public int size() {
        return valuesMap.size();
    }

    /**
     * Returns true if opbLoad(ResultSet) has not yet been called or the last
     * call failed, false otherwise.
     * @see #opbLoad(ResultSet)
     * @return true
     *   If opbLoad(ResultSet) has not yet been called or the last call failed.
     */
    public boolean isEmpty() {
        return valuesMap.isEmpty();
    }

    /**
     * Returns true if opbLoad(ResultSet) was passed a result set that contained
     * a column that's name, when converted to a Java name, is the same as key.
     * @see #opbLoad(ResultSet)
     * @param key
     *   A java name for a column that may have been in the result set used to
     *   load this view.
     * @return
     *   true if opbLoad(ResultSet) was passed a result set that contained a
     *   column corresponding to key.
     */
    public boolean containsKey(final Object key) {
        return valuesMap.containsKey(key);
    }

    /**
     * Returns true if the current row of the result set passed to
     * opbLoad(ResultSet) contained a column that's value is the same a value,
     * false otherwise.
     * @see #opbLoad(ResultSet)
     * @param value
     *   A value of a column that may have been in the result set used to
     *   load this view.
     * @return
     *   true if the current row of the result set passed to opbLoad(ResultSet)
     *   contained a column that's value is the same a value.
     */
    public boolean containsValue(final Object value) {
        return valuesMap.containsValue(value);
    }

    /**
     * Returns the value of the column that's name, when converted to a Java
     * name, is the same as key.
     * Returns null if this view does not contain the specified column.
     * @param key
     *   The Java name for a column that may have been in the result set used to
     *   load this view.
     * @return
     *   The value of the column that's name, when converted to a Java
     *   name, is the same as key.
     */
    public Object get(final Object key) {
        return valuesMap.get(key);
    }

    /**
     * Does nothing except return null as the data of this view should not be
     * changed once loaded.
     * @param key n/a
     * @param value n/a
     * @return n/a
     */
    public Object put(final Object key, final Object value) {
        logger.logp(Level.WARNING, CLASS_NAME,
                "put(Object, Object)", "does nothing");
        return null;
    }

    /**
     * Does nothing except return null as the data of this view should not be
     * changed once loaded.
     * @param key n/a
     * @return n/a
     */
    public Object remove(final Object key) {
        logger.logp(Level.WARNING, CLASS_NAME,
                "remove(Object)", "does nothing");
        return null;
    }

    /**
     * Does nothing as the data of this view should not be changed once loaded.
     * @param m n/a
     */
    public void putAll(final Map m) {
        logger.logp(Level.WARNING, CLASS_NAME, "putAll(Map)", "does nothing");
    }

    /**
     * Does nothing as the data of this view should not be changed once loaded.
     */
    public void clear() {
        logger.logp(Level.WARNING, CLASS_NAME, "clear", "does nothing");
    }

    /**
     * Returns the names of all columns in the resultSet passed to
     * opbLoad(ResultSet).
     * Note: These names will be in Java name format.
     *
     * @see #opbLoad(ResultSet)
     * @return
     *   The names of all columns in the resultSet passed to opbLoad(ResultSet).
     */
    public Set<String> keySet() {
        return valuesMap.keySet();
    }

    /**
     * Returns the values of all columns in the resultSet passed to
     * opbLoad(ResultSet).
     * @see #opbLoad(ResultSet)
     * @return
     *   The values of all columns in the resultSet passed to
     *   opbLoad(ResultSet).
     */
    public Collection<Object> values() {
        return valuesMap.values();
    }

    /**
     * Returns the names and values of all columns in the resultSet passed to
     * opbLoad(ResultSet).
     * @see #opbLoad(ResultSet)
     * @return
     *   The names and values of all columns in the resultSet passed to
     *   opbLoad(ResultSet).
     */
    public Set<Map.Entry<String, Object>> entrySet() {
        return valuesMap.entrySet();
    }

} // End of class OpbDynamicDataViewImpl
