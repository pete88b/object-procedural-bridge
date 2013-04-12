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

import java.math.BigDecimal;
import junit.framework.*;
import com.butterfill.opb.util.*;

/**
 *
 * @author Peter Butterfill
 */
public class OpbSingleMemberGroupTest extends TestCase {
    
    public OpbSingleMemberGroupTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbSingleMemberGroupTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getGroupName method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testGetGroupName() {
        System.out.println("getGroupName");
        
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        String expResult = null;
        String result = instance.getGroupName();
        assertEquals(expResult, result);
        
        instance = new OpbSingleMemberGroup("name");
        assertEquals("name", instance.getGroupName());
        
    }

    /**
     * Test of addMember method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testAddMember() {
        System.out.println("addMember");
        
        Object object = null;
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        instance.addMember(object);
        instance.addMember("");
        instance.addMember(new BigDecimal("8758345"));
        instance.addMember(null);
        object = new Object();
        instance.addMember(object);
        instance.addMember(new OpbGroupMemberWrapper() {
            public Object getValue() {
                return null;
            }
            public void setValue(Object value) {
            }
        });
        
        
        OpbGroupMemberWrapperImpl<Object> w = new OpbGroupMemberWrapperImpl<Object>();
        w.setValue(w);
        instance.addMember(w);
    }

    /**
     * Test of removeMember method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testRemoveMember() {
        System.out.println("removeMember");
        
        Object object = null;
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        assertNull(instance.getMember());
        
        instance.removeMember(object);
        
        assertNull(instance.getMember());
        
        object = new Object();
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        h.setValue(object);
        
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        instance.addMember(object);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeMember(new Object());
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeMember(object); // remove directly
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
        
        instance.addMember(object);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeMember(h); // remove via wrapper
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
        //wrapper
        object = new Object();
        
        h.setValue(object);
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        instance.addMember(h);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeMember(new Object());
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeMember(object); // remove directly
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
        instance.addMember(h);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeMember(h); // remove via wrapper
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
        //
        object = new Object();
        
        h.setValue(object);
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        instance.addMember(h);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        h.setValue(null);
        instance.removeMember(object);
        h.setValue(object);
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
    }

    /**
     * Test of removeAllMembers method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testRemoveAllMembers() {
        System.out.println("removeAllMembers");
        
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        instance.removeAllMembers();
        
        Object object = new Object();
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        h.setValue(object);
        
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        instance.addMember(object);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeAllMembers();
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
        instance.addMember(h);
        assertTrue(instance.isMember(object));
        assertTrue(instance.isMember(h));
        instance.removeAllMembers();
        assertFalse(instance.isMember(object));
        assertFalse(instance.isMember(h));
        
    }

    /**
     * Test of removeMembersByClass method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testRemoveMembersByClass() {
        System.out.println("removeMembersByClass");
        
        Class classOfObject = null;
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        instance.removeMembersByClass(classOfObject);
        
        Object o = new Object();
        assertFalse(instance.isMember(o));
        instance.addMember(o);
        assertTrue(instance.isMember(o));
        instance.removeMembersByClass(String.class);
        assertTrue(instance.isMember(o));
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        h.setValue(o);
        instance.addMember(o);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(String.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(OpbGroupMemberWrapperImpl.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(OpbGroupMemberWrapper.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(h));
        
        instance.addMember(h);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(String.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(OpbGroupMemberWrapperImpl.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(OpbGroupMemberWrapper.class);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMembersByClass(Object.class);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(h));
        
        instance.addMember(h);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        h.setValue(null);
        instance.removeMembersByClass(String.class);
        h.setValue(o);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(h));
        
    }

    /**
     * Test of isMember method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testIsMember() {
        System.out.println("isMember");
        
        Object o = null;
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        assertFalse(instance.isMember(o));
        instance.addMember(o);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(null));
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        h.setValue(o);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(h));
        instance.addMember(h);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(h));
        
        o = new Object();
        assertFalse(instance.isMember(o));
        instance.addMember(o);
        assertTrue(instance.isMember(o));
        assertFalse(instance.isMember(h));
        assertFalse(instance.isMember(null));
        h.setValue(o);
        assertTrue(instance.isMember(h));
        assertTrue(instance.isMember(o));
        instance.removeAllMembers();
        assertFalse(instance.isMember(h));
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(null));
        
        instance.addMember(h);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        assertFalse(instance.isMember(null));
        instance.removeAllMembers();
        assertFalse(instance.isMember(h));
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(null));
        
        instance.addMember(h);
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        assertFalse(instance.isMember(null));
        Object o2 = new Object();
        h.setValue(o2);
        assertFalse(instance.isMember(o));
        assertTrue(instance.isMember(h));
        assertTrue(instance.isMember(o2));
        assertFalse(instance.isMember(null));
        h.setValue(o);
        assertTrue(instance.isMember(o));
        assertFalse(instance.isMember(o2));
        assertTrue(instance.isMember(h));
        assertFalse(instance.isMember(null));
        h.setValue(null);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(o2));
        assertFalse(instance.isMember(h));
        assertFalse(instance.isMember(null));
        h.setValue(o);
        assertFalse(instance.isMember(o));
        assertFalse(instance.isMember(o2));
        assertFalse(instance.isMember(h));
        assertFalse(instance.isMember(null));
    }

    /**
     * Test of getMember method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testGetMember() {
        System.out.println("getMember");
        
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        Object o = null;
        assertSame(o, instance.getMember());
        o = new Object();
        instance.addMember(o);
        assertSame(o, instance.getMember());
        
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        instance.addMember(h);
        assertNull(instance.getMember());
        h.setValue(o);
        assertNull(instance.getMember());
        instance.addMember(h);
        assertSame(o, instance.getMember());
        assertTrue(instance.isMember(o));
        assertTrue(instance.isMember(h));
        instance.removeMember(o);
        assertNull(instance.getMember());
        
        instance.addMember(h);
        assertSame(o, instance.getMember());
        Object o2 = new Object();
        h.setValue(o2);
        assertSame(o2, instance.getMember());
        h.setValue(o);
        assertSame(o, instance.getMember());
        h.setValue(null);
        assertNull(instance.getMember());
        h.setValue(o);
        assertNull(instance.getMember());
        
        
    }

    /**
     * Test of getMembers method, of class com.butterfill.opb.groups.OpbSingleMemberGroup.
     */
    public void testGetMembers() {
        System.out.println("getMembers");
        
        OpbSingleMemberGroup instance = new OpbSingleMemberGroup();
        
        assertEquals(0, instance.getMembers().size());
        instance.removeAllMembers();
        assertEquals(0, instance.getMembers().size());
        instance.removeMember(new Object());
        assertEquals(0, instance.getMembers().size());
        instance.removeMembersByClass(Object.class);
        assertEquals(0, instance.getMembers().size());
        instance.addMember(null);
        assertEquals(0, instance.getMembers().size());
        OpbGroupMemberWrapperImpl<Object> h = new OpbGroupMemberWrapperImpl<Object>();
        instance.addMember(h);
        assertEquals(0, instance.getMembers().size());
        
        Object o = new Object();
        instance.addMember(o);
        assertSame(o, instance.getMembers().get(0));
        instance.addMember(null);
        assertEquals(0, instance.getMembers().size());
        
        h.setValue(o);
        instance.addMember(h);
        assertSame(o, instance.getMembers().get(0));
        Object o2 = new Object();
        h.setValue(o2);
        assertSame(o2, instance.getMembers().get(0));
        h.setValue(null);
        assertEquals(0, instance.getMembers().size());
        h.setValue(o);
        assertEquals(0, instance.getMembers().size());
        
        
    }
    
}
