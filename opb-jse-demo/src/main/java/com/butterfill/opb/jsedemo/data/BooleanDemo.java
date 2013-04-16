/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * boolean_demo.
 */
public interface BooleanDemo
        extends OpbActiveDataObject {

    /**
     * 
     * Calls the database function get_true.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Boolean getTrue()
            throws OpbDataAccessException;
    

}