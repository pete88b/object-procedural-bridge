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
 * person.
 */
public interface Person
        extends OpbActiveCacheableEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of personId.
     * @return The value of personId.
     */
    Long getPersonId();

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
     * Returns the value of lastNameDataSourceValue.
     * This is the last value returned by the data source for lastName.
     * @return The value of lastNameDataSourceValue.
     */
    String getLastNameDataSourceValue();

    /**
     * Returns true if the value of lastName
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if lastName has changed since it was loaded.
     */
    boolean getLastNameChanged();

    /**
     * Returns the value of addressId.
     * @return The value of addressId.
     */
    Long getAddressId();

    /**
     * Sets the value of addressId.
     * @param a The new value for addressId.
     */
    void setAddressId(Long a);

    /**
     * Returns the value of addressIdDataSourceValue.
     * This is the last value returned by the data source for addressId.
     * @return The value of addressIdDataSourceValue.
     */
    Long getAddressIdDataSourceValue();

    /**
     * Returns true if the value of addressId
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if addressId has changed since it was loaded.
     */
    boolean getAddressIdChanged();

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
     * Returns the value of firstNameDataSourceValue.
     * This is the last value returned by the data source for firstName.
     * @return The value of firstNameDataSourceValue.
     */
    String getFirstNameDataSourceValue();

    /**
     * Returns true if the value of firstName
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if firstName has changed since it was loaded.
     */
    boolean getFirstNameChanged();

    /**
     * Returns the value of addressLabel.
     * @return The value of addressLabel.
     */
    String getAddressLabel();

    /**
     * Returns the value of cityLabel.
     * @return The value of cityLabel.
     */
    String getCityLabel();


    /**
     * Returns the address of this person.
     * Calls the database function get_address.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Address> getAddress(Long pAddressId)
            throws OpbDataAccessException;

    /**
     * Calls getAddress using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Address> getAddress()
            throws OpbDataAccessException;


    /**
     * Deletes a Person by primary key.
     * Calls the database procedure del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void del(Long pPersonId,
            String pOldLastName,
            Long pOldAddressId,
            String pOldFirstName)
            throws OpbDataAccessException;

    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pPersonId is mapped to personId</li>
     * <li>pOldLastName is mapped to lastNameDataSourceValue</li>
     * <li>pOldAddressId is mapped to addressIdDataSourceValue</li>
     * <li>pOldFirstName is mapped to firstNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void del()
            throws OpbDataAccessException;

    /**
     * Creates a Person returning it's new primary key value(s).
     * Calls the database procedure ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void ins(OpbValueWrapper<Long> pPersonId,
            String pLastName,
            Long pAddressId,
            String pFirstName)
            throws OpbDataAccessException;

    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pPersonId is mapped to personId</li>
     * <li>pLastName is mapped to lastName</li>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pFirstName is mapped to firstName</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void ins()
            throws OpbDataAccessException;

    /**
     * Updates a Person by primary key.
     * Calls the database procedure upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void upd(Long pPersonId,
            String pLastName,
            Long pAddressId,
            String pFirstName,
            String pOldLastName,
            Long pOldAddressId,
            String pOldFirstName)
            throws OpbDataAccessException;

    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pPersonId is mapped to personId</li>
     * <li>pLastName is mapped to lastName</li>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pFirstName is mapped to firstName</li>
     * <li>pOldLastName is mapped to lastNameDataSourceValue</li>
     * <li>pOldAddressId is mapped to addressIdDataSourceValue</li>
     * <li>pOldFirstName is mapped to firstNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void upd()
            throws OpbDataAccessException;


}