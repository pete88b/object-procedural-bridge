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
 * address.
 */
public class AddressImpl implements Address {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            AddressImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of AddressImpl.
     */
    public AddressImpl() {
        logger.entering(CLASS_NAME, "AddressImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this AddressImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this AddressImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this AddressImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this AddressImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this AddressImpl.
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
        addressId = null;

        cityId = null;
        cityIdDataSourceValue = null;

        line1 = null;
        line1DataSourceValue = null;

        line2 = null;
        line2DataSourceValue = null;


    } // End of opbClearState()

    /**
     * The id of this AddressImpl.
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this AddressImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>addressId</li>
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
     * <li>address_id is <em>mandatory</em></li>
     * <li>city_id is <em>mandatory</em></li>
     * <li>line_1 is <em>mandatory</em></li>
     * <li>line_2 is <em>mandatory</em></li>
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
            // load addressId from column address_id
            addressId = OpbSqlHelper.getValue(
                    addressId, resultSet,
                    "address_id", true);

            // load cityId from column city_id
            cityId = OpbSqlHelper.getValue(
                    cityId, resultSet,
                    "city_id", true);
            // save the value we just loaded as the datasource value
            cityIdDataSourceValue = cityId;

            // load line1 from column line_1
            line1 = OpbSqlHelper.getValue(
                    line1, resultSet,
                    "line_1", true);
            // save the value we just loaded as the datasource value
            line1DataSourceValue = line1;

            // load line2 from column line_2
            line2 = OpbSqlHelper.getValue(
                    line2, resultSet,
                    "line_2", true);
            // save the value we just loaded as the datasource value
            line2DataSourceValue = line2;


            // create the id
            opbId = new OpbId(addressId);

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
    public void opbLoad(final AddressValueObject valueObject) {
        final String methodName = "opbLoad(AddressValueObject)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure valueObject is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "valueObject", valueObject);

        // Get field values from valueObject
        addressId = valueObject.addressId;

        cityId = valueObject.cityId;
        cityIdDataSourceValue = valueObject.cityIdDataSourceValue;

        line1 = valueObject.line1;
        line1DataSourceValue = valueObject.line1DataSourceValue;

        line2 = valueObject.line2;
        line2DataSourceValue = valueObject.line2DataSourceValue;


    } // End of opbLoad(AddressValueObject)

    /**
     * Returns a value object for this instance.
     * @return A value object for this AddressImpl.
     */
    public AddressValueObject opbToValueObject() {
        final String methodName = "opbToValueObject()";

        logger.entering(CLASS_NAME, methodName);

        final AddressValueObject valueObject = new AddressValueObject();

        valueObject.addressId = addressId;

        valueObject.cityId = cityId;
        valueObject.cityIdDataSourceValue = cityIdDataSourceValue;

        valueObject.line1 = line1;
        valueObject.line1DataSourceValue = line1DataSourceValue;

        valueObject.line2 = line2;
        valueObject.line2DataSourceValue = line2DataSourceValue;


        return valueObject;

    } // End of opbToValueObject()

    /**
     * Derived from an opb-package field.
     */
    private Long addressId = null;

    /**
     * Returns the value of addressId.
     * @return The value of addressId.
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * Sets the value of addressId.
     * @param a The new value for addressId.
     */
    private void setAddressId(final Long a) {
        this.addressId = a;
    }

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
    public void setCityId(final Long a) {
        this.cityId = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private Long cityIdDataSourceValue = null;

    /**
     * Returns the value of cityIdDataSourceValue.
     * This is the last value returned by the data source for cityId.
     * @return The value of cityIdDataSourceValue.
     */
    public Long getCityIdDataSourceValue() {
        return cityIdDataSourceValue;
    }

    /**
     * Returns true if the value of cityId
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if cityId has changed since it was loaded.
     */
    public boolean getCityIdChanged() {
        return !OpbComparisonHelper.isEqual(
                    cityId, cityIdDataSourceValue);
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
     * Derived from a read-write opb-package field.
     */
    private String line1DataSourceValue = null;

    /**
     * Returns the value of line1DataSourceValue.
     * This is the last value returned by the data source for line1.
     * @return The value of line1DataSourceValue.
     */
    public String getLine1DataSourceValue() {
        return line1DataSourceValue;
    }

    /**
     * Returns true if the value of line1
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if line1 has changed since it was loaded.
     */
    public boolean getLine1Changed() {
        return !OpbComparisonHelper.isEqual(
                    line1, line1DataSourceValue);
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
     * Derived from a read-write opb-package field.
     */
    private String line2DataSourceValue = null;

    /**
     * Returns the value of line2DataSourceValue.
     * This is the last value returned by the data source for line2.
     * @return The value of line2DataSourceValue.
     */
    public String getLine2DataSourceValue() {
        return line2DataSourceValue;
    }

    /**
     * Returns true if the value of line2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if line2 has changed since it was loaded.
     */
    public boolean getLine2Changed() {
        return !OpbComparisonHelper.isEqual(
                    line2, line2DataSourceValue);
    }


    /**
     * Returns all people for the specified address.
     * Calls the database function get_people.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Person>
            getPeople(final Long pAddressId)
            throws OpbDataAccessException {
        final String methodName = "getPeople(Long)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);

        OpbId keyToResult = new OpbId(
                "address.get_people",
                pAddressId);

        java.util.List<Person> result =
                opbDataObjectSource.getCachedResult(
                Person.class, keyToResult);

        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := address.get_people(?); END;");

        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pAddressId);


        opbCallHelper.execute();

        result = opbDataObjectSource.getResult(
                Person.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * Calls getPeople using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Person>
            getPeople()
            throws OpbDataAccessException {
        final String methodName = "getPeople()";

        logger.entering(CLASS_NAME, methodName);

        java.util.List<Person> result = getPeople(
                getAddressId());


        return result;
    }


    /**
     * Deletes a Address by primary key.
     * Calls the database procedure del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void del(final Long pAddressId,
            final Long pOldCityId,
            final String pOldLine1,
            final String pOldLine2)
            throws OpbDataAccessException {
        final String methodName = "del(Long, Long, String, String)";

        logger.entering(CLASS_NAME, methodName);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN address.del(?, ?, ?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, pAddressId);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pOldCityId);

        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pOldLine1);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pOldLine2);


        opbCallHelper.execute();

        opbDataObjectSource.clearCached(Address.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pOldCityId is mapped to cityIdDataSourceValue</li>
     * <li>pOldLine1 is mapped to line1DataSourceValue</li>
     * <li>pOldLine2 is mapped to line2DataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void del()
            throws OpbDataAccessException {
        final String methodName = "del()";

        logger.entering(CLASS_NAME, methodName);

        del(getAddressId(),
                    getCityIdDataSourceValue(),
                    getLine1DataSourceValue(),
                    getLine2DataSourceValue());

    }

    /**
     * Creates a Address returning it's new primary key value(s).
     * Calls the database procedure ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void ins(final OpbValueWrapper<Long> pAddressId,
            final Long pCityId,
            final String pLine1,
            final String pLine2)
            throws OpbDataAccessException {
        final String methodName = "ins(OpbValueWrapper, Long, String, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pAddressId", pAddressId);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN address.ins(?, ?, ?, ?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pCityId);

        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pLine1);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pLine2);


        opbCallHelper.execute();

        pAddressId.setValue(opbCallHelper.get(Long.class, 1));

        opbDataObjectSource.invalidateCached(Address.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pCityId is mapped to cityId</li>
     * <li>pLine1 is mapped to line1</li>
     * <li>pLine2 is mapped to line2</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void ins()
            throws OpbDataAccessException {
        final String methodName = "ins()";

        logger.entering(CLASS_NAME, methodName);

        OpbValueWrapper<Long> pAddressIdValueWrapper =
                new OpbValueWrapperImpl<Long>();


        ins(pAddressIdValueWrapper,
                    getCityId(),
                    getLine1(),
                    getLine2());

        setAddressId(pAddressIdValueWrapper.getValue());


    }

    /**
     * Updates a Address by primary key.
     * Calls the database procedure upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void upd(final Long pAddressId,
            final Long pCityId,
            final String pLine1,
            final String pLine2,
            final Long pOldCityId,
            final String pOldLine1,
            final String pOldLine2)
            throws OpbDataAccessException {
        final String methodName = "upd(Long, Long, String, String, Long, String, String)";

        logger.entering(CLASS_NAME, methodName);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN address.upd(?, ?, ?, ?, ?, ?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, pAddressId);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pCityId);

        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pLine1);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pLine2);

        opbCallHelper.setObject(
                5, java.sql.Types.BIGINT, pOldCityId);

        opbCallHelper.setObject(
                6, java.sql.Types.VARCHAR, pOldLine1);

        opbCallHelper.setObject(
                7, java.sql.Types.VARCHAR, pOldLine2);


        opbCallHelper.execute();

        opbDataObjectSource.invalidateCached(Address.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pCityId is mapped to cityId</li>
     * <li>pLine1 is mapped to line1</li>
     * <li>pLine2 is mapped to line2</li>
     * <li>pOldCityId is mapped to cityIdDataSourceValue</li>
     * <li>pOldLine1 is mapped to line1DataSourceValue</li>
     * <li>pOldLine2 is mapped to line2DataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void upd()
            throws OpbDataAccessException {
        final String methodName = "upd()";

        logger.entering(CLASS_NAME, methodName);

        upd(getAddressId(),
                    getCityId(),
                    getLine1(),
                    getLine2(),
                    getCityIdDataSourceValue(),
                    getLine1DataSourceValue(),
                    getLine2DataSourceValue());

    }


}