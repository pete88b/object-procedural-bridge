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

import com.butterfill.opb.OpbConstants;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an Opb field. 
 * This is a field created from an Opb package comment element.
 * <br/>
 * This class is not intended for use outside the translation package.
 * 
 * @author Peter Butterfill
 */
class OpbField {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbField.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /**
     * The SQL name of this field.
     */
    private String sqlName;
    
    /**
     * The Java name of this field.
     */
    private String name;
    
    /**
     * The Java name of this field with the first character upper cased - 
     * so that we can create getters and setters by prependin get and set.
     */
    private String nameWithFirstCharUpper;
    
    /**
     * The SQL datatype of this field.
     */
    private String sqlDatatype;
    
    /**
     * The Java datatype of this field.
     */
    private String datatype;
    
    /**
     * The SQL initial value of this field.
     */
    private String sqlInitialValue;
    
    /**
     * The Java initial value of this field.
     */
    private String initialValue = "null";
    
    /**
     * Set to true if this is an ID field.
     */
    private boolean id;
    
    /**
     * List of no-arg methods that should be called when the value of this
     * field changes.
     */
    private final List<String> onChangeList = new ArrayList<String>();
    
    /**
     * Set to true if this field is optional in the opbLoad method.
     */
    private boolean optionalInLoad;
    
    /**
     * Set to true if this field is read-only.
     */
    private Boolean readOnly;
    
    /**
     * Set to false if this field is not loadable.
     * Once set to false, this field should not be set back to true.
     */
    private boolean loadable = true;

    /**
     * The translation helper used by this class.
     */
    private final PlsqlTranslationHelper translationHelper = 
            new PlsqlTranslationHelper();
    
    
    /**
     * Creates a new PlsqlPackageField.
     */
    public OpbField() {
        sqlDatatype = OpbConstants.DEFAULT_DATATYPE;
        datatype = translationHelper.toJavaDatatype(sqlDatatype);
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this PlsqlPackageField.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    
    /**
     * Sets the name property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_name(final String s) {
        sqlName = s.toLowerCase();
        name = translationHelper.toJavaMemberName(s);
        nameWithFirstCharUpper = translationHelper.toJavaClassName(s);
    }
    
    /**
     * Sets the datatype property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_datatype(final String s) {
        sqlDatatype = s.toUpperCase();
        datatype = translationHelper.toJavaDatatype(s);
    }
    
    /**
     * Sets the initial_value property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_initial_value(final String s) {
        sqlInitialValue = s;
    }
    
    /**
     * Sets the id property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_id(final String s) {
        id = translationHelper.toBoolean(s, id);
    }
    
    /**
     * Sets the on_change property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_on_change(final String s) {
        onChangeList.add(translationHelper.toJavaMemberName(s));
    }
    
    /**
     * Sets the in_load property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_in_load(final String s) {
        final String methodName = "opb_in_load(String)";
        
        if ("optional".equalsIgnoreCase(s)) {
            optionalInLoad = true;
            loadable = true;
            
        } else if ("required".equalsIgnoreCase(s)) {
            optionalInLoad = false;
            loadable = true;
            
        } else if ("ignored".equalsIgnoreCase(s)) {
            loadable = false;
            
        } else {
            logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                    "{0}{1}{2}{3}", new Object[]{
                    "Unknown value for in_load property of a ",
                    "field element in an opb-package comment. ",
                    s, ". Expecting optional, required or ignored."});

        }
        
    }
    
    /**
     * Sets the read_only property of this field.
     * @param s The value of the property.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_read_only(final String s) {
        readOnly = translationHelper.toBoolean(s, readOnly);
    }
    
    /**
     * Sets the loadable attribute based on the SQL datatype, 
     * the initial value of this field and 
     * logs a warning if this is an ID field and is not loadable.
     * <br/>
     * Called when all Opb comment properties have been set.
     * @see OpbComment#applyElement(Map, Object)
     */
    public void opb_applyElementComplete() {
        final String methodName = "opb_applyElementComplete()";
        
        // check that the SQL datatype is loadable
        if (!translationHelper.isLoadableType(sqlDatatype)) {
            loadable = false;
        }
        
        // if we have been given an initial value, convert to a Java literal
        if (sqlInitialValue != null) {
            initialValue = translationHelper.toJavaLiteral(
                    sqlInitialValue, sqlDatatype);
        }
        
        // warn the user if an ID field is not loadable
        if (id && !loadable) {
            logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                    "{0}{1}{2}", new Object[]{
                    "field ", sqlName,
                    " has been set as an ID field but is not loadable"});
        }
        
    } // End of opb_applyElementComplete()
    
    /**
     * Returns the SQL name of this field.
     * @return The SQL name of this field.
     */
    public String getSqlName() {
        return sqlName;
    }

    /**
     * Returns the Java name of this field.
     * @return The Java name of this field.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Java name of this field with the first character upper cased.
     * @return The Java name of this field with the first character upper cased.
     */
    public String getNameWithFirstCharUpper() {
        return nameWithFirstCharUpper;
    }

    /**
     * Returns the SQL datatype of this field.
     * @return The SQL datatype of this field.
     */
    public String getSqlDatatype() {
        return sqlDatatype;
    }

    /**
     * Returns the Java datatype of this field.
     * @return The Java datatype of this field.
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * Returns the SQL initial value of this field.
     * @return The SQL initial value of this field.
     */
    public String getSqlInitialValue() {
        return sqlInitialValue;
    }

    /**
     * Returns the Java initial value of this field.
     * @return The Java initial value of this field.
     */
    public String getInitialValue() {
        return initialValue;
    }

    /**
     * Returns true if this is an ID field, false otherwise.
     * @return true if this is an ID field.
     */
    public boolean isId() {
        return id;
    }

    /**
     * Returns a list of no-arg method names that should be called when the 
     * value of this field changes.
     * @return The on change list of this field.
     */
    public List<String> getOnChangeList() {
        return onChangeList;
    }

    /**
     * Returns true if this field is optionally loaded by the opbLoad method.
     * @return true if this field is optional in the load method.
     */
    public boolean isOptionalInLoad() {
        return optionalInLoad;
    }

    /**
     * Returns true if this field is read-only.
     * @return true if this field is read-only.
     */
    public boolean isReadOnly() {
        return (readOnly == null) ? id : readOnly;
    }

    /**
     * Returns true if this field is loadable.
     * @return true if this field is loadable.
     */
    public boolean isLoadable() {
        return loadable;
    }
    
    /**
     * Returns true if this field has a data source value.
     * @return true if this field has a data source value.
     */
    public boolean getHasDatasourceValue() {
        return isLoadable() && !isReadOnly();
    }

    /**
     * Validates this field.
     * A field is valid if we were able to translate the SQL datatype into a
     * Java datatype.
     * @return true if this field is valid, false otherwise.
     */
    public boolean validate() {
        final String methodName = "validate()";
        
        logger.entering(CLASS_NAME, methodName);
        
        if (datatype == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to translate datatype '");
            sb.append(sqlDatatype);
            sb.append("' of field '");
            sb.append(sqlName);
            sb.append("'. ");
            sb.append("This field will be ignored");
            // warn the user
            logger.logp(Level.SEVERE, CLASS_NAME, methodName, sb.toString());
            
            return false;
            
        }
        
        return true;
    }
    
}
