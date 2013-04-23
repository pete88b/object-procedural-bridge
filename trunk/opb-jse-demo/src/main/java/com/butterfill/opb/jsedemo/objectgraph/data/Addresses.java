/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.objectgraph.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * addresses.
 */
public interface Addresses
        extends OpbActiveDataObject {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of cityId.
     * @return The value of cityId.
     */
    String getCityId();

    /**
     * Sets the value of cityId.
     * @param a The new value for cityId.
     */
    void setCityId(String a);

    /**
     * Returns the value of line1.
     * @return The value of line1.
     */
    String getLine1();

    /**
     * Sets the value of line1.
     * @param a The new value for line1.
     */
    void setLine1(String a);

    /**
     * Returns the value of line2.
     * @return The value of line2.
     */
    String getLine2();

    /**
     * Sets the value of line2.
     * @param a The new value for line2.
     */
    void setLine2(String a);


    /**
     * Returns all addresses that meet the search criteria.
     * Calls the database function get_filtered.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Address> getFiltered(String pCityId,
            String pLine1,
            String pLine2)
            throws OpbDataAccessException;

    /**
     * Calls getFiltered using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pLine1 is mapped to line1</li>
     * <li>pLine2 is mapped to line2</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Address> getFiltered()
            throws OpbDataAccessException;


}