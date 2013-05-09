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
package helpers;

import com.butterfill.opb.OpbObjectSourceImpl;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.plsql.session.OpbSessionPlsqlImpl;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbScalarResultCache;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import oracle.jdbc.pool.OracleDataSource;

/**
 * opb-library
 *
 * @author Peter Butterfill
 */
public class AssertHelper {

    public static void assertArrayEqual(Object[] expResult, Object[] result) {
        if (expResult == null && result == null) {
            return;
        }
        assertEquals("arrrays have different number of elements", expResult.length, result.length);
        for (int i = 0; i < expResult.length; i++) {
            assertEquals("i="+i, expResult[i], result[i]);
        }
    }

}
