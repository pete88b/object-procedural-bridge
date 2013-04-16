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
 * array_demo.
 */
public interface ArrayDemo
        extends OpbActiveDataObject {

    /**
     * Logs the elements of the specified collection at level 101.
     * Calls the database procedure demo_one.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void demoOne(String[] pArray)
            throws OpbDataAccessException;
    

}