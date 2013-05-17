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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Helper class for converting SQL names to Java names.
 *
 * @author Peter Butterfill
 */
public class OpbSqlNameToJavaNameHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbSqlNameToJavaNameHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Creates a new instance of OpbSqlNameToJavaNameHelper.
     */
    public OpbSqlNameToJavaNameHelper() {
        logger.entering(CLASS_NAME, "OpbSqlNameToJavaNameHelper()");

    }

    /**
     * Returns a String representation of this instance and it's values.
     *
     * @return
     *   A string representation of this OpbSqlNameToJavaNameHelper.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Contains Java names for SQL names already converted by sqlNameToJavaName(String).
     */
    private static final Map<String, String> NAME_CACHE =
            new HashMap<String, String>();

    /**
     * Converts a SQL name to a Java name.
     *
     * @param sqlName
     *   The SQL name to convert.
     * @return
     *   The Java name for the specified SQL name.
     */
    public String sqlNameToJavaName(final String sqlName) {
        // if the name is already cached, we don't need to convert
        if (!NAME_CACHE.containsKey(sqlName)) {
            final String[] nameBits = sqlName.toLowerCase().split("_");

            final StringBuilder sb = new StringBuilder();

            boolean firstBit = true;

            for (String bit : nameBits) {
                if (firstBit) {
                    firstBit = false;
                    sb.append(bit);

                } else if (bit.length() > 0) {
                    // bit.length() will be 0 if the sql name contained
                    // consecutive underscores
                    sb.append(bit.substring(0, 1).toUpperCase());
                    if (bit.length() > 1) {
                        sb.append(bit.substring(1));

                    }

                }

            } // End of for (String bit : nameBits)

            NAME_CACHE.put(sqlName, sb.toString());

        } // End of if (!NAME_CACHE.containsKey(sqlName))

        return NAME_CACHE.get(sqlName);

    } // End of sqlNameToJavaName(String)

} // End of class OpbSqlNameToJavaNameHelper
