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

/**
 * Specifies the behaviour of objects that can provide value objects.
 *
 * @param <E>
 *   The type of object to wrap.
 *
 * @author Peter Butterfill
 */
public interface OpbValueObjectProvider<E> {

    /**
     * Loads the instance using the specified value object.
     * @param valueObject
     *   A value object which must not be null.
     */
    void opbLoad(final E valueObject);

    /**
     * Returns a value object for the instance.
     * @return
     *   A value object for the instance.
     */
    E opbToValueObject();

}
