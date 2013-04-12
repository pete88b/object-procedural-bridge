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
 * user_defined_collection_demo.
 */
public interface UserDefinedCollectionDemo
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * 
     * Calls the database function echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal[] echo(Object[] pData) 
            throws OpbDataAccessException; 
    

}