/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.butterfill.opb.plsql.session;

import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImplTest.TestDataObjectSource;
import com.butterfill.opb.util.OpbScalarResultCache;
import helpers.TestHelper;
import junit.framework.TestCase;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Butterp
 */
public class OpbSessionLightPlsqlImplTest extends TestCase {


    OracleDataSource dataSource;
    OpbDataObjectSource dataObjectSource;
    OpbScalarResultCache scalarResultCache;

    OpbSessionPlsqlImpl instance;

    public OpbSessionLightPlsqlImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        dataSource = TestHelper.getSharedOracleDataSource();
        dataObjectSource = new TestDataObjectSource();
        scalarResultCache = new OpbScalarResultCache();

        instance = new OpbSessionPlsqlImpl(
                dataSource, dataObjectSource, scalarResultCache);

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
     * Test of getScalarResultCache method, of class OpbSessionLightPlsqlImpl.
     */
    public void testGetScalarResultCache() {
        System.out.println("getScalarResultCache");

        OpbScalarResultCache expResult = scalarResultCache;
        OpbScalarResultCache result = instance.getOpbScalarResultCache();
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

}
