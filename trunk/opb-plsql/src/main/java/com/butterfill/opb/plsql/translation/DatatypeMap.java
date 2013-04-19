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
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles datatype mappings for SQL to Java translation.
 * Most importantly this class can return JDBC and Java datatypes for a given
 * SQL datatype.
 * <br/>
 * <br/>
 * Two kinds of datatype are understood by the translator;
 * <ul>
 *   <li>
 *     Simple datatypes that map directly to a Java datatype.
 *     <ul>
 *       <li>
 *         e.g. VARCHAR2 could map to the Java datatype String and user_sys_priv
 *         could map to the Java datatype UserSysPriv.
 *       </li>
 *     </ul>
 *   </li>
 *   <li>
 *     Two-part datatypes that tell the translator what kind of object can be
 *     created from the data in a cursor.
 *     <ul>
 *       <li>
 *         e.g. cursor?user_sys_priv could map to the Java datatype
 *         List&lt;UserSysPriv>.
 *       </li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * This class uses a
 * <a href="doc-files/datatypeMap.txt">default datatype map</a>
 * which can be overridden via the initDatatypeMap(InputStream) method.
 *
 * @see #initDatatypeMap(InputStream)
 *
 * @author Peter Butterfill
 */
public final class DatatypeMap {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = DatatypeMap.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The single instance of this class.
     */
    private static final DatatypeMap INSTANCE = new DatatypeMap();

    /**
     * A list of SQL to JDBC to Java datatype mappings.
     */
    private final List<SqlJdbcJavaMap> sqlJdbcJavaMappings =
            new ArrayList<SqlJdbcJavaMap>();

    /**
     * A list of PL/SQL to SQL datatype mappings.
     */
    private final List<PlsqlSqlMap> plsqlSqlMappings = new ArrayList<PlsqlSqlMap>();

    /**
     * The JDBC cursor data type.
     */
    private String jdbcCursorType;

    /**
     * A list of all PL/SQL index table types.
     */
    private final List<String> plsqlIndexTableTypes = new ArrayList<String>();

    /**
     * Creates a new instance of DatatypeMap reading the default datatype map.
     */
    private DatatypeMap() {
        logger.entering(CLASS_NAME, "DatatypeMap()");

        initDatatypeMap();

    } // End of DatatypeMap()

    /**
     * Returns a String representation of this DatatypeMap and it's values.
     * @return String representation of this DatatypeMap
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the single instance of this class.
     * <br/>
     * If initDatatypeMap(InputStream) has not been called on this instance,
     * the DatatypeMap returned will be loaded with the default datatype map.
     * @see #initDatatypeMap(InputStream)
     * @return The single instance of this class.
     */
    public static DatatypeMap getInstance() {
        return INSTANCE;
    }

    /**
     * Initializes or re-initializes this DatatypeMap using the default datatype map.
     *
     * @throws RuntimeException
     *   If we fail to initialize the DatatypeMap.
     */
    public void initDatatypeMap() throws RuntimeException {
        logger.entering(CLASS_NAME, "initDatatypeMap()");

        initDatatypeMap(getClass().getResourceAsStream("datatypeMap.txt"));

    }

    /**
     * Initializes or re-initializes this DatatypeMap.
     *
     * The input stream should contain data in the following format;
     * <pre>
     * sql-jdbc-java;
     * [SQL type] [JDBC type] [Java type]
     *
     * jdbc-cursor-type;
     * [JBDC type for accessing cursors]
     *
     * plsql-index-table-types;
     * [SQL type that is a PL/SQL index-by table]
     *
     * plsql-sql;
     * [PL/SQL type] [SQL type]
     *
     * comments;
     * [Any number of comments]
     * </pre>
     *
     * The lines following sql-jdbc-java; should contain SQL to JDBC to Java
     * type mappings. e.g.
     * <pre>
     * sql-jdbc-java;
     * VARCHAR2    java.sql.Types.VARCHAR          String
     * NUMBER      java.sql.Types.DECIMAL          java.math.BigDecimal
     * </pre>
     *
     * The line following jdbc-cursor-type; should contain the JDBC type that
     * can be used to access cursors (result sets in Java). e.g.
     * <pre>
     * jdbc-cursor-type;
     * oracle.jdbc.OracleTypes.CURSOR
     * </pre>
     *
     * The lines following plsql-index-table-types; should contain SQL types
     * that are PL/SQL index-by tables.
     * The SQL types used here should all have entries in the sql-jdbc-java
     * section. e.g.
     * <pre>
     * plsql-index-table-types;
     * VARCHAR2[]
     * NUMBER[]
     * </pre>
     *
     * The lines following plsql-sql; should contain PL/SQL to SQL type
     * mappings. The SQL types used here should all have entries in the
     * sql-jdbc-java section. e.g.
     * <pre>
     * plsql-sql;
     * ROWID           VARCHAR2
     * DECIMAL         NUMBER
     * </pre>
     *
     * The lines following comments; can contain anything.
     * <br/>
     * <br/>
     * It's not possible to directly map the PL/SQL boolean type to a JDBC type.
     * Some classes give the Boolean type special treatment in order to pass
     * boolean data between Java and PL/SQL as text.
     * com.butterfill.opb.plsql.OpbPlsqlCallHelper and OpbSqlHelper
     * (of opb-library) are two of these classes and they both use
     * com.butterfill.opb.util.OpbBooleanHelper (of opb-library) to handle the
     * conversions.
     * <br/>
     * <br/>
     * DATE mapped to java.sql.Types.DATE passes dates with no time.
     * <br/>
     * DATE mapped to java.sql.Types.TIME passes time with date components set
     * to the "zero epoch" value of January 1, 1970.
     * <br/>
     * <br/>
     * Opb can't do datatypes with spaces yet. e.g. TIMESTAMP WITH TIME ZONE
     * or TIMESTAMP WITH LOCAL TIME ZONE.
     * <br/>
     * <br/>
     * It is possible to use datatypes with spaces by using PL/SQL subtypes.
     * e.g.
     * <pre>
     * CREATE OR REPLACE PACKAGE demo
     * IS
     *   SUBTYPE timestamp_tz IS TIMESTAMP WITH TIME ZONE;
     *   SUBTYPE timestamp_ltz IS TIMESTAMP WITH LOCAL TIME ZONE;
     *
     *   PROCEDURE demo_procedure(
     *     a IN timestamp_tz,
     *     b IN timestamp_ltz);
     *
     * END demo;
     *
     * sql-jdbc-java;
     * timestamp_tz   oracle.jdbc.OracleTypes.TIMESTAMPTZ   java.sql.Timestamp
     * timestamp_ltz  oracle.jdbc.OracleTypes.TIMESTAMPLTZ  java.sql.Timestamp
     * </pre>
     * <a href="doc-files/datatypeMap.txt">
     *   Please find the default datatype map here.
     * </a>
     *
     * @param inputStream
     *   An input stream containing data type mapping data.
     * @throws RuntimeException
     *   If we fail to initialize the DatatypeMap.
     */
    public void initDatatypeMap(final InputStream inputStream)
            throws RuntimeException {
        final String methodName = "initDatatypeMap(InputStream)";

        logger.entering(CLASS_NAME, methodName);

        sqlJdbcJavaMappings.clear();

        plsqlSqlMappings.clear();

        jdbcCursorType = null;

        plsqlIndexTableTypes.clear();

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "inputStream", inputStream);

        BufferedReader in = null;

        try {
            in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            int reading = 0;

            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.length() > 0) {
                    if (line.trim().equals("sql-jdbc-java;")) {
                        reading = 1;
                    } else if (line.trim().equals("plsql-sql;")) {
                        reading = 2;
                    } else if (line.trim().equals("comments;")) {
                        reading = 3;
                    } else if (line.trim().equals("jdbc-cursor-type;")) {
                        reading = 4;
                    } else if (line.trim().equals("plsql-index-table-types;")) {
                        reading = 5;
                    } else {
                        // no need for a default
                        // if we don't know what we're reading, ignore it
                        switch (reading) {
                            case 1:
                                sqlJdbcJavaMappings.add(new SqlJdbcJavaMap(line));
                                break;

                            case 2:
                                plsqlSqlMappings.add(new PlsqlSqlMap(line));
                                break;

                            case 4:
                                jdbcCursorType = line.trim();
                                break;

                            case 5:
                                plsqlIndexTableTypes.add(
                                        line.trim().toUpperCase());

                        } // End of switch (reading)

                    }

                } // End of if (line.length() > 0)

            } // End of for (String line = in.readLine() ...

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new RuntimeException("Failed to initialize the DatatypeMap", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            close(in);

        }

    }

    /**
     * Returns the SqlJdbcJavaMap for a given SQL or PL/SQL type.
     *
     * @param s A SQL or PL/SQL type.
     * @return The SqlJdbcJavaMap for the specified SQL type.
     */
    private SqlJdbcJavaMap getSqlJdbcJavaMapBySql(final String s) {
        for (SqlJdbcJavaMap m : sqlJdbcJavaMappings) {
            if (m.sql.equalsIgnoreCase(s)) {
                return m;
            }
        }
        final PlsqlSqlMap plsqlSqlMap = getPlsqlSqlMapByPlsql(s);
        if (plsqlSqlMap != null) {
            for (SqlJdbcJavaMap m : sqlJdbcJavaMappings) {
                if (m.sql.equalsIgnoreCase(plsqlSqlMap.sql)) {
                    return m;
                }
            }
        }
        return null;
    }

    /**
     * Returns the SqlJdbcJavaMap for a given JDBC type.
     *
     * @param s A JDBC type.
     * @return The SqlJdbcJavaMap for the specified JDBC type.
     */
    private SqlJdbcJavaMap getSqlJdbcJavaMapByJdbc(final String s) {
        for (SqlJdbcJavaMap m : sqlJdbcJavaMappings) {
            if (m.jdbc.equalsIgnoreCase(s)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Returns the SqlJdbcJavaMap for a given Java type.
     *
     * @param s A Java type.
     * @return The SqlJdbcJavaMap for the specified Java type.
     */
    private SqlJdbcJavaMap getSqlJdbcJavaMapByJava(final String s) {
        for (SqlJdbcJavaMap m : sqlJdbcJavaMappings) {
            if (m.java.equalsIgnoreCase(s)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Returns the PlsqlSqlMap for a given PL/SQL type.
     *
     * @param s A PL/SQL type.
     * @return The PlsqlSqlMap for the specified PL/SQL type.
     */
    private PlsqlSqlMap getPlsqlSqlMapByPlsql(final String s) {
        for (PlsqlSqlMap m : plsqlSqlMappings) {
            if (m.plsql.equalsIgnoreCase(s)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Return true if the specified SQL or PL/SQL type is mapped to the JDBC
     * type java.sql.Types.ARRAY, false otherwise.
     * <br/>
     * Note: This method will not split a two-part datatype.
     * @return true if the specified SQL or PL/SQL type is mapped to ARRAY.
     * @param sqlType
     *   A SQL or PL/SQL type. If sqlType is null, the default datatype defined
     *   in OpbConstants will be used.
     */
    public boolean isArrayType(String sqlType) {
        final String methodName = "isArrayType(String)";

        logger.entering(CLASS_NAME, methodName);

        sqlType = (sqlType == null) ?
                OpbConstants.DEFAULT_DATATYPE : sqlType;

        SqlJdbcJavaMap map = getSqlJdbcJavaMapBySql(sqlType);
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "map={0}", map);

        boolean result = false;

        if (map == null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "The SQL type '{0}' has not been mapped", sqlType);

        } else {
            result = "java.sql.Types.ARRAY".equals(map.jdbc);

        }

        logger.exiting(CLASS_NAME, methodName, result);

        return result;

    }

    /**
     * Return true if the specified SQL or PL/SQL type is mapped to Boolean,
     * false otherwise.
     * <br/>
     * Note: This method will not split a two-part datatype.
     * @return true if the specified SQL or PL/SQL type is mapped to Boolean.
     * @param sqlType
     *   A SQL or PL/SQL type. If sqlType is null, the default datatype defined
     *   in OpbConstants will be used.
     */
    public boolean isBooleanType(String sqlType) {
        final String methodName = "isBooleanType(String)";

        logger.entering(CLASS_NAME, methodName);

        sqlType = (sqlType == null) ?
                OpbConstants.DEFAULT_DATATYPE : sqlType;

        final SqlJdbcJavaMap map = getSqlJdbcJavaMapBySql(sqlType);
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "map={0}", map);

        boolean result = false;

        if (map == null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "The SQL type '{0}' has not been mapped", sqlType);

        } else {
            result = "Boolean".equals(map.java);

        }

        logger.exiting(CLASS_NAME, methodName, result);

        return result;

    }

    /**
     * Return true if the JDBC type mapped to the specified SQL or PL/SQL type
     * is the JDBC cursor type, false otherwise.
     * <br/>
     * Note: Only the first part of a two-part datatype is used.
     * i.e. Passing cursor to this method would give the same results as
     * passing cursor?anything_else.
     * @return true if the JDBC type mapped to the specified SQL or PL/SQL type
     * is the JDBC cursor type.
     * @param sqlType
     *   A SQL or PL/SQL type. If sqlType is null, the default datatype defined
     *   in OpbConstants will be used.
     * @throws NullPointerException
     *   If _jdbcCursorType is null.
     */
    public boolean isCursorType(String sqlType) throws NullPointerException {
        final String methodName = "isCursorType(String)";

        logger.entering(CLASS_NAME, methodName);

        sqlType = (sqlType == null) ?
                OpbConstants.DEFAULT_DATATYPE : sqlType;

        OpbAssert.notNull(
                logger,
                CLASS_NAME,
                methodName,
                "jdbcCursorType",
                jdbcCursorType,
                "You can't call isCursorType(String) when the JDBC cursor has not been set");

        // If the object type of the cursor has been specified, remove it.
        // e.g. datatype=cursor?user_sys_priv
        final int delimPos = sqlType.indexOf("?");

        if (delimPos != -1) {
            sqlType = sqlType.substring(0, delimPos);

        }

        final SqlJdbcJavaMap map = getSqlJdbcJavaMapBySql(sqlType);
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "map={0}", map);

        boolean result = false;

        if (map == null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "The SQL type '{0}' has not been mapped", sqlType);

        } else {
            result = jdbcCursorType.equals(map.jdbc);
        }

        logger.exiting(CLASS_NAME, methodName, result);

        return result;

    }

    /**
     * Return true if the specified SQL or PL/SQL type is a PL/SQL index-by
     * table type, false otherwise.
     * <br/>
     * Note: This method will not split a two-part datatype.
     * @return true
     *   If the specified SQL or PL/SQL type is a PL/SQL index-by table.
     * @param sqlType
     *   A SQL or PL/SQL type. If sqlType is null, the default datatype defined
     *   in OpbConstants will be used.
     */
    public boolean isPlsqlIndexTableType(String sqlType) {
        final String methodName = "isPlsqlIndexTableType(String)";

        logger.entering(CLASS_NAME, methodName);

        sqlType = (sqlType == null) ?
                OpbConstants.DEFAULT_DATATYPE : sqlType;

        sqlType = sqlType.toUpperCase();

        boolean result = plsqlIndexTableTypes.contains(sqlType);

        if (!result) {
            PlsqlSqlMap map = getPlsqlSqlMapByPlsql(sqlType);
            if (map != null) {
                result = plsqlIndexTableTypes.contains(map.sql);
            }
        }

        logger.exiting(CLASS_NAME, methodName, result);

        return result;

    }

    /**
     * Returns true if the specified type is a mapped SQL or PL/SQL type.
     * <br/>
     * Note: This method will not split a two-part datatype.
     * @param datatype A SQL or PL/SQL datatype.
     * @return true if the specified type is a mapped SQL or PL/SQL type.
     */
    public boolean isSqlDatatype(final String datatype) {
        return getSqlJdbcJavaMapBySql(datatype) != null;
    }

    /**
     * Returns the mapped JDBC type for the specified SQL or PL/SQL type.
     * <br/>
     * Note: This method will not split a two-part datatype.
     * @return The JDBC type for the given SQL type or null if the specified type is
     *   not mapped.
     * @param sqlType A SQL or PL/SQL datatype.
     */
    public String sqlToJdbc(final String sqlType) {
        final SqlJdbcJavaMap sqlJdbcJavaMap = getSqlJdbcJavaMapBySql(sqlType);
        if (sqlJdbcJavaMap != null) {
            return sqlJdbcJavaMap.jdbc;
        }
        return null;
    }

    /**
     * Returns the mapped Java type for the specified SQL or PL/SQL type.
     * <br/>
     * Note: This method will not split a two-part datatype.
     * @return
     *   The Java type for the given SQL type or
     *   null if the specified type is not mapped.
     * @param sqlType A SQL or PL/SQL datatype.
     */
    public String sqlToJava(final String sqlType) {
        final SqlJdbcJavaMap sqlJdbcJavaMap = getSqlJdbcJavaMapBySql(sqlType);
        if (sqlJdbcJavaMap != null) {
            return sqlJdbcJavaMap.java;
        }
        return null;
    }

    /**
     * Closes a closeable without throwing any exceptions.
     * @param closeable
     *   A closeable (could be null).
     */
    private void close(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception ignore) {
            }
        }
    }

    /**
     * Holds SQL to JDBC to Java datatype mappings.
     */
    private static class SqlJdbcJavaMap {

        /**
         * The SQL datatype.
         */
        private final String sql;

        /**
         * The JDBC type.
         */
        private final String jdbc;

        /**
         * The Java datatype.
         */
        private final String java;

        /**
         * Creates a new map from the specified data.
         *
         * @param data
         *   This string should consist of a SQL datatype, a JDBC type
         *   and a Java datatype separated by whitespace.
         */
        SqlJdbcJavaMap(final String data) {
            String[] bits = data.split("[\\s]+");
            sql = bits[0];
            jdbc = bits[1];
            java = bits[2];
        }

        /**
         * Returns a String representation of this Map and it's values.
         * @return A String representation of this Map and it's values.
         */
        @Override
        public String toString() {
            return OpbToStringHelper.toString(this);
        }

    }

    /**
     * Holds PL/SQL to SQL datatype mappings.
     */
    private static class PlsqlSqlMap {

        /**
         * The PL/SQL datatype.
         */
        private final String plsql;

        /**
         * The SQL datatype.
         */
        private final String sql;

        /**
         * Creates a new map from the specified data.
         *
         * @param data
         *   This string should consist of a PL/SQL datatype
         *   and a SQL datatype separated by whitespace.
         */
        PlsqlSqlMap(final String data) {
            String[] bits = data.split("[\\s]+");
            plsql = bits[0];
            sql = bits[1];
        }

        /**
         * Returns a String representation of this Map and it's values.
         * @return A String representation of this Map and it's values.
         */
        @Override
        public String toString() {
            return OpbToStringHelper.toString(this);
        }

    }

} // End of class DatatypeMap
