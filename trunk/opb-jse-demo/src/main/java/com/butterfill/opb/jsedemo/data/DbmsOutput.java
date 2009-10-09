/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.1.0
 * opb-core version: 1.1.0
 */

package com.butterfill.opb.jsedemo.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * dbms_output.
 */
public interface DbmsOutput
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database procedure enable.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void enable(Long bufferSize) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure disable.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void disable() 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure put.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void put(String a) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure put_line.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void putLine(String a) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure new_line.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void newLine() 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure get_line.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void getLine(OpbValueWrapper<String> line,
            OpbValueWrapper<Long> status) 
            throws OpbDataAccessException;
    

}