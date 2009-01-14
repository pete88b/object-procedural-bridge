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
public class OpbValueWrapperImplTest extends TestCase {
    
    public OpbValueWrapperImplTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbValueWrapperImplTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.util.OpbValueWrapperImpl.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbValueWrapperImpl<Object> instance = new OpbValueWrapperImpl<Object>();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
        OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
        System.out.format("%s%n", instance);
        
        instance.setValue("testValue");
        System.out.format("%s%n", instance);
        OpbToStringHelper.setToStringMode(OpbToStringMode.MINIMAL);
        
    }

    /**
     * Test of getValue method, of class com.butterfill.opb.util.OpbValueWrapperImpl.
     */
    public void testGetValue() {
        System.out.println("getValue");
        
        OpbValueWrapperImpl<Object> instance = new OpbValueWrapperImpl<Object>();
        
        Object expResult = null;
        Object expResult2 = "testExp";
        Object result = instance.getValue();
        assertEquals(expResult, result);
        
        expResult = new Object();
        instance = new OpbValueWrapperImpl<Object>(expResult);
        result = instance.getValue();
        assertSame(expResult, result);
        
        instance.setValue(expResult2);
        result = instance.getValue();
        assertSame(expResult2, result);
        assertNotSame(expResult, result);
        
    }

    /**
     * Test of setValue method, of class com.butterfill.opb.util.OpbValueWrapperImpl.
     */
    public void testSetValue() {
        System.out.println("setValue");
        
        Object value = null;
        OpbValueWrapperImpl<Object> instance = new OpbValueWrapperImpl<Object>();
        
        instance.setValue(value);
        assertNull(instance.getValue());
    }

    
}
