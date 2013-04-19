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

import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.SQLException;
import junit.framework.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.Set;
import com.butterfill.opb.util.OpbBooleanHelper;
import helpers.TestHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Peter Butterfill
 */
public class OpbSqlHelperTest extends TestCase {

    public OpbSqlHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        dropTestPackage();
    }

    @Override
    protected void tearDown() throws Exception {
        dropTestPackage();
    }

    /**
     * Try to drop the test package (opb_sql_helper_test) but don't raise exceptions
     * if we can't drop it (i.e. if it doesn't exist).
     */
    private void dropTestPackage() {
        Connection connection = null;
        try {
            connection = TestHelper.getOracleDataSource().getConnection();

            CallableStatement statement = connection.prepareCall(
                    "BEGIN" +
                    "  EXECUTE IMMEDIATE 'DROP PACKAGE opb_sql_helper_test';" +
                    "END;");
            statement.execute();

        } catch (Exception ex) {
            // we don't care
        } finally {
            OpbSqlHelper.close(null, null, null, connection);

        }

    }

    public void testCloseResultSet() {
        System.out.format("close(ResultSet)%n");

        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        ResultSet rs = null;

        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);

        sourceLogger = Logger.getLogger("x");
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);

        sourceClass = "Test";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);

        sourceMethod = "testCloseResultSet()";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);

        rs = (ResultSet) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{ResultSet.class, Closeable.class}, new CloseOk());

        assertFalse(((Closeable)rs).getClosed());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        assertTrue(((Closeable)rs).getClosed());

        rs = (ResultSet) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{ResultSet.class}, new CloseThrowSqlEx());

        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);

        rs = (ResultSet) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{ResultSet.class}, new CloseThrowRuntimeEx());

        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);

    }

    public void testCloseStatement() {
        System.out.format("close(Statement)%n");

        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        Statement stmt = null;

        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);

        sourceLogger = Logger.getLogger("name");
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);

        sourceClass = getClass().getName();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);

        sourceMethod = "meth";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);

        stmt = (Statement) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{Statement.class, Closeable.class}, new CloseOk());

        assertFalse(((Closeable)stmt).getClosed());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        assertTrue(((Closeable)stmt).getClosed());

        stmt =  (Statement) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{Statement.class}, new CloseThrowSqlEx());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);

        stmt =  (Statement) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{Statement.class}, new CloseThrowRuntimeEx());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);

    }

    public void testCloseConnection() {
        System.out.format("close(Connection)%n");

        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        Connection con = null;

        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);

        sourceLogger = Logger.getAnonymousLogger();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);

        sourceClass = "x";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);

        sourceMethod = "";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);

        con = (Connection) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{Connection.class, Closeable.class}, new CloseOk());

        assertFalse(((Closeable)con).getClosed());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        assertTrue(((Closeable)con).getClosed());

        con = (Connection) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{Connection.class}, new CloseThrowRuntimeEx());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);

        con = (Connection) Proxy.newProxyInstance(
                OpbSqlHelperTest.class.getClassLoader(),
                new Class[]{Connection.class}, new CloseThrowSqlEx());
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);

    }

    /**
     * See test cases for overloaded method calls.
     */
    public void testClose() {

    }

    static interface Closeable {
        boolean getClosed();
    }

    static class CloseOk implements InvocationHandler {
        private boolean closed;
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("close".equals(method.getName())) {
                closed = true;
                return null;
            } else if ("getClosed".equals(method.getName())) {
                return closed;
            } else {
                throw new RuntimeException(method.getName() + " is not supported");
            }
        }
    }

    static class CloseThrowSqlEx implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("close".equals(method.getName())) {
                throw new SQLException("");
            } else {
                throw new RuntimeException(method.getName() + " is not supported");
            }
        }
    }

    static class CloseThrowRuntimeEx implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("close".equals(method.getName())) {
                throw new RuntimeException("");
            } else {
                throw new RuntimeException(method.getName() + " is not supported");
            }
        }
    }


    public static Test suite() {
        TestSuite suite = new TestSuite(OpbSqlHelperTest.class);

        return suite;
    }

    /**
     * Test of getReTryableErrorCodes method, of class com.butterfill.opb.data.OpbSqlHelper.
     */
    public void testGetReTryableErrorCodes() {
        System.out.println("getReTryableErrorCodes");

        Set<Integer> result = OpbSqlHelper.getReTryableErrorCodes();
        assertEquals(2, result.size());
        assertTrue(result.contains(4061));
        assertTrue(result.contains(4068));

    }

    /**
     * Test of execute method, of class com.butterfill.opb.data.OpbSqlHelper.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");

        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        CallableStatement statement = null;

        try {
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }

        Connection con2 = TestHelper.getOracleDataSource().getConnection();

        CallableStatement statement2 = con2.prepareCall(
                "BEGIN" +
                "  EXECUTE IMMEDIATE " +
                "  'CREATE PACKAGE opb_sql_helper_test AS " +
                "     call_count NUMBER := 0;" +
                "     PROCEDURE x; " +
                "   END;';" +
                "END;");
        statement2.execute();
        statement2 = con2.prepareCall(
                "BEGIN" +
                "  EXECUTE IMMEDIATE " +
                "  'CREATE PACKAGE BODY opb_sql_helper_test AS " +
                "     PROCEDURE x IS BEGIN " +
                "       call_count := call_count + 1; " +
                "     END; " +
                "   END;';" +
                "END;");
        statement2.execute();

        Connection con = TestHelper.getOracleDataSource().getConnection();

        statement = con.prepareCall("{ CALL opb_sql_helper_test.x }");
        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);

        sourceLogger = Logger.getLogger("OpbSqlHelperTest");
        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);

        sourceClass = "OpbSqlHelperTest";
        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);

        sourceMethod = "testExecute()";
        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);

        statement = con.prepareCall("{ CALL opb_sql_helper_testX }");
        try {
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            fail();
        } catch (SQLException ex) {
            //ok
        }

        statement = con.prepareCall("{ CALL opb_sql_helper_test.x }");
        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
        statement.execute();

        // re-create package to make statement.execute() fail due to
        // existing state  discarded
        statement2 = con2.prepareCall(
                "BEGIN" +
                "  EXECUTE IMMEDIATE " +
                "  'CREATE OR REPLACE PACKAGE opb_sql_helper_test AS " +
                "     /* */" +
                "     call_count NUMBER := 0;" +
                "     PROCEDURE x; " +
                "   END;';" +
                "END;");
        statement2.execute();

        try {
            statement.execute();
            fail();
        } catch (SQLException ex) {
            //ok
        }

        statement = con.prepareCall("{ CALL opb_sql_helper_test.x }");
        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
        statement.execute();

        statement2 = con2.prepareCall(
                "BEGIN" +
                "  EXECUTE IMMEDIATE " +
                "  'CREATE OR REPLACE PACKAGE opb_sql_helper_test AS " +
                "     /* comment 2 */" +
                "     call_count NUMBER := 0;" +
                "     PROCEDURE x; " +
                "   END;';" +
                "END;");
        statement2.execute();

        OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);

        OpbSqlHelper.close(sourceLogger, sourceClass, sourceMethod, con);
        OpbSqlHelper.close(sourceLogger, sourceClass, sourceMethod, con2);

    }


    /**
     * Test of getValue method, of class com.butterfill.opb.data.OpbSqlHelper.
     */
    public void testGetValue() throws Exception {
        System.out.println("getValue");

        OpbBooleanHelper.setValueForTrue("Y");
        OpbBooleanHelper.setValueForFalse("N");
        OpbBooleanHelper.setIgnoreCase(true);

        Clob type = null;
        ResultSet resultSet = null;
        String columnName = null;
        boolean failOnInvalidColumnName = false;

        try {
            OpbSqlHelper.getValue(type, resultSet, columnName, failOnInvalidColumnName);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }

        String sql =
                "SELECT 'y' AS t, " +
                "       'n' AS f," +
                "       '' AS null_boolean," +
                "       '" + Integer.MIN_VALUE + "' AS i_min," +
                "       '" + Integer.MAX_VALUE + "' AS i_max," +
                "       '" + Long.MIN_VALUE + "' AS l_min," +
                "       '" + Long.MAX_VALUE + "' AS l_max," +
                "       TO_DATE('15-feb-2001 23:55:22', 'dd-mon-yyyy hh24:mi:ss') AS dt" +
                "  FROM dual";

        Connection con = TestHelper.getOracleDataSource().getConnection();

        resultSet = con.createStatement().executeQuery(sql);
        resultSet.next();

        failOnInvalidColumnName = true;
        try {
            OpbSqlHelper.getValue(type, resultSet, columnName, failOnInvalidColumnName);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }

        // <editor-fold defaultstate="collapsed" desc="integer section">

        Integer integer = null;
        assertNull(OpbSqlHelper.getValue(integer, resultSet, "x", false));

        try {
            OpbSqlHelper.getValue(integer, resultSet, "x", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to get") != -1);
        }
        Object o = Integer.MIN_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(integer, resultSet, "i_min", true));

        o = Integer.MAX_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(integer, resultSet, "i_max", true));

        try {
            OpbSqlHelper.getValue(integer, resultSet, "l_max", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }

        try {
            OpbSqlHelper.getValue(integer, resultSet, "l_min", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }

        // </editor-fold> End of integer Section


        // <editor-fold defaultstate="collapsed" desc="long section">

        Long longish = null;

        assertNull(OpbSqlHelper.getValue(longish, resultSet, "x", false));

        try {
            OpbSqlHelper.getValue(longish, resultSet, "x", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to get") != -1);
        }
        o = Long.valueOf(Integer.MIN_VALUE);
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "i_min", true));

        o = Long.valueOf(Integer.MAX_VALUE);
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "i_max", true));

        o = Long.MIN_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "l_min", true));

        o = Long.MAX_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "l_max", true));

        try {
            OpbSqlHelper.getValue(longish, resultSet, "t", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }

        // </editor-fold> End of long Section


        // <editor-fold defaultstate="collapsed" desc="boolean section">

        Boolean b = null;
        assertNull(OpbSqlHelper.getValue(b, resultSet, "x", false));

        try {
            OpbSqlHelper.getValue(b, resultSet, "x", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to get") != -1);
        }

        assertTrue(OpbSqlHelper.getValue(b, resultSet, "t", true));
        assertFalse(OpbSqlHelper.getValue(b, resultSet, "f", true));
        assertNull(OpbSqlHelper.getValue(b, resultSet, "null_boolean", true));

        try {
            OpbSqlHelper.getValue(b, resultSet, "l_max", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }

        try {
            OpbSqlHelper.getValue(b, resultSet, "l_min", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }

        assertNull(OpbSqlHelper.getValue(b, resultSet, "x", false));

        b = true;
        assertTrue(OpbSqlHelper.getValue(b, resultSet, "x", false));

        b = false;
        assertFalse(OpbSqlHelper.getValue(b, resultSet, "x", false));

        // </editor-fold> End of boolean Section


        // <editor-fold defaultstate="collapsed" desc="String section">

        String s = null;

        assertNull(OpbSqlHelper.getValue(s, resultSet, "x", false));

        s = "testDefaultValue";
        assertEquals(s, OpbSqlHelper.getValue(s, resultSet, "x", false));

        s = "x";
        assertEquals(s, OpbSqlHelper.getValue(s, resultSet, "x", false));

        // </editor-fold> End of String Section


        // <editor-fold defaultstate="collapsed" desc="Date section">

        java.util.Date javaUtilDate = null;
        java.sql.Date javaSqlDate = null;
        java.sql.Timestamp javaSqlTimestamp = null;

        assertNull(OpbSqlHelper.getValue(javaUtilDate, resultSet, "unk", false));
        assertNull(OpbSqlHelper.getValue(javaSqlDate, resultSet, "unk", false));
        assertNull(OpbSqlHelper.getValue(javaSqlTimestamp, resultSet, "unk", false));

        Calendar calendar = new GregorianCalendar();

        java.util.Date result = OpbSqlHelper.getValue(javaUtilDate, resultSet, "dt", true);

        calendar.setTime(result);
        assertEquals(15, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(1, calendar.get(Calendar.MONTH));
        assertEquals(2001, calendar.get(Calendar.YEAR));
        assertEquals(11, calendar.get(Calendar.HOUR));
        assertEquals(55, calendar.get(Calendar.MINUTE));
        assertEquals(22, calendar.get(Calendar.SECOND));

        result = OpbSqlHelper.getValue(javaSqlDate, resultSet, "dt", true);

        calendar.setTime(result);
        assertEquals(15, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(1, calendar.get(Calendar.MONTH));
        assertEquals(2001, calendar.get(Calendar.YEAR));
        // no time component with sql.Date
        assertEquals(0, calendar.get(Calendar.HOUR));
        assertEquals(0, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));

        result = OpbSqlHelper.getValue(javaSqlTimestamp, resultSet, "dt", true);

        calendar.setTime(result);
        assertEquals(15, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(1, calendar.get(Calendar.MONTH));
        assertEquals(2001, calendar.get(Calendar.YEAR));
        assertEquals(11, calendar.get(Calendar.HOUR));
        assertEquals(55, calendar.get(Calendar.MINUTE));
        assertEquals(22, calendar.get(Calendar.SECOND));

        // </editor-fold> End of Date Section


        con.close();

    }

}
