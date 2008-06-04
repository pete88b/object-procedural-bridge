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
 * exception_demo.
 */
public interface ExceptionDemo
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database procedure raise_no_data_found.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void raiseNoDataFound() 
            throws OpbDataAccessException;
    

}