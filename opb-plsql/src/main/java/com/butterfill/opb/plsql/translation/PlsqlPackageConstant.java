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


import java.util.List;
import java.util.logging.Logger;

/**
 * Represents a constant defined in a PL/SQL package specification.
 * <br/>
 * This class is not intended for use outside the translation package.
 * @author Peter Butterfill
 */
class PlsqlPackageConstant {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PlsqlPackageConstant.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The translation helper used by this class.
     */
    private final PlsqlTranslationHelper translationHelper =
            new PlsqlTranslationHelper();

    /**
     * The SQL name of this constant.
     */
    private final String sqlName;

    /**
     * The Java name of this constant.
     */
    private final String name;

    /**
     * The SQL datatype of this constant.
     */
    private final String sqlDatatype;

    /**
     * The Java datatype of this constant.
     */
    private final String datatype;

    /**
     * The SQL value of this constant.
     */
    private final String sqlValue;

    /**
     * The Java value of this constant.
     */
    private final String value;

    /**
     * The comment for this constant.
     */
    private final List<String> commentLines;

    /**
     * Creates a fully configured instance of a PlsqlPackageConstant.
     * @param sqlName The SQL name of this constant.
     * @param sqlDatatype The SQL datatype of this constant.
     * @param sqlValue The SQL value of this constant.
     * @param commentLines The comment for this constant.
     */
    public PlsqlPackageConstant(final String sqlName, final String sqlDatatype,
            final String sqlValue, final List<String> commentLines) {
        final String methodName = "PlsqlPackageConstant(String, String, String, List<String>)";

        logger.entering(CLASS_NAME, methodName);

        this.sqlName = sqlName;
        this.name = translationHelper.toJavaConstantName(sqlName);

        this.sqlDatatype = sqlDatatype;
        this.datatype = translationHelper.toJavaDatatype(sqlDatatype);

        this.sqlValue = sqlValue;
        this.value = translationHelper.toJavaLiteral(sqlValue, sqlDatatype);

        this.commentLines = commentLines;

    }

    /**
     * Reurns the SQL name of this constant.
     * @return The SQL name of this constant.
     */
    public String getSqlName() {
        return sqlName;
    }

    /**
     * Reurns the Java name of this constant.
     * @return The Java name of this constant.
     */
    public String getName() {
        return name;
    }

    /**
     * Reurns the SQL datatype of this constant.
     * @return The SQL datatype of this constant.
     */
    public String getSqlDatatype() {
        return sqlDatatype;
    }

    /**
     * Reurns the Java datatype of this constant.
     * @return The Java datatype of this constant.
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * Reurns the SQL value of this constant.
     * @return The SQL value of this constant.
     */
    public String getSqlValue() {
        return sqlValue;
    }

    /**
     * Reurns the Java value of this constant.
     * @return The Java value of this constant.
     */
    public String getValue() {
        return value;
    }

    /**
     * Reurns the comment for this constant.
     * @return The comment for of this constant.
     */
    public List<String> getCommentLines() {
        return commentLines;
    }

    /**
     * Validates this constant returning true if this constant is valid.
     * This implementation returns true if the Java datatype is not null.
     * @return true if this constant is valid.
     */
    public boolean validate() {
        return datatype != null;
    }

}
