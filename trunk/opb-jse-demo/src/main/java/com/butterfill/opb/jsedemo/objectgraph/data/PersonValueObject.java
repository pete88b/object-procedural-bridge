/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.objectgraph.data;

/**
 * File created from the PL/SQL package specification
 * person.
 */
public class PersonValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PersonValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public Long personId;

    /**
     * Derived from an opb-package field.
     */
    public String lastName;

    /**
     * Derived from a read-write opb-package field.
     */
    public String lastNameDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public Long addressId;

    /**
     * Derived from a read-write opb-package field.
     */
    public Long addressIdDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public String firstName;

    /**
     * Derived from a read-write opb-package field.
     */
    public String firstNameDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public String addressLabel;

    /**
     * Derived from an opb-package field.
     */
    public String cityLabel;


}