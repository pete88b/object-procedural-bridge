/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.0.0
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.jsedemo.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * boolean_demo.
 */
public interface BooleanDemo
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database function get_true.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Boolean getTrue() 
            throws OpbDataAccessException; 
    

}