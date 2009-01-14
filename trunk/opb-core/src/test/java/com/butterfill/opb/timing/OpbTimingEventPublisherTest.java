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
 *
 * @author Peter Butterfill
 */
public class OpbTimingEventPublisherTest extends TestCase {
    
    public OpbTimingEventPublisherTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbTimingEventPublisherTest.class);
        
        return suite;
    }

    /**
     * Test of setOpbEventTimerProvider method, of class com.butterfill.opb.timing.OpbTimingEventPublisher.
     */
    public void testSetOpbEventTimerProvider() {
        System.out.println("setOpbEventTimerProvider");
        
        OpbEventTimerProvider provider = null;
        OpbTimingEventPublisher instance = new OpbTimingEventPublisherImpl();
        
        instance.setOpbEventTimerProvider(provider);
        
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.timing.OpbTimingEventPublisher. Please fill dummy bodies of generated methods.
     */
    private class OpbTimingEventPublisherImpl implements OpbTimingEventPublisher {

        public void setOpbEventTimerProvider(com.butterfill.opb.timing.OpbEventTimerProvider provider) {
            
        }
    }

    
}
