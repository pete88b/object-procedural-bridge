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

import java.util.ArrayList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class PlsqlPackageTest extends TestCase {
    
    public PlsqlPackageTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlPackageTest.class);
        return suite;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getOpbLibraryTitle method, of class PlsqlPackage.
     */
    public void testGetOpbLibraryTitle() {
        System.out.println("getOpbLibraryTitle");
        PlsqlPackage instance = new PlsqlPackage();
        // just make sure it runs
        instance.getOpbLibraryTitle();
    }

    /**
     * Test of getOpbLibraryVersion method, of class PlsqlPackage.
     */
    public void testGetOpbLibraryVersion() {
        System.out.println("getOpbLibraryVersion");
        PlsqlPackage instance = new PlsqlPackage();
        // just make sure it runs
        instance.getOpbLibraryVersion();
    }

    /**
     * Test of getOpbPlsqlTitle method, of class PlsqlPackage.
     */
    public void testGetOpbPlsqlTitle() {
        System.out.println("getOpbPlsqlTitle");
        PlsqlPackage instance = new PlsqlPackage();
        // just make sure it runs
        instance.getOpbPlsqlTitle();
    }

    /**
     * Test of getOpbPlsqlVersion method, of class PlsqlPackage.
     */
    public void testGetOpbPlsqlVersion() {
        System.out.println("getOpbPlsqlVersion");
        PlsqlPackage instance = new PlsqlPackage();
        // just make sure it runs
        instance.getOpbPlsqlVersion();
    }

    /**
     * Test of getFields method, of class PlsqlPackage.
     */
    public void testGetFields() {
        System.out.println("getFields");
        PlsqlPackage instance = new PlsqlPackage();
        List<OpbField> expResult = new ArrayList<OpbField>();
        List<OpbField> result = instance.getFields();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConstants method, of class PlsqlPackage.
     */
    public void testGetConstants() {
        System.out.println("getConstants");
        PlsqlPackage instance = new PlsqlPackage();
        List<PlsqlPackageConstant> expResult = new ArrayList<PlsqlPackageConstant>();
        List<PlsqlPackageConstant> result = instance.getConstants();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSqlName method, of class PlsqlPackage.
     */
    public void testGetSqlName() {
        System.out.println("getSqlName");
        PlsqlPackage instance = new PlsqlPackage();
        String expResult = null;
        String result = instance.getSqlName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSqlName method, of class PlsqlPackage.
     */
    public void testSetSqlName() {
        System.out.println("setSqlName");
        String sqlName = "a_a";
        PlsqlPackage instance = new PlsqlPackage();
        instance.setSqlName(sqlName);
        assertEquals("a_a", instance.getSqlName());
        assertEquals("AA", instance.getJavaInterfaceName());
        assertEquals("AAImpl", instance.getJavaClassName());
    }

    /**
     * Test of getJavaPackageName method, of class PlsqlPackage.
     */
    public void testGetJavaPackageName() {
        System.out.println("getJavaPackageName");
        PlsqlPackage instance = new PlsqlPackage();
        String expResult = null;
        String result = instance.getJavaPackageName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJavaPackageName method, of class PlsqlPackage.
     */
    public void testSetJavaPackageName() {
        System.out.println("setJavaPackageName");
        String javaPackageName = "com.butterfill";
        PlsqlPackage instance = new PlsqlPackage();
        instance.setJavaPackageName(javaPackageName);
        assertEquals(javaPackageName, instance.getJavaPackageName());
    }

    /**
     * Test of validate method, of class PlsqlPackage.
     */
    public void testValidate() {
        System.out.println("validate");
        PlsqlPackage instance = new PlsqlPackage();
        instance.validate();
    }

    /**
     * Test of getIdFieldNames method, of class PlsqlPackage.
     */
    public void testGetIdFieldNames() {
        System.out.println("getIdFieldNames");
        PlsqlPackage instance = new PlsqlPackage();
        List<String> expResult = new ArrayList<String>();
        assertEquals(expResult, instance.getIdFieldNames());
        
        OpbField f = new OpbField();
        f.opb_name("a");
        instance.getFields().add(f);
        
        assertEquals(expResult, instance.getIdFieldNames());
        
        f.opb_id("n");
        assertEquals(expResult, instance.getIdFieldNames());
        
        f.opb_id("Y");
        expResult.add("a");
        assertEquals(expResult, instance.getIdFieldNames());
        
    }

    /**
     * Test of getDefaultValueWrapper method, of class PlsqlPackage.
     */
    public void testGetDefaultValueWrapper() {
        System.out.println("getDefaultValueWrapper");
        PlsqlPackage instance = new PlsqlPackage();
        String expResult = "OpbValueWrapper";
        String result = instance.getDefaultValueWrapper();
        assertEquals(expResult, result);
    }

    /**
     * Test of isIdentifiable method, of class PlsqlPackage.
     */
    public void testIsIdentifiable() {
        System.out.println("isIdentifiable");
        PlsqlPackage instance = new PlsqlPackage();
        assertFalse(instance.isIdentifiable());
        OpbField f = new OpbField();
        f.opb_id("y");
        instance.getFields().add(f);
        assertTrue(instance.isIdentifiable());
    }

    /**
     * Test of isLoadable method, of class PlsqlPackage.
     */
    public void testIsLoadable() {
        System.out.println("isLoadable");
        PlsqlPackage instance = new PlsqlPackage();
        assertFalse(instance.isLoadable());
        OpbField f = new OpbField();
        f.opb_datatype("date");
        instance.getFields().add(f);
        assertTrue(instance.isLoadable());
    }

    /**
     * Test of isUseScalarResultCache method, of class PlsqlPackage.
     */
    public void testIsUseScalarResultCache() {
        System.out.println("isUseScalarResultCache");
        PlsqlPackage instance = new PlsqlPackage();
        assertFalse(instance.isUseScalarResultCache());
        PlsqlCall call = new PlsqlCall();
        call.setFunction(true);
        call.setSqlReturnType("varchar2");
        instance.getFunctions().add(call);
        call.validate();
        assertFalse(instance.isUseScalarResultCache());
        call.getReturn().opb_use_scalar_result_cache("y");
        assertTrue(instance.isUseScalarResultCache());
        
    }

    /**
     * Test of getJavaClassName method, of class PlsqlPackage.
     */
    public void testGetJavaClassName() {
        System.out.println("getJavaClassName");
        PlsqlPackage instance = new PlsqlPackage();
        assertNull(instance.getJavaClassName());
        instance.setSqlName("a");
        assertEquals("AImpl", instance.getJavaClassName());
    }

    /**
     * Test of getJavaInterfaceName method, of class PlsqlPackage.
     */
    public void testGetJavaInterfaceName() {
        System.out.println("getJavaInterfaceName");
        PlsqlPackage instance = new PlsqlPackage();
        assertNull(instance.getJavaInterfaceName());
        instance.setSqlName("a");
        assertEquals("A", instance.getJavaInterfaceName());
    }

    /**
     * Test of getFunctions method, of class PlsqlPackage.
     */
    public void testGetFunctions() {
        System.out.println("getFunctions");
        PlsqlPackage instance = new PlsqlPackage();
        List<PlsqlCall> expResult = new ArrayList<PlsqlCall>();
        List<PlsqlCall> result = instance.getFunctions();
        assertEquals(expResult, result);
        assertSame(result, instance.getFunctions());
    }

    /**
     * Test of getProcedures method, of class PlsqlPackage.
     */
    public void testGetProcedures() {
        System.out.println("getProcedures");
        PlsqlPackage instance = new PlsqlPackage();
        List<PlsqlCall> expResult = new ArrayList<PlsqlCall>();
        List<PlsqlCall> result = instance.getProcedures();
        assertEquals(expResult, result);
        assertSame(result, instance.getProcedures());
    }

    /**
     * Test of isOnlyConstants method, of class PlsqlPackage.
     */
    public void testIsOnlyConstants() {
        System.out.println("isOnlyConstants");
        PlsqlPackage instance = new PlsqlPackage();
        
        assertTrue(instance.isOnlyConstants());
                
        instance.getFields().add(new OpbField());
        assertFalse(instance.isOnlyConstants());
        instance.getFields().clear();
        assertTrue(instance.isOnlyConstants());
        
        instance.getFunctions().add(new PlsqlCall());
        assertFalse(instance.isOnlyConstants());
        instance.getFunctions().clear();
        assertTrue(instance.isOnlyConstants());
        
        instance.getProcedures().add(new PlsqlCall());
        assertFalse(instance.isOnlyConstants());
        instance.getProcedures().clear();
        assertTrue(instance.isOnlyConstants());
    }

}
