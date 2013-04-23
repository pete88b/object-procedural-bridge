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
 * people.
 */
public interface People
        extends OpbActiveDataObject {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of lastName.
     * @return The value of lastName.
     */
    String getLastName();

    /**
     * Sets the value of lastName.
     * @param a The new value for lastName.
     */
    void setLastName(String a);

    /**
     * Returns the value of addressId.
     * @return The value of addressId.
     */
    String getAddressId();

    /**
     * Sets the value of addressId.
     * @param a The new value for addressId.
     */
    void setAddressId(String a);

    /**
     * Returns the value of firstName.
     * @return The value of firstName.
     */
    String getFirstName();

    /**
     * Sets the value of firstName.
     * @param a The new value for firstName.
     */
    void setFirstName(String a);


    /**
     * Returns all people that meet the search criteria.
     * Calls the database function get_filtered.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Person> getFiltered(String pLastName,
            String pFirstName,
            String pAddress,
            String pCity)
            throws OpbDataAccessException;


}