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

import java.util.logging.Logger;
import org.antlr.Tool;

/**
 * Generates and compiles the parsers used for PL/SQL translation.
 * <br/>
 * This class is not intended for use outside the translation package.
 * 
 * @author Peter Butterfill
 */
final class GeneratePlsqlParser {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = GeneratePlsqlParser.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Private constructor as there's no point creating an instance
     * of this class.
     */
    private GeneratePlsqlParser() {
    }
    
    /**
     * Generates and compiles the parsers defined in the grammar files Plsql.g
     * and PlsqlTreeParser.g.
     * 
     * @param args The command line arguments (which are ignored).
     * @throws Exception If we fail to generate the parser.
     */
    public static void main(final String[] args) throws Exception {
        logger.info("Start of processing for Plsql.g");
        
        // create the parser
        Tool antlr = new Tool(new String[]{
                "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g"});
        
        antlr.process();
        
        logger.info("antlr proccessing of Plsql.g complete");
        
        String[] compilerCommand = new String[]{
                "-d",
                "build/classes",
                "src/main/java/com/butterfill/opb/plsql/translation/PlsqlLexer.java",
                "src/main/java/com/butterfill/opb/plsql/translation/PlsqlParser.java"};
        
        int compilerResult = com.sun.tools.javac.Main.compile(compilerCommand);
        
        if (compilerResult == 0) {
            logger.info("compilation of PlsqlLexer and PlsqlParser ok");
        } else {
            logger.warning("compilation of PlsqlLexer and PlsqlParser failed");
            logger.info("compilerResult=" + compilerResult);
        }
        
        
        // create the tree parser
        logger.info("Start of processing for PlsqlTreeParser.g");
        
        antlr = new Tool(new String[]{
                "src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g"});
        
        antlr.process();
        
        logger.info("antlr proccessing of PlsqlTreeParser.g complete");
               
        compilerCommand = new String[]{
                "-d",
                "target/classes",
                "src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.java"};
        
        compilerResult = com.sun.tools.javac.Main.compile(compilerCommand);
        
        if (compilerResult == 0) {
            logger.info("compilation of PlsqlTreeParser ok");
        } else {
            logger.warning("compilation of PlsqlTreeParser failed");
            logger.info("compilerResult=" + compilerResult);
        }
        
    }

}
