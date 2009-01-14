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


package com.butterfill.opb.timing;

import junit.framework.*;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbTimingEventTest extends TestCase {
    
    public OpbTimingEventTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbTimingEventTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.timing.OpbTimingEvent.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbTimingEvent instance = new OpbTimingEvent("", 0);
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    

    /**
     * Test of getEventName method, of class com.butterfill.opb.timing.OpbTimingEvent.
     */
    public void testGetEventName() {
        System.out.println("getEventName");
        
        String expResult = "";
        
        OpbTimingEvent instance = new OpbTimingEvent(expResult, 0);
        
        String result = instance.getEventName();
        assertEquals(expResult, result);
        
        expResult = "event";
        instance = new OpbTimingEvent(expResult, 0L);
        result = instance.getEventName();
        assertSame(expResult, result);
        
        instance = new OpbTimingEvent(expResult, 0);
        result = instance.getEventName();
        assertSame(expResult, result);
        
    }

    
    /**
     * Test of getStartTime method, of class com.butterfill.opb.timing.OpbTimingEvent.
     */
    public void testGetStartTime() {
        System.out.println("getStartTime");
        
        OpbTimingEvent instance = new OpbTimingEvent("", 0);
        
        long expResult = 0L;
        long result = instance.getStartTime();
        assertEquals(expResult, result);
        
        expResult = 9L;
        instance = new OpbTimingEvent("", expResult);
        result = instance.getStartTime();
        assertSame(expResult, result);
        
        instance = new OpbTimingEvent("", expResult);
        
        result = instance.getStartTime();
        assertSame(expResult, result);
        
    }

    
    /**
     * Test of getEndTime method, of class com.butterfill.opb.timing.OpbTimingEvent.
     */
    public void testGetEndTime() {
        System.out.println("getEndTime");
        
        OpbTimingEvent instance = new OpbTimingEvent("", 0);
        
        long expResult = 0L;
        long result = instance.getEndTime();
        assertEquals(expResult, result);
        
        expResult = 8L;
        instance.setEndTime(expResult);
        result = instance.getEndTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setEndTime method, of class com.butterfill.opb.timing.OpbTimingEvent.
     */
    public void testSetEndTime() {
        System.out.println("setEndTime");
        
        long endTime = 0L;
        OpbTimingEvent instance = new OpbTimingEvent("", 0);
        
        instance.setEndTime(endTime);
        
    }
    
}
