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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class OpbCommentTest extends TestCase {
    
    private final static String LS = System.getProperty("line.separator");
    
    private OpbComment _oc;
    private OpbComment _ocp;
    
    public OpbCommentTest(String testName) {
        super(testName);
    }            

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        _oc = new OpbComment(
                "/*opb"+LS+
                "param"+LS+
                "name=a;"+LS+
                "*/");
        _ocp = new OpbComment(
                "/*opb-package"+LS+
                "field"+LS+
                "name=a;"+LS+
                "*/");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbCommentTest.class);
        return suite;
    }
    
    /**
     * Test of toString method, of class OpbComment.
     */
    public void testToString() {
        System.out.println("toString");
        OpbComment instance = new OpbComment("");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getElements method, of class OpbComment.
     */
    public void testGetElements() {
        System.out.println("getElements");
        OpbComment instance = new OpbComment("");
        List<Map<String, String>> expResult = new ArrayList<Map<String, String>>();
        List<Map<String, String>> result = instance.getElements();
        assertEquals(expResult, result);
    }

    /**
     * Test of parseComment method, of class OpbComment.
     */
    public void testParseComment() {
        System.out.println("parseComment");
        String comment = 
                "/*opb"+LS+
                "field"+LS+
                "name=a"+LS+
                "datatype=b;"+LS+
                "testProp"+LS+
                "a=A"+LS+
                "b=B;"+LS+
                "*/"+LS;
        
        OpbComment instance = new OpbComment(comment);
        
        assertTrue(instance.isOpb());
        
        assertEquals(2, instance.getElements().size());
    }

    /**
     * Test of applyElement method, of class OpbComment.
     */
    public void testApplyElement() {
        System.out.println("applyElement");
        Map<String, String> element = new HashMap<String, String>();
        element.put("a", "A");
        element.put("b", "B");
        element.put("throw_ex", null);
        TestClass target = new TestClass();
        OpbComment instance = new OpbComment("");
        instance.applyElement(element, target);
        assertEquals("A", target.getA());
        
        element.clear();
        
        TestClass2 tc2 = new TestClass2();
        instance.applyElement(element, tc2);
        
        tc2.fail = true;
        instance.applyElement(element, tc2);
        
    }

    /**
     * Test of isOpbPackage method, of class OpbComment.
     */
    public void testIsOpbPackage() {
        System.out.println("isOpbPackage");
        
        assertFalse(_oc.isOpbPackage());
        assertTrue(_ocp.isOpbPackage());
    }

    /**
     * Test of isOpb method, of class OpbComment.
     */
    public void testIsOpb() {
        System.out.println("isOpb");
        
        assertFalse(_ocp.isOpb());
        assertTrue(_oc.isOpb());
    }

    /**
     * Test of checkElementTypes method, of class OpbComment.
     */
    public void testCheckElementTypes() {
        System.out.println("checkElementTypes");
        
        _oc.checkElementTypes("param", "clear_cached", "invalidate_cached");
        _ocp.checkElementTypes("field");
        
        _oc.checkElementTypes("x");
        
    }
    
    private static class TestClass {
        String a;
        public void opb_a(String a) {
            this.a = a;
        }
        String getA() {
            return a;
        }
        public void opb_throw_ex(String s) {
            s.toString();
            throw new RuntimeException("Test fail message");
        }
    }
    
    private static class TestClass2 {
        boolean fail = false;
        public void opb_applyElementComplete() {
            if (fail) {
                throw new RuntimeException("Test fail from TestClass2");
            }
        }
    }
    
}
