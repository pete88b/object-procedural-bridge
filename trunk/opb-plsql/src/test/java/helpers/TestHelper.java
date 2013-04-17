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


import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImpl;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbValueWrapper;
import com.butterfill.opb.util.OpbValueWrapperImpl;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import oracle.jdbc.pool.OracleDataSource;

/**
 * opb-plsql
 *
 * @author Peter Butterfill
 */
public class TestHelper {

    private static OracleDataSource _sharedOracleDataSource =
            getOracleDataSource();

    private static Connection _sharedConnection;

    private static OpbSession _sharedSession = getOpbSession();

    private static Connection _getConnection() {
        if (_sharedConnection == null) {
            try {
                _sharedConnection = _sharedOracleDataSource.getConnection();
            } catch (Exception ex) {
                throw new RuntimeException(
                        "Failed to get connection from shared datasource", ex);
            }
        }
        return _sharedConnection;
    }

    public static OracleDataSource getSharedOracleDataSource() {
        return _sharedOracleDataSource;
    }

    private static OracleDataSource getOracleDataSource() {

        OracleDataSource dataSource = null;

        try {
            dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/xe");
            dataSource.setUser("opb_test");
            dataSource.setPassword("weak_pw");
            dataSource.setConnectionCachingEnabled(true);
            dataSource.setImplicitCachingEnabled(true);

        } catch (SQLException ex) {
            throw new RuntimeException(
                    "Failed to create Oracle data source", ex);
        }

        return dataSource;

    }

    public static OpbSession getSharedOpbSession() {
        return _sharedSession;
    }

    public static OpbSession getOpbSession() {
        return new OpbSessionPlsqlImpl(
                _sharedOracleDataSource,
                new OpbDataObjectSource(new OpbObjectSourceImpl()),
                new OpbScalarResultCache());
    }

    public static ResultSet getResultSet(String[] columns, int skipColumn) {

        try {
            Statement statement = _getConnection().createStatement();
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
            Statement statement = _getConnection().createStatement();
            ResultSet result = statement.executeQuery(sql);
            return result;

        } catch (Exception ex) {
            throw new RuntimeException("Failed to get result set " + sql, ex);

        }

    }

    public static Method getMethod(Class clazz, String name, Class... parameterTypes) {
        try {
            Method method = clazz.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (Exception ex) {
            throw new RuntimeException("failed to get method; " + name);
        }

    }

    public static Object invoke(Method method, Object instance, Object... args) {
        try {
            return method.invoke(instance, args);
        } catch (Exception ex) {
            throw new RuntimeException("failed to invoke method; " + method);
        }

    }

    public static void enableDbmsOutput() {
        getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(DbmsOutput.class)
                .enable(1000000L);
    }

    public static void printDbmsOutput() {
        System.out.println("*** START OF DBMS_OUTPUT ***");

        DbmsOutput dbmsOutput = TestHelper.getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(DbmsOutput.class);

        // get the DBMS_OUTPUT
        // before we can make the GET_LINE call, we need a couple of wrappers to hold the value
        // returned via the "line" parameter and
        final OpbValueWrapper<String> getLineResultWrapper = new OpbValueWrapperImpl<String>();

        // the value returned via the "status" parameter
        final OpbValueWrapper<Long> getLineStatusWrapper = new OpbValueWrapperImpl<Long>();

        // make the 1st GET_LINE call to get the data back
        dbmsOutput.getLine(getLineResultWrapper, getLineStatusWrapper);

        // if the status is 0, we got some data
        while (getLineStatusWrapper.getValue().equals(0L)) {
            // output the values returned
            System.out.println(getLineResultWrapper.getValue());
            // and see if we have some more data
            dbmsOutput.getLine(getLineResultWrapper, getLineStatusWrapper);

        }

        dbmsOutput.disable();

        System.out.println("*** END OF DBMS_OUTPUT ***");

    }

}
