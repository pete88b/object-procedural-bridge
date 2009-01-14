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
 * Defines constants for this project (opb-library).
 * @author Peter Butterfill
 */
public final class OpbConstants {

    /**
     * The default SQL datatype. This will be used when a datatype is expected
     * but no datatype has been specified.
     */
    public static final String DEFAULT_DATATYPE = "VARCHAR";

    /**
     * Fully qualified name of the interface that should be used when an
     * OpbEntity is needed but no OpbEntity has been specified.
     */
    public static final String DEFAULT_ENTITY =
            "com.butterfill.opb.data.OpbDynamicDataView";

    /**
     * Fully qualified name of the class that should be used when an
     * OpbValueWrapper is needed but no OpbValueWrapper has been specified.
     */
    public static final String DEFAULT_VALUE_WRAPPER =
            "com.butterfill.opb.util.OpbValueWrapper";


    /**
     * Creates a new instance of OpbConstants.
     * This is private as this class contains only static members.
     * i.e. There is no point creating an instance of this class.
     */
    private OpbConstants() {
    }

} // End of class OpbConstants
