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

import com.butterfill.opb.OpbException;
import junit.framework.*;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter Butterfill
 */
public class OpbExceptionHelperTest extends TestCase {
    
    public OpbExceptionHelperTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    

    /**
     * Test of throwException method, of class com.butterfill.opb.util.OpbExceptionHelper.
     */
    public void testThrowException() {
        System.out.println("throwException");
        
        Exception exception = null;
        OpbException exception2 = null;
        RuntimeException rtException = null;
        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        
        // won't compile due to unreport ex
        //OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
        
        try {
            OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
            fail("should throw a null pointer");
        } catch (NullPointerException ex) {
            //ok
        } catch (Exception ex) {
            fail("should have been a null pointer");
        }
        
        exception = new Exception("test exception message");
        
        try {
            OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (Exception ex) {
            assertEquals(exception, ex);
        }
        
        sourceLogger = Logger.getLogger("TestLoggerName");
        try {
            OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (Exception ex) {
            assertEquals(exception, ex);
        }
        
        sourceClass = "TestClassName";
        try {
            OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (Exception ex) {
            assertEquals(exception, ex);
        }
        
        sourceMethod = "TestMethodName";
        try {
            OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (Exception ex) {
            assertEquals(exception, ex);
        }
        
        exception = new Exception("test exception message with cause",
                new Throwable("a throwable"));
        try {
            OpbExceptionHelper.throwException(exception, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (Exception ex) {
            assertEquals(exception, ex);
        }
        
        // won't compile due to unreport ex
        //OpbExceptionHelper.throwException(exception2, sourceLogger, sourceClass, sourceMethod);
        
        try {
            OpbExceptionHelper.throwException(exception2, sourceLogger, sourceClass, sourceMethod);
            fail("should throw a null pointer");
        } catch (NullPointerException ex) {
            //ok
        } catch (Exception ex) {
            fail("should have been a null pointer");
        }
        
        exception2 = new OpbException("test msg 2");
        
        try {
            OpbExceptionHelper.throwException(exception2, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (OpbException ex) {
            assertEquals(exception2, ex);
        }
        
        exception2 = new OpbException("test msg 2 w/cause",
                new Throwable("a throwable2"));
        try {
            OpbExceptionHelper.throwException(exception2, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (OpbException ex) {
            assertEquals(exception2, ex);
        }
        
        // will compile. 
        try {
            OpbExceptionHelper.throwException(rtException, sourceLogger, sourceClass, sourceMethod);
            fail("should have thrown a null pointer");
        } catch (NullPointerException ex) {
            //ok
        }
        
        
        rtException = new RuntimeException("rt ex");
        try {
            OpbExceptionHelper.throwException(rtException, sourceLogger, sourceClass, sourceMethod);
            fail("this should have thrown an exception");
        } catch (RuntimeException ex) {
            assertEquals(rtException, ex);
        }
        
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbExceptionHelperTest.class);
        
        return suite;
    }
    
}
