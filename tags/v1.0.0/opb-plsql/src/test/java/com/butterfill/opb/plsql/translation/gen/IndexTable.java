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
 * index_table.
 */
public interface IndexTable
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of numberArray.
     * @return The value of numberArray.
     */
    java.math.BigDecimal[] getNumberArray();
    
    /**
     * Sets the value of numberArray.
     * @param a The new value for numberArray.
     */
    void setNumberArray(java.math.BigDecimal[] a);
    
    /**
     * Returns the value of varcharArray.
     * @return The value of varcharArray.
     */
    String[] getVarcharArray();
    
    /**
     * Sets the value of varcharArray.
     * @param a The new value for varcharArray.
     */
    void setVarcharArray(String[] a);
    

    /**
     * 
     * Calls the database procedure a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void a(String[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure a2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void a2(java.math.BigDecimal[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure a3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void a3(Long[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure x.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void x(String[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure x2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void x2(java.math.BigDecimal[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure x3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void x3(Long[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure y2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void y2(String[] pData) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure z.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void z(String[] pData,
            Long[] pData2,
            String[] pData3) 
            throws OpbDataAccessException;
    

}