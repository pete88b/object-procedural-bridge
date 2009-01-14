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

/**
 *
 * @author Peter Butterfill
 */
public class OpbComparisonHelperTest extends TestCase {
    
    public OpbComparisonHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbComparisonHelperTest.class);
        
        return suite;
    }

    
    /**
     * Test of isEqual method, of class com.butterfill.opb.util.OpbComparisonHelper.
     */
    public void testIsEqual() {
        
        System.out.println("equal");
        
        Object a = new Object();
        Object b = a;
        
        boolean expResult = true;
        boolean result = OpbComparisonHelper.isEqual(a, b);
        
        long iterations = 999;
        System.out.format("iterations=%s%n", iterations);
        
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < iterations; i++) {
            result = OpbComparisonHelper.isEqual(a, b);
            assertEquals(expResult, result);
        }
        
        long end = System.currentTimeMillis();
        long duration = end - start;
        
        System.out.format("a == b%n");
        System.out.format("duration=%sms%n", duration);
        
        b = new Object();
        expResult = false;
        
        start = System.currentTimeMillis();
        
        for (int i = 0; i < iterations; i++) {
            result = OpbComparisonHelper.isEqual(a, b);
            assertEquals(expResult, result);
        }
        
        end = System.currentTimeMillis();
        duration = end - start;
        
        System.out.format("a != b%n");
        System.out.format("duration=%sms%n", duration);
        
        a = null;
        start = System.currentTimeMillis();
        
        for (int i = 0; i < iterations; i++) {
            result = OpbComparisonHelper.isEqual(a, b);
            assertEquals(expResult, result);
        }
        
        end = System.currentTimeMillis();
        duration = end - start;
        
        System.out.format("a != b (a == null)%n");
        System.out.format("duration=%sms%n", duration);
        
        a = b;
        b = null;
        start = System.currentTimeMillis();
        
        for (int i = 0; i < iterations; i++) {
            result = OpbComparisonHelper.isEqual(a, b);
            assertEquals(expResult, result);
        }
        
        end = System.currentTimeMillis();
        duration = end - start;
        
        System.out.format("a != b (b == null)%n");
        System.out.format("duration=%sms%n", duration);
        
        a = new String("test");
        b = new String("test");
        assertTrue(a != b);
        assertTrue(a.equals(b));
        
        expResult = true;
        start = System.currentTimeMillis();
        
        for (int i = 0; i < iterations; i++) {
            result = OpbComparisonHelper.isEqual(a, b);
            assertEquals(expResult, result);
        }
        
        end = System.currentTimeMillis();
        duration = end - start;
        
        System.out.format("a != b (a.equals(b) == true)%n");
        System.out.format("duration=%sms%n", duration);
        
    }

    
}
