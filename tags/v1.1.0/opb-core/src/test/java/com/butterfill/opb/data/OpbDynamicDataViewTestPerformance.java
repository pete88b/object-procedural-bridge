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

import junit.framework.*;
import com.butterfill.opb.session.OpbSession;
import helpers.TestHelper;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Peter Butterfill
 */
public class OpbDynamicDataViewTestPerformance extends TestCase {
    
    public OpbDynamicDataViewTestPerformance(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        
    }

    @Override
    protected void tearDown() throws Exception {
    }

    
    /**
     * Test of opbLoad method, of class com.butterfill.opb.data.OpbDynamicDataViewImpl.
     */
    public void testOpbLoad() throws Exception {
        System.out.println("opbLoad");
        
        //OpbToStringHelper.setToStringMode(OpbToStringMode.FULL);
        
        ResultSet resultSet = null;
        
        ResultSet rs = TestHelper.getResultSet(
                "SELECT * " +
                "  FROM dba_tab_columns " +
                " WHERE rownum < 101");
        
        int count = 0;
        
        long start = System.currentTimeMillis();
        
        while (rs.next()) {
            count++;
            OpbDynamicDataViewImpl instance = new OpbDynamicDataViewImpl();
            instance.opbLoad(rs);

        }
        
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
        System.out.println("Count: " + count);
        
    }
    
    
}
