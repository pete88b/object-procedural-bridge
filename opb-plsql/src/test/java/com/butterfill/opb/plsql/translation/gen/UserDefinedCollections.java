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
 * user_defined_collections.
 */
public interface UserDefinedCollections
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database function get_null.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal[] getNull() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function echo_number_table.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal[] echoNumberTable(Object[] pData) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function how_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String howLong(Object[] pData,
            OpbValueWrapper<String[]> pResults) 
            throws OpbDataAccessException; 
    

    /**
     * 
     * Calls the database procedure get_null_proc.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void getNullProc(OpbValueWrapper<java.math.BigDecimal[]> pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure simple_in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void simpleInOut(OpbValueWrapper<String[]> pData) 
            throws OpbDataAccessException;
    

}