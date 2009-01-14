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
public class PlsqlPackageConstantTest extends TestCase {
    
    PlsqlPackageConstant instance;
    List<String> commentLines;
    
    public PlsqlPackageConstantTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlPackageConstantTest.class);
        return suite;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        commentLines = new ArrayList<String>();
        commentLines.add("line 1");
        commentLines.add("line 2");
        commentLines.add("line 3");
        
        instance = new PlsqlPackageConstant("a_a", "integer", "33", commentLines);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getSqlName method, of class PlsqlPackageConstant.
     */
    public void testGetSqlName() {
        System.out.println("getSqlName");
        
        String expResult = "a_a";
        String result = instance.getSqlName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class PlsqlPackageConstant.
     */
    public void testGetName() {
        System.out.println("getName");
        
        String expResult = "A_A";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSqlDatatype method, of class PlsqlPackageConstant.
     */
    public void testGetSqlDatatype() {
        System.out.println("getSqlDatatype");
        
        String expResult = "integer";
        String result = instance.getSqlDatatype();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatatype method, of class PlsqlPackageConstant.
     */
    public void testGetDatatype() {
        System.out.println("getDatatype");
        
        String expResult = "Long";
        String result = instance.getDatatype();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSqlValue method, of class PlsqlPackageConstant.
     */
    public void testGetSqlValue() {
        System.out.println("getSqlValue");
        
        String expResult = "33";
        String result = instance.getSqlValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class PlsqlPackageConstant.
     */
    public void testGetValue() {
        System.out.println("getValue");
        
        String expResult = "33L";
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentLines method, of class PlsqlPackageConstant.
     */
    public void testGetCommentLines() {
        System.out.println("getCommentLines");
        
        List expResult = commentLines;
        List result = instance.getCommentLines();
        assertEquals(expResult, result);
    }

}
