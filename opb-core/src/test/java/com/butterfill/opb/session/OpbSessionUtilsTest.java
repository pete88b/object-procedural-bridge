/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.butterfill.opb.session;

import com.butterfill.opb.OpbException;
import com.butterfill.opb.OpbId;
import com.butterfill.opb.OpbObjectSource;
import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbCacheableEntity;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.groups.OpbGroupManagerMap;
import com.butterfill.opb.groups.OpbGroupable;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.timing.OpbEventTimerProvider;
import com.butterfill.opb.timing.OpbTimingEventPublisher;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbScalarResultCacheProvider;
import com.butterfill.opb.util.OpbScalarResultCacheUser;
import com.butterfill.opb.util.OpbToStringHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import junit.framework.TestCase;

/**
 *
 * @author Butterp
 */
public class OpbSessionUtilsTest extends TestCase {

    Class requestedType;
    Object dataObject;
    boolean cached;
    OpbObjectSource objectSource;
    OpbDataObjectSource dataObjectSource;
    OpbGroupManager groupManager;
    OpbConnectionProvider connectionProvider;
    OpbEventTimerProvider eventTimerProvider;
    OpbScalarResultCacheProvider scalarResultCacheProvider;

    OpbSession session;

    public OpbSessionUtilsTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        requestedType = null;
        dataObject = null;
        cached = false;
        objectSource = null;
        dataObjectSource = null;
        groupManager = null;
        connectionProvider = null;
        eventTimerProvider = null;
        scalarResultCacheProvider = null;

        session = null;

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private void nullArgumentPassedToDataObjectCreated(final String exMessageContains) {
        try {
            OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

            fail();

        } catch (NullPointerException ex) {
            assertTrue(ex.getMessage().contains(exMessageContains));

        }

    }

    /**
     * Test of dataObjectCreated method, of class OpbSessionUtils.
     */
    public void testDataObjectCreated() {
        System.out.println("dataObjectCreated");

        nullArgumentPassedToDataObjectCreated("requestedType");

        requestedType = Object.class;

        nullArgumentPassedToDataObjectCreated("dataObject");
        
        dataObject = new Object();

        nullArgumentPassedToDataObjectCreated("dataObjectSource");

        objectSource = new OpbObjectSourceImpl();
        dataObjectSource = new OpbDataObjectSource(objectSource);

        nullArgumentPassedToDataObjectCreated("groupManager");

        groupManager = new OpbGroupManager();

        

        connectionProvider = new OpbConnectionProvider() {
            public Connection getConnection() throws OpbException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        eventTimerProvider = new OpbEventTimerProvider() {
            public OpbEventTimer getOpbEventTimer() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        scalarResultCacheProvider = new OpbScalarResultCacheProvider() {
            public OpbScalarResultCache getScalarResultCache() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        requestedType = MockActiveDataObject.class;
        dataObject = new MockActiveDataObject();

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        assertSame(connectionProvider, ((MockActiveDataObject) dataObject).provider);


        requestedType = MockTimingEventPublisher.class;
        dataObject = new MockTimingEventPublisher();

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        assertSame(eventTimerProvider, ((MockTimingEventPublisher) dataObject).provider);


        requestedType = MockScalarResultCacheUser.class;
        dataObject = new MockScalarResultCacheUser();

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        assertSame(scalarResultCacheProvider, ((MockScalarResultCacheUser) dataObject).provider);


        requestedType = MockGroupable.class;
        dataObject = new MockGroupable();

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        assertNotNull(((MockGroupable) dataObject).getGroupManagerMap());

        ((MockGroupable) dataObject).setGroupManagerMap(null);

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, true, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        assertNotNull(((MockGroupable) dataObject).getGroupManagerMap());


        requestedType = MockGroupableCacheableEntity.class;
        dataObject = new MockGroupableCacheableEntity();

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, cached, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        // get the group manage map from the data object
        OpbGroupManagerMap map =
                ((MockGroupableCacheableEntity) dataObject).getGroupManagerMap();
        // make sure it's not null
        assertNotNull(map);
        // make the data object a member of a group called "testGroup"
        map.put("testGroup", true);
        // make sure the data object is a member of a group called "testGroup"
        assertSame(dataObject, groupManager.getMember("testGroup"));

        ((MockGroupableCacheableEntity) dataObject).setGroupManagerMap(null);

        OpbSessionUtils.dataObjectCreated(
                    requestedType, dataObject, true, dataObjectSource,
                    groupManager, connectionProvider, eventTimerProvider,
                    scalarResultCacheProvider);

        // get the group manage map from the data object
        map = ((MockGroupableCacheableEntity) dataObject).getGroupManagerMap();
        // make sure it's not null
        assertNotNull(map);
        // make the data object a member of a group called "testGroup"
        map.put("testGroup", true);
        // make sure the data object is NOT a member of a group called "testGroup"
        // as it's cacheable, the group manager should try to get the member from the
        // data object source -
        // as this data object did NOT come from the data object source, we expect null
        assertNull(groupManager.getMember("testGroup"));

    }

    static class MockActiveDataObject implements OpbActiveDataObject {
        OpbDataObjectSource source;
        public void setOpbDataObjectSource(OpbDataObjectSource source) {
            this.source = source;
        }

        OpbConnectionProvider provider;
        public void setOpbConnectionProvider(OpbConnectionProvider provider) {
            this.provider = provider;
        }

    }


    static class MockTimingEventPublisher implements OpbTimingEventPublisher {

        OpbEventTimerProvider provider;
        public void setOpbEventTimerProvider(OpbEventTimerProvider provider) {
            this.provider = provider;
        }

    }


    static class MockScalarResultCacheUser implements OpbScalarResultCacheUser {

        OpbScalarResultCacheProvider provider;
        public void setOpbScalarResultCacheProvider(OpbScalarResultCacheProvider provider) {
            this.provider = provider;
        }

    }


    static class MockGroupable implements OpbGroupable {
        OpbGroupManagerMap map;
        public void setGroupManagerMap(OpbGroupManagerMap map) {
            this.map = map;
        }

        public OpbGroupManagerMap getGroupManagerMap() {
            return map;
        }

    }


    static class MockGroupableCacheableEntity implements OpbGroupable, OpbCacheableEntity {
        OpbGroupManagerMap map;
        public void setGroupManagerMap(OpbGroupManagerMap map) {
            this.map = map;
        }

        public OpbGroupManagerMap getGroupManagerMap() {
            return map;
        }

        public void opbLoad(ResultSet resultSet) throws OpbDataAccessException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        OpbId opbId = new OpbId("testId");
        public OpbId getOpbId() {
            return opbId;
        }

    }


    public void testCheckMemoryUse() {
        System.out.println("checkMemoryUse");
        
        OpbSessionUtils.checkMemoryUse(null, null, null);
        
        objectSource = new OpbObjectSourceImpl();
        dataObjectSource = new OpbDataObjectSource(objectSource);
        
        OpbSessionUtils.checkMemoryUse(null, null, dataObjectSource);

        OpbSessionUtils.checkMemoryUse(0F, null, dataObjectSource);

        OpbSessionUtils.checkMemoryUse(null, 0F, dataObjectSource);

        OpbSessionUtils.checkMemoryUse(0F, 0F, dataObjectSource);

        OpbSessionUtils.checkMemoryUse(0.9F, null, dataObjectSource);

        OpbSessionUtils.checkMemoryUse(null, 0.9F, dataObjectSource);

        OpbSessionUtils.checkMemoryUse(0.9F, 0.9F, dataObjectSource);
        
    }

}
