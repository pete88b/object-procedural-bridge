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
 * city.
 */
public interface City
        extends OpbActiveCacheableEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of cityId.
     * @return The value of cityId.
     */
    Long getCityId();

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
     * Returns the value of cityNameDataSourceValue.
     * This is the last value returned by the data source for cityName.
     * @return The value of cityNameDataSourceValue.
     */
    String getCityNameDataSourceValue();

    /**
     * Returns true if the value of cityName
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if cityName has changed since it was loaded.
     */
    boolean getCityNameChanged();


    /**
     * Returns all addresses of the specified city.
     * Calls the database function get_addresses.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Address> getAddresses(Long pCityId)
            throws OpbDataAccessException;

    /**
     * Calls getAddresses using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Address> getAddresses()
            throws OpbDataAccessException;


    /**
     * Deletes a City by primary key.
     * Calls the database procedure del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void del(Long pCityId,
            String pOldCityName)
            throws OpbDataAccessException;

    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pOldCityName is mapped to cityNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void del()
            throws OpbDataAccessException;

    /**
     * Creates a City returning it's new primary key value(s).
     * Calls the database procedure ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void ins(OpbValueWrapper<Long> pCityId,
            String pCityName)
            throws OpbDataAccessException;

    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pCityName is mapped to cityName</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void ins()
            throws OpbDataAccessException;

    /**
     * Updates a City by primary key.
     * Calls the database procedure upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void upd(Long pCityId,
            String pCityName,
            String pOldCityName)
            throws OpbDataAccessException;

    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pCityName is mapped to cityName</li>
     * <li>pOldCityName is mapped to cityNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void upd()
            throws OpbDataAccessException;


}