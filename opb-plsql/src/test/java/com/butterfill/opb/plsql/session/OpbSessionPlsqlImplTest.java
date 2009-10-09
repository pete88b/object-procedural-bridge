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
import com.butterfill.opb.OpbException;
import com.butterfill.opb.OpbId;
import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbCacheableEntity;
import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.session.*;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.groups.OpbGroupable;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.groups.OpbGroupManagerMap;
import com.butterfill.opb.plsql.messages.OpbMessages;
import com.butterfill.opb.timing.OpbEventTimerProvider;
import com.butterfill.opb.timing.OpbTimingEventPublisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;
import com.butterfill.opb.util.OpbScalarResultCache;
import helpers.TestHelper;
import java.util.List;
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
        String contextName = "";
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbDataObjectSource dataObjectSource = new TestDataObjectSource();
        OpbGroupManager groupManager = new OpbGroupManager();
        OpbScalarResultCache scalarResultCache = new OpbScalarResultCache();
        OpbEventTimer eventTimer = new OpbEventTimer();
        
        instance = new OpbSessionPlsqlImpl(
                contextName, dataSource, dataObjectSource, 
                groupManager, scalarResultCache, eventTimer);
                
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbSessionPlsqlImplTest.class);
        
        return suite;
    }

    public void testConstructor() {
        String contextName = "cn-session";
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbDataObjectSource dataObjectSource = new TestDataObjectSource();
        OpbGroupManager groupManager = new OpbGroupManager();
        OpbScalarResultCache scalarResultCache = new OpbScalarResultCache();
        OpbEventTimer eventTimer = new OpbEventTimer();
        
        try {
            new OpbSessionPlsqlImpl(null, dataSource, dataObjectSource, 
                    groupManager, scalarResultCache, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbSessionPlsqlImpl(contextName, null, dataObjectSource, 
                    groupManager, scalarResultCache, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbSessionPlsqlImpl(contextName, dataSource, null, 
                    groupManager, scalarResultCache, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbSessionPlsqlImpl(contextName, dataSource, dataObjectSource, 
                    null, scalarResultCache, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbSessionPlsqlImpl(contextName, dataSource, dataObjectSource, 
                    groupManager, null, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbSessionPlsqlImpl(contextName, dataSource, dataObjectSource, 
                    groupManager, scalarResultCache, null);
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbSession session = new OpbSessionPlsqlImpl(
                contextName, dataSource, dataObjectSource, 
                groupManager, scalarResultCache, eventTimer);
        
        assertNull(session.getId());
        session.createSession();
        assertNotNull(session.getId());
        session.endSession();
        
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
     * Test of getId method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetId() {
        System.out.println("getId");
        
        
        String result = instance.getId();
        assertNull(result);
        instance.createSession();
        assertNotNull(instance.getId());
        instance.endSession();
    }

    /**
     * Test of createSession method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testCreateSession() throws Exception {
        System.out.println("createSession");
        
        assertNull(instance.getId());
        instance.createSession();
        assertNotNull(instance.getId());
        
        try {
            // can't start a session that's started
            instance.createSession();
            fail();
        } catch (IllegalArgumentException ex) {
            //ok
        }
        
        instance.endSession();
        
    }

    /**
     * Test of endSession method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testEndSession() throws Exception {
        System.out.println("endSession");
        
        try {
            // can't end a session that's not started
            instance.endSession();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        instance.createSession();
        instance.endSession();
        try {
            // can't end a session that's ended
            instance.endSession();
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
    }

    public void testGetMemoryLimitForCachedObjects() {
        System.out.println("getMemoryLimitForCachedObjects");

        assertNull(instance.getMemoryLimitForCachedObjects());
    }

    public void testGetMemoryLimitForCachedResults() {
        System.out.println("getMemoryLimitForCachedResults");

        assertEquals((Float) 0.9F, instance.getMemoryLimitForCachedResults());
    }

    /**
     * Test of checkMemoryUse method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testCheckMemoryUse() {
        System.out.println("checkMemoryUse");
        
        instance.checkMemoryUse();
        
        instance.setMemoryLimitForCachedResults(0.9F);
        instance.checkMemoryUse();
        
        instance.setMemoryLimitForCachedObjects(0.0F);
        instance.checkMemoryUse();
        TestDataObjectSource dos = 
                (TestDataObjectSource)instance.getDataObjectSource();
        assertTrue(dos.clearCachedCalled);
        assertFalse(dos.clearCachedResultsCalled);
        
        instance.setMemoryLimitForCachedObjects(999.0F);
        instance.setMemoryLimitForCachedResults(0.0F);
        dos.clearCachedCalled = false;
        
        instance.checkMemoryUse();
        assertFalse(dos.clearCachedCalled);
        assertTrue(dos.clearCachedResultsCalled);
        
        dos.clearCachedCalled = false;
        dos.clearCachedResultsCalled = false;
        
        instance.setMemoryLimitForCachedObjects(0.0F);
        
        instance.checkMemoryUse();
        assertTrue(dos.clearCachedCalled);
        // result caches are cleared by the clearCached() call
        // so clearCachedResults does not need to be called.
        assertFalse(dos.clearCachedResultsCalled);
        
    }

    /**
     * Test of getConnection method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        
        try {
            instance.getConnection();
            fail();
        } catch (OpbException ex) {
            //ok
        }
        
        instance.createSession();
        
        Connection result = instance.getConnection();
        assertNotNull(result);
        
        for (int i = 0; i < 99; i++) {
            Connection connection2 = instance.getConnection();
            assertSame(result, connection2);
        }
        
        instance.endSession();
        
        try {
            instance.getConnection();
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        logger.warning(
                "################# " +
                "'WARNING: Connection is in use by another thread' " +
                "should follow");
        
        instance.createSession();
        
        instance.getConnection();
        
        new Thread(new Runnable() {
            public void run() {
                instance.getConnection();
            }
        }).start();
        
        Thread.sleep(500);
        
        logger.warning("#################");
        
        instance.endSession();
        
    }

    /**
     * Test of releaseConnection method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testReleaseConnection() throws Exception {
        System.out.println("releaseConnection");
        
        TestDataObjectSource dos = 
                (TestDataObjectSource)instance.getDataObjectSource();
        
        instance.releaseConnection(true);
        
        assertFalse(dos.clearCachedCalled);
        
        instance.setMemoryLimitForCachedObjects(0.0F);
        
        instance.releaseConnection(true);
        
        assertTrue(dos.clearCachedCalled);
        
        instance.releaseConnection(true);
        
        instance.createSession();
        instance.releaseConnection(true);
        
        Connection con = instance.getConnection();
        
        assertFalse(con.isClosed());
        
        instance.releaseConnection(true);
        assertTrue(con.isClosed());
        
        OpbMessages messages = 
                instance.getDataObjectSource().newInstance(OpbMessages.class);
        messages.addSessionMessage(OpbMessages.MESSAGE_LEVEL_INFO, "s", "d");
        
        for (int i=0; i<9; i++) {
            instance.releaseConnection(false);
            assertFalse(messages.getSessionMessages().isEmpty());
        }
        
        for (int i=0; i<9; i++) {
            messages.addSessionMessage(OpbMessages.MESSAGE_LEVEL_INFO, "s", "d");
            assertFalse(messages.getSessionMessages().isEmpty());
            instance.releaseConnection(true);
            assertTrue(messages.getSessionMessages().isEmpty());
        }
        
        instance.endSession();
        
    }

    /**
     * Test of getUsername method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetUsername() {
        System.out.println("getUsername");
        
        assertNull(instance.getUsername());
        
        // see also setUsername(String) tests
        
    }

    /**
     * Test of setUsername method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testSetUsername() throws Exception {
        System.out.println("setUsername");
        
        try {
            instance.setUsername(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        assertNull(instance.getUsername());
        
        try {
            instance.setUsername("name");
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        assertNull(instance.getUsername());
        
        instance.createSession();
        try {
            instance.setUsername(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        assertNull(instance.getUsername());
        
        instance.setUsername("user");
        assertEquals("user", instance.getUsername());
        
        try {
            instance.setUsername(null);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        assertEquals("user", instance.getUsername());
        
        instance.endSession();
        
    }

    /**
     * Test of getAttributes method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetAttributes() {
        System.out.println("getAttributes");
        
        Map<Object, Object> expResult = instance.getAttributes();
        Map<Object, Object> result = instance.getAttributes();
        assertSame(expResult, result);
        
    }

    /**
     * Test of getGroupManager method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetGroupManager() {
        System.out.println("getGroupManager");
        
        assertNotNull(instance.getGroupManager());
        assertSame(instance.getGroupManager(), instance.getGroupManager());
        
    }

    
    /**
     * Test of getScalarResultCache method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetScalarResultCache() {
        System.out.println("getScalarResultCache");
        
        assertNotNull(instance.getScalarResultCache());
        assertSame(instance.getScalarResultCache(), instance.getScalarResultCache());
        
    }

    
    /**
     * Test of getDataObjectSource method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetDataObjectSource() {
        System.out.println("getDataObjectSource");
        
        assertNotNull(instance.getDataObjectSource());
        assertSame(instance.getDataObjectSource(), instance.getDataObjectSource());
        
    }

    /**
     * Test of dataObjectCreated method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testDataObjectCreated() {
        System.out.println("dataObjectCreated");
        
        Object dataObject = null;
        boolean cached = true;
        
        try {
            instance.dataObjectCreated(Object.class, dataObject, cached);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        dataObject = new ActiveDataObjectImpl();
        instance.dataObjectCreated(ActiveDataObject.class, dataObject, cached);
        assertSame(((ActiveDataObject)dataObject).getProvider(), instance);
        
        dataObject = new TimingEventPublisher();
        instance.dataObjectCreated(ActiveDataObject.class, dataObject, cached);
        assertSame(((TimingEventPublisher)dataObject).provider, instance);
        
        dataObject = new Groupable();
        
        instance.dataObjectCreated(ActiveDataObject.class, dataObject, cached);
        assertNotNull(((Groupable)dataObject).map);
        assertNotNull(((Groupable)dataObject).getGroupManagerMap());
        
        dataObject = new GroupableCacheableImpl(); // cacheable groupable data object
        assertNull(((GroupableCacheable)dataObject).getGroupManagerMap());
        instance.getGroupManager().removeAllGroups();
        instance.dataObjectCreated(GroupableCacheable.class, dataObject, cached);
        assertNotNull(((GroupableCacheable)dataObject).getGroupManagerMap());
        assertNotNull(((GroupableCacheable)dataObject).getGroupManagerMap());
        
    }

    public void testGroupsAfterDataObjectCreated() throws Exception {
        
        String singleGroup = "singleTestGroup";
        String multipleGroup = "multipleGroup";
        
        OpbDataObjectSource dos = instance.getDataObjectSource();
        OpbGroupManager groupManager = instance.getGroupManager();
        
        ResultSet rs = TestHelper.getResultSet(
                "SELECT 'a' AS a from dual");
        
        GroupableCacheable dataObject = null;
        
        List<GroupableCacheable> result = dos.getResult(
                GroupableCacheable.class, rs, true);
        
        dataObject = result.get(0);
        
        OpbGroupManagerMap map = dataObject.getGroupManagerMap();
        
        assertNotNull(map);
        
        map.put(singleGroup, true);
        assertTrue(groupManager.isMember(singleGroup, dataObject));
        
        assertTrue(dos.isCached(GroupableCacheable.class, dataObject.getOpbId()));
        
        dos.clearCached();
        assertFalse(groupManager.isMember(singleGroup, dataObject));
        
    }
    
    /**
     * Test of getOpbEventTimer method, of class com.butterfill.opb.session.OpbSessionPlsqlImpl.
     */
    public void testGetOpbEventTimer() throws Exception {
        System.out.println("getOpbEventTimer");
        
        assertNotNull(instance.getOpbEventTimer());
        assertSame(instance.getOpbEventTimer(), instance.getOpbEventTimer());
        
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
    
    static class TimingEventPublisher implements OpbTimingEventPublisher {
        public OpbEventTimerProvider provider;
        public void setOpbEventTimerProvider(OpbEventTimerProvider provider) {
            this.provider = provider;
        }    
    }
    
    static class Groupable implements OpbGroupable {
        public OpbGroupManagerMap map;
        public void setGroupManagerMap(OpbGroupManagerMap map) {
            this.map = map;
        }
        public OpbGroupManagerMap getGroupManagerMap() {
            return map;
        }
    }
    
    public static interface GroupableCacheable extends OpbGroupable, OpbCacheableEntity {
    }
    
    public static class GroupableCacheableImpl implements GroupableCacheable {
        
        private OpbGroupManagerMap _map;
        private OpbId _opbId;
        private String a;
        
        public void setGroupManagerMap(OpbGroupManagerMap map) {
            this._map = map;
        }
        
        public OpbGroupManagerMap getGroupManagerMap() {
            return _map;
        }
        
        public OpbId getOpbId() {
            return _opbId;
        }
        
        public void opbLoad(ResultSet resultSet) throws OpbDataAccessException {
            try {
                a = resultSet.getString("a");
            } catch (SQLException ex) {
                throw new OpbDataAccessException(
                        "failed to load GroupableCacheableImpl", ex);
            }
            _opbId = new OpbId(a);
        }
        
    }
    
}
