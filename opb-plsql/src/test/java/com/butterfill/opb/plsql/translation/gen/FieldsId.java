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
 * fields_id.
 */
public interface FieldsId
        extends OpbActiveCacheableEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of pk.
     * @return The value of pk.
     */
    String getPk();
    
    /**
     * Returns the value of pk2.
     * @return The value of pk2.
     */
    String getPk2();
    
    /**
     * Sets the value of pk2.
     * @param a The new value for pk2.
     */
    void setPk2(String a);
    
    /**
     * Returns the value of pk2DataSourceValue.
     * This is the last value returned by the data source for pk2.
     * @return The value of pk2DataSourceValue.
     */
    String getPk2DataSourceValue();
    
    /**
     * Returns true if the value of pk2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if pk2 has changed since it was loaded.
     */
    boolean getPk2Changed();
    
    /**
     * Returns the value of a.
     * @return The value of a.
     */
    String getA();
    

}