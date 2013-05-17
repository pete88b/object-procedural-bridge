/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

/**
 * File created from the PL/SQL package specification
 * cat.
 */
public class CatValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this CatValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public String name;

    /**
     * Derived from an opb-package field.
     */
    public Long type;

    /**
     * Derived from an opb-package field.
     */
    public java.util.Date lastChanged;

    /**
     * Derived from an opb-package field.
     */
    public String description;

    /**
     * Derived from a read-write opb-package field.
     */
    public String descriptionDataSourceValue;


}