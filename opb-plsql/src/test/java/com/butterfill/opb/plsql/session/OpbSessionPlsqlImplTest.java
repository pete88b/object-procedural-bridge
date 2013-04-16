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

package com.butterfill.opb.plsql.session;

import com.butterfill.opb.OpbObjectSourceImpl;
import java.sql.SQLException;
import junit.framework.*;
import com.butterfill.opb.OpbId;
import com.butterfill.opb.data.OpbCacheableEntity;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.session.*;
import java.sql.ResultSet;
import com.butterfill.opb.util.OpbScalarResultCache;
import helpers.TestHelper;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Peter Butterfill
 */
public class OpbSessionPlsqlImplTest extends TestCase {
    private static final Logger logger = Logger.getLogger(
            "com.butterfill.opb.plsql.session.OpbSessionPlsqlImplTest");

    OpbSessionPlsqlImpl instance;

    public OpbSessionPlsqlImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbDataObjectSource dataObjectSource = new TestDataObjectSource();
        OpbScalarResultCache scalarResultCache = new OpbScalarResultCache();

        instance = new OpbSessionPlsqlImpl(dataSource, dataObjectSource, scalarResultCache);

    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbSessionPlsqlImplTest.class);

        return suite;
    }

    public void testConstructor() {
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbDataObjectSource dataObjectSource = new TestDataObjectSource();
        OpbScalarResultCache scalarResultCache = new OpbScalarResultCache();

        try {
            new OpbSessionPlsqlImpl(null, dataObjectSource, scalarResultCache);
            fail();
        } catch (NullPointerException ex) {
        }

        try {
            new OpbSessionPlsqlImpl(dataSource, null, scalarResultCache);
            fail();
        } catch (NullPointerException ex) {
        }

        try {
            new OpbSessionPlsqlImpl(dataSource, dataObjectSource, null);
            fail();
        } catch (NullPointerException ex) {
        }

        OpbSession session = new OpbSessionPlsqlImpl(
                dataSource, dataObjectSource, scalarResultCache);

    }

    /**
     * Test of toString method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testToString() {
        System.out.println("toString");

        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);

    }


    /**
     * Test of getScalarResultCache method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetScalarResultCache() {
        System.out.println("getScalarResultCache");

        assertNotNull(instance.getOpbScalarResultCache());
        assertSame(instance.getOpbScalarResultCache(), instance.getOpbScalarResultCache());

    }


    /**
     * Test of getDataObjectSource method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetDataObjectSource() {
        System.out.println("getDataObjectSource");

        assertNotNull(instance.getDataObjectSource());
        assertSame(instance.getDataObjectSource(), instance.getDataObjectSource());

    }



    static class TestDataObjectSource extends OpbDataObjectSource {

        public TestDataObjectSource() {
            super(new OpbObjectSourceImpl());
        }

        public boolean clearCachedCalled;
        @Override
        public void clearCached() {
            clearCachedCalled = true;
            super.clearCached();
        }
        public boolean clearCachedResultsCalled;
        @Override
        public void clearCachedResults() {
            clearCachedResultsCalled = true;
            super.clearCachedResults();
        }

    }


    public static interface Cacheable extends OpbCacheableEntity {
    }

    public static class CacheableImpl implements Cacheable {

        private OpbId _opbId;
        private String a;

        public OpbId getOpbId() {
            return _opbId;
        }

        public void opbLoad(ResultSet resultSet) throws OpbDataAccessException {
            try {
                a = resultSet.getString("a");
            } catch (SQLException ex) {
                throw new OpbDataAccessException(
                        "failed to load CacheableImpl", ex);
            }
            _opbId = new OpbId(a);
        }

    }

}
