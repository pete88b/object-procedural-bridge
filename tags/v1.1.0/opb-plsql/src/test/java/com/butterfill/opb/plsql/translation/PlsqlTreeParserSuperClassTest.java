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
public class PlsqlTreeParserSuperClassTest extends TestCase {
    
    public PlsqlTreeParserSuperClassTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlTreeParserSuperClassTest.class);
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
     * Test of setJavaPackageName method, of class PlsqlTreeParserSuperClass.
     */
    public void testSetJavaPackageName() {
        System.out.println("setJavaPackageName");
        String name = "x";
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.setJavaPackageName(name);
        assertEquals(name, instance.getPlsqlPackage().getJavaPackageName());
    }

    /**
     * Test of setPlsqlPackageName method, of class PlsqlTreeParserSuperClass.
     */
    public void testSetPlsqlPackageName() {
        System.out.println("setPlsqlPackageName");
        String plsqlPackageName = "aa_aa";
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.setPlsqlPackageName(plsqlPackageName);
        assertEquals(plsqlPackageName, instance.getPlsqlPackage().getSqlName());
        assertEquals("AaAa", instance.getPlsqlPackage().getJavaInterfaceName());
        assertEquals("AaAaImpl", instance.getPlsqlPackage().getJavaClassName());
    }

    /**
     * Test of clearTempData method, of class PlsqlTreeParserSuperClass.
     */
    public void testClearTempData() {
        System.out.println("clearTempData");
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.clearTempData();
    }

    /**
     * Test of setLastComment method, of class PlsqlTreeParserSuperClass.
     */
    public void testSetMlComment() {
        System.out.println("setMlComment");
        String s = "";
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.setMlComment(s);
        
    }

    /**
     * Test of getLastCommentLines method, of class PlsqlTreeParserSuperClass.
     */
    public void testGetLastCommentLines() {
        System.out.println("getLastCommentLines");
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.setMlComment(
                "/* comment for a.b\n which does\r\nsomething \r usefull. " +
                "this bit\r should\n not be seen\r\n.");
        List<String> expResult = new ArrayList<String>();
        expResult.add("comment for a.b");
        expResult.add("which does");
        expResult.add("something");
        expResult.add("usefull.");
        
        instance.addConstant("a", "number", "1");
        
        List<String> result = 
                instance.getPlsqlPackage().getConstants().get(0).getCommentLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of initFunction method, of class PlsqlTreeParserSuperClass.
     */
    public void testInitFunction() {
        System.out.println("initFunction");
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.initFunction();
    }

    /**
     * Test of setFunctionInfo method, of class PlsqlTreeParserSuperClass.
     */
    public void testSetFunctionInfo() {
        System.out.println("setFunctionInfo");
        String sqlName = "a";
        String sqlDatatypeA = null;
        String sqlDatatypeB = "date";
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.initFunction();
        instance.setFunctionInfo(sqlName, sqlDatatypeA, sqlDatatypeB);
        assertEquals("a", instance.getPlsqlPackage().getFunctions().get(0).getSqlName());
    }

    /**
     * Test of initProcedure method, of class PlsqlTreeParserSuperClass.
     */
    public void testInitProcedure() {
        System.out.println("initProcedure");
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.initProcedure();
    }

    /**
     * Test of setProcedureInfo method, of class PlsqlTreeParserSuperClass.
     */
    public void testSetProcedureInfo() {
        System.out.println("setProcedureInfo");
        String sqlName = "a";
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.initProcedure();
        instance.setProcedureInfo(sqlName);
        assertEquals("a", instance.getPlsqlPackage().getProcedures().get(0).getSqlName());
    }

    /**
     * Test of addParam method, of class PlsqlTreeParserSuperClass.
     */
    public void testAddParam() {
        System.out.println("addParam");
        String sqlName = "p_a";
        String sqlDatatypeA = "dbms_sql";
        String sqlDatatypeB = "varchar2_table";
        Object in = null;
        Object out = new Object();
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        instance.initProcedure();
        instance.addParam(sqlName, sqlDatatypeA, sqlDatatypeB, in, out);
        instance.setProcedureInfo("a");
        assertEquals("p_a", instance.getPlsqlPackage().getProcedures().get(0).getParams().get(0).getSqlName());
    }

    /**
     * Test of getPlsqlPackage method, of class PlsqlTreeParserSuperClass.
     */
    public void testGetPlsqlPackage() {
        System.out.println("getPlsqlPackage");
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        PlsqlPackage expResult = instance.getPlsqlPackage();
        PlsqlPackage result = instance.getPlsqlPackage();
        assertSame(expResult, result);
        assertNotNull(result);
    }

    /**
     * Test of addConstant method, of class PlsqlTreeParserSuperClass.
     */
    public void testAddConstant() {
        System.out.println("addConstant");
        String sqlName = "a_a";
        String sqlDatatype = "integer";
        String sqlValue = "3";
        PlsqlTreeParserSuperClass instance = new PlsqlTreeParserSuperClass(null);
        assertEquals(0, instance.getPlsqlPackage().getConstants().size());
        instance.addConstant(sqlName, sqlDatatype, sqlValue);
        assertEquals(1, instance.getPlsqlPackage().getConstants().size());
        PlsqlPackageConstant c = instance.getPlsqlPackage().getConstants().get(0);
        assertEquals(sqlName, c.getSqlName());
        assertEquals(sqlDatatype, c.getSqlDatatype());
        assertEquals(sqlValue, c.getSqlValue());
        assertEquals("Long", c.getDatatype());
        assertEquals("A_A", c.getName());
        assertEquals(sqlValue + "L", c.getValue());
    }

}
