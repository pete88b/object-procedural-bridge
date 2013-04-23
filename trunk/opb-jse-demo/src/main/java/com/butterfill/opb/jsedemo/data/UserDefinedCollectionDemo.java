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
 * user_defined_collection_demo.
 */
public interface UserDefinedCollectionDemo
        extends OpbActiveDataObject {

    /**
     * 
     * Calls the database function echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.math.BigDecimal[] echo(Object[] pData)
            throws OpbDataAccessException;


}