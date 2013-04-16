/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * embedded_comments.
 */
public interface EmbeddedComments
        extends OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of include.
     * @return The value of include.
     */
    String getInclude();
    
    /**
     * Sets the value of include.
     * @param a The new value for include.
     */
    void setInclude(String a);
    
    /**
     * Returns the value of includeDataSourceValue.
     * This is the last value returned by the data source for include.
     * @return The value of includeDataSourceValue.
     */
    String getIncludeDataSourceValue();
    
    /**
     * Returns true if the value of include
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if include has changed since it was loaded.
     */
    boolean getIncludeChanged();
    

    /**
     * if the param element wasn't commented, this call would not be translated as
     * the datatype of p_data would be set to something un-known.
     * Calls the database procedure a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void a(java.math.BigDecimal pData)
            throws OpbDataAccessException;
    

}