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
 * cities.
 */
public interface Cities
        extends OpbActiveDataObject {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of cityName.
     * @return The value of cityName.
     */
    String getCityName();

    /**
     * Sets the value of cityName.
     * @param a The new value for cityName.
     */
    void setCityName(String a);


    /**
     * Returns all cities that meet the search criteria.
     * Calls the database function get_filtered.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<City> getFiltered(String pCityName)
            throws OpbDataAccessException;

    /**
     * Calls getFiltered using mapped parameters.
     * <ul>
     * <li>pCityName is mapped to cityName</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<City> getFiltered()
            throws OpbDataAccessException;

    /**
     * Returns the ID of the specified city.
     * Calls the database function get_city_id.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getCityId(String pCityName)
            throws OpbDataAccessException;


}