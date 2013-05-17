/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.objectgraph.data;

/**
 * File created from the PL/SQL package specification
 * addresses.
 */
public class AddressesValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this AddressesValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public String cityId;

    /**
     * Derived from an opb-package field.
     */
    public String line1;

    /**
     * Derived from an opb-package field.
     */
    public String line2;


}