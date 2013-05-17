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
public class OpbSqlNameToJavaNameHelperTest extends TestCase {

    public OpbSqlNameToJavaNameHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        return new TestSuite(OpbSqlNameToJavaNameHelperTest.class);
    }

    /**
     *
     */
    public void testGetValue() {
        OpbSqlNameToJavaNameHelper instance = new OpbSqlNameToJavaNameHelper();
        try {
            instance.sqlNameToJavaName(null);
            fail("should throw a null pointer");
        } catch (NullPointerException ex) {

        }
        assertEquals("a", instance.sqlNameToJavaName("a"));
        assertEquals("a", instance.sqlNameToJavaName("A"));
        assertEquals("aA", instance.sqlNameToJavaName("a_a"));
        assertEquals("aA", instance.sqlNameToJavaName("a__a"));
        assertEquals("aA", instance.sqlNameToJavaName("a___a"));
        assertEquals("a a", instance.sqlNameToJavaName("a a"));
        assertEquals("aGoodSqlName", instance.sqlNameToJavaName("a_good_sql_name"));
        assertEquals("aGoodSqlName", instance.sqlNameToJavaName("a_GOOD_sql_name"));
        assertEquals("agoodjavaname", instance.sqlNameToJavaName("aGoodJavaName"));
        
    }

}
