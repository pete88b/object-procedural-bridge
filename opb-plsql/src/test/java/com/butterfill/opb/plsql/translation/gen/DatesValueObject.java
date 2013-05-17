/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

/**
 * File created from the PL/SQL package specification
 * dates.
 */
public class DatesValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this DatesValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public java.util.Date aDate;

    /**
     * Derived from a read-write opb-package field.
     */
    public java.util.Date aDateDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public java.util.Date bDate;

    /**
     * Derived from a read-write opb-package field.
     */
    public java.util.Date bDateDataSourceValue;


}