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
import java.util.List;
import junit.framework.*;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Peter Butterfill
 */
public class OpbEventTimerTest extends TestCase {
    
    public OpbEventTimerTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbEventTimerTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.timing.OpbEventTimer.
     */
    public void testToString() {
        System.out.println("toString");
        
        OpbEventTimer instance = new OpbEventTimer();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addTimingEventListener method, of class com.butterfill.opb.timing.OpbEventTimer.
     */
    public void testAddTimingEventListener() {
        System.out.println("addTimingEventListener");
        
        OpbTimingEventListener listsener = null;
        OpbEventTimer instance = new OpbEventTimer();
        
        try {
            instance.addTimingEventListener(listsener);
            fail("should not be able to add null listener");
        } catch (NullPointerException e) {
            //ok
        }
        
        Listener lsnr = new Listener();
        
        instance.addTimingEventListener(lsnr);
        
        for (int i = 0; i < 9; i++) {
            OpbTimingEvent e = instance.start("testEvent"+i);
            assertEquals(i, lsnr.complete.size());
            instance.end(e);
            assertEquals(i+1, lsnr.complete.size());
        }
        
    }

    /**
     * Test of removeTimingEventListener method, of class com.butterfill.opb.timing.OpbEventTimer.
     */
    public void testRemoveTimingEventListener() {
        System.out.println("removeTimingEventListener");
        
        OpbTimingEventListener listsener = null;
        OpbEventTimer instance = new OpbEventTimer();
        
        instance.removeTimingEventListener(listsener);
        
        Listener lsnr = new Listener();
        
        // no-op
        instance.removeTimingEventListener(lsnr);
        
        instance.addTimingEventListener(lsnr);
        
        OpbTimingEvent e = instance.start("testEvent");
        
        assertEquals(0, lsnr.complete.size());
        
        instance.end(e);
        
        assertEquals(1, lsnr.complete.size());
        
        instance.removeTimingEventListener(lsnr);
        
        e = instance.start("testEvent");
        instance.end(e);
        
        assertEquals(1, lsnr.complete.size());
        
    }

    /**
     * Test of removeAllTimingEventListeners method, of class com.butterfill.opb.timing.OpbEventTimer.
     */
    public void testRemoveAllTimingEventListeners() {
        System.out.println("removeAllTimingEventListeners");
        
        OpbEventTimer instance = new OpbEventTimer();
        
        instance.removeAllTimingEventListeners();
        
        Listener listsener = new Listener();
        
        Listener listsener2 = new Listener();
        
        instance.addTimingEventListener(listsener);
        instance.addTimingEventListener(listsener2);
        
        OpbTimingEvent e = instance.start("testEvent");
        instance.end(e);
        
        assertEquals(1, listsener.complete.size());
        assertEquals(1, listsener2.complete.size());
        
        instance.removeAllTimingEventListeners();
        
        e = instance.start("testEvent");
        instance.end(e);
        
        assertEquals(1, listsener.complete.size());
        assertEquals(1, listsener2.complete.size());
        
    }

    

    
    
    private static class Listener implements OpbTimingEventListener {
        
        List<OpbTimingEvent> complete = new ArrayList<OpbTimingEvent>();
        
        public void timingEventComplete(OpbTimingEvent event) {
            assertNotNull(event);
            complete.add(event);
        }
        
    }

    /**
     * Test of start method, of class com.butterfill.opb.timing.OpbEventTimer.
     */
    public void testStart() {
        System.out.println("start");
        
        String eventName = null;
        OpbEventTimer instance = new OpbEventTimer();
        long now = System.currentTimeMillis();
        
        OpbTimingEvent expResult = null;
        OpbTimingEvent result = instance.start(eventName);
        assertNotNull(result);
        assertEquals("", result.getEventName());
        assertTrue(now <= result.getStartTime());
        assertEquals(0, result.getEndTime());
        
        now = System.currentTimeMillis();
        assertTrue(now >= result.getStartTime());
        
        expResult = result;
        result = instance.start(eventName);
        now = System.currentTimeMillis();
        assertNotNull(result);
        assertEquals("", result.getEventName());
        assertTrue(now <= result.getStartTime());
        assertEquals(0, result.getEndTime());
        
        assertNotSame(expResult, result);
        
    }

    /**
     * Test of end method, of class com.butterfill.opb.timing.OpbEventTimer.
     */
    public void testEnd() {
        System.out.println("end");
        
        OpbTimingEvent event = null;
        OpbEventTimer instance = new OpbEventTimer();
        
        instance.end(event);
        
        Lsnr lsnr = new Lsnr();
        
        instance.addTimingEventListener(lsnr);
        
        instance.end(event);
        
        event = instance.start("x");
        instance.end(event);
        
        assertEquals(event, lsnr.events.get(0));
        
    }
    
    private static class Lsnr implements OpbTimingEventListener {
        List<OpbTimingEvent> events = new ArrayList<OpbTimingEvent>();
        public void timingEventComplete(OpbTimingEvent event) {
            assertNotNull(event);
            events.add(event);
        }
        
    }
    
}
