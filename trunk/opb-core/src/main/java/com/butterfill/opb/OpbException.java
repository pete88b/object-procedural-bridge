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

import java.util.logging.Logger;

/**
 * Superclass for all exceptions thrown by Opb code.
 * @author Peter Butterfill
 */
public class OpbException extends RuntimeException {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbException.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Constructs an instance of <code>OpbException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public OpbException(final String msg) {
        super(msg);
        logger.entering(CLASS_NAME, "OpbException(String)");
    }

    /**
     * Constructs an instance of <code>OpbException</code> with the specified
     * detail message and cause.
     * @param msg the detail message.
     * @param cause the cause of the exception.
     */
    public OpbException(final String msg, final Throwable cause) {
        super(msg, cause);
        logger.entering(CLASS_NAME, "OpbException(String, Throwable)");
    }

} // End of class OpbException
