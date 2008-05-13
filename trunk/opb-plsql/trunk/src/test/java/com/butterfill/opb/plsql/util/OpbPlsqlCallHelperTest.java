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

import junit.framework.*;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.timing.OpbEventTimerProvider;
import helpers.TestHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbPlsqlCallHelperTest extends TestCase {
    private static final Logger logger = Logger.getLogger(
            OpbPlsqlCallHelperTest.class.getName());
    
    OpbSession session;
    
    public OpbPlsqlCallHelperTest(String testName) {
        super(testName);
        session = TestHelper.getSharedOpbSession();
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbPlsqlCallHelperTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testToString() throws Exception {
        System.out.println("toString");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{}",
                "testCallEventName");
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance.callComplete();
    }

    /**
     * Test of registerOutParameter method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testRegisterOutParameter() throws Exception {
        System.out.println("registerOutParameter");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testRegisterOutParameter",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.varchar2_test(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        instance.execute();
        
        assertEquals("VARCHAR2_pos_1", instance.get(String.class, 1));
        assertEquals("VARCHAR2_pos_2", instance.get(String.class, 2));
        
        instance.callComplete();
        
        // test cleanup on error (default)
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testRegisterOutParameter",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.varchar2_test(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        instance.execute();
        instance.execute();
        
        try {
            instance.registerOutParameter(3, java.sql.Types.VARCHAR);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok invalid col index
        }
        
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok closed statement
        }
        
        instance.callComplete();
        
        
        // test cleanup on error (non-default)
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testRegisterOutParameter",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.varchar2_test(?) }",
                "testCallEventName");
        
        instance.setCloseResourcesOnException(false);
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        instance.execute();
        instance.execute();
        
        try {
            instance.registerOutParameter(3, java.sql.Types.VARCHAR);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok invalid col index
        }
        
        instance.execute();
        
        instance.callComplete();
    }

    /**
     * Test of setObject method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testSetObject() throws Exception {
        System.out.println("setObject");
        
        Object value = 99;
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        instance.setObject(2, java.sql.Types.VARCHAR, value);
        
        instance.execute();
        
        assertEquals(
                99+"#appended", instance.get(String.class, 1));
        
        value = "abc";
        instance.setObject(2, java.sql.Types.VARCHAR, value);
        
        instance.execute();
        
        assertEquals(
                "abc#appended", instance.get(String.class, 1));
        
        instance.callComplete();
        
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        instance.setObject(2, java.sql.Types.VARCHAR, value);
        
        instance.execute();
        
        try {
            instance.setObject(3, java.sql.Types.VARCHAR, value);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test(?) }",
                "testCallEventName");
        instance.setCloseResourcesOnException(false);
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        instance.setObject(2, java.sql.Types.VARCHAR, value);
        
        instance.execute();
        
        try {
            instance.setObject(3, java.sql.Types.VARCHAR, value);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        instance.execute();
        
        instance.callComplete();
            
        
        // test setting boolean
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test2(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, Types.VARCHAR);
        instance.setObject(2, Types.VARCHAR, true);
        instance.execute();
        assertEquals("Y", instance.get(String.class, 1));
        
        instance.setObject(2, Types.VARCHAR, false);
        instance.execute();
        assertEquals("N", instance.get(String.class, 1));
        
        instance.setObject(2, Types.VARCHAR, null);
        instance.execute();
        assertNull(instance.get(String.class, 1));
        
        instance.callComplete();
        
    }

    /**
     * Test of execute method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        instance.setObject(2, java.sql.Types.VARCHAR, "testValue");
        
        instance.execute();
        
        instance.callComplete();
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := fail.set_object_test(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        instance.setObject(2, java.sql.Types.VARCHAR, "testValue");
        
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test(?) }",
                "testCallEventName");
        
        instance.setObject(2, java.sql.Types.VARCHAR, "testValue");
        
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.set_object_test(?) }",
                "testCallEventName");
        instance.setCloseResourcesOnException(false);
        instance.setObject(2, java.sql.Types.VARCHAR, "testValue");
        
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.execute();
        
        instance.callComplete();
    }

    /**
     * Test of getObject method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testGetObject() throws Exception {
        System.out.println("getObject");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL opb_plsql_call_help_test.get_object_test(?) }",
                "testCallEventName");
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.execute();
        for (int i = 0; i < 9; i++) {
            assertEquals("abc", instance.get(String.class, 1));
        }
        for (int i = 0; i < 5; i++) {
            instance.execute();
            assertEquals("abc", instance.get(String.class, 1));
        }
        instance.callComplete();
        
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL opb_plsql_call_help_test.get_object_test(?) }",
                "testCallEventName");
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.execute();
        try {
            instance.registerOutParameter(2, java.sql.Types.VARCHAR);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        
        instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL opb_plsql_call_help_test.get_object_test(?) }",
                "testCallEventName");
        instance.setCloseResourcesOnException(false);
        instance.registerOutParameter(1, java.sql.Types.VARCHAR);
        instance.execute();
        try {
            instance.registerOutParameter(2, java.sql.Types.VARCHAR);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        instance.execute();
        instance.execute();
        
        instance.callComplete();
    }

    /**
     * Test of callComplete method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testCallComplete() throws Exception {
        System.out.println("callComplete");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testCallComplete",
                session,
                session,
                "{ CALL opb_plsql_call_help_test.call_complete_test }",
                "testCallEventName");
        
        instance.execute();
        instance.callComplete();
        try {
            instance.execute();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
    }

    /**
     * Test of isCloseResourcesOnException method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testIsCloseResourcesOnException() throws Exception  {
        System.out.println("isCloseResourcesOnException");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testCallComplete",
                session.getOpbEventTimer(),
                session.getConnection(),
                "{ CALL opb_plsql_call_help_test.call_complete_test }",
                "testCallEventName");
        
        assertTrue(instance.isCloseResourcesOnException());
        instance.setCloseResourcesOnException(false);
        assertFalse(instance.isCloseResourcesOnException());
        instance.setCloseResourcesOnException(true);
        assertTrue(instance.isCloseResourcesOnException());
    }

    /**
     * Test of setCloseResourcesOnException method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testSetCloseResourcesOnException() throws Exception {
        System.out.println("setCloseResourcesOnException");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testCallComplete",
                session.getOpbEventTimer(),
                session.getConnection(),
                "{ CALL opb_plsql_call_help_test.call_complete_test }",
                "testCallEventName");
        
        assertTrue(instance.isCloseResourcesOnException());
        instance.setCloseResourcesOnException(false);
        assertFalse(instance.isCloseResourcesOnException());
        instance.setCloseResourcesOnException(true);
        assertTrue(instance.isCloseResourcesOnException());
    }

    /**
     * Test of getResultSet method, of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testGetResultSet() throws Exception {
        System.out.println("getResultSet");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testCallComplete",
                session.getOpbEventTimer(),
                session.getConnection(),
                "{ CALL ? := opb_plsql_call_help_test.get_rs_test }",
                "testCallEventName");
        
        instance.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        instance.execute();
        ResultSet rs = instance.get(ResultSet.class, 1);
        rs.next();
        assertEquals("x", rs.getString(1));
        instance.callComplete();
        
    }
    
    
    /**
     * Test of get method, of class OpbPlsqlCallHelper.
     * @see #testGetBoolean
     * @see #testGetObject
     * @see #testGetResultSet
     */
    public void testGet() {
        System.out.println("get");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testCallComplete",
                session.getOpbEventTimer(),
                session.getConnection(),
                "{ CALL opb_plsql_call_help_test.increment(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, Types.BIGINT);
        
        instance.setObject(1, Types.BIGINT, null);
        instance.execute();
        assertNull(instance.get(Long.class, 1));
        
        instance.setObject(1, Types.BIGINT, 8);
        instance.execute();
        Object expected = 9L;
        Object result = instance.get(Long.class, 1);
        assertEquals(expected, result);
        
        instance.setObject(1, Types.BIGINT, result);
        instance.execute();
        expected = 10L;
        result = instance.get(Long.class, 1);
        assertEquals(expected, result);
        
        instance.callComplete();
        
    }

    /**
     * Test of getBoolean method, of class OpbPlsqlCallHelper.
     */
    public void testGetBoolean() {
        System.out.println("getBoolean");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testCallComplete",
                session.getOpbEventTimer(),
                session.getConnection(),
                "{ CALL opb_plsql_call_help_test.boolean_test(?, ?) }",
                "testCallEventName");
        
        instance.registerOutParameter(2, Types.VARCHAR);
        
        instance.setObject(1, Types.INTEGER, 0);
        instance.execute();
        assertFalse(instance.get(Boolean.class, 2));
        
        instance.setObject(1, Types.INTEGER, 1);
        instance.execute();
        assertTrue(instance.get(Boolean.class, 2));
        
        instance.setObject(1, Types.INTEGER, 999);
        instance.execute();
        assertNull(instance.get(Boolean.class, 2));
        
        instance.callComplete();
        
    }
    
    /**
     * Test the constructors of class com.butterfill.opb.plsql.OpbPlsqlCallHelper.
     */
    public void testConstructors() throws Exception {
        
        OpbEventTimerProvider evtProvider = session;
        OpbConnectionProvider conProvider = session;
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger,         //sourceLogger
                "",             //sourceClass
                "",             //sourceMethod
                evtProvider,    //eventTimerProvider
                conProvider,    //connectionProvider
                "x",             //sqlCall
                "");            //eventName
        instance.callComplete();
        
        try {
            evtProvider = null;
            new OpbPlsqlCallHelper(
                    logger,         //sourceLogger
                    "",             //sourceClass
                    "",             //sourceMethod
                    evtProvider,    //eventTimerProvider
                    conProvider,    //connectionProvider
                    "x",             //sqlCall
                    "");            //eventName
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        try {
            evtProvider = session;
            conProvider = null;
            new OpbPlsqlCallHelper(
                    logger,         //sourceLogger
                    "",             //sourceClass
                    "",             //sourceMethod
                    evtProvider,    //eventTimerProvider
                    conProvider,    //connectionProvider
                    "x",             //sqlCall
                    "");            //eventName
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        conProvider = session;
        
        try {
            new OpbPlsqlCallHelper(
                    logger,         //sourceLogger
                    "",             //sourceClass
                    "",             //sourceMethod
                    evtProvider,    //eventTimerProvider
                    conProvider,    //connectionProvider
                    null,             //sqlCall
                    "");            //eventName
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        try {
            new OpbPlsqlCallHelper(
                    logger,         //sourceLogger
                    "",             //sourceClass
                    "",             //sourceMethod
                    evtProvider,    //eventTimerProvider
                    conProvider,    //connectionProvider
                    "",             //sqlCall
                    "");            //eventName
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        instance = new OpbPlsqlCallHelper(
                logger,         //sourceLogger
                "",             //sourceClass
                "",             //sourceMethod
                evtProvider,    //eventTimerProvider
                conProvider,    //connectionProvider
                "x",             //sqlCall
                null);            //eventName
        instance.callComplete();
        
        instance = new OpbPlsqlCallHelper(
                null,         //sourceLogger
                "",             //sourceClass
                "",             //sourceMethod
                evtProvider,    //eventTimerProvider
                conProvider,    //connectionProvider
                "x",             //sqlCall
                null);            //eventName
        instance.callComplete();
        
        instance = new OpbPlsqlCallHelper(
                null,         //sourceLogger
                null,             //sourceClass
                "",             //sourceMethod
                evtProvider,    //eventTimerProvider
                conProvider,    //connectionProvider
                "x",             //sqlCall
                null);            //eventName
        instance.callComplete();
        
        instance = new OpbPlsqlCallHelper(
                null,         //sourceLogger
                null,             //sourceClass
                null,             //sourceMethod
                evtProvider,    //eventTimerProvider
                conProvider,    //connectionProvider
                "x",             //sqlCall
                null);            //eventName
        instance.callComplete();
        
        
        Connection con = session.getConnection();
        OpbEventTimer timer = session.getOpbEventTimer();
        
        instance = new OpbPlsqlCallHelper(
                logger,         //sourceLogger
                "",             //sourceClass
                "",             //sourceMethod
                timer,          //timer
                con,            //connection
                "x",             //sqlCall
                "");            //eventName
        instance.callComplete();
        
        try {
            timer = null;
            new OpbPlsqlCallHelper(
                    logger,         //sourceLogger
                    "",             //sourceClass
                    "",             //sourceMethod
                    timer,          //timer
                    con,            //connection
                    "x",             //sqlCall
                    "");            //eventName
            fail();
        } catch (NullPointerException ex) {
            //ok
        }

        try {
            timer = session.getOpbEventTimer();
            con = null;
            new OpbPlsqlCallHelper(
                    logger,         //sourceLogger
                    "",             //sourceClass
                    "",             //sourceMethod
                    timer,          //timer
                    con,            //connection
                    "x",             //sqlCall
                    "");            //eventName
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
    }

    /**
     * Test of setPlsqlIndexTable method, of class OpbPlsqlCallHelper.
     */
    public void testSetPlsqlIndexTable() {
        System.out.println("setPlsqlIndexTable");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testToString",
                session,
                session,
                "{ CALL ? := opb_plsql_call_help_test.index_table(?) }",
                "testCallEventName");
        
        instance.registerOutParameter(1, Types.BIGINT);
        instance.setPlsqlIndexTable(2, Types.VARCHAR, new String[]{});
        instance.execute();
        Object expected = 0L;
        assertEquals(expected, instance.get(Long.class, 1));
        
        instance.setPlsqlIndexTable(2, Types.VARCHAR, new String[]{""});
        instance.execute();
        expected = 1L;
        assertEquals(expected, instance.get(Long.class, 1));
        
        instance.setPlsqlIndexTable(2, Types.VARCHAR, new String[]{"a", "b"});
        instance.execute();
        expected = 2L;
        assertEquals(expected, instance.get(Long.class, 1));
        
        instance.setPlsqlIndexTable(2, Types.VARCHAR, new String[]{"1", "2", "3"});
        instance.execute();
        expected = 3L;
        assertEquals(expected, instance.get(Long.class, 1));
        
        instance.callComplete();
        
    }

    /**
     * Test of registerOutArray method, of class OpbPlsqlCallHelper.
     */
    public void testRegisterOutArray() {
        System.out.println("registerOutArray");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testRegisterOutArray",
                session,
                session,
                "{ CALL ? := user_defined_collections.how_long(?, ?) }",
                "testCallEventName(Array)");
        
        instance.registerOutParameter(1, Types.VARCHAR);
        instance.setArray(2, "VARCHAR_TABLE", new String[]{});
        instance.registerOutArray(3, "VARCHAR_TABLE");
        instance.execute();
        assertEquals("null", instance.get(String.class, 1));
        
    }

    /**
     * Test of setArray method, of class OpbPlsqlCallHelper.
     */
    public void testSetArray() {
        System.out.println("setArray");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testRegisterOutArray",
                session,
                session,
                "{ CALL ? := user_defined_collections.how_long(?, ?) }",
                "testCallEventName(Array)");
        
        instance.registerOutParameter(1, Types.VARCHAR);
        instance.setArray(2, "VARCHAR_TABLE", new String[]{"", null});
        instance.registerOutArray(3, "VARCHAR_TABLE");
        instance.execute();
        assertEquals("notnull", instance.get(String.class, 1));
        String[] result = instance.getArray(String[].class, 3);
        assertEquals(2, result.length);
        assertEquals(null, result[0]);
        assertEquals(null, result[1]);
    }

    /**
     * Test of getArray method, of class OpbPlsqlCallHelper.
     */
    public void testGetArray() {
        System.out.println("getArray");
        
        OpbPlsqlCallHelper instance = new OpbPlsqlCallHelper(
                logger, "OpbPlsqlCallHelper", "testRegisterOutArray",
                session,
                session,
                "{ CALL ? := user_defined_collections.how_long(?, ?) }",
                "testCallEventName(Array)");
        
        instance.registerOutParameter(1, Types.VARCHAR);
        instance.setArray(2, "VARCHAR_TABLE", new String[]{"1", "bb", "ccc"});
        instance.registerOutArray(3, "VARCHAR_TABLE");
        instance.execute();
        assertEquals("notnull", instance.get(String.class, 1));
        String[] result = instance.getArray(String[].class, 3);
        assertEquals(3, result.length);
        assertEquals("1", result[0]);
        assertEquals("2", result[1]);
        assertEquals("3", result[2]);
    }

}
