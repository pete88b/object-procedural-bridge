/*
 */
package com.butterfill.opb.data;

import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbScalarResultCacheUser;
import java.sql.Connection;
import junit.framework.TestCase;

/**
 *
 * @author Butterp
 */
public class OpbDataObjectCreatedListenerImplTest extends TestCase {

    OpbConnectionProvider connectionProvider = new OpbConnectionProvider() {

        public Connection getConnection() throws OpbDataAccessException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void releaseConnection() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };

    OpbScalarResultCache scalarResultCache = new OpbScalarResultCache();

    public OpbDataObjectCreatedListenerImplTest(String testName) {
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

    public void testConstructors() {
        try {
            new OpbDataObjectCreatedListenerImpl(null, null);
            fail("");
        } catch (NullPointerException ex) {

        }
        try {
            new OpbDataObjectCreatedListenerImpl(connectionProvider, null);
            fail("");
        } catch (NullPointerException ex) {

        }
        try {
            new OpbDataObjectCreatedListenerImpl(null, scalarResultCache);
            fail("");
        } catch (NullPointerException ex) {

        }
        new OpbDataObjectCreatedListenerImpl(connectionProvider, scalarResultCache);

    }

    /**
     * Test of dataObjectCreated method, of class OpbDataObjectCreatedListenerImpl.
     */
    public void testDataObjectCreated() {
        System.out.println("dataObjectCreated");
        Class requestedType = null;
        Object dataObject = null;
        boolean cached = false;
        OpbDataObjectCreatedListenerImpl instance =
                new OpbDataObjectCreatedListenerImpl(connectionProvider, scalarResultCache);

        try {
            instance.dataObjectCreated(requestedType, dataObject, cached);
            fail("");
        } catch (NullPointerException ex) {

        }

        dataObject = new Object();
        instance.dataObjectCreated(requestedType, dataObject, cached);

        dataObject = new MockOpbObject();
        instance.dataObjectCreated(requestedType, dataObject, cached);

        MockOpbObject mockOpbObject = (MockOpbObject) dataObject;
        assertEquals(connectionProvider, mockOpbObject.provider);
        assertEquals(scalarResultCache, mockOpbObject.cache);

    }

    /**
     * Test of toString method, of class OpbDataObjectCreatedListenerImpl.
     */
    public void testToString() {
        System.out.println("toString");
        OpbDataObjectCreatedListenerImpl instance =
                new OpbDataObjectCreatedListenerImpl(connectionProvider, scalarResultCache);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    static class MockOpbObject implements OpbActiveDataObject, OpbScalarResultCacheUser {
        OpbDataObjectSource source;
        public void setOpbDataObjectSource(OpbDataObjectSource source) {
            this.source = source;
        }
        OpbConnectionProvider provider;
        public void setOpbConnectionProvider(OpbConnectionProvider provider) {
            this.provider = provider;
        }
        OpbScalarResultCache cache;
        public void setOpbScalarResultCache(OpbScalarResultCache cache) {
            this.cache = cache;
        }

    }

}
