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
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbGroupManagerMapTest extends TestCase {

    public OpbGroupManagerMapTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbGroupManagerMapTest.class);

        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testToString() {
        System.out.println("toString");

        OpbGroupManagerMap instance = new OpbGroupManagerMap(new OpbGroupManager(), null);

        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testSize() {
        System.out.println("size");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).size();
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of isEmpty method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).isEmpty();
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }

    }

    /**
     * Test of containsKey method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testContainsKey() {
        System.out.println("containsKey");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).containsKey(null);
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of containsValue method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testContainsValue() {
        System.out.println("containsValue");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).containsValue(null);
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of get method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testGet() {
        System.out.println("get");

        OpbGroupManager manager = new OpbGroupManager();
        Object o = new Object();

        OpbGroupManagerMap instance = manager.newGroupManagerMap(o);
        assertFalse(instance.get("a"));
        assertFalse(instance.get("b"));
        assertFalse(instance.get("c"));

        manager.addMember("b", o);
        assertFalse(instance.get("a"));
        assertTrue(instance.get("b"));
        assertFalse(instance.get("c"));

        manager.removeMember(o);
        assertFalse(instance.get("a"));
        assertFalse(instance.get("b"));
        assertFalse(instance.get("c"));

        Object[] objects = new Object[32];
        OpbGroupManagerMap[] maps = new OpbGroupManagerMap[32];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
            maps[i] = manager.newGroupManagerMap(objects[i]);
            manager.addMember("a", objects[i]);
            assertTrue(maps[i].get("a"));
            assertFalse(maps[i].get("b"));
        }

    }

    /**
     * Test of put method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testPut() {
        System.out.println("put");

        OpbGroupManager manager = new OpbGroupManager();
        Object o = new Object();

        OpbGroupManagerMap instance = manager.newGroupManagerMap(o);

        assertFalse(instance.get("a"));
        assertFalse(instance.get("b"));
        assertFalse(instance.get("c"));

        instance.put("b", true);
        assertFalse(instance.get("a"));
        assertTrue(instance.get("b"));
        assertFalse(instance.get("c"));

        instance.put("b", false);
        assertFalse(instance.get("a"));
        assertFalse(instance.get("b"));
        assertFalse(instance.get("c"));

        Object[] objects = new Object[32];
        OpbGroupManagerMap[] maps = new OpbGroupManagerMap[32];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
            maps[i] = manager.newGroupManagerMap(objects[i]);
            maps[i].put("a", true);
            assertTrue(maps[i].get("a"));
            assertFalse(maps[i].get("b"));
            assertTrue(manager.isMember("a", objects[i]));
            maps[i].put("a", false);
            assertFalse(maps[i].get("a"));
            assertFalse(manager.isMember("a", objects[i]));
            assertFalse(maps[i].get("b"));
        }

    }

    /**
     * Test of remove method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testRemove() {
        System.out.println("remove");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).remove(null);
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of putAll method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testPutAll() {
        System.out.println("putAll");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).putAll(null);
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of clear method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testClear() {
        System.out.println("clear");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).clear();
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of keySet method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testKeySet() {
        System.out.println("keySet");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).keySet();
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of values method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testValues() {
        System.out.println("values");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).values();
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

    /**
     * Test of entrySet method, of class com.butterfill.opb.groups.OpbGroupManagerMap.
     */
    public void testEntrySet() {
        System.out.println("entrySet");

        try {
            new OpbGroupManagerMap(new OpbGroupManager(), null).entrySet();
            fail();
        } catch (UnsupportedOperationException ex) {
            //ok
        }
    }

}
