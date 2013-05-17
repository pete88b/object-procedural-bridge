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

import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.OpbValueObjectProvider;
import com.butterfill.opb.data.OpbActiveDataObject;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.session.OpbSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Provides methods for converting Opb objects to value objects and vice versa.
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
     * Default data object source to use.
     */
    private final OpbDataObjectSource dataObjectSource;

    /**
     * Creates a new instance of OpbValueObjectHelper that will use a {@link OpbDataObjectSource}.
     */
    public OpbValueObjectHelper() {
        dataObjectSource = new OpbDataObjectSource(new OpbObjectSourceImpl());
    }

    /**
     * Creates a new instance of OpbValueObjectHelper that will use the specified data object
     * source.
     * @param dataObjectSource
     *   The data object source used by {@link #toOpbObjectList(java.lang.Class, java.util.List)}
     *   to create new instances.
     */
    public OpbValueObjectHelper(final OpbDataObjectSource dataObjectSource) {
        OpbAssert.notNull(logger, CLASS_NAME, "toOpbObjectList",
                "dataObjectSource", dataObjectSource);

        this.dataObjectSource = dataObjectSource;
    }

    /**
     * Creates a new instance of OpbValueObjectHelper that will use the data object
     * source of the specified session.
     * @param session
     *   A session from which we can get the data object source used by
     *   {@link #toOpbObjectList(java.lang.Class, java.util.List)} to create new instances.
     */
    public OpbValueObjectHelper(final OpbSession session) {
        OpbAssert.notNull(logger, CLASS_NAME, "toOpbObjectList", "session", session);

        this.dataObjectSource = session.getDataObjectSource();

        OpbAssert.notNull(logger, CLASS_NAME, "toOpbObjectList",
                "dataObjectSource", dataObjectSource);

    }

    /**
     * Converts a list of Opb objects to a list of value objects.
     * @param opbObjects
     *   A list of Opb objects.
     * @return
     *   A list of Opb objects or null if opbObjects is null.
     */
    public List toValueObjectList(final List opbObjects) {
        final String method = "toValueObjectList(List)";

        logger.entering(CLASS_NAME, method);

        if (opbObjects == null) {
            return null;
        }

        final List<Object> result = new ArrayList<Object>();

        for (Object object : opbObjects) {
            if (object == null) {
                result.add(null);

            } else if (object instanceof OpbValueObjectProvider) {
                result.add(((OpbValueObjectProvider) object).opbToValueObject());

            } else if (object instanceof OpbActiveDataObject) {
                result.add(null);

            } else {
                OpbExceptionHelper.throwException(
                        new RuntimeException("failed to add value object to list. " + object),
                        logger, CLASS_NAME, method);

            }

        }

        return result;

    }

    /**
     * Converts a list of value objects to a list of Opb objects.
     * @param <T>
     *   The type of object to convert to.
     * @param classOfObject
     *   The class of object to convert to.
     * @param valueObjects
     *   A list of value objects.
     * @return
     *   A list of Opb objects or null if valueObjects is null.
     */
    public <T extends OpbValueObjectProvider> List<T> toOpbObjectList(
            final Class<T> classOfObject, final List valueObjects) {
        final String method = "toOpbObjectList(Class, List)";

        logger.entering(CLASS_NAME, method);

        if (valueObjects == null) {
            return null;
        }

        final List<T> result = new ArrayList<T>();

        for (Object object : valueObjects) {
            if (object == null) {
                result.add(null);

            } else {
                final T opbObject = dataObjectSource.newInstance(classOfObject);
                opbObject.opbLoad(object);
                result.add(opbObject);

            }

        }

        return result;

    }

} // End of class OpbValueObjectHelper
