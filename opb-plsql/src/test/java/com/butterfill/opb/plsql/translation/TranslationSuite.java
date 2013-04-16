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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Peter Butterfill
 */
public class TranslationSuite extends TestCase {

    public TranslationSuite(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite("TranslationSuite");

        suite.addTest(com.butterfill.opb.plsql.translation.DatatypeMapTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.GeneratePlsqlParserTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.OpbCommentTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.OpbFieldTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlCallParameterTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlCallTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlLexerTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlPackageConstantTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlPackageTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlParserTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlTranslationHelperTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlTranslatorTest.suite());
//        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlTranslatorPart2Test.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlTreeParserSuperClassTest.suite());
        suite.addTest(com.butterfill.opb.plsql.translation.PlsqlTreeParserTest.suite());

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

}
