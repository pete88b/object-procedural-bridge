/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * fields_in_load.
 */
public interface FieldsInLoad
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of fDefault.
     * @return The value of fDefault.
     */
    String getFDefault();
    
    /**
     * Returns the value of fOptional.
     * @return The value of fOptional.
     */
    String getFOptional();
    
    /**
     * Returns the value of fIgnored.
     * @return The value of fIgnored.
     */
    String getFIgnored();
    

}