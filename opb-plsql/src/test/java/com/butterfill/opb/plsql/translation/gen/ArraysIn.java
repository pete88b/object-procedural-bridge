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
 * arrays_in.
 */
public interface ArraysIn
        extends OpbActiveDataObject {

    /**
     * 
     * Calls the database procedure test_one.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void testOne(String[] pArray)
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure test_two.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void testTwo(java.math.BigDecimal[] pArray)
            throws OpbDataAccessException;
    

}