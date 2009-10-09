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

import java.util.Map;

/**
 * Used to hold (and provide access to) the data of a single row of a ResultSet.
 * OpbDynamicDataView's provide access to their data via the Map interface.
 *
 * @author Peter Butterfill
 */
public interface OpbDynamicDataView extends OpbEntity, Map {

}
