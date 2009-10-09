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
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class PlsqlTranslationHelperTest extends TestCase {
    
    public PlsqlTranslationHelperTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlTranslationHelperTest.class);
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
     * Test of isCursorType method, of class PlsqlTranslationHelper.
     */
    public void testIsCursorType() {
        System.out.println("isCursorType");
        String sqlType = null;
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertFalse(instance.isCursorType(sqlType));
        assertFalse(instance.isCursorType("number"));
        assertFalse(instance.isCursorType("varchar2"));
        
        assertTrue(instance.isCursorType("cursor"));
        assertTrue(instance.isCursorType("Cursor"));
        assertTrue(instance.isCursorType("CURSOR"));
        assertTrue(instance.isCursorType("SYS_REFCURSOR"));
        assertTrue(instance.isCursorType("sys_refcursor"));
        
    }

    /**
     * Test of isLoadableType method, of class PlsqlTranslationHelper.
     */
    public void testIsLoadableType() {
        System.out.println("isLoadableType");
        String sqlType = null;
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertTrue(instance.isLoadableType(sqlType));
        assertTrue(instance.isLoadableType("number"));
        assertTrue(instance.isLoadableType("varchar2"));
        assertTrue(instance.isLoadableType("boolean"));
        
        assertFalse(instance.isLoadableType("varchar[]"));
        assertFalse(instance.isLoadableType("varchar2[]"));
        assertFalse(instance.isLoadableType("VARCHAR2[]"));
        assertFalse(instance.isLoadableType("cursor"));
        assertFalse(instance.isLoadableType("Cursor"));
        assertFalse(instance.isLoadableType("CURSOR"));
        assertFalse(instance.isLoadableType("SYS_REFCURSOR"));
        assertFalse(instance.isLoadableType("sys_refcursor"));
    }

    /**
     * Test of toJavaMemberName method, of class PlsqlTranslationHelper.
     */
    public void testToJavaMemberName() {
        System.out.println("toJavaMemberName");
        String sqlName = "_testOne_sql_name";
        String expResult = "TestoneSqlName";
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertEquals(expResult, instance.toJavaMemberName(sqlName));
        
        sqlName = "testOne_sql_name";
        expResult = "testoneSqlName";
        assertEquals(expResult, instance.toJavaMemberName(sqlName));
        
        sqlName = "test__sql_name";
        expResult = "testSqlName";
        assertEquals(expResult, instance.toJavaMemberName(sqlName));
        
        sqlName = "\"test__sql_name\"";
        assertEquals(expResult, instance.toJavaMemberName(sqlName));
        
        sqlName = "test__sql_name\"";
        expResult = "testSqlName\"";
        assertEquals(expResult, instance.toJavaMemberName(sqlName));
    }

    /**
     * Test of toJavaClassName method, of class PlsqlTranslationHelper.
     */
    public void testToJavaClassName() {
        System.out.println("toJavaMemberName");
        String sqlName = "_testOne_sql_name";
        String expResult = "TestoneSqlName";
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertEquals(expResult, instance.toJavaClassName(sqlName));
        
        sqlName = "testOne_sql_name";
        expResult = "TestoneSqlName";
        assertEquals(expResult, instance.toJavaClassName(sqlName));
        
        sqlName = "test___sql_name";
        expResult = "TestSqlName";
        assertEquals(expResult, instance.toJavaClassName(sqlName));
        
        sqlName = "\"test___sql_name\"";
        assertEquals(expResult, instance.toJavaClassName(sqlName));
        
        sqlName = "\"test___sql_name";
        expResult = "\"testSqlName";
        assertEquals(expResult, instance.toJavaClassName(sqlName));
        
    }

    /**
     * Test of toJavaConstantName method, of class PlsqlTranslationHelper.
     */
    public void testToJavaConstantName() {
        System.out.println("toJavaConstantName");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        String sqlName = "_testOne_sql_name";
        String expResult = "_TESTONE_SQL_NAME";
        assertEquals(expResult, instance.toJavaConstantName(sqlName));
        
        sqlName = "testOne_sql_name";
        expResult = "TESTONE_SQL_NAME";
        assertEquals(expResult, instance.toJavaConstantName(sqlName));
        
        sqlName = "test__sql_name";
        expResult = "TEST__SQL_NAME";
        assertEquals(expResult, instance.toJavaConstantName(sqlName));
        
        sqlName = "\"test__sql_name\"";
        assertEquals(expResult, instance.toJavaConstantName(sqlName));
    }

    /**
     * Test of toJavaLiteral method, of class PlsqlTranslationHelper.
     */
    public void testToJavaLiteral() {
        System.out.println("toJavaLiteral");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        String sqlLiteral = "1.2";
        String sqlDatatype = "varchar";
        String expResult = "\"1.2\"";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
        sqlLiteral = "'1.2'";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
        sqlLiteral = "\"string";
        expResult = "\"\\\"string\"";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
        sqlDatatype = "INTEGER";
        sqlLiteral = "a";
        expResult = "aL";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
        sqlDatatype = "number";
        sqlLiteral = "a";
        expResult = "java.math.BigDecimal.valueOf(a)";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
        sqlDatatype = "BOOLEAN";
        sqlLiteral = "TRUE";
        expResult = "true";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
        sqlDatatype = "raw";
        sqlLiteral = "TRUE";
        expResult = "TRUE";
        assertEquals(expResult, instance.toJavaLiteral(sqlLiteral, sqlDatatype));
        
    }

    /**
     * Test of getElementType method, of class PlsqlTranslationHelper.
     */
    public void testGetElementType() {
        System.out.println("getElementType");
        String sqlDatatype = null;
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertNull(instance.getElementType(sqlDatatype));
        assertNull(instance.getElementType("varchar"));
        assertNull(instance.getElementType("varchar?test"));
        assertNull(instance.getElementType("number"));
        
        String expResult = 
                OpbConstants.DEFAULT_ENTITY.substring(
                OpbConstants.DEFAULT_ENTITY.lastIndexOf('.') + 1);
        
        assertEquals(expResult, instance.getElementType("sys_refcursor"));
        assertEquals(expResult, instance.getElementType("cursor"));
        
        assertEquals("Test", instance.getElementType("cursor?test"));
        
    }

    /**
     * Test of getJdbcType method, of class PlsqlTranslationHelper.
     */
    public void testGetJdbcType() {
        System.out.println("getJdbcType");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        String expResult = 
                DatatypeMap.getInstance().sqlToJdbc(
                OpbConstants.DEFAULT_DATATYPE);
        String result = instance.getJdbcType(null);
        assertEquals(expResult, result);
        
        expResult = DatatypeMap.getInstance().sqlToJdbc("number");
        result = instance.getJdbcType("number");
        assertEquals(expResult, result);
    }

    /**
     * Test of toJavaDatatype method, of class PlsqlTranslationHelper.
     */
    public void testToJavaDatatype() {
        System.out.println("toJavaDatatype");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        String expResult = 
                DatatypeMap.getInstance().sqlToJava(
                OpbConstants.DEFAULT_DATATYPE);
        String result = instance.toJavaDatatype(null);
        assertEquals(expResult, result);
        
        expResult = DatatypeMap.getInstance().sqlToJava("integer");
        result = instance.toJavaDatatype("integer");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toBoolean method, of class PlsqlTranslationHelper.
     */
    public void testToBoolean() {
        System.out.println("toBoolean");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertTrue(instance.toBoolean("y", false));
        assertTrue(instance.toBoolean("Y", false));
        assertFalse(instance.toBoolean("n", true));
        assertFalse(instance.toBoolean("N", true));
        
        assertTrue(instance.toBoolean(null, true));
        assertFalse(instance.toBoolean(null, false));
        
        assertFalse(instance.toBoolean("true", false));
        assertTrue(instance.toBoolean("false", true));
        
    }

    /**
     * Test of isPlsqlIndexTableType method, of class PlsqlTranslationHelper.
     */
    public void testIsPlsqlIndexTableType() {
        System.out.println("isPlsqlIndexTableType");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertFalse(instance.isPlsqlIndexTableType(null));
        assertTrue(instance.isPlsqlIndexTableType("dbms_sql.number_table"));
    }

    /**
     * Test of isArrayType method, of class PlsqlTranslationHelper.
     */
    public void testIsArrayType() {
        System.out.println("isArrayType");
        
        PlsqlTranslationHelper instance = new PlsqlTranslationHelper();
        
        assertFalse(instance.isArrayType(null));
        assertFalse(instance.isArrayType("varchar[]"));
        assertFalse(instance.isArrayType("varchar2[]"));
        
        assertTrue(instance.isArrayType("varchar_table"));
    }

}
