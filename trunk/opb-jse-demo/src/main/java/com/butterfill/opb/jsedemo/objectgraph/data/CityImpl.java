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
 * city.
 */
public class CityImpl implements City {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            CityImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of CityImpl.
     */
    public CityImpl() {
        logger.entering(CLASS_NAME, "CityImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this CityImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this CityImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this CityImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this CityImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this CityImpl.
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

        // set the id to null
        opbId = null;

        // set all fields to their initial values
        cityId = null;

        cityName = null;
        cityNameDataSourceValue = null;


    } // End of opbClearState()

    /**
     * The id of this CityImpl.
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this CityImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>cityId</li>
     * </ul>
     * This method will return null if opbLoad(ResultSet) has not been called.
     *
     * @return The ID of this instance.
     */
    public OpbId getOpbId() {
        return opbId;
    }


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>city_id is <em>mandatory</em></li>
     * <li>city_name is <em>mandatory</em></li>
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
            // load cityId from column city_id
            cityId = OpbSqlHelper.getValue(
                    cityId, resultSet,
                    "city_id", true);

            // load cityName from column city_name
            cityName = OpbSqlHelper.getValue(
                    cityName, resultSet,
                    "city_name", true);
            // save the value we just loaded as the datasource value
            cityNameDataSourceValue = cityName;


            // create the id
            opbId = new OpbId(cityId);

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
    private Long cityId = null;

    /**
     * Returns the value of cityId.
     * @return The value of cityId.
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Sets the value of cityId.
     * @param a The new value for cityId.
     */
    private void setCityId(final Long a) {
        this.cityId = a;
    }

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
     * Derived from a read-write opb-package field.
     */
    private String cityNameDataSourceValue = null;

    /**
     * Returns the value of cityNameDataSourceValue.
     * This is the last value returned by the data source for cityName.
     * @return The value of cityNameDataSourceValue.
     */
    public String getCityNameDataSourceValue() {
        return cityNameDataSourceValue;
    }

    /**
     * Returns true if the value of cityName
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if cityName has changed since it was loaded.
     */
    public boolean getCityNameChanged() {
        return !OpbComparisonHelper.isEqual(
                    cityName, cityNameDataSourceValue);
    }


    /**
     * Returns all addresses of the specified city.
     * Calls the database function get_addresses.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Address>
            getAddresses(final Long pCityId)
            throws OpbDataAccessException {
        final String methodName = "getAddresses(Long)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);

        OpbId keyToResult = new OpbId(
                "city.get_addresses",
                pCityId);

        java.util.List<Address> result =
                opbDataObjectSource.getCachedResult(
                Address.class, keyToResult);

        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := city.get_addresses(?); END;");

        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pCityId);


        opbCallHelper.execute();

        result = opbDataObjectSource.getResult(
                Address.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * Calls getAddresses using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Address>
            getAddresses()
            throws OpbDataAccessException {
        final String methodName = "getAddresses()";

        logger.entering(CLASS_NAME, methodName);

        java.util.List<Address> result = getAddresses(
                getCityId());


        return result;
    }


    /**
     * Deletes a City by primary key.
     * Calls the database procedure del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void del(final Long pCityId,
            final String pOldCityName)
            throws OpbDataAccessException {
        final String methodName = "del(Long, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN city.del(?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, pCityId);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pOldCityName);


        opbCallHelper.execute();

        opbDataObjectSource.clearCached(City.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pOldCityName is mapped to cityNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void del()
            throws OpbDataAccessException {
        final String methodName = "del()";

        logger.entering(CLASS_NAME, methodName);

        del(getCityId(),
                    getCityNameDataSourceValue());

    }

    /**
     * Creates a City returning it's new primary key value(s).
     * Calls the database procedure ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void ins(final OpbValueWrapper<Long> pCityId,
            final String pCityName)
            throws OpbDataAccessException {
        final String methodName = "ins(OpbValueWrapper, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pCityId", pCityId);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN city.ins(?, ?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pCityName);


        opbCallHelper.execute();

        pCityId.setValue(opbCallHelper.get(Long.class, 1));

        opbDataObjectSource.invalidateCached(City.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pCityName is mapped to cityName</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void ins()
            throws OpbDataAccessException {
        final String methodName = "ins()";

        logger.entering(CLASS_NAME, methodName);

        OpbValueWrapper<Long> pCityIdValueWrapper =
                new OpbValueWrapperImpl<Long>();


        ins(pCityIdValueWrapper,
                    getCityName());

        setCityId(pCityIdValueWrapper.getValue());


    }

    /**
     * Updates a City by primary key.
     * Calls the database procedure upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void upd(final Long pCityId,
            final String pCityName,
            final String pOldCityName)
            throws OpbDataAccessException {
        final String methodName = "upd(Long, String, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN city.upd(?, ?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, pCityId);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pCityName);

        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pOldCityName);


        opbCallHelper.execute();

        opbDataObjectSource.invalidateCached(City.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pCityId is mapped to cityId</li>
     * <li>pCityName is mapped to cityName</li>
     * <li>pOldCityName is mapped to cityNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void upd()
            throws OpbDataAccessException {
        final String methodName = "upd()";

        logger.entering(CLASS_NAME, methodName);

        upd(getCityId(),
                    getCityName(),
                    getCityNameDataSourceValue());

    }


}