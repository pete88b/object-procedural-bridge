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
 * dates.
 */
public class DatesImpl implements Dates {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            DatesImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of DatesImpl.
     */
    public DatesImpl() {
        logger.entering(CLASS_NAME, "DatesImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this DatesImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this DatesImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this DatesImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this DatesImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this DatesImpl.
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
        aDate = null;
        aDateDataSourceValue = null;

        bDate = null;
        bDateDataSourceValue = null;


    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>a_date is <em>mandatory</em></li>
     * <li>b_date is <em>mandatory</em></li>
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
            // load aDate from column a_date
            aDate = OpbSqlHelper.getValue(
                    aDate, resultSet,
                    "a_date", true);
            // save the value we just loaded as the datasource value
            aDateDataSourceValue = aDate;

            // load bDate from column b_date
            bDate = OpbSqlHelper.getValue(
                    bDate, resultSet,
                    "b_date", true);
            // save the value we just loaded as the datasource value
            bDateDataSourceValue = bDate;


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
    private java.util.Date bDate = null;

    /**
     * Returns the value of bDate.
     * @return The value of bDate.
     */
    public java.util.Date getBDate() {
        return bDate;
    }

    /**
     * Sets the value of bDate.
     * @param a The new value for bDate.
     */
    public void setBDate(final java.util.Date a) {
        this.bDate = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.util.Date bDateDataSourceValue = null;

    /**
     * Returns the value of bDateDataSourceValue.
     * This is the last value returned by the data source for bDate.
     * @return The value of bDateDataSourceValue.
     */
    public java.util.Date getBDateDataSourceValue() {
        return bDateDataSourceValue;
    }

    /**
     * Returns true if the value of bDate
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if bDate has changed since it was loaded.
     */
    public boolean getBDateChanged() {
        return !OpbComparisonHelper.isEqual(
                    bDate, bDateDataSourceValue);
    }


    /**
     * 
     * Calls the database function add_one_day.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.Date
            addOneDay(final java.util.Date pDate)
            throws OpbDataAccessException {
        final String methodName = "addOneDay(java.util.Date)";

        logger.entering(CLASS_NAME, methodName);

        java.util.Date result = null;

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := dates.add_one_day(?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.TIMESTAMP);

        opbCallHelper.setObject(
                2, java.sql.Types.TIMESTAMP, pDate);


        opbCallHelper.execute();

        result = opbCallHelper.get(java.util.Date.class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * Calls addOneDay using mapped parameters.
     * <ul>
     * <li>pDate is mapped to bDate</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.Date
            addOneDay()
            throws OpbDataAccessException {
        final String methodName = "addOneDay()";

        logger.entering(CLASS_NAME, methodName);

        java.util.Date result = addOneDay(
                getBDate());


        return result;
    }

    /**
     * 
     * Calls the database function today.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.Date
            today()
            throws OpbDataAccessException {
        final String methodName = "today()";

        logger.entering(CLASS_NAME, methodName);

        java.util.Date result = null;

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := dates.today(); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.TIMESTAMP);

        opbCallHelper.execute();

        result = opbCallHelper.get(java.util.Date.class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }


    /**
     * 
     * Calls the database procedure date_in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void dateInOut(final OpbValueWrapper<java.util.Date> pDate)
            throws OpbDataAccessException {
        final String methodName = "dateInOut(OpbValueWrapper)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pDate", pDate);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN dates.date_in_out(?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.TIMESTAMP, pDate.getValue());

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.TIMESTAMP);


        opbCallHelper.execute();

        pDate.setValue(opbCallHelper.get(java.util.Date.class, 1));

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls dateInOut using mapped parameters.
     * <ul>
     * <li>pDate is mapped to aDate</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void dateInOut()
            throws OpbDataAccessException {
        final String methodName = "dateInOut()";

        logger.entering(CLASS_NAME, methodName);

        OpbValueWrapper<java.util.Date> pDateValueWrapper =
                new OpbValueWrapperImpl<java.util.Date>(getADate());


        dateInOut(pDateValueWrapper);

        setADate(pDateValueWrapper.getValue());


    }


}