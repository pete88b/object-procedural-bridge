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
 * Simple value wrapper implementation that holds a value in an instance field.
 * One expected use of an OpbValueWrapperImpl is to pass values out of Java
 * methods via parameters.
 *
 * @param <E> The type of value being wrapped.
 *
 * @author Peter Butterfill
 */
public class OpbValueWrapperImpl<E> implements OpbValueWrapper<E> {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbValueWrapperImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * The value being wrapped.
     */
    private E value;

    /**
     * Creates a new instance of OpbValueWrapperImpl.
     */
    public OpbValueWrapperImpl() {
        logger.entering(CLASS_NAME, "OpbValueWrapperImpl()");

    } // End of OpbValueWrapperImpl()

    /**
     * Creates a new instance of OpbValueWrapperImpl with the specifed value.
     * @param value
     *   The initial value of this holder.
     */
    public OpbValueWrapperImpl(final E value) {
        logger.entering(CLASS_NAME, "OpbValueWrapperImpl(Object)");

        this.value = value;

    } // End of OpbValueWrapperImpl(Object value)

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbValueWrapperImpl.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the value being held.
     * @return The value being held.
     */
    public E getValue() {
        return value;
    }

    /**
     * Sets the value to be held.
     * @param value The value to be held.
     */
    public void setValue(final E value) {
        this.value = value;
    }

} // End of class OpbValueWrapperImpl
