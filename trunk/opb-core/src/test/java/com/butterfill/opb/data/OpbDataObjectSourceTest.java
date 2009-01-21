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

import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.OpbException;
import com.butterfill.opb.plsql.messages.OpbMessageImpl;
import com.butterfill.opb.plsql.messages.OpbMessagesImpl;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.SQLException;
import junit.framework.*;
import com.butterfill.opb.OpbId;
import com.butterfill.opb.OpbObjectSource;
import com.butterfill.opb.plsql.messages.OpbMessage;
import com.butterfill.opb.plsql.messages.OpbMessages;
import helpers.TestHelper;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Peter Butterfill
 */
public class OpbDataObjectSourceTest extends TestCase {
    
    OpbDataObjectSource instance;
    
    public OpbDataObjectSourceTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        instance = new OpbDataObjectSource(new OpbObjectSourceImpl());
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbDataObjectSourceTest.class);
        
        return suite;
    }

    public void testContructor() {
        try {
            new OpbDataObjectSource(null);
            fail();
        } catch (NullPointerException nullPointerException) {
        }
        
        new OpbDataObjectSource(new OpbObjectSourceImpl());
        
        new OpbDataObjectSource(new OpbObjectSource() {
            public <T> T newInstance(Class<T> interfaceOfInstance) 
                    throws OpbException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    
    /**
     * Test of toString method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testToString() {
        System.out.println("toString");
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addListener method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testAddListener() throws Exception {
        System.out.println("addListener");
        
        OpbDataObjectCreatedListener lsnr = null;
                
        Field field = OpbDataObjectSource.class.getDeclaredField(
                "dataObjectCreatedListeners");
        field.setAccessible(true);
        Set lsnrs = (Set)field.get(instance);
        assertEquals(0, lsnrs.size());
        
        for (int i = 0; i < 9; i++) {
            instance.addListener(lsnr);

            lsnrs = (Set)field.get(instance);
            assertEquals(0, lsnrs.size());
        }
        
        lsnr = new OpbDataObjectCreatedListener() {
            public void dataObjectCreated(Class c, Object dataObject, boolean cached) {
            }
        };
        
        for (int i = 0; i < 99; i++) {
            instance.addListener(lsnr);
            lsnrs = (Set)field.get(instance);

            assertEquals(1, lsnrs.size());
            assertTrue(lsnrs.contains(lsnr));
        }
        
        instance.removeListener(lsnr);
        lsnrs = (Set)field.get(instance);
        assertEquals(0, lsnrs.size());
        
        for (int i = 1; i < 99; i++) {
            lsnr = new OpbDataObjectCreatedListener() {
                public void dataObjectCreated(Class c, Object dataObject, boolean cached) {
                }
            };
            instance.addListener(lsnr);
            lsnrs = (Set)field.get(instance);

            assertEquals(i, lsnrs.size());
            assertTrue(lsnrs.contains(lsnr));
        }
        
    }

    /**
     * Test of removeListener method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testRemoveListener() throws Exception {
        System.out.println("removeListener");
        
        OpbDataObjectCreatedListener lsnr = null;
        
        Field field = OpbDataObjectSource.class.getDeclaredField(
                "dataObjectCreatedListeners");
        field.setAccessible(true);
        Set lsnrs = (Set)field.get(instance);
        assertEquals(0, lsnrs.size());
        
        instance.removeListener(lsnr);
        
        instance.addListener(new OpbDataObjectCreatedListener() {
            public void dataObjectCreated(Class c, Object dataObject, boolean cached) {
            }
        });
        
        lsnrs = (Set)field.get(instance);
        assertEquals(1, lsnrs.size());
        
        instance.removeListener(lsnr);
        
        lsnrs = (Set)field.get(instance);
        assertEquals(1, lsnrs.size());
        
        lsnr = new OpbDataObjectCreatedListener() {
            public void dataObjectCreated(Class c, Object dataObject, boolean cached) {
            }
        };
        
        instance.removeListener(lsnr);
        
        lsnrs = (Set)field.get(instance);
        assertEquals(1, lsnrs.size());
        
        instance.addListener(lsnr);
        lsnrs = (Set)field.get(instance);
        assertEquals(2, lsnrs.size());
        assertTrue(lsnrs.contains(lsnr));
        
        instance.removeListener(lsnr);
        
        lsnrs = (Set)field.get(instance);
        assertEquals(1, lsnrs.size());
        assertFalse(lsnrs.contains(lsnr));
        
    }

    /**
     * Test of invalidateCached method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testInvalidateCached() {
        System.out.println("invalidateCached");
        
        instance.invalidateCached();
        try {
            instance.invalidateCached(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.invalidateCached(OpbMessage.class);
        try {
            instance.invalidateCached(null, null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.invalidateCached(OpbMessage.class, null);
        instance.invalidateCached(OpbMessage.class, new OpbId());
        
    }

    /**
     * Test of clearCached method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testClearCached() {
        System.out.println("clearCached");
        
        instance.clearCached();
        try {
            instance.clearCached(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.clearCached(OpbMessage.class);
        try {
            instance.clearCached(null, null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.clearCached(OpbMessage.class, null);
        instance.clearCached(OpbMessage.class, new OpbId());
        
    }

    /**
     * Test of clearCachedResult method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testClearCachedResult() {
        System.out.println("clearCachedResult");
        
        Class<OpbMessage> classOfObject = OpbMessage.class;
        OpbId key = null;
        
        instance.clearCachedResult(classOfObject, key);
        instance.clearCachedResult(classOfObject, new OpbId());
        try {
            instance.clearCachedResult(null, new OpbId());
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
    }

    /**
     * Test of clearCachedResults method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testClearCachedResults() {
        System.out.println("clearCachedResults");
        
        instance.clearCachedResults();
        instance.clearCachedResults(OpbMessage.class);
        try {
            instance.clearCachedResults(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
    }

    /**
     * Test of isCached method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testIsCached() throws Exception {
        System.out.println("isCached");
        
        ResultSet rs = TestHelper.getResultSet(message9Sql);
        rs.next();
                
        OpbMessage message = new OpbMessageImpl();
        message.opbLoad(rs);
        
        Class<OpbMessage> classOfObject = OpbMessage.class;
        OpbId id = message.getOpbId();
        
        assertFalse(instance.isCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        assertTrue(instance.isCached(classOfObject, id));
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        //clean up
        instance.clearCached();
        assertFalse(instance.isCached(classOfObject, id));
        
        OpbId resultId = new OpbId("a");
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, resultId, true);
        assertTrue(instance.isCached(classOfObject, id));
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        //clean up
        instance.clearCached();
        assertFalse(instance.isCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, false);
        assertFalse(instance.isCached(classOfObject, id));
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, resultId, false);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertFalse(instance.isCached(classOfObject, id));
        
        // clear cached after get result call
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertTrue(instance.isCached(classOfObject, id));
        instance.clearCached();
        assertFalse(instance.isCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertTrue(instance.isCached(classOfObject, id));
        instance.clearCached(OpbMessage.class);
        assertFalse(instance.isCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertTrue(instance.isCached(classOfObject, id));
        instance.clearCached(OpbMessage.class, id);
        assertFalse(instance.isCached(classOfObject, id));
        
        //invalidate
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertTrue(instance.isCached(classOfObject, id));
        instance.invalidateCached();
        assertTrue(instance.isCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertTrue(instance.isCached(classOfObject, id));
        instance.invalidateCached(OpbMessage.class);
        assertTrue(instance.isCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(OpbMessage.class, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertTrue(instance.isCached(classOfObject, id));
        instance.invalidateCached(OpbMessage.class, id);
        assertTrue(instance.isCached(classOfObject, id));
        
        try {
            instance.isCached(null, id);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
    }

    /**
     * Test of getCached method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testGetCached() throws Exception {
        System.out.println("getCached");
        
        Class<OpbMessage> classOfObject = OpbMessage.class;
        OpbId id = null;
        
        OpbMessage expResult = null;
        OpbMessage result = instance.getCached(classOfObject, id);
        assertEquals(expResult, result);
        
        try {
            instance.getCached(null, id);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        id = new OpbId(new BigDecimal("9"));
        
        try {
            instance.getCached(null, id);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        ResultSet rs = TestHelper.getResultSet(message9Sql);
        
        List<OpbMessage> list = instance.getResult(classOfObject, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        OpbMessage message9 = list.get(0);
        
        assertNotNull(message9);
        assertSame(
                message9,
                instance.getCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message9Sql);
        instance.getResult(classOfObject, rs, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        assertSame(
                message9,
                instance.getCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message8Sql);
        OpbMessage message8 = instance.getResult(classOfObject, rs, true).get(0);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        assertNotNull(message8);
        assertSame(
                message8,
                instance.getCached(classOfObject, new OpbId(new BigDecimal("8"))));
        
        instance.clearCached(classOfObject, new OpbId(new BigDecimal("8")));
        message8 = instance.getCached(classOfObject, new OpbId(new BigDecimal("8")));
        assertNull(message8);
        
        assertSame(
                message9,
                instance.getCached(classOfObject, id));
        
        rs = TestHelper.getResultSet(message8Sql);
        message8 = instance.getResult(classOfObject, rs, true).get(0);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        List<OpbMessage> list2 = instance.getCached(classOfObject);
        
        assertTrue(list2.contains(message8));
        assertTrue(list2.contains(message9));
        assertEquals(2, list2.size());
        
    }

    /**
     * Test of getCachedResult method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testGetCachedResult() throws Exception {
        System.out.println("getCachedResult");
        
        Class<OpbMessage> classOfObject = OpbMessage.class;
        OpbId key = null;
        
        try {
            instance.getCachedResult(null, key);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        key = new OpbId("a");
        
        try {
            instance.getCachedResult(null, key);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        List<OpbMessage> expResult = null;
        List<OpbMessage> result = instance.getCachedResult(classOfObject, key);
        assertEquals(expResult, result);
        
        ResultSet rs = TestHelper.getResultSet(message9Sql);
        List<OpbMessage> list = instance.getResult(classOfObject, rs);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        assertNull(instance.getCachedResult(classOfObject, key));
        
        rs = TestHelper.getResultSet(message9Sql);
        list = instance.getResult(classOfObject, rs, key);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(list);
        
        for (int i = 0; i < 9; i++) {
            assertSame(list, instance.getCachedResult(classOfObject, key));
        }
        
        instance.clearCached(classOfObject, new OpbId(new BigDecimal("9")));
        
        assertNull(instance.getCachedResult(classOfObject, key));
        
        rs = TestHelper.getResultSet(message9Sql);
        list = instance.getResult(classOfObject, rs, key);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(list);
        assertSame(list, instance.getCachedResult(classOfObject, key));
        instance.clearCachedResult(classOfObject, key);
        assertNull(instance.getCachedResult(classOfObject, key));
        
        rs = TestHelper.getResultSet(message9Sql);
        list = instance.getResult(classOfObject, rs, key);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(list);
        assertSame(list, instance.getCachedResult(classOfObject, key));
        instance.clearCachedResults(classOfObject);
        assertNull(instance.getCachedResult(classOfObject, key));
        
        rs = TestHelper.getResultSet(message9Sql);
        list = instance.getResult(classOfObject, rs, key);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(list);
        assertSame(list, instance.getCachedResult(classOfObject, key));
        instance.clearCachedResults();
        assertNull(instance.getCachedResult(classOfObject, key));
        
        
        rs = TestHelper.getResultSet(message9Sql);
        list = instance.getResult(classOfObject, rs, key, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(list);
        assertSame(list, instance.getCachedResult(classOfObject, key));
        
        OpbId key2 = new OpbId("secondKey");
        rs = TestHelper.getResultSet(message9Sql);
        List<OpbMessage> list2 = instance.getResult(classOfObject, rs, key2, true);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(list2);
        assertSame(list2, instance.getCachedResult(classOfObject, key2));
        
        assertTrue(list.containsAll(list2));
        assertTrue(list2.containsAll(list));
        assertTrue(list != list2);
        
        instance.clearCached();
        
        assertNull(instance.getCachedResult(classOfObject, key2));
        assertNull(instance.getCachedResult(classOfObject, key));
        
    }

    /**
     * Test of getResult method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testGetResult() throws Exception {
        System.out.println("getResult");
        
        ResultSet rs = TestHelper.getResultSet(message9Sql);
        
        Class<OpbMessage> classOfObject = OpbMessage.class;
        
        try {
            instance.getResult(null, null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        try {
            instance.getResult(null, rs);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        try {
            instance.getResult(classOfObject, null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        List<OpbMessage> expResult = instance.getResult(classOfObject, rs);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        
        rs = TestHelper.getResultSet(message9Sql);
        List<OpbMessage> result = instance.getResult(classOfObject, rs);
        try {
            rs.getMetaData();
            fail("rs should be closed");
        } catch (SQLException ex) {
            assertTrue(ex.getMessage().startsWith("Closed Result"));
        }
        assertNotNull(expResult);
        assertNotNull(result);
        assertTrue(expResult != result);
        assertEquals(1, expResult.size());
        assertEquals(1, result.size());
        assertEquals(expResult.get(0).getOpbId(), result.get(0).getOpbId());
        assertTrue(expResult.get(0) != result.get(0));
        
    }

    /**
     * Test of newInstance method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testNewInstance() throws Exception {
        System.out.println("newInstance");
        
        try {
            instance.newInstance(PackagePrivate.class);
            fail();
        } catch (Exception ex) {
            assertTrue(ex.getCause() instanceof IllegalAccessException);
        }

        assertNotNull(instance.newInstance(OpbMessage.class));
        ActiveDataObject ado = instance.newInstance(ActiveDataObject.class);
        assertNotNull(ado);
        assertSame(instance, ado.getSource());
        
        DataObjectCreatedListener lsnr = new DataObjectCreatedListener();
        instance.addListener(lsnr);
        assertNull(lsnr.o);
        
        OpbMessage message = instance.newInstance(OpbMessage.class);
        assertSame(lsnr.o, message);
        assertFalse(lsnr.cached);
        
        lsnr.cached = true;
        ado = instance.newInstance(ActiveDataObject.class);
        assertSame(lsnr.o, ado);
        assertFalse(lsnr.cached);
        
        try {
            instance.newInstance(Object.class);
            fail("should have failed with a class not found");
        } catch (OpbException ex) {
            //ok
        }
        
        try {
            instance.newInstance(AnObject.class).getString();
            fail("should have failed with a class cast ex");
        } catch (OpbException ex) {
            //ok
        }

        // make sure config complete listeners get notified without having to register
        ConfigCompleteListener configCompleteListener =
                instance.newInstance(ConfigCompleteListener.class);

        assertTrue(configCompleteListener.getDataObjectConfigCompleteWasCalled());

    }

    /**
     * Test of getInstance method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        
        assertNotNull(instance.getInstance(OpbMessage.class, ""));
        ActiveDataObject ado = instance.getInstance(ActiveDataObject.class, "");
        assertNotNull(ado);
        assertSame(instance, ado.getSource());
        
        instance.clearInstances();
        DataObjectCreatedListener lsnr = new DataObjectCreatedListener();
        instance.addListener(lsnr);
        assertNull(lsnr.o);
        
        OpbMessage message = instance.getInstance(OpbMessage.class, "");
        assertSame(lsnr.o, message);
        assertFalse(lsnr.cached);
        
        lsnr.cached = true;
        ado = instance.getInstance(ActiveDataObject.class, "");
        assertSame(lsnr.o, ado);
        assertFalse(lsnr.cached);
        
        lsnr.cached = true;
        lsnr.o = null;
        for (int i = 0; i < 66; i++) {
            assertSame(message, instance.getInstance(OpbMessage.class, ""));
            assertNull(lsnr.o);
            assertTrue(lsnr.cached);

            assertSame(ado, instance.getInstance(ActiveDataObject.class, ""));
            assertNull(lsnr.o);
            assertTrue(lsnr.cached);
        }
        
        assertTrue(message != instance.getInstance(OpbMessage.class, " "));
        assertTrue(ado != instance.getInstance(ActiveDataObject.class, " "));
    }

    /**
     * Test of clearInstances method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testClearInstances() throws Exception {
        System.out.println("clearInstances");
        
        // create an instance of OpbMessagesImpl to make sure it's been compiled
        // and loaded. 
        OpbMessagesImpl x = new OpbMessagesImpl();
        
        instance.clearInstances();
        
        OpbMessage message = instance.getInstance(OpbMessage.class, "");
        assertSame(message, instance.getInstance(OpbMessage.class, ""));
        
        OpbMessages messages = instance.getInstance(OpbMessages.class, "");
        assertSame(messages, instance.getInstance(OpbMessages.class, ""));
        
        instance.clearInstances();
        assertTrue(message != instance.getInstance(OpbMessage.class, ""));
        assertTrue(messages != instance.getInstance(OpbMessages.class, ""));
        
        try {
            instance.clearInstances(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        instance.clearInstances(OpbMessage.class);
        
        message = instance.getInstance(OpbMessage.class, "");
        assertSame(message, instance.getInstance(OpbMessage.class, ""));
        
        messages = instance.getInstance(OpbMessages.class, "");
        assertSame(messages, instance.getInstance(OpbMessages.class, ""));
        
        instance.clearInstances(OpbMessage.class);
        assertTrue(message != instance.getInstance(OpbMessage.class, ""));
        assertSame(messages, instance.getInstance(OpbMessages.class, ""));
        
    }

    /**
     * Test of clearInstance method, of class com.butterfill.opb.data.OpbDataObjectSource.
     */
    public void testClearInstance() throws Exception {
        System.out.println("clearInstance");
        
        Class<OpbMessage> classOfObject = OpbMessage.class;
        String key = "";
        
        try {
            instance.clearInstance(null, null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        try {
            instance.clearInstance(null, key);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        instance.clearInstance(classOfObject, key);
        
        OpbMessage message = instance.getInstance(OpbMessage.class, "");
        
        assertSame(message, instance.getInstance(OpbMessage.class, ""));
        
        instance.clearInstance(classOfObject, " ");
        assertSame(message, instance.getInstance(OpbMessage.class, ""));
        
        instance.clearInstance(classOfObject, "");
        assertTrue(message != instance.getInstance(OpbMessage.class, ""));
        
    }

    String message7Sql = 
                "select 7 as id," +
                "       'ctx' as context_name," +
                "       'sessionId' as session_id," +
                "       'type' as message_type," +
                "       'level' as message_level," +
                "       'summary' as message_summary," +
                "       'detaiil' as message_detail" +
                "  from dual";
    
    String message8Sql = 
                "select 8 as id," +
                "       'ctx' as context_name," +
                "       'sessionId' as session_id," +
                "       'type' as message_type," +
                "       'level' as message_level," +
                "       'summary' as message_summary," +
                "       'detaiil' as message_detail" +
                "  from dual";
    
    String message9Sql = 
                "select 9 as id," +
                "       'ctx' as context_name," +
                "       'sessionId' as session_id," +
                "       'type' as message_type," +
                "       'level' as message_level," +
                "       'summary' as message_summary," +
                "       'detaiil' as message_detail" +
                "  from dual";
    
    
    static interface PackagePrivate {
    }
    
    static class PackagePrivateImpl implements PackagePrivate {
    }
    
    public static interface ActiveDataObject extends OpbActiveDataObject {
        public void setOpbDataObjectSource(OpbDataObjectSource source);
        
        public void setOpbConnectionProvider(OpbConnectionProvider provider);
        
        public OpbDataObjectSource getSource();

        public OpbConnectionProvider getProvider();

    }
    
    public static class ActiveDataObjectImpl implements ActiveDataObject {
        
        private OpbDataObjectSource source;
        public void setOpbDataObjectSource(OpbDataObjectSource source) {
            this.source = source;
        }
        
        private OpbConnectionProvider provider;
        public void setOpbConnectionProvider(OpbConnectionProvider provider) {
            this.provider = provider;
        }

        public OpbDataObjectSource getSource() {
            return source;
        }

        public OpbConnectionProvider getProvider() {
            return provider;
        }

    }
    
    public static class DataObjectCreatedListener implements OpbDataObjectCreatedListener{
        public Object o;
        public boolean cached;
        public void dataObjectCreated(Class c, Object dataObject, boolean cached) {
            o = dataObject;
            this.cached = cached;
        }
    };
    
    public static interface AnObject {
        String getString();
    }
    
    // Do NOT implement AnObject
    public static class AnObjectImpl {
        public String getString() {
            return "test string value";
        }
    }

    public static interface ConfigCompleteListener extends OpbDataObjectConfigCompleteListener {
        public boolean getDataObjectConfigCompleteWasCalled();
    }

    public static class ConfigCompleteListenerImpl implements ConfigCompleteListener {

        private boolean dataObjectConfigCompleteWasCalled;

        public boolean getDataObjectConfigCompleteWasCalled() {
            return dataObjectConfigCompleteWasCalled;
        }

        public void dataObjectConfigComplete(Class requestedType, Object dataObject, boolean cached) {
            assertSame(this, dataObject);
            dataObjectConfigCompleteWasCalled = true;
        }

    }

}
