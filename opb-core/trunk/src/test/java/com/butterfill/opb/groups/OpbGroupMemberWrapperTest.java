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
import com.butterfill.opb.util.OpbValueWrapper;

/**
 *
 * @author Peter Butterfill
 */
public class OpbGroupMemberWrapperTest extends TestCase {
    
    public OpbGroupMemberWrapperTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbGroupMemberWrapperTest.class);
        
        return suite;
    }

    /**
     * Test of getValue method, of class com.butterfill.opb.groups.OpbGroupMemberWrapper.
     */
    public void testGetValue() {
        System.out.println("getValue");
        
        OpbGroupMemberWrapper<Object> instance = new OpbGroupMemberWrapperImpl<Object>();
        
        Object expResult = null;
        Object result = instance.getValue();
        assertEquals(expResult, result);
        
        expResult = new Object();
        instance.setValue(expResult);
        result = instance.getValue();
        assertSame(expResult, result);
        
    }

    public void testSetValue() {
        System.out.println("setValue");
        
        OpbGroupMemberWrapper<Object> instance = new OpbGroupMemberWrapperImpl<Object>();
        
        Object expResult = null;
        Object result = instance.getValue();
        assertEquals(expResult, result);
        
        expResult = new Object();
        instance.setValue(expResult);
        result = instance.getValue();
        assertSame(expResult, result);
        
    }
    
    /**
     * Generated implementation of abstract class com.butterfill.opb.groups.OpbGroupMemberWrapper. Please fill dummy bodies of generated methods.
     */
    private class OpbGroupMemberWrapperImpl<E> implements OpbGroupMemberWrapper<E> {
        
        private E value;
        
        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    
}
