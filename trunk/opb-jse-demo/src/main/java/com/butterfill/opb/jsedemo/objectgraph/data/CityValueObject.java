/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.objectgraph.data;

/**
 * File created from the PL/SQL package specification
 * city.
 */
public class CityValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this CityValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public Long cityId;

    /**
     * Derived from an opb-package field.
     */
    public String cityName;

    /**
     * Derived from a read-write opb-package field.
     */
    public String cityNameDataSourceValue;


}