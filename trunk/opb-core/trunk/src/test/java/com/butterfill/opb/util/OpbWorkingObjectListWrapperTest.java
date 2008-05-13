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


package com.butterfill.opb.util;

import java.util.ArrayList;
import junit.framework.*;
import java.util.List;

/**
 *
 * @author Peter Butterfill
 */
public class OpbWorkingObjectListWrapperTest extends TestCase {
    
    public OpbWorkingObjectListWrapperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbWorkingObjectListWrapperTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbWorkingObjectListWrapper instance = new Wrapper();
        System.out.println(instance);
    }

    /**
     * Test of getList method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testGetList() throws Exception {
        System.out.println("getList");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();

        List<String> expResult = instance.getList();
        List<String> result = instance.getList();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isListNotEmpty method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testIsListNotEmpty() throws Exception {
        System.out.println("isListNotEmpty");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        assertTrue(instance.isListNotEmpty());
        
        instance.getList().clear();
        assertFalse(instance.isListNotEmpty());
        
        instance = new WrapperOfNull();
        assertFalse(instance.isListNotEmpty());
        
    }

    /**
     * Test of getWorkingObject method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testGetWorkingObject() throws Exception {
        System.out.println("getWorkingObject");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        Object expResult = "a";
        Object result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = "b";
        result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance.previous();
        expResult = "a";
        result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance = new WrapperOfNull();
        assertNull(instance.getWorkingObject());
    }

    /**
     * Test of next method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testNext() throws Exception {
        System.out.println("next");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        Object expResult = "a";
        Object result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = "b";
        result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = "c";
        result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        for (int i = 0; i < 9; i++) {
            instance.next();
            result = instance.getWorkingObject();
            assertEquals(expResult, result);
        }
        
    }

    /**
     * Test of previous method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testPrevious() throws Exception {
        System.out.println("previous");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        Object expResult = "a";
        Object result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = "b";
        result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        instance.previous();
        expResult = "a";
        result = instance.getWorkingObject();
        assertEquals(expResult, result);
        
        for (int i = 0; i < 9; i++) {
            instance.previous();
            result = instance.getWorkingObject();
            assertEquals(expResult, result);
        }
        
    }

    /**
     * Test of isWorkingObjectLast method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testIsWorkingObjectLast() throws Exception {
        System.out.println("isWorkingObjectLast");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        boolean expResult = false;
        boolean result = instance.isWorkingObjectLast();
        assertEquals(expResult, result);
        
        for (int i = 0; i < instance.getList().size() - 1; i++) {
            instance.next();
        }
        expResult = true;
        result = instance.isWorkingObjectLast();
        assertEquals(expResult, result);
        
        instance.previous();
        expResult = false;
        result = instance.isWorkingObjectLast();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = true;
        result = instance.isWorkingObjectLast();
        assertEquals(expResult, result);
        
        instance.getList().clear();
        assertFalse(instance.isWorkingObjectLast());
        
        instance = new WrapperOfNull();
        assertFalse(instance.isWorkingObjectLast());
    }

    /**
     * Test of isWorkingObjectFirst method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testIsWorkingObjectFirst() throws Exception {
        System.out.println("isWorkingObjectFirst");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        boolean expResult = true;
        boolean result = instance.isWorkingObjectFirst();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = false;
        result = instance.isWorkingObjectFirst();
        assertEquals(expResult, result);
        
        instance.previous();
        expResult = true;
        result = instance.isWorkingObjectFirst();
        assertEquals(expResult, result);
        
        instance.getList().clear();
        assertFalse(instance.isWorkingObjectFirst());
        
        instance = new WrapperOfNull();
        assertFalse(instance.isWorkingObjectFirst());
    }

    /**
     * Test of getListSize method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testGetListSize() throws Exception {
        System.out.println("getListSize");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        int expResult = 3;
        int result = instance.getListSize();
        assertEquals(expResult, result);
        
        instance.getList().clear();
        expResult = 0;
        result = instance.getListSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getWorkingObjectIndex method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testGetWorkingObjectIndex() throws Exception {
        System.out.println("getWorkingObjectIndex");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        int expResult = 0;
        int result = instance.getWorkingObjectIndex();
        assertEquals(expResult, result);
        
        instance.next();
        expResult = 1;
        result = instance.getWorkingObjectIndex();
        assertEquals(expResult, result);
        
        instance.last();
        expResult = 2;
        result = instance.getWorkingObjectIndex();
        assertEquals(expResult, result);
        
        instance.getList().clear();
        expResult = 2;
        result = instance.getWorkingObjectIndex();
        assertEquals(expResult, result);
        
        // Note: clearing the list does not re-set the index.
        // getWorkingObject does
        
        instance.getWorkingObject();
        expResult = 0;
        result = instance.getWorkingObjectIndex();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of first method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testFirst() throws Exception {
        System.out.println("first");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        String expResult = null;
        String result = instance.first();
        assertEquals(expResult, result);
        assertEquals("a", instance.getWorkingObject());
        
        instance.next();
        assertEquals("b", instance.getWorkingObject());
        
        result = instance.first();
        assertEquals(expResult, result);
        assertEquals("a", instance.getWorkingObject());
        
    }

    /**
     * Test of last method, of class com.butterfill.opb.util.OpbWorkingObjectListWrapper.
     */
    public void testLast() throws Exception {
        System.out.println("last");
        
        OpbWorkingObjectListWrapper<String> instance = new Wrapper();
        
        String expResult = null;
        String result = instance.last();
        assertEquals(expResult, result);
        assertEquals("c", instance.getWorkingObject());
        
        instance.previous();
        assertEquals("b", instance.getWorkingObject());
        
        result = instance.last();
        assertEquals(expResult, result);
        assertEquals("c", instance.getWorkingObject());
        assertEquals(2, instance.getWorkingObjectIndex());
        
        instance.getList().clear();
        instance.last();
        assertEquals(0, instance.getWorkingObjectIndex());
        
        instance = new WrapperOfNull();
        instance.last();
        assertEquals(0, instance.getWorkingObjectIndex());
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.util.OpbWorkingObjectListWrapper. Please fill dummy bodies of generated methods.
     */
    private class Wrapper extends OpbWorkingObjectListWrapper<String> {

        List<String> list = new ArrayList<String>();
        
        {
            list.add("a");
            list.add("b");
            list.add("c");
        }
        
        public java.util.List<String> getList() {
            return list;
        }
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.util.OpbWorkingObjectListWrapper. Please fill dummy bodies of generated methods.
     */
    private class WrapperOfNull extends OpbWorkingObjectListWrapper {

        public java.util.List getList() {
            return null;
        }
    }



    
}
