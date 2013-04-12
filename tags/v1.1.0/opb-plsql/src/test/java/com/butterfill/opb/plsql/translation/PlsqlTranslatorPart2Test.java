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

// Note: the unused imports help IDE to compile required classes

import com.butterfill.opb.OpbId;
import com.butterfill.opb.OpbIdentifiable;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.data.OpbDynamicDataView;
import com.butterfill.opb.plsql.translation.gen.ArraysIn;
import com.butterfill.opb.plsql.translation.gen.ArraysInImpl;
import com.butterfill.opb.plsql.translation.gen.BigDecimalsImpl;
import com.butterfill.opb.plsql.translation.gen.Calls10g;
import com.butterfill.opb.plsql.translation.gen.Calls10gImpl;
import com.butterfill.opb.plsql.translation.gen.Calls8i;
import com.butterfill.opb.plsql.translation.gen.Calls8iImpl;
import com.butterfill.opb.plsql.translation.gen.Cat;
import com.butterfill.opb.plsql.translation.gen.CatImpl;
import com.butterfill.opb.plsql.translation.gen.Cats;
import com.butterfill.opb.plsql.translation.gen.CatsImpl;
import com.butterfill.opb.plsql.translation.gen.Constants;
import com.butterfill.opb.plsql.translation.gen.Dates;
import com.butterfill.opb.plsql.translation.gen.EmbeddedComments;
import com.butterfill.opb.plsql.translation.gen.EmbeddedCommentsImpl;
import com.butterfill.opb.plsql.translation.gen.Fields;
import com.butterfill.opb.plsql.translation.gen.FieldsImpl;
import com.butterfill.opb.plsql.translation.gen.FieldsId;
import com.butterfill.opb.plsql.translation.gen.FieldsIdImpl;
import com.butterfill.opb.plsql.translation.gen.FieldsInLoadImpl;
import com.butterfill.opb.plsql.translation.gen.IndexTable;
import com.butterfill.opb.plsql.translation.gen.IndexTableImpl;
import com.butterfill.opb.plsql.translation.gen.LongStrings;
import com.butterfill.opb.plsql.translation.gen.LongStringsImpl;
import com.butterfill.opb.plsql.translation.gen.OneOfEachSqlType;
import com.butterfill.opb.plsql.translation.gen.OneOfEachSqlTypeImpl;
import com.butterfill.opb.plsql.translation.gen.ParamCache;
import com.butterfill.opb.plsql.translation.gen.ParamCacheImpl;
import com.butterfill.opb.plsql.translation.gen.ParamCache2;
import com.butterfill.opb.plsql.translation.gen.ParamCache2Impl;
import com.butterfill.opb.plsql.translation.gen.ParamCache3;
import com.butterfill.opb.plsql.translation.gen.ParamCache3Impl;
import com.butterfill.opb.plsql.translation.gen.ParamDatatype;
import com.butterfill.opb.plsql.translation.gen.ParamDatatypeImpl;
import com.butterfill.opb.plsql.translation.gen.UserDefinedCollections;
import com.butterfill.opb.plsql.translation.gen.UserDefinedCollectionsImpl;
import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbValueWrapper;
import com.butterfill.opb.util.OpbValueWrapperImpl;
import helpers.TestHelper;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import oracle.sql.TIMESTAMP;

// Note: the unused imports help IDE to compile required classes

/**
 * Before running these tests;
 * <ul>
 * <li>
 *   Run PlsqlTranslatorTest and compile code in 
 *   com.butterfill.opb.plsql.translation.gen.
 * </li>
 * <li>
 *   Run all .sql files in this package to create database objects. 
 *   (See helpers.TestHelper for connection details).
 * </li>
 * </ul>
 * 
 * @author Peter Butterfill
 */
public class PlsqlTranslatorPart2Test extends TestCase {
    
    public PlsqlTranslatorPart2Test(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlTranslatorPart2Test.class);
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

    public void testDates() {
        Dates instance = TestHelper.getSharedOpbSession().
                getDataObjectSource().
                newInstance(Dates.class);

        // allow up to 1 second inaccuracy
        long before = System.currentTimeMillis() - 999;

        java.util.Date result = instance.today();

        long after = System.currentTimeMillis() + 999;

        // if result is between before and after (within 1 second) we got a date with a time component
        if (result.getTime() < before) {
            fail("expected " + result + " (" + result.getTime() + ") to be after " + before);
        }

        if (result.getTime() > after) {
            fail("expected " + result + " (" + result.getTime() + ") to be before " + after);
        }

        // the addOneDay method makes sure we can pass dates in
        Calendar calendar = new GregorianCalendar(2000, 1, 15);

        java.util.Date pDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        java.util.Date expResult = calendar.getTime();

        assertEquals(expResult, instance.addOneDay(pDate));

        // null plus one day is still null
        assertNull(instance.addOneDay());

        instance.setBDate(pDate);
        assertEquals(expResult, instance.addOneDay());

        assertNull(instance.getADate());
        instance.dateInOut();
        assertNull(instance.getADate());

        OpbValueWrapper<java.util.Date> wrapper =
                new OpbValueWrapperImpl<java.util.Date>(pDate);
        instance.dateInOut(wrapper);
        assertEquals(expResult, wrapper.getValue());

        instance.setADate(pDate);
        instance.dateInOut();
        assertEquals(expResult, instance.getADate());

    }

    public void testBigDecimals() {
        BigDecimalsImpl instance = new BigDecimalsImpl();
        assertNull(instance.getANumberNoInitial());
        assertNull(instance.getANumberNoInitialDataSourceValue());
        
        assertEquals(BigDecimal.valueOf(323), 
                instance.getANumberWithInitial());
        assertEquals(BigDecimal.valueOf(323), 
                instance.getANumberWithInitialDataSourceValue());
        
        assertEquals(BigDecimal.valueOf(3239898), 
                instance.getANumberWithInitial2());
        assertEquals(BigDecimal.valueOf(3239898), 
                instance.getANumberWithInitial2DataSourceValue());
        
        assertEquals(BigDecimal.valueOf(32.3457234), 
                instance.getANumberWithInitial3());
        assertEquals(BigDecimal.valueOf(32.3457234), 
                instance.getANumberWithInitial3DataSourceValue());
    }
    
    public void testLongStrings10g() throws Exception {
        LongStrings instance = TestHelper.getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(LongStrings.class);
        
        //32513 throws a numeric or value error on 10g
        int expectedLengthInt = 32512;
        Long expectedLengthLong = Long.parseLong(""+expectedLengthInt);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expectedLengthInt; i++) {
            sb.append("a");
        }
        String s = sb.toString();
        assertEquals(expectedLengthInt, s.length());
        assertEquals(expectedLengthLong, instance.howLong(s));
        OpbValueWrapper<String> wrapper = new OpbValueWrapperImpl<String>();
        wrapper.setValue(s);
        instance.inOut(wrapper);
        
        assertEquals(32512,  wrapper.getValue().length());
        String s2 = instance.getLong(expectedLengthLong);
        assertEquals(32512, s2.length());
        
        assertEquals(32512, instance.getLong(32512L).length());
    }
    
    public void testCalls10g() throws Exception {
        Calls10g instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls10g.class);
        
        assertEquals("a", instance.echo("a"));
        String s = OpbToStringHelper.toStringFull(instance);
        // Oracle drivers won't return more that 4000 characters!
        if (s.length() > 4000) {
            s = s.substring(0, 4000);
        }
        String sEchoed = instance.echo(s);
        assertEquals(s.length(), sEchoed.length());
        assertEquals(s, sEchoed);
        
        OpbValueWrapper<String> result = new OpbValueWrapperImpl<String>();
        instance.echo("b", result);
        assertEquals("b", result.getValue());
        instance.echo(s, result);
        assertEquals(s, result.getValue());
        
        try {
            instance.fBlob(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fBoolean(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fChar(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fChar(""); // zero length strings convert to SQL null
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fClob(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fDate(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fDbmsSqlNumberTable(new BigDecimal[0]);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data.LAST is null") != -1);
        }
        
        try {
            instance.fDbmsSqlVarchar2Table(new String[0]);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data.LAST is null") != -1);
        }
        
        try {
            instance.fInteger(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fNumber(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fRaw(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fTimestamp(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fVarchar2(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        /*
         * You can't construct a BLOB or a CLOB locator with a Java new statement.
         * You must create the locator through a SQL operation.
         */
        Blob blob = instance.getBlob();
        assertNotNull(blob);
        blob.setBytes(1, new byte[]{1, 2, 3});
        assertEquals("ok", instance.fBlob(blob));
        
        Clob clob = instance.getClob();
        assertNotNull(clob);
        clob.setString(1, "testClobStringThatsNotVeryLarge");
        assertEquals("ok", instance.fClob(clob));
        
        assertEquals("ok", instance.fBoolean(true));
        assertEquals("ok", instance.fBoolean(false));
        assertEquals("ok", instance.fChar("a"));
        assertEquals("ok", instance.fDate(new Timestamp(System.currentTimeMillis())));
        assertEquals("ok", instance.fDbmsSqlNumberTable(new BigDecimal[]{BigDecimal.TEN}));
        assertEquals("ok", instance.fDbmsSqlVarchar2Table(new String[]{"a"}));
        assertEquals("ok", instance.fInteger(0L));
        assertEquals("ok", instance.fNumber(BigDecimal.ONE));
        assertEquals("ok", instance.fRaw(new byte[]{1, 2, 3}));
        assertEquals("ok", instance.fTimestamp(new Timestamp(System.currentTimeMillis())));
        assertEquals("ok", instance.fVarchar2("c"));
        
        assertEquals("ok", instance.fBinaryDouble(0.0));
        assertEquals("ok", instance.fBinaryFloat(0.0F));
        assertEquals("ok", instance.fBinaryInteger(9L));
        
        assertEquals("ok", instance.fDec(BigDecimal.ONE));
        assertEquals("ok", instance.fDecimal(BigDecimal.TEN));
        
        assertEquals("ok", instance.fFloat(BigDecimal.TEN));
        assertEquals("ok", instance.fInt(99L));
        assertEquals("ok", instance.fNumber(BigDecimal.valueOf(845745L)));
        assertEquals("ok", instance.fPlsInteger(77L));
        assertEquals("ok", instance.fPositive(BigDecimal.ONE));
        assertEquals("ok", instance.fSmallint(32L));
        assertEquals("ok", instance.fCharacter("lkjdfvkldjfv8y4iojdfv;ldfv"));
        assertEquals("ok", instance.fNchar("dscvsdv"));
        assertEquals("ok", instance.fNvarchar2("dvdfv"));
        assertEquals("ok", instance.fRowid("losdkied"));
        assertEquals("ok", instance.fString("kidjcwuepok"));
        assertEquals("ok", instance.fVarchar("!\"*&^_)£\"(£)(£)(£$)*@:L<><."));
        
        ResultSet rs = TestHelper.getResultSet("select rowid from dual");
        rs.next();
        String rowid = rs.getString(1);
        assertEquals("ok", instance.fUrowid(rowid));
        
        
        String pChar = "a";
        String pVarchar2 = "a";
        BigDecimal pNumber = BigDecimal.ZERO;
        Long pInteger = 0L;
        byte[] pRaw = new byte[]{0};
        Timestamp pDate = new Timestamp(System.currentTimeMillis());
        Timestamp pTimestamp = pDate;
        Blob pBlob = instance.getBlob();
        Clob pClob = instance.getClob();
        Boolean pBoolean = true;
        String[] pVarchar2Array = new String[]{"a"};
        BigDecimal[] pNumberArray = new BigDecimal[]{BigDecimal.ZERO};
        
        instance.dataTypes(
                pChar, 
                pVarchar2,  
                pNumber, 
                pInteger, 
                pRaw, 
                pDate, 
                pTimestamp, 
                pBlob, 
                pClob, 
                pBoolean, 
                pVarchar2Array, 
                pNumberArray);
        
        try {
            instance.dataTypes(
                    null, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    null,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    null, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    null, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    null, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    null, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    null, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    null, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    null, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    null, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    null, 
                    pNumberArray);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().indexOf(
                    "PL/SQL index-by tables cannot be set to null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pTimestamp, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().indexOf(
                    "PL/SQL index-by tables cannot be set to null") != -1);
        }
        
        BigDecimal bigDecimalExpected = BigDecimal.valueOf(78L);
        Double binaryDoubleExpected = 78.0;
        Float binaryFloatExpected = 78.0F;
        Long longExpected = 78L;
        // Expected date: 23dec1845 23:05:11
        Calendar calendarExpected = Calendar.getInstance();
        calendarExpected.set(1845, 11, 23, 23, 05, 11);
        calendarExpected.set(Calendar.MILLISECOND, 0);
        Timestamp timestampExpected = new Timestamp(calendarExpected.getTimeInMillis());
        
        assertEquals(binaryDoubleExpected, instance.getBinaryDouble());
        assertNull(instance.getBinaryDoubleNull());
        assertEquals(binaryFloatExpected, instance.getBinaryFloat());
        assertNull(instance.getBinaryFloatNull());
        assertEquals(longExpected, instance.getBinaryInteger());
        assertTrue(instance.getBoolean());
        assertEquals("78", instance.getChar());
        assertEquals("78", instance.getCharacter());
        assertEquals(timestampExpected, instance.getDate());
        assertEquals(bigDecimalExpected, instance.getDec());
        assertEquals(bigDecimalExpected, instance.getDecimal());
        assertEquals(bigDecimalExpected, instance.getFloat());
        assertEquals(longExpected, instance.getInt());
        assertEquals(longExpected, instance.getInteger());
        assertEquals("78", instance.getNchar());
        assertEquals(bigDecimalExpected, instance.getNumber());
        assertEquals(bigDecimalExpected, instance.getNumeric());
        assertEquals("78", instance.getNvarchar2());
        assertEquals(longExpected, instance.getPlsInteger());
        assertEquals(bigDecimalExpected, instance.getPositive());
        byte[] rawResult = instance.getRaw();
        assertEquals(2, rawResult.length);
        assertEquals(7, rawResult[0]);
        assertEquals(8, rawResult[1]);
        assertNotNull(instance.getRowid());
        assertEquals(longExpected, instance.getSmallint());
        assertEquals("78", instance.getString());
        assertEquals(timestampExpected, instance.getTimestamp());
        assertNotNull(instance.getUrowid());
        assertEquals("78", instance.getVarchar());
        assertEquals("78", instance.getVarchar2());
        
    }
    
    public void testCalls10gTestTable() throws Exception {
        Calls10g instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls10g.class);
        
        OpbDynamicDataView result = instance.getFromTestTable().get(0);
        
        Double binaryDoubleExpected = 3.14159265358979;
        Float binaryFloatExpected = 3.14159274F;
        Calendar calendarExpected = Calendar.getInstance();
        calendarExpected.set(0003, 01, 01, 0, 0, 0); // Note: zero time component
        calendarExpected.set(Calendar.MILLISECOND, 0);
        Date dateExpected = new Date(calendarExpected.getTimeInMillis());
        calendarExpected.set(0003, 01, 01, 04, 05, 06);
        TIMESTAMP timestampExpected = 
                new TIMESTAMP(new Timestamp(calendarExpected.getTimeInMillis()));
        BigDecimal numberExpected = BigDecimal.valueOf(3.14159265358979);
        
        assertEquals(binaryDoubleExpected, result.get("aBinaryDouble"));
        assertEquals(binaryFloatExpected, result.get("aBinaryFloat"));
        assertEquals("Pi        ", result.get("aChar"));
        assertEquals(dateExpected, result.get("aDate"));
        assertEquals(
                timestampExpected.dateValue(), 
                ((TIMESTAMP)result.get("aTimestamp")).dateValue());
        assertEquals(
                "3-2-1 4.5.6.7000", 
                ((TIMESTAMP)result.get("aTimestamp")).stringValue());
        assertEquals(numberExpected, result.get("aNumber"));
        assertEquals("Pi", result.get("aNvarchar2"));
        assertEquals(3, ((byte[])result.get("aRaw"))[0]);
        assertEquals("Pi", result.get("aVarchar2"));
        assertNotNull(result.get("aBlob"));
        assertNotNull(result.get("aClob"));
        assertNotNull(result.get("aNclob"));
    }
    
    public void testCalls10gOneOfEachDatatype() throws Exception {
        Calls10g instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls10g.class);
        
        OneOfEachSqlType result = instance.getOneOfEachSqlType().get(0);
        
        Double binaryDoubleExpected = 3.14159265358979;
        Float binaryFloatExpected = 3.14159274F;
        Calendar calendarExpected = Calendar.getInstance();
        calendarExpected.set(0003, 01, 01, 04, 05, 06);
        calendarExpected.set(Calendar.MILLISECOND, 0);
        java.util.Date dateExpected =
                new java.util.Date(calendarExpected.getTimeInMillis());
        
        BigDecimal numberExpected = BigDecimal.valueOf(3.14159265358979);
        
        assertEquals(binaryDoubleExpected, result.getABinaryDouble());
        assertEquals(binaryFloatExpected, result.getABinaryFloat());
        assertNotNull(result.getABlob());
        assertNotNull(result.getAClob());
        assertNotNull(result.getANclob());
        assertEquals("Pi        ", result.getAChar());
        assertEquals(dateExpected, result.getADate());
        assertEquals(numberExpected, result.getANumber());
        assertEquals("Pi", result.getANvarchar2());
        assertEquals(3, result.getARaw()[0]);
        assertEquals("Pi", result.getAVarchar2());

        Timestamp timestampExpected =
                new Timestamp(calendarExpected.getTimeInMillis());
        timestampExpected.setNanos(7000);
        assertEquals(timestampExpected, result.getATimestamp());
        
    }
    
    public void testIndexTableWithLongStrings() {
        IndexTable instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(IndexTable.class);
        
        //32513 throws a unimplemented or unreasonable conversion requested on 10g
        int expectedLengthInt = 32512;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expectedLengthInt; i++) {
            sb.append("a");
        }
        String s = sb.toString();
        
        String[] stringArray = new String[]{"one", s, "3", s};
        
        instance.x(stringArray);
        
    }
    
    public void testLongStrings8i() throws Exception {
        System.out.println("testLongStrings8i()");
        LongStrings instance = TestHelper.getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(LongStrings.class);
        
        //4001 throws a wrong number or types of arguments in call error on 8i
        int expectedLengthInt = 4000;
        Long expectedLengthLong = Long.parseLong(""+expectedLengthInt);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expectedLengthInt; i++) {
            sb.append("a");
        }
        String s = sb.toString();
        assertEquals(expectedLengthInt, s.length());
        assertEquals(expectedLengthLong, instance.howLong(s));
        OpbValueWrapper<String> wrapper = new OpbValueWrapperImpl<String>();
        wrapper.setValue(s);
        instance.inOut(wrapper);
        assertEquals(expectedLengthInt, wrapper.getValue().length());
        String s2 = instance.getLong(expectedLengthLong);
        assertEquals(expectedLengthInt, s2.length());
        assertEquals(s, s2);
        
        assertEquals(32512, instance.getLong(32512L).length());
    }
    
    public void testCalls8i() throws Exception {
        Calls8i instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls8i.class);
        
        assertEquals("a", instance.echo("a"));
        String s = OpbToStringHelper.toStringFull(instance);
        // Oracle drivers won't return more that 4000 characters!
        if (s.length() > 4000) {
            s = s.substring(0, 4000);
        }
        String sEchoed = instance.echo(s);
        assertEquals(s.length(), sEchoed.length());
        assertEquals(s, sEchoed);
        
        OpbValueWrapper<String> result = new OpbValueWrapperImpl<String>();
        instance.echo("b", result);
        assertEquals("b", result.getValue());
        instance.echo(s, result);
        assertEquals(s, result.getValue());
        
        try {
            instance.fBlob(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fBoolean(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fChar(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fChar(""); // zero length strings convert to SQL null
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fClob(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fDate(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fDbmsSqlNumberTable(new BigDecimal[0]);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data.LAST is null") != -1);
        }
        
        try {
            instance.fDbmsSqlVarchar2Table(new String[0]);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data.LAST is null") != -1);
        }
        
        try {
            instance.fInteger(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fNumber(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fRaw(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        try {
            instance.fVarchar2(null);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf("p_data is null") != -1);
        }
        
        /*
         * You can't construct a BLOB or a CLOB locator with a Java new statement.
         * You must create the locator through a SQL operation.
         */
        Blob blob = instance.getBlob();
        assertNotNull(blob);
        blob.setBytes(1, new byte[]{1, 2, 3});
        assertEquals("ok", instance.fBlob(blob));
        
        Clob clob = instance.getClob();
        assertNotNull(clob);
        clob.setString(1, "testClobStringThatsNotVeryLarge");
        assertEquals("ok", instance.fClob(clob));
        
        assertEquals("ok", instance.fBoolean(true));
        assertEquals("ok", instance.fBoolean(false));
        assertEquals("ok", instance.fChar("a"));
        assertEquals("ok", instance.fDate(new Timestamp(System.currentTimeMillis())));
        assertEquals("ok", instance.fDbmsSqlNumberTable(new BigDecimal[]{BigDecimal.TEN}));
        assertEquals("ok", instance.fDbmsSqlVarchar2Table(new String[]{"a"}));
        assertEquals("ok", instance.fInteger(0L));
        assertEquals("ok", instance.fNumber(BigDecimal.ONE));
        assertEquals("ok", instance.fRaw(new byte[]{1, 2, 3}));
        assertEquals("ok", instance.fVarchar2("c"));
        
        assertEquals("ok", instance.fBinaryInteger(9L));
        
        assertEquals("ok", instance.fDec(BigDecimal.ONE));
        assertEquals("ok", instance.fDecimal(BigDecimal.TEN));
        
        assertEquals("ok", instance.fFloat(BigDecimal.TEN));
        assertEquals("ok", instance.fInt(99L));
        assertEquals("ok", instance.fNumber(BigDecimal.valueOf(845745L)));
        assertEquals("ok", instance.fPlsInteger(77L));
        assertEquals("ok", instance.fPositive(BigDecimal.ONE));
        assertEquals("ok", instance.fSmallint(32L));
        assertEquals("ok", instance.fCharacter("lkjdfvkldjfv8y4iojdfv;ldfv"));
        assertEquals("ok", instance.fRowid("losdkied"));
        assertEquals("ok", instance.fString("kidjcwuepok"));
        assertEquals("ok", instance.fVarchar("!\"*&^_)£\"(£)(£)(£$)*@:L<><."));
        
        ResultSet rs = TestHelper.getResultSet("select rowid from dual");
        rs.next();
        String rowid = rs.getString(1);
        assertEquals("ok", instance.fUrowid(rowid));
        
        
        String pChar = "a";
        String pVarchar2 = "a";
        BigDecimal pNumber = BigDecimal.ZERO;
        Long pInteger = 0L;
        byte[] pRaw = new byte[]{0};
        Timestamp pDate = new Timestamp(System.currentTimeMillis());
        Timestamp pTimestamp = pDate;
        Blob pBlob = instance.getBlob();
        Clob pClob = instance.getClob();
        Boolean pBoolean = true;
        String[] pVarchar2Array = new String[]{"a"};
        BigDecimal[] pNumberArray = new BigDecimal[]{BigDecimal.ZERO};
        
        instance.dataTypes(
                pChar, 
                pVarchar2,  
                pNumber, 
                pInteger, 
                pRaw, 
                pDate, 
                pBlob, 
                pClob, 
                pBoolean, 
                pVarchar2Array, 
                pNumberArray);
        
        try {
            instance.dataTypes(
                    null, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    null,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    null, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    null, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    null, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    null, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    null, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    null, 
                    pBoolean, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    null, 
                    pVarchar2Array, 
                    pNumberArray);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause() instanceof SQLException);
            assertTrue(ex.getCause().getMessage().indexOf(" is null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    null, 
                    pNumberArray);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().indexOf(
                    "PL/SQL index-by tables cannot be set to null") != -1);
        }
        
        try {
            instance.dataTypes(
                    pChar, 
                    pVarchar2,  
                    pNumber, 
                    pInteger, 
                    pRaw, 
                    pDate, 
                    pBlob, 
                    pClob, 
                    pBoolean, 
                    pVarchar2Array, 
                    null);
            fail();
        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().indexOf(
                    "PL/SQL index-by tables cannot be set to null") != -1);
        }
        
        BigDecimal bigDecimalExpected = BigDecimal.valueOf(78L);
        Double binaryDoubleExpected = 78.0;
        Float binaryFloatExpected = 78.0F;
        Long longExpected = 78L;
        // Expected date: 23dec1845 23:05:11
        Calendar calendarExpected = Calendar.getInstance();
        calendarExpected.set(1845, 11, 23, 23, 05, 11);
        calendarExpected.set(Calendar.MILLISECOND, 0);
        Timestamp timestampExpected = new Timestamp(calendarExpected.getTimeInMillis());
        
        assertEquals(longExpected, instance.getBinaryInteger());
        assertTrue(instance.getBoolean());
        assertEquals("78", instance.getChar());
        assertEquals("78", instance.getCharacter());
        assertEquals(timestampExpected, instance.getDate());
        assertEquals(bigDecimalExpected, instance.getDec());
        assertEquals(bigDecimalExpected, instance.getDecimal());
        assertEquals(bigDecimalExpected, instance.getFloat());
        assertEquals(longExpected, instance.getInt());
        assertEquals(longExpected, instance.getInteger());
        assertEquals(bigDecimalExpected, instance.getNumber());
        assertEquals(bigDecimalExpected, instance.getNumeric());
        assertEquals(longExpected, instance.getPlsInteger());
        assertEquals(bigDecimalExpected, instance.getPositive());
        byte[] rawResult = instance.getRaw();
        assertEquals(2, rawResult.length);
        assertEquals(7, rawResult[0]);
        assertEquals(8, rawResult[1]);
        assertNotNull(instance.getRowid());
        assertEquals(longExpected, instance.getSmallint());
        assertEquals("78", instance.getString());
        assertNotNull(instance.getUrowid());
        assertEquals("78", instance.getVarchar());
        assertEquals("78", instance.getVarchar2());
        
    }
    
    public void testCalls8iTestTable() throws Exception {
        Calls8i instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls8i.class);
        
        OpbDynamicDataView result = instance.getFromTestTable().get(0);
        
        Calendar calendarExpected = Calendar.getInstance();
        calendarExpected.set(0003, 01, 01, 0, 0, 0); // Note: zero time component
        calendarExpected.set(Calendar.MILLISECOND, 0);
        Date dateExpected = new Date(calendarExpected.getTimeInMillis());
        calendarExpected.set(0003, 01, 01, 04, 05, 06);
        BigDecimal numberExpected = BigDecimal.valueOf(3.14159265358979);
        
        assertEquals("Pi        ", result.get("aChar"));
        assertEquals(dateExpected, result.get("aDate"));
        assertEquals(numberExpected, result.get("aNumber"));
        assertEquals(3, ((byte[])result.get("aRaw"))[0]);
        assertEquals("Pi", result.get("aVarchar2"));
        assertNotNull(result.get("aBlob"));
        assertNotNull(result.get("aClob"));
        assertNotNull(result.get("aNclob"));
    }
    
    public void testCalls8iOneOfEachDatatype() throws Exception {
        Calls8i instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls8i.class);
        
        OneOfEachSqlType result = instance.getOneOfEachSqlType().get(0);
        
        Calendar calendarExpected = Calendar.getInstance();
        calendarExpected.set(0003, 01, 01, 04, 05, 06);
        calendarExpected.set(Calendar.MILLISECOND, 0);
        java.util.Date dateExpected =
                new java.util.Date(calendarExpected.getTimeInMillis());
        
        BigDecimal numberExpected = BigDecimal.valueOf(3.14159265358979);
        
        assertNotNull(result.getABlob());
        assertNotNull(result.getAClob());
        assertNotNull(result.getANclob());
        assertEquals("Pi        ", result.getAChar());
        assertEquals(dateExpected, result.getADate());
        assertEquals(numberExpected, result.getANumber());
        assertEquals(3, result.getARaw()[0]);
        assertEquals("Pi", result.getAVarchar2());
        
    }
    
    public void testZeroLengthString() {
        Calls8i instance = TestHelper.getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(Calls8i.class);
        
        OpbValueWrapper<String> wrapper = new OpbValueWrapperImpl<String>();
        instance.echo("", wrapper);
        assertNull(wrapper.getValue());
        
        assertNull(instance.echo(""));
        
    }
    
    public void testConstants() throws Exception {
        try {
            Constants.class.getDeclaredField("G_VARCHAR");
            fail("G_VARCHAR was translated");
        } catch (NoSuchFieldException ex) {
        }
        
        assertNull(Constants.C_VARCHAR_NULL);
        assertNull(Constants.C_VARCHAR_NULL2);
        assertEquals("c_varchar_value", Constants.C_VARCHAR);
        
        assertNull(Constants.C_NUMBER_NULL);
        assertEquals(BigDecimal.valueOf(3.2), Constants.C_NUMBER);
        
        assertNull(Constants.C_INTEGER_NULL);
        assertEquals(Long.valueOf("7"), Constants.C_INTEGER);
        
        Class.forName("com.butterfill.opb.plsql.translation.gen.Constants");
        try {
            Class.forName("com.butterfill.opb.plsql.translation.gen.ConstantsImpl");
            fail();
        } catch (ClassNotFoundException ex) {
        }
        
    }
    
    public void testEmbeddedComments() throws Exception {
        Class[] cs = new Class[] {EmbeddedComments.class, EmbeddedCommentsImpl.class};
        
        for (int i = 0; i < cs.length; i++) {
            _methodExists(cs[i], "getInclude");
            _methodExists(cs[i], "setInclude", String.class);
            _methodExists(cs[i], "getIncludeDataSourceValue");
            _methodExists(cs[i], "getIncludeChanged");

            _methodDoesNotExist(cs[i], "getExclude");
            _methodDoesNotExist(cs[i], "setExclude", String.class);
            _methodDoesNotExist(cs[i], "getExcludeDataSourceValue");
            _methodDoesNotExist(cs[i], "getExcludeChanged");
            
            _methodExists(cs[i], "a", BigDecimal.class);
            _methodDoesNotExist(cs[i], "a2", BigDecimal.class);
        }
        
    }
    
    public void testFields() throws Exception {
        Class[] cs = new Class[] {Fields.class, FieldsImpl.class};
        
        for (int i = 0; i < cs.length; i++) {
            _methodExists(cs[i], "getA");
            _methodExists(cs[i], "setA", String.class);
            _methodExists(cs[i], "getADataSourceValue");
            _methodExists(cs[i], "getAChanged");
            
            _methodExists(cs[i], "getAVarchar");
            _methodExists(cs[i], "setAVarchar", String.class);
            _methodExists(cs[i], "getAVarcharDataSourceValue");
            _methodExists(cs[i], "getAVarcharChanged");
            
            _methodExists(cs[i], "getANumber");
            _methodExists(cs[i], "setANumber", BigDecimal.class);
            _methodExists(cs[i], "getANumberDataSourceValue");
            _methodExists(cs[i], "getANumberChanged");
            
            _methodExists(cs[i], "getAInteger");
            _methodExists(cs[i], "setAInteger", Long.class);
            _methodExists(cs[i], "getAIntegerDataSourceValue");
            _methodExists(cs[i], "getAIntegerChanged");

            _methodExists(cs[i], "getADate");
            _methodExists(cs[i], "setADate", java.util.Date.class);
            _methodExists(cs[i], "getADateDataSourceValue");
            _methodExists(cs[i], "getADateChanged");
            
            _methodExists(cs[i], "getARo");
            _methodDoesNotExist(cs[i], "setARo", String.class);
            _methodDoesNotExist(cs[i], "getARoDataSourceValue", String.class);
            _methodDoesNotExist(cs[i], "getARoChanged", String.class);
            
            _methodExists(cs[i], "getARo");
            _methodDoesNotExist(cs[i], "setARo", String.class);
            _methodDoesNotExist(cs[i], "getARoDataSourceValue", String.class);
            _methodDoesNotExist(cs[i], "getARoChanged", String.class);
            
        }

        FieldsImpl f = new FieldsImpl();
        assertEquals(Long.valueOf("8"), f.getAInteger());
        
        assertFalse(f instanceof OpbIdentifiable);
        
        FieldsImpl2 f2 = new FieldsImpl2();
        assertFalse(f2.aChangedCalled);
        f2.setA(null);
        assertFalse(f2.aChangedCalled);
        f2.setA("newValue");
        assertTrue(f2.aChangedCalled);
        
    }
    
    public void testFieldsId() throws Exception {
        Class[] cs = new Class[] {FieldsId.class, FieldsIdImpl.class};
        
        for (int i = 0; i < cs.length; i++) {
            _methodExists(cs[i], "getPk");
            _methodDoesNotExist(cs[i], "setPk", String.class);
            _methodDoesNotExist(cs[i], "getPkDataSourceValue");
            _methodDoesNotExist(cs[i], "getPkChanged");
            
            _methodExists(cs[i], "getPk2");
            _methodExists(cs[i], "setPk2", String.class);
            _methodExists(cs[i], "getPk2DataSourceValue");
            _methodExists(cs[i], "getPk2Changed");
            
            _methodExists(cs[i], "getA");
            _methodDoesNotExist(cs[i], "setA", String.class);
            _methodDoesNotExist(cs[i], "getADataSourceValue");
            _methodDoesNotExist(cs[i], "getAChanged");
            
        }

        FieldsIdImpl f = new FieldsIdImpl();
        
        assertTrue(f instanceof OpbIdentifiable);
        
        ResultSet rs = TestHelper.getResultSet(
                "select 'a' as pk, 'b' as pk2, null as a from dual");
        
        rs.next();
        
        assertNull(f.getOpbId());
        f.opbLoad(rs);
        
        assertEquals(new OpbId("a", "b"), f.getOpbId());
        
    }
    
    public void testFieldsInLoad() throws Exception {
        FieldsInLoadImpl f = new FieldsInLoadImpl();
        
        assertNull(f.getFDefault());
        assertNull(f.getFIgnored());
        assertNull(f.getFOptional());
        
        ResultSet rs = TestHelper.getResultSet(
                "select " +
                "  'default' as f_default, " +
                "  'ignored' as f_ignored, " +
                "  'optional' as f_optional " +
                "from " +
                "  dual");
        rs.next();
        f.opbLoad(rs);
        
        assertEquals("default", f.getFDefault());
        assertNull(f.getFIgnored());
        assertEquals("optional", f.getFOptional());
        
        
        rs = TestHelper.getResultSet(
                "select " +
                "  'default' as f_default, " +
                "  'ignored' as f_ignored " +
                "from " +
                "  dual");
        rs.next();
        f.opbLoad(rs);
        
        assertEquals("default", f.getFDefault());
        assertNull(f.getFIgnored());
        assertNull(f.getFOptional());
        
        
        rs = TestHelper.getResultSet(
                "select " +
                "  'ignored' as f_ignored " +
                "from " +
                "  dual");
        rs.next();
        
        try {
            f.opbLoad(rs);
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause().getMessage().indexOf("Failed to get 'f_default'") != -1);
        }
        
        
    }
    
    public void testIndexTable() throws Exception {
        Class[] cs = new Class[] {IndexTable.class, IndexTableImpl.class};
        
        String[] stringArray = new String[]{"one", "two", "3"};
        
        BigDecimal[] bigDecimalArray = new BigDecimal[]{
            new BigDecimal(1), new BigDecimal(2.2)
        };
        
        Long[] longArray = new Long[5];
        longArray[1] = 5L;
        longArray[3] = 9L;
        
        
        for (int i = 0; i < cs.length; i++) {
            _methodExists(cs[i], "a", stringArray.getClass());
            _methodDoesNotExist(cs[i], "b", OpbValueWrapper.class);
            _methodDoesNotExist(cs[i], "c", OpbValueWrapper.class);
            _methodDoesNotExist(cs[i], "f");
            _methodDoesNotExist(cs[i], "y");
            _methodExists(cs[i], "getNumberArray");
            _methodExists(cs[i], "setNumberArray", bigDecimalArray.getClass());
            _methodExists(cs[i], "getVarcharArray");
            _methodExists(cs[i], "setVarcharArray", stringArray.getClass());
        }
        
        IndexTable instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(IndexTable.class);
        
        instance.a(stringArray);
        
        try {
            instance.a(null);
            fail();
        } catch (NullPointerException ex) {
        }
        
        
        instance.a2(bigDecimalArray);
        
        try {
            instance.a2(null);
            fail();
        } catch (NullPointerException ex) {
        }
        
        
        instance.a3(longArray);
        
        try {
            instance.a3(null);
            fail();
        } catch (NullPointerException ex) {
        }
        
        
        instance.x(stringArray);
        instance.x2(bigDecimalArray);
        instance.x3(longArray);
        
        instance.y2(stringArray);
        instance.z(stringArray, longArray, new String[]{"testArrayWithOneElement"});
        
    }
    
    public void testParamDatatype() throws Exception {
        Class[] cs = new Class[] {ParamDatatype.class, ParamDatatypeImpl.class};
        
        for (int i = 0; i < cs.length; i++) {
            _methodExists(cs[i], "invalid1");
            _methodExists(cs[i], "invalid2", BigDecimal.class);
            _methodExists(cs[i], "a", Long.class, Long.class);
            _methodExists(cs[i], "dodgy", OpbValueWrapper.class, OpbValueWrapper.class);
        }
        
        ParamDatatype instance = new ParamDatatypeImpl();
        if (false) {
            // don't try to call dodgy but this would create compiler warnings
            // if the wrapper types were wrong
            OpbValueWrapper<Long> wrapper = new OpbValueWrapperImpl<Long>();
            instance.dodgy(wrapper, wrapper);
        }
        
    }
    
    public void testParamCache() throws Exception {
        ParamCache instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .getInstance(ParamCache.class, "");
        
        OpbValueWrapper<List<OpbDynamicDataView>> wrapper = 
                new OpbValueWrapperImpl<List<OpbDynamicDataView>>();
        OpbValueWrapper<List<OpbDynamicDataView>> wrapper2 = 
                new OpbValueWrapperImpl<List<OpbDynamicDataView>>();
        
        instance.useResultCacheA(wrapper);
        instance.useResultCacheA(wrapper2);
        assertNotSame(wrapper, wrapper2);
        // this is testing default behaviour of use_data_object_cache
        assertNotSame(wrapper.getValue().get(0), wrapper2.getValue().get(0));
        
        List<OpbDynamicDataView> list = instance.useResultCacheB();
        List<OpbDynamicDataView> list2 = instance.useResultCacheB();
        assertSame(list, list2);
        // if the lists are the same, their contents must be the same
        assertSame(list.get(0), list2.get(0));
        // prove that these data objects are not cached
        // this is testing default behaviour of use_data_object_cache
        TestHelper.getSharedOpbSession()
                .getDataObjectSource()
                .clearCachedResults();
        list2 = instance.useResultCacheB();
        assertNotSame(list, list2);
        assertNotSame(list.get(0), list2.get(0));
        
        assertSame(instance.useResultCacheB2(), instance.useResultCacheB2());
        assertNotSame(instance.useResultCacheB3(), instance.useResultCacheB3());
        
        
        
        OpbValueWrapper<Long> longWrapper = new OpbValueWrapperImpl<Long>();
        OpbValueWrapper<Long> longWrapper2 = new OpbValueWrapperImpl<Long>();
        instance.useScalarResultCacheA(longWrapper);
        instance.useScalarResultCacheA(longWrapper2);
        assertNotSame(longWrapper, longWrapper2);
        
        assertNotSame(instance.useScalarResultCacheB(), instance.useScalarResultCacheB());
        assertSame(instance.useScalarResultCacheB2(), instance.useScalarResultCacheB2());
        assertNotSame(instance.useScalarResultCacheB3(), instance.useScalarResultCacheB3());
        
        
        
        OpbValueWrapper<List<FieldsId>> useDataObjectCacheResult =
                new OpbValueWrapperImpl<List<FieldsId>>();
        instance.useDataObjectCacheA(useDataObjectCacheResult);
        
        assertNotNull(useDataObjectCacheResult.getValue().get(0));
        assertSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB().get(0));
        
        assertNotNull(instance.useDataObjectCacheB2());
        assertNotSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB2().get(0));
        
        //TODO xxx clear_cahced invalidate_cached
        
    }
    
    public void testParamCache2() throws Exception {
        ParamCache2 instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .getInstance(ParamCache2.class, "");
        
        OpbValueWrapper<List<OpbDynamicDataView>> wrapper = 
                new OpbValueWrapperImpl<List<OpbDynamicDataView>>();
        OpbValueWrapper<List<OpbDynamicDataView>> wrapper2 = 
                new OpbValueWrapperImpl<List<OpbDynamicDataView>>();
        
        instance.useResultCacheA(wrapper, "key");
        instance.useResultCacheA(wrapper2, "key");
        assertNotSame(wrapper, wrapper2);
        // this is testing default behaviour of use_data_object_cache
        assertNotSame(wrapper.getValue().get(0), wrapper2.getValue().get(0));
        
        List<OpbDynamicDataView> list = instance.useResultCacheB(0L);
        List<OpbDynamicDataView> list2 = instance.useResultCacheB(0L);
        assertSame(list, list2);
        // if the lists are the same, their contents must be the same
        assertSame(list.get(0), list2.get(0));
        // prove that these data objects are not cached
        // this is testing default behaviour of use_data_object_cache
        TestHelper.getSharedOpbSession()
                .getDataObjectSource()
                .clearCachedResults();
        list2 = instance.useResultCacheB(0L);
        assertNotSame(list, list2);
        assertNotSame(list.get(0), list2.get(0));
        
        list = instance.useResultCacheB(0L);
        list2 = instance.useResultCacheB(2L); // different key
        assertNotSame(list, list2);
        assertNotSame(list.get(0), list2.get(0));
        
        assertSame(instance.useResultCacheB2(0L), instance.useResultCacheB2(0L));
        assertNotSame(instance.useResultCacheB2(0L), instance.useResultCacheB2(1L));
        assertNotSame(instance.useResultCacheB3(0L), instance.useResultCacheB3(0L));
        
        
        
        OpbValueWrapper<Long> longWrapper = new OpbValueWrapperImpl<Long>();
        OpbValueWrapper<Long> longWrapper2 = new OpbValueWrapperImpl<Long>();
        instance.useScalarResultCacheA(longWrapper, 0L);
        instance.useScalarResultCacheA(longWrapper2, 0L);
        assertNotSame(longWrapper, longWrapper2);
        
        assertNotSame(instance.useScalarResultCacheB(0L), instance.useScalarResultCacheB(0L));
        assertSame(instance.useScalarResultCacheB2(0L), instance.useScalarResultCacheB2(0L));
        assertNotSame(instance.useScalarResultCacheB2(0L), instance.useScalarResultCacheB2(2L));
        assertNotSame(instance.useScalarResultCacheB3(0L), instance.useScalarResultCacheB3(0L));
        
        
        
        OpbValueWrapper<List<FieldsId>> useDataObjectCacheResult =
                new OpbValueWrapperImpl<List<FieldsId>>();
        instance.useDataObjectCacheA(useDataObjectCacheResult, 0L);
        
        assertNotNull(useDataObjectCacheResult.getValue().get(0));
        assertSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB(0L).get(0));
        assertSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB(2L).get(0)); // different key
        
        assertNotNull(instance.useDataObjectCacheB2(0L));
        assertNotSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB2(0L).get(0));
        assertNotSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB2(2L).get(0));
        
    }
    
    public void testParamCache3() throws Exception {
        ParamCache3 instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(ParamCache3.class);
        
        OpbValueWrapper<Long> longWrapper = new OpbValueWrapperImpl<Long>();
        OpbValueWrapper<Long> longWrapper2 = new OpbValueWrapperImpl<Long>();
        
        assertNotSame(
                instance.useResultCacheB(longWrapper), 
                instance.useResultCacheB(longWrapper));
        
        assertNotSame(
                instance.useResultCacheBPart2(longWrapper), 
                instance.useResultCacheBPart2(longWrapper));
        
        assertNotSame(
                instance.useResultCacheB2(longWrapper), 
                instance.useResultCacheB2(longWrapper));
        
        assertNotSame(
                instance.useResultCacheB2Part2(longWrapper), 
                instance.useResultCacheB2Part2(longWrapper));
        
        assertNotSame(
                instance.useResultCacheB3(longWrapper), 
                instance.useResultCacheB3(longWrapper));
        
        
        assertNotSame(
                instance.useScalarResultCacheB(longWrapper), 
                instance.useScalarResultCacheB(longWrapper));
        
        assertNotSame(
                instance.useScalarResultCacheBP2(longWrapper), 
                instance.useScalarResultCacheBP2(longWrapper));
        
        assertNotSame(
                instance.useScalarResultCacheB2(longWrapper), 
                instance.useScalarResultCacheB2(longWrapper));
        
        assertNotSame(
                instance.useScalarResultCacheB2P2(longWrapper), 
                instance.useScalarResultCacheB2P2(longWrapper));
        
        assertNotSame(
                instance.useScalarResultCacheB3(longWrapper), 
                instance.useScalarResultCacheB3(longWrapper));
        
        OpbValueWrapper<List<FieldsId>> useDataObjectCacheResult =
                new OpbValueWrapperImpl<List<FieldsId>>();
        instance.useDataObjectCacheA(useDataObjectCacheResult, longWrapper);
        
        assertNotNull(useDataObjectCacheResult.getValue().get(0));
        assertSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB(longWrapper).get(0));
        assertSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB(longWrapper2).get(0)); 
        
        assertNotNull(instance.useDataObjectCacheB2(longWrapper));
        assertNotSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB2(longWrapper).get(0));
        assertNotSame(
                useDataObjectCacheResult.getValue().get(0), 
                instance.useDataObjectCacheB2(longWrapper).get(0));
        
    }
    
    public void testCats() throws Exception {
        OpbDataObjectSource dos = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource();
        dos.clearCached();
        
        Cats cats = dos.newInstance(Cats.class);
        
        OpbId keyToResult = new OpbId("cats.get_cats");
        
        List<Cat> result = cats.getCats();
        
        assertNotSame(result.get(1), result.get(2));
        assertSame(result.get(3), result.get(4));
        
        Cat cat1 = result.get(0);
        java.util.Date cat1LastChanged = cat1.getLastChanged();
        Cat cat2 = result.get(1);
        java.util.Date cat2LastChanged = cat2.getLastChanged();
        
        assertNotNull(dos.getCachedResult(Cat.class, keyToResult));
        cat1.updateDescription();
        assertTrue(dos.isCached(Cat.class, cat1.getOpbId()));
        assertTrue(dos.isCached(Cat.class, cat2.getOpbId()));
        assertNull(dos.getCachedResult(Cat.class, keyToResult));
        
        result = cats.getCats();
        assertSame(cat1, result.get(0));
        assertNotSame(cat1LastChanged, result.get(0).getLastChanged());
        assertSame(cat2, result.get(1));
        assertSame(cat2LastChanged, result.get(1).getLastChanged());
        
        
        cat1.deleteCat();
        assertFalse(dos.isCached(Cat.class, cat1.getOpbId()));
        assertTrue(dos.isCached(Cat.class, cat2.getOpbId()));
        
        result = cats.getCats();
        assertNotSame(cat1, result.get(0));
        assertNotSame(cat1LastChanged, result.get(0).getLastChanged());
        assertSame(cat2, result.get(1));
        assertSame(cat2LastChanged, result.get(1).getLastChanged());
        assertEquals(4, dos.getCached(Cat.class).size());
        
        
        dos.newInstance(ParamCache.class).useDataObjectCacheB();
        assertTrue(dos.getCached(FieldsId.class).size() > 0);
        
        
        cat2.clearCachedAll();
        assertFalse(dos.isCached(Cat.class, cat1.getOpbId()));
        assertFalse(dos.isCached(Cat.class, cat2.getOpbId()));
        assertEquals(0, dos.getCached(Cat.class).size());
        assertEquals(0, dos.getCached(FieldsId.class).size());
        
        result = cats.getCats();
        assertNotSame(cat1, result.get(0));
        assertNotSame(cat1LastChanged, result.get(0).getLastChanged());
        assertNotSame(cat2, result.get(1));
        assertNotSame(cat2LastChanged, result.get(1).getLastChanged());
        
        
        cat1 = result.get(0);
        cat1LastChanged = cat1.getLastChanged();
        cat2 = result.get(1);
        cat2LastChanged = cat2.getLastChanged();
        
        dos.newInstance(ParamCache.class).useDataObjectCacheB();
        assertTrue(dos.getCached(FieldsId.class).size() > 0);
        
        cat2.invalidateCachedAll();
        assertTrue(dos.isCached(Cat.class, cat1.getOpbId()));
        assertTrue(dos.isCached(Cat.class, cat2.getOpbId()));
        
        result = cats.getCats();
        assertSame(cat1, result.get(0));
        assertNotSame(cat1LastChanged, result.get(0).getLastChanged());
        assertSame(cat2, result.get(1));
        assertNotSame(cat2LastChanged, result.get(1).getLastChanged());
        assertTrue(dos.getCached(FieldsId.class).size() > 0);
        
        
        dos.newInstance(ParamCache.class).useDataObjectCacheB();
        assertTrue(dos.getCached(FieldsId.class).size() > 0);
        
        cat1.clearCachedCats();
        
        result = cats.getCats();
        assertNotSame(cat1, result.get(0));
        assertNotSame(cat1LastChanged, result.get(0).getLastChanged());
        assertNotSame(cat2, result.get(1));
        assertNotSame(cat2LastChanged, result.get(1).getLastChanged());
        assertTrue(dos.getCached(FieldsId.class).size() > 0);
        
        
        cat1 = result.get(0);
        cat1LastChanged = cat1.getLastChanged();
        cat2 = result.get(1);
        cat2LastChanged = cat2.getLastChanged();
        
        cat1.invalidateCachedCats();
        
        result = cats.getCats();
        assertSame(cat1, result.get(0));
        assertNotSame(cat1LastChanged, result.get(0).getLastChanged());
        assertSame(cat2, result.get(1));
        assertNotSame(cat2LastChanged, result.get(1).getLastChanged());
        assertTrue(dos.getCached(FieldsId.class).size() > 0);
        
        
    }
    
    public void testArraysInTestOne() throws Exception {
        OpbDataObjectSource dos = 
                TestHelper.getSharedOpbSession().getDataObjectSource();
                
        ArraysIn instance = dos.newInstance(ArraysIn.class);
        
        String[] data = new String[] {};
        
        instance.testOne(data);
        
        data = new String[] {"a", "b", "c"};
        instance.testOne(data);
        
        data = new String[999];
        for (int i = 0; i < data.length; i++) {
            String s = "a";
            for (int j = 0; j < i; j++) {
                s = s+"BB";
            }
            data[i] = s;
        }
        
        instance.testOne(data);
        
    }

    public void testArraysInTestTwo() throws Exception {
        OpbDataObjectSource dos = 
                TestHelper.getSharedOpbSession().getDataObjectSource();
        ArraysIn instance = dos.newInstance(ArraysIn.class);
        
        BigDecimal[] data = new BigDecimal[] {
            BigDecimal.valueOf(32)
        };
        
        instance.testTwo(data);
        
        data = new BigDecimal[] {};
        
        instance.testTwo(data);
        
        data = new BigDecimal[999];
        
        for (int i = 0; i < data.length; i++) {
            data[i] = BigDecimal.valueOf(Double.parseDouble(i + "." + i));
        }
        
        instance.testTwo(data);
        
    }

    public void testUserDefinedCollectionsPassingNull() throws Exception {
        UserDefinedCollections instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(UserDefinedCollections.class);

        // passing NULL for a user defined collection is ok - function should return NULL
        assertNull(instance.echoNumberTable(null));

        try {
            // this should fail as the format_number_table function uses the collection
            instance.formatNumberTable(null);
            fail();
        } catch (OpbDataAccessException ex) {
            //Caused by: java.sql.SQLException: ORA-06531: Reference to uninitialized collection
        }

        // passing null to an IN OUT parameter is also OK
        OpbValueWrapper<String[]> wrapperForSimpleInOut = new OpbValueWrapperImpl<String[]>();
        instance.simpleInOut(wrapperForSimpleInOut);
        String[] resultOfSimpleInOut = (String[]) wrapperForSimpleInOut.getValue();
        assertNull(resultOfSimpleInOut);

    }
    
    public void testUserDefinedCollections() throws Exception {
        UserDefinedCollections instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(UserDefinedCollections.class);

        String[] numbers = new String[]{"1", "2", "3"};
        assertEquals("1, 2, 3", instance.formatNumberTable(numbers));

        BigDecimal[] data = new BigDecimal[]{
            BigDecimal.ONE,
            BigDecimal.TEN,
            BigDecimal.ZERO
        };
        
        BigDecimal[] result = instance.echoNumberTable(data);
        
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], result[i]);
        }
        assertEquals(data.length, result.length);
        assertNotSame(data, result);
        
        // Oracle's implicit datatype conversions
        Object[] data2 = new Object[]{
            BigDecimal.ONE,
            "2",
            "3.0",
            4, 5L, 6, 7, 8, 9.0,
            BigDecimal.TEN,
            BigDecimal.ZERO,
            3.1,
            "3.2"   
        };
        
        BigDecimal[] expected2 = new BigDecimal[] {
            BigDecimal.ONE,
            BigDecimal.valueOf(2),
            BigDecimal.valueOf(3),
            BigDecimal.valueOf(4),
            BigDecimal.valueOf(5),
            BigDecimal.valueOf(6),
            BigDecimal.valueOf(7),
            BigDecimal.valueOf(8),
            BigDecimal.valueOf(9),
            BigDecimal.TEN,
            BigDecimal.ZERO,
            BigDecimal.valueOf(3.1),
            BigDecimal.valueOf(3.2)
        };
        
        result = instance.echoNumberTable(data2);
        
        for (int i = 0; i < expected2.length; i++) {
            assertEquals(expected2[i], result[i]);
        }
        assertEquals(expected2.length, result.length);
        assertEquals(expected2.length, data2.length);
        
        
        String[] dataForSimpleInOut = new String[]{"a", "B", "2", "Pi", " "};
        OpbValueWrapper<String[]> wrapperForSimpleInOut = 
                new OpbValueWrapperImpl<String[]>(dataForSimpleInOut);
        instance.simpleInOut(wrapperForSimpleInOut);
        String[] resultOfSimpleInOut = (String[]) wrapperForSimpleInOut.getValue();
        for (int i = 0; i < dataForSimpleInOut.length; i++) {
            assertEquals(dataForSimpleInOut[i], resultOfSimpleInOut[i]);
        }
        assertEquals(dataForSimpleInOut.length, resultOfSimpleInOut.length);
        assertNotSame(dataForSimpleInOut, resultOfSimpleInOut);
        
    }
    
    public void testUserDefinedCollectionsWithLongStrings() throws Exception {
        UserDefinedCollections instance = TestHelper
                .getSharedOpbSession()
                .getDataObjectSource()
                .newInstance(UserDefinedCollections.class);
        
        int expectedLengthInt = 4000;
        String expectedLengthString = ""+expectedLengthInt;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<expectedLengthInt; i++) {
            sb.append("a");
        }
        String s = sb.toString();
        assertEquals(expectedLengthInt, s.length());
        
        String[] data = new String[]{s, s, s, s, s, s, s, s};
        OpbValueWrapper<String[]> resultsWrapper = new OpbValueWrapperImpl<String[]>();
        assertEquals("notnull", instance.howLong(data, resultsWrapper));
        
        String[] results = resultsWrapper.getValue();
        
        assertEquals(data.length, results.length);
        
        for (int i = 0; i < results.length; i++) {
            assertEquals(expectedLengthString, results[i]);
        }

        data = new String[]{s+"A"};
        try {
            instance.howLong(data, resultsWrapper);
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getCause().getMessage().indexOf("too large") != -1);
        }
        
    }
    
    
    private void _methodExists(Class c, String name, Class... paramTypes) 
            throws Exception {
        c.getDeclaredMethod(name, paramTypes);
    }
    
    private void _methodDoesNotExist(Class c, String name, Class... paramTypes) 
            throws Exception {
        try {
            Method m = c.getDeclaredMethod(name, paramTypes);
            if (!Modifier.isPrivate(m.getModifiers())) {
                fail("Method should not exist. Found " + name + 
                        " for class " + c.getName());
            }
        } catch (NoSuchMethodException ex) {
        }
    }
    
    
    static class FieldsImpl2 extends FieldsImpl {
        public boolean aChangedCalled;
        
        @Override
        public void aChanged() throws OpbDataAccessException {
            aChangedCalled = true;
        }
        
    }
        
}
