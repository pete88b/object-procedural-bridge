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
public class PlsqlCallTest extends TestCase {
    private final static String LS = System.getProperty("line.separator");
    
    public PlsqlCallTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlCallTest.class);
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
     * Test of toString method, of class PlsqlCall.
     */
    public void testToString() {
        System.out.println("toString");
        PlsqlCall instance = new PlsqlCall();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class PlsqlCall.
     */
    public void testGetName() {
        System.out.println("getName");
        PlsqlCall instance = new PlsqlCall();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getSqlName method, of class PlsqlCall.
     */
    public void testGetSqlName() {
        System.out.println("getSqlName");
        PlsqlCall instance = new PlsqlCall();
        String expResult = null;
        String result = instance.getSqlName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSqlName method, of class PlsqlCall.
     */
    public void testSetSqlName() {
        System.out.println("setSqlName");
        String sqlName = "";
        PlsqlCall instance = new PlsqlCall();
        instance.setSqlName(sqlName);
        assertEquals("", instance.getSqlName());
    }

    /**
     * Test of isFunction method, of class PlsqlCall.
     */
    public void testIsFunction() {
        System.out.println("isFunction");
        PlsqlCall instance = new PlsqlCall();
        boolean expResult = false;
        boolean result = instance.isFunction();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFunction method, of class PlsqlCall.
     */
    public void testSetFunction() {
        System.out.println("setFunction");
        PlsqlCall instance = new PlsqlCall();
        instance.setFunction(false);
        assertFalse(instance.isFunction());
        instance.setFunction(true);
        assertTrue(instance.isFunction());
    }

    /**
     * Test of isProcedure method, of class PlsqlCall.
     */
    public void testIsProcedure() {
        System.out.println("isProcedure");
        PlsqlCall instance = new PlsqlCall();
        boolean expResult = false;
        boolean result = instance.isProcedure();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProcedure method, of class PlsqlCall.
     */
    public void testSetProcedure() {
        System.out.println("setProcedure");
        
        PlsqlCall instance = new PlsqlCall();
        instance.setProcedure(false);
        assertFalse(instance.isProcedure());
        instance.setProcedure(true);
        assertTrue(instance.isProcedure());
    }

    /**
     * Test of getParams method, of class PlsqlCall.
     */
    public void testGetParams() {
        System.out.println("getParams");
        PlsqlCall instance = new PlsqlCall();
        List<PlsqlCallParameter> expResult = new ArrayList<PlsqlCallParameter>();
        List<PlsqlCallParameter> result = instance.getParams();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMappedParams method, of class PlsqlCall.
     */
    public void testGetMappedParams() {
        System.out.println("getMappedParams");
        PlsqlCall instance = new PlsqlCall();
        List<PlsqlCallParameter> expResult = new ArrayList<PlsqlCallParameter>();
        List<PlsqlCallParameter> result = instance.getMappedParams();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnMappedParams method, of class PlsqlCall.
     */
    public void testGetUnMappedParams() {
        System.out.println("getUnMappedParams");
        PlsqlCall instance = new PlsqlCall();
        List<PlsqlCallParameter> expResult = new ArrayList<PlsqlCallParameter>();
        List<PlsqlCallParameter> result = instance.getUnMappedParams();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAtLeastOneParamIsMapped method, of class PlsqlCall.
     */
    public void testGetAtLeastOneParamIsMapped() {
        System.out.println("getAtLeastOneParamIsMapped");
        PlsqlCall instance = new PlsqlCall();
        
        assertFalse(instance.getAtLeastOneParamIsMapped());
        
        OpbComment c = new OpbComment(
                "/*opb"+LS+
                "param"+LS+
                "name=P_A"+LS+
                "field=a;");
        instance.setOpbComment(c);
        
        PlsqlCallParameter p = new PlsqlCallParameter("p_a", "number", true, false);
        instance.addParameter(p);
        
        assertTrue(instance.getAtLeastOneParamIsMapped());
    }

    /**
     * Test of getReturn method, of class PlsqlCall.
     */
    public void testGetReturn() {
        System.out.println("getReturn");
        PlsqlCall instance = new PlsqlCall();
        assertNull(instance.getReturn());
        
        instance.setSqlReturnType("number");
        assertNotNull(instance.getReturn());
    }

    /**
     * Test of addParameter method, of class PlsqlCall.
     */
    public void testAddParameter() {
        System.out.println("addParameter");
        PlsqlCallParameter p = null;
        PlsqlCall instance = new PlsqlCall();
        try {
            instance.addParameter(p);
            fail();
        } catch (NullPointerException exception) {
        }
        p = new PlsqlCallParameter("", "date", false, false);
        instance.addParameter(p);
    }

    /**
     * Test of setSqlReturnType method, of class PlsqlCall.
     */
    public void testSetSqlReturnType() {
        System.out.println("setSqlReturnType");
        String sqlReturnType = "date";
        PlsqlCall instance = new PlsqlCall();
        instance.setSqlReturnType(sqlReturnType);
    }

    /**
     * Test of isClearCachedAll method, of class PlsqlCall.
     */
    public void testIsClearCachedAll() {
        System.out.println("isClearCachedAll");
        PlsqlCall instance = new PlsqlCall();
        
        assertFalse(instance.isClearCachedAll());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=all;"));
        
        assertFalse(instance.isClearCachedAll());
        
        instance.validate();
        
        assertTrue(instance.isClearCachedAll());
        
    }

    /**
     * Test of isClearCachedThis method, of class PlsqlCall.
     */
    public void testIsClearCachedThis() {
        System.out.println("isClearCachedThis");
        PlsqlCall instance = new PlsqlCall();
        
        assertFalse(instance.isClearCachedThis());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=this;"));
        
        assertFalse(instance.isClearCachedThis());
        
        instance.validate();
        
        assertTrue(instance.isClearCachedThis());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=all;"));
        instance.validate();
        
        assertFalse(instance.isClearCachedThis());
        
    }

    /**
     * Test of getClearCached method, of class PlsqlCall.
     */
    public void testGetClearCached() {
        System.out.println("getClearCached");
        PlsqlCall instance = new PlsqlCall();
        List<String> expResult = new ArrayList<String>();
        List<String> result = instance.getClearCached();
        assertEquals(expResult, result);
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=all;"));
        instance.validate();
        
        assertNull(instance.getClearCached());
    }

    /**
     * Test of isInvalidateCachedAll method, of class PlsqlCall.
     */
    public void testIsInvalidateCachedAll() {
        System.out.println("isInvalidateCachedAll");
        PlsqlCall instance = new PlsqlCall();
        
        assertFalse(instance.isInvalidateCachedAll());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "invalidate_cached"+LS+
                "name=all;"));
        
        assertFalse(instance.isInvalidateCachedAll());
        
        instance.validate();
        
        assertTrue(instance.isInvalidateCachedAll());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=all;"));
        instance.validate();
        
        assertFalse(instance.isInvalidateCachedAll());
        
    }

    /**
     * Test of isInvalidateCachedThis method, of class PlsqlCall.
     */
    public void testIsInvalidateCachedThis() {
        System.out.println("isInvalidateCachedThis");
        PlsqlCall instance = new PlsqlCall();
        
        assertFalse(instance.isInvalidateCachedThis());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "invalidate_cached"+LS+
                "name=THIS;"));
        
        assertFalse(instance.isInvalidateCachedThis());
        
        instance.validate();
        
        assertTrue(instance.isInvalidateCachedThis());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "invalidate_cached"+LS+
                "name=all;"));
        instance.validate();
        
        assertFalse(instance.isInvalidateCachedThis());
        
        
        instance = new PlsqlCall();
        
        assertFalse(instance.isInvalidateCachedThis());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "invalidate_cached"+LS+
                "name=this;"));
        
        assertFalse(instance.isInvalidateCachedThis());
        
        instance.validate();
        
        assertTrue(instance.isInvalidateCachedThis());
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=this;"));
        instance.validate();
        
        assertFalse(instance.isInvalidateCachedThis());
    }

    /**
     * Test of getInvalidateCached method, of class PlsqlCall.
     */
    public void testGetInvalidateCached() {
        System.out.println("getInvalidateCached");
        PlsqlCall instance = new PlsqlCall();
        List<String> expResult = new ArrayList<String>();
        List<String> result = instance.getInvalidateCached();
        assertEquals(expResult, result);
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "invalidate_cached"+LS+
                "name=all;"));
        instance.validate();
        
        assertNull(instance.getInvalidateCached());
        
        instance = new PlsqlCall();
        assertEquals(expResult, result);
        
        instance.setOpbComment(new OpbComment(
                "/*opb"+LS+
                "clear_cached"+LS+
                "name=all;"));
        instance.validate();
        
        assertNull(instance.getInvalidateCached());
        
    }

    /**
     * Test of setOpbComment method, of class PlsqlCall.
     */
    public void testSetOpbComment() {
        System.out.println("setOpbComment");
        OpbComment comment = new OpbComment("");
        PlsqlCall instance = new PlsqlCall();
        instance.setOpbComment(comment);
    }

    /**
     * Test of validate method, of class PlsqlCall.
     */
    //TODO xxx this could do with a bit more
    public void testValidate() {
        System.out.println("validate");
        PlsqlCall instance = new PlsqlCall();
        instance.validate();
        
        instance.setOpbComment(new OpbComment(
                "/*opb\n"+
                "param\n"+
                "name=x\r"+
                "field=j;"));
        instance.validate();
        
        instance.setSqlName("test_call");
        instance.validate();
    }

    

    /**
     * Test of getCommentLines method, of class PlsqlCall.
     */
    public void testGetCommentLines() {
        System.out.println("getCommentLines");
        PlsqlCall instance = new PlsqlCall();
        List<String> expResult = null;
        List<String> result = instance.getCommentLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCommentLines method, of class PlsqlCall.
     */
    public void testSetCommentLines() {
        System.out.println("setCommentLines");
        List<String> commentLines = new ArrayList<String>();
        PlsqlCall instance = new PlsqlCall();
        instance.setCommentLines(commentLines);
        assertSame(commentLines, instance.getCommentLines());
    }

}
