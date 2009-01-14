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
 * Encapsulates the instantiation of objects.
 * <br/>
 * Implementations of this interface can be used by Opb code to create new
 * objects.
 *
 * @author Peter Butterfill
 */
public interface OpbObjectSource {

    /**
     * Returns a new instance of the specified class.
     * 
     * @param <T>
     *   The type of object to return.
     * @param interfaceOfInstance
     *   The type of object to return.
     * @return
     *   A new instance of the specified class.
     * @throws com.butterfill.opb.OpbException
     *   If we fail to create the new instance.
     */
    <T extends Object> T newInstance(Class<T> interfaceOfInstance)
            throws OpbException;

}
