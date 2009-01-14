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

import junit.framework.*;
import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.timing.*;
import helpers.TestHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Peter Butterfill
 */
public class OpbMessagesTest extends TestCase {
    
    OpbSession session;
    
    public OpbMessagesTest(String testName) {
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
        TestSuite suite = new TestSuite(OpbMessagesTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setOpbDataObjectSource method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetOpbDataObjectSource() {
        System.out.println("setOpbDataObjectSource");
        
        OpbDataObjectSource source = null;
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setOpbDataObjectSource(source);
        
    }

    /**
     * Test of setOpbConnectionProvider method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetOpbConnectionProvider() {
        System.out.println("setOpbConnectionProvider");
        
        OpbConnectionProvider provider = null;
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setOpbConnectionProvider(provider);
        
    }

    /**
     * Test of setOpbEventTimerProvider method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetOpbEventTimerProvider() {
        System.out.println("setOpbEventTimerProvider");
        
        OpbEventTimerProvider provider = null;
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setOpbEventTimerProvider(provider);
        
    }

    /**
     * Test of setGroupManagerMap method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetGroupManagerMap() {
        System.out.println("setGroupManagerMap");
        
        OpbGroupManagerMap map = null;
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setGroupManagerMap(map);
        
    }

    /**
     * Test of getGroupManagerMap method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetGroupManagerMap() {
        System.out.println("getGroupManagerMap");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbGroupManagerMap expResult = null;
        OpbGroupManagerMap result = instance.getGroupManagerMap();
        assertEquals(expResult, result);
        
        expResult = new OpbGroupManager().newGroupManagerMap(instance);
        instance.setGroupManagerMap(expResult);
        result = instance.getGroupManagerMap();
        assertSame(expResult, result);
    }

    /**
     * Test of opbClearState method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testOpbClearState() throws Exception {
        System.out.println("opbClearState");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.opbClearState();
        
        assertNull(instance.getContextName());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
        
        instance.opbClearState();
        
        assertNull(instance.getContextName());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
        
        String sql = "" +
                "SELECT " +
                "'a' AS context_name, " +
                "'c' AS message_type, " +
                "'d' AS message_level, " +
                "'e' AS message_detail, " +
                "'f' AS message_summary " +
                "FROM dual";
        ResultSet rs = TestHelper.getResultSet(sql);
        rs.next();
        instance.opbLoad(rs);
        assertEquals("a", instance.getContextName());
        assertEquals("c", instance.getMessageType());
        assertEquals("d", instance.getMessageLevel());
        assertEquals("e", instance.getMessageDetail());
        assertEquals("f", instance.getMessageSummary());
        
        instance.opbClearState();
        
        assertNull(instance.getContextName());
        assertNull(instance.getMessageLevel());
        assertNull(instance.getMessageDetail());
        assertNull(instance.getMessageType());
        assertNull(instance.getMessageSummary());
    }

    /**
     * Test of opbLoad method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testOpbLoad() throws Exception {
        System.out.println("opbLoad");
        
        ResultSet resultSet = null;
        OpbMessages instance = new OpbMessagesImpl();
        
        try {
            instance.opbLoad(resultSet);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        String[] columns = new String[] {
            "context_name",
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
        
        assertNull(instance.getContextName());
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
        assertEquals("a", instance.getContextName());
        assertEquals("c", instance.getMessageType());
        assertEquals("d", instance.getMessageLevel());
        assertEquals("e", instance.getMessageDetail());
        assertEquals("f", instance.getMessageSummary());
    }

    /**
     * Test of getContextNameDataSourceValue method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetContextNameDataSourceValue() throws Exception {
        System.out.println("getContextNameDataSourceValue");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getContextNameDataSourceValue();
        assertEquals(expResult, result);
        
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
        
        assertEquals("a", instance.getContextNameDataSourceValue());
        
    }

    /**
     * Test of getContextName method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetContextName() {
        System.out.println("getContextName");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getContextName();
        assertEquals(expResult, result);
        instance.setContextName("ctx");
        assertEquals("ctx", instance.getContextName());
    }

    /**
     * Test of setContextName method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetContextName() {
        System.out.println("setContextName");
        
        String contextName = "";
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setContextName(contextName);
        
    }

    /**
     * Test of getMessageTypeDataSourceValue method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageTypeDataSourceValue() throws Exception {
        System.out.println("getMessageTypeDataSourceValue");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageTypeDataSourceValue();
        assertEquals(expResult, result);
        
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
        
        assertEquals("c", instance.getMessageTypeDataSourceValue());
    }

    /**
     * Test of getMessageType method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageType() {
        System.out.println("getMessageType");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageType();
        assertEquals(expResult, result);
        instance.setMessageType("t");
        assertEquals("t", instance.getMessageType());
    }

    /**
     * Test of setMessageType method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetMessageType() {
        System.out.println("setMessageType");
        
        String messageType = "";
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setMessageType(messageType);
        
    }

    /**
     * Test of getMessageLevelDataSourceValue method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageLevelDataSourceValue() throws Exception {
        System.out.println("getMessageLevelDataSourceValue");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageLevelDataSourceValue();
        assertEquals(expResult, result);
        
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
        
        assertEquals("d", instance.getMessageLevelDataSourceValue());
    }

    /**
     * Test of getMessageLevel method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageLevel() {
        System.out.println("getMessageLevel");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageLevel();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMessageLevel method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetMessageLevel() {
        System.out.println("setMessageLevel");
        
        String messageLevel = "";
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setMessageLevel(messageLevel);
        
    }

    /**
     * Test of getMessageSummaryDataSourceValue method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageSummaryDataSourceValue() throws Exception {
        System.out.println("getMessageSummaryDataSourceValue");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageSummaryDataSourceValue();
        assertEquals(expResult, result);
        
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
        
        assertEquals("f", instance.getMessageSummaryDataSourceValue());
    }

    /**
     * Test of getMessageSummary method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageSummary() {
        System.out.println("getMessageSummary");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageSummary();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMessageSummary method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetMessageSummary() {
        System.out.println("setMessageSummary");
        
        String messageSummary = "";
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setMessageSummary(messageSummary);
        
    }

    /**
     * Test of getMessageDetailDataSourceValue method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageDetailDataSourceValue() throws Exception {
        System.out.println("getMessageDetailDataSourceValue");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageDetailDataSourceValue();
        assertEquals(expResult, result);
        
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
        
        assertEquals("e", instance.getMessageDetailDataSourceValue());
    }

    /**
     * Test of getMessageDetail method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageDetail() {
        System.out.println("getMessageDetail");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        String expResult = null;
        String result = instance.getMessageDetail();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMessageDetail method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testSetMessageDetail() {
        System.out.println("setMessageDetail");
        
        String messageDetail = "";
        OpbMessages instance = new OpbMessagesImpl();
        
        instance.setMessageDetail(messageDetail);
        
    }

    /**
     * Test of getContextNameChanged method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetContextNameChanged() throws Exception {
        System.out.println("getContextNameChanged");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        assertFalse(instance.getContextNameChanged());
        instance.setContextName("new name");
        assertTrue(instance.getContextNameChanged());
        
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
        
        assertFalse(instance.getContextNameChanged());
        instance.setContextName("new name");
        assertTrue(instance.getContextNameChanged());
        instance.setContextName("a");
        assertFalse(instance.getContextNameChanged());
    }

    /**
     * Test of getMessageTypeChanged method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageTypeChanged() throws Exception {
        System.out.println("getMessageTypeChanged");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        assertFalse(instance.getMessageTypeChanged());
        instance.setMessageType("X");
        assertTrue(instance.getMessageTypeChanged());
        
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
        
        assertFalse(instance.getMessageTypeChanged());
        instance.setMessageType("X");
        assertTrue(instance.getMessageTypeChanged());
        instance.setMessageType("c");
        assertFalse(instance.getMessageTypeChanged());
    }

    /**
     * Test of getMessageLevelChanged method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageLevelChanged() throws Exception {
        System.out.println("getMessageLevelChanged");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        assertFalse(instance.getMessageLevelChanged());
        instance.setMessageLevel("X");
        assertTrue(instance.getMessageLevelChanged());
        
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
        
        assertFalse(instance.getMessageLevelChanged());
        instance.setMessageLevel("X");
        assertTrue(instance.getMessageLevelChanged());
        instance.setMessageLevel("d");
        assertFalse(instance.getMessageLevelChanged());
    }

    /**
     * Test of getMessageSummaryChanged method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageSummaryChanged() throws Exception {
        System.out.println("getMessageSummaryChanged");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        assertFalse(instance.getMessageSummaryChanged());
        instance.setMessageSummary("X");
        assertTrue(instance.getMessageSummaryChanged());
        
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
        
        assertFalse(instance.getMessageSummaryChanged());
        instance.setMessageSummary("X");
        assertTrue(instance.getMessageSummaryChanged());
        instance.setMessageSummary("f");
        assertFalse(instance.getMessageSummaryChanged());
    }

    /**
     * Test of getMessageDetailChanged method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageDetailChanged() throws Exception {
        System.out.println("getMessageDetailChanged");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        assertFalse(instance.getMessageDetailChanged());
        instance.setMessageDetail("X");
        assertTrue(instance.getMessageDetailChanged());
        
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
        
        assertFalse(instance.getMessageDetailChanged());
        instance.setMessageDetail("X");
        assertTrue(instance.getMessageDetailChanged());
        instance.setMessageDetail("e");
        assertFalse(instance.getMessageDetailChanged());
    }

    /**
     * Test of getMessageTypes method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageTypes() throws Exception {
        System.out.println("getMessageTypes");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = new OpbConnectionProvider() {
            public Connection getConnection() throws OpbException {
                try {
                    return TestHelper.getSharedOracleDataSource().getConnection();
                } catch (Exception ex) {
                    throw new OpbException("Failed to get connection from ds", ex);
                }
            }
        };
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        instance.getMessageTypes();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(null);
        
        try {
            instance.getMessageTypes();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(null);
        
        try {
            instance.getMessageTypes();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(null);
        
        try {
            instance.getMessageTypes();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        instance.setOpbEventTimerProvider(etp);
        java.util.List<OpbDynamicDataView> result = instance.getMessageTypes();
        
        assertTrue(result.size() > 0);
        
        for (OpbDynamicDataView view : result) {
            assertNotNull(view.get("value"));
            assertNotNull(view.get("label"));
        }
        
    }

    /**
     * Test of getMessageLevels method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetMessageLevels() throws Exception {
        System.out.println("getMessageLevels");
        
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        java.util.List<OpbDynamicDataView> result = instance.getMessageLevels();
        assertTrue(result.size() > 0);
        
        for (OpbDynamicDataView view : result) {
            assertNotNull(view.get("value"));
            assertNotNull(view.get("label"));
        }
    }

    /**
     * Test of addSessionMessage method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testAddSessionMessage() throws Exception {
        System.out.println("addSessionMessage");
        
        String pLevel = OpbMessages.MESSAGE_LEVEL_WARNING;
        String pSummary = "s";
        String pDetail = "d";
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        instance.addSessionMessage(pLevel, pSummary, pDetail);
        //see also testGetSessionMessages
    }

    /**
     * Test of getSessionMessages method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetSessionMessages() throws Exception {
        System.out.println("getSessionMessages");
        
        OpbMessages instance = null;
        
        try {
            instance = new OpbMessagesImpl();
            
            OpbEventTimerProvider etp = new OpbEventTimerProvider() {
                public OpbEventTimer getOpbEventTimer() {
                    return new OpbEventTimer();
                }
            };
            
            OpbConnectionProvider cp = session;
            
            OpbDataObjectSource dos = session.getDataObjectSource();
            dos.clearCached();
            
            instance.setOpbConnectionProvider(cp);
            instance.setOpbDataObjectSource(dos);
            instance.setOpbEventTimerProvider(etp);
            
            for (int i = 0; i < 3; i++) {
                java.util.List<OpbMessage> result = instance.getSessionMessages();
                assertEquals(1, result.size());
                OpbMessage msg = result.get(0);
                assertEquals("s", msg.getMessageSummary());
                assertEquals("d", msg.getMessageDetail());
                assertEquals(OpbMessages.MESSAGE_LEVEL_WARNING, msg.getMessageLevel());

            }
        } finally  {
            instance.clearAllMessages();
        }
        
    }

    /**
     * Test of addContextMessage method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testAddContextMessage() throws Exception {
        System.out.println("addContextMessage");
        
        String pContextName = "X";
        String pLevel = OpbMessages.MESSAGE_LEVEL_ERROR;
        String pSummary = "ctxS";
        String pDetail = "ctxD";
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        instance.addContextMessage(pContextName, pLevel, pSummary, pDetail);
        
        //see also testGetContextMessages
    }

    /**
     * Test of getContextMessages method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetContextMessages() throws Exception {
        System.out.println("getContextMessages");
        
        OpbMessages instance = null;
        
        try {
            instance = new OpbMessagesImpl();
            
            OpbEventTimerProvider etp = new OpbEventTimerProvider() {
                public OpbEventTimer getOpbEventTimer() {
                    return new OpbEventTimer();
                }
            };
            
            OpbConnectionProvider cp = session;
            
            OpbDataObjectSource dos = session.getDataObjectSource();
            dos.clearCached();
            
            instance.setOpbConnectionProvider(cp);
            instance.setOpbDataObjectSource(dos);
            instance.setOpbEventTimerProvider(etp);
            
            for (int i = 0; i < 3; i++) {
                java.util.List<OpbMessage> result = instance.getContextMessages("X");
                assertTrue(result.size() == 1);
                OpbMessage msg = result.get(0);
                assertEquals("ctxS", msg.getMessageSummary());
                assertEquals("ctxD", msg.getMessageDetail());
                assertEquals(OpbMessages.MESSAGE_LEVEL_ERROR, msg.getMessageLevel());

            }
            
            java.util.List<OpbMessage> result = instance.getContextMessages("%");
            assertTrue(result.size() == 1);
            OpbMessage msg = result.get(0);
            assertEquals("ctxS", msg.getMessageSummary());
            assertEquals("ctxD", msg.getMessageDetail());
            assertEquals(OpbMessages.MESSAGE_LEVEL_ERROR, msg.getMessageLevel());
            
            result = instance.getContextMessages("X%");
            assertTrue(result.size() == 1);
            msg = result.get(0);
            assertEquals("ctxS", msg.getMessageSummary());
            assertEquals("ctxD", msg.getMessageDetail());
            assertEquals(OpbMessages.MESSAGE_LEVEL_ERROR, msg.getMessageLevel());

            
        } finally  {
            instance.clearAllMessages();
        }
    }

    /**
     * Test of addAllContextMessage method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testAddAllContextMessage() throws Exception {
        System.out.println("addAllContextMessage");
        
        String pLevel = OpbMessages.MESSAGE_LEVEL_INFO;
        String pSummary = "allS";
        String pDetail = "allD";
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        instance.addAllContextMessage(pLevel, pSummary, pDetail);
        
        // see also testGetAllContextMessages
    }

    /**
     * Test of getAllContextMessages method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testGetAllContextMessages() throws Exception {
        System.out.println("getAllContextMessages");
        
        OpbMessages instance = null;
        
        try {
            instance = new OpbMessagesImpl();
            
            OpbEventTimerProvider etp = new OpbEventTimerProvider() {
                public OpbEventTimer getOpbEventTimer() {
                    return new OpbEventTimer();
                }
            };
            
            OpbConnectionProvider cp = session;
            
            OpbDataObjectSource dos = session.getDataObjectSource();
            dos.clearCached();
            
            instance.setOpbConnectionProvider(cp);
            instance.setOpbDataObjectSource(dos);
            instance.setOpbEventTimerProvider(etp);
            
            for (int i = 0; i < 3; i++) {
                java.util.List<OpbMessage> result = instance.getAllContextMessages();
                assertTrue(result.size() == 1);
                OpbMessage msg = result.get(0);
                assertEquals("allS", msg.getMessageSummary());
                assertEquals("allD", msg.getMessageDetail());
                assertEquals(OpbMessages.MESSAGE_LEVEL_INFO, msg.getMessageLevel());

            }
        } finally  {
            instance.clearAllMessages();
        }
        
    }

    /**
     * Test of clearSessionMessages method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testClearSessionMessages() throws Exception {
        System.out.println("clearSessionMessages");
        
        testAddSessionMessage();
        
        String pSessionId = session.getId();
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        assertTrue(instance.getSessionMessages().size() > 0);
        
        instance.clearSessionMessages(pSessionId);
        
        assertTrue(instance.getSessionMessages().isEmpty());
    }

    /**
     * Test of clearMessagesForContext method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testClearMessagesForContext() throws Exception {
        System.out.println("clearMessagesForContext");
        
        testAddContextMessage();
        
        String pContextName = "X";
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        assertFalse(instance.getContextMessages("X").isEmpty());
        
        instance.clearMessagesForContext(pContextName);
        
        assertTrue(instance.getContextMessages("X").isEmpty());
    }

    /**
     * Test of clearAllMessages method, of class com.butterfill.opb.messages.OpbMessages.
     */
    public void testClearAllMessages() throws Exception {
        System.out.println("clearAllMessages");
        
        testAddAllContextMessage();
        
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = session;
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbConnectionProvider(cp);
        instance.setOpbDataObjectSource(dos);
        instance.setOpbEventTimerProvider(etp);
        
        assertFalse(instance.getAllContextMessages().isEmpty());
        
        instance.clearAllMessages();
        
        assertTrue(instance.getAllContextMessages().isEmpty());
    }

    /**
     * Test of addMessage method, of class com.butterfill.opb.plsql.messages.OpbMessages.
     */
    public void testAddMessage() throws Exception {
        System.out.println("addMessage");
        
        String pLevel = OpbMessages.MESSAGE_LEVEL_FATAL;
        String pSummary = "summary_one";
        String pDetail = "detail_one";
        
        OpbMessages instance = new OpbMessagesImpl();
        
        OpbEventTimerProvider etp = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                return new OpbEventTimer();
            }
        };
        
        OpbConnectionProvider cp = TestHelper.getSharedOpbSession();
        
        OpbDataObjectSource dos = session.getDataObjectSource();
        dos.clearCached();
        
        instance.setOpbEventTimerProvider(etp);
        instance.setOpbConnectionProvider(cp);
        try {
            instance.getSessionMessages();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.setOpbDataObjectSource(dos);
        instance.setOpbConnectionProvider(null);
        try {
            instance.getSessionMessages();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.setOpbEventTimerProvider(null);
        instance.setOpbConnectionProvider(cp);
        try {
            instance.getSessionMessages();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.setOpbEventTimerProvider(etp);
        
        List<OpbMessage> list = instance.getSessionMessages();
        assertNotNull(list);
        assertTrue(list.isEmpty());
        
        instance.addMessage(pLevel, pSummary, pDetail);
        
        assertEquals(1, instance.getSessionMessages().size());
    }
    
}
