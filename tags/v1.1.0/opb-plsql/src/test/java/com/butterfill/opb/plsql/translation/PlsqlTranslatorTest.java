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

package com.butterfill.opb.plsql.translation;

import java.io.File;
import java.io.FileFilter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * @author Peter Butterfill
 */
public class PlsqlTranslatorTest extends TestCase {
    
    public PlsqlTranslatorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(PlsqlTranslatorTest.class);
        return suite;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of toJava method, of class PlsqlTranslator.
     */
    public void testToJava() throws Exception {
        System.out.println("toJava");
        
        File inputDir = new File(
                "src/test/resources/com/butterfill/opb/plsql/translation");
        File outputDir = new File(
                "src/test/java/com/butterfill/opb/plsql/translation/gen");
        String javaPackageName = "com.butterfill.opb.plsql.translation.gen";
        PlsqlTranslator instance = new PlsqlTranslator();
        
        File[] files = inputDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".spc") ||
                        pathname.getName().endsWith(".pck");
            }
        });
        
        instance.setIncludePlsqlComments(true);
        
        instance.toJava(files, outputDir, javaPackageName);
        
    }
    
}
