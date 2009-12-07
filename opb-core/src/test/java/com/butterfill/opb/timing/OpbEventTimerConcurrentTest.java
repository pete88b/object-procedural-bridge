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
import com.butterfill.opb.util.OpbValueWrapper;
import com.butterfill.opb.util.OpbValueWrapperImpl;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO: xxx
 * 
 * @author Peter Butterfill
 */
public class OpbEventTimerConcurrentTest extends TestCase {
    
    public OpbEventTimerConcurrentTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbEventTimerConcurrentTest.class);
        
        return suite;
    }

    /**
     * Test of timingEventComplete method, of class com.butterfill.opb.timing.OpbBasicTimingEventListener.
     */
    public void testEnd() {
        System.out.println("end");

        // set to true if an error occurs
        final OpbValueWrapper<Boolean> errorFlag = 
                new OpbValueWrapperImpl<Boolean>(false);

        // incremented by each thread when it completes
        final AtomicInteger threadCompleteCount =
                new AtomicInteger();

        // the instance we're testing
        final OpbEventTimer instance = new OpbEventTimer();
        
        final Lsnr lsnr = new Lsnr();
        instance.addTimingEventListener(lsnr);

        // the number of threads to create
        final int threadCount = 10;
        // the number of calls each thread should make
        final int callCount = 100;

        // create the threads
        for (int i = 0; i < threadCount; i++) {
            new Thread(new EndCaller(
                    errorFlag, threadCompleteCount, instance, callCount)).start();
        }

        // wait until all threads have completed
        while (threadCompleteCount.intValue() < threadCount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                //
            }
        }

        System.out.println("checking errorFlag");
        // check the error flag
        assertFalse(errorFlag.getValue());

    }

    static class Lsnr implements OpbTimingEventListener {
        int callCount;
        int failOnCall = 100;
        public void timingEventComplete(OpbTimingEvent event) {
            callCount++;
            if (failOnCall == callCount) {
                throw new RuntimeException("test ex callCount=" + callCount);
            }
        }

    }


    static class EndCaller implements Runnable {

        final OpbValueWrapper<Boolean> errorFlag;
        final AtomicInteger threadCompleteCount;
        final OpbEventTimer eventTimer;
        final int callCount;

        public EndCaller(
                final OpbValueWrapper<Boolean> errorFlag,
                final AtomicInteger threadCompleteCount,
                final OpbEventTimer eventTimer,
                final int callCount) {
            this.errorFlag = errorFlag;
            this.threadCompleteCount = threadCompleteCount;
            this.eventTimer = eventTimer;
            this.callCount = callCount;
        }

        public void run() {
            System.out.println("run(). Thread.currentThread().getName()=" +
                    Thread.currentThread().getName());

            try {
                for (int i=0; i<callCount; i++) {
                    // call timingEventComplete passing a new event for each call
                    eventTimer.end(eventTimer.start("concurrent-event2"));

                }

            } catch (RuntimeException ex) {
                // set the error flag
                errorFlag.setValue(true);
                // re-raise the exception - as there's no point carrying on
                throw ex;

            } finally {
                // increment the thread complete count
                threadCompleteCount.incrementAndGet();

            }

            System.out.println("run() complete. Thread.currentThread().getName()=" +
                    Thread.currentThread().getName());

        }

    }

}
