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
 * fields.
 */
public interface Fields
        extends OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of a.
     * @return The value of a.
     */
    String getA();
    
    /**
     * Sets the value of a.
     * @param a The new value for a.
     */
    void setA(String a);
    
    /**
     * Returns the value of aDataSourceValue.
     * This is the last value returned by the data source for a.
     * @return The value of aDataSourceValue.
     */
    String getADataSourceValue();
    
    /**
     * Returns true if the value of a
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if a has changed since it was loaded.
     */
    boolean getAChanged();
    
    /**
     * Returns the value of aVarchar.
     * @return The value of aVarchar.
     */
    String getAVarchar();
    
    /**
     * Sets the value of aVarchar.
     * @param a The new value for aVarchar.
     */
    void setAVarchar(String a);
    
    /**
     * Returns the value of aVarcharDataSourceValue.
     * This is the last value returned by the data source for aVarchar.
     * @return The value of aVarcharDataSourceValue.
     */
    String getAVarcharDataSourceValue();
    
    /**
     * Returns true if the value of aVarchar
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aVarchar has changed since it was loaded.
     */
    boolean getAVarcharChanged();
    
    /**
     * Returns the value of aNumber.
     * @return The value of aNumber.
     */
    java.math.BigDecimal getANumber();
    
    /**
     * Sets the value of aNumber.
     * @param a The new value for aNumber.
     */
    void setANumber(java.math.BigDecimal a);
    
    /**
     * Returns the value of aNumberDataSourceValue.
     * This is the last value returned by the data source for aNumber.
     * @return The value of aNumberDataSourceValue.
     */
    java.math.BigDecimal getANumberDataSourceValue();
    
    /**
     * Returns true if the value of aNumber
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumber has changed since it was loaded.
     */
    boolean getANumberChanged();
    
    /**
     * Returns the value of aInteger.
     * @return The value of aInteger.
     */
    Long getAInteger();
    
    /**
     * Sets the value of aInteger.
     * @param a The new value for aInteger.
     */
    void setAInteger(Long a);
    
    /**
     * Returns the value of aIntegerDataSourceValue.
     * This is the last value returned by the data source for aInteger.
     * @return The value of aIntegerDataSourceValue.
     */
    Long getAIntegerDataSourceValue();
    
    /**
     * Returns true if the value of aInteger
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aInteger has changed since it was loaded.
     */
    boolean getAIntegerChanged();
    
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
     * Returns the value of aRo.
     * @return The value of aRo.
     */
    String getARo();
    

    /**
     * dummy procedure so that a method is created that will be called when a
     * changes.
     * Calls the database procedure a_changed.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void aChanged()
            throws OpbDataAccessException;
    

}