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
import java.util.List;

/**
 *
 * @author Peter Butterfill
 */
public class OpbBasicTimingEventListenerTest extends TestCase {
    
    public OpbBasicTimingEventListenerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbBasicTimingEventListenerTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.timing.OpbBasicTimingEventListener.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbBasicTimingEventListener instance = new OpbBasicTimingEventListener();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCompletedEvents method, of class com.butterfill.opb.timing.OpbBasicTimingEventListener.
     */
    public void testGetCompletedEvents() {
        System.out.println("getCompletedEvents");
        
        OpbBasicTimingEventListener instance = new OpbBasicTimingEventListener();
        
        List<OpbTimingEvent> result = instance.getCompletedEvents();
        assertEquals(0, result.size());
        
        OpbTimingEvent evt = new OpbTimingEvent("testEvent", 1);
        evt.setEndTime(99);
        
        instance.timingEventComplete(evt);
        result = instance.getCompletedEvents();
        assertEquals(1, result.size());
        assertEquals("testEvent", result.get(0).getEventName());
        assertEquals(1, result.get(0).getStartTime());
        assertEquals(99, result.get(0).getEndTime());
        
        instance.clearCompletedEvents();
        // result still points to the old result -
        // getCompletedEvents() won't return the same instance twice
        assertEquals(1, result.size());
        // get the current completed events (which should be empty)
        result = instance.getCompletedEvents();
        assertEquals(0, result.size());
        
        instance.timingEventComplete(evt);
        result = instance.getCompletedEvents();
        assertEquals(1, result.size());
        assertTrue(evt == result.get(0));
        
        evt = new OpbTimingEvent("", 0);
        instance.timingEventComplete(evt);
        result = instance.getCompletedEvents();
        assertEquals(1, result.size());
        assertTrue(evt == result.get(0));


        evt = new OpbTimingEvent("", 0);
        instance.timingEventComplete(evt);
        evt = new OpbTimingEvent("", 0);
        instance.timingEventComplete(evt);
        result = instance.getCompletedEvents();
        assertEquals(2, result.size());
        assertTrue(evt == result.get(1));

        
    }

    /**
     * Test of timingEventComplete method, of class com.butterfill.opb.timing.OpbBasicTimingEventListener.
     */
    public void testTimingEventComplete() {
        System.out.println("timingEventComplete");
        
        OpbTimingEvent event = null;
        OpbBasicTimingEventListener instance = new OpbBasicTimingEventListener();
        
        assertEquals(0, instance.getCompletedEvents().size());
        
        instance.timingEventComplete(event);
        
        assertEquals(0, instance.getCompletedEvents().size());
        
        event = new OpbTimingEvent("", 0);
        instance.timingEventComplete(event);
        // Note: getCompletedEvents clears saved events
        List<OpbTimingEvent> completedEvents = instance.getCompletedEvents();
        assertEquals(event, completedEvents.get(0));
        assertEquals(1, completedEvents.size());

        // adding the same event twice, will mean it's saved as a completed event twice
        instance.timingEventComplete(event);
        instance.timingEventComplete(event);
        assertEquals(2, instance.getCompletedEvents().size());
        
    }

    /**
     * Test of clearCompletedEvents method, of class com.butterfill.opb.timing.OpbBasicTimingEventListener.
     */
    public void testClearCompletedEvents() {
        System.out.println("clearCompletedEvents");
        
        OpbBasicTimingEventListener instance = new OpbBasicTimingEventListener();
        
        instance.clearCompletedEvents();
        assertEquals(0, instance.getCompletedEvents().size());
        
        for (int i = 0; i < 9; i++) {
            instance.timingEventComplete(
                    new OpbTimingEvent("", 0));
        }
        // prove that the above loop added some events
        // Note: getCompletedEvents() clears saved events too
        assertEquals(9, instance.getCompletedEvents().size());

        // add some events again
        for (int i = 0; i < 9; i++) {
            instance.timingEventComplete(
                    new OpbTimingEvent("", 0));
        }
        // this time, it's clearCompletedEvents that clears the saved events
        instance.clearCompletedEvents();
        assertEquals(0, instance.getCompletedEvents().size());
        
    }
    
}
