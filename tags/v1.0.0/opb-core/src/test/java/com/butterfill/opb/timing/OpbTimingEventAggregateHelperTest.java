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

import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.*;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import com.butterfill.opb.util.OpbAssert;

/**
 *
 * @author Peter Butterfill
 */
public class OpbTimingEventAggregateHelperTest extends TestCase {
    
    public OpbTimingEventAggregateHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbTimingEventAggregateHelperTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.timing.OpbTimingEventAggregateHelper.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbTimingEventAggregateHelper instance = new OpbTimingEventAggregateHelper();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addEvent method, of class com.butterfill.opb.timing.OpbTimingEventAggregateHelper.
     */
    public void testAddEvent() {
        System.out.println("addEvent");
        
        OpbTimingEvent event = null;
        OpbTimingEventAggregateHelper instance = new OpbTimingEventAggregateHelper();
        
        try {
            instance.addEvent(event);
            fail("can't add a null event");
        } catch (NullPointerException e) {
            //ok
        }
        
        event = new OpbTimingEvent("e", 0L);
        
        instance.addEvent(event);
        
        for (int i = 0; i < 9; i++) {
            event.setEndTime((long)i);
            instance.addEvent(event);
        }
        
    }

    /**
     * Test of addEvents method, of class com.butterfill.opb.timing.OpbTimingEventAggregateHelper.
     */
    public void testAddEvents() {
        System.out.println("addEvents");
        
        List<OpbTimingEvent> events = null;
        OpbTimingEventAggregateHelper instance = new OpbTimingEventAggregateHelper();
        
        try {
            instance.addEvents(events);
            fail("can't add a null list");
        } catch (NullPointerException e) {
            //ok
        }
        
        events = new ArrayList<OpbTimingEvent>();
        
        instance.addEvents(events);
        
        OpbTimingEvent event = new OpbTimingEvent("testEvent", 0);
        event.setEndTime(2);
        events.add(event);
        instance.addEvents(events);
        assertEquals(2, instance.getAggregates().get(0).getAverageEventDuration());
    }

    /**
     * Test of getAggregates method, of class com.butterfill.opb.timing.OpbTimingEventAggregateHelper.
     */
    public void testGetAggregates() {
        System.out.println("getAggregates");
        
        OpbTimingEventAggregateHelper instance = new OpbTimingEventAggregateHelper();
        
        Collection<OpbTimingEventAggregate> result = instance.getAggregates();
        assertEquals(0, instance.getAggregates().size());
        
        OpbTimingEvent e = new OpbTimingEvent("e", 0L);
        for (long i = 0; i < 10; i++) {
            e.setEndTime(i);
            instance.addEvent(e);
        }
        assertEquals(1, instance.getAggregates().size());
        for (Iterator<OpbTimingEventAggregate> i = instance.getAggregates().iterator(); i.hasNext(); ) {
            OpbTimingEventAggregate agg = i.next();
            assertEquals(10, agg.getEventCount());
            assertEquals("e", agg.getEventName());
            assertEquals(0, agg.getMinimumEventDuration());
            assertEquals(9, agg.getMaximumEventDuration());
            assertEquals(45, agg.getTotalEventDuration());
        }
        
        e = new OpbTimingEvent("e2", 0L);
        for (long i = 0; i < 10; i++) {
            e.setEndTime(i);
            instance.addEvent(e);
        }
        assertEquals(2, instance.getAggregates().size());
        
    }
    
}
