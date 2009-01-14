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
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbTimingEventAggregateTest extends TestCase {
    
    public OpbTimingEventAggregateTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbTimingEventAggregateTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addEvent method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testAddEvent() {
        System.out.println("addEvent");
        
        OpbTimingEvent event = null;
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        try {
            instance.addEvent(event);
            fail();
        } catch (NullPointerException e) {
            //ok
        }
        assertNull(instance.getEventName());
        event = new OpbTimingEvent("", 0);
        instance.addEvent(event);
        assertEquals("", instance.getEventName());
        
        instance = new OpbTimingEventAggregate();
        
        event = new OpbTimingEvent("e", 0);
        
        assertNull(instance.getEventName());
        instance.addEvent(event);
        assertEquals("e", instance.getEventName());
        
        instance.addEvent(event);
        
    }

    /**
     * Test of getEventName method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testGetEventName() {
        System.out.println("getEventName");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        String expResult = null;
        String result = instance.getEventName();
        assertEquals(expResult, result);
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0);
        
        instance.addEvent(e);
        expResult = "e";
        result = instance.getEventName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEventCount method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testGetEventCount() {
        System.out.println("getEventCount");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        int expResult = 0;
        int result = instance.getEventCount();
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0);
        
        for (int i = 0; i < 9; i++) {
            result = instance.getEventCount();
            assertEquals("i=" + i, expResult, result);
            instance.addEvent(e);
            expResult++;
        }
        
        
    }

    /**
     * Test of getTotalEventDuration method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testGetTotalEventDuration() {
        System.out.println("getTotalEventDuration");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        long expResult = 0L;
        long result = instance.getTotalEventDuration();
        assertEquals(expResult, result);
        
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0);
        
        
        for (int i = 0; i < 9; i++) {
            instance.addEvent(e);
        }
        result = instance.getTotalEventDuration();
        assertEquals(expResult, result);
        
        e.setEndTime(1);
        for (int i = 0; i < 9; i++) {
            instance.addEvent(e);
        }
        result = instance.getTotalEventDuration();
        expResult = 9;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMinimumEventDuration method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testGetMinimumEventDuration() {
        System.out.println("getMinimumEventDuration");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        long expResult = 0L;
        long result = instance.getMinimumEventDuration();
        assertEquals(expResult, result);
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0);
        
        e.setEndTime(2);
        
        for (int i = 0; i < 9; i++) {
            instance.addEvent(e);
        }
        result = instance.getMinimumEventDuration();
        expResult = 2;
        assertEquals(expResult, result);
        
        e.setEndTime(1);
        instance.addEvent(e);
        result = instance.getMinimumEventDuration();
        expResult = 1;
        assertEquals(expResult, result);
        
        e.setEndTime(5);
        instance.addEvent(e);
        result = instance.getMinimumEventDuration();
        expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaximumEventDuration method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testGetMaximumEventDuration() {
        System.out.println("getMaximumEventDuration");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        long expResult = 0L;
        long result = instance.getMaximumEventDuration();
        assertEquals(expResult, result);
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0);
        
        e.setEndTime(2);
        instance.addEvent(e);
        expResult = 2;
        result = instance.getMaximumEventDuration();
        assertEquals(expResult, result);
        
        e.setEndTime(1);
        instance.addEvent(e);
        expResult = 2;
        result = instance.getMaximumEventDuration();
        assertEquals(expResult, result);
        
        e.setEndTime(3);
        instance.addEvent(e);
        expResult = 3;
        result = instance.getMaximumEventDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAverageEventDuration method, of class com.butterfill.opb.timing.OpbTimingEventAggregate.
     */
    public void testGetAverageEventDuration() {
        System.out.println("getAverageEventDuration");
        
        OpbTimingEventAggregate instance = new OpbTimingEventAggregate();
        
        long expResult = 0L;
        long result = 0L;
        
        try {
            result = instance.getAverageEventDuration();
            fail();
        } catch (Exception e) {
            //ok
        }
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0);
        
        e.setEndTime(2);
        instance.addEvent(e);
        expResult = 2;
        result = instance.getAverageEventDuration();
        assertEquals(expResult, result);
        
    }
    
}
