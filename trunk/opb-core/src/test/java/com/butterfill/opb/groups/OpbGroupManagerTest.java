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


package com.butterfill.opb.groups;

import junit.framework.*;

/**
 *
 * @author Peter Butterfill
 */
public class OpbGroupManagerTest extends TestCase {
    
    public OpbGroupManagerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbGroupManagerTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbGroupManager instance = new OpbGroupManager();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of newGroupManagerMap method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testNewGroupManagerMap() {
        System.out.println("newGroupManagerMap");
        
        Object object = "anObject";
        OpbGroupManager instance = new OpbGroupManager();
        
        OpbGroupManagerMap expResult = new OpbGroupManagerMap(instance, object);
        OpbGroupManagerMap result = instance.newGroupManagerMap(object);
        
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                object = new Object();
            }
            String g = "g" + i;
            assertFalse(expResult.get(g));
            assertEquals(expResult.get(g), result.get(g));

            expResult.put(g, true);
            assertTrue(expResult.get(g));
            assertEquals(expResult.get(g), result.get(g));

            result.put(g, false);
            assertFalse(expResult.get(g));
            assertEquals(expResult.get(g), result.get(g));

        }
        
        
        
    }

    /**
     * Test of addMember method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testAddMember() {
        System.out.println("addMember");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        OpbGroupManager instance = new OpbGroupManager();
        
        OpbGroupMemberWrapper w = new OpbGroupMemberWrapper() {
            public Object getValue() {
                return null;
            }
            public void setValue(Object value) {
            }
        };
        
        instance.addMember(groupName, null);
        assertFalse(instance.isMember(groupName, null));
        
        instance.addMember(groupName, w);
        assertFalse(instance.isMember(groupName, null));
        assertFalse(instance.isMember(groupName, w));
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        
        for (int i = 0; i < 9; i++) {
            instance.addMember(groupName, object);
            assertTrue(instance.isMember(groupName, object));
            assertFalse(instance.isMember(groupName, object2));

            instance.addMember(groupName, object2);
            assertFalse(instance.isMember(groupName, object));
            assertTrue(instance.isMember(groupName, object2));
        }
        
        groupName = "multiple";
        
        instance.addMember(groupName, null);
        assertFalse(instance.isMember(groupName, null));
        
        instance.addMember(groupName, w);
        assertFalse(instance.isMember(groupName, null));
        assertFalse(instance.isMember(groupName, w));
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        
        for (int i = 0; i < 9; i++) {
            instance.addMember(groupName, object);
            instance.addMember(groupName, object2);
            assertTrue(instance.isMember(groupName, object));
            assertTrue(instance.isMember(groupName, object2));
            assertEquals(2, instance.getMembers(groupName).size());
            
        }
        
        // single group test - adding wrapped objects
        instance = new OpbGroupManager();
        
        groupName = "single2";
        
        object = new OpbGroupMemberWrapper() {
            public Object getValue() {
                return "testValue";
            }
            public void setValue(Object value) {
            }
        };
        
        instance.addMember(groupName, object);
        
        assertTrue(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, "testValue"));
        
        instance.removeMember(object);
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, "testValue"));
        
        instance.addMember(groupName, object);
        
        assertTrue(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, "testValue"));
        
        instance.removeMember("testValue");
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, "testValue"));
        
    }

    /**
     * Test of removeMember method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testRemoveMember() {
        System.out.println("removeMember");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        OpbGroupManager instance = new OpbGroupManager();
        
        final Object object3 = new Object();
        
        OpbGroupMemberWrapper w = new OpbGroupMemberWrapper() {
            public Object getValue() {
                return object3;
            }
            public void setValue(Object value) {
            }
        };
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        instance.removeMember(groupName, object);
        instance.removeMember(groupName, object2);
        instance.removeMember(groupName, object3);
        instance.removeMember(groupName, w);
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        instance.addMember(groupName, object);
        assertTrue(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        instance.removeMember(groupName, object);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        instance.addMember(groupName, object3);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertTrue(instance.isMember(groupName, object3));
        assertTrue(instance.isMember(groupName, w));
        
        instance.removeMember(w);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        instance.addMember(groupName, w);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertTrue(instance.isMember(groupName, object3));
        assertTrue(instance.isMember(groupName, w));
        
        instance.removeMember(object3);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        groupName = "multiple";
        
        instance.removeMember(groupName, object);
        instance.removeMember(groupName, object2);
        instance.removeMember(object3);
        instance.removeMember(w);
        
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
        instance.addMember(groupName, object);
        instance.addMember(groupName, object2);
        instance.addMember(groupName, object3);
        assertTrue(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, object2));
        assertTrue(instance.isMember(groupName, object3));
        assertTrue(instance.isMember(groupName, w));
        
        instance.removeMember(object2);
        assertTrue(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertTrue(instance.isMember(groupName, object3));
        assertTrue(instance.isMember(groupName, w));
        
        instance.removeMember(object);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertTrue(instance.isMember(groupName, object3));
        assertTrue(instance.isMember(groupName, w));
        
        instance.removeMember(object3);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, object3));
        assertFalse(instance.isMember(groupName, w));
        
    }

    /**
     * Test of removeAllMembers method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testRemoveAllMembers() {
        System.out.println("removeAllMembers");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        OpbGroupManager instance = new OpbGroupManager();
        
        instance.removeAllMembers(groupName);
        
        instance.addMember(groupName, object);
        assertTrue(instance.isMember(groupName, object));
        
        instance.removeAllMembers(groupName);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        
        instance.addMember(groupName, object2);
        assertTrue(instance.isMember(groupName, object2));
        
        instance.removeAllMembers(groupName);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        
        groupName = "multiple";
        
        instance.addMember(groupName, object);
        instance.addMember(groupName, object2);
        assertTrue(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, object2));
        
        instance.removeAllMembers(groupName);
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        
    }

    /**
     * Test of removeMembersByClass method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testRemoveMembersByClass() {
        System.out.println("removeMembersByClass");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        Class classOfObject = null;
        OpbGroupManager instance = new OpbGroupManager();
        
        instance.removeMembersByClass(groupName, classOfObject);
        
        classOfObject = String.class;
        
        instance.removeMembersByClass(groupName, classOfObject);
        
        instance.addMember(groupName, object);
        assertTrue(instance.isMember(groupName, object));
        
        instance.removeMembersByClass(groupName, classOfObject);
        assertTrue(instance.isMember(groupName, object));
        
        instance.addMember(groupName, "string");
        assertFalse(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, "string"));
        
        instance.removeMembersByClass(groupName, classOfObject);
        assertFalse(instance.isMember(groupName, "string"));
        
        groupName = "multiple";
        
        instance.addMember(groupName, object);
        instance.addMember(groupName, object2);
        instance.addMember(groupName, "s");
        assertTrue(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, object2));
        assertTrue(instance.isMember(groupName, "s"));
        
        instance.removeMembersByClass(groupName, classOfObject);
        assertTrue(instance.isMember(groupName, object));
        assertTrue(instance.isMember(groupName, object2));
        assertFalse(instance.isMember(groupName, "s"));
        
    }

    /**
     * Test of removeAllGroups method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testRemoveAllGroups() {
        System.out.println("removeAllGroups");
        
        String groupName = "single";
        String groupName2 = "multiple";
        OpbGroupManager instance = new OpbGroupManager();
        
        assertEquals(0, instance.getMembers(groupName).size());
        assertEquals(0, instance.getMembers(groupName2).size());
        
        instance.removeAllGroups();
        
        assertEquals(0, instance.getMembers(groupName).size());
        assertEquals(0, instance.getMembers(groupName2).size());
        
        instance.addMember(groupName, "");
        instance.addMember(groupName2, "");
        
        assertEquals(1, instance.getMembers(groupName).size());
        assertEquals(1, instance.getMembers(groupName2).size());
        
        instance.removeAllGroups();
        
        assertEquals(0, instance.getMembers(groupName).size());
        assertEquals(0, instance.getMembers(groupName2).size());
        
        
        
    }

    /**
     * Test of isMember method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testIsMember() {
        System.out.println("isMember");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        OpbGroupManager instance = new OpbGroupManager();
        
        assertFalse(instance.isMember(groupName, null));
        
        instance.addMember(groupName, null);
        assertFalse(instance.isMember(groupName, null));
        
        for (int i = 0; i < 9; i++) {
            instance.addMember(groupName, object);
            assertTrue(instance.isMember(groupName, object));
            assertFalse(instance.isMember(groupName, object2));

            instance.addMember(groupName, object2);
            assertFalse(instance.isMember(groupName, object));
            assertTrue(instance.isMember(groupName, object2));
        }
        
        groupName = "multiple";
        assertFalse(instance.isMember(groupName, object));
        assertFalse(instance.isMember(groupName, object2));
        
        for (int i = 0; i < 9; i++) {
            instance.addMember(groupName, object);
            instance.addMember(groupName, object2);
            assertTrue(instance.isMember(groupName, object));
            assertTrue(instance.isMember(groupName, object2));
            if (i > 5) {
                instance.removeAllMembers(groupName);
                assertFalse(instance.isMember(groupName, object));
                assertFalse(instance.isMember(groupName, object2));
            }
        }
        
    }

    /**
     * Test of getMember method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testGetMember() throws Exception {
        System.out.println("getMember");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        OpbGroupManager instance = new OpbGroupManager();
        
        assertNull(instance.getMember(groupName));
        
        for (int i = 0; i < 5; i++) {
            instance.addMember(groupName, object);
            assertEquals(object, instance.getMember(groupName));
            instance.addMember(groupName, object2);
            assertEquals(object2, instance.getMember(groupName));
        }
        
        groupName = "multiple";
        try {
            instance.getMember(groupName);
            fail("get member should fail for multiple group");
        } catch (UnsupportedOperationException ex) {
            //ok
        }
        
    }

    /**
     * Test of getMembers method, of class com.butterfill.opb.groups.OpbGroupManager.
     */
    public void testGetMembers() {
        System.out.println("getMembers");
        
        String groupName = "single";
        Object object = new Object();
        Object object2 = new Object();
        OpbGroupManager instance = new OpbGroupManager();
        
        assertEquals(0, instance.getMembers(groupName).size());
        
        instance.addMember(groupName, "x");
        assertEquals("x", instance.getMembers(groupName).get(0));
        
        for (int i = 0; i < 5; i++) {
            instance.addMember(groupName, object);
            assertEquals(object, instance.getMembers(groupName).get(0));
            assertEquals(1, instance.getMembers(groupName).size());
            instance.addMember(groupName, object2);
            assertEquals(object2, instance.getMembers(groupName).get(0));
            assertEquals(1, instance.getMembers(groupName).size());
        }
        
        groupName = "multiple";
        
        assertEquals(0, instance.getMembers(groupName).size());
        instance.addMember(groupName, object);
        assertEquals(object, instance.getMembers(groupName).get(0));
        assertEquals(1, instance.getMembers(groupName).size());

        instance.removeAllGroups();
        instance.addMember(groupName, object2);
        assertEquals(object2, instance.getMembers(groupName).get(0));
        assertEquals(1, instance.getMembers(groupName).size());
        
        
        instance.addMember(groupName, object);
        assertTrue(instance.getMembers(groupName).contains(object));
        assertTrue(instance.getMembers(groupName).contains(object2));
        assertEquals(2, instance.getMembers(groupName).size());
    }

    
}
