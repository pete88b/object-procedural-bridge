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

package com.butterfill.opb.data;

import com.butterfill.opb.OpbException;
import java.util.logging.Logger;

/**
 * Exception thrown when a data access opperation fails.
 *
 * @author Peter Butterfill
 */
public class OpbDataAccessException extends OpbException {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbDataAccessException.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Constructs an instance of <code>OpbDataAccessException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public OpbDataAccessException(final String msg) {
        super(msg);

        logger.entering(CLASS_NAME, "OpbDataAccessException(String)");

    }

    /**
     * Constructs an instance of <code>OpbDataAccessException</code>
     * with the specified detail message and cause.
     *
     * @param msg the detail message.
     * @param cause the cause of the exception.
     */
    public OpbDataAccessException(final String msg, final Throwable cause) {
        super(msg, cause);

        logger.entering(
                CLASS_NAME, "OpbDataAccessException(String, Throwable)");

    }

} // End of class OpbDataAccessException
