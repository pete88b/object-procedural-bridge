/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.butterfill.opb.plsql.session;

import com.butterfill.opb.data.OpbDataAccessException;
import helpers.TestHelper;
import java.sql.Connection;
import java.sql.SQLException;
import junit.framework.TestCase;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Butterp
 */
public class OpbSessionPlsqlUtilsTest extends TestCase {
    
    public OpbSessionPlsqlUtilsTest(String testName) {
        super(testName);
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
     * Test of getConnection method, of class OpbSessionPlsqlUtils.
     */
    public void testGetConnection() {
        System.out.println("getConnection");
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        String sourceMethod = "testGetConnection";
        
        Connection result = OpbSessionPlsqlUtils.getConnection(dataSource, sourceMethod);

        assertNotNull(result);

        dataSource = newMockOracleDataSource();

        try {
            result = OpbSessionPlsqlUtils.getConnection(dataSource, sourceMethod);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().contains("url=dummy:url"));
        }

        ((MockOracleDataSource) dataSource).getUrlResult = new SQLException("failed to get URL");

        try {
            result = OpbSessionPlsqlUtils.getConnection(dataSource, sourceMethod);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().contains("url=null"));
        }

    }

    /**
     * Test of refreshConnectionCache method, of class OpbSessionPlsqlUtils.
     */
    public void testRefreshConnectionCache() {
        System.out.println("refreshConnectionCache");
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbSessionPlsqlUtils.refreshConnectionCache(dataSource);

        dataSource = newMockOracleDataSource();
        OpbSessionPlsqlUtils.refreshConnectionCache(dataSource);

        ((MockOracleDataSource) dataSource).connectionCachingEnabledShouldThrowException = true;
        OpbSessionPlsqlUtils.refreshConnectionCache(dataSource);

    }

    /**
     * Test of runTestQuery method, of class OpbSessionPlsqlUtils.
     */
    public void testRunTestQuery() {
        System.out.println("runTestQuery");
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbSessionPlsqlUtils.runTestQuery(dataSource);

        dataSource = newMockOracleDataSource();
        try {
            OpbSessionPlsqlUtils.runTestQuery(dataSource);
            fail();
        } catch (OpbDataAccessException ex) {

        }
        
    }

    static MockOracleDataSource newMockOracleDataSource() {
        try {
            return new MockOracleDataSource();
        } catch (Exception ex) {
            throw new RuntimeException("failed to create MockOracleDataSource", ex);
        }
    }

    static class MockOracleDataSource extends OracleDataSource {
        MockOracleDataSource() throws SQLException {
        }

        @Override
        public Connection getConnection() throws SQLException {
            throw new SQLException("failed to get connection");
        }

        Object getUrlResult = "dummy:url";

        @Override
        public synchronized String getURL() throws SQLException {
            if (getUrlResult instanceof String) {
                return (String) getUrlResult;
            }

            if (getUrlResult instanceof SQLException) {
                throw (SQLException) getUrlResult;
            }

            throw new RuntimeException("invalid getUrlResult. " + getUrlResult);

        }

        boolean connectionCachingEnabledShouldThrowException = false;

        @Override
        public boolean getConnectionCachingEnabled() throws SQLException {
            if (connectionCachingEnabledShouldThrowException) {
                throw new SQLException("getConnectionCachingEnabled failed");
            }
            return false;
        }

    }

}
