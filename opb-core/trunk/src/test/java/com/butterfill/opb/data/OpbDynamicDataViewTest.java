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

package com.butterfill.opb.data;

import com.butterfill.opb.util.OpbToStringMode;
import java.util.ArrayList;
import java.util.HashSet;
import junit.framework.*;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import com.butterfill.opb.util.OpbToStringHelper;
import helpers.TestHelper;

/**
 *
 * @author Peter Butterfill
 */
public class OpbDynamicDataViewTest extends TestCase {

    public OpbDynamicDataViewTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {

    }

    @Override
    protected void tearDown() throws Exception {
    }

    /**
     * Test of toString method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testToString() {
        System.out.println("toString");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }


    /**
     * Test of opbLoad method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testLoad() throws Exception {
        System.out.println("load");

        //OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        String adminOption = null;
        String privilege = null;
        String username = null;

        ResultSet rs = TestHelper.getResultSet(
                "SELECT user_sys_privs.*, 'x' AS testCol " +
                "FROM   user_sys_privs " +
                "WHERE  rownum < 9");

        while (rs.next()) {
            adminOption = rs.getString("admin_option");
            privilege = rs.getString("privilege");
            username = rs.getString("username");

            instance.opbLoad(rs);

            OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
            System.out.format("~~~~~~~~~~~~~~~~~~~~~~%n");
            System.out.format("%s%n", instance);
            System.out.format("~~~~~~~~~~~~~~~~~~~~~~%n");

            assertEquals(adminOption, instance.get("adminOption"));
            assertEquals(privilege, instance.get("privilege"));
            assertEquals(username, instance.get("username"));
            assertEquals("x", instance.get("testcol"));
            assertNull(instance.get("testCol"));
            assertNull(instance.get("test_col"));

            //System.out.println(instance);

        }

    }

    /**
     * Test of size method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testSize() throws Exception {
        System.out.println("size");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT admin_option, privilege, username " +
                "FROM   user_sys_privs " +
                "WHERE  rownum < 9");

        rs.next();

        instance.opbLoad(rs);

        expResult = 3;

        result = instance.size();
        assertEquals(expResult, result);

        rs.close();

        rs = TestHelper.getResultSet(
                "SELECT admin_option, privilege " +
                "FROM   user_sys_privs " +
                "WHERE  rownum < 9");

        rs.next();

        instance.opbLoad(rs);

        expResult = 2;

        result = instance.size();
        assertEquals(expResult, result);

        rs.close();

        rs = TestHelper.getResultSet(
                "SELECT admin_option " +
                "FROM   user_sys_privs " +
                "WHERE  rownum < 9");

        rs.next();

        instance.opbLoad(rs);

        expResult = 1;

        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testIsEmpty() throws Exception{
        System.out.println("isEmpty");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT admin_option, privilege, username " +
                "FROM   user_sys_privs " +
                "WHERE  rownum < 9");

        rs.next();

        instance.opbLoad(rs);

        expResult = false;

        result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of containsKey method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testContainsKey()
    throws Exception {
        System.out.println("START of testContainsKey() ");

        String key = null;
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        boolean expResult = false;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT * " +
                "FROM   user_sys_privs " +
                "WHERE  rownum < 9");

        rs.next();

        instance.opbLoad(rs);

        expResult = false;
        key = "ADMIN_OPTION";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "ADMIN_option";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "PRIVILEGE";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "PRIVIlEGE"; // lower case L
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "USERNAME";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "username_";
        result = instance.containsKey(key);
        assertEquals(expResult, result);


        expResult = true;

        key = "username";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "adminOption";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

        key = "privilege";
        result = instance.containsKey(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of containsValue method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testContainsValue() throws Exception {
        System.out.println("containsValue");

        Object value = null;
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        boolean expResult = false;
        boolean result = instance.containsValue(value);
        assertEquals(expResult, result);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO', 'fudge' " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        expResult = true;
        value = "NO";
        result = instance.containsValue(value);
        assertEquals(expResult, result);

        expResult = true;
        value = "fudge";
        result = instance.containsValue(value);
        assertEquals(expResult, result);

        expResult = false;
        value = "Fudge";
        result = instance.containsValue(value);
        assertEquals(expResult, result);

        expResult = false;
        value = "FUDGE";
        result = instance.containsValue(value);
        assertEquals(expResult, result);

        expResult = false;
        value = "nO";
        result = instance.containsValue(value);
        assertEquals(expResult, result);

    }

    /**
     * Test of get method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testGet() throws Exception {
        System.out.println("get");

        Object key = null;
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        Object expResult = null;
        Object result = instance.get(key);
        assertEquals(expResult, result);

        expResult = null;
        key = "column_a";
        result = instance.get(key);
        assertEquals(expResult, result);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        expResult = "NO";
        key = "columnA";
        result = instance.get(key);
        assertEquals(expResult, result);

        expResult = null;
        key = "columnB";
        result = instance.get(key);
        assertEquals(expResult, result);

        expResult = null;
        key = "columnC";
        result = instance.get(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of put method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     * Note: This is a no-op
     */
    public void testPut() {
        System.out.println("put");

        Object key = "column_a";
        Object value = "value_a";
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        Object expResult = null;
        Object result = instance.put(key, value);
        assertEquals(expResult, result);
        assertNull(instance.get(key));
        assertFalse(instance.containsKey(key));
        assertFalse(instance.containsValue(value));

    }

    /**
     * Test of remove method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     * Note: This is a no-op
     */
    public void testRemove() throws Exception {
        System.out.println("remove");

        Object key = null;
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        Object expResult = null;
        Object result = instance.remove(key);
        assertEquals(expResult, result);

        key = "columnA";
        result = instance.remove(key);
        assertEquals(expResult, result);
        assertNull(instance.get(key));

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        assertEquals(instance.get("columnA"), "NO");
        result = instance.remove(key);
        assertEquals(expResult, result);
        assertEquals(instance.get("columnA"), "NO");

    }

    /**
     * Test of putAll method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     * Note: This is a no-op
     */
    public void testPutAll() throws Exception {
        System.out.println("putAll");

        Map<String, String> m = null;
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        instance.putAll(m);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        assertEquals(instance.size(), 1);

        m = new HashMap<String, String>();
        m.put("column_b", "value_b");

        instance.putAll(m);

        assertEquals(instance.size(), 1);
        assertNull(instance.get("column_b"));

    }

    /**
     * Test of clear method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     * Note: This is a no-op
     */
    public void testClear() throws Exception {
        System.out.println("clear");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        instance.clear();

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        assertTrue(instance.containsKey("columnA"));
        instance.clear();
        assertTrue(instance.containsKey("columnA"));

    }

    /**
     * Test of keySet method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testKeySet() throws Exception {
        System.out.println("keySet");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        Set<String> expResult = null;
        Set<String> result = instance.keySet();
        assertEquals(result.size(), 0);

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        result = instance.keySet();
        assertEquals(result.size(), 2);

        expResult = new HashSet<String>();
        expResult.add("columnA");
        expResult.add("columnB");

        assertTrue(expResult.containsAll(result));
        assertTrue(result.containsAll(expResult));

    }

    /**
     * Test of values method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testValues() throws Exception {
        System.out.println("values");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        Collection<Object> expResult = null;
        Collection<Object> result = instance.values();
        assertEquals(0, result.size());

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        expResult = new ArrayList<Object>();
        expResult.add("NO");
        expResult.add(null);

        result = instance.values();
        assertEquals(2, result.size());

        assertTrue(expResult.containsAll(result));
        assertTrue(result.containsAll(expResult));

    }

    /**
     * Test of entrySet method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testEntrySet() throws Exception {
        System.out.println("entrySet");

        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        Set<Map.Entry<String, Object>> expResult = null;
        Set<Map.Entry<String, Object>> result = instance.entrySet();
        assertEquals(0, result.size());

        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);

        result = instance.entrySet();
        assertEquals(2, result.size());

        Set<String> keys = new HashSet<String>();
        keys.add("columnA");
        keys.add("columnB");

        List<Object> values = new ArrayList<Object>();
        values.add("NO");
        values.add(null);

        for (Map.Entry e : result) {
            assertTrue(keys.contains(e.getKey()));
            assertTrue(values.contains(e.getValue()));
        }

    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbDynamicDataViewTest.class);

        return suite;
    }



    /**
     * Test of opbLoad method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testOpbLoad() throws Exception {
        System.out.println("opbLoad");

        ResultSet resultSet = null;
        OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();

        try {
            instance.opbLoad(resultSet);
            fail("opbLoad should fail given a null result set");
        } catch (NullPointerException ex) {
            //ok
        }

        // silly__name tests conversion of names with consecutive underscores
        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'NO' AS column_a, '' AS column_b, 'Yes' AS silly__name " +
                "FROM   dual");

        rs.next();

        instance.opbLoad(rs);
        
        assertEquals("NO", instance.get("columnA"));
        assertNull(instance.get("columnB"));
        assertEquals("Yes", instance.get("sillyName"));

        rs.close();

        try {
            // opbLoad should fail when result set is closed
            instance.opbLoad(rs);
            fail("opbLoad should fail when result set is closed");

        } catch (OpbDataAccessException ex) {

        }

    }

}
