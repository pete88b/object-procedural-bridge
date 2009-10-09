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
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbBooleanHelperTest extends TestCase {
    
    public OpbBooleanHelperTest(String testName) {
        super(testName);
    }

    
    @Override
    protected void setUp() throws Exception {
        OpbBooleanHelper.setIgnoreCase(true);
        // avoid setting values for true and false to the same thing
        OpbBooleanHelper.setValueForFalse("~N");
        OpbBooleanHelper.setValueForTrue("~Y");
        OpbBooleanHelper.setValueForFalse("N");
        OpbBooleanHelper.setValueForTrue("Y");
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbBooleanHelperTest.class);
        
        return suite;
    }
    
    /**
     * Test of isIgnoreCase method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testIsIgnoreCase() {
        System.out.println("isIgnoreCase");
        
        boolean expResult = true;
        boolean result = OpbBooleanHelper.isIgnoreCase();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIgnoreCase method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testSetIgnoreCase() {
        System.out.println("setIgnoreCase");
        assertTrue(OpbBooleanHelper.isIgnoreCase());
        OpbBooleanHelper.setIgnoreCase(false);
        assertFalse(OpbBooleanHelper.isIgnoreCase());
        OpbBooleanHelper.setIgnoreCase(true);
        assertTrue(OpbBooleanHelper.isIgnoreCase());
    }

    /**
     * Test of getValueForTrue method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testGetValueForTrue() {
        System.out.println("getValueForTrue");
        
        assertEquals("Y", OpbBooleanHelper.getValueForTrue());
        
    }

    /**
     * Test of setValueForTrue method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testSetValueForTrue() {
        System.out.println("setValueForTrue");
        
        assertEquals("Y", OpbBooleanHelper.getValueForTrue());
        OpbBooleanHelper.setValueForTrue("true");
        assertEquals("true", OpbBooleanHelper.getValueForTrue());
        OpbBooleanHelper.setValueForTrue("Y");
        assertEquals("Y", OpbBooleanHelper.getValueForTrue());
        try {
            OpbBooleanHelper.setValueForTrue("n");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.setValueForTrue("N");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        OpbBooleanHelper.setIgnoreCase(false);
        
        OpbBooleanHelper.setValueForTrue("n");
        assertEquals("n", OpbBooleanHelper.getValueForTrue());
        try {
            OpbBooleanHelper.setValueForTrue("N");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        OpbBooleanHelper.setValueForFalse(null);
        try {
            OpbBooleanHelper.setValueForTrue(null);
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        OpbBooleanHelper.setValueForFalse("");
        OpbBooleanHelper.setValueForTrue(null);
        try {
            OpbBooleanHelper.setValueForFalse(null);
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
    }

    /**
     * Test of getValueForFalse method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testGetValueForFalse() {
        System.out.println("getValueForFalse");
        
        assertEquals("N", OpbBooleanHelper.getValueForFalse());
    }

    /**
     * Test of setValueForFalse method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testSetValueForFalse() {
        System.out.println("setValueForFalse");
        
        assertEquals("N", OpbBooleanHelper.getValueForFalse());
        OpbBooleanHelper.setValueForFalse("false");
        assertEquals("false", OpbBooleanHelper.getValueForFalse());
        OpbBooleanHelper.setValueForFalse("N");
        assertEquals("N", OpbBooleanHelper.getValueForFalse());
        
        try {
            OpbBooleanHelper.setValueForTrue("N");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        try {
            OpbBooleanHelper.setValueForTrue("n");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
    }

    /**
     * Test of toBoolean method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testToBoolean() {
        System.out.println("toBoolean");
        
        assertEquals(null, OpbBooleanHelper.toBoolean(null));
        assertEquals(Boolean.TRUE, OpbBooleanHelper.toBoolean("Y"));
        assertEquals(Boolean.TRUE, OpbBooleanHelper.toBoolean("y"));
        assertEquals(Boolean.FALSE, OpbBooleanHelper.toBoolean("N"));
        assertEquals(Boolean.FALSE, OpbBooleanHelper.toBoolean("n"));
        
        try {
            OpbBooleanHelper.toBoolean("Yes");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("yes");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("no");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("No");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("true");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("false");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        OpbBooleanHelper.setIgnoreCase(false);
        assertEquals(null, OpbBooleanHelper.toBoolean(null));
        assertEquals(Boolean.TRUE, OpbBooleanHelper.toBoolean("Y"));
        assertEquals(Boolean.FALSE, OpbBooleanHelper.toBoolean("N"));
        try {
            OpbBooleanHelper.toBoolean("y");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("n");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("true");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("false");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        OpbBooleanHelper.setValueForTrue("true");
        assertEquals(null, OpbBooleanHelper.toBoolean(null));
        assertEquals(Boolean.TRUE, OpbBooleanHelper.toBoolean("true"));
        assertEquals(Boolean.FALSE, OpbBooleanHelper.toBoolean("N"));
        try {
            OpbBooleanHelper.toBoolean("y");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("n");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("Y");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("false");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        OpbBooleanHelper.setValueForFalse("false");
        assertEquals(null, OpbBooleanHelper.toBoolean(null));
        assertEquals(Boolean.TRUE, OpbBooleanHelper.toBoolean("true"));
        assertEquals(Boolean.FALSE, OpbBooleanHelper.toBoolean("false"));
        try {
            OpbBooleanHelper.toBoolean("y");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("n");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("Y");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        try {
            OpbBooleanHelper.toBoolean("N");
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        
    }

    /**
     * Test of toString method, of class com.butterfill.opb.util.OpbBooleanHelper.
     */
    public void testToString() {
        System.out.println("toString");
        
        for (int i = 0; i < 99; i++) {
            assertNull(OpbBooleanHelper.toString(null));
            assertEquals(
                    OpbBooleanHelper.getValueForFalse(), 
                    OpbBooleanHelper.toString(false));
            assertEquals(
                    OpbBooleanHelper.getValueForTrue(), 
                    OpbBooleanHelper.toString(true));
            OpbBooleanHelper.setValueForFalse("f"+i);
            OpbBooleanHelper.setValueForTrue("t"+i);
        }
        
    }
    
}
