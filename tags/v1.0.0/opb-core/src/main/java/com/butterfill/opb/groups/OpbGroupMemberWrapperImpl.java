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

package com.butterfill.opb.groups;

import java.util.logging.Logger;

/**
 * Simple group member wrapper implementation that holds a group member in an
 * instance field.
 *
 * @param <E> The type of value wrapped.
 *
 * @author Peter Butterfill
 */
public class OpbGroupMemberWrapperImpl<E> implements OpbGroupMemberWrapper<E> {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbGroupMemberWrapperImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The value being wrapped.
     */
    private E value;

    /**
     * Creates a new instance of OpbGroupMemberWrapperImpl.
     */
    public OpbGroupMemberWrapperImpl() {
        logger.entering(CLASS_NAME, "OpbGroupMemberWrapperImpl()");

    }

    /**
     * Creates a new instance of OpbGroupMemberWrapperImpl with the specified
     * value.
     *
     * @param value Initial value for this holder.
     */
    public OpbGroupMemberWrapperImpl(final E value) {
        logger.entering(CLASS_NAME, "OpbGroupMemberWrapperImpl(E)");

        this.value = value;
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

} // End of class OpbGroupMemberWrapperImpl
