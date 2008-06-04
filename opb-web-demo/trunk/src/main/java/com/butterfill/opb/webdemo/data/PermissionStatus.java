/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.0.0
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.webdemo.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * permission_status.
 */
public interface PermissionStatus
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of value.
     * @return The value of value.
     */
    Long getValue();
    
    /**
     * Returns the value of label.
     * @return The value of label.
     */
    String getLabel();
    

}