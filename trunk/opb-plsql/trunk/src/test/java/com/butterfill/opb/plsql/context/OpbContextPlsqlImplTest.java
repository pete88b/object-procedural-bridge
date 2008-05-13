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

package com.butterfill.opb.plsql.context;

import junit.framework.*;
import com.butterfill.opb.context.*;
import com.butterfill.opb.timing.OpbEventTimer;
import helpers.TestHelper;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Peter Butterfill
 */
public class OpbContextPlsqlImplTest extends TestCase {
    
    private static final Logger logger = Logger.getLogger(
            OpbContextPlsqlImplTest.class.getName());
    
    OpbContextPlsqlImpl instance;
    
    public OpbContextPlsqlImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        String contextName = "";
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbEventTimer eventTimer = new OpbEventTimer();
        
        instance = new OpbContextPlsqlImpl(
                contextName, dataSource, eventTimer);
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbContextPlsqlImplTest.class);
        
        return suite;
    }

    public void testConstructor() {
        String contextName = "tc";
        OracleDataSource dataSource = TestHelper.getSharedOracleDataSource();
        OpbEventTimer eventTimer = new OpbEventTimer();
        
        try {
            new OpbContextPlsqlImpl(null, dataSource, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }

        try {
            new OpbContextPlsqlImpl(contextName, null, eventTimer);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbContextPlsqlImpl(contextName, dataSource, null);
            fail();
        } catch (NullPointerException ex) {
        }
        
        OpbContext ctx = 
                new OpbContextPlsqlImpl(contextName, dataSource, eventTimer);
        assertEquals(contextName, ctx.getContextName());
        
        try {
            new OpbContextPlsqlImpl(null, dataSource, eventTimer, false);
            fail();
        } catch (NullPointerException ex) {
        }

        try {
            new OpbContextPlsqlImpl(contextName, null, eventTimer, false);
            fail();
        } catch (NullPointerException ex) {
        }
        
        try {
            new OpbContextPlsqlImpl(contextName, dataSource, null, false);
            fail();
        } catch (NullPointerException ex) {
        }
        
        ctx = new OpbContextPlsqlImpl(contextName, dataSource, eventTimer, false);
        assertEquals(contextName, ctx.getContextName());
        
    }
    
    /**
     * Test of toString method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
    public void testToString() {
        System.out.println("toString");
        
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getContextName method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
    public void testGetContextName() {
        System.out.println("getContextName");
        
        String expResult = "";
        String result = instance.getContextName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLocalUsername method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testGetLocalUsername() {
//        System.out.println("getLocalUsername");
//        
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        String expResult = System.getProperty("user.name");
//        String result = instance.getLocalUsername();
//        assertEquals(expResult, result);
//        assertNotNull(result);
//        
//    }

    /**
     * Test of getLocalHost method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testGetLocalHost() throws Exception {
//        System.out.println("getLocalHost");
//        
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        String expResult = InetAddress.getLocalHost().toString();
//        String result = instance.getLocalHost();
//        assertEquals(expResult, result);
//        assertNotNull(result);
//        
//    }

    /**
     * Test of startContext method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
    public void testStartContext() throws Exception {
        System.out.println("startContext");
        
        for (int i=0; i<99; i++) {
            instance.startContext(true);
            instance.startContext(false);
        }
        
    }

    /**
     * Test of stopContext method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
    public void testStopContext() throws Exception {
        System.out.println("stopContext");
        
        instance.stopContext();
        
        for (int i = 0; i < 90; i++) {
            instance.stopContext();
        }
        
    }

    /**
     * Test of initDataSource method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testInitDataSource() throws Exception {
//        System.out.println("initDataSource");
//        
//        Properties dataSourceProperties = null;
//        Properties connectionCacheProperties = null;
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        try {
//            instance.initDataSource(dataSourceProperties, connectionCacheProperties);
//            fail();
//        } catch (NullPointerException ex) {
//            //ok
//        }
//        
//        dataSourceProperties = new Properties();
//        try {
//            instance.initDataSource(dataSourceProperties, connectionCacheProperties);
//            fail();
//        } catch (OpbException ex) {
//            assertTrue(ex.getCause().getMessage().indexOf("url") != -1);
//        }
//        
//        dataSourceProperties.setProperty("url", "bobins");
//        try {
//            instance.initDataSource(dataSourceProperties, connectionCacheProperties);
//            fail();
//        } catch (OpbException ex) {
//            assertTrue(ex.getCause().getMessage().indexOf("user") != -1);
//        }
//        
//        dataSourceProperties.setProperty("user", "bobins");
//        try {
//            instance.initDataSource(dataSourceProperties, connectionCacheProperties);
//            fail();
//        } catch (OpbException ex) {
//            assertTrue(ex.getCause().getMessage().indexOf("password") != -1);
//        }
//        
//        dataSourceProperties.setProperty("password", "bobins");
//        try {
//            instance.initDataSource(dataSourceProperties, connectionCacheProperties);
//            fail();
//        } catch (OpbException ex) {
//            assertTrue(ex.getMessage().indexOf("Failed to get test con") != -1);
//        }
//        
//        dataSourceProperties = TestSuiteHelper.getInstance().getDatasourceProperties();
//        instance.initDataSource(dataSourceProperties, connectionCacheProperties);
//        
//    }

    /**
     * Test of closeDataSource method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testCloseDataSource() throws Exception {
//        System.out.println("closeDataSource");
//        
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        try {
//            instance.closeDataSource();
//            
//            instance.initDataSource(
//                    TestSuiteHelper.getInstance().getDatasourceProperties(),
//                    null);
//            instance.closeDataSource();
//            
//            instance.initDataSource(
//                    TestSuiteHelper.getInstance().getDatasourceProperties(),
//                    null);
//            instance.getRawConnection().close();
//            instance.closeDataSource();
//            try {
//                instance.getRawConnection();
//                fail();
//            } catch (NullPointerException ex) {
//                //ok
//            }
//            
//        } catch (Exception ex) {
//            instance.initDataSource(
//                    TestSuiteHelper.getInstance().getDatasourceProperties(),
//                    null);
//            
//        }
//        
//    }

    /**
     * Test of checkDataSource method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testCheckDataSource() {
//        System.out.println("checkDataSource");
//        
//        OpbContextPlsqlImpl instance = 
//                (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        try {
//            instance.checkDataSource();
//            fail();
//        } catch (NullPointerException ex) {
//            //ok
//        }
//        
//        instance = 
//                (OpbContextPlsqlImpl)TestSuiteHelper.getInstance().getOpbContext();
//        
//        instance.checkDataSource();
//    }

    /**
     * Test of getRawConnection method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testGetRawConnection() throws Exception {
//        System.out.println("getRawConnection");
//        
//        OpbContextPlsqlImpl instance = 
//                (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        try {
//            instance.getRawConnection();
//            fail();
//        } catch (NullPointerException ex) {
//            //ok;
//        }
//        
//        try {
//            instance.getRawConnection("x", "x");
//            fail();
//        } catch (NullPointerException ex) {
//            //ok;
//        }
//        
//        instance = 
//                (OpbContextPlsqlImpl)TestSuiteHelper.getInstance().getOpbContext();
//        
//        instance.getRawConnection().close();
//        
//        try {
//            instance.getRawConnection("x", "x");
//            fail();
//        } catch (OpbException ex) {
//            //ok;
//        }
//        Properties p = TestSuiteHelper.getInstance().getDatasourceProperties();
//        
//        instance.getRawConnection(
//                p.getProperty("user"), p.getProperty("password")).close();
//        
//    }

    /**
     * Test of getOpbEventTimer method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testGetOpbEventTimer() {
//        System.out.println("getOpbEventTimer");
//        
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        OpbEventTimer expResult = instance.getOpbEventTimer();
//        OpbEventTimer result = instance.getOpbEventTimer();
//        assertSame(expResult, result);
//        assertNotNull(result);
//        
//    }

    /**
     * Test of isTrimDomainFromUsername method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
     */
//    public void testIsTrimDomainFromUsername() {
//        System.out.println("isTrimDomainFromUsername");
//        
//        OpbContextPlsqlImpl instance = 
//                (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        boolean expResult = true;
//        boolean result = instance.isTrimDomainFromUsername();
//        assertEquals(expResult, result);
//        
//        instance.setTrimDomainFromUsername(true);
//        result = instance.isTrimDomainFromUsername();
//        assertEquals(expResult, result);
//        
//        expResult = false;
//        instance.setTrimDomainFromUsername(false);
//        result = instance.isTrimDomainFromUsername();
//        assertEquals(expResult, result);
//        
//        
//        
//    }
//
//    /**
//     * Test of setTrimDomainFromUsername method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
//     */
//    public void testSetTrimDomainFromUsername() {
//        System.out.println("setTrimDomainFromUsername");
//        
//        OpbContextPlsqlImpl instance = 
//                (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        for (int i = 0; i < 9; i++) {
//            instance.setTrimDomainFromUsername(true);
//            assertTrue(instance.isTrimDomainFromUsername());
//            instance.setTrimDomainFromUsername(false);
//            assertFalse(instance.isTrimDomainFromUsername());
//
//        }
//        
//    }
//
//    /**
//     * Test of getMemoryLimitForCachedObjects method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
//     */
//    public void testGetMemoryLimitForCachedObjects() {
//        System.out.println("getMemoryLimitForCachedObjects");
//        
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        float expResult = 999.0F;
//        float result = instance.getMemoryLimitForCachedObjects();
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of setMemoryLimitForCachedObjects method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
//     */
//    public void testSetMemoryLimitForCachedObjects() {
//        System.out.println("setMemoryLimitForCachedObjects");
//        
//        float limit = 0.0F;
//        OpbContextPlsqlImpl instance = 
//                (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        instance.setMemoryLimitForCachedObjects(limit);
//        assertEquals(limit, instance.getMemoryLimitForCachedObjects());
//        
//        limit = 987.0F;
//        instance.setMemoryLimitForCachedObjects(limit);
//        assertEquals(limit, instance.getMemoryLimitForCachedObjects());
//        
//    }
//
//    /**
//     * Test of getMemoryLimitForCachedResults method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
//     */
//    public void testGetMemoryLimitForCachedResults() {
//        System.out.println("getMemoryLimitForCachedResults");
//        
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        float expResult = 0.9F;
//        float result = instance.getMemoryLimitForCachedResults();
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of setMemoryLimitForCachedResults method, of class com.butterfill.opb.context.OpbContextPlsqlImpl.
//     */
//    public void testSetMemoryLimitForCachedResults() {
//        System.out.println("setMemoryLimitForCachedResults");
//        
//        float limit = 0.0F;
//        OpbContextPlsqlImpl instance = (OpbContextPlsqlImpl)OpbContextSource.getContext("");
//        
//        instance.setMemoryLimitForCachedResults(limit);
//        assertEquals(limit, instance.getMemoryLimitForCachedResults());
//        
//        limit = 3453456.4F;
//        instance.setMemoryLimitForCachedResults(limit);
//        assertEquals(limit, instance.getMemoryLimitForCachedResults());
//        
//    }
//    
}
