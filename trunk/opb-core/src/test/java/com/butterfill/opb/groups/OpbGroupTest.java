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
import java.util.List;

/**
 *
 * @author Peter Butterfill
 */
public class OpbGroupTest extends TestCase {
    
    public OpbGroupTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbGroupTest.class);
        
        return suite;
    }

    /**
     * Test of addMember method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testAddMember() {
        System.out.println("addMember");
        
        Object object = null;
        OpbGroup instance = new OpbGroupImpl();
        
        instance.addMember(object);
        
    }

    /**
     * Test of getGroupName method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testGetGroupName() {
        System.out.println("getGroupName");
        
        OpbGroup instance = new OpbGroupImpl();
        
        String expResult = null;
        String result = instance.getGroupName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMembers method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testGetMembers() {
        System.out.println("getMembers");
        
        OpbGroup instance = new OpbGroupImpl();
        
        List<Object> expResult = null;
        List<Object> result = instance.getMembers();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isMember method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testIsMember() {
        System.out.println("isMember");
        
        Object object = null;
        OpbGroup instance = new OpbGroupImpl();
        
        boolean expResult = false;
        boolean result = instance.isMember(object);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeAllMembers method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testRemoveAllMembers() {
        System.out.println("removeAllMembers");
        
        OpbGroup instance = new OpbGroupImpl();
        
        instance.removeAllMembers();
        
    }

    /**
     * Test of removeMember method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testRemoveMember() {
        System.out.println("removeMember");
        
        Object object = null;
        OpbGroup instance = new OpbGroupImpl();
        
        instance.removeMember(object);
        
    }

    /**
     * Test of removeMembersByClass method, of class com.butterfill.opb.groups.OpbGroup.
     */
    public void testRemoveMembersByClass() {
        System.out.println("removeMembersByClass");
        
        Class classOfObject = null;
        OpbGroup instance = new OpbGroupImpl();
        
        instance.removeMembersByClass(classOfObject);
        
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.groups.OpbGroup. Please fill dummy bodies of generated methods.
     */
    private class OpbGroupImpl implements OpbGroup {

        public void addMember(java.lang.Object object) {
            
        }

        public java.lang.String getGroupName() {
            
            
            return null;
        }

        public java.util.List<java.lang.Object> getMembers() {
            
            
            return null;
        }

        public boolean isMember(java.lang.Object object) {
            
            
            return false;
        }

        public void removeAllMembers() {
            
            
        }

        public void removeMember(java.lang.Object object) {
            
            
        }

        public void removeMembersByClass(java.lang.Class classOfObject) {
            
            
        }
    }

    
}
