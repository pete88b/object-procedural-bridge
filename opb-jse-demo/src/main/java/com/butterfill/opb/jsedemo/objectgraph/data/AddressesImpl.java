/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.objectgraph.data;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * addresses.
 */
public class AddressesImpl implements Addresses {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            AddressesImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of AddressesImpl.
     */
    public AddressesImpl() {
        logger.entering(CLASS_NAME, "AddressesImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this AddressesImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this AddressesImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this AddressesImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this AddressesImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this AddressesImpl.
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
        cityId = null;

        line1 = null;

        line2 = null;


    } // End of opbClearState()

    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the value object.
     *
     * @param valueObject The value object from which this instance should be loaded.
     */
    public void opbLoad(final AddressesValueObject valueObject) {
        final String methodName = "opbLoad(AddressesValueObject)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure valueObject is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "valueObject", valueObject);

        // Get field values from valueObject
        cityId = valueObject.cityId;

        line1 = valueObject.line1;

        line2 = valueObject.line2;


    } // End of opbLoad(AddressesValueObject)

    /**
     * Returns a value object for this instance.
     * @return A value object for this AddressesImpl.
     */
    public AddressesValueObject opbToValueObject() {
        final String methodName = "opbToValueObject()";

        logger.entering(CLASS_NAME, methodName);

        final AddressesValueObject valueObject = new AddressesValueObject();

        valueObject.cityId = cityId;

        valueObject.line1 = line1;

        valueObject.line2 = line2;


        return valueObject;

    } // End of opbToValueObject()

    /**
     * Derived from an opb-package field.
     */
    private String cityId = null;

    /**
     * Returns the value of cityId.
     * @return The value of cityId.
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * Sets the value of cityId.
     * @param a The new value for cityId.
     */
    public void setCityId(final String a) {
        this.cityId = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String line1 = null;

    /**
     * Returns the value of line1.
     * @return The value of line1.
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the value of line1.
     * @param a The new value for line1.
     */
    public void setLine1(final String a) {
        this.line1 = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String line2 = null;

    /**
     * Returns the value of line2.
     * @return The value of line2.
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the value of line2.
     * @param a The new value for line2.
     */
    public void setLine2(final String a) {
        this.line2 = a;
    }


    /**
     * Returns all addresses that meet the search criteria.
     * Calls the database function get_filtered.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Address>
            getFiltered(final String pCityId,
            final String pLine1,
            final String pLine2)
            throws OpbDataAccessException {
        final String methodName = "getFiltered(String, String, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);

        OpbId keyToResult = new OpbId(
                "addresses.get_filtered",
                pCityId,
                pLine1,
                pLine2);

        java.util.List<Address> result =
                opbDataObjectSource.getCachedResult(
                Address.class, keyToResult);

        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := addresses.get_filtered(?, ?, ?); END;");

        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pCityId);

        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pLine1);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pLine2);


        opbCallHelper.execute();

        result = opbDataObjectSource.getResult(
                Address.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * Calls getFiltered using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pLine1 is mapped to line1</li>
     * <li>pLine2 is mapped to line2</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Address>
            getFiltered()
            throws OpbDataAccessException {
        final String methodName = "getFiltered()";

        logger.entering(CLASS_NAME, methodName);

        java.util.List<Address> result = getFiltered(
                getCityId(),
                getLine1(),
                getLine2());


        return result;
    }


}