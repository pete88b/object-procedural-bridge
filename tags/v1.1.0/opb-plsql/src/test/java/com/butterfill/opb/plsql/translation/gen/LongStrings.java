/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.1.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * long_strings.
 */
public interface LongStrings
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database function how_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long howLong(String pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getLong(Long pHowLong) 
            throws OpbDataAccessException; 
    

    /**
     * 
     * Calls the database procedure in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void inOut(OpbValueWrapper<String> pData) 
            throws OpbDataAccessException;
    

}