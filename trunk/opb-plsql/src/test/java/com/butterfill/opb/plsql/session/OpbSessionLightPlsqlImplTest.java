/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.butterfill.opb.plsql.session;

import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImplTest.TestDataObjectSource;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.util.OpbScalarResultCache;
import helpers.TestHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import junit.framework.TestCase;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Butterp
 */
public class OpbSessionLightPlsqlImplTest extends TestCase {


    OracleDataSource dataSource;
    OpbDataObjectSource dataObjectSource;
    OpbGroupManager groupManager;
    OpbScalarResultCache scalarResultCache;
    OpbEventTimer eventTimer;

    OpbSessionLightPlsqlImpl instance;

    public OpbSessionLightPlsqlImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        dataSource = TestHelper.getSharedOracleDataSource();
        dataObjectSource = new TestDataObjectSource();
        groupManager = new OpbGroupManager();
        scalarResultCache = new OpbScalarResultCache();
        eventTimer = new OpbEventTimer();

        instance = new OpbSessionLightPlsqlImpl(
                dataSource, dataObjectSource, groupManager, scalarResultCache, eventTimer);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of toString method, of class OpbSessionLightPlsqlImpl.
     */
    public void testToString() {
        System.out.println("toString");
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetId() {
        System.out.println("getId");
        
        String expResult = null;
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDataSource method, of class OpbSessionLightPlsqlImpl.
     */
    public void testCheckDataSource() {
        System.out.println("checkDataSource");
        
        instance.checkDataSource();

        try {
            dataSource = new MockOracleDataSource();
            instance = new OpbSessionLightPlsqlImpl(
                    dataSource, dataObjectSource, groupManager, scalarResultCache, eventTimer);
            instance.checkDataSource();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().contains("Can't query data source"));
            
        }

    }

    /**
     * Test of createSession method, of class OpbSessionLightPlsqlImpl.
     */
    public void testCreateSession() {
        System.out.println("createSession");
        
        instance.createSession();
    }

    /**
     * Test of endSession method, of class OpbSessionLightPlsqlImpl.
     */
    public void testEndSession() {
        System.out.println("endSession");
        
        instance.endSession();
    }

    /**
     * Test of checkMemoryUse method, of class OpbSessionLightPlsqlImpl.
     */
    public void testCheckMemoryUse() {
        System.out.println("checkMemoryUse");
        
        instance.checkMemoryUse();
    }

    /**
     * Test of getConnection method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetConnection() {
        System.out.println("getConnection");
        
        
        Connection result = instance.getConnection();
        assertNotNull(result);

        assertSame(result, instance.getConnection());
    }

    /**
     * Test of releaseConnection method, of class OpbSessionLightPlsqlImpl.
     */
    public void testReleaseConnection() {
        System.out.println("releaseConnection");
        boolean clearTempData = false;
        
        instance.releaseConnection(clearTempData);
    }

    /**
     * Test of getUsername method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetUsername() {
        System.out.println("getUsername");
        
        String expResult = null;
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class OpbSessionLightPlsqlImpl.
     */
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "testUsername";
        
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getAttributes method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetAttributes() {
        System.out.println("getAttributes");
        
        Map<Object, Object> expResult = instance.getAttributes();
        Map<Object, Object> result = instance.getAttributes();
        assertSame(expResult, result);

    }

    /**
     * Test of getGroupManager method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetGroupManager() {
        System.out.println("getGroupManager");
        
        OpbGroupManager expResult = groupManager;
        OpbGroupManager result = instance.getGroupManager();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScalarResultCache method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetScalarResultCache() {
        System.out.println("getScalarResultCache");
        
        OpbScalarResultCache expResult = scalarResultCache;
        OpbScalarResultCache result = instance.getScalarResultCache();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataObjectSource method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetDataObjectSource() {
        System.out.println("getDataObjectSource");
        
        OpbDataObjectSource expResult = dataObjectSource;
        OpbDataObjectSource result = instance.getDataObjectSource();
        assertEquals(expResult, result);
    }

    /**
     * Test of dataObjectCreated method, of class OpbSessionLightPlsqlImpl.
     */
    public void testDataObjectCreated() {
        System.out.println("dataObjectCreated");
        Class requestedType = Object.class;
        Object dataObject = new Object();
        boolean cached = false;
        
        instance.dataObjectCreated(requestedType, dataObject, cached);
        
    }

    /**
     * Test of getOpbEventTimer method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetOpbEventTimer() {
        System.out.println("getOpbEventTimer");
        
        OpbEventTimer expResult = eventTimer;
        OpbEventTimer result = instance.getOpbEventTimer();
        assertEquals(expResult, result);
    }


    static class MockOracleDataSource extends OracleDataSource {
        MockOracleDataSource() throws SQLException {
        }

        @Override
        public Connection getConnection() throws SQLException {
            throw new SQLException("failed to get connection");
        }

    }

}
