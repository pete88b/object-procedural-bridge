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
 * A data object is active if it can interact with the data source.
 * (i.e performs one or more function or procedure calls).
 * <br/>
 * <br/>
 * Data objects can interact with the data source in several ways but all
 * interactions need a connection to the data source (so the data object needs
 * a connection source).
 * <br/>
 * Most active data objects will retrieve other data objects from the data
 * source (so the data object needs an object source).
 *
 * @author Peter Butterfill
 */
public interface OpbActiveDataObject {

    /**
     * Sets the data object source to be used by the active data object (to
     * retrieve other data objects).
     * It is expected that this data object source will be the data object
     * source that this object came from.
     * @see OpbDataObjectSource
     * @param source A data object source.
     */
    void setOpbDataObjectSource(OpbDataObjectSource source);

    /**
     * Sets the connection provider to be used by the active data object.
     * @see OpbConnectionProvider
     * @param provider A connection provider.
     */
    void setOpbConnectionProvider(OpbConnectionProvider provider);

}
