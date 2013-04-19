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

package com.butterfill.opb.plsql.translation;

import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;

/**
 * Represents a parameter of a PL/SQL call. This could be either a formal
 * parameter or a function return value.
 * <br/>
 * This class is not intended for use outside the translation package.
 *
 * @author Peter Butterfill
 */
class PlsqlCallParameter {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PlsqlCallParameter.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The index of the parameter. e.g. 1 for function return or the first
     * parameter of a procedure.
     */
    private int index;

    /**
     * The SQL name of this parameter.
     */
    private String sqlName;

    /**
     * The Java name of this parameter.
     */
    private String name;

    /**
     * The name of the field that this parameter is mapped to.
     * This will be the Java property name in Java class name format so that
     * getters and setters can be created by prepending get or set.
     */
    private String mappedTo;

    /**
     * The name of the Java property that this parameter is mapped to.
     */
    private String mappedToProperty;

    /**
     * The SQL datatype of this parameter. This may be set in the Opb comment
     * for the call.
     */
    private String sqlDatatype;

    /**
     * The actual SQL datatype of this parameter. This will not be overridden
     * by the Opb comment.
     */
    private String originalSqlDatatype;

    /**
     * The Java datatype of this parameter.
     */
    private String datatype;

    /**
     * The type of element contained in the collection - if the datatype of this
     * parameter is of collection type.
     */
    private String elementTypeOfDatatype;

    /**
     * The JDBC type of this parameter.
     */
    private String jdbcType;

    /**
     * Out parameters will be wrapped. This will hold the datatype wrapped by
     * the value wrapper.
     */
    private String wrappedDatatype;

    /**
     * Set to true of this parameter is a JDBC ARRAY.
     */
    private boolean array;

    /**
     * Set to true if this parameter is a cursor.
     */
    private boolean cursor;

    /**
     * Set to true if this parameter is a PL/SQL index-by table.
     */
    private boolean plsqlTable;

    /**
     * Set to true if this is an IN parameter.
     */
    private boolean  in;

    /**
     * Set to true if this is an OUT parameter.
     */
    private boolean  out;

    /**
     * Set to true if this parameter should use the data object cache.
     */
    private Boolean useDataObjectCache;

    /**
     * Set to true if this parameter should use the result cache.
     */
    private Boolean useResultCache;

    /**
     * Set to true if this parameter should use the scalar result cache.
     */
    private Boolean useScalarResultCache;

    /**
     * The translation helper used by this class.
     */
    private final PlsqlTranslationHelper translationHelper =
            new PlsqlTranslationHelper();


    /**
     * Creates a new PlsqlCallParameter.
     * @param sqlName
     *   The SQL name of this parameter.
     * @param sqlDatatype
     *   The SQL datatype of this parameter. This will be saved as the original
     *   SQL datatype.
     * @param in
     *   Pass true if this is an IN parameter, false otherwise.
     * @param out
     *   Pass true if this is an OUT parameter, false otherwise.
     */
    public PlsqlCallParameter(final String sqlName, final String sqlDatatype,
            final boolean in, final boolean out) {
        this.sqlName = sqlName;
        name = translationHelper.toJavaMemberName(sqlName);

        this.in = in;
        this.out = out;

        originalSqlDatatype = sqlDatatype;

        opb_datatype(sqlDatatype);

    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this PlsqlCallParameter.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns true if this is the return parameter of a function, false
     * otherwise.
     * @return true if this is the return parameter of a function.
     */
    public boolean isReturn() {
        return "RETURN".equalsIgnoreCase(sqlName);
    }

    /**
     * Sets the name property of this parameter.
     * <br/>
     * This method is a no-op as the SQL name is set by the constructor.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_name(final String s) {
    }

    /**
     * Sets the datatype property of this parameter.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_datatype(final String s) {
        sqlDatatype = (s == null) ? s : s.toUpperCase();
        datatype = translationHelper.toJavaDatatype(sqlDatatype, out);
        jdbcType = translationHelper.getJdbcType(sqlDatatype);
        if (out) {
            wrappedDatatype = translationHelper.toJavaDatatype(sqlDatatype);
        }
        elementTypeOfDatatype = translationHelper.getElementType(sqlDatatype);
        array = translationHelper.isArrayType(sqlDatatype);
        cursor = translationHelper.isCursorType(sqlDatatype);
        plsqlTable = translationHelper.isPlsqlIndexTableType(sqlDatatype);

    }

    /**
     * Sets the field property of this parameter.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_field(final String s) {
        mappedTo = translationHelper.toJavaClassName(s);
        mappedToProperty = translationHelper.toJavaMemberName(s);
    }

    /**
     * Sets the use_result_cache property of this parameter.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_use_result_cache(final String s) {
        useResultCache = translationHelper.toBoolean(s, useResultCache);
    }

    /**
     * Sets the use_scalar_result_cache property of this parameter.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_use_scalar_result_cache(final String s) {
        useScalarResultCache =
                translationHelper.toBoolean(s, useScalarResultCache);

    }

    /**
     * Sets the use_data_object_cache property of this parameter.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_use_data_object_cache(final String s) {
        useDataObjectCache =
                translationHelper.toBoolean(s, useDataObjectCache);
    }

    /**
     * Returns the index of this parameter.
     * @return The index of this parameter.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the index of this parameter.
     * @param index The index of this parameter.
     */
    public void setIndex(final int index) {
        this.index = index;
    }

    /**
     * Returns the SQL name of this parameter.
     * @return The SQL name of this parameter.
     */
    public String getSqlName() {
        return sqlName;
    }

    /**
     * Returns the Java name of this parameter.
     * @return The Java name of this parameter.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the SQL datatype of this parameter.
     * @return The SQL datatype of this parameter.
     */
    public String getSqlDatatype() {
        return sqlDatatype;
    }

    /**
     * Returns the Java datatype of this parameter.
     * @return The Java datatype of this parameter.
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * Returns the true if this is an IN parameter, false otherwise.
     * @return true if this is an IN parameter.
     */
    public boolean getIn() {
        return in;
    }

    /**
     * Returns the true if this is an OUT parameter, false otherwise.
     * @return true if this is an OUT parameter.
     */
    public boolean getOut() {
        return out;
    }

    /**
     * Returns true if this parameter has been configured to use the data object
     * cache, false if this parameter has been configured to not use the data
     * object cache, null otherwise.
     *
     * @return
     *   true if this parameter has been configured to use the data object
     *   cache, false if this parameter has been configured to not use the data
     *   object cache, null otherwise.
     */
    public Boolean isUseDataObjectCache() {
        return useDataObjectCache;
    }

    /**
     * Sets the value for use data object cache directly.
     * This method is not intended for use outside this package.
     * @param value The new value for use data object cache.
     */
    void setUseDataObjectCache(final boolean value) {
        this.useDataObjectCache = value;
    }

    /**
     * Returns true if this parameter has been configured to use the result
     * cache, false if this parameter has been configured to not use the result
     * cache, null otherwise.
     *
     * @return
     *   true if this parameter has been configured to use the result cache,
     *   false if this parameter has been configured to not use the result
     *   cache, null otherwise.
     */
    public Boolean isUseResultCache() {
        return useResultCache;
    }

    /**
     * Sets the value for use result cache directly.
     * This method is not intended for use outside this package.
     * @param value The new value for use result cache.
     */
    void setUseResultCache(final boolean value) {
        this.useResultCache = value;
    }

    /**
     * Returns true if this parameter has been configured to use the scalar
     * result cache,
     * false if this parameter has been configured to not use the scalar result
     * cache,
     * null otherwise.
     *
     * @return
     *   true if this parameter has been configured to use the scalar result
     *   cache,
     *   false if this parameter has been configured to not use the scalar
     *   result cache,
     *   null otherwise.
     */
    public Boolean isUseScalarResultCache() {
        return useScalarResultCache;
    }

    /**
     * Sets the value for use scalar result cache directly.
     * This method is not intended for use outside this package.
     * @param value The new value for use scalar result cache.
     */
    void setUseScalarResultCache(final boolean value) {
        this.useScalarResultCache = value;
    }

    /**
     * Returns the wrapped datatype of this parameter.
     * @return The wrapped datatype of this parameter.
     */
    public String getWrappedDatatype() {
        return wrappedDatatype;
    }

    /**
     * Returns the JDBC type of this parameter.
     * @return The JDBC type of this parameter.
     */
    public String getJdbcType() {
        return jdbcType;
    }

    /**
     * Returns the name of the field that this parameter is mapped to.
     * This will be the Java property name in Java class name format so that
     * getters and setters can be created by prepending get or set.
     * @return The name of the field that this parameter is mapped to.
     */
    public String getMappedTo() {
        return mappedTo;
    }

    /**
     * Returns the name of the Java property that this parameter is mapped to.
     * @return The name of the Java property that this parameter is mapped to.
     */
    public String getMappedToProperty() {
        return mappedToProperty;
    }

    /**
     * Returns the element type of this parameter.
     * @return The element type of this parameter.
     */
    public String getElementTypeOfDatatype() {
        return elementTypeOfDatatype;
    }

    /**
     * Returns true if this parameter is of JDBC ARRAY type, false otherwise.
     * @return true if this parameter is of JDBC ARRAY type, false otherwise.
     */
    public boolean isArray() {
        return array;
    }

    /**
     * Returns true if this parameter is of cursor type, false otherwise.
     * @return true if this parameter is of cursor type.
     */
    public boolean isCursor() {
        return cursor;
    }

    /**
     * Returns true if this parameter is of PL/SQL index-by table type, false
     * otherwise.
     * @return true if this parameter is of PL/SQL index-by table type.
     */
    public boolean isPlsqlIndexTable() {
        return plsqlTable;
    }

    /**
     * Returns the SQL datatype of this parameter as set by the constructor.
     * This value will not be overridden by the Opb comment of the call.
     * @return The original SQL datatype of this parameter.
     */
    public String getOriginalSqlDatatype() {
        return originalSqlDatatype;
    }

}
