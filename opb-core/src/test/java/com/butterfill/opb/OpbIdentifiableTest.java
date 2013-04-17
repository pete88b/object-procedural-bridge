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
     * Simple test to for catching changes to interface.
     */
    public void testGetOpbId() {
        System.out.println("getOpbId");

        OpbId expResult = new OpbId(1, 2, 3);
        OpbIdentifiable instance = new OpbIdentifiableImpl(expResult);
        OpbId result = instance.getOpbId();
        assertSame(expResult, result);

    }

    /**
     * A mock identifiable.
     */
    private class OpbIdentifiableImpl implements OpbIdentifiable {
        OpbId id;

        public OpbIdentifiableImpl(OpbId id) {
            this.id = id;
        }

        public com.butterfill.opb.OpbId getOpbId() {
            return id;
        }

    }

}
