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


package com.butterfill.opb.plsql.translation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class PlsqlCallParameterTest extends TestCase {

    public PlsqlCallParameterTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlCallParameterTest.class);
        return suite;
    }

    PlsqlCallParameter instance;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        instance = new PlsqlCallParameter("a", "integer", true, true);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of toString method, of class PlsqlCallParameter.
     */
    public void testToString() {
        System.out.println("toString");

        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getIndex method, of class PlsqlCallParameter.
     */
    public void testGetIndex() {
        System.out.println("getIndex");

        int expResult = 0;
        int result = instance.getIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIndex method, of class PlsqlCallParameter.
     */
    public void testSetIndex() {
        System.out.println("setIndex");
        int index = 1;

        instance.setIndex(index);
        assertEquals(index, instance.getIndex());
    }

    /**
     * Test of getSqlName method, of class PlsqlCallParameter.
     */
    public void testGetSqlName() {
        System.out.println("getSqlName");

        String expResult = "a";
        String result = instance.getSqlName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class PlsqlCallParameter.
     */
    public void testGetName() {
        System.out.println("getName");

        String expResult = "a";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSqlDatatype method, of class PlsqlCallParameter.
     */
    public void testGetSqlDatatype() {
        System.out.println("getSqlDatatype");

        String expResult = "INTEGER";
        String result = instance.getSqlDatatype();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDatatype method, of class PlsqlCallParameter.
     */
    public void testGetDatatype() {
        System.out.println("getDatatype");

        String expResult = "OpbValueWrapper";
        String result = instance.getDatatype();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIn method, of class PlsqlCallParameter.
     */
    public void testGetIn() {
        System.out.println("getIn");

        boolean expResult = true;
        boolean result = instance.getIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOut method, of class PlsqlCallParameter.
     */
    public void testGetOut() {
        System.out.println("getOut");

        boolean expResult = true;
        boolean result = instance.getOut();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUseDataObjectCache method, of class PlsqlCallParameter.
     */
    public void testIsUseDataObjectCache() {
        System.out.println("isUseDataObjectCache");

        assertNull(instance.isUseDataObjectCache());
    }


    /**
     * Test of isUseResultCache method, of class PlsqlCallParameter.
     */
    public void testIsUseResultCache() {
        System.out.println("isUseResultCache");

        assertNull(instance.isUseResultCache());
    }


    /**
     * Test of isUseScalarResultCache method, of class PlsqlCallParameter.
     */
    public void testIsUseScalarResultCache() {
        System.out.println("isUseScalarResultCache");

       assertNull(instance.isUseScalarResultCache());

    }


    /**
     * Test of getWrappedDatatype method, of class PlsqlCallParameter.
     */
    public void testGetWrappedDatatype() {
        System.out.println("getWrappedDatatype");

        String expResult = "Long";
        String result = instance.getWrappedDatatype();
        assertEquals(expResult, result);
    }


    /**
     * Test of getJdbcType method, of class PlsqlCallParameter.
     */
    public void testGetJdbcType() {
        System.out.println("getJdbcType");

        String expResult = "java.sql.Types.BIGINT";
        String result = instance.getJdbcType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMappedTo method, of class PlsqlCallParameter.
     */
    public void testGetMappedTo() {
        System.out.println("getMappedTo");

        String expResult = null;
        String result = instance.getMappedTo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMappedToProperty method, of class PlsqlCallParameter.
     */
    public void testGetMappedToProperty() {
        System.out.println("getMappedToProperty");

        String expResult = null;
        String result = instance.getMappedToProperty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElementTypeOfDatatype method, of class PlsqlCallParameter.
     */
    public void testGetElementTypeOfDatatype() {
        System.out.println("getElementTypeOfDatatype");

        String expResult = null;
        String result = instance.getElementTypeOfDatatype();
        assertEquals(expResult, result);

    }


    /**
     * Test of isCursor method, of class PlsqlCallParameter.
     */
    public void testIsCursor() {
        System.out.println("isCursor");

        boolean expResult = false;
        boolean result = instance.isCursor();
        assertEquals(expResult, result);
    }


    /**
     * Test of getOriginalSqlDatatype method, of class PlsqlCallParameter.
     */
    public void testGetOriginalSqlDatatype() {
        System.out.println("getOriginalSqlDatatype");

        String expResult = "integer";
        assertEquals(expResult, instance.getOriginalSqlDatatype());
        instance.opb_datatype("varchar");
        assertEquals(expResult, instance.getOriginalSqlDatatype());
    }

    /**
     * Test of opb_name method, of class PlsqlCallParameter.
     */
    public void testOpb_name() {
        System.out.println("opb_name");

        instance.opb_name("b");
        assertEquals("a", instance.getSqlName());
    }

    /**
     * Test of opb_datatype method, of class PlsqlCallParameter.
     */
    public void testOpb_datatype() {
        System.out.println("opb_datatype");

        instance.opb_datatype("number");
        assertEquals("NUMBER", instance.getSqlDatatype());
        assertEquals("OpbValueWrapper", instance.getDatatype());
        assertEquals("java.math.BigDecimal", instance.getWrappedDatatype());
        assertEquals("java.sql.Types.DECIMAL", instance.getJdbcType());
    }

    /**
     * Test of opb_field method, of class PlsqlCallParameter.
     */
    public void testOpb_field() {
        System.out.println("opb_field");

        instance.opb_field("K_y");
        assertEquals("KY", instance.getMappedTo());
        assertEquals("kY", instance.getMappedToProperty());
    }

    /**
     * Test of opb_use_result_cache method, of class PlsqlCallParameter.
     */
    public void testOpb_use_result_cache() {
        System.out.println("opb_use_result_cache");

        assertNull(instance.isUseResultCache());
        instance.opb_use_result_cache("y");
        assertTrue(instance.isUseResultCache());
        instance.opb_use_result_cache("n");
        assertFalse(instance.isUseResultCache());
        instance.opb_use_result_cache("Y");
        assertTrue(instance.isUseResultCache());
        instance.opb_use_result_cache("N");
        assertFalse(instance.isUseResultCache());

    }

    /**
     * Test of opb_use_scalar_result_cache method, of class PlsqlCallParameter.
     */
    public void testOpb_use_scalar_result_cache() {
        System.out.println("opb_use_scalar_result_cache");

        assertNull(instance.isUseScalarResultCache());
        instance.opb_use_scalar_result_cache("y");
        assertTrue(instance.isUseScalarResultCache());
        instance.opb_use_scalar_result_cache("n");
        assertFalse(instance.isUseScalarResultCache());
        instance.opb_use_scalar_result_cache("Y");
        assertTrue(instance.isUseScalarResultCache());
        instance.opb_use_scalar_result_cache("N");
        assertFalse(instance.isUseScalarResultCache());


    }

    /**
     * Test of opb_use_data_object_cache method, of class PlsqlCallParameter.
     */
    public void testOpb_use_data_object_cache() {
        System.out.println("opb_use_data_object_cache");

        assertNull(instance.isUseDataObjectCache());
        instance.opb_use_data_object_cache("y");
        assertTrue(instance.isUseDataObjectCache());
        instance.opb_use_data_object_cache("n");
        assertFalse(instance.isUseDataObjectCache());
        instance.opb_use_data_object_cache("Y");
        assertTrue(instance.isUseDataObjectCache());
        instance.opb_use_data_object_cache("N");
        assertFalse(instance.isUseDataObjectCache());
    }

    /**
     * Test of isPlsqlIndexTable method, of class PlsqlCallParameter.
     */
    public void testIsPlsqlIndexTable() {
        System.out.println("isPlsqlIndexTable");

        assertFalse(instance.isPlsqlIndexTable());
    }

    /**
     * Test of isReturn method, of class PlsqlCallParameter.
     */
    public void testIsReturn() {
        System.out.println("isReturn");

        assertFalse(instance.isReturn());
    }

    /**
     * Test of setUseDataObjectCache method, of class PlsqlCallParameter.
     */
    public void testSetUseDataObjectCache() {
        System.out.println("setUseDataObjectCache");

        instance.setUseDataObjectCache(true);
        instance.setUseDataObjectCache(false);
    }

    /**
     * Test of setUseResultCache method, of class PlsqlCallParameter.
     */
    public void testSetUseResultCache() {
        System.out.println("setUseResultCache");

        instance.setUseResultCache(true);
        instance.setUseResultCache(false);
    }

    /**
     * Test of setUseScalarResultCache method, of class PlsqlCallParameter.
     */
    public void testSetUseScalarResultCache() {
        System.out.println("setUseScalarResultCache");

        instance.setUseScalarResultCache(true);
        instance.setUseScalarResultCache(false);
    }

    /**
     * Test of isArray method, of class PlsqlCallParameter.
     */
    public void testIsArray() {
        System.out.println("isArray");

        assertFalse(instance.isArray());
    }

}
