/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * dates.
 */
public interface Dates
        extends OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of aDate.
     * @return The value of aDate.
     */
    java.util.Date getADate();

    /**
     * Sets the value of aDate.
     * @param a The new value for aDate.
     */
    void setADate(java.util.Date a);

    /**
     * Returns the value of aDateDataSourceValue.
     * This is the last value returned by the data source for aDate.
     * @return The value of aDateDataSourceValue.
     */
    java.util.Date getADateDataSourceValue();

    /**
     * Returns true if the value of aDate
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aDate has changed since it was loaded.
     */
    boolean getADateChanged();

    /**
     * Returns the value of bDate.
     * @return The value of bDate.
     */
    java.util.Date getBDate();

    /**
     * Sets the value of bDate.
     * @param a The new value for bDate.
     */
    void setBDate(java.util.Date a);

    /**
     * Returns the value of bDateDataSourceValue.
     * This is the last value returned by the data source for bDate.
     * @return The value of bDateDataSourceValue.
     */
    java.util.Date getBDateDataSourceValue();

    /**
     * Returns true if the value of bDate
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if bDate has changed since it was loaded.
     */
    boolean getBDateChanged();


    /**
     * 
     * Calls the database function add_one_day.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.Date addOneDay(java.util.Date pDate)
            throws OpbDataAccessException;

    /**
     * Calls addOneDay using mapped parameters.
     * <ul>
     * <li>pDate is mapped to bDate</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.Date addOneDay()
            throws OpbDataAccessException;

    /**
     * 
     * Calls the database function today.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.Date today()
            throws OpbDataAccessException;


    /**
     * 
     * Calls the database procedure date_in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void dateInOut(OpbValueWrapper<java.util.Date> pDate)
            throws OpbDataAccessException;

    /**
     * Calls dateInOut using mapped parameters.
     * <ul>
     * <li>pDate is mapped to aDate</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void dateInOut()
            throws OpbDataAccessException;


}