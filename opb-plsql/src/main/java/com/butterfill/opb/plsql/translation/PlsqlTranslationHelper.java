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

import com.butterfill.opb.OpbConstants;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides methods that help when translating PL/SQL code to Java.
 * <br/>
 * This class is not intended for use outside the translation package.
 *
 * @author Peter Butterfill
 */
class PlsqlTranslationHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PlsqlTranslationHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Returns true if the specified type is of JDBC ARRAY type, false
     * otherwise.
     * @param sqlType
     *   The SQL type to test.
     * @return
     *   true if the specified type is of JDBC ARRAY type.
     * @see DatatypeMap#isArrayType(String)
     */
    boolean isArrayType(final String sqlType) {
        return DatatypeMap.getInstance().isArrayType(sqlType);
    }

    /**
     * Returns true if the specified type is a type of cursor, false otherwise.
     * @param sqlType
     *   The SQL type to test.
     * @return
     *   true if the specified type is a cursor type.
     * @see DatatypeMap#isCursorType(String)
     */
    boolean isCursorType(final String sqlType) {
        return DatatypeMap.getInstance().isCursorType(sqlType);
    }

    /**
     * Return true if the specified SQL or PL/SQL type is a PL/SQL index-by
     * table type, false otherwise.
     * @param sqlType
     *   The SQL type to test.
     * @return
     *   true if the specified type is a PL/SQL index-by table.
     * @see DatatypeMap#isPlsqlIndexTableType(String)
     */
    boolean isPlsqlIndexTableType(final String sqlType) {
        return DatatypeMap.getInstance().isPlsqlIndexTableType(sqlType);
    }

    /**
     * Returns true if the specified type will be converted to a Java type
     * that is loadable, false otherwise.
     * @param sqlType
     *   The SQL type to test. If sqlType is null, the default datatype defined
     *   in OpbConstants will be used.
     * @return
     *   true if the specified type will be converted to a loadable Java type.
     */
    boolean isLoadableType(final String sqlType) {
        return !isPlsqlIndexTableType(sqlType) &&
                !isCursorType(sqlType) &&
                !isArrayType(sqlType);
    }

    /**
     * Converts a SQL name into a camel-cased name.
     * @param sqlName
     *   The SQL name to convert.
     * @param firstCharLower
     *   Pass true if the first char of the name returned should be lower case
     *   (i.e. to return a field or method name).
     *   Pass false if the first char of the name returned should be upper case
     *   (i.e. to return a class name).
     * @return
     *   A Java name for the specified SQL name.
     */
    private String toJavaName(String sqlName, final boolean firstCharLower) {
        if (sqlName.startsWith("\"") &&
                sqlName.endsWith("\"")) {
            sqlName = sqlName.substring(1, sqlName.length() - 1);
        }

        String[] nameBits = sqlName.toLowerCase().split("_");

        StringBuilder sb = new StringBuilder();

        boolean firstBit = true;

        for (String bit : nameBits) {
            if (firstCharLower && firstBit) {
                firstBit = false;
                sb.append(bit);

            } else if (bit.length() > 0) {
                sb.append(bit.substring(0, 1).toUpperCase());
                if (bit.length() > 1) {
                    sb.append(bit.substring(1));

                }

            }

        } // End of for (String bit : nameBits)

        return sb.toString();
    }

    /**
     * Returns a Java member name for the specified SQL name.
     * @param sqlName
     *   The SQL name to convert.
     * @return
     *   A Java member name.
     */
    String toJavaMemberName(final String sqlName) {
        return toJavaName(sqlName, true);
    }

    /**
     * Returns a Java class (or interface) name for the specified SQL name.
     * @param sqlName
     *   The SQL name to convert.
     * @return
     *   A Java class name.
     */
    String toJavaClassName(final String sqlName) {
        return toJavaName(sqlName, false);
    }

    /**
     * Returns a Java constant name for the specified SQL name.
     * @param sqlName
     *   The SQL name to convert.
     * @return
     *   A Java constant name.
     */
    String toJavaConstantName(String sqlName) {
        if (sqlName.startsWith("\"") &&
                sqlName.endsWith("\"")) {
            sqlName = sqlName.substring(1, sqlName.length() - 1);
        }
        return sqlName.toUpperCase();
    }

    /**
     * Returns the Java literal for the specified SQL literal.
     * @param sqlLiteral
     *   The SQL literal to convert.
     * @param sqlDatatype
     *   The SQL datatype of the literal to convert.
     * @return
     *   The Java literal for the specified SQL literal.
     */
    String toJavaLiteral(final String sqlLiteral, final String sqlDatatype) {
        final String methodName = "toJavaLiteral(String, String)";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "sqlLiteral={0}, sqlDatatype={1}",
                new Object[]{sqlLiteral, sqlDatatype});

        if (sqlLiteral == null || "null".equalsIgnoreCase(sqlLiteral)) {
            return "null";
        }

        // get the Java type for the given SQL type
        String datatype = toJavaDatatype(sqlDatatype);

        String result;

        if ("String".equals(datatype) ||
                "java.lang.String".equals(datatype)) {

            String s = sqlLiteral;

            if (sqlLiteral.startsWith("'") &&
                    sqlLiteral.endsWith("'")) {
                s = sqlLiteral.substring(1, sqlLiteral.length() - 1);

            }

            result = "\"" + s.replaceAll("\"", "\\\\\"") + "\"";

        } else if ("Long".equals(datatype) ||
                "java.lang.Long".equals(datatype)) {
            result = sqlLiteral + "L";

        } else if ("Float".equals(datatype) ||
                "java.lang.Float".equals(datatype)) {
            result = sqlLiteral + "F";

        } else if ("BigDecimal".equals(datatype) ||
                "java.math.BigDecimal".equals(datatype)) {
            result = "java.math.BigDecimal.valueOf(" + sqlLiteral + ")";

        } else if ("Boolean".equals(datatype) ||
                "java.lang.Boolean".equals(datatype)) {
            result = sqlLiteral.toLowerCase();

        } else {
            result = sqlLiteral;

        }

        logger.exiting(CLASS_NAME, methodName, result);

        return result;

    } // End of toJavaLiteral(String, String)

    /**
     * Returns the type of element of the Java collection (if the SQL datatype
     * would be converted to a Java collection type).
     * If the SQL datatype would not be converted to a Java collection type,
     * null is returned.
     * @param sqlDatatype
     *   The SQL type to convert.
     * @return
     *   The type of element of the Java collection.
     */
    String getElementType(String sqlDatatype) {
        DatatypeMap datatypeMap = DatatypeMap.getInstance();

        if (sqlDatatype == null) {
            sqlDatatype = OpbConstants.DEFAULT_DATATYPE;
        }

        if (datatypeMap.isCursorType(sqlDatatype)) {
            int delimPos = sqlDatatype.indexOf("?");

            if (delimPos == -1) {
                return OpbConstants
                        .DEFAULT_ENTITY
                        .replaceFirst("com.butterfill.opb.data.", "");

            } else {
                return toJavaClassName(sqlDatatype.substring(delimPos + 1));

            }

        }

        return null;

    }

    /**
     * Returns the JDBC type of the specified SQL type.
     * @param sqlDatatype
     *   The SQL type to convert. If sqlType is null, the default datatype
     *   defined in OpbConstants will be used.
     * @return
     *   The JDBC type of the specified SQL type.
     */
    String getJdbcType(String sqlDatatype) {
        final String methodName = "getJdbcType(String)";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "sqlDatatype={0}", sqlDatatype);

        DatatypeMap datatypeMap = DatatypeMap.getInstance();

        if (sqlDatatype == null) {
            sqlDatatype = OpbConstants.DEFAULT_DATATYPE;

        } else {
            int delimPos = sqlDatatype.indexOf("?");

            if (delimPos != -1) {
                sqlDatatype = sqlDatatype.substring(0, delimPos);

            }

        }

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "converting {0}", sqlDatatype);

        return datatypeMap.sqlToJdbc(sqlDatatype);

    }

    /**
     * Returns the Java type of the specified SQL type.
     * @param sqlDatatype
     *   The SQL type to convert. If sqlType is null, the default datatype
     *   defined in OpbConstants will be used.
     * @return
     *   The Java type of the specified SQL type.
     */
    String toJavaDatatype(String sqlDatatype) {
        DatatypeMap datatypeMap = DatatypeMap.getInstance();

        if (sqlDatatype == null) {
            sqlDatatype = OpbConstants.DEFAULT_DATATYPE;
        }

        if (datatypeMap.isCursorType(sqlDatatype)) {
            StringBuilder sb = new StringBuilder();

            int delimPos = sqlDatatype.indexOf("?");

            if (delimPos == -1) {
                sb.append(datatypeMap.sqlToJava(sqlDatatype));
                sb.append("<");
                sb.append(OpbConstants
                        .DEFAULT_ENTITY
                        .replaceFirst("com.butterfill.opb.data.", ""));
                sb.append(">");

            } else {
                String[] bits = new String[2];
                bits[0] = sqlDatatype.substring(0, delimPos);
                bits[1] = sqlDatatype.substring(delimPos + 1);
                sb.append(datatypeMap.sqlToJava(bits[0]));
                sb.append("<");
                sb.append(toJavaClassName(bits[1]));
                sb.append(">");

            }

            return sb.toString();

        }

        return datatypeMap.sqlToJava(sqlDatatype);

    } // End of toJavaDatatype(String)

    /**
     * Returns the Java type of the specified SQL type taking parameter mode
     * into account.
     * Out parameters need to be wrapped.
     * @param sqlDatatype
     *   The SQL type to convert. If sqlType is null, the default datatype
     *   defined in OpbConstants will be used.
     * @param isOutParam
     *   Pass true if converting the datatype of an out parameter,
     *   false otehrwise.
     * @return
     *   The Java type of the specified SQL type.
     */
    String toJavaDatatype(final String sqlDatatype, final boolean isOutParam) {
        final String methodName = "toJavaDatatype(String, boolean)";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "sqlDatatype={0}, isOutParam={1}",
                new Object[]{sqlDatatype, isOutParam});

        if (isOutParam) {
            return OpbConstants
                    .DEFAULT_VALUE_WRAPPER
                    .replaceFirst("com.butterfill.opb.util.", "");

        } else {
            return toJavaDatatype(sqlDatatype);

        }

    }

    /**
     * Converts a string to boolean.
     *
     * @param yOrN
     *   y and Y will return true, n and N will return false and any other
     *   value will cause valueIfNotYOrN to be returned.
     * @param valueIfNotYOrN
     *   The value to return if yOrN is not y, Y, n or N.
     * @return
     *   The boolean value for the specified string.
     */
    Boolean toBoolean(final String yOrN, final Boolean valueIfNotYOrN) {
        final String methodName = "toBoolean(String, boolean)";

        logger.entering(CLASS_NAME, methodName);

        if ("Y".equalsIgnoreCase(yOrN) ||
                "N".equalsIgnoreCase(yOrN)) {
            return "Y".equalsIgnoreCase(yOrN);
        }

        logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                "Expected y, Y, n or N. found {0}", yOrN);

        return valueIfNotYOrN;

    }

}
