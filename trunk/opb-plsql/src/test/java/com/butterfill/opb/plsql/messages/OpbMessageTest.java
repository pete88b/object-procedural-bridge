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

package com.butterfill.opb.plsql.messages;

import java.math.BigDecimal;
import java.sql.Connection;
import junit.framework.*;
import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.timing.*;
import helpers.TestHelper;
import java.sql.ResultSet;

/**
 *
 * @author Peter Butterfill
 */
public class OpbMessageTest extends TestCase {
    
    public OpbMessageTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbMessageTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbMessage instance = new OpbMessageImpl();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setOpbDataObjectSource method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testSetOpbDataObjectSource() {
        System.out.println("setOpbDataObjectSource");
        
        OpbDataObjectSource source = null;
        OpbMessage instance = new OpbMessageImpl();
        
        instance.setOpbDataObjectSource(source);
        
    }

    /**
     * Test of setOpbConnectionProvider method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testSetOpbConnectionProvider() {
        System.out.println("setOpbConnectionProvider");
        
        OpbConnectionProvider provider = null;
        OpbMessage instance = new OpbMessageImpl();
        
        instance.setOpbConnectionProvider(provider);
        
    }

    /**
     * Test of setOpbEventTimerProvider method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testSetOpbEventTimerProvider() {
        System.out.println("setOpbEventTimerProvider");
        
        OpbEventTimerProvider provider = null;
        OpbMessage instance = new OpbMessageImpl();
        
        instance.setOpbEventTimerProvider(provider);
        
    }

    /**
     * Test of setGroupManagerMap method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testSetGroupManagerMap() {
        System.out.println("setGroupManagerMap");
        
        OpbGroupManagerMap map = null;
        OpbMessage instance = new OpbMessageImpl();
        
        instance.setGroupManagerMap(map);
        
    }

    /**
     * Test of getGroupManagerMap method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetGroupManagerMap() {
        System.out.println("getGroupManagerMap");
        
        OpbMessage instance = new OpbMessageImpl();
        
        OpbGroupManagerMap expResult = null;
        OpbGroupManagerMap result = instance.getGroupManagerMap();
        assertEquals(expResult, result);
        
        expResult = new OpbGroupManager().newGroupManagerMap(instance);
        instance.setGroupManagerMap(expResult);
        result = instance.getGroupManagerMap();
        assertSame(expResult, result);
        
    }

    /**
     * Test of opbClearState method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testOpbClearState() throws Exception {
        System.out.println("opbClearState");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getId());
        assertNull(instance.getContextName());
        assertNull(instance.getSessionId());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
        
        instance.opbClearState();
        
        assertNull(instance.getId());
        assertNull(instance.getContextName());
        assertNull(instance.getSessionId());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals(new BigDecimal(9), instance.getId());
        assertEquals("a", instance.getContextName());
        assertEquals("b", instance.getSessionId());
        assertEquals("c", instance.getMessageType());
        assertEquals("d", instance.getMessageLevel());
        assertEquals("e", instance.getMessageDetail());
        assertEquals("f", instance.getMessageSummary());
        
        instance.opbClearState();
        
        assertNull(instance.getId());
        assertNull(instance.getContextName());
        assertNull(instance.getSessionId());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
    }

    /**
     * Test of opbLoad method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testOpbLoad() throws Exception {
        System.out.println("opbLoad");
        
        ResultSet resultSet = null;
        OpbMessage instance = new OpbMessageImpl();
        try {
            instance.opbLoad(resultSet);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        String[] columns = new String[] {
            "id",
            "context_name",
            "session_id",
            "message_type",
            "message_level",
            "message_detail",
            "message_summary"
        };
        
        for (int i = 0; i < columns.length; i++) {
            ResultSet rs = TestHelper.getResultSet(
                    columns, i);
            rs.next();
            try {
                instance.opbLoad(rs);
                fail();
            } catch (OpbDataAccessException ex) {
                assertTrue(ex.getCause().getMessage().indexOf(
                        "Failed to get '" + columns[i]) != -1);
            }
        }
        ResultSet rs = TestHelper.getResultSet(
                columns, -1);
        rs.next();
        instance.opbLoad(rs);
        
        assertNull(instance.getId());
        assertNull(instance.getContextName());
        assertNull(instance.getSessionId());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals(new BigDecimal(9), instance.getId());
        assertEquals("a", instance.getContextName());
        assertEquals("b", instance.getSessionId());
        assertEquals("c", instance.getMessageType());
        assertEquals("d", instance.getMessageLevel());
        assertEquals("e", instance.getMessageDetail());
        assertEquals("f", instance.getMessageSummary());
        
    }

    

    /**
     * Test of getId method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetId() throws Exception {
        System.out.println("getId");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getId());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals(new BigDecimal(9), instance.getId());
        
    }

    /**
     * Test of getContextName method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetContextName() throws Exception {
        System.out.println("getContextName");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getContextName());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("a", instance.getContextName());
        
    }

    
    /**
     * Test of getSessionId method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetSessionId() throws Exception {
        System.out.println("getSessionId");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getSessionId());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("b", instance.getSessionId());
        
    }

    
    /**
     * Test of getMessageType method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetMessageType() throws Exception {
        System.out.println("getMessageType");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getMessageType());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("c", instance.getMessageType());
        
    }

    /**
     * Test of getMessageLevel method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetMessageLevel() throws Exception  {
        System.out.println("getMessageLevel");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getMessageLevel());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("d", instance.getMessageLevel());
        
    }

    /**
     * Test of getMessageSummary method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetMessageSummary() throws Exception {
        System.out.println("getMessageSummary");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getMessageSummary());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("f", instance.getMessageSummary());
        
    }

    /**
     * Test of getMessageDetail method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testGetMessageDetail() throws Exception {
        System.out.println("getMessageDetail");
        
        OpbMessage instance = new OpbMessageImpl();
        
        assertNull(instance.getMessageDetail());
        
        String sql = "" +
                "SELECT " +
                "9 AS id, " +
                "'a' AS context_name, " +
                "'b' AS session_id, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("e", instance.getMessageDetail());
        
    }


    /**
     * Test of deleteMessage method, of class com.butterfill.opb.messages.OpbMessage.
     */
    public void testDeleteMessage() throws Exception {
        System.out.println("deleteMessage");
        
        java.math.BigDecimal pId = null;
        OpbMessage instance = new OpbMessageImpl();
        
        try {
            instance.deleteMessage(pId);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.setOpbEventTimerProvider(new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        });
        try {
            instance.deleteMessage(pId);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.setOpbConnectionProvider(new OpbConnectionProvider() {
            public Connection getConnection() throws OpbException {
                try {
                    return TestHelper.getSharedOracleDataSource().getConnection();
                } catch (Exception ex) {
                    throw new OpbException(
                            "Failed to get connection from data source", ex);
                }
            }
        });
        
        instance.deleteMessage(pId);
        
        pId = BigDecimal.ZERO;
        instance.deleteMessage(pId);
        instance.deleteMessage();
        instance.deleteMessage();
        
        instance.setOpbEventTimerProvider(null);
        try {
            instance.deleteMessage(pId);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        OpbSession session = TestHelper.getSharedOpbSession();
        
        OpbMessages messages = session
                .getDataObjectSource()
                .newInstance(OpbMessages.class);
        messages.clearAllMessages();
        messages.addAllContextMessage(
                OpbMessages.MESSAGE_LEVEL_ERROR, "s", "d");
        
        instance = messages.getAllContextMessages().get(0);
        instance.deleteMessage(instance.getId().add(new BigDecimal(1)));
        assertEquals(1, messages.getAllContextMessages().size());
        instance.deleteMessage();
        assertEquals(0, messages.getAllContextMessages().size());
        
    }
    
}
