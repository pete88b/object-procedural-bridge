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

import com.butterfill.opb.util.OpbAssert;
import java.util.logging.Logger;

/**
 * Holds any number of values that together make an ID.
 *
 * @author Peter Butterfill
 */
public class OpbId {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbId.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The set of values that make up this id.
     */
    private final Object[] values;

    /**
     * Creates a new instance of OpbId for the given set of values.
     * <br/>
     * While the set of values that make up this id cannot be changed and this
     * id provides no access to it's values, mutable objects used as values can
     * be changed (effectively changing this id).
     * The following example will output true before the date change and false
     * after the date change.
     * <br/>
     * <pre>
     * Date date = new Date();
     * Date date2 = new Date(date.getTime());
     *
     * OpbId id = new OpbId(date);
     * OpbId id2 = new OpbId(date2);
     *
     * System.out.format("before date change: %s%n", id.equals(id2)); // true
     * date.setTime(2L);
     * System.out.format("after date change: %s%n", id.equals(id2)); // false
     * </pre>
     *
     * @param values
     *   The set of values that make up this id.
     * @throws NullPointerException
     *   If values is null.
     */
    public OpbId(final Object... values) throws NullPointerException {
        logger.entering("OpbId", "OpbId(Object...)");

        OpbAssert.notNull(
                logger, CLASS_NAME, "OpbId(Object...)", "values", values,
                "You can't create an id with no values");

        this.values = values;

    } // End of OpbId()


    /**
     * Returns a String representation of this OpbId and it's values.
     * The string representation consists of a list of the id's values in the
     * order they were passed to the constructor, enclosed in square brackets.
     * Adjacent elements are separated by the characters ", " (comma and space).
     * <br/>
     * Values are converted to strings by passing them to
     * StringBuilder#append(Object).
     * <br/>
     * Arrays are converted to strings by passing each element to
     * StringBuilder#append(Object).
     * Array elements are enclosed in square brackets and are separated by ", ".
     *
     * @return a string representation of this id
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof Object[]) {
                sb.append("[");
                Object[] arrayValue = (Object[]) values[i];
                for (int j = 0; j < arrayValue.length; j++) {
                    sb.append(arrayValue[j]);
                    if (j < arrayValue.length - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
            } else {
                sb.append(values[i]);
            }
            if (i < values.length - 1) {
                sb.append(", ");
            }
        }
        return sb.append(']').toString();
    }

    /**
     * Compares the specified object with this id for equality.
     * <br/>
     * Returns true if the specified object is an OpbId and contains equal
     * values in the same order as this id, false otehrwise.
     * <br/>
     * Arrays are considered equal if they have the same length and equal
     * elements in the same order.
     *
     * @param o the object to be compared for equality with this id
     * @return {@code true} if the specified object is equal to this id
     */
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof OpbId)) {
            return false;
        }

        OpbId id = (OpbId) o;

        if (values.length != id.values.length) {
            return false;
        }

        for (int i = 0; i < values.length; i++) {
            Object a = values[i];
            Object b = id.values[i];

            if (a != b && a instanceof Object[] && b instanceof Object[]) {
                Object[] aArray = (Object[]) a;
                Object[] bArray = (Object[]) b;

                if (aArray.length != bArray.length) {
                    return false;
                }

                for (int j = 0; j < aArray.length; j++) {
                    a = aArray[j];
                    b = bArray[j];

                    if (!(a == null ? b == null : a.equals(b))) {
                        return false;
                    }

                }

            } else if (!(a == null ? b == null : a.equals(b))) {
                return false;
            }

        } // End of for (int i = 0; i < values.length; i++)

        return true;

    }

    /**
     * Returns the hash code value for this id.
     *
     * @return the hash code value for this id
     */
    @Override
    public int hashCode() {
        int result = 1;

        for (Object o : values) {
            if (o instanceof Object[]) {
                for (Object o2 : (Object[]) o) {
                    result = (31 * result) + (o2 == null ? 0 : o2.hashCode());
                }
            } else {
                result = (31 * result) + (o == null ? 0 : o.hashCode());
            }
        }

        return result;
    }

} // End of class OpbId
