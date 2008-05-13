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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Methods to help when working with exceptions.
 *
 * @author Peter Butterfill
 */
public final class OpbExceptionHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbExceptionHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Creates a new instance of OpbExceptionHelper.
     * This is private as this class contains only static methods.
     * i.e. There is no point creating an instance of this class.
     */
    private OpbExceptionHelper() {
    }


    /**
     * Throws the specified exception after logging an info message for first
     * pass diagnostics.
     * Also loggs a throwing message via
     * Logger#throwing(String, String, Throwable).
     *
     * @param <T> The type of exception to throw.
     * @param exception
     *   The exception to throw. If this is null, this method does nothing
     * @param sourceLogger
     *   The logger of the class calling this method. If sourceLogger is null,
     *   the logger of this class is used
     * @param sourceClass The name of the class calling this method
     * @param sourceMethod The name of the method calling this method
     * @throws T
     *   The specified exception after logging an info message
     * @return
     *   The specified exception for use in methods that should return a value.
     */
    public static <T extends Exception> T throwException(final T exception,
            final Logger sourceLogger, final String sourceClass,
            final String sourceMethod)
    throws T {
        final String methodName = "throwException";

        logger.entering(CLASS_NAME, methodName);

        if (exception == null) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "throwing NullPointerException. exception is null");
            throw new NullPointerException("exception must not be null");

        } // End of if (exception == null)

        Logger lggr;

        if (sourceLogger == null) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "sourceLogger is null. Using OpbExceptionHelper's logger");
            lggr = logger;

        } else {
            lggr = sourceLogger;

        }

        StringBuilder message = new StringBuilder();
        message.append("throwing ");
        message.append(exception.getClass().getName());
        message.append(". ");
        message.append(exception.getMessage());

        Throwable cause = exception.getCause();
        if (cause != null) {
            message.append(". cause=");
            message.append(cause.getMessage());

        }

        lggr.logp(Level.INFO, sourceClass, sourceMethod, message.toString());
        lggr.throwing(sourceClass, sourceMethod, exception);

        throw exception;

    }

} // End of class OpbExceptionHelper
