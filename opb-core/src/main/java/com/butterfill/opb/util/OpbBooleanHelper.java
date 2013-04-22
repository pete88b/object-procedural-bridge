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
 * Provides methods to convert between String and Boolean values.
 *
 * @author Peter Butterfill
 */
public final class OpbBooleanHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbBooleanHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Controls case sensitive behaviour of the methods in this class.
     */
    private static boolean ignoreCase = true;

    /**
     * The value that represents true.
     */
    private static String valueForTrue = "Y";

    /**
     * The value that represents false.
     */
    private static String valueForFalse = "N";


    /**
     * Creates a new instance of OpbBooleanHelper.
     * This is private as this class contains only static methods.
     * i.e. There is no point creating an instance of this class.
     */
    private OpbBooleanHelper() {
    }


    /**
     * Returns true if a and b are the same taking into account the value of
     * the ignore case flag.
     * @param a Any string.
     * @param b Any string.
     * @return
     *   true if a and b are the same.
     */
    private static boolean equals(final String a, final String b) {
        if (a == b) {
            // if a and b are the same object, or both null, return true
            return true;
        }

        if (ignoreCase) {
            return a != null && a.equalsIgnoreCase(b);

        } else {
            return a != null && a.equals(b);

        }

    } // End of equals(String, String)


    // <editor-fold defaultstate="collapsed" desc="getter and setter section">

    /**
     * Returns true if the methods of this class are not case sensitive,
     * false otherwise.
     * <br/>
     * <strong>true is the default</strong>
     *
     * @return
     *   true if the methods of this class are not case sensitive.
     */
    public static boolean isIgnoreCase() {
        return ignoreCase;
    }

    /**
     * Sets the value for ignore case for this class.
     *
     * @param ignore
     *   The value for ignore case for this class.
     */
    public static void setIgnoreCase(final boolean ignore) {
        ignoreCase = ignore;
    }

    /**
     * Returns the string value that represents true.
     * @return The string value that represents true.
     */
    public static String getValueForTrue() {
        return valueForTrue;
    }

    /**
     * Sets the string value that represents true.
     * @param newValueForTrue
     *   The value that represents true.
     * @throws IllegalArgumentException
     *   If the current value for false is the same as valueForTrue.
     */
    public static void setValueForTrue(final String newValueForTrue)
            throws IllegalArgumentException {
        final String methodName = "setValueForTrue(String)";

        logger.entering(CLASS_NAME, methodName);

        if (equals(valueForFalse, newValueForTrue)) {
            OpbExceptionHelper.throwException(
                    new IllegalArgumentException(
                    "You can't make the values for true and false the same"
                    + ". current value for false=" + valueForFalse
                    + ". input value for true=" + newValueForTrue
                    + ". ignore case=" + ignoreCase),
                    logger, CLASS_NAME, methodName);
        }

        valueForTrue = newValueForTrue;

    } // End of setValueForTrue(String)

    /**
     * Returns the string value that represents false.
     * @return
     *   The string value that represents false.
     */
    public static String getValueForFalse() {
        return valueForFalse;
    }

    /**
     * Sets the string value that represents false.
     * @param newValueForFalse
     *   The value that represents false.
     * @throws IllegalArgumentException
     *   If the current value for true is the same as valueForFalse.
     */
    public static void setValueForFalse(final String newValueForFalse)
    throws IllegalArgumentException {
        final String methodName = "setValueForFalse(String)";

        logger.entering(CLASS_NAME, methodName);

        if (equals(valueForTrue, newValueForFalse)) {
            OpbExceptionHelper.throwException(
                    new IllegalArgumentException(
                    "You can't make the values for true and false the same"
                    + ". current value for true=" + valueForTrue
                    + ". input value for false=" + newValueForFalse
                    + ". ignore case=" + ignoreCase),
                    logger, CLASS_NAME, methodName);
        }

        valueForFalse = newValueForFalse;

    } // End of setValueForFalse(String)

    // </editor-fold> End of getter and setter Section


    /**
     * Returns a Boolean with the value represented by the specified string
     * or throws an IllegalArgumentException if value is invalid.
     * <br/>
     * If value is null, this method will always return null.
     *
     * @param value
     *   The value to convert to boolean.
     *
     * @return
     *   The String value converted to Boolean.
     */
    public static Boolean toBoolean(final String value) {
        final String methodName = "toBoolean(String)";

        logger.entering(CLASS_NAME, methodName);

        if (value == null) {
            return null;

        } else if (equals(value, valueForTrue)) {
            return Boolean.TRUE;

        } else if (equals(value, valueForFalse)) {
            return Boolean.FALSE;

        }

        throw OpbExceptionHelper.throwException(
                new IllegalArgumentException(
                "Failed to convert " + value
                + " to Boolean. value for true=" + getValueForTrue()
                + ". value for false=" + getValueForFalse()
                + ". ignore case=" + ignoreCase),
                logger, CLASS_NAME, methodName);

    } // End of toBoolean(String)

    /**
     * Returns value converted to String.
     * <br/>
     * If value is null, this method will always return null.
     *
     * @param value
     *   The value to convert to String.
     *
     * @return
     *   value converted to String.
     */
    public static String toString(final Boolean value) {
        final String methodName = "toString(Boolean)";

        logger.entering(CLASS_NAME, methodName);

        if (value == null) {
            return null;
        }

        return (value) ? valueForTrue : valueForFalse;

    }


} // End of class OpbBooleanHelper
