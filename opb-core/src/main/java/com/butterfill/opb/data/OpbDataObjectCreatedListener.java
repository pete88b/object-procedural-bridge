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

package com.butterfill.opb.data;

/**
 * Defines an object which can listen to data object created events.
 *
 * @author Peter Butterfill
 */
public interface OpbDataObjectCreatedListener {

    /**
     * Called when a data object has been created to give listeners a chance to
     * complete the data object configuration.
     * opbLoad(ResultSet) will have been called on the data object if it was
     * created as part of a "get result" operation.
     *
     * @see OpbEntity#opbLoad(java.sql.ResultSet)
     *
     * @param requestedType
     *   The type of data object requested.
     * @param dataObject
     *   The data object that has just been created.
     * @param cached
     *   Will be true if the data object has been cached, false otherwise.
     */
    void dataObjectCreated(Class requestedType, Object dataObject,
            boolean cached);

}
