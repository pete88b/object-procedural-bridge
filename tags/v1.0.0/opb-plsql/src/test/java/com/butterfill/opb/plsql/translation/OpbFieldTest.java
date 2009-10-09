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

import com.butterfill.opb.OpbConstants;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class OpbFieldTest extends TestCase {
    
    public OpbFieldTest(String testName) {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbFieldTest.class);
        return suite;
    }
    
    /**
     * Test of toString method, of class OpbField.
     */
    public void testToString() {
        System.out.println("toString");
        OpbField instance = new OpbField();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of opb_name method, of class OpbField.
     */
    public void testOpb_name() {
        System.out.println("opb_name");
        String s = "a_a";
        OpbField instance = new OpbField();
        instance.opb_name(s);
        assertEquals("a_a", instance.getSqlName());
        assertEquals("aA", instance.getName());
        assertEquals("AA", instance.getNameWithFirstCharUpper());
    }

    /**
     * Test of opb_datatype method, of class OpbField.
     */
    public void testOpb_datatype() {
        System.out.println("opb_datatype");
        String s = "varchar";
        OpbField instance = new OpbField();
        instance.opb_datatype(s);
        assertEquals("VARCHAR", instance.getSqlDatatype());
        assertEquals("String", instance.getDatatype());
        assertTrue(instance.isLoadable());
        instance.opb_applyElementComplete();
        assertTrue(instance.isLoadable());
        
        instance.opb_datatype("varchar[]");
        assertEquals("VARCHAR[]", instance.getSqlDatatype());
        assertEquals("String[]", instance.getDatatype());
        assertTrue(instance.isLoadable());
        instance.opb_applyElementComplete();
        assertFalse(instance.isLoadable());
        
    }

    /**
     * Test of opb_initial_value method, of class OpbField.
     */
    public void testOpb_initial_value() {
        System.out.println("opb_initial_value");
        String s = "x";
        OpbField instance = new OpbField();
        instance.opb_initial_value(s);
        assertEquals("x", instance.getSqlInitialValue());
    }

    /**
     * Test of opb_id method, of class OpbField.
     */
    public void testOpb_id() {
        System.out.println("opb_id");
        String s = "y";
        OpbField instance = new OpbField();
        assertFalse(instance.isId());
        instance.opb_id(s);
        assertTrue(instance.isId());
    }

    /**
     * Test of opb_on_change method, of class OpbField.
     */
    public void testOpb_on_change() {
        System.out.println("opb_on_change");
        String s = "a_a";
        OpbField instance = new OpbField();
        assertEquals(0, instance.getOnChangeList().size());
        instance.opb_on_change(s);
        assertEquals(1, instance.getOnChangeList().size());
        assertEquals("aA", instance.getOnChangeList().get(0));
    }

    /**
     * Test of opb_in_load method, of class OpbField.
     */
    public void testOpb_in_load() {
        System.out.println("opb_in_load");
        
        OpbField instance = new OpbField();
        assertFalse(instance.isOptionalInLoad());
        assertTrue(instance.isLoadable());
        
        instance.opb_in_load("optional");
        assertTrue(instance.isOptionalInLoad());
        assertTrue(instance.isLoadable());
        
        instance.opb_in_load("required");
        assertFalse(instance.isOptionalInLoad());
        assertTrue(instance.isLoadable());
        
        instance.opb_in_load("ignored");
        assertFalse(instance.isOptionalInLoad());
        assertFalse(instance.isLoadable());
        
        instance.opb_in_load("x");
        
    }

    /**
     * Test of opb_read_only method, of class OpbField.
     */
    public void testOpb_read_only() {
        System.out.println("opb_read_only");
        String s = "y";
        OpbField instance = new OpbField();
        assertFalse(instance.isReadOnly());
        instance.opb_read_only(s);
        assertTrue(instance.isReadOnly());
    }

    /**
     * Test of opb_applyElementComplete method, of class OpbField.
     */
    public void testOpb_applyElementComplete() {
        System.out.println("opb_applyElementComplete");
        OpbField instance = new OpbField();
        instance.opb_applyElementComplete();
        
        instance.opb_initial_value("x");
        assertEquals("null", instance.getInitialValue());
        instance.opb_applyElementComplete();
        assertEquals("\"x\"", instance.getInitialValue());
        
        instance.opb_datatype("varchar[]");
        assertTrue(instance.isLoadable());
        instance.opb_applyElementComplete();
        assertFalse(instance.isLoadable());
        assertEquals("x", instance.getInitialValue());
        
        instance.opb_datatype("number");
        instance.opb_applyElementComplete();
        assertEquals("java.math.BigDecimal.valueOf(x)", instance.getInitialValue());
        
        instance = new OpbField();
        instance.opb_id("y");
        instance.opb_datatype("varchar[]");
        instance.opb_applyElementComplete();
        
    }

    /**
     * Test of getSqlName method, of class OpbField.
     */
    public void testGetSqlName() {
        System.out.println("getSqlName");
        OpbField instance = new OpbField();
        String expResult = null;
        String result = instance.getSqlName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class OpbField.
     */
    public void testGetName() {
        System.out.println("getName");
        OpbField instance = new OpbField();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNameWithFirstCharUpper method, of class OpbField.
     */
    public void testGetNameWithFirstCharUpper() {
        System.out.println("getNameWithFirstCharUpper");
        OpbField instance = new OpbField();
        String expResult = null;
        String result = instance.getNameWithFirstCharUpper();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSqlDatatype method, of class OpbField.
     */
    public void testGetSqlDatatype() {
        System.out.println("getSqlDatatype");
        OpbField instance = new OpbField();
        String expResult = OpbConstants.DEFAULT_DATATYPE;
        String result = instance.getSqlDatatype();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatatype method, of class OpbField.
     */
    public void testGetDatatype() {
        System.out.println("getDatatype");
        OpbField instance = new OpbField();
        String expResult = "String";
        String result = instance.getDatatype();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSqlInitialValue method, of class OpbField.
     */
    public void testGetSqlInitialValue() {
        System.out.println("getSqlInitialValue");
        OpbField instance = new OpbField();
        String expResult = null;
        String result = instance.getSqlInitialValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitialValue method, of class OpbField.
     */
    public void testGetInitialValue() {
        System.out.println("getInitialValue");
        OpbField instance = new OpbField();
        String expResult = "null";
        String result = instance.getInitialValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of isId method, of class OpbField.
     */
    public void testIsId() {
        System.out.println("isId");
        OpbField instance = new OpbField();
        boolean expResult = false;
        boolean result = instance.isId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOnChangeList method, of class OpbField.
     */
    public void testGetOnChangeList() {
        System.out.println("getOnChangeList");
        OpbField instance = new OpbField();
        List<String> expResult = new ArrayList<String>();
        List<String> result = instance.getOnChangeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of isOptionalInLoad method, of class OpbField.
     */
    public void testIsOptionalInLoad() {
        System.out.println("isOptionalInLoad");
        OpbField instance = new OpbField();
        boolean expResult = false;
        boolean result = instance.isOptionalInLoad();
        assertEquals(expResult, result);
    }

    /**
     * Test of isReadOnly method, of class OpbField.
     */
    public void testIsReadOnly() {
        System.out.println("isReadOnly");
        OpbField instance = new OpbField();
        
        assertFalse(instance.isReadOnly());
        instance.opb_id("y");
        assertTrue(instance.isReadOnly());
        instance.opb_read_only("n");
        assertFalse(instance.isReadOnly());
        
    }

    /**
     * Test of isLoadable method, of class OpbField.
     */
    public void testIsLoadable() {
        System.out.println("isLoadable");
        OpbField instance = new OpbField();
        boolean expResult = true;
        boolean result = instance.isLoadable();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHasDatasourceValue method, of class OpbField.
     */
    public void testGetHasDatasourceValue() {
        System.out.println("getHasDatasourceValue");
        OpbField instance = new OpbField();
        
        assertTrue(instance.getHasDatasourceValue());
        instance.opb_id("y");
        assertFalse(instance.getHasDatasourceValue());
        instance.opb_id("n");
        assertTrue(instance.getHasDatasourceValue());
        instance.opb_datatype("cursor");
        instance.opb_applyElementComplete();
        assertFalse(instance.getHasDatasourceValue());
        instance.opb_id("y");
        assertFalse(instance.getHasDatasourceValue());
        
        
    }

    /**
     * Test of validate method, of class OpbField.
     */
    public void testValidate() {
        System.out.println("validate");
        OpbField instance = new OpbField();
        assertTrue(instance.validate());
        instance.opb_datatype("unknown_datatype");
        assertFalse(instance.validate());
    }

}
