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
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Peter Butterfill
 */
public class OpbIdTest extends TestCase {

    public OpbIdTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbIdTest.class);

        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.OpbId.
     */
    public void testToString() {
        System.out.println("toString");

        OpbId instance = new OpbId(null, 1);

        String expResult = "[null, 1]";
        String result = instance.toString();
        assertEquals(expResult, result);

        assertEquals(
                "[1]",
                new OpbId(1).toString());
        assertEquals(
                "[1]",
                new OpbId("1").toString());
        assertEquals(
                "[a, b, c]",
                new OpbId("a", "b", "c").toString());
        Object o = new Object();
        assertEquals(
                "["+ o +"]",
                new OpbId(o).toString());
        assertEquals(
                "[" + o + ", " + o + "]",
                new OpbId(o, o).toString());
        assertEquals(
                "[x, " + o + ", " + o + ", 999]",
                new OpbId("x", o, o, 999).toString());

        o = new Object[]{"elem1", "elem2"};
        assertEquals(
                "[[elem1, elem2]]",
                new OpbId(o).toString());

    }

    /**
     * Test of equals method, of class com.butterfill.opb.OpbId.
     */
    public void testEquals() {
        System.out.println("equals");

        // general purpose not-equals ID
        Object ne = new OpbId("a", 3, 9);
        Object nullRef = null;

        Object x = new OpbId("a", 3);
        Object y = new OpbId("a", 3);
        OpbId z = new OpbId("a", 3);

        // make sure all 3 are equal orcording to JUnit
        assertEquals(x, y);
        assertEquals(x, z);
        assertEquals(y, z);

        //the following tests are repeated to prove consitency
        for (int i = 0; i < 9; i++) {
            x = new OpbId("a", i, 45);
            y = new OpbId("a", i, 45);
            z = new OpbId("a", i, 45);

            for (int j = 0; j < 9; j++) {

                //reflexive
                assertTrue(x.equals(x));

                //symetric
                assertTrue(x.equals(y));
                assertTrue(y.equals(x));

                assertFalse(x.equals(ne));
                assertFalse(ne.equals(x));

                //transitive
                assertTrue(x.equals(y));
                assertTrue(y.equals(z));
                assertTrue(z.equals(x));

                assertTrue(x.equals(y));
                assertFalse(y.equals(ne));
                assertFalse(ne.equals(x));

                // always false for null
                assertFalse(x.equals(null));
                assertFalse(x.equals(nullRef));
            }
        }

        x = new OpbId(new String[] {"a", "b", "c"}, 3);
        y = new OpbId(new String[] {"a", "b", "c"}, 3);
        z = new OpbId(new String[] {"a", "b", "c"}, 3);

        assertEquals(x, y);
        assertEquals(x, z);
        assertEquals(y, z);

        //repeat test to prove consitency
        for (int i = 0; i < 9; i++) {
            x = new OpbId("a", i, 45);
            y = new OpbId("a", i, 45);
            z = new OpbId("a", i, 45);

            for (int j = 0; j < 9; j++) {

                //reflexive
                assertTrue(x.equals(x));

                //symetric
                assertTrue(x.equals(y));
                assertTrue(y.equals(x));

                assertFalse(x.equals(ne));
                assertFalse(ne.equals(x));

                //transitive
                assertTrue(x.equals(y));
                assertTrue(y.equals(z));
                assertTrue(z.equals(x));

                assertTrue(x.equals(y));
                assertFalse(y.equals(ne));
                assertFalse(ne.equals(x));

                // always false for null
                assertFalse(x.equals(null));
                assertFalse(x.equals(nullRef));
            }
        }

        String[] array = new String[] {"a", "b", "c"};
        x = new OpbId(array, 4);
        y = new OpbId(array, 4);
        z = new OpbId(array, 4);

        //repeat test to prove consitency
        for (int i = 0; i < 9; i++) {
            x = new OpbId("a", i, 45);
            y = new OpbId("a", i, 45);
            z = new OpbId("a", i, 45);

            for (int j = 0; j < 9; j++) {

                //reflexive
                assertTrue(x.equals(x));

                //symetric
                assertTrue(x.equals(y));
                assertTrue(y.equals(x));

                assertFalse(x.equals(ne));
                assertFalse(ne.equals(x));

                //transitive
                assertTrue(x.equals(y));
                assertTrue(y.equals(z));
                assertTrue(z.equals(x));

                assertTrue(x.equals(y));
                assertFalse(y.equals(ne));
                assertFalse(ne.equals(x));

                // always false for null
                assertFalse(x.equals(null));
                assertFalse(x.equals(nullRef));
            }
        }

        // check arrays of different lengths
        Object stringArray = new String[] {"a", "b", "c"};
        Object stringArray2 = new String[] {};
        Object arrayId = new OpbId(stringArray);
        Object arrayId2 = new OpbId(stringArray2);

        assertFalse(arrayId.equals(arrayId2));
        assertFalse(arrayId2.equals(arrayId));

        arrayId = new OpbId(stringArray2);
        arrayId2 = new OpbId(stringArray);

        assertFalse(arrayId.equals(arrayId2));
        assertFalse(arrayId2.equals(arrayId));

        // check id's with different numbers of values
        assertFalse(new OpbId(1).equals(new OpbId(1, 1)));

        assertFalse(
                new OpbId(new Object[]{null, null}).equals(
                new OpbId(new Object[]{null, 2})));
        assertFalse(
                new OpbId(null, new Object[]{null, null}).equals(
                new OpbId(null, new Object[]{null, 2})));

        // compare an id containing a single array with an id containing a
        // single non-array value
        assertFalse(arrayId.equals(new OpbId("notAnArray")));
    }

    /**
     * Test of hashCode method, of class com.butterfill.opb.OpbId.
     */
    public void testHashCode() {
        System.out.println("hashCode");

        Object o = new Object();

        OpbId instance = new OpbId("fx", 9, o);

        int result = instance.hashCode();

        for (int i = 0; i < 9; i++) {
            assertEquals(result, instance.hashCode());
        }

        OpbId instance2 = new OpbId("fx", 9, o);

        // quick check to make sure the 2 instance have the same hashcode
        assertTrue(instance.hashCode() == instance2.hashCode());

        instance2 = new OpbId("fx", 9, new Object());

        // quick check to make sure the 2 instance don't have the same hashcode
        assertTrue(instance.hashCode() != instance2.hashCode());

        // run some repetitive tests
        
        int equalsCount = 0;
        int nonEqualHashCount = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    instance = new OpbId(i, j, k);
                    instance2 = new OpbId(k, j, i);
                    if (instance.equals(instance2)) {
                        assertEquals(instance.hashCode(), instance2.hashCode());
                        equalsCount++;
                    }
                    if (instance.hashCode() != instance2.hashCode()) {
                        assertFalse(instance.equals(instance2));
                        nonEqualHashCount++;
                    }
                    instance = new OpbId(i, j, null, k);
                    instance2 = new OpbId(k, j, null, i);
                    if (instance.equals(instance2)) {
                        assertEquals(instance.hashCode(), instance2.hashCode());
                    }
                    if (instance.hashCode() != instance2.hashCode()) {
                        assertFalse(instance.equals(instance2));
                    }
                }
            }
        }

        assertEquals(81, equalsCount);
        assertEquals(648, nonEqualHashCount);

        equalsCount = 0;
        nonEqualHashCount = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    instance = new OpbId(null, new Object[] {i, j, k});
                    instance2 = new OpbId(null, new Object[] {k, j, i});
                    if (instance.equals(instance2)) {
                        assertEquals(instance.hashCode(), instance2.hashCode());
                        equalsCount++;
                    }
                    if (instance.hashCode() != instance2.hashCode()) {
                        assertFalse(instance.equals(instance2));
                        nonEqualHashCount++;
                    }
                    instance = new OpbId(null, new Object[] {i, j, k, null});
                    instance2 = new OpbId(null, new Object[] {k, j, i, null});
                    if (instance.equals(instance2)) {
                        assertEquals(instance.hashCode(), instance2.hashCode());
                    }
                    if (instance.hashCode() != instance2.hashCode()) {
                        assertFalse(instance.equals(instance2));
                    }
                }
            }
        }

        assertEquals(81, equalsCount);
        assertEquals(648, nonEqualHashCount);
    }

}
