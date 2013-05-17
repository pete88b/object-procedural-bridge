/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.data;

/**
 * File created from the PL/SQL package specification
 * dbms_output.
 */
public class DbmsOutputValueObject {

    /**
     * The name of this class.
     */
    public final String CLASS_NAME =
            DbmsOutputValueObject.class.getName();

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this DbmsOutputValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

}