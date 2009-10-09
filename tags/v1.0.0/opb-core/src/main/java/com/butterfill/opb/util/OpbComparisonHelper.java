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
 * Provides methods to perform comparisons.
 *
 * @author Peter Butterfill
 */
public final class OpbComparisonHelper {

    /**
     * Creates a new instance of OpbComparisonHelper.
     * This is private as this class contains only static methods.
     * i.e. There is no point creating an instance of this class.
     */
    private OpbComparisonHelper() {
    }

    /**
     * Returns true if a and b are considered to be equal.
     * <br/>
     * Returns true if;
     * <ul>
     * <li>a and b are the same instance,</li>
     * <li>a and b are both null or</li>
     * <li>a is equal to b according to a's equals(Object obj) method.</li>
     * </ul>
     *
     * @param a Object to compare with b. Can be null
     * @param b Object to compare with a. Can be null
     * @return true if a and b are equal
     */
    public static boolean isEqual(final Object a, final Object b) {

        // If a and b are NOT often the same instance
        //return a == null ? b == null : a.equals(b);

        // If a and b are often the same instance
        return a == b || (a != null && a.equals(b));

        /*
          All tests used Object except for a != b (a.equals(b) == true) which
          used String.

          return a == null ? b == null : a.equals(b);
            iterations=20000000
            a == b
            duration=1129ms
            a != b
            duration=1128ms
            a != b (a == null)
            duration=909ms
            a != b (b == null)
            duration=1113ms
            a != b (a.equals(b) == true)
            duration=1725ms

          return a == b || (a != null && a.equals(b));
            iterations=20000000
            a == b
            duration=1019ms
            a != b
            duration=1128ms
            a != b (a == null)
            duration=910ms
            a != b (b == null)
            duration=1128ms
            a != b (a.equals(b) == true)
            duration=1756ms
        */

    } // End of isEqual(Object, Object)

} // End of class OpbComparisonHelper
