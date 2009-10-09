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
import com.butterfill.opb.util.OpbAssert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Represents a PL/SQL package.
 * A fully configured instance of this class contains all the information
 * needed to generate Java code.
 * <br/>
 * This class is not intended for use outside the translation package.
 * 
 * @author Peter Butterfill
 */
class PlsqlPackage {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PlsqlPackage.class.getName();
    
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /**
     * The translastion helper used by this class.
     */
    private final PlsqlTranslationHelper translationHelper =
            new PlsqlTranslationHelper();
    
    /**
     * The title given to the opb-library project.
     */
    private String opbLibraryTitle;
    
    /**
     * The version of the opb-library project.
     */
    private String opbLibraryVersion;
    
    /**
     * The title given to the this project.
     */
    private String opbPlsqlTitle;
    
    /**
     * The version of this project.
     */
    private String opbPlsqlVersion;
    
    /**
     * The SQL name of this PL/SQL package.
     */
    private String sqlName;
    
    /**
     * The name of the Java class that should be created by translating this
     * PL/SQL package.
     */
    private String javaClassName;
    
    /**
     * The name of the Java interface that should be created by translating this
     * PL/SQL package.
     */
    private String javaInterfaceName;
    
    /**
     * The name of the Java package that should be used for both the class and
     * interface generated from this PL/SQL package.
     */
    private String javaPackageName;
    
    /**
     * The fields of this PL/SQL package. 
     * As defined in an opb-package comment.
     */
    private final List<OpbField> fields = new ArrayList<OpbField>();
    
    /**
     * The constants of this PL/SQL package.
     */
    private final List<PlsqlPackageConstant> constants = 
            new ArrayList<PlsqlPackageConstant>();
    
    /**
     * The function of this PL/SQL package.
     */
    private final List<PlsqlCall> functions = new ArrayList<PlsqlCall>();
    
    /**
     * The procedures of this PL/SQL package.
     */
    private final List<PlsqlCall> procedures = new ArrayList<PlsqlCall>();
    
    
    /**
     * Creates a new instance of a PlsqlPackage initialising the title and
     * version of this project and the opb-library project.
     */
    public PlsqlPackage() {
        // get package info for opb-library
        Package p = OpbConstants.class.getPackage();
        opbLibraryTitle = p.getImplementationTitle();
        opbLibraryVersion = p.getImplementationVersion();
        
        // get package info for opb-plsql
        p = getClass().getPackage();
        opbPlsqlTitle = p.getImplementationTitle();
        opbPlsqlVersion = p.getImplementationVersion();
    }
    
    /**
     * Returns the title of the opb-library project.
     * @return The title of the opb-library project.
     */
    public String getOpbLibraryTitle() {
        return opbLibraryTitle;
    }

    /**
     * Returns the version of the opb-library project.
     * @return The version of the opb-library project.
     */
    public String getOpbLibraryVersion() {
        return opbLibraryVersion;
    }

    /**
     * Returns the title of this project.
     * @return The title of this project.
     */
    public String getOpbPlsqlTitle() {
        return opbPlsqlTitle;
    }

    /**
     * Returns the version of this project.
     * @return The version of this project.
     */
    public String getOpbPlsqlVersion() {
        return opbPlsqlVersion;
    }
    
    /**
     * Returns the fields of this PL/SQL package.
     * @return The fields of this PL/SQL package.
     */
    public List<OpbField> getFields() {
        return fields;
    }

    /**
     * Returns the constants of this PL/SQL package.
     * @return The constants of this PL/SQL package.
     */
    public List<PlsqlPackageConstant> getConstants() {
        return constants;
    }
    
    /**
     * Returns the SQL name of this PL/SQL package.
     * @return The SQL name of this PL/SQL package.
     */
    public String getSqlName() {
        return sqlName;
    }

    /**
     * Sets the SQL name of this PL/SQL package.
     * This also sets the interface and class name for this PL/SQL package.
     * @param sqlName The SQL name of this PL/SQL package.
     */
    public void setSqlName(final String sqlName) {
        this.sqlName = sqlName;
        javaInterfaceName = translationHelper.toJavaClassName(sqlName);
        javaClassName = translationHelper.toJavaClassName(sqlName) + "Impl";
    }

    /**
     * Returns the Java package that should be used for both the class and
     * interface generated from this PL/SQL package.
     * @return The Java package.
     */
    public String getJavaPackageName() {
        return javaPackageName;
    }

    /**
     * Sets the Java package that should be used for both the class and
     * interface generated from this PL/SQL package.
     * @param javaPackageName 
     *   The Java package that should be used for both the class and
     *   interface generated from this PL/SQL package.
     */
    public void setJavaPackageName(final String javaPackageName) {
        this.javaPackageName = javaPackageName;
    }
    
    /**
     * Validates this PL/SQL package.
     * <br/>
     * If the Java Interface name of this instance is null, an exception is thrown.
     * If we don't know the interface name, something has gone badly wrong.
     * <br/>
     * For all functions, procedures, constants and fields of this 
     * PL/SQL package validate() is called - if validate() returns false, the 
     * function, procedure, constant or field is removed from this 
     * PL/SQL package.
     */
    public void validate() {
        final String method = "validate()";
        
        OpbAssert.notNull(
                logger, CLASS_NAME, method, 
                "javaInterfaceName", javaInterfaceName,
                "Java Interface name is missing. Something has gone badly wrong");
        
        for (Iterator<PlsqlCall> i = functions.iterator(); i.hasNext();) {
            if (!i.next().validate()) {
                i.remove();
            }
        }
        
        for (Iterator<PlsqlCall> i = procedures.iterator(); i.hasNext();) {
            if (!i.next().validate()) {
                i.remove();
            }
        }
        
        for (Iterator<PlsqlPackageConstant> i = constants.iterator(); i.hasNext();) {
            if (!i.next().validate()) {
                i.remove();
            }
        }
        
        for (Iterator<OpbField> i = fields.iterator(); i.hasNext();) {
            if (!i.next().validate()) {
                i.remove();
            }
        }
        
    } // End of validate()
    
    /**
     * Returns the names of all ID fields of this package.
     * @return The names of all ID fields of this package.
     */
    public List<String> getIdFieldNames() {
        List<String> result = new ArrayList<String>();
        for (OpbField field : fields) {
            if (field.isId()) {
                result.add(field.getName());
            }
        }
        return result;
    }
    
    /**
     * Returns the unqualified name of the class that should be used when
     * a value wrapper is needed.
     * @return Name of the default value wrapper.
     */
    public String getDefaultValueWrapper() {
        return OpbConstants.DEFAULT_VALUE_WRAPPER
                .substring(OpbConstants.DEFAULT_VALUE_WRAPPER
                .lastIndexOf(".") + 1);
    }
    
    /**
     * Returns true if this package is identifiable, false otherwise.
     * This will be true if at least one field of this package is an ID field.
     * @return true if this package is identifiable, false otherwise.
     */
    public boolean isIdentifiable() {
        for (OpbField field : fields) {
            if (field.isId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this package is loadable, false otherwise.
     * This will be true if at least one field of this package is loadable.
     * @return true if this package is loadable, false otherwise.
     */
    public boolean isLoadable() {
        for (OpbField field : fields) {
            if (field.isLoadable()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns true if this package contains only constants, false otherwise.
     * @return true if this package has no fields, functions or procedures.
     */
    public boolean isOnlyConstants() {
        return fields.isEmpty() &&
                functions.isEmpty() &&
                procedures.isEmpty();
    }
    
    /**
     * Returns true if this package uses the scalar result cache, 
     * false otherwise.
     * This will be true if at least one parameter of a call uses the scalar 
     * result cache.
     * @return true if this package uses the scalar result cache.
     */
    public boolean isUseScalarResultCache() {
        for (PlsqlCall call : functions) {
            if (call.getReturn().isUseScalarResultCache()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the name of the Java class that should be created by translating 
     * this PL/SQL package.
     * @return The name of the Java class that should be created by translating 
     * this PL/SQL package.
     */
    public String getJavaClassName() {
        return javaClassName;
    }

    /**
     * Returns the name of the Java interface that should be created by 
     * translating this PL/SQL package.
     * @return The name of the Java interface that should be created by 
     * translating this PL/SQL package.
     */
    public String getJavaInterfaceName() {
        return javaInterfaceName;
    }

    /**
     * Returns the functions of this PL/SQL package.
     * @return The functions of this PL/SQL package.
     */
    public List<PlsqlCall> getFunctions() {
        return functions;
    }

    /**
     * Returns the procedures of this PL/SQL package.
     * @return The procedures of this PL/SQL package.
     */
    public List<PlsqlCall> getProcedures() {
        return procedures;
    }

}
