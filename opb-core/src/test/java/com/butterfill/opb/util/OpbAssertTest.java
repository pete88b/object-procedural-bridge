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


package com.butterfill.opb.util;

import junit.framework.*;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbAssertTest extends TestCase {

    public OpbAssertTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbAssertTest.class);

        return suite;
    }

    /**
     * Test of notNull method, of class com.butterfill.opb.util.OpbAssert.
     */
    public void testNotNull() {
        System.out.println("notNull");

        Logger logger = null;
        String className = null;
        String methodName = null;
        String argName = null;
        Object arg = null;

        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg);
            fail("a null pointer ex should only be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }
        // a null pointer ex should not be thrown when arg is not null
        arg = "";
        OpbAssert.notNull(logger, className, methodName, argName, arg);

        className = "";
        methodName = "";
        argName = "";
        arg = null;
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg);
            fail("a null pointer ex should only be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }
        // a null pointer ex should not be thrown when arg is not null
        arg = 1;
        OpbAssert.notNull(logger, className, methodName, argName, arg);

        arg = null;
        logger = Logger.getLogger("TestClass");
        className = "TestClass";
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg);
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        methodName = "testMethod()";
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg);
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        argName = "testArg";
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg);
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        arg = new Object();
        OpbAssert.notNull(logger, className, methodName, argName, arg);

        try {
            OpbAssert.notNull(logger, className, methodName, argName, null);
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        OpbAssert.notNull(logger, className, methodName, argName, "arg");

        logger = null;
        className = null;
        methodName = null;
        argName = null;
        arg = null;

        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }
        arg = "";
        OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");

        className = "";
        methodName = "";
        argName = "";
        arg = null;
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }
        arg = 1;
        OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");

        arg = null;
        logger = Logger.getLogger("TestClass");
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        className = "TestClass";
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        methodName = "testMethod()";
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        argName = "testArg";
        try {
            OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        arg = new Object();
        OpbAssert.notNull(logger, className, methodName, argName, arg, "extra message info");

        try {
            OpbAssert.notNull(logger, className, methodName, argName, null, "extra message info");
            fail("a null pointer ex should be thrown when arg is null");
        } catch (NullPointerException ex) {
            //ok
        }

        OpbAssert.notNull(logger, className, methodName, argName, "arg", "extra message info");

    }

    /**
     * Test of notNull method, of class com.butterfill.opb.util.OpbAssert.
     */
    public void testIsNull() {
        System.out.println("isNull");

        Logger logger = null;
        String className = null;
        String methodName = null;
        String argName = null;
        Object arg = null;

        // ex should not be thrown when arg is null
        OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");

        arg = "";
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown only when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

        className = "";
        methodName = "";
        argName = "";
        arg = null;
        OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");

        arg = 2;
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

        arg = null;
        logger = Logger.getLogger("TestClass");
        OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");

        arg = "";
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

        arg = null;
        className = "TestClass";
        OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");

        arg = "";
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

        arg = null;
        methodName = "testMethod()";
        OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");

        arg = "";
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

        arg = null;
        argName = "testArg";
        OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");

        arg = "";
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

        arg = new Object();

        arg = "";
        try {
            OpbAssert.isNull(logger, className, methodName, argName, arg, "extra message info");
            fail("ex should be thrown when arg is not null");
        } catch (IllegalArgumentException ex) {
            //ok
        }

    }

    /**
     * Test of notEqual method, of class com.butterfill.opb.util.OpbAssert.
     */
    public void testNotEqual() {
        System.out.println("notEqual");

        for (int i = 0; i < 2; i++) {
            Logger logger = null;
            String className = "";
            String methodName = "";
            String argName = "";
            Object arg = null;
            String arg2Name = "";
            Object arg2 = null;
            String message = null;

            if (i == 1) {
                message = "xtr message";
            }

            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }
            arg = "";
            arg2 = arg;
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            arg2 = new Object();
            OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg = arg2;
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            arg = null;
            OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg = new Object();
            arg2 = null;
            OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg = "x";
            arg2 = "X";
            OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg = 9999;
            arg2 = 9999;
            assertTrue(arg != arg2);
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            logger = Logger.getLogger("TestClass");
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }
            className = "TestClass";
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }
            methodName = "testMethod()";
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }
            argName = "a";
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }
            arg2Name = "a2";
            try {
                OpbAssert.notEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }
        }
    }

    /**
     * Test of isEqual method, of class com.butterfill.opb.util.OpbAssert.
     */
    public void testIsEqual() {
        System.out.println("equal");

        for (int i = 0; i < 2; i++) {
            Logger logger = null;
            String className = "";
            String methodName = "";
            String argName = "";
            Object arg = null;
            String arg2Name = "";
            Object arg2 = null;
            String message = null;

            if (i == 1) {
                message = "xtr message";
            }

            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg = "";
            arg2 = arg;
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg2 = new Object();
            try {
                OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is not equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            arg = arg2;
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg = null;
            try {
                OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is not equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            arg = new Object();
            arg2 = null;
            try {
                OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is not equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            arg = "x";
            arg2 = "X";
            try {
                OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);
                fail("this should throw one as arg is not equal to arg2");
            } catch (IllegalArgumentException ex) {
                // ok
            }

            arg = 9999;
            arg2 = 9999;
            assertTrue(arg != arg2);
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            logger = Logger.getLogger("TestClass");
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            className = "TestClass";
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            methodName = "testMethod()";
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            argName = "a";
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

            arg2Name = "a2";
            OpbAssert.isEqual(logger, className, methodName, argName, arg, arg2Name, arg2, message);

        }
    }

}
