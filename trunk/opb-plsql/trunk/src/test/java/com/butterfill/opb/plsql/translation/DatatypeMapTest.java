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

import com.butterfill.opb.plsql.*;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbToStringMode;
import junit.framework.*;
import java.io.InputStream;

/**
 * Test for DatatypeMap.
 * @author Peter Butterfill
 */
public class DatatypeMapTest extends TestCase {
    
    public DatatypeMapTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        DatatypeMap.getInstance().initDatatypeMap(
                getClass().getResourceAsStream("testDatatypeMap.txt"));
    }

    @Override
    protected void tearDown() throws Exception {
        DatatypeMap.getInstance().initDatatypeMap();
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(DatatypeMapTest.class);
        
        return suite;
    }

    /**
     * Test of toString method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testToString() {
        System.out.println("toString");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
        OpbToStringMode m = OpbToStringHelper.getToStringMode();
        OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
        System.out.println(instance);
        OpbToStringHelper.setToStringMode(m);
    }

    /**
     * Test of getInstance method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        
        DatatypeMap expResult = DatatypeMap.getInstance();
        DatatypeMap result = DatatypeMap.getInstance();
        assertSame(expResult, result);
        
    }

    /**
     * Test of initDatatypeMap method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testInitDatatypeMap() {
        System.out.println("initDatatypeMap");
        
        InputStream inputStream = null;
        DatatypeMap instance = DatatypeMap.getInstance();
        
        
        try {
            instance.initDatatypeMap(inputStream);
            fail();
        } catch (NullPointerException ex) {
        }
        
        inputStream = getClass().getResourceAsStream("emptyFile");
        instance.initDatatypeMap(inputStream);
        
    }

    /**
     * Test of isCursorType method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testIsCursorType() {
        System.out.println("isCursorType");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        assertTrue(instance.isCursorType("SYS_REFCURSOR"));
        assertTrue(instance.isCursorType("CURSOR"));
        assertTrue(instance.isCursorType("sys_refcursor"));
        assertTrue(instance.isCursorType("cursor"));
        assertFalse(instance.isCursorType("varchar2"));
        assertFalse(instance.isCursorType("DATE"));
        assertFalse(instance.isCursorType("CURSORS"));
        assertFalse(instance.isCursorType(null));
        
        instance.initDatatypeMap(getClass().getResourceAsStream("emptyFile"));
        try {
            instance.isCursorType(null);
        } catch (NullPointerException ex) {
        }
        
    }

    /**
     * Test of isSqlDatatype method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testIsSqlDatatype() {
        System.out.println("isSqlDatatype");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        assertTrue(instance.isSqlDatatype("VARCHAR"));
        assertFalse(instance.isSqlDatatype("VARCHAR3"));
        assertTrue(instance.isSqlDatatype("BOOLEAN"));
        assertTrue(instance.isSqlDatatype("SYS_REFCURSOR"));
        assertTrue(instance.isSqlDatatype("CURSOR"));
        assertFalse(instance.isSqlDatatype("CURSOR?varchar2"));
        assertTrue(instance.isSqlDatatype("BINARY_DOUBLE"));
        assertFalse(instance.isSqlDatatype("DOUBLE_BINARY"));
        
    }

    /**
     * Test of sqlToJdbc method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testSqlToJdbc() {
        System.out.println("sqlToJdbc");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        assertEquals("java.sql.Types.CHAR", instance.sqlToJdbc("char"));
        assertEquals("java.sql.Types.CHAR", instance.sqlToJdbc("CHAR"));
        assertEquals(null, instance.sqlToJdbc("chair"));
        assertEquals("java.sql.Types.BIGINT", instance.sqlToJdbc("BINARY_INTEGER"));
        assertEquals("java.sql.Types.BIGINT", instance.sqlToJdbc("binary_integer"));
        assertEquals(null, instance.sqlToJdbc("integer_binary"));
        
    }

    /**
     * Test of sqlToJava method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testSqlToJava() {
        System.out.println("sqlToJava");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        assertEquals("String", instance.sqlToJava("char"));
        assertEquals("String", instance.sqlToJava("CHAR"));
        assertEquals(null, instance.sqlToJava("chair"));
        assertEquals("Long", instance.sqlToJava("BINARY_INTEGER"));
        assertEquals("Long", instance.sqlToJava("binary_integer"));
        assertEquals(null, instance.sqlToJava("integer_binary"));
        
    }

    /**
     * Test of isBooleanType method, of class com.butterfill.opb.plsql.DatatypeMap.
     */
    public void testIsBooleanType() {
        System.out.println("isBooleanType");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        assertTrue(instance.isBooleanType("BOOLEAN"));
        assertTrue(instance.isBooleanType("BOOlean"));
        assertTrue(instance.isBooleanType("boolean"));
        assertTrue(instance.isBooleanType("naeloob"));
        assertTrue(instance.isBooleanType("NAeloob"));
        assertTrue(instance.isBooleanType("NAELOOB"));
        assertFalse(instance.isBooleanType("CURSOR"));
        assertFalse(instance.isBooleanType("VARCHAR"));
        assertFalse(instance.isBooleanType("notMappedType"));
        assertFalse(instance.isBooleanType(null));
        
    }

    /**
     * Test of isPlsqlIndexTableType method, of class DatatypeMap.
     */
    public void testIsPlsqlIndexTableType() {
        System.out.println("isPlsqlIndexTableType");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        OpbToStringHelper.toStringFull(instance);
        
        // don't forget, these tests use testDatatypeMap.txt
        assertFalse(instance.isPlsqlIndexTableType("number[]"));
        assertFalse(instance.isPlsqlIndexTableType("NUMBER[]"));
        assertFalse(instance.isPlsqlIndexTableType("varchar2[]"));
        assertFalse(instance.isPlsqlIndexTableType("VARCHAR2[]"));
        
        assertFalse(instance.isPlsqlIndexTableType("varchar[]"));
        assertFalse(instance.isPlsqlIndexTableType("VARCHAR[]"));
        assertFalse(instance.isPlsqlIndexTableType("dbms_sql.varchar2_table"));
        assertFalse(instance.isPlsqlIndexTableType("dbms_sql.number_table"));
        
        assertTrue(instance.isPlsqlIndexTableType("text[]"));
        assertTrue(instance.isPlsqlIndexTableType("TEXT[]"));
        assertTrue(instance.isPlsqlIndexTableType("NUM[]"));
        assertTrue(instance.isPlsqlIndexTableType("num[]"));
        
        assertTrue(instance.isPlsqlIndexTableType("TEXT_IBT"));
        assertTrue(instance.isPlsqlIndexTableType("text_ibt"));
        assertTrue(instance.isPlsqlIndexTableType("NUM_IBT"));
        assertTrue(instance.isPlsqlIndexTableType("num_ibt"));
        
        assertFalse(instance.isPlsqlIndexTableType(null));
        
    }

    /**
     * Test of isArrayType method, of class DatatypeMap.
     */
    public void testIsArrayType() {
        System.out.println("isArrayType");
        
        DatatypeMap instance = DatatypeMap.getInstance();
        
        OpbToStringHelper.toStringFull(instance);
        
        assertFalse(instance.isArrayType(null));
        assertFalse(instance.isArrayType("string[]"));
        assertFalse(instance.isArrayType("STRING[]"));
        assertFalse(instance.isArrayType("varchar2[]"));
        assertFalse(instance.isArrayType("VARCHAR2[]"));
        
        assertTrue(instance.isArrayType("number_table"));
        assertTrue(instance.isArrayType("NUMBER_TABLE"));
        assertTrue(instance.isArrayType("varchar_table"));
        assertTrue(instance.isArrayType("VARCHAR_TABLE"));
    }
    
}
