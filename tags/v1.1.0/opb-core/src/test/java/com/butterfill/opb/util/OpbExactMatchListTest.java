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

import com.butterfill.opb.OpbId;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.*;
import java.util.Collection;

/**
 *
 * @author Peter Butterfill
 */
public class OpbExactMatchListTest extends TestCase {
    
    public OpbExactMatchListTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbExactMatchListTest.class);
        
        return suite;
    }

    /**
     * Test constructors
     */
    public void testConstructors() throws Exception {
        // no-args constructor
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        Field field = instance.getClass().getDeclaredField("elementData");
        field.setAccessible(true);
        
        Object[] elementData = (Object[])field.get(instance);
        
        assertEquals(10, elementData.length);
        
        // specific capacity constructor
        instance = new OpbExactMatchList<String>(32);
        elementData = (Object[])field.get(instance);
        assertEquals(32, elementData.length);
        
        // collection constructor
        Collection<String> c = new LinkedList<String>();
        for (int i = 0; i < 12; i++) {
            c.add(""+i);
        }
        
        instance = new OpbExactMatchList<String>(c);
        elementData = (Object[])field.get(instance);
        assertEquals(12, elementData.length);
        
        for (int i = 0; i < 12; i++) {
            assertEquals(""+i, instance.get(i));
        }
        
        try {
            new OpbExactMatchList(-1);
            fail();
        } catch (IllegalArgumentException ex) {
        }
        
    }
    
    /**
     * Test of trimToSize method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testTrimToSize() throws Exception {
        System.out.println("trimToSize");
        
        OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
        
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        Field field = instance.getClass().getDeclaredField("elementData");
        field.setAccessible(true);
        
        Object[] elementData = (Object[])field.get(instance);
        
        assertEquals(10, elementData.length);
        
        instance.trimToSize();
        
        elementData = (Object[])field.get(instance);
        assertEquals(0, elementData.length);
        
        for (int i = 0; i < 99; i++) {
            instance.add(""+i);
            elementData = (Object[])field.get(instance);
            // make sure that element data is at least as long as i
            assertTrue(
                    "elementData was not as long as expected. elementData.length=" +
                    elementData.length + ". i=" + i,
                    elementData.length >= i);

            instance.trimToSize();
            elementData = (Object[])field.get(instance);
            assertEquals(i + 1, elementData.length);
        }
        
           for (int i = 98; i >= 0; i--) {
            instance.remove(i);
            elementData = (Object[])field.get(instance);
            assertEquals(i + 1, elementData.length);
            instance.trimToSize();
            elementData = (Object[])field.get(instance);
            assertEquals(i, elementData.length);
        }
        
    }

    /**
     * Test of ensureCapacity method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testEnsureCapacity() throws Exception {
        System.out.println("ensureCapacity");
        
        // test with default initial capacity of 10
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        Field field = instance.getClass().getDeclaredField("elementData");
        field.setAccessible(true);
        
        Object[] elementData = (Object[])field.get(instance);
        
        assertEquals(10, elementData.length);
        
        instance.ensureCapacity(0);
        elementData = (Object[])field.get(instance);
        assertEquals(10, elementData.length);

        instance.ensureCapacity(10);
        elementData = (Object[])field.get(instance);
        assertEquals(10, elementData.length);
        
        for (int i = 10; i < 99; i++) {
            instance.ensureCapacity(i);
            elementData = (Object[]) field.get(instance);
            // make sure that element data is at least as long as i
            assertTrue(
                    "elementData was not as long as expected. elementData.length=" +
                    elementData.length + ". i=" + i,
                    elementData.length >= i);
        }
        instance.ensureCapacity(5);
        elementData = (Object[]) field.get(instance);
        assertEquals(133, elementData.length);

        // test elementData size increade with non-default initial capacity
        instance = new OpbExactMatchList<String>(100);
        elementData = (Object[]) field.get(instance);
        assertEquals(100, elementData.length);

        instance.ensureCapacity(100);
        // instance can already cope with this capacity so no change
        elementData = (Object[]) field.get(instance);
        assertEquals(100, elementData.length);

        instance.ensureCapacity(101);
        // instance will need to increase capacity, by 50% + 1
        elementData = (Object[]) field.get(instance);
        assertEquals(151, elementData.length);

        instance.ensureCapacity(152);
        // instance will need to increase capacity, by 50% + 1
        elementData = (Object[]) field.get(instance);
        assertEquals(227, elementData.length);

    }

    /**
     * Test of size method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testSize() {
        System.out.println("size");
        
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        
        for (int i = 0; i < 99; i++) {
            instance.add("");
            assertEquals(i+1, instance.size());
        }
        
        for (int i = 98; i >= 0; i--) {
            assertEquals(i+1, instance.size());
            instance.remove(i);
            assertEquals(i, instance.size());
        }
        
        Collection<String> c = new ArrayList<String>();
        c.add("");
        c.add("");
        c.add("");
        instance = new OpbExactMatchList<String>(c);
        assertEquals(3, instance.size());
        
        instance.remove("");
        assertEquals(2, instance.size());
        instance.remove("");
        assertEquals(1, instance.size());
        instance.remove("");
        assertEquals(0, instance.size());
        
        instance = new OpbExactMatchList<String>();
        instance.add("");
        instance.add(0, "");
        assertEquals(2, instance.size());
        
        instance.clear();
        assertEquals(0, instance.size());
        
        instance.addAll(c);
        assertEquals(3, instance.size());
        instance.addAll(c);
        assertEquals(6, instance.size());
        instance.addAll(c);
        assertEquals(9, instance.size());
        instance.addAll(c);
        assertEquals(12, instance.size());
        
        instance.addAll(0, c);
        assertEquals(15, instance.size());
        
        instance.removeRange(0, 1);
        assertEquals(14, instance.size());
        instance.removeRange(10, 14);
        assertEquals(10, instance.size());
        
    }

    /**
     * Test of isEmpty method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
        
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
        instance.add("");
        assertEquals(false, instance.isEmpty());
        
        instance.clear();
        assertEquals(true, instance.isEmpty());
        
        Collection<String> c = new ArrayList<String>();
        instance.addAll(c);
        assertEquals(true, instance.isEmpty());
        
        c.add("");
        instance.addAll(c);
        assertEquals(false, instance.isEmpty());
        
    }

    /**
     * Test of contains method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testContains() {
        System.out.println("contains");
        
        Object o = null;
        OpbExactMatchList<Object> instance = 
                new OpbExactMatchList<Object>();
        
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        
        result = instance.contains(null);
        assertEquals(expResult, result);
        
        instance.add(o);
        assertEquals(true, instance.contains(o));
        
        instance.remove(o);
        assertEquals(false, instance.contains(o));
        
        instance.add(o);
        instance.add(null);
        assertEquals(true, instance.contains(o));
        instance.remove(o);
        assertEquals(true, instance.contains(o));
        instance.remove(o);
        assertEquals(false, instance.contains(o));
        
        assertTrue(instance.isEmpty());
        
        instance.add("");
        assertEquals(true, instance.contains(""));
        
        o = new OpbId("x", "y");
        instance.add(o);
        assertEquals(true, instance.contains(o));
        
        instance.remove(o);
        assertEquals(false, instance.contains(o));
        
        
    }

    /**
     * Test of indexOf method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testIndexOf() {
        System.out.println("indexOf");
        
        OpbId o = null;
        OpbExactMatchList<OpbId> instance = new OpbExactMatchList<OpbId>();
        
        int expResult = -1;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        
        o = new OpbId(1, 2, 3);
        instance.add(o);
        assertEquals(0, instance.indexOf(o));
        assertEquals(-1, instance.indexOf(new OpbId(1, 2, 3)));
        instance.add(o);
        assertEquals(0, instance.indexOf(o));
        instance.remove(o);
        assertEquals(0, instance.indexOf(o));
        instance.remove(o);
        assertEquals(-1, instance.indexOf(o));
        
        instance.add(new OpbId(""));
        assertEquals(-1, instance.indexOf(o));
        instance.add(o);
        assertEquals(1, instance.indexOf(o));
        
    }

    /**
     * Test of lastIndexOf method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        
        String o = "s";
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        assertEquals(-1, instance.lastIndexOf(o));
        
        for (int i = 0; i < 9; i++) {
            instance.add(o);
            assertEquals(i, instance.lastIndexOf(o));
        }
        
        for (int i = 8; i >= 0; i--) {
            assertEquals(i, instance.lastIndexOf(o));
            instance.remove(o);
        }
        
        assertEquals(-1, instance.lastIndexOf(o));
        
        instance.clear();
        instance.add("a");
        instance.add("b");
        instance.add("c");
        instance.add("a");
        instance.add("b");
        instance.add("c");
        assertEquals(3, instance.lastIndexOf("a"));
        assertEquals(4, instance.lastIndexOf("b"));
        assertEquals(5, instance.lastIndexOf("c"));
        assertEquals(-1, instance.lastIndexOf(o));
        
    }

    /**
     * Test of toArray method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testToArray() {
        System.out.println("toArray");
        
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        assertEquals(0, instance.toArray().length);
        
        for (int i = 1; i < 99; i++) {
            instance.add(i+"");
            assertEquals(i, instance.toArray().length);
        }
        
        for (int i = 1; i < 99; i++) {
            assertEquals(i+"", instance.toArray()[i - 1]);
        }
        
        assertNotSame(instance.toArray(), instance.toArray());
        
        instance.clear();
        instance.add("a");
        instance.add("b");
        instance.add("c");
        
        // array is just long enough to hold all elements
        String[] expected = new String[3];
        assertSame(expected, instance.toArray(expected));
        assertEquals("a", expected[0]);
        assertEquals("b", expected[1]);
        assertEquals("c", expected[2]);
        
        // array is more then long enough to hold all elements
        expected = new String[5];
        assertSame(expected, instance.toArray(expected));
        assertEquals("a", expected[0]);
        assertEquals("b", expected[1]);
        assertEquals("c", expected[2]);
        assertNull(expected[3]);
        assertNull(expected[4]);
        
        // array is more then long enough to hold all elements
        expected = new String[]{"a", "b", "c", "d", "e"};
        assertSame(expected, instance.toArray(expected));
        assertEquals("a", expected[0]);
        assertEquals("b", expected[1]);
        assertEquals("c", expected[2]);
        assertNull(expected[3]);
        assertEquals("e", expected[4]);
        
        // array is too small to hold all elements
        String[] notExpected = new String[]{};
        String[] result = instance.toArray(notExpected);
        assertNotSame(notExpected, result);
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
        
    }

    /**
     * Test of get method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testGet() {
        System.out.println("get");
        
        int index = 0;
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        try {
            instance.get(index);
            fail("should throw index out of bounds");
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        
        Object expResult = null;
        instance.add(null);
        Object result = instance.get(index);
        assertEquals(expResult, result);
        
        instance.clear();
        
        for (int i = 0; i < 99; i++) {
            String s = new String(i+"");
            instance.add(s);
            assertSame(s, instance.get(i));
        }
        
        for (int i = 0; i < 99; i++) {
            String s = i+"";
            assertEquals(s, instance.get(i));
            assertNotSame(s, instance.get(i));
        }
        
    }

    /**
     * Test of set method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testSet() {
        System.out.println("set");
        
        int index = 0;
        Object element = null;
        OpbExactMatchList<Object> instance = new OpbExactMatchList<Object>();
        try {
            instance.set(index, element);
            fail("should have thrown an ondex out of bounds");
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        
        instance.add("x");
        assertSame("x", instance.get(0));
        
        Object expResult = "x";
        Object result = instance.set(index, element);
        assertEquals(expResult, result);
        assertEquals(element, instance.get(0));
        
        instance.clear();
        instance.trimToSize();
        
        for (int i = 0; i < 99; i++) {
            Object o = new Integer(i);
            try {
                instance.set(i, o);
                fail("should have thrown an ondex out of bounds");
            } catch (IndexOutOfBoundsException ex) {
                //ok
            }
            Object o2 = new Object();
            instance.add(o2);
            assertSame(o2, instance.set(i, o));
            assertSame(o, instance.get(i));
            
        }
        
    }

    /**
     * Test of add method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testAdd() {
        System.out.println("add");
        
        OpbExactMatchList<Object> instance = new OpbExactMatchList<Object>();
        
        for (int i = 0; i < 127; i++) {
            assertEquals(i, instance.size());
            assertTrue(instance.add(i));
            assertEquals(i+1, instance.size());
            assertSame(i, instance.get(i));
        }
        
        for (int i = 0; i < 127; i++) {
            //System.out.format("i=%s%n", i);
            assertEquals(i+127, instance.size());
            instance.add(i*2, i);
            assertEquals(i+128, instance.size());
            //System.out.format("getting=%s. val=%s%n", i * 2 + 1, instance.get(i * 2 + 1));
            assertSame(i, instance.get((i * 2) + 1));
            //System.out.format("getting=%s. val=%s%n", i * 2, instance.get(i * 2));
            assertSame(i, instance.get(i * 2));
        }
        
        instance.clear();
        
        try {
            instance.add(0, "b");
            fail();
        } catch (IndexOutOfBoundsException ex) {
        }
        
        assertTrue(instance.isEmpty());
        instance.add("a");
        instance.add(0, "b");
        assertEquals(2, instance.size());
        assertEquals("b", instance.get(0));
        assertEquals("a", instance.get(1));
        
        
    }

    /**
     * Test of remove method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testRemove() {
        System.out.println("remove");
        
        int index = 0;
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
        
        for (int i = 0; i < 99; i++) {
            try {
                instance.remove(i);
                fail("should have thrown an index out of bounds");
            } catch (IndexOutOfBoundsException ex) {
            }
        }
        
        Object expResult = null;
        instance.add(null);
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());
        
        for (int i = 0; i < 99; i++) {
            instance.add(""+i);
        }
        
        for (int i = 0; i < 99; i++) {
            assertEquals(""+i, instance.remove(0));
        }
        
        instance.clear();
        
        String[] strings = new String[99];
        for (int i = 0; i < 99; i++) {
            strings[i] = new String("x");
            instance.add(strings[i]);
        }
        
        assertEquals(99, instance.size());
        
        for (int i = 0; i < strings.length; i++) {
            assertTrue(instance.contains(strings[i]));
            assertTrue(instance.remove(strings[i]));
            assertFalse(instance.contains(strings[i]));
            assertFalse(instance.remove(strings[i]));
            
        }
        
        assertTrue(instance.isEmpty());
        
        String s = new String("s");
        
        instance.add(s);
        instance.add(s);
        
        assertTrue(instance.contains(s));
        assertTrue(instance.remove(s));
        assertTrue(instance.contains(s));
        assertTrue(instance.remove(s));
        assertFalse(instance.contains(s));
        assertFalse(instance.remove(s));
        
    }

    /**
     * Test of clear method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testClear() {
        System.out.println("clear");
        
        OpbExactMatchList<Integer> instance = new OpbExactMatchList<Integer>();
        
        instance.clear();
        
        for (int i = 0; i < 9999; i++) {
            instance.add(i);
            assertEquals(i+1, instance.size());
            assertFalse(instance.isEmpty());
        }
        
        instance.clear();
        assertEquals(0, instance.size());
        assertTrue(instance.isEmpty());
        
    }

    /**
     * Test of addAll method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testAddAll() {
        System.out.println("addAll");
        
        Collection<Object> c = null;
        OpbExactMatchList<Object> instance = new OpbExactMatchList<Object>();
        
        try {
            instance.addAll(c);
            fail("should have thrown a null pointer");
        } catch (NullPointerException ex) {
            //ok
        }
        
        c = new ArrayList<Object>();
        assertFalse(instance.addAll(c));
        assertTrue(instance.isEmpty());
        
        for (int i = 0; i < 99; i++) {
            c.add(i);
        }
        
        assertTrue(instance.addAll(c));
        assertEquals(c.size(), instance.size());
        
        for (Iterator i = c.iterator(); i.hasNext(); ) {
            assertTrue(instance.contains(i.next()));
        }
        
        instance.addAll(c);
        assertEquals(c.size() * 2, instance.size());
        
        for (int i = 0; i < 198; i++) {
            assertEquals(i % 99, instance.get(i));
        }
        
        c.clear();
        c.add("x");
        c.add("y");
        c.add("z");
        
        instance.addAll(99, c);
        
        assertEquals("x", instance.get(99));
        assertEquals("y", instance.get(100));
        assertEquals("z", instance.get(101));
        
        assertEquals(201, instance.size());
        
        instance.clear();
        instance.addAll(c);
        instance.addAll(c);
        c.clear();
        assertFalse(instance.addAll(3, c));
        c.add("a");
        c.add("b");
        c.add("c");
        assertTrue(instance.addAll(3, c));
        assertEquals("x", instance.get(0));
        assertEquals("y", instance.get(1));
        assertEquals("z", instance.get(2));
        assertEquals("a", instance.get(3));
        assertEquals("b", instance.get(4));
        assertEquals("c", instance.get(5));
        assertEquals("x", instance.get(6));
        assertEquals("y", instance.get(7));
        assertEquals("z", instance.get(8));
        
        c.clear();
        assertFalse(instance.addAll(3, c));
        assertEquals("x", instance.get(0));
        assertEquals("y", instance.get(1));
        assertEquals("z", instance.get(2));
        assertEquals("a", instance.get(3));
        assertEquals("b", instance.get(4));
        assertEquals("c", instance.get(5));
        assertEquals("x", instance.get(6));
        assertEquals("y", instance.get(7));
        assertEquals("z", instance.get(8));
        
        try {
            instance.addAll(999, c);
            fail();
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            instance.addAll(-1, c);
            fail();
        } catch (IndexOutOfBoundsException ex) {
        }
        try {
            instance.addAll(instance.size(), c);
            fail();
        } catch (IndexOutOfBoundsException ex) {
        }
        
        instance.addAll(instance.size() - 1, c);
        
    }

    /**
     * Test of removeRange method, of class com.butterfill.opb.util.OpbExactMatchList.
     */
    public void testRemoveRange() {
        System.out.println("removeRange");
        
        OpbExactMatchList<String> instance = new OpbExactMatchList<String>();
                
        try {
            instance.removeRange(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        try {
            instance.removeRange(0, 0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        try {
            instance.removeRange(0, 1);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        try {
            instance.removeRange(0, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        
        instance.add("a");
        instance.removeRange(0, 0);
        assertEquals(1, instance.size());
        
        try {
            instance.removeRange(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        try {
            instance.removeRange(1, 0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        try {
            instance.removeRange(0, 2);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        try {
            instance.removeRange(1, 0);
            fail();
        } catch (IndexOutOfBoundsException ex) {
            //ok
        }
        instance.removeRange(0, 1);
        assertEquals(0, instance.size());
        instance.clear();
        
        instance.add("a");
        instance.add("b");
        instance.add("c");
        
        assertEquals("a", instance.get(0));
        assertEquals("b", instance.get(1));
        assertEquals("c", instance.get(2));
        assertEquals(3, instance.size());
        
        instance.removeRange(2, 3);
        
        assertEquals("a", instance.get(0));
        assertEquals("b", instance.get(1));
        assertEquals(2, instance.size());
        
        instance.add("c");
        
        assertEquals("a", instance.get(0));
        assertEquals("b", instance.get(1));
        assertEquals("c", instance.get(2));
        assertEquals(3, instance.size());
        
        instance.removeRange(1, 2);
        
        assertEquals("a", instance.get(0));
        assertEquals("c", instance.get(1));
        assertEquals(2, instance.size());
        
    }
    
}
