/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * big_decimals.
 */
public class BigDecimalsImpl implements BigDecimals {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            BigDecimalsImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of BigDecimalsImpl.
     */
    public BigDecimalsImpl() {
        logger.entering(CLASS_NAME, "BigDecimalsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this BigDecimalsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this BigDecimalsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this BigDecimalsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this BigDecimalsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this BigDecimalsImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }


    /**
     * Resets all field values to their initial values.
     */
    public void opbClearState() {
        final String methodName = "opbClearState()";

        logger.entering(CLASS_NAME, methodName);

        // set all fields to their initial values
        aNumberNoInitial = null;
        aNumberNoInitialDataSourceValue = null;

        aNumberWithInitial = java.math.BigDecimal.valueOf(323);
        aNumberWithInitialDataSourceValue = java.math.BigDecimal.valueOf(323);

        aNumberWithInitial2 = java.math.BigDecimal.valueOf(3239898);
        aNumberWithInitial2DataSourceValue = java.math.BigDecimal.valueOf(3239898);

        aNumberWithInitial3 = java.math.BigDecimal.valueOf(32.3457234);
        aNumberWithInitial3DataSourceValue = java.math.BigDecimal.valueOf(32.3457234);


    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>a_number_no_initial is <em>mandatory</em></li>
     * <li>a_number_with_initial is <em>mandatory</em></li>
     * <li>a_number_with_initial2 is <em>mandatory</em></li>
     * <li>a_number_with_initial3 is <em>mandatory</em></li>
     * </ul>
     *
     * @param resultSet The result set from which this instance should be loaded.
     * @throws OpbDataAccessException If we fail to load this instance.
     */
    public void opbLoad(final java.sql.ResultSet resultSet)
            throws OpbDataAccessException {
        final String methodName = "opbLoad(ResultSet)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure resultSet is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "resultSet", resultSet);

        // Get field values from resultSet
        try {
            // load aNumberNoInitial from column a_number_no_initial
            aNumberNoInitial = OpbSqlHelper.getValue(
                    aNumberNoInitial, resultSet,
                    "a_number_no_initial", true);
            // save the value we just loaded as the datasource value
            aNumberNoInitialDataSourceValue = aNumberNoInitial;

            // load aNumberWithInitial from column a_number_with_initial
            aNumberWithInitial = OpbSqlHelper.getValue(
                    aNumberWithInitial, resultSet,
                    "a_number_with_initial", true);
            // save the value we just loaded as the datasource value
            aNumberWithInitialDataSourceValue = aNumberWithInitial;

            // load aNumberWithInitial2 from column a_number_with_initial2
            aNumberWithInitial2 = OpbSqlHelper.getValue(
                    aNumberWithInitial2, resultSet,
                    "a_number_with_initial2", true);
            // save the value we just loaded as the datasource value
            aNumberWithInitial2DataSourceValue = aNumberWithInitial2;

            // load aNumberWithInitial3 from column a_number_with_initial3
            aNumberWithInitial3 = OpbSqlHelper.getValue(
                    aNumberWithInitial3, resultSet,
                    "a_number_with_initial3", true);
            // save the value we just loaded as the datasource value
            aNumberWithInitial3DataSourceValue = aNumberWithInitial3;


        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            logger.exiting(CLASS_NAME, methodName);

        }

    } // End of opbLoad(ResultSet)


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the value object.
     *
     * @param valueObject The value object from which this instance should be loaded.
     */
    public void opbLoad(final BigDecimalsValueObject valueObject) {
        final String methodName = "opbLoad(BigDecimalsValueObject)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure valueObject is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "valueObject", valueObject);

        // Get field values from valueObject
        aNumberNoInitial = valueObject.aNumberNoInitial;
        aNumberNoInitialDataSourceValue = valueObject.aNumberNoInitialDataSourceValue;

        aNumberWithInitial = valueObject.aNumberWithInitial;
        aNumberWithInitialDataSourceValue = valueObject.aNumberWithInitialDataSourceValue;

        aNumberWithInitial2 = valueObject.aNumberWithInitial2;
        aNumberWithInitial2DataSourceValue = valueObject.aNumberWithInitial2DataSourceValue;

        aNumberWithInitial3 = valueObject.aNumberWithInitial3;
        aNumberWithInitial3DataSourceValue = valueObject.aNumberWithInitial3DataSourceValue;


    } // End of opbLoad(BigDecimalsValueObject)

    /**
     * Returns a value object for this instance.
     * @return A value object for this BigDecimalsImpl.
     */
    public BigDecimalsValueObject opbToValueObject() {
        final String methodName = "opbToValueObject()";

        logger.entering(CLASS_NAME, methodName);

        final BigDecimalsValueObject valueObject = new BigDecimalsValueObject();

        valueObject.aNumberNoInitial = aNumberNoInitial;
        valueObject.aNumberNoInitialDataSourceValue = aNumberNoInitialDataSourceValue;

        valueObject.aNumberWithInitial = aNumberWithInitial;
        valueObject.aNumberWithInitialDataSourceValue = aNumberWithInitialDataSourceValue;

        valueObject.aNumberWithInitial2 = aNumberWithInitial2;
        valueObject.aNumberWithInitial2DataSourceValue = aNumberWithInitial2DataSourceValue;

        valueObject.aNumberWithInitial3 = aNumberWithInitial3;
        valueObject.aNumberWithInitial3DataSourceValue = aNumberWithInitial3DataSourceValue;


        return valueObject;

    } // End of opbToValueObject()

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal aNumberNoInitial = null;

    /**
     * Returns the value of aNumberNoInitial.
     * @return The value of aNumberNoInitial.
     */
    public java.math.BigDecimal getANumberNoInitial() {
        return aNumberNoInitial;
    }

    /**
     * Sets the value of aNumberNoInitial.
     * @param a The new value for aNumberNoInitial.
     */
    public void setANumberNoInitial(final java.math.BigDecimal a) {
        this.aNumberNoInitial = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal aNumberNoInitialDataSourceValue = null;

    /**
     * Returns the value of aNumberNoInitialDataSourceValue.
     * This is the last value returned by the data source for aNumberNoInitial.
     * @return The value of aNumberNoInitialDataSourceValue.
     */
    public java.math.BigDecimal getANumberNoInitialDataSourceValue() {
        return aNumberNoInitialDataSourceValue;
    }

    /**
     * Returns true if the value of aNumberNoInitial
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberNoInitial has changed since it was loaded.
     */
    public boolean getANumberNoInitialChanged() {
        return !OpbComparisonHelper.isEqual(
                    aNumberNoInitial, aNumberNoInitialDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal aNumberWithInitial = java.math.BigDecimal.valueOf(323);

    /**
     * Returns the value of aNumberWithInitial.
     * @return The value of aNumberWithInitial.
     */
    public java.math.BigDecimal getANumberWithInitial() {
        return aNumberWithInitial;
    }

    /**
     * Sets the value of aNumberWithInitial.
     * @param a The new value for aNumberWithInitial.
     */
    public void setANumberWithInitial(final java.math.BigDecimal a) {
        this.aNumberWithInitial = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal aNumberWithInitialDataSourceValue = java.math.BigDecimal.valueOf(323);

    /**
     * Returns the value of aNumberWithInitialDataSourceValue.
     * This is the last value returned by the data source for aNumberWithInitial.
     * @return The value of aNumberWithInitialDataSourceValue.
     */
    public java.math.BigDecimal getANumberWithInitialDataSourceValue() {
        return aNumberWithInitialDataSourceValue;
    }

    /**
     * Returns true if the value of aNumberWithInitial
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberWithInitial has changed since it was loaded.
     */
    public boolean getANumberWithInitialChanged() {
        return !OpbComparisonHelper.isEqual(
                    aNumberWithInitial, aNumberWithInitialDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal aNumberWithInitial2 = java.math.BigDecimal.valueOf(3239898);

    /**
     * Returns the value of aNumberWithInitial2.
     * @return The value of aNumberWithInitial2.
     */
    public java.math.BigDecimal getANumberWithInitial2() {
        return aNumberWithInitial2;
    }

    /**
     * Sets the value of aNumberWithInitial2.
     * @param a The new value for aNumberWithInitial2.
     */
    public void setANumberWithInitial2(final java.math.BigDecimal a) {
        this.aNumberWithInitial2 = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal aNumberWithInitial2DataSourceValue = java.math.BigDecimal.valueOf(3239898);

    /**
     * Returns the value of aNumberWithInitial2DataSourceValue.
     * This is the last value returned by the data source for aNumberWithInitial2.
     * @return The value of aNumberWithInitial2DataSourceValue.
     */
    public java.math.BigDecimal getANumberWithInitial2DataSourceValue() {
        return aNumberWithInitial2DataSourceValue;
    }

    /**
     * Returns true if the value of aNumberWithInitial2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberWithInitial2 has changed since it was loaded.
     */
    public boolean getANumberWithInitial2Changed() {
        return !OpbComparisonHelper.isEqual(
                    aNumberWithInitial2, aNumberWithInitial2DataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal aNumberWithInitial3 = java.math.BigDecimal.valueOf(32.3457234);

    /**
     * Returns the value of aNumberWithInitial3.
     * @return The value of aNumberWithInitial3.
     */
    public java.math.BigDecimal getANumberWithInitial3() {
        return aNumberWithInitial3;
    }

    /**
     * Sets the value of aNumberWithInitial3.
     * @param a The new value for aNumberWithInitial3.
     */
    public void setANumberWithInitial3(final java.math.BigDecimal a) {
        this.aNumberWithInitial3 = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal aNumberWithInitial3DataSourceValue = java.math.BigDecimal.valueOf(32.3457234);

    /**
     * Returns the value of aNumberWithInitial3DataSourceValue.
     * This is the last value returned by the data source for aNumberWithInitial3.
     * @return The value of aNumberWithInitial3DataSourceValue.
     */
    public java.math.BigDecimal getANumberWithInitial3DataSourceValue() {
        return aNumberWithInitial3DataSourceValue;
    }

    /**
     * Returns true if the value of aNumberWithInitial3
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumberWithInitial3 has changed since it was loaded.
     */
    public boolean getANumberWithInitial3Changed() {
        return !OpbComparisonHelper.isEqual(
                    aNumberWithInitial3, aNumberWithInitial3DataSourceValue);
    }


}