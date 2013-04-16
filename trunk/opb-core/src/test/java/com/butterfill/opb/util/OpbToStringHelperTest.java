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

import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.data.OpbDataObjectSource;
import helpers.TestHelper;
import java.lang.reflect.Field;
import junit.framework.*;
import static com.butterfill.opb.util.OpbToStringMode.*;

/**
 * Note: Full test suite will run toString on all objects.
 *
 * @author Peter Butterfill
 */
public class OpbToStringHelperTest extends TestCase {

    public OpbToStringHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        OpbToStringHelper.setToStringMode(MINIMAL);
        OpbToStringHelper.setFieldFilter(null);
    }

    @Override
    protected void tearDown() throws Exception {
        OpbToStringHelper.setToStringMode(MINIMAL);
        OpbToStringHelper.setFieldFilter(null);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbToStringHelperTest.class);

        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.util.OpbToStringHelper.
     */
    public void testToString() {
        System.out.println("toString");

        Object object = null;

        assertEquals("null", OpbToStringHelper.toString(object));
        assertEquals("null", OpbToStringHelper.toString(null));

        object = new Object();

        String expResult = object.toString();
        String result = OpbToStringHelper.toString(object);
        assertEquals(expResult, result);

        OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
        result = OpbToStringHelper.toString(object);
        assertNotSame(expResult, result);
        OpbToStringHelper.setToStringMode(OpbToStringMode.MINIMAL);

        object = new OpbDataObjectSource(new OpbObjectSourceImpl());

        expResult = object.toString();
        result = OpbToStringHelper.toString(object);
        assertEquals(expResult, result);

        OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
        result = OpbToStringHelper.toString(object);
        assertNotSame(expResult, result);
        OpbToStringHelper.setToStringMode(OpbToStringMode.MINIMAL);

        OpbFieldFilter acceptAll = new OpbFieldFilter() {
            public boolean accept(Object object, Field field) {
                return true;
            }
        };

        OpbFieldFilter acceptNone = new OpbFieldFilter() {
            public boolean accept(Object object, Field field) {
                return false;
            }
        };

        for (int i = 0; i < 3; i++) {
            System.out.println("~~~~~~~~~~~~~~~~");
            System.out.println(i);
            System.out.println("~~~~~~~~~~~~~~~~");
            switch (i) {
                case 1: OpbToStringHelper.setFieldFilter(acceptAll);
                break;
                case 2: OpbToStringHelper.setFieldFilter(acceptNone);
            }
            object = new TestObjectForToString();
            for (OpbToStringMode m : OpbToStringMode.values()) {
                OpbToStringHelper.setToStringMode(m);
                System.out.println("#                Start of mode="+m);
                System.out.println(object);
                System.out.println("#                End of mode="+m);

            }
            System.out.println("\n\n\n");
            for (OpbToStringMode m : OpbToStringMode.values()) {
                OpbToStringHelper.setToStringMode(m);
                System.out.println("#                Start of mode="+m);
                ((TestObjectForToString)object).testMethod();
                System.out.println("#                End of mode="+m);

            }

            System.out.println("\n\n\n");
            object = new TestObjectForToString.PublicStaticClass();
            for (OpbToStringMode m : OpbToStringMode.values()) {
                OpbToStringHelper.setToStringMode(m);
                System.out.println("#                Start of mode="+m);
                System.out.println(object);
                System.out.println("#                End of mode="+m);

            }

        }

    }

    /**
     * Test of getToStringMode method, of class com.butterfill.opb.util.OpbToStringHelper.
     */
    public void testGetToStringMode() {
        System.out.println("getToStringMode");

        OpbToStringMode expResult = OpbToStringMode.MINIMAL;
        OpbToStringMode result = OpbToStringHelper.getToStringMode();
        assertEquals(expResult, result);

    }

    /**
     * Test of setToStringMode method, of class com.butterfill.opb.util.OpbToStringHelper.
     */
    public void testSetToStringMode() {
        System.out.println("setToStringMode");

        OpbToStringMode mode = OpbToStringMode.MINIMAL;
        OpbToStringHelper.setToStringMode(mode);
        assertSame(mode, OpbToStringHelper.getToStringMode());
        OpbToStringHelper.setToStringMode(null);
        assertSame(mode, OpbToStringHelper.getToStringMode());

        mode = OpbToStringMode.EXCLUDE_SUPER_CLASS;
        OpbToStringHelper.setToStringMode(mode);
        assertSame(mode, OpbToStringHelper.getToStringMode());

        mode = OpbToStringMode.FULL;
        OpbToStringHelper.setToStringMode(mode);
        assertSame(mode, OpbToStringHelper.getToStringMode());

    }

    /**
     * Test of getFieldFilter method, of class OpbToStringHelper.
     */
    public void testGetFieldFilter() {
        System.out.println("getFieldFilter");

        OpbFieldFilter result = OpbToStringHelper.getFieldFilter();
        assertNotNull(result);
        OpbFieldFilter f = new OpbFieldFilter() {
            public boolean accept(Object object, Field field) {
                return false;
            }
        };
        OpbToStringHelper.setFieldFilter(f);
        assertNotSame(result, f);
        OpbToStringHelper.setFieldFilter(null);
        assertSame(result, OpbToStringHelper.getFieldFilter());
    }

    /**
     * Test of setFieldFilter method, of class OpbToStringHelper.
     */
    public void testSetFieldFilter() {
        System.out.println("setFieldFilter");
        OpbFieldFilter fieldFilter = null;
        OpbToStringHelper.setFieldFilter(fieldFilter);
        assertNotNull(OpbToStringHelper.getFieldFilter());
        OpbFieldFilter f = new OpbFieldFilter() {
            public boolean accept(Object object, Field field) {
                return false;
            }
        };
        OpbToStringHelper.setFieldFilter(f);
        assertSame(f, OpbToStringHelper.getFieldFilter());

    }

    /**
     * Test of toStringFull method, of class OpbToStringHelper.
     */
    public void testToStringFull() {
        System.out.println("toStringFull");
        Object object = null;
        assertEquals("null", OpbToStringHelper.toStringFull(object));
        object = "null";
        assertEquals(
                OpbToStringHelper.toStringFull(object),
                OpbToStringHelper.toStringFull(object));
        assertSame(
                OpbToStringHelper.toStringFull(object),
                OpbToStringHelper.toStringFull("null"));
        assertSame(OpbToStringHelper.getToStringMode(), MINIMAL);
        // TODO: xxx write a proper test
//        OpbSingleMemberGroup group = new OpbSingleMemberGroup();
//        String ts = group.toString();
//        String full = OpbToStringHelper.toStringFull(group);
//        assertSame(OpbToStringHelper.getToStringMode(), MINIMAL);
//        System.out.println("~~~MINI");
//        System.out.println(ts);
//        System.out.println("~~~MINI end of ");
//        System.out.println("~~~FULL");
//        System.out.println(full);
//        System.out.println("~~~FULL end of ");
//        assertNotSame(ts, full);
//        OpbToStringHelper.setToStringMode(FULL);
//        ts = group.toString();
//        assertEquals(full, ts);
//        assertTrue(
//                OpbToStringHelper.toString(new TestObjectForToStringThrowEx())
//                .indexOf("toString() threw an exception!") != -1);
    }

    public void testToStringExtra() {
        System.out.println("toStringExtra()");
        OpbToStringHelper.setToStringMode(FULL);
        OpbToStringHelper.toString(new TestEmptyObjectForToString());
        OpbToStringHelper.toString(getClass());
        OpbToStringHelper.toString(TestHelper.getOracleDataSource());
        OpbToStringHelper.toString(TestHelper.getResultSet("select * from dual"));
        OpbToStringHelper.toString(TestHelper.getSharedOpbSession().getOpbConnectionProvider());
        OpbToStringHelper.toString(
                TestHelper.getSharedOpbSession().getOpbConnectionProvider().getConnection());
        OpbToStringHelper.toString(new TestObjectForToStringReturnNull());
        Object o = new Object[] {
            1, "2", 3.0, "four",
            TestHelper.getSharedOpbSession(),
            "after session",
            null,
            new TestObjectForToStringReturnNull()};
        OpbToStringHelper.toString(o);
        o = new Object[] {
            1, "2", 3.0, "four",
            null,
            new TestObjectForToStringReturnNull()};
        String expected =
                "Object[](1)[ \n" +
                "  [1, 2, 3.0, four, null, null]\n" +
                "]Object[](1)";
        System.out.println(expected);
        System.out.println(OpbToStringHelper.toString(o));
        assertEquals(expected, OpbToStringHelper.toString(o));
    }

}
