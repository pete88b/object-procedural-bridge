/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

/**
 * File created from the PL/SQL package specification
 * fields.
 */
public class FieldsValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this FieldsValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public String a;

    /**
     * Derived from a read-write opb-package field.
     */
    public String aDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public String aVarchar;

    /**
     * Derived from a read-write opb-package field.
     */
    public String aVarcharDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public java.math.BigDecimal aNumber;

    /**
     * Derived from a read-write opb-package field.
     */
    public java.math.BigDecimal aNumberDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public Long aInteger;

    /**
     * Derived from a read-write opb-package field.
     */
    public Long aIntegerDataSourceValue;

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
    public String aRo;


}