/*
 */
package com.butterfill.opb.plsql.data;

import com.butterfill.opb.data.OpbDataAccessException;
import helpers.TestHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Butterp
 */
public class OpbConnectionProviderPlsqlImplTest extends TestCase {

    private static final Logger logger = Logger.getLogger(
            OpbConnectionProviderPlsqlImplTest.class.getName());

    OpbConnectionProviderPlsqlImpl instance = new OpbConnectionProviderPlsqlImpl(
            TestHelper.getSharedOracleDataSource());

    OracleDataSource dataSource;

    public OpbConnectionProviderPlsqlImplTest(String testName) {
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

    // TODO: xxx test constructors etc

    /**
     * Test of toString method, of class OpbConnectionProviderPlsqlImpl.
     */
    public void testToString() {
        System.out.println("toString");

        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDataSource method, of class OpbConnectionProviderPlsqlImpl.
     */
    public void testCheckDataSource() {
        System.out.println("checkDataSource");

        instance.checkDataSource();

        try {
            dataSource = new MockOracleDataSource();
            instance = new OpbConnectionProviderPlsqlImpl(dataSource);
            instance.checkDataSource();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().contains("Can't query data source"));

        }

    }

    /**
     * Test of getConnection method, of class OpbConnectionProviderPlsqlImpl.
     */
    public void testGetConnection() {
        System.out.println("getConnection");

        Connection result = instance.getConnection();
        assertNotNull(result);

        assertSame(result, instance.getConnection());

    }

    /**
     * Test of getConnection method.
     */
    public void testGetConnection2() throws Exception {
        System.out.println("getConnection");

        Connection result = instance.getConnection();
        assertNotNull(result);

        for (int i = 0; i < 99; i++) {
            Connection connection2 = instance.getConnection();
            assertSame(result, connection2);
        }

        logger.warning(
                "################# " +
                "'WARNING: Connection is in use by another thread' " +
                "should follow");

        instance.getConnection();

        new Thread(new Runnable() {
            public void run() {
                instance.getConnection();
            }
        }).start();

        Thread.sleep(500);

        logger.warning("#################");

        instance.releaseConnection();

    }

    /**
     * Test of releaseConnection method, of class OpbConnectionProviderPlsqlImpl.
     */
    public void testReleaseConnection() throws Exception {
        System.out.println("releaseConnection");

        // safe to release connection even when we don't have one open
        instance.releaseConnection();

        // get a connection
        Connection connection = instance.getConnection();
        // make sure it's open
        assertFalse(connection.isClosed());
        // release the connection
        instance.releaseConnection();
        // and make sure it's closed
        assertTrue(connection.isClosed());

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
