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

import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

/**
 * Provides methods to translate PL/SQL package source into Java files.
 * <p>
 * Please refer to the {@link com.butterfill.opb.plsql.translation} package
 * documentation for complete details of how a PL/SQL package is translated
 * to Java.
 * </p>
 * <p>
 * For all toJava methods of this class;
 * <ul>
 * <li>The PL/SQL package source files are expected to start with a package
 * specification.
 * Anything in the source file after the first package specification will be
 * ignored.
 * </li>
 * <li>
 * Existing Java files will be over-written.
 * </li>
 * </ul>
 * </p>
 *
 * @author Peter Butterfill
 */
public class PlsqlTranslator {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PlsqlTranslator.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The string template group used to create Java interfaces.
     */
    private StringTemplateGroup opbJavaStg;

    /**
     * The string template group used to create Java classes.
     */
    private StringTemplateGroup opbJavaImplStg;

    /**
     * Flag to include/exclude PL/SQL comments from generated Java code.
     */
    private boolean includePlsqlComments = true;

    /**
     * Creates a new PlsqlTranslator.
     * <br/>
     * This method calls getClass().getResourceAsStream(String) to load string
     * template groups.
     */
    public PlsqlTranslator() {
        final String methodName = "PlsqlTranslator()";

        logger.entering(CLASS_NAME, methodName);

        try {
            opbJavaStg = new StringTemplateGroup(new InputStreamReader(
                    getClass().getResourceAsStream("OpbJava.stg"), "UTF-8"));

            opbJavaImplStg = new StringTemplateGroup(new InputStreamReader(
                    getClass().getResourceAsStream("OpbJavaImpl.stg"), "UTF-8"));

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new RuntimeException(
                    "Failed to load string template group files", ex),
                    logger, CLASS_NAME, methodName);

        }

    }

    /**
     * Translates the specified PL/SQL package to Java.
     *
     * @param plsqlPackageSourceFile
     *   The PL/SQL package source file to be translated.
     * @param outputDir
     *   The directory into which Java files should be written.
     * @param javaPackageName
     *   The java package to use for all Java files created.
     * @throws java.lang.Exception
     *   If the translation fails.
     */
    public void toJava(final File plsqlPackageSourceFile, final File outputDir,
            final String javaPackageName)
            throws Exception {
        final String methodName = "toJava(String, File, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "plsqlPackageSourceFile", plsqlPackageSourceFile);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "outputDir", outputDir);

        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "javaPackageName", javaPackageName);


        final String plsqlPackageSourceFileName =
                plsqlPackageSourceFile.getCanonicalPath();

        // tell the user which file we are about to process
        logger.logp(Level.INFO, CLASS_NAME, methodName,
                "Processing source file {0}", plsqlPackageSourceFileName);

        logger.logp(Level.FINER, CLASS_NAME, methodName,
                "outputDir={0}", outputDir.getAbsolutePath());

        logger.logp(Level.FINER, CLASS_NAME, methodName,
                "javaPackageName={0}", javaPackageName);

        // parse the PL/SQL source
        final ANTLRFileStream in = new ANTLRFileStream(plsqlPackageSourceFileName);
        final PlsqlLexer lexer = new PlsqlLexer(in);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PlsqlParser parser = new PlsqlParser(tokens);
        PlsqlParser.startRule_return parserResult = parser.startRule();
        final Tree tree = (Tree) parserResult.getTree();

        logger.fine(tree.toStringTree());

        // parse the AST
        final CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        // tell it where it can find the token objects
        nodes.setTokenStream(tokens);
        // create the tree parser
        final PlsqlTreeParser treeParser = new PlsqlTreeParser(nodes);
        // pass our value for include PL/SQL comments
        treeParser.setIncludePlsqlComments(includePlsqlComments);
        // set the java package name
        treeParser.setJavaPackageName(javaPackageName);
        // invoke the start rule rule
        treeParser.startRule();

        // get the PL/SQL package from the parser and validate it
        final PlsqlPackage plsqlPackage = treeParser.getPlsqlPackage();
        plsqlPackage.validate();

        // write the Java interface to file
        StringTemplate template = opbJavaStg.getInstanceOf("javaFile");
        template.setAttribute("plsqlPackage", plsqlPackage);

        PrintWriter writer = new PrintWriter(
                outputDir.getPath() + File.separator
                + treeParser.getPlsqlPackage().getJavaInterfaceName() + ".java",
                "UTF-8");

        writer.write(template.toString());
        writer.close();

        // if the only translatable elements are constants, do not create the
        // Java class file
        if (plsqlPackage.isOnlyConstants()) {
            // tell the user if the Java class won't be created
            logger.logp(Level.INFO, CLASS_NAME, methodName,
                    "PL/SQL package has no fields, functions or procedures. "
                    + "Java class will NOT be created");

        } else {
            // write the Java class to file
            template = opbJavaImplStg.getInstanceOf("javaFile");
            template.setAttribute("plsqlPackage", plsqlPackage);

            // write the output to a file
            writer = new PrintWriter(
                    outputDir.getPath() + File.separator
                    + treeParser.getPlsqlPackage().getJavaClassName() + ".java",
                    "UTF-8");

            writer.write(template.toString());
            writer.close();

        }

        // tell the user we're done
        logger.logp(Level.INFO, CLASS_NAME, methodName,
                "Processing source file {0} complete\n",
                plsqlPackageSourceFileName);

    }

    /**
     * Translates the specified set of PL/SQL packages to Java.
     * <p>
     * This method calls toJava(File, File, String) for every file in
     * plsqlPackageSourceFiles.
     * </p>
     * @param plsqlPackageSourceFiles
     *   The set of PL/SQL packages to convert.
     * @param outputDir
     *   The directory into which Java files should be written.
     * @param javaPackageName
     *   The java package to use for all Java files created.
     * @throws java.lang.Exception
     *   If translation fails.
     */
    public void toJava(final File[] plsqlPackageSourceFiles,
            final File outputDir, final String javaPackageName)
            throws Exception {
        for (File file : plsqlPackageSourceFiles) {
            toJava(file, outputDir, javaPackageName);
        }
    }

    /**
     * Returns true if PL/SQL comments should be used in generated Java code,
     * false otherwise.
     * The default is true.
     * @return true if PL/SQL comments should be used in generated Java code.
     */
    public boolean isIncludePlsqlComments() {
        return includePlsqlComments;
    }

    /**
     * Pass true if PL/SQL comments should be used in generated Java code,
     * false otherwise.
     * @param includePlsqlComments
     *   true if PL/SQL comments should be used in generated Java code.
     */
    public void setIncludePlsqlComments(final boolean includePlsqlComments) {
        this.includePlsqlComments = includePlsqlComments;
    }

}
