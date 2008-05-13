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
public class OpbValueWrapperTest extends TestCase {
    
    public OpbValueWrapperTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbValueWrapperTest.class);
        
        return suite;
    }

    /**
     * Test of getValue method, of class com.butterfill.opb.util.OpbValueWrapper.
     */
    public void testGetValue() {
        System.out.println("getValue");
        
        OpbValueWrapper instance = new OpbValueWrapperImpl();
        
        Object expResult = null;
        Object result = instance.getValue();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setValue method, of class com.butterfill.opb.util.OpbValueWrapper.
     */
    public void testSetValue() {
        System.out.println("setValue");
        
        Object value = null;
        OpbValueWrapper<Object> instance = new OpbValueWrapperImpl<Object>();
        
        instance.setValue(value);
        
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.util.OpbValueWrapper. Please fill dummy bodies of generated methods.
     */
    private class OpbValueWrapperImpl<E> implements OpbValueWrapper<E> {

        public E getValue() {
            return null;
        }

        public void setValue(E value) {
            
            
        }
    }

    
}
