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

import com.butterfill.opb.OpbId;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides methods for converting Opb objects to simple value objects.
 * <br/>
 * One expected use of this class is to simplify serialization of Opb objects -
 * so you might convert an Opb object to a value object before serializing the object.
 *
 * @author Peter Butterfill
 */
public class OpbValueObjectHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbValueObjectHelper.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The default field filter which accepts any non-synthetic fields that are
     * not called logger, opbConnectionProvider or opbDataObjectSource.
     */
    private static final OpbFieldFilter DEFAULT_FIELD_FILTER =
            new OpbFieldFilter() {
        public boolean accept(final Object object, final Field field) {
            return !field.isSynthetic()
                    && !field.getName().equals("logger")
                    && !field.getName().equals("opbConnectionProvider")
                    && !field.getName().equals("opbDataObjectSource");
        }
    };

    /**
     * Used by toValueObject to control which fields are included.
     */
    private OpbFieldFilter fieldFilter = DEFAULT_FIELD_FILTER;

    /**
     * Creates a new instance of OpbValueObjectHelper.
     */
    public OpbValueObjectHelper() {
    }

    /**
     * Returns a copy of the values held by the specified OpbId.
     * @param opbId
     *   An OpbId - which must not be null.
     * @return
     *   A copy of the values held by the specified OpbId.
     */
    private Object[] getOpbIdValues(final Object opbId) {
        final String method = "getOpbIdValues(Object)";

        try {
            final Field valuesField = OpbId.class.getDeclaredField("values");
            valuesField.setAccessible(true);
            final Object[] values = (Object[]) valuesField.get(opbId);
            return values.clone();

        } catch (Exception ex) {
            throw OpbExceptionHelper.throwException(
                    new RuntimeException("failed to get OpbId#values field value", ex),
                    logger, CLASS_NAME, method);

        }
    }

    /**
     * Returns a "value object" representation of the specified object.
     * <br/>
     * Using the default field filter, this method will return a map;
     * <ul>
     * <li>
     *  containing all fields that are;
     *  <ul>
     *      <li>not synthetic</li>
     *      <li>not called logger</li>
     *      <li>not called opbConnectionProvider</li>
     *      <li>not called opbDataObjectSource</li>
     *  </ul>
     * </li>
     * <li>where key is the field name and value is the field value</li>
     * <li>
     *  containing an extra entry where key is <code>CLASS_NAME</code>
     *  and value is the name of the class of the object passed to this method
     * </li>
     * </ul>
     * () containing all
     * @param object
     *   The object to convert.
     * @return
     *   A value object or null if object is null.
     */
    public Map<String, Object> toValueObject(final Object object) {
        final String method = "toValueObject(Object)";

        if (object == null) {
            return null;
        }

        final Map<String, Object> result = new HashMap<String, Object>();

        final Class objectClass = object.getClass();

        result.put("CLASS_NAME", objectClass.getName());

        final Field[] fields = objectClass.getDeclaredFields();

        try {
            AccessibleObject.setAccessible(fields, true);

        } catch (SecurityException ex) {
            // if we can't make the fields accessible, we'll get illegal argument
            // and illegal access exceptions when we try to get field values
            logger.logp(Level.WARNING, CLASS_NAME, method,
                    "failed to make fields accessible", ex);
        }

        for (Field field : fields) {
            // see if the field filter excludes this field
            if (!fieldFilter.accept(object, field)) {
                continue;
            }

            try {
                final Object value = field.get(object);

                if (value instanceof OpbId) {
                    result.put(field.getName(), getOpbIdValues(value));

                } else {
                    result.put(field.getName(), value);

                }

            } catch (Exception ex) {
                OpbExceptionHelper.throwException(
                        new RuntimeException("failed to get field value", ex),
                        logger, CLASS_NAME, method);

            }

        }

        return result;

    }

    /**
     * Returns a list of "value object" representations of the specified objects.
     * @param objects
     *   The objects to convert.
     * @return
     *   A list of value objects or null if objects is null.
     */
    public List<Map<String, Object>> toValueObject(final List objects) {
        if (objects == null) {
            return null;
        }

        final List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        for (Object object : objects) {
            result.add(toValueObject(object));
        }

        return result;

    }

    /**
     * Returns a list of "value object" representations of the specified objects.
     * @param objects
     *   The objects to convert.
     * @return
     *   A list of value objects or null if objects is null.
     */
    public List<Map<String, Object>> toValueObject(final Object[] objects) {
        if (objects == null) {
            return null;
        }

        final List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        for (Object object : objects) {
            result.add(toValueObject(object));
        }

        return result;

    }

    /**
     * Returns the field filter used by the toString method.
     * @return The field filter used by the toString method.
     */
    public OpbFieldFilter getFieldFilter() {
        return fieldFilter;
    }

    /**
     * Sets the field filter to be used by the toString method.
     * @param filter
     *   The field filter to be used by the toString method.
     *   If filter is null, the default field filter will be used.
     */
    public void setFieldFilter(final OpbFieldFilter filter) {
        fieldFilter = (filter == null) ? DEFAULT_FIELD_FILTER : filter;
    }

} // End of class OpbValueObjectHelper
