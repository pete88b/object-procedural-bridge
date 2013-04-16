/*
 */
package com.butterfill.opb.plsql.data;

import com.butterfill.opb.data.OpbDataObjectCreatedListenerImpl;
import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImplTest;
import com.butterfill.opb.util.OpbScalarResultCache;
import helpers.TestHelper;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.fail;
import junit.framework.TestCase;

/**
 *
 * @author Butterp
 */
public class OpbDataObjectCreatedListenerPlsqlImplTest extends TestCase {

    OpbConnectionProvider connectionProvider =
            new OpbConnectionProviderPlsqlImpl(TestHelper.getSharedOracleDataSource());

    OpbDataObjectCreatedListenerImpl instance = new OpbDataObjectCreatedListenerImpl(
            connectionProvider, new OpbScalarResultCache());

    public OpbDataObjectCreatedListenerPlsqlImplTest(String testName) {
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
     * Test of toString method, of class OpbDataObjectCreatedListenerPlsqlImpl.
     */
    public void testToString() {
        System.out.println("toString");

        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of dataObjectCreated method, of class OpbDataObjectCreatedListenerPlsqlImpl.
     */
    public void testDataObjectCreated() {
        System.out.println("dataObjectCreated");
        Class requestedType = null;
        Object dataObject = null;
        boolean cached = false;
        try {
            instance.dataObjectCreated(requestedType, dataObject, cached);
            fail();
        } catch (NullPointerException ex) {
            // requested type must not be null
        }

        requestedType = ActiveDataObject.class;
        try {
            instance.dataObjectCreated(requestedType, dataObject, cached);
            fail();
        } catch (NullPointerException ex) {
            // data object must not be null
        }

        dataObject = new ActiveDataObjectImpl();
        instance.dataObjectCreated(requestedType, dataObject, cached);

    }

    /**
     * Test of dataObjectCreated method.
     */
    public void testDataObjectCreated2() {
        System.out.println("dataObjectCreated");

        Object dataObject = new ActiveDataObjectImpl();;
        boolean cached = true;

        instance.dataObjectCreated(ActiveDataObject.class, dataObject, cached);
        assertSame(((ActiveDataObject)dataObject).getProvider(), connectionProvider);

        dataObject = new OpbSessionPlsqlImplTest.CacheableImpl(); // cacheable data object
        instance.dataObjectCreated(OpbSessionPlsqlImplTest.Cacheable.class, dataObject, cached);

    }

    static interface ActiveDataObject extends OpbActiveDataObject {
        public void setOpbDataObjectSource(OpbDataObjectSource source);

        public void setOpbConnectionProvider(OpbConnectionProvider provider);

        public OpbDataObjectSource getSource();

        public OpbConnectionProvider getProvider();

    }

    static class ActiveDataObjectImpl implements ActiveDataObject {

        private OpbDataObjectSource source;
        public void setOpbDataObjectSource(OpbDataObjectSource source) {
            this.source = source;
        }

        private OpbConnectionProvider provider;
        public void setOpbConnectionProvider(OpbConnectionProvider provider) {
            this.provider = provider;
        }

        public OpbDataObjectSource getSource() {
            return source;
        }

        public OpbConnectionProvider getProvider() {
            return provider;
        }

    }

}
