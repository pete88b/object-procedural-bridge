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
 * big_decimals.
 */
public interface BigDecimals
        extends OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of aNumberNoInitial.
     * @return The value of aNumberNoInitial.
     */
    java.math.BigDecimal getANumberNoInitial();

    /**
     * Sets the value of aNumberNoInitial.
     * @param a The new value for aNumberNoInitial.
     */
    void setANumberNoInitial(java.math.BigDecimal a);

    /**
     * Returns the value of aNumberNoInitialDataSourceValue.
     * This is the last value returned by the data source for aNumberNoInitial.
     * @return The value of aNumberNoInitialDataSourceValue.
     */
    java.math.BigDecimal getANumberNoInitialDataSourceValue();

    /**
     * Returns true if the value of aNumberNoInitial
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberNoInitial has changed since it was loaded.
     */
    boolean getANumberNoInitialChanged();

    /**
     * Returns the value of aNumberWithInitial.
     * @return The value of aNumberWithInitial.
     */
    java.math.BigDecimal getANumberWithInitial();

    /**
     * Sets the value of aNumberWithInitial.
     * @param a The new value for aNumberWithInitial.
     */
    void setANumberWithInitial(java.math.BigDecimal a);

    /**
     * Returns the value of aNumberWithInitialDataSourceValue.
     * This is the last value returned by the data source for aNumberWithInitial.
     * @return The value of aNumberWithInitialDataSourceValue.
     */
    java.math.BigDecimal getANumberWithInitialDataSourceValue();

    /**
     * Returns true if the value of aNumberWithInitial
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberWithInitial has changed since it was loaded.
     */
    boolean getANumberWithInitialChanged();

    /**
     * Returns the value of aNumberWithInitial2.
     * @return The value of aNumberWithInitial2.
     */
    java.math.BigDecimal getANumberWithInitial2();

    /**
     * Sets the value of aNumberWithInitial2.
     * @param a The new value for aNumberWithInitial2.
     */
    void setANumberWithInitial2(java.math.BigDecimal a);

    /**
     * Returns the value of aNumberWithInitial2DataSourceValue.
     * This is the last value returned by the data source for aNumberWithInitial2.
     * @return The value of aNumberWithInitial2DataSourceValue.
     */
    java.math.BigDecimal getANumberWithInitial2DataSourceValue();

    /**
     * Returns true if the value of aNumberWithInitial2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberWithInitial2 has changed since it was loaded.
     */
    boolean getANumberWithInitial2Changed();

    /**
     * Returns the value of aNumberWithInitial3.
     * @return The value of aNumberWithInitial3.
     */
    java.math.BigDecimal getANumberWithInitial3();

    /**
     * Sets the value of aNumberWithInitial3.
     * @param a The new value for aNumberWithInitial3.
     */
    void setANumberWithInitial3(java.math.BigDecimal a);

    /**
     * Returns the value of aNumberWithInitial3DataSourceValue.
     * This is the last value returned by the data source for aNumberWithInitial3.
     * @return The value of aNumberWithInitial3DataSourceValue.
     */
    java.math.BigDecimal getANumberWithInitial3DataSourceValue();

    /**
     * Returns true if the value of aNumberWithInitial3
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberWithInitial3 has changed since it was loaded.
     */
    boolean getANumberWithInitial3Changed();


}