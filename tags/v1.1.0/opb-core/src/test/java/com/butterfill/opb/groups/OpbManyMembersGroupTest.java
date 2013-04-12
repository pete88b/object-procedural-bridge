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
import com.butterfill.opb.util.*;
import java.util.List;

/**
 * @author Peter Butterfill
 */
public class OpbManyMembersGroupTest extends TestCase {
    
    public OpbManyMembersGroupTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbManyMembersGroupTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getGroupName method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testGetGroupName() {
        System.out.println("getGroupName");
        
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        String expResult = null;
        String result = instance.getGroupName();
        assertEquals(expResult, result);
        
        instance = new OpbManyMembersGroup("name");
        expResult = "name";
        result = instance.getGroupName();
        assertEquals(expResult, result);
        
    }

    private Object _testAddMemberObject;
    
    private Object _getTestAddMemberObject() {
        return _testAddMemberObject;
    }
    
    /**
     * Test of addMember method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testAddMember() {
        System.out.println("addMember");
        
        Object object = null;
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        instance.addMember(object);
        assertEquals(0, instance.getMembers().size());
        
        instance.addMember("");
        assertEquals(1, instance.getMembers().size());
        assertTrue(instance.isMember(""));
        assertEquals("", instance.getMembers().get(0));
        
        instance.removeAllMembers();
        assertEquals(0, instance.getMembers().size());
        assertFalse(instance.isMember(""));
        
        Object[] objects = new Object[9];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
            instance.addMember(objects[i]);
            assertTrue(instance.isMember(objects[i]));
        }
        for (int i = 0; i < objects.length; i++) {
            assertTrue(instance.isMember(objects[i]));
            instance.removeMember(objects[i]);
            assertFalse(instance.isMember(objects[i]));
            for (int j = i+1; j < objects.length; j++) {
                assertTrue(instance.isMember(objects[j]));
            }
        }
        
        
        OpbGroupMemberWrapper w = new OpbGroupMemberWrapper() {
            public Object getValue() {
                return _getTestAddMemberObject();
            }
            public void setValue(Object value) {
            }
        };
        
        instance.addMember(w);
        assertEquals(0, instance.getMembers().size());
        assertFalse(instance.isMember(w));
        assertFalse(instance.isMember(_testAddMemberObject));
        
        _testAddMemberObject = new Object();
        instance.addMember(w);
        assertEquals(1, instance.getMembers().size());
        assertTrue(instance.isMember(w));
        assertTrue(instance.isMember(_testAddMemberObject));
        
        _testAddMemberObject = new Object();
        assertEquals(1, instance.getMembers().size());
        assertTrue(instance.isMember(w));
        assertTrue(instance.isMember(_testAddMemberObject));
        
        _testAddMemberObject = null;
        assertEquals(0, instance.getMembers().size());
        assertFalse(instance.isMember(w));
        assertFalse(instance.isMember(_testAddMemberObject));
        
        _testAddMemberObject = new Object();
        assertEquals(0, instance.getMembers().size());
        assertFalse(instance.isMember(w));
        assertFalse(instance.isMember(_testAddMemberObject));
        
    }

    /**
     * Test of removeMember method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testRemoveMember() {
        System.out.println("removeMember");
        
        Object[] objects = new Object[88];
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        instance.removeMember(null);
        
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
            assertFalse(instance.isMember(objects[i]));
            instance.addMember(objects[i]);
            assertTrue(instance.isMember(objects[i]));
            instance.removeMember(objects[i]);
            assertFalse(instance.isMember(objects[i]));
            instance.addMember(objects[i]);
            instance.removeMember(null);
        }
        
        for (int i = 0; i < objects.length; i++) {
            assertTrue(instance.isMember(objects[i]));
            instance.removeMember(objects[i]);
            for (int j = i+1; j < objects.length; j++) {
                assertTrue(instance.isMember(objects[j]));
                instance.removeMember(null);
            }
        }
        
        Object o = new Object();
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        h.setValue(o);
        instance.addMember(h);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMember(new Object());
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        h.setValue(new Object());
        instance.removeMember(o);
        assertFalse(instance.isMember(o));
        assertTrue(instance.isMember(h));
        h.setValue(o);
        assertTrue(instance.isMember(h));
        instance.removeMember(o);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(h));
        
    }

    /**
     * Test of removeAllMembers method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testRemoveAllMembers() {
        System.out.println("removeAllMembers");
        
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        instance.removeAllMembers();
        
        assertEquals(0, instance.getMembers().size());
        
        Object[] objects = new Object[76];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = "" + i;
            instance.addMember(objects[i]);
            assertTrue(instance.isMember(objects[i]));
        }
        
        assertEquals(objects.length, instance.getMembers().size());
        
        instance.removeAllMembers();
        assertEquals(0, instance.getMembers().size());
        for (int i = 0; i < objects.length; i++) {
            assertFalse(instance.isMember(objects[i]));
        }
        
    }

    /**
     * Test of removeMembersByClass method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testRemoveMembersByClass() {
        System.out.println("removeMembersByClass");
        
        Class classOfObject = null;
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        instance.removeMembersByClass(classOfObject);
        
        Object o = new Object();
        Object s = "testObject";
        instance.addMember(o);
        instance.addMember(s);
        
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(s));
        
        instance.removeMembersByClass(String.class);
        assertTrue(instance.isMember(o));
        assertFalse(instance.isMember(s));
        
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(s));
        
        instance.addMember(o);
        instance.addMember(s);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(s));
        
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        assertTrue(instance.isMember(s));
        
        instance.removeMembersByClass(String.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(s));
        
        OpbGroupMemberWrapperImpl<Object> ho = new OpbGroupMemberWrapperImpl<Object>();
        ho.setValue(o);
        OpbGroupMemberWrapperImpl<Object> hs = new OpbGroupMemberWrapperImpl<Object>();
        hs.setValue(s);
        
        instance.addMember(ho);
        instance.addMember(hs);
        
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(ho));
        assertTrue(instance.isMember(s));
        assertTrue(instance.isMember(hs));
        
        instance.removeMembersByClass(String.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(ho));
        assertFalse(instance.isMember(s));
        assertFalse(instance.isMember(hs));
        
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(ho));
        assertFalse(instance.isMember(s));
        assertFalse(instance.isMember(hs));
        
        instance.addMember(o);
        instance.addMember(s);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(ho));
        assertTrue(instance.isMember(s));
        assertTrue(instance.isMember(hs));
        
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(ho));
        assertTrue(instance.isMember(s));
        assertTrue(instance.isMember(hs));
        
        instance.removeMembersByClass(String.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(ho));
        assertFalse(instance.isMember(s));
        assertFalse(instance.isMember(hs));
        
        
    }

    /**
     * Test of isMember method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    @SuppressWarnings(value="unchecked")
    public void testIsMember() {
        System.out.println("isMember");
        
        Object object = null;
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(null));
        
        Object[] objects = new Object[45];
        OpbGroupMemberWrapperImpl[] holders = new OpbGroupMemberWrapperImpl[45];
        for (int i = 0; i < holders.length; i++) {
            objects[i] = new Object();
            holders[i] = new OpbGroupMemberWrapperImpl<Object>();
            holders[i].setValue(objects[i]);
            instance.addMember(objects[i]);
            assertTrue(instance.isMember(objects[i]));
            assertTrue(instance.isMember(holders[i]));
            instance.removeMember(objects[i]);
            assertFalse(instance.isMember(objects[i]));
            assertFalse(instance.isMember(holders[i]));
            
            instance.addMember(holders[i]);
            assertTrue(instance.isMember(objects[i]));
            assertTrue(instance.isMember(holders[i]));
            instance.removeMember(objects[i]);
            assertFalse(instance.isMember(objects[i]));
            assertFalse(instance.isMember(holders[i]));
            
            instance.addMember(objects[i]);
            assertTrue(instance.isMember(objects[i]));
            assertTrue(instance.isMember(holders[i]));
            instance.removeMember(holders[i]);
            assertFalse(instance.isMember(objects[i]));
            assertFalse(instance.isMember(holders[i]));
            
            instance.addMember(holders[i]);
            assertTrue(instance.isMember(objects[i]));
            assertTrue(instance.isMember(holders[i]));
            instance.removeMember(holders[i]);
            assertFalse(instance.isMember(objects[i]));
            assertFalse(instance.isMember(holders[i]));
            
            instance.addMember(holders[i]);
            
        }
        
        for (int i = 0; i < holders.length; i++) {
            assertTrue(instance.isMember(objects[i]));
            assertTrue(instance.isMember(holders[i]));
            holders[i].setValue(null);
            assertFalse(instance.isMember(objects[i]));
            assertFalse(instance.isMember(holders[i]));
            for (int j = i+1; j < holders.length; j++) {
                assertTrue(instance.isMember(objects[j]));
                assertTrue(instance.isMember(holders[j]));
            }
            holders[i].setValue(objects[i]);
            assertFalse(instance.isMember(objects[i]));
            assertFalse(instance.isMember(holders[i]));
        }
        
    }

    /**
     * Test of getMembers method, of class com.butterfill.opb.groups.OpbManyMembersGroup.
     */
    public void testGetMembers() {
        System.out.println("getMembers");
        
        OpbManyMembersGroup instance = new OpbManyMembersGroup();
        
        List<Object> result = instance.getMembers();
        
        instance.addMember(null);
        assertTrue(instance.getMembers().isEmpty());
        
        Object o = new Object();
        Object o2 = new Object();
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        h.setValue(o);
        OpbGroupMemberWrapperImpl<Object> h2 = new OpbGroupMemberWrapperImpl<Object>();
        h2.setValue(o2);
        
        instance.addMember(h);
        instance.addMember(h2);
        assertEquals(2, instance.getMembers().size());
        
        h.setValue(null);
        h2.setValue(null);
        assertEquals(0, instance.getMembers().size());
        
        h.setValue(o);
        h2.setValue(o2);
        assertEquals(0, instance.getMembers().size());
        
        Object[] objects = new Object[33];
        for (int i = 0; i < objects.length; i++) {
            assertEquals(i, instance.getMembers().size());
            objects[i] = new Object();
            instance.addMember(objects[i]);
            for (int j = 0; j <= i; j++) {
                assertTrue(instance.getMembers().contains(objects[i]));
                assertTrue(instance.isMember(objects[i]));
            }
            
        }
        assertEquals(objects.length, instance.getMembers().size());
    }
    
}
