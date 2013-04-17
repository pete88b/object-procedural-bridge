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


package com.butterfill.opb;

import com.butterfill.opb.ext.TestInterface3Impl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class OpbObjectSourceImplTest extends TestCase {

    public OpbObjectSourceImplTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbObjectSourceImplTest.class);
        return suite;
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
     * Test of newInstance method, of class OpbDefaultObjectSource.
     */
    public void testNewInstance() {
        System.out.println("newInstance");

        OpbObjectSourceImpl instance = new OpbObjectSourceImpl();
        try {
            instance.newInstance(Object.class);
            fail("There is no ObjectImpl class");
        } catch (OpbException ex) {
            assertTrue(ex.getMessage().indexOf("Class not found") != -1);
        }

        // get an instance of the TestInterface class
        TestInterface ti = instance.newInstance(TestInterface.class);
        // check we have a not-null instance and check we got the correct implementation
        assertTrue(ti instanceof TestInterfaceImpl);

        try {
            instance.newInstance(TestInterface2.class);
            fail("TestInterface2Impl.class can be found but it doesn't implement TestInterface2");
        } catch (OpbException ex) {
            assertTrue(ex.getMessage().indexOf("does not implement") != -1);
        }

        // get an instance of the TestInterface3 class
        TestInterface3 ti3 = instance.newInstance(TestInterface3.class);
        // check we have a not-null instance and check we got the correct implementation
        // from the .ext package
        assertTrue(ti3 instanceof TestInterface3Impl);

        try {
            instance.newInstance(TestInterface4.class);
            fail("TestInterface4impl has a private constructor - so we should not have access");
        } catch (OpbException ex) {
            assertTrue(ex.getCause().getMessage().indexOf("can not access") != -1);
        }

        // test the creation of a class with no package
        // this will fail because RootSuiteImpl does not exist
        try {
            Class c = Class.forName("RootSuite");
            instance.newInstance(c);
            fail();
        } catch (OpbException ex) {
            assertTrue(ex.getMessage().indexOf(
                    "failed to create new instance of a RootSuiteImpl") != -1);
            assertTrue(ex.getMessage().indexOf("Class not found") != -1);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("failed to get class for RootSuite", ex);
        }

    }

}
