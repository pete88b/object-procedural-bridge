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

import junit.framework.*;
import com.butterfill.opb.OpbId;

/**
 *
 * @author Peter Butterfill
 */
public class OpbScalarResultCacheTest extends TestCase {
    
    public OpbScalarResultCacheTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbScalarResultCacheTest.class);
        
        return suite;
    }
    
    /**
     * Test of toString method, of class com.butterfill.opb.util.OpbScalarResultCache.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbScalarResultCache instance = new OpbScalarResultCache();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isCached method, of class com.butterfill.opb.util.OpbScalarResultCache.
     */
    public void testIsCached() {
        System.out.println("isCached");
        
        OpbId key = null;
        OpbScalarResultCache instance = new OpbScalarResultCache();
        
        assertFalse(instance.isCached(key));
        assertFalse(instance.isCached(null));
        key = new OpbId("a");
        assertFalse(instance.isCached(key));
        instance.cache(key, null);
        assertTrue(instance.isCached(key));
        instance.cache(key, new Object());
        assertTrue(instance.isCached(key));
        instance.clearCached(key);
        assertFalse(instance.isCached(key));
        instance.cache(key, new Object());
        assertTrue(instance.isCached(key));
        instance.clearCached();
        assertFalse(instance.isCached(key));
    }

    /**
     * Test of getCached method, of class com.butterfill.opb.util.OpbScalarResultCache.
     */
    public void testGetCached() {
        System.out.println("getCached");
        
        OpbId key = null;
        OpbScalarResultCache instance = new OpbScalarResultCache();
        
        try {
            instance.getCached(null, key);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        Object expResult = null;
        assertNull(instance.getCached(Object.class, key));
        
        key = new OpbId("b");
        
        try {
            instance.getCached(null, key);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        instance.cache(key, null);
        assertNull(instance.getCached(Object.class, key));
        
        expResult = new Object();
        instance.cache(key, expResult);
        assertEquals(expResult, instance.getCached(Object.class, key));
        
        try {
            instance.getCached(String.class, key);
            fail();
        } catch (ClassCastException ex) {
            //ok
        }
        
        String s = "testString";
        instance.cache(key, s);
        instance.getCached(String.class, key);
        instance.getCached(Object.class, key);
        try {
            instance.getCached(OpbScalarResultCache.class, key);
            fail();
        } catch (ClassCastException ex) {
            //ok
        }
        
        s = null;
        instance.cache(key, s);
        instance.getCached(String.class, key);
        instance.getCached(Object.class, key);
        instance.getCached(OpbScalarResultCache.class, key);
        
    }

    /**
     * Test of cache method, of class com.butterfill.opb.util.OpbScalarResultCache.
     */
    public void testCache() {
        System.out.println("cache");
        
        OpbId key = null;
        OpbScalarResultCache instance = new OpbScalarResultCache();
        
        Object value = null;
        assertNull(instance.getCached(Object.class, key));
        
        key = new OpbId("b");
        instance.cache(key, null);
        assertNull(instance.getCached(Object.class, key));
        
        value = new Object();
        instance.cache(key, value);
        assertEquals(value, instance.getCached(Object.class, key));
    }

    /**
     * Test of clearCached method, of class com.butterfill.opb.util.OpbScalarResultCache.
     */
    public void testClearCached() {
        System.out.println("clearCached");
        
        OpbId key = null;
        OpbScalarResultCache instance = new OpbScalarResultCache();
        
        instance.clearCached();
        
        assertFalse(instance.isCached(key));
        assertFalse(instance.isCached(null));
        key = new OpbId("a");
        assertFalse(instance.isCached(key));
        instance.cache(key, null);
        assertTrue(instance.isCached(key));
        instance.cache(key, new Object());
        assertTrue(instance.isCached(key));
        instance.clearCached(key);
        assertFalse(instance.isCached(key));
        assertNull(instance.getCached(Object.class, key));
        instance.cache(key, new Object());
        assertTrue(instance.isCached(key));
        instance.clearCached();
        assertFalse(instance.isCached(key));
        assertNull(instance.getCached(Object.class, key));
    }
    
}
