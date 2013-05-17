/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.OpbValueObjectProvider;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * cat.
 */
public interface Cat
        extends OpbActiveCacheableEntity,
        OpbValueObjectProvider<CatValueObject> {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of name.
     * @return The value of name.
     */
    String getName();

    /**
     * Returns the value of type.
     * @return The value of type.
     */
    Long getType();

    /**
     * Returns the value of lastChanged.
     * @return The value of lastChanged.
     */
    java.util.Date getLastChanged();

    /**
     * Returns the value of description.
     * @return The value of description.
     */
    String getDescription();

    /**
     * Sets the value of description.
     * @param a The new value for description.
     */
    void setDescription(String a);

    /**
     * Returns the value of descriptionDataSourceValue.
     * This is the last value returned by the data source for description.
     * @return The value of descriptionDataSourceValue.
     */
    String getDescriptionDataSourceValue();

    /**
     * Returns true if the value of description
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if description has changed since it was loaded.
     */
    boolean getDescriptionChanged();


    /**
     * invalidate this instance when update_description is called.
     * Calls the database procedure update_description.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void updateDescription(String pName,
            Long pType,
            String pDescription)
            throws OpbDataAccessException;

    /**
     * Calls updateDescription using mapped parameters.
     * <ul>
     * <li>pName is mapped to name</li>
     * <li>pType is mapped to type</li>
     * <li>pDescription is mapped to description</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void updateDescription()
            throws OpbDataAccessException;

    /**
     * clear this instance when delete_cat is called.
     * Calls the database procedure delete_cat.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deleteCat(String pName,
            Long pType)
            throws OpbDataAccessException;

    /**
     * Calls deleteCat using mapped parameters.
     * <ul>
     * <li>pName is mapped to name</li>
     * <li>pType is mapped to type</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deleteCat()
            throws OpbDataAccessException;

    /**
     * 
     * Calls the database procedure clear_cached_all.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void clearCachedAll()
            throws OpbDataAccessException;

    /**
     * 
     * Calls the database procedure invalidate_cached_all.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void invalidateCachedAll()
            throws OpbDataAccessException;

    /**
     * 
     * Calls the database procedure clear_cached_cats.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void clearCachedCats()
            throws OpbDataAccessException;

    /**
     * 
     * Calls the database procedure invalidate_cached_cats.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void invalidateCachedCats()
            throws OpbDataAccessException;


}