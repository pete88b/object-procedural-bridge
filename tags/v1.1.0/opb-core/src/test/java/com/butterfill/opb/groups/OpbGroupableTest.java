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


package com.butterfill.opb.groups;

import junit.framework.*;
import com.butterfill.opb.session.OpbSession;

/**
 *
 * @author Peter Butterfill
 */
public class OpbGroupableTest extends TestCase {
    
    public OpbGroupableTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbGroupableTest.class);
        
        return suite;
    }

    /**
     * Test of setGroupManagerMap method, of class com.butterfill.opb.groups.OpbGroupable.
     */
    public void testSetGroupManagerMap() {
        System.out.println("setGroupManagerMap");
        
        OpbGroupManagerMap map = null;
        OpbGroupable instance = new OpbGroupableImpl();
        
        instance.setGroupManagerMap(map);
        
        assertNull(instance.getGroupManagerMap());
        
        OpbGroupManager manager = new OpbGroupManager();
        map = manager.newGroupManagerMap(instance);
        
        instance.setGroupManagerMap(map);
        
        assertEquals(map, instance.getGroupManagerMap());
        
        instance.setGroupManagerMap(null);
        
        assertNull(instance.getGroupManagerMap());
        
    }

    /**
     * Test of getGroupManagerMap method, of class com.butterfill.opb.groups.OpbGroupable.
     */
    public void testGetGroupManagerMap() {
        System.out.println("getGroupManagerMap");
        
        OpbGroupable instance = new OpbGroupableImpl();
        
        OpbGroupManagerMap expResult = null;
        OpbGroupManagerMap result = instance.getGroupManagerMap();
        assertEquals(expResult, result);
        
        instance.setGroupManagerMap(expResult);
        
        assertNull(instance.getGroupManagerMap());
        
        OpbGroupManager manager = new OpbGroupManager();
        expResult = manager.newGroupManagerMap(instance);
        
        instance.setGroupManagerMap(expResult);
        
        assertEquals(expResult, instance.getGroupManagerMap());
        
        instance.setGroupManagerMap(null);
        
        assertNull(instance.getGroupManagerMap());
        
    }

    /**
     * Generated implementation of abstract class com.butterfill.opb.groups.OpbGroupable. Please fill dummy bodies of generated methods.
     */
    private class OpbGroupableImpl implements OpbGroupable {

        private OpbGroupManagerMap _map;
        
        public void setGroupManagerMap(com.butterfill.opb.groups.OpbGroupManagerMap map) {
            _map = map;
            
        }

        public com.butterfill.opb.groups.OpbGroupManagerMap getGroupManagerMap() {
            return _map;
        }
    }

    
}
