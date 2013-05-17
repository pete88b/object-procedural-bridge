/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

/**
 * File created from the PL/SQL package specification
 * embedded_comments.
 */
public class EmbeddedCommentsValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this EmbeddedCommentsValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public String include;

    /**
     * Derived from a read-write opb-package field.
     */
    public String includeDataSourceValue;


}