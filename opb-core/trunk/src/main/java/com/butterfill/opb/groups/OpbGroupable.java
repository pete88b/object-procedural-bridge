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

/**
 * Groupables provide access to a OpbGroupManagerMap.
 *
 * @author Peter Butterfill
 */
public interface OpbGroupable {

    /**
     * Save map so that it can be returned by getGroupManagerMap().
     * @param map The map to be saved.
     */
    void setGroupManagerMap(OpbGroupManagerMap map);

    /**
     * Return the map saved by setGroupManagerMap(OpbGroupManagerMap) or
     * null if setGroupManagerMap(OpbGroupManagerMap) has not been called.
     * @return The map saved by setGroupManagerMap(OpbGroupManagerMap).
     */
    OpbGroupManagerMap getGroupManagerMap();

}
