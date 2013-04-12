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

/**
 * Test the performance of different timingEventComplete implementations.
 * 
 * @author Peter Butterfill
 */
public class PerformanceTestBasicTimingEventListenerTest extends TestCase {
    
    public PerformanceTestBasicTimingEventListenerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PerformanceTestBasicTimingEventListenerTest.class);
        
        return suite;
    }

    private void run(final int callCount,
            final PerformanceTestBasicTimingEventListener listener,
            final PerformanceTestBasicTimingEventListener listener2,
            final PerformanceTestBasicTimingEventListener listener3) {
        long start = System.currentTimeMillis();
        long end;

        for (int i = 0; i < callCount; i++) {
            listener.timingEventComplete(new OpbTimingEvent("", 0L));
        }
        end = System.currentTimeMillis();
        System.out.println("timingEventComplete took " + (end - start) + " ms");


        start = end;
        for (int i = 0; i < callCount; i++) {
            listener2.timingEventComplete_synchronized(new OpbTimingEvent("", 0L));
        }
        end = System.currentTimeMillis();
        System.out.println("timingEventComplete_synchronized took " + (end - start) + " ms");


        start = end;
        for (int i = 0; i < callCount; i++) {
            listener3.timingEventComplete_synchronized_no_duplicate_check(new OpbTimingEvent("", 0L));
        }
        end = System.currentTimeMillis();
        System.out.println("timingEventComplete_synchronized_no_duplicate_check took " + (end - start) + " ms");

    }

    /**
     * Test of timingEventComplete method, of class com.butterfill.opb.timing.PerformanceTestBasicTimingEventListener.
     */
    public void testTimingEventComplete() {
        System.out.println("timingEventComplete");

        if (true) {
            // these tests are for dev only.
            // not really unit tests
            return;
        }

        PerformanceTestBasicTimingEventListener listener =
                new PerformanceTestBasicTimingEventListener();
        PerformanceTestBasicTimingEventListener listener2 =
                new PerformanceTestBasicTimingEventListener();
        PerformanceTestBasicTimingEventListener listener3 =
                new PerformanceTestBasicTimingEventListener();

        run(20000, listener, listener2, listener3);
        /*
        timingEventComplete took 1938 ms
        timingEventComplete_synchronized took 1781 ms
        timingEventComplete_synchronized_no_duplicate_check took 1094 ms

        -- after changing OpbExactMatchList to use more efficient ensureCapacity(int)
        timingEventComplete took 590 ms
        timingEventComplete_synchronized took 621 ms
        timingEventComplete_synchronized_no_duplicate_check took 16 ms

         */

        run(1000, listener, listener2, listener3);
        /*
        timingEventComplete took 266 ms
        timingEventComplete_synchronized took 250 ms
        timingEventComplete_synchronized_no_duplicate_check took 187 ms

        -- after changing OpbExactMatchList to use more efficient ensureCapacity(int)
        timingEventComplete took 62 ms
        timingEventComplete_synchronized took 62 ms
        timingEventComplete_synchronized_no_duplicate_check took 0 ms

        */

    }

}
