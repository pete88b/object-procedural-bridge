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
 * param_datatype.
 */
public interface ParamDatatype
        extends OpbActiveDataObject {

    /**
     * 
     * Calls the database function invalid_1.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal invalid1()
            throws OpbDataAccessException;
    

    /**
     * 
     * Calls the database procedure invalid_2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void invalid2(java.math.BigDecimal p1)
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure dodgy.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void dodgy(OpbValueWrapper<Long> p1,
            OpbValueWrapper<Long> p2)
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void a(Long p1,
            Long p2)
            throws OpbDataAccessException;
    

}