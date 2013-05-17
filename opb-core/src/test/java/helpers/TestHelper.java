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
package helpers;

import com.butterfill.opb.OpbId;
import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImpl;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbScalarResultCache;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 * opb-library
 *
 * @author Peter Butterfill
 */
public class TestHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = TestHelper.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * JDBC connection properties to be used when creating data sources.
     */
    private static final Properties _jdbcProperties = new Properties();

    /**
     * A data source that can be shared between tests.
     */
    private static final OracleDataSource _sharedOracleDataSource;

    /**
     * A connection that can be shared between tests.
     */
    private static Connection _sharedConnection;

    /**
     * An Opb session that can be shared between tests.
     */
    private static final OpbSession _sharedSession;

    /**
     * Initialise the shared connection, "creates" the shared session and
     * loads/sets JDBC properties.
     */
    static {
        logger.info("java.version=" + System.getProperty("java.version"));

        try {
            // load the properties from file
            _jdbcProperties.load(
                    TestHelper.class.getResourceAsStream("jdbc.properties"));
            // apply default values
            String[] keys = new String[]{
                "url",
                "user",
                "password"
            };
            String[] defaults = new String[]{
                "jdbc:oracle:thin:@//localhost:1521/xe",
                "opb_test",
                "weak_pw"
            };
            String[] notFound = new String[]{
                "${opb.test.jdbc.url}",
                "${opb.test.jdbc.user}",
                "${opb.test.jdbc.password}"
            };

            for (int i = 0; i < keys.length; i++) {
                if (notFound[i].equals(_jdbcProperties.get(keys[i]))) {
                    logger.logp(Level.INFO, CLASS_NAME, "static",
                            "{0} not found. using default {1}",
                            new Object[]{keys[i], defaults[i]});

                    _jdbcProperties.setProperty(keys[i], defaults[i]);

                } else {
                    logger.logp(Level.INFO, CLASS_NAME, "static", "{0}={1}",
                            new Object[]{keys[i], _jdbcProperties.get(keys[i])});

                }

            }

        } catch (Exception ex) {
            throw new RuntimeException("Failed to load jdbc.properties", ex);

        }

        // create the shared data source
        _sharedOracleDataSource = getOracleDataSource();

        // initialise the shared connection
        try {
            _sharedConnection = _sharedOracleDataSource.getConnection();

        } catch (Exception ex) {
            throw new RuntimeException(
                    "Failed to get connection from shared datasource", ex);

        }

        // create the shared session
        _sharedSession = getOpbSession();

    } // End of static

    /**
     * Returns a newly created data source using "jdbc.properties" loaded via
     * this classes class loader.
     * @return A newly created data source.
     */
    public static OracleDataSource getOracleDataSource() {
        final String _method = "getOracleDataSource()";

        logger.entering(CLASS_NAME, _method);

        try {
            final OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL(_jdbcProperties.getProperty("url"));
            dataSource.setUser(_jdbcProperties.getProperty("user"));
            dataSource.setPassword(_jdbcProperties.getProperty("password"));
            dataSource.setConnectionCachingEnabled(true);
            dataSource.setImplicitCachingEnabled(true);
            return dataSource;

        } catch (Exception ex) {
            throw new RuntimeException(
                    "Failed to create Oracle data source", ex);

        }

    }

    public static OpbSession getSharedOpbSession() {
        return _sharedSession;
    }

    private static OpbSession getOpbSession() {
        return new OpbSessionPlsqlImpl(
                _sharedOracleDataSource,
                new OpbDataObjectSource(new OpbObjectSourceImpl()),
                new OpbScalarResultCache());
    }

    private static ResultSet getResultSet(String[] columns, int skipColumn) {
        try {
            Statement statement = _sharedConnection.createStatement();
            String sql = "SELECT ";
            for (int i = 0; i < columns.length; i++) {
                if (i != skipColumn) {
                    sql += "'' AS ";
                    sql += columns[i];
                    sql += ", ";
                }

            }
            sql = sql.substring(0, sql.length() - 2);
            sql += " FROM dual";
            System.out.format("sql=%s%n", sql);
            return statement.executeQuery(sql);

        } catch (Exception ex) {
            throw new RuntimeException(
                    "Failed to get result set. columns=" +
                    Arrays.asList(columns) + ". skipColumn=" + skipColumn, ex);

        }

    }

    public static ResultSet getResultSet(String sql) {
        try {
            Statement statement = _sharedConnection.createStatement();
            return statement.executeQuery(sql);

        } catch (Exception ex) {
            throw new RuntimeException("Failed to get result set " + sql, ex);

        }

    }

    public static OpbId toOpbId(final Object object) {
        if (object == null) {
            return null;
        }
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            Field.setAccessible(fields, true);
            Object[] values = new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                values[i] = field.get(object);
            }
            return new OpbId(values);

        } catch (Exception ex) {
            throw new RuntimeException("failed to convert object to OpbId", ex);

        }

    }

    public static List<OpbId> toOpbIdList(final List list) {
        if (list == null) {
            return null;
        }
        List<OpbId> result = new ArrayList<OpbId>();
        for (Object object : list) {
            result.add(toOpbId(object));
        }
        return result;
    }

}
