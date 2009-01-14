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


package com.butterfill.opb.session;

import com.butterfill.opb.plsql.messages.OpbMessages;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImpl;
import com.butterfill.opb.util.OpbScalarResultCache;
import java.util.List;
import junit.framework.*;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.groups.OpbGroupManager;
import helpers.TestHelper;
import java.util.ArrayList;

/**
 *
 * @author Peter Butterfill
 */
public class OpbSessionHelperTest extends TestCase {
    
    public OpbSessionHelperTest(String testName) {
        super(testName);
    }
    
    //OpbSession session;
    
    protected void setUp() throws Exception {
//        session = new OpbSessionPlsqlImpl("helperTest");
//        session.setDataObjectSource(new OpbDataObjectSource());
//        session.setGroupManager(new OpbGroupManager());
//        session.setScalarResultCache(new OpbScalarResultCache());
    }

    protected void tearDown() throws Exception {
        OpbSessionHelper.setSession(null);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbSessionHelperTest.class);
        
        return suite;
    }
    /**
     * Test of toString method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbSessionHelper instance = new OpbSessionHelper();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSession method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testGetSession() {
        System.out.println("getSession");
        
        try {
            OpbSessionHelper.getSession();
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSession expResult = TestHelper.getOpbSession();
        
        OpbSessionHelper.setSession(expResult);
        
        OpbSession result = OpbSessionHelper.getSession();
        assertEquals(expResult, result);
        
        OpbSessionHelper.setSession(null);
        try {
            OpbSessionHelper.getSession();
            fail();
        } catch (NullPointerException ex) {
        }
    }

    /**
     * Test of setSession method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testSetSession() {
        System.out.println("setSession");
        
        OpbSession opbSession = null;
        
        OpbSessionHelper.setSession(opbSession);
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
    }

    /**
     * Test of getAttribute method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testGetAttribute() {
        System.out.println("getAttribute");
        
        try {
            OpbSessionHelper.getAttribute("");
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        Object key = "k";
        
        Object expResult = null;
        Object result = OpbSessionHelper.getAttribute(key);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of putAttribute method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testPutAttribute() {
        System.out.println("putAttribute");
        
        try {
            OpbSessionHelper.putAttribute("", "");
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        Object key = "k";
        Object value = 32;
        
        OpbSessionHelper.putAttribute(key, value);
        
        assertEquals(32, OpbSessionHelper.getAttribute("k"));
        
    }

    /**
     * Test of clearSessionState method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testClearSessionState() {
        System.out.println("clearSessionState");
        
        try {
            OpbSessionHelper.clearSessionState();
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        OpbSessionHelper.clearSessionState();
        
    }

    /**
     * Test of endSession method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testEndSession() {
        System.out.println("endSession");
        
        try {
            OpbSessionHelper.endSession();
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSession session = TestHelper.getOpbSession();
        
        OpbSessionHelper.setSession(session);
        
        try {
            OpbSessionHelper.endSession();
            fail();
        } catch (NullPointerException ex) {
        }
        
        session.createSession();
        OpbSessionHelper.endSession();
        
    }

    /**
     * Test of getDataObjectSource method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testGetDataObjectSource() {
        System.out.println("getDataObjectSource");
        
        try {
            OpbSessionHelper.getDataObjectSource();
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        assertNotNull(OpbSessionHelper.getDataObjectSource());
        
    }

    /**
     * Test of getInstance method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        
        
        Class<OpbMessages> classOfObject = OpbMessages.class;
        String key = "";
        
        try {
            OpbSessionHelper.getInstance(classOfObject, key);
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        OpbMessages expResult = OpbSessionHelper.getInstance(classOfObject, key);
        OpbMessages result = OpbSessionHelper.getInstance(classOfObject, key);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getInstance method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testNewInstance() {
        System.out.println("newInstance");
        
        
        Class<OpbMessages> classOfObject = OpbMessages.class;
        
        try {
            OpbSessionHelper.newInstance(classOfObject);
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        OpbMessages expResult = OpbSessionHelper.newInstance(classOfObject);
        OpbMessages result = OpbSessionHelper.newInstance(classOfObject);
        assertNotSame(expResult, result);
        assertNotNull(expResult);
        assertNotNull(result);
        
    }

    /**
     * Test of getGroupManager method, of class com.butterfill.opb.session.OpbSessionHelper.
     */
    public void testGetGroupManager() {
        System.out.println("getGroupManager");
        
        try {
            OpbSessionHelper.getGroupManager();
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSessionHelper.setSession(TestHelper.getOpbSession());
        
        OpbGroupManager expResult = OpbSessionHelper.getGroupManager();
        OpbGroupManager result = OpbSessionHelper.getGroupManager();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of reCreateSession method, of class OpbSessionHelper.
     */
    public void testReCreateSession() {
        System.out.println("reCreateSession");
        
        try {
            OpbSessionHelper.reCreateSession();
            fail();
        } catch (NullPointerException ex) {
        }
        OpbSession session = TestHelper.getOpbSession();
        OpbSessionHelper.setSession(session);
        
        session.getAttributes().put("a", "A");
        
        assertEquals("A", session.getAttributes().get("a"));
        try {
            OpbSessionHelper.reCreateSession();
            fail();
        } catch (NullPointerException ex) {
        }
        assertEquals("A", session.getAttributes().get("a"));
        
        session.createSession();
        assertEquals("A", session.getAttributes().get("a"));
        
        OpbSessionHelper.reCreateSession();
        assertTrue(session.getAttributes().isEmpty());
    }

    /**
     * Test of getMember method, of class OpbSessionHelper.
     */
    public void testGetMember() {
        System.out.println("getMember");
        
        try {
            OpbSessionHelper.getMember("");
            fail();
        } catch (NullPointerException ex) {
        }
        OpbSession session = TestHelper.getOpbSession();
        OpbSessionHelper.setSession(session);
        
        Object expResult = new Object();
        session.getGroupManager().addMember("", expResult);
        Object result = OpbSessionHelper.getMember("");
        assertSame(expResult, result);
        
    }

    /**
     * Test of getMembers method, of class OpbSessionHelper.
     */
    public void testGetMembers() {
        System.out.println("getMembers");
        
        try {
            OpbSessionHelper.getMembers("");
            fail();
        } catch (NullPointerException ex) {
        }
        OpbSession session = TestHelper.getOpbSession();
        OpbSessionHelper.setSession(session);
        
        String groupName = "multipleMemberGroup";
        List<Object> expResult = new ArrayList<Object>();
        expResult.add(new Object());
        expResult.add("test member");
        
        OpbGroupManager gm = session.getGroupManager();
        
        for (Object o : expResult) {
            gm.addMember(groupName, o);
        }
        
        List<Object> result = OpbSessionHelper.getMembers(groupName);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAllMembers method, of class OpbSessionHelper.
     */
    public void testRemoveAllMembers() {
        System.out.println("removeAllMembers");
        
        try {
            OpbSessionHelper.removeAllMembers("");
            fail();
        } catch (NullPointerException ex) {
        }
        OpbSession session = TestHelper.getOpbSession();
        OpbSessionHelper.setSession(session);
        
        OpbGroupManager gm = session.getGroupManager();
        
        Object single = new Object();
        gm.addMember("single", single);
        
        List<Object> multiple = new ArrayList<Object>();
        multiple.add(new Object());
        multiple.add(Integer.MIN_VALUE);
        
        gm.addMember("multiple", multiple.get(0));
        gm.addMember("multiple", multiple.get(1));
        
        assertSame(single, gm.getMember("single"));
        assertEquals(multiple, gm.getMembers("multiple"));
        
        OpbSessionHelper.removeAllMembers("single");
        assertNull(gm.getMember("single"));
        
        assertEquals(multiple, gm.getMembers("multiple"));
        OpbSessionHelper.removeAllMembers("multiple");
        assertEquals(0, gm.getMembers("multiple").size());
        
    }
    
}
