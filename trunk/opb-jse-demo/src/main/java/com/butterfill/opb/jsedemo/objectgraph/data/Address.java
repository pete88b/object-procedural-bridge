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
 * address.
 */
public interface Address
        extends OpbActiveCacheableEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of addressId.
     * @return The value of addressId.
     */
    Long getAddressId();
    
    /**
     * Returns the value of cityId.
     * @return The value of cityId.
     */
    Long getCityId();
    
    /**
     * Sets the value of cityId.
     * @param a The new value for cityId.
     */
    void setCityId(Long a);
    
    /**
     * Returns the value of cityIdDataSourceValue.
     * This is the last value returned by the data source for cityId.
     * @return The value of cityIdDataSourceValue.
     */
    Long getCityIdDataSourceValue();
    
    /**
     * Returns true if the value of cityId
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if cityId has changed since it was loaded.
     */
    boolean getCityIdChanged();
    
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
     * Returns the value of line1DataSourceValue.
     * This is the last value returned by the data source for line1.
     * @return The value of line1DataSourceValue.
     */
    String getLine1DataSourceValue();
    
    /**
     * Returns true if the value of line1
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if line1 has changed since it was loaded.
     */
    boolean getLine1Changed();
    
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
     * Returns the value of line2DataSourceValue.
     * This is the last value returned by the data source for line2.
     * @return The value of line2DataSourceValue.
     */
    String getLine2DataSourceValue();
    
    /**
     * Returns true if the value of line2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if line2 has changed since it was loaded.
     */
    boolean getLine2Changed();
    

    /**
     * Returns all people for the specified address.
     * Calls the database function get_people.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Person> getPeople(Long pAddressId)
            throws OpbDataAccessException;
    
    /**
     * Calls getPeople using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Person> getPeople()
            throws OpbDataAccessException;
    

    /**
     * Deletes a Address by primary key.
     * Calls the database procedure del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void del(Long pAddressId,
            Long pOldCityId,
            String pOldLine1,
            String pOldLine2)
            throws OpbDataAccessException;
    
    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pOldCityId is mapped to cityIdDataSourceValue</li>
     * <li>pOldLine1 is mapped to line1DataSourceValue</li>
     * <li>pOldLine2 is mapped to line2DataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void del()
            throws OpbDataAccessException;
    
    /**
     * Creates a Address returning it's new primary key value(s).
     * Calls the database procedure ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void ins(OpbValueWrapper<Long> pAddressId,
            Long pCityId,
            String pLine1,
            String pLine2)
            throws OpbDataAccessException;
    
    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pCityId is mapped to cityId</li>
     * <li>pLine1 is mapped to line1</li>
     * <li>pLine2 is mapped to line2</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void ins()
            throws OpbDataAccessException;
    
    /**
     * Updates a Address by primary key.
     * Calls the database procedure upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void upd(Long pAddressId,
            Long pCityId,
            String pLine1,
            String pLine2,
            Long pOldCityId,
            String pOldLine1,
            String pOldLine2)
            throws OpbDataAccessException;
    
    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pCityId is mapped to cityId</li>
     * <li>pLine1 is mapped to line1</li>
     * <li>pLine2 is mapped to line2</li>
     * <li>pOldCityId is mapped to cityIdDataSourceValue</li>
     * <li>pOldLine1 is mapped to line1DataSourceValue</li>
     * <li>pOldLine2 is mapped to line2DataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void upd()
            throws OpbDataAccessException;
    

}