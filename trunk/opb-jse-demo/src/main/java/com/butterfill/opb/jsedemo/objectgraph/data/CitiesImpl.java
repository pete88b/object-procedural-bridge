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
 * cities.
 */
public class CitiesImpl implements Cities {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            CitiesImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of CitiesImpl.
     */
    public CitiesImpl() {
        logger.entering(CLASS_NAME, "CitiesImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this CitiesImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this CitiesImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this CitiesImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this CitiesImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this CitiesImpl.
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
        cityName = null;


    } // End of opbClearState()

    /**
     * Derived from an opb-package field.
     */
    private String cityName = null;

    /**
     * Returns the value of cityName.
     * @return The value of cityName.
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of cityName.
     * @param a The new value for cityName.
     */
    public void setCityName(final String a) {
        this.cityName = a;
    }


    /**
     * Returns all cities that meet the search criteria.
     * Calls the database function get_filtered.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<City>
            getFiltered(final String pCityName)
            throws OpbDataAccessException {
        final String methodName = "getFiltered(String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);

        OpbId keyToResult = new OpbId(
                "cities.get_filtered",
                pCityName);

        java.util.List<City> result =
                opbDataObjectSource.getCachedResult(
                City.class, keyToResult);

        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := cities.get_filtered(?); END;");

        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pCityName);


        opbCallHelper.execute();

        result = opbDataObjectSource.getResult(
                City.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * Calls getFiltered using mapped parameters.
     * <ul>
     * <li>pCityName is mapped to cityName</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<City>
            getFiltered()
            throws OpbDataAccessException {
        final String methodName = "getFiltered()";

        logger.entering(CLASS_NAME, methodName);

        java.util.List<City> result = getFiltered(
                getCityName());


        return result;
    }

    /**
     * Returns the ID of the specified city.
     * Calls the database function get_city_id.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            getCityId(final String pCityName)
            throws OpbDataAccessException {
        final String methodName = "getCityId(String)";

        logger.entering(CLASS_NAME, methodName);

        Long result = null;

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := cities.get_city_id(?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pCityName);


        opbCallHelper.execute();

        result = opbCallHelper.get(Long.class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }


}