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

import com.butterfill.opb.OpbId;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataObjectSource;
import helpers.AssertHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.*;

/**
 * Note: Full test suite will run toString on all objects.
 *
 * @author Peter Butterfill
 */
public class OpbValueObjectHelperTest extends TestCase {

    Map<String, Object> expObject;
    Map<String, Object> expObject2;

    public OpbValueObjectHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        expObject = new HashMap<String, Object>();
        expObject.put("CLASS_NAME", "com.butterfill.opb.util.OpbValueObjectHelperTest$TestObject");
        expObject.put("name", "Bill");
        expObject.put("id", 789L);
        expObject.put("nullValue", null);
        expObject.put("opbId", new Object[]{789L});

        expObject2 = new HashMap<String, Object>();
        expObject2.put("CLASS_NAME", "com.butterfill.opb.util.OpbValueObjectHelperTest$TestObject2");
        expObject2.put("firstname", "Jane");
        expObject2.put("lastname", "Jones");
        expObject2.put("id", 321L);
        expObject2.put("nullValue", null);
        expObject2.put("opbId", new Object[]{321L});
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbValueObjectHelperTest.class);
        return suite;
    }

    /**
     * asserts that 2 value objects are equal.
     */
    private static void assertValueObjectEqual(
            Map<String, Object> expResult, Map<String, Object> result) {
        final Set<String> keySet = expResult.keySet();
        // 1st check that they have the same number of entries
        assertEquals(
                "value objects have different number of entries"
                + "\n expResult=" + expResult
                + ", \n result=" + result + "\n",
                keySet.size(), result.keySet().size());

        // then we check each entry
        for (String key : keySet) {
            Object expValue = expResult.get(key);
            Object value = result.get(key);

            if (expValue instanceof Object[]) {
                // assertEquals doesn't work for arrays -
                // so if the values are arrays, we need to use the helper to assert they are equal
                AssertHelper.assertArrayEqual((Object[]) expValue, (Object[]) value);

            } else {
                // otherwise we can do a normal assertEquals
                assertEquals(
                        "\nexpResult=" + expResult + ", \nresult=" + result + "\n",
                        expValue, value);
            }
        }
    }

    /**
     * Asserts that 2 lists contain equal value objects -
     * the lists must contain the same number of objects and in the same order.
     */
    private static void assertValueObjectEqual(
            List<Map<String, Object>> expResult, List<Map<String, Object>> result) {
        // 1st check that they have the same number of elements
        assertEquals(
                "lists have different number of elements"
                + "\n expResult=" + expResult
                + ", \n result=" + result + "\n",
                expResult.size(), result.size());

        for (int i = 0; i < result.size(); i++) {
            assertValueObjectEqual(expResult.get(i), result.get(i));
        }
    }

    /**
     * test converting an object
     */
    public void testToValueObject() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();

        Object value = null;
        assertNull(instance.toValueObject(value));

        assertValueObjectEqual(expObject, instance.toValueObject(new TestObject()));

    }

    /**
     * test converting a list
     */
    public void testToValueObjectList() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();

        List<Object> valueList = null;
        assertNull(instance.toValueObject(valueList));

        List<Map<String, Object>> expResult = new ArrayList<Map<String, Object>>();
        expResult.add(expObject);
        expResult.add(expObject2);

        valueList = new ArrayList<Object>();
        valueList.add(new TestObject());
        valueList.add(new TestObject2());

        assertValueObjectEqual(expResult, instance.toValueObject(valueList));

    }

    /**
     * test with a list of TestObject (rather than list of Object)
     */
    public void testToValueObjectList2() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();

        List<Map<String, Object>> expResult = new ArrayList<Map<String, Object>>();
        expResult.add(expObject);
        List<TestObject> testObjectList = new ArrayList<TestObject>();
        testObjectList.add(new TestObject());
        assertValueObjectEqual(expResult, instance.toValueObject(testObjectList));

    }

    /**
     * test with a list with no type
     */
    public void testToValueObjectList3() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();

        List<Map<String, Object>> expResult = new ArrayList<Map<String, Object>>();
        expResult.add(expObject);
        expResult.add(expObject2);
        List objectList = new ArrayList();
        objectList.add(new TestObject());
        objectList.add(new TestObject2());
        assertValueObjectEqual(expResult, instance.toValueObject(objectList));

    }

    /**
     * test converting an array
     */
    public void testToValueObjectArray() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();

        Object[] valueArray = null;
        assertNull(instance.toValueObject(valueArray));

        valueArray = new Object[]{new TestObject(), new TestObject2()};

        List<Map<String, Object>> expResult = new ArrayList<Map<String, Object>>();
        expResult.add(expObject);
        expResult.add(expObject2);

        assertValueObjectEqual(expResult, instance.toValueObject(valueArray));

        // we can also create the array on the fly
        assertValueObjectEqual(
                expResult,
                instance.toValueObject(new Object[]{new TestObject(), new TestObject2()}));

    }

    public void testGetFieldFilter() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();
        assertNotNull(instance.getFieldFilter());
    }

    public void testSetFieldFilter() {
        OpbValueObjectHelper instance = new OpbValueObjectHelper();
        final OpbFieldFilter defaultFieldFilter = instance.getFieldFilter();
        OpbFieldFilter fieldFilter = new OpbFieldFilter() {
            public boolean accept(Object object, Field field) {
                return true;
            }
        };
        assertSame(defaultFieldFilter, instance.getFieldFilter());
        assertNotSame(fieldFilter, instance.getFieldFilter());
        instance.setFieldFilter(fieldFilter);
        assertSame(fieldFilter, instance.getFieldFilter());
        // if we try to set the field filter to null, the value object helper should use the default
        instance.setFieldFilter(null);
        assertSame(defaultFieldFilter, instance.getFieldFilter());
    }


    static class TestObject {
        OpbDataObjectSource opbDataObjectSource;
        OpbConnectionProvider opbConnectionProvider;
        Object nullValue;
        String name = "Bill";
        Long id = 789L;
        OpbId opbId = new OpbId(id);

    }

    static class TestObject2 {
        OpbDataObjectSource opbDataObjectSource;
        OpbConnectionProvider opbConnectionProvider;
        Object nullValue;
        String firstname = "Jane";
        String lastname = "Jones";
        Long id = 321L;
        OpbId opbId = new OpbId(id);

    }

}
