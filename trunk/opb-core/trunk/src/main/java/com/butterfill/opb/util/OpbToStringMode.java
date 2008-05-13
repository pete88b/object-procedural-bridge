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

/**
 * Values to control the behaviour of OpbToStringHelper's toString method.
 *
 * @see OpbToStringHelper#toString(Object)
 *
 * @author Peter Butterfill
 */
public enum OpbToStringMode {

    /**
     * Used to indicate that the toString method should return a fully detailed
     * string representation of an object and it's values.
     */
    FULL,

    /**
     * Used to indicate that the toString method should return a fully detailed
     * string representation of an object and it's values excluding fields
     * declared in the object's super class.
     */
    EXCLUDE_SUPER_CLASS,

    /**
     * Used to indicate that the toString method should return a string
     * representation of an object and it's values with minimal details.
     */
    MINIMAL

}
