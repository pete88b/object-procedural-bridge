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

import java.util.logging.Logger;

/**
 * Provides commonly used assertion methods.
 *
 * @author Peter Butterfill
 */
public final class OpbAssert {

    /**
     * Creates a new instance of OpbAssert.
     * This is private as this class contains only static methods.
     * i.e. There is no point creating an instance of this class.
     */
    private OpbAssert() {
    }

    /**
     * Formats the specified argument name for use in user messages.
     * @param argName The argument name to format. May be null.
     * @return The specified argument name, formatted for use in user messages.
     */
    private static String formatArgName(final String argName) {
        return (argName == null) ? "?" : argName;
    }

    /**
     * Throws a NullPointerException if arg is null.
     * Before throwing the exception an info message is logged for first pass
     * diagnostics and a throwing message is logged via
     * Logger#throwing(String, String, Throwable).
     * It is expected that this method will be used to assert that a method
     * argument is not null.
     *
     * @param sourceLogger
     *   The logger of the class calling this method. If sourceLogger is null,
     *   the logger of this class is used
     * @param sourceClass
     *   The name of the class calling this method
     * @param sourceMethod
     *   The name of the method calling this method
     * @param argName
     *   The name of the argument to check
     * @param arg
     *   The argument to check
     */
    public static void notNull(final Logger sourceLogger,
            final String sourceClass, final String sourceMethod,
            final String argName, final Object arg) {
        // if the argument is null
        if (arg == null) {
            // throw a null pointer exception
            OpbExceptionHelper.throwException(
                    new NullPointerException(
                    formatArgName(argName) + " must not be null"),
                    sourceLogger, sourceClass, sourceMethod);

        }

    }

    /**
     * Throws a NullPointerException if arg is null.
     * Before throwing the exception an info message is logged for first pass
     * diagnostics and a throwing message is logged via
     * Logger#throwing(String, String, Throwable).
     * The message specified will be included in both the exception message
     * and the logged message.
     * It is expected that this method will be used to assert that a method
     * argument is not null.
     *
     * @param sourceLogger
     *   The logger of the class calling this method. If sourceLogger is null,
     *   the logger of this class is used
     * @param sourceClass
     *   The name of the class calling this method
     * @param sourceMethod
     *   The name of the method calling this method
     * @param argName
     *   The name of the argument to check
     * @param arg
     *   The argument to check
     * @param message
     *   An additional piece of message
     */
    public static void notNull(final Logger sourceLogger,
            final String sourceClass, final String sourceMethod,
            final String argName, final Object arg, final String message) {
        // if the argument is null
        if (arg == null) {
            // throw a null pointer exception
            OpbExceptionHelper.throwException(
                    new NullPointerException(
                    formatArgName(argName) + " must not be null. " + message),
                    sourceLogger, sourceClass, sourceMethod);

        }

    }

    /**
     * Throws a IllegalArgumentException if arg is not null.
     * Before throwing the exception an info message is logged for first pass
     * diagnostics and a throwing message is logged via
     * Logger#throwing(String, String, Throwable).
     * The message specified will be included in both the exception message
     * and the logged message.
     * It is expected that this method will be used to assert that a method
     * argument is null.
     *
     * @param sourceLogger
     *   The logger of the class calling this method. If sourceLogger is null,
     *   the logger of this class is used
     * @param sourceClass
     *   The name of the class calling this method
     * @param sourceMethod
     *   The name of the method calling this method
     * @param argName
     *   The name of the argument to check
     * @param arg
     *   The argument to check
     * @param message
     *   An additional piece of message
     */
    public static void isNull(final Logger sourceLogger,
            final String sourceClass, final String sourceMethod,
            final String argName, final Object arg, final String message) {
        // if the argument is not null
        if (arg != null) {
            // throw a illegal arg exception
            OpbExceptionHelper.throwException(
                    new IllegalArgumentException(
                    formatArgName(argName) + " must be null. " + message),
                    sourceLogger, sourceClass, sourceMethod);

        }

    }

    /**
     * Throws a IllegalArgumentException if arg is equal to arg2 according to
     * OpbComparisonHelper#isEqual(Object, Object).
     * Before throwing the exception an info message is logged for first pass
     * diagnostics and a throwing message is logged via
     * Logger#throwing(String, String, Throwable).
     * The message specified will be included in both the exception message
     * and the logged message.
     *
     * @param sourceLogger
     *   The logger of the class calling this method. If sourceLogger is null,
     *   the logger of this class is used
     * @param sourceClass
     *   The name of the class calling this method
     * @param sourceMethod
     *   The name of the method calling this method
     * @param argName
     *   The name of the argument to check
     * @param arg
     *   The argument to check
     * @param arg2Name
     *   The name of the second argument to check
     * @param arg2
     *   The second argument to check
     *
     * @param message
     *   An additional piece of message
     *
     * @see OpbComparisonHelper#isEqual(Object, Object)
     */
    public static void notEqual(final Logger sourceLogger,
            final String sourceClass, final String sourceMethod,
            final String argName, final Object arg, final String arg2Name,
            final Object arg2, final String message) {
        // if the two args are equal
        if (OpbComparisonHelper.isEqual(arg, arg2)) {
            // throw an illegal argument exception
            StringBuilder sb = new StringBuilder();
            sb.append(formatArgName(argName));
            sb.append(" should not equal ");
            sb.append(arg2Name);
            if (message != null) {
                sb.append(". ");
                sb.append(message);
            }
            OpbExceptionHelper.throwException(
                    new IllegalArgumentException(
                    sb.toString()),
                    sourceLogger, sourceClass, sourceMethod);

        }

    }

    /**
     * Throws a IllegalArgumentException if arg is not equal to arg2 according
     * to OpbComparisonHelper#isEqual(Object, Object).
     * Before throwing the exception an info message is logged for first pass
     * diagnostics and a throwing message is logged via
     * Logger#throwing(String, String, Throwable).
     * The message specified will be included in both the exception message
     * and the logged message.
     *
     * @param sourceLogger
     *   The logger of the class calling this method. If sourceLogger is null,
     *   the logger of this class is used
     * @param sourceClass
     *   The name of the class calling this method
     * @param sourceMethod
     *   The name of the method calling this method
     * @param argName
     *   The name of the argument to check
     * @param arg
     *   The argument to check
     * @param arg2Name
     *   The name of the second argument to check
     * @param arg2
     *   The second argument to check
     *
     * @param message
     *   An additional piece of message
     *
     * @see OpbComparisonHelper#isEqual(Object, Object)
     */
    public static void isEqual(final Logger sourceLogger,
            final String sourceClass, final String sourceMethod,
            final String argName, final Object arg, final String arg2Name,
            final Object arg2, final String message) {
        // if the two args are not equal
        if (!OpbComparisonHelper.isEqual(arg, arg2)) {
            // throw an illegal argument exception
            StringBuilder sb = new StringBuilder();
            sb.append(formatArgName(argName));
            sb.append(" should equal ");
            sb.append(arg2Name);
            if (message != null) {
                sb.append(". ");
                sb.append(message);
            }
            OpbExceptionHelper.throwException(
                    new IllegalArgumentException(
                    sb.toString()),
                    sourceLogger, sourceClass, sourceMethod);

        }

    }

} // End of class OpbAssert
