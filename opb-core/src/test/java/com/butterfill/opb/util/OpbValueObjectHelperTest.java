/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.butterfill.opb.util;

import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.data.ArraysIn;
import com.butterfill.opb.util.data.OneOfEachSqlType;
import com.butterfill.opb.util.data.OneOfEachSqlTypeValueObject;
import helpers.TestHelper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.*;

/**
 * Note: Full test suite will run toString on all objects.
 *
 * @author Peter Butterfill
 */
public class OpbValueObjectHelperTest extends TestCase {

    public OpbValueObjectHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbValueObjectHelperTest.class);
        return suite;
    }

    public void testConstructors() {
        // negative tests
        OpbDataObjectSource dataObjectSource = null;
        OpbSession session = null;

        try {
            new OpbValueObjectHelper(dataObjectSource);
            fail("constructor should throw null pointer when data object source is null");
        } catch (NullPointerException ex) {
        }

        try {
            new OpbValueObjectHelper(session);
            fail("constructor should throw null pointer when session is null");
        } catch (NullPointerException ex) {
        }

        try {
            new OpbValueObjectHelper(newMockSession(null));
            fail("should throw null pointer when data object source provided by session is null");
        } catch (NullPointerException ex) {
        }

        // positive tests
        new OpbValueObjectHelper();
        dataObjectSource = new OpbDataObjectSource(new OpbObjectSourceImpl());
        new OpbValueObjectHelper(dataObjectSource);
        new OpbValueObjectHelper(newMockSession(dataObjectSource));

    }

    public void testToValueObjectList() {
        OpbDataObjectSource dataObjectSource = new OpbDataObjectSource(new OpbObjectSourceImpl());
        OpbValueObjectHelper instance = new OpbValueObjectHelper(dataObjectSource);

        assertNull(instance.toValueObjectList(null));

        // passing empty list should return an empty list
        ArrayList opbObjects = new ArrayList();
        assertEquals(opbObjects, instance.toValueObjectList(opbObjects));

        // null elements in list should be returned as null in result
        opbObjects.add(null);
        assertEquals(opbObjects, instance.toValueObjectList(opbObjects));

        // value object providers in list should be returned as value objects in result
        ArrayList expResult = new ArrayList();
        opbObjects = new ArrayList();
        OneOfEachSqlType oneOfEachSqlType = dataObjectSource.newInstance(OneOfEachSqlType.class);
        opbObjects.add(oneOfEachSqlType);
        expResult.add(oneOfEachSqlType.opbToValueObject());
        assertEquals(
                TestHelper.toOpbIdList(expResult),
                TestHelper.toOpbIdList(instance.toValueObjectList(opbObjects)));

        // can mix in null elements with not null elements
        expResult.add(null);
        opbObjects.add(null);
        assertEquals(
                TestHelper.toOpbIdList(expResult),
                TestHelper.toOpbIdList(instance.toValueObjectList(opbObjects)));

        // opb objects that are not value providers shoudl be returned as null in result
        expResult = new ArrayList();
        opbObjects = new ArrayList();
        ArraysIn arraysIn = dataObjectSource.newInstance(ArraysIn.class);
        opbObjects.add(arraysIn);
        // arraysIn is not added to result as it's not a value object provider
        expResult.add(null);
        assertEquals(
                TestHelper.toOpbIdList(expResult),
                TestHelper.toOpbIdList(instance.toValueObjectList(opbObjects)));

        // unknown objects in list cause exceptions
        opbObjects.add(new Object());
        try {
            instance.toValueObjectList(opbObjects);
            fail("trying to convert unrecognised objects should throw an exception");
        } catch (Exception ex) {
            assertTrue(ex.getMessage().startsWith("failed to add value object to list"));
        }

    }

    public void testToOpbObjectList() {
        OpbDataObjectSource dataObjectSource = new OpbDataObjectSource(new OpbObjectSourceImpl());
        OpbValueObjectHelper instance = new OpbValueObjectHelper(dataObjectSource);

        assertNull(instance.toOpbObjectList(null, null));

        // passing empty list should return an empty list
        ArrayList valueObjects = new ArrayList();
        assertEquals(valueObjects, instance.toOpbObjectList(null, valueObjects));

        // null elements in list should be returned as null in result
        valueObjects.add(null);
        assertEquals(valueObjects, instance.toOpbObjectList(null, valueObjects));

        // convert an "empty" value object to an Opb object
        OneOfEachSqlTypeValueObject valueObject = new OneOfEachSqlTypeValueObject();
        valueObjects = new ArrayList();
        valueObjects.add(valueObject);
        List<OneOfEachSqlType> result =
                instance.toOpbObjectList(OneOfEachSqlType.class, valueObjects);
        assertEquals(1, result.size());
        OneOfEachSqlType oneOfEachSqlType = result.get(0);
        assertEquals(null, oneOfEachSqlType.getABinaryDouble());
        assertEquals(null, oneOfEachSqlType.getABinaryDoubleDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getABinaryDoubleChanged());
        assertEquals(null, oneOfEachSqlType.getABinaryFloat());
        assertEquals(null, oneOfEachSqlType.getABinaryFloatDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getABinaryFloatChanged());
        assertEquals(null, oneOfEachSqlType.getABlob());
        assertEquals(null, oneOfEachSqlType.getABlobDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getABlobChanged());
        assertEquals(null, oneOfEachSqlType.getAChar());
        assertEquals(null, oneOfEachSqlType.getACharDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getACharChanged());
        assertEquals(null, oneOfEachSqlType.getAClob());
        assertEquals(null, oneOfEachSqlType.getAClobDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getAClobChanged());
        assertEquals(null, oneOfEachSqlType.getADate());
        assertEquals(null, oneOfEachSqlType.getADateDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getADateChanged());
        assertEquals(null, oneOfEachSqlType.getANclob());
        assertEquals(null, oneOfEachSqlType.getANclobDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getANclobChanged());
        assertEquals(null, oneOfEachSqlType.getANumber());
        assertEquals(null, oneOfEachSqlType.getANumberDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getANumberChanged());
        assertEquals(null, oneOfEachSqlType.getANvarchar2());
        assertEquals(null, oneOfEachSqlType.getANvarchar2DataSourceValue());
        assertEquals(false, oneOfEachSqlType.getANvarchar2Changed());
        assertEquals(null, oneOfEachSqlType.getARaw());
        assertEquals(null, oneOfEachSqlType.getARawDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getARawChanged());
        assertEquals(null, oneOfEachSqlType.getATimestamp());
        assertEquals(null, oneOfEachSqlType.getATimestampDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getATimestampChanged());
        assertEquals(null, oneOfEachSqlType.getAVarchar2());
        assertEquals(null, oneOfEachSqlType.getAVarchar2DataSourceValue());
        assertEquals(false, oneOfEachSqlType.getAVarchar2Changed());

        // convert a value object (that has some values set) to an Opb object
        valueObject = new OneOfEachSqlTypeValueObject();
        valueObject.aBinaryDouble = new Double(33.3);
        valueObject.aBinaryDoubleDataSourceValue = new Double(33.0);
        valueObject.aChar = "a";
        valueObject.aCharDataSourceValue = "a";
        valueObject.aDateDataSourceValue = new Date();
        valueObject.aVarchar2 = "any-old-string";
        valueObjects = new ArrayList();
        valueObjects.add(valueObject);
        result = instance.toOpbObjectList(OneOfEachSqlType.class, valueObjects);
        assertEquals(1, result.size());
        oneOfEachSqlType = result.get(0);
        assertEquals(new Double(33.3), oneOfEachSqlType.getABinaryDouble());
        assertEquals(new Double(33.0), oneOfEachSqlType.getABinaryDoubleDataSourceValue());
        assertEquals(true, oneOfEachSqlType.getABinaryDoubleChanged());
        assertEquals(null, oneOfEachSqlType.getABinaryFloat());
        assertEquals(null, oneOfEachSqlType.getABinaryFloatDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getABinaryFloatChanged());
        assertEquals(null, oneOfEachSqlType.getABlob());
        assertEquals(null, oneOfEachSqlType.getABlobDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getABlobChanged());
        assertEquals("a", oneOfEachSqlType.getAChar());
        assertEquals("a", oneOfEachSqlType.getACharDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getACharChanged());
        assertEquals(null, oneOfEachSqlType.getAClob());
        assertEquals(null, oneOfEachSqlType.getAClobDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getAClobChanged());
        assertEquals(null, oneOfEachSqlType.getADate());
        assertEquals(valueObject.aDateDataSourceValue, oneOfEachSqlType.getADateDataSourceValue());
        assertEquals(true, oneOfEachSqlType.getADateChanged());
        assertEquals(null, oneOfEachSqlType.getANclob());
        assertEquals(null, oneOfEachSqlType.getANclobDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getANclobChanged());
        assertEquals(null, oneOfEachSqlType.getANumber());
        assertEquals(null, oneOfEachSqlType.getANumberDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getANumberChanged());
        assertEquals(null, oneOfEachSqlType.getANvarchar2());
        assertEquals(null, oneOfEachSqlType.getANvarchar2DataSourceValue());
        assertEquals(false, oneOfEachSqlType.getANvarchar2Changed());
        assertEquals(null, oneOfEachSqlType.getARaw());
        assertEquals(null, oneOfEachSqlType.getARawDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getARawChanged());
        assertEquals(null, oneOfEachSqlType.getATimestamp());
        assertEquals(null, oneOfEachSqlType.getATimestampDataSourceValue());
        assertEquals(false, oneOfEachSqlType.getATimestampChanged());
        assertEquals("any-old-string", oneOfEachSqlType.getAVarchar2());
        assertEquals(null, oneOfEachSqlType.getAVarchar2DataSourceValue());
        assertEquals(true, oneOfEachSqlType.getAVarchar2Changed());

    }

    private OpbSession newMockSession(final OpbDataObjectSource dataObjectSource) {
        final InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getDataObjectSource")) {
                    return dataObjectSource;
                }
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        return (OpbSession) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{OpbSession.class},
                invocationHandler);

    }
}
