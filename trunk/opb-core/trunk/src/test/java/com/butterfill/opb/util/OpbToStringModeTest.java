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

/**
 *
 * @author Peter Butterfill
 */
public class OpbToStringModeTest extends TestCase {
    
    public OpbToStringModeTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbToStringModeTest.class);
        
        return suite;
    }
    
    public void testTheValues() {
        String[] values = {
            "FULL",
            "EXCLUDE_SUPER_CLASS",
            "MINIMAL"
        };
        
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], OpbToStringMode.values()[i].toString());
        }
        
    }
    
}
