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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.TreeParser;

/**
 * Super class for the ANTLR generated PlsqlTreeParser.
 * This class provides methods to help parse the PL/SQL source tree (that is an
 * abstract syntax tree created by PlsqlParser).
 * <br/>
 * This class is not intended for use outside the translation package.
 * 
 * @author Peter Butterfill
 */
class PlsqlTreeParserSuperClass extends TreeParser {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = 
            PlsqlTreeParserSuperClass.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /**
     * The PL/SQL package constructed by this parser.
     */
    private PlsqlPackage plsqlPackage = new PlsqlPackage();
    
    /**
     * The PL/SQL call currently being parsed.
     */
    private PlsqlCall currentCall;
    
    /**
     * The text of the last comment found.
     */
    private String lastCommentText;
    
    /**
     * Flag to include/exclude PL/SQL comments from generated Java code.
     */
    private boolean includePlsqlComments = true;
    
    
    /**
     * Creates a new parser by calling super(TreeNodeStream).
     * @param input The tree to parse.
     */
    public PlsqlTreeParserSuperClass(final TreeNodeStream input) {
        super(input);
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
    
    /**
     * Returns the PL/SQL package constructed by this parser.
     * @return The PL/SQL package constructed by this parser.
     */
    public PlsqlPackage getPlsqlPackage() {
        return plsqlPackage;
    }
    
    /**
     * Sets the Java package name that should be used for the generated class.
     * @param name A Java package name.
     */
    public void setJavaPackageName(final String name) {
        plsqlPackage.setJavaPackageName(name);
    }
    
    /**
     * Sets the name of the PL/SQL package being parsed.
     * This method converts the PL/SQL package name into Java class and 
     * interface names.
     * @param plsqlPackageName A PL/SQL package name.
     */
    public void setPlsqlPackageName(final String plsqlPackageName) {
        plsqlPackage.setSqlName(plsqlPackageName);
    }
    
    /**
     * Adds a constant to this call.
     * 
     * @param sqlName The SQL name of the constant.
     * @param sqlDatatype The SQL datatype of the constant.
     * @param sqlValue The SQL value of the constant.
     */
    public void addConstant(final String sqlName, final String sqlDatatype, 
            final String sqlValue) {
        plsqlPackage.getConstants().add(
                new PlsqlPackageConstant(
                sqlName, sqlDatatype, sqlValue, getLastCommentLines()));
    }
    
    /**
     * Clears any temp data held. 
     * Temp data should be held until the construct that it pertains to has been
     * parsed.
     * e.g. The text of the last comment parsed is saved (as temp data) until
     * another PL/SQL construct is found (e.g. another comment, a function etc).
     * The comment text may be used in the comments of a method generated from
     * a function.
     */
    public void clearTempData() {
        lastCommentText = null;
        currentCall = null;
    }
    
    /**
     * Called by the parser when a multi-line comment is found.
     * This is a no-op if s is null.
     * @param s
     *   The text of a multi-line comment.
     */
    public void setMlComment(final String s) {
        if (s == null) {
            return;
        } 
        
        // create a new OpbComment using the given text
        OpbComment opbComment = new OpbComment(s);
        
        if (opbComment.isOpbPackage()) {
            // if this is an opb package comment, create an OpbField for each
            // comment element
            opbComment.checkElementTypes("field");
            for (Map<String, String> element : opbComment.getElements()) {
                OpbField f = new OpbField();
                opbComment.applyElement(element, f);
                plsqlPackage.getFields().add(f);
                
            }
            
        } else if (opbComment.isOpb()) {
            // if this is an opb comment, we may be about to parse a PL/SQL call
            // create the call an give the call the comment
            currentCall = new PlsqlCall();
            currentCall.setOpbComment(opbComment);
            
        } else if (includePlsqlComments) {
            // if this is a regular comment (and we're including PL/SQL 
            // comments), save it as the last comment found
            lastCommentText = s;
            
        }
        
    } // End of setMlComment(String)
    
    /**
     * Breaks the last comment text into lines (that could be used in a Javadoc
     * comment) and returns the lines in a list.
     * 
     * @return The last comment text broken into separate lines.
     */
    private List<String> getLastCommentLines() {
        List<String> result = new ArrayList<String>();
        
        if (lastCommentText == null) {
            return result;
        }
        
        // replace the first /*
        // replace all */
        // keep everything upto the first full stop followed by white-space.
        String lines = lastCommentText
                .replaceFirst("/\\*[\\s]*", "")
                .replaceAll("[\\s]*\\*/", "")
                .split("\\.[\\s]+")[0];
        
        if (lines.length() > 0 && !lines.endsWith(".")) {
            lines = lines + ".";
        }
        
        for (String line : lines.split("[\\s]*(\\r\\n|\\n|\\r)[\\s]*")) {
            result.add(line);
        }
        
        lastCommentText = null;
        
        return result;
        
    } // End of getLastCommentLines()
    
    /**
     * Initialises a new function.
     */
    void initFunction() {
        if (currentCall == null) {
            currentCall = new PlsqlCall();
        }
        currentCall.setFunction(true);
        currentCall.setCommentLines(getLastCommentLines());
    }
    
    /**
     * Sets details of the function previously initialise by initFunction().
     * <p>
     * Note: 2 part datatypes are of the form [owner or package].[datatype].
     * e.g. DBMS_SQL.VARCHAR2_TABLE
     * </p>
     * @param sqlName
     *   The SQL name of the function.
     * @param sqlDatatypeA
     *   Either the datatype of return for this call or the first part of
     *   the 2 part datatype of return for this call.
     * @param sqlDatatypeB
     *   Either the second part of the 2 part datatype of return for this call
     *   or null (if this is a 1 part datatype).
     */
    void setFunctionInfo(final String sqlName, final String sqlDatatypeA, 
            final String sqlDatatypeB) {
        final String methodName = "setFunctionInfo(String, String, String)";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINER, CLASS_NAME, methodName, 
                "sqlName={0}, sqlDatatypeA{1}, sqlDatatypeB{2}",
                new Object[]{sqlName, sqlDatatypeA, sqlDatatypeB});
        
        currentCall.setSqlName(sqlName);
        currentCall.setSqlReturnType(
                toSqlDatatype(sqlDatatypeA, sqlDatatypeB));
        // add the current call to the package
        plsqlPackage.getFunctions().add(currentCall);
        
    }
    
    /**
     * Initialises a new procedure.
     */
    public void initProcedure() {
        if (currentCall == null) {
            currentCall = new PlsqlCall();
        }
        currentCall.setProcedure(true);
        currentCall.setCommentLines(getLastCommentLines());
    }
    
    /**
     * Sets details of the procedure previously initialised by initProcedure().
     * 
     * @param sqlName The SQL name of the procedure.
     */
    public void setProcedureInfo(final String sqlName) {
        final String methodName = "setProcedureInfo(String)";

        logger.entering(CLASS_NAME, methodName);
        
        logger.logp(Level.FINER, CLASS_NAME, methodName, "sqlName={0}", sqlName);
        
        currentCall.setSqlName(sqlName);
        
        // add the current call to the package
        plsqlPackage.getProcedures().add(currentCall);
        
    }
    
    /**
     * Adds a parameter to this call.
     * <p>
     * Note: 2 part datatypes are of the form [owner or package].[datatype].
     * e.g. DBMS_SQL.VARCHAR2_TABLE
     * </p>
     * @param sqlName
     *   The SQL name of the parameter.
     * @param sqlDatatypeA
     *   Either the datatype of return for this call or the first part of
     *   the 2 part datatype of return for this call.
     * @param sqlDatatypeB
     *   Either the second part of the 2 part datatype of return for this call
     *   or null (if this is a 1 part datatype).
     * @param in
     *   Pass a non-null object if this is an IN parameter.
     * @param out
     *   Pass a non-null object if this is an OUT parameter.
     */
    public void addParam(final String sqlName, final String sqlDatatypeA, 
            final String sqlDatatypeB, final Object in, final Object out) {
        
        /*
         * The parameter will be an IN parameter if specified as in or it's mode has not
         * been specified at all.
         * 
         * in != null || (in == null && out == null)
         */
        
        PlsqlCallParameter p = new PlsqlCallParameter(
                sqlName, 
                toSqlDatatype(sqlDatatypeA, sqlDatatypeB), 
                in != null || (in == null && out == null), 
                out != null);
        
        currentCall.addParameter(p);
        // Note: Only return can use the scalar result cache
    }
    
    /**
     * Converts a 2 part SQL datatype into a 1 part SQL datatype.
     * <br/><br/>
     * e.g.
     * <pre>
     * toSqlDatatype("dbms_sql", "varchar2_table") -> dbms_sql.varchar2_table
     * toSqlDatatype(null, "varchar2_table")       -> varchar2_table
     * </pre>
     * @param sqlDatatypeA
     *   Part 1 of the SQL datatype.
     * @param sqlDatatypeB
     *   Part 2 of the SQL datatype.
     * @return
     *   A one part SQL datatype.
     */
    private String toSqlDatatype(final String sqlDatatypeA, final String sqlDatatypeB) {
        return (sqlDatatypeA != null) ? 
                sqlDatatypeA + "." + sqlDatatypeB :
                sqlDatatypeB;
    }

}
