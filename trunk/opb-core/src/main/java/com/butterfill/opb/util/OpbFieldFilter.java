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

import java.lang.reflect.Field;

/**
 * A filter for fields.
 *
 * @author Peter Butterfill
 */
public interface OpbFieldFilter {

    /**
     * Tests whether or not the specified field should be included.
     *
     * @param object
     *   The instance of which field is an instance variable.
     * @param field
     *   The filed to be tested.
     * @return
     *   true if the specified field should be included, false otherwise.
     */
    boolean accept(Object object, Field field);

}
