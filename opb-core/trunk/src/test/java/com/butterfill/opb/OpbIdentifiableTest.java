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


package com.butterfill.opb;

import junit.framework.*;

/**
 *
 * @author Peter Butterfill
 */
public class OpbIdentifiableTest extends TestCase {
    
    public OpbIdentifiableTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbIdentifiableTest.class);
        
        return suite;
    }

    /**
     * Test of getOpbId method, of class com.butterfill.opb.OpbIdentifiable.
     */
    public void testGetOpbId() {
        System.out.println("getOpbId");
        
        OpbIdentifiable instance = new OpbIdentifiableImpl();
        
        OpbId expResult = null;
        OpbId result = instance.getOpbId();
        assertEquals(expResult, result);
        
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.OpbIdentifiable. Please fill dummy bodies of generated methods.
     */
    private class OpbIdentifiableImpl implements OpbIdentifiable {

        public com.butterfill.opb.OpbId getOpbId() {
            
            
            return null;
        }
    }

    
}
