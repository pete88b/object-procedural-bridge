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
 * cats.
 */
public interface Cats
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database function get_cats.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Cat> getCats() 
            throws OpbDataAccessException; 
    

}