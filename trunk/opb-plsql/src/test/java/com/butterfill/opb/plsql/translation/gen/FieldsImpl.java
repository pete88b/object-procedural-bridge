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
 * fields.
 */
public class FieldsImpl implements Fields {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            FieldsImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of FieldsImpl.
     */
    public FieldsImpl() {
        logger.entering(CLASS_NAME, "FieldsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this FieldsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this FieldsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this FieldsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this FieldsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this FieldsImpl.
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
        a = null;
        aDataSourceValue = null;

        aVarchar = null;
        aVarcharDataSourceValue = null;

        aNumber = null;
        aNumberDataSourceValue = null;

        aInteger = 8L;
        aIntegerDataSourceValue = 8L;

        aDate = null;
        aDateDataSourceValue = null;

        aRo = null;


    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>a is <em>mandatory</em></li>
     * <li>a_varchar is <em>mandatory</em></li>
     * <li>a_number is <em>mandatory</em></li>
     * <li>a_integer is <em>mandatory</em></li>
     * <li>a_date is <em>mandatory</em></li>
     * <li>a_ro is <em>mandatory</em></li>
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
            // load a from column a
            a = OpbSqlHelper.getValue(
                    a, resultSet,
                    "a", true);
            // save the value we just loaded as the datasource value
            aDataSourceValue = a;

            // load aVarchar from column a_varchar
            aVarchar = OpbSqlHelper.getValue(
                    aVarchar, resultSet,
                    "a_varchar", true);
            // save the value we just loaded as the datasource value
            aVarcharDataSourceValue = aVarchar;

            // load aNumber from column a_number
            aNumber = OpbSqlHelper.getValue(
                    aNumber, resultSet,
                    "a_number", true);
            // save the value we just loaded as the datasource value
            aNumberDataSourceValue = aNumber;

            // load aInteger from column a_integer
            aInteger = OpbSqlHelper.getValue(
                    aInteger, resultSet,
                    "a_integer", true);
            // save the value we just loaded as the datasource value
            aIntegerDataSourceValue = aInteger;

            // load aDate from column a_date
            aDate = OpbSqlHelper.getValue(
                    aDate, resultSet,
                    "a_date", true);
            // save the value we just loaded as the datasource value
            aDateDataSourceValue = aDate;

            // load aRo from column a_ro
            aRo = OpbSqlHelper.getValue(
                    aRo, resultSet,
                    "a_ro", true);


        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            logger.exiting(CLASS_NAME, methodName);

        }

    } // End of opbLoad(ResultSet resultSet)


    /**
     * Derived from an opb-package field.
     */
    private String a = null;

    /**
     * Returns the value of a.
     * @return The value of a.
     */
    public String getA() {
        return a;
    }

    /**
     * Sets the value of a.
     * Calls aChanged()
     * if this call changes the value of a.
     * @param a The new value for a.
     */
    public void setA(final String a) {
        if (!OpbComparisonHelper.isEqual(this.a, a)) {
            // If the new value is different, save it
            this.a = a;
            // and make the "on change" calls
            aChanged();
        }
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String aDataSourceValue = null;

    /**
     * Returns the value of aDataSourceValue.
     * This is the last value returned by the data source for a.
     * @return The value of aDataSourceValue.
     */
    public String getADataSourceValue() {
        return aDataSourceValue;
    }

    /**
     * Returns true if the value of a
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if a has changed since it was loaded.
     */
    public boolean getAChanged() {
        return !OpbComparisonHelper.isEqual(
                    a, aDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String aVarchar = null;

    /**
     * Returns the value of aVarchar.
     * @return The value of aVarchar.
     */
    public String getAVarchar() {
        return aVarchar;
    }

    /**
     * Sets the value of aVarchar.
     * @param a The new value for aVarchar.
     */
    public void setAVarchar(final String a) {
        this.aVarchar = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String aVarcharDataSourceValue = null;

    /**
     * Returns the value of aVarcharDataSourceValue.
     * This is the last value returned by the data source for aVarchar.
     * @return The value of aVarcharDataSourceValue.
     */
    public String getAVarcharDataSourceValue() {
        return aVarcharDataSourceValue;
    }

    /**
     * Returns true if the value of aVarchar
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aVarchar has changed since it was loaded.
     */
    public boolean getAVarcharChanged() {
        return !OpbComparisonHelper.isEqual(
                    aVarchar, aVarcharDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal aNumber = null;

    /**
     * Returns the value of aNumber.
     * @return The value of aNumber.
     */
    public java.math.BigDecimal getANumber() {
        return aNumber;
    }

    /**
     * Sets the value of aNumber.
     * @param a The new value for aNumber.
     */
    public void setANumber(final java.math.BigDecimal a) {
        this.aNumber = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal aNumberDataSourceValue = null;

    /**
     * Returns the value of aNumberDataSourceValue.
     * This is the last value returned by the data source for aNumber.
     * @return The value of aNumberDataSourceValue.
     */
    public java.math.BigDecimal getANumberDataSourceValue() {
        return aNumberDataSourceValue;
    }

    /**
     * Returns true if the value of aNumber
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumber has changed since it was loaded.
     */
    public boolean getANumberChanged() {
        return !OpbComparisonHelper.isEqual(
                    aNumber, aNumberDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private Long aInteger = 8L;

    /**
     * Returns the value of aInteger.
     * @return The value of aInteger.
     */
    public Long getAInteger() {
        return aInteger;
    }

    /**
     * Sets the value of aInteger.
     * @param a The new value for aInteger.
     */
    public void setAInteger(final Long a) {
        this.aInteger = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private Long aIntegerDataSourceValue = 8L;

    /**
     * Returns the value of aIntegerDataSourceValue.
     * This is the last value returned by the data source for aInteger.
     * @return The value of aIntegerDataSourceValue.
     */
    public Long getAIntegerDataSourceValue() {
        return aIntegerDataSourceValue;
    }

    /**
     * Returns true if the value of aInteger
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aInteger has changed since it was loaded.
     */
    public boolean getAIntegerChanged() {
        return !OpbComparisonHelper.isEqual(
                    aInteger, aIntegerDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.util.Date aDate = null;

    /**
     * Returns the value of aDate.
     * @return The value of aDate.
     */
    public java.util.Date getADate() {
        return aDate;
    }

    /**
     * Sets the value of aDate.
     * @param a The new value for aDate.
     */
    public void setADate(final java.util.Date a) {
        this.aDate = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.util.Date aDateDataSourceValue = null;

    /**
     * Returns the value of aDateDataSourceValue.
     * This is the last value returned by the data source for aDate.
     * @return The value of aDateDataSourceValue.
     */
    public java.util.Date getADateDataSourceValue() {
        return aDateDataSourceValue;
    }

    /**
     * Returns true if the value of aDate
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aDate has changed since it was loaded.
     */
    public boolean getADateChanged() {
        return !OpbComparisonHelper.isEqual(
                    aDate, aDateDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String aRo = null;

    /**
     * Returns the value of aRo.
     * @return The value of aRo.
     */
    public String getARo() {
        return aRo;
    }

    /**
     * Sets the value of aRo.
     * @param a The new value for aRo.
     */
    private void setARo(final String a) {
        this.aRo = a;
    }


    /**
     * dummy procedure so that a method is created that will be called when a
     * changes.
     * Calls the database procedure a_changed.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void aChanged()
            throws OpbDataAccessException {
        final String methodName = "aChanged()";

        logger.entering(CLASS_NAME, methodName);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN fields.a_changed(); END;");

        opbCallHelper.execute();

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }


}