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

import static com.butterfill.opb.util.OpbToStringMode.*;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

/**
 * Provides a standard way of creating a string representation of an object and
 * it's values.
 *
 * <br/><br/>
 * Example of use;
 *
 * <pre>
 * &#64;Override
 * public String toString() {
 *    return OpbToStringHelper.toString(this);
 * }
 * </pre>
 *
 * @author Peter Butterfill
 */
public final class OpbToStringHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbToStringHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Controlls the behaviour of the toString method.
     */
    private static OpbToStringMode toStringMode = MINIMAL;

    /**
     * The default field filter which accepts any non-synthetic fields that are
     * not called logger.
     */
    private static final OpbFieldFilter DEFAULT_FIELD_FILTER =
            new OpbFieldFilter() {
        public boolean accept(final Object object, final Field field) {
            return !field.isSynthetic() && !field.getName().equals("logger");
        }
    };

    /**
     * Used by toString to control which fields are included.
     */
    private static OpbFieldFilter fieldFilter = DEFAULT_FIELD_FILTER;

    /**
     * List of objects that have been added to the output.
     * Objects are added to this list just before they are added to the output.
     * If an object is in this list, it's details need not be repeated.
     */
    private static final List<Object> OBJECTS_ADDED = 
            new OpbExactMatchList<Object>();

    /**
     * The object that is about to be added as a field value.
     */
    private static Object aboutToAddAsFieldValue;


    /**
     * Creates a new instance of OpbToStringHelper.
     * Declared to be private as toString(Object) is static.
     */
    private OpbToStringHelper() {
    }

    /**
     * Returns a string representation of object and it's values.
     * <br/><br/>
     * If the toString mode has been set to FULL, this method will return a
     * string containing all members of object and object's super classes, upto
     * but not including java.lang.Object.
     * <br/>
     * If the toString mode has been set to EXCLUDE_SUPER_CLASS, this method
     * will return a string containing all members of object but not members of
     * object's super classes.
     * <br/>
     * If the toString mode has been set to MINIMAL, this method will return
     * <pre>
     * object.getClass().getName() + "@" + Integer.toHexString(object.hashCode())
     * </pre>
     * Fields are only included in the string returned if the field filter
     * accepts them.
     * By default this will be any non-synthetic fields that are not called
     * logger.
     * <br/><br/>
     *
     * Note: Object values are converted to strings by calling toString on
     * the value. If a value of object uses this method to implement toString(),
     * this method will be called recursively.
     * <br/>
     * @param object
     *   The object for which a string representation will be returned.
     * @return
     *   A string representation of object and it's values.
     * @throws NullPointerException
     *   If object is null.
     * @see #setToStringMode(OpbToStringMode)
     * @see #setFieldFilter(OpbFieldFilter)
     */
    public static synchronized String toString(final Object object)
            throws NullPointerException {
        final String methodName = "toString(Object)";

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "object", object);

        if (toStringMode == MINIMAL) {
            StringBuilder sb = new StringBuilder(object.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(object.hashCode()));
            return sb.toString();

        }

        Class topLevelClass = object.getClass();
        
        boolean objectAdded = OBJECTS_ADDED.contains(object);

        if (!objectAdded) {
            OBJECTS_ADDED.add(object);
        }

        StringBuilder sb = new StringBuilder(topLevelClass.getSimpleName());

        try {
            if (objectAdded && object != aboutToAddAsFieldValue) {
                // if the object has already been added, do not duplicate
                sb.append("(");
                sb.append(OBJECTS_ADDED.indexOf(object) + 1);
                sb.append(")[~~~]");
                return sb.toString();
            }

        } finally {
            aboutToAddAsFieldValue = null;
            
        }

        sb.append("(");
        sb.append(OBJECTS_ADDED.size());
        sb.append(")");
        sb.append("[ ");

        String fieldName = null;
        Field[] fields;
        Class workingClass = topLevelClass;
        String fieldNamePrefix = "";

        // get fields of the top level class and all of it's super classes
        // except for Object
        while (!"java.lang.Object".equals(workingClass.getName())) {
            fields = workingClass.getDeclaredFields();

            AccessibleObject.setAccessible(fields, true);

            for (Field field : fields) {
                fieldName = field.getName();

                // see if the field filter excludes this field
                if (!fieldFilter.accept(object, field)) {
                    continue;
                }

                sb.append("\n  ");
                sb.append(fieldNamePrefix);
                sb.append(fieldName);
                sb.append("=");

                try {
                    Object value = field.get(object);
                    
                    if (value == null) {
                        sb.append("null");

                    } else {
                        if (OBJECTS_ADDED.contains(value)) {
                            // if already added, do not duplicate
                            sb.append(value.getClass().getSimpleName());
                            sb.append("(");
                            sb.append(OBJECTS_ADDED.indexOf(value) + 1);
                            sb.append(")[~~~]");

                        } else {
                            OBJECTS_ADDED.add(value);
                            aboutToAddAsFieldValue = value;

                            sb.append(
                                    value.toString().replaceAll("\n", "\n  "));

                            OBJECTS_ADDED.remove(value);

                        }

                    } // End of if (value == null)

                } catch (IllegalArgumentException ex) {
                    sb.append("<IllegalArgumentException>");

                } catch (IllegalAccessException ex) {
                    sb.append("<IllegalAccessException>");

                }

            } // End of for (Field field : fields)

            // get the next superclass
            workingClass = workingClass.getSuperclass();
            fieldNamePrefix += "super.";

            if (toStringMode == EXCLUDE_SUPER_CLASS) {
                // if super classes have been excluded, stop now");
                break;
            }

        } // End of while (!"Object".equals(workingClass.getSimpleName()))

        sb.append("\n]");

        sb.append(topLevelClass.getSimpleName());
        sb.append("(");
        sb.append(OBJECTS_ADDED.size());
        sb.append(")");

        if (!objectAdded) {
            OBJECTS_ADDED.remove(object);

        }

        return sb.toString();

    } // End of toString(Object)

    /**
     * Convenience method to return the toString() of an object when in FULL
     * mode.
     * <br/>
     * The to string mode of this class will be the same after calling this
     * method as before.
     * <br/>
     * It only makes sense to use this method if the implementation of object's
     * toString() method uses this class.
     *
     * @param object
     *   The object who's toString() result should be returned.
     *   If object is null, "null" will be returned.
     * @return
     *   The result of object's toString() method having set the to string mode
     *   to FULL.
     */
    public static synchronized String toStringFull(final Object object) {
        if (object == null) {
            return "null";
        }
        OpbToStringMode initialMode = toStringMode;
        toStringMode = FULL;
        String result = object.toString();
        toStringMode = initialMode;
        return result;
    }

    /**
     * Returns the mode of the toString method.
     * @see #toString(Object)
     * @see OpbToStringMode
     * @return The mode of the toString method.
     */
    public static OpbToStringMode getToStringMode() {
        return toStringMode;
    }

    /**
     * Sets the mode of the toString method.
     *
     * @param mode
     *   The mode for toString behaviour.
     *   If mode is null, OpbToStringMode.MINIMAL will be used.
     *
     * @see #toString(Object)
     * @see OpbToStringMode
     */
    public static void setToStringMode(final OpbToStringMode mode) {
        toStringMode = (mode == null) ? OpbToStringMode.MINIMAL : mode;
    }

    /**
     * Returns the field filter used by the toString method.
     * @return The field filter used by the toString method.
     */
    public static OpbFieldFilter getFieldFilter() {
        return fieldFilter;
    }

    /**
     * Sets the field filter to be used by the toString method.
     * @param filter
     *   The field filter to be used by the toString method.
     *   If filter is null, the default field filter will be used.
     */
    public static void setFieldFilter(final OpbFieldFilter filter) {
        fieldFilter = (filter == null) ? DEFAULT_FIELD_FILTER : filter;
    }

} // End of class OpbToStringHelper
