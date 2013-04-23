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
 * person.
 */
public class PersonImpl implements Person {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PersonImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of PersonImpl.
     */
    public PersonImpl() {
        logger.entering(CLASS_NAME, "PersonImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PersonImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this PersonImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PersonImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PersonImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PersonImpl.
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
        personId = null;

        lastName = null;
        lastNameDataSourceValue = null;

        addressId = null;
        addressIdDataSourceValue = null;

        firstName = null;
        firstNameDataSourceValue = null;

        addressLabel = null;

        cityLabel = null;


    } // End of opbClearState()

    /**
     * The id of this PersonImpl.
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this PersonImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>personId</li>
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
     * <li>person_id is <em>mandatory</em></li>
     * <li>last_name is <em>mandatory</em></li>
     * <li>address_id is <em>mandatory</em></li>
     * <li>first_name is <em>mandatory</em></li>
     * <li>address_label is <em>mandatory</em></li>
     * <li>city_label is <em>mandatory</em></li>
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
            // load personId from column person_id
            personId = OpbSqlHelper.getValue(
                    personId, resultSet,
                    "person_id", true);

            // load lastName from column last_name
            lastName = OpbSqlHelper.getValue(
                    lastName, resultSet,
                    "last_name", true);
            // save the value we just loaded as the datasource value
            lastNameDataSourceValue = lastName;

            // load addressId from column address_id
            addressId = OpbSqlHelper.getValue(
                    addressId, resultSet,
                    "address_id", true);
            // save the value we just loaded as the datasource value
            addressIdDataSourceValue = addressId;

            // load firstName from column first_name
            firstName = OpbSqlHelper.getValue(
                    firstName, resultSet,
                    "first_name", true);
            // save the value we just loaded as the datasource value
            firstNameDataSourceValue = firstName;

            // load addressLabel from column address_label
            addressLabel = OpbSqlHelper.getValue(
                    addressLabel, resultSet,
                    "address_label", true);

            // load cityLabel from column city_label
            cityLabel = OpbSqlHelper.getValue(
                    cityLabel, resultSet,
                    "city_label", true);


            // create the id
            opbId = new OpbId(personId);

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
    private Long personId = null;

    /**
     * Returns the value of personId.
     * @return The value of personId.
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Sets the value of personId.
     * @param a The new value for personId.
     */
    private void setPersonId(final Long a) {
        this.personId = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String lastName = null;

    /**
     * Returns the value of lastName.
     * @return The value of lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of lastName.
     * @param a The new value for lastName.
     */
    public void setLastName(final String a) {
        this.lastName = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String lastNameDataSourceValue = null;

    /**
     * Returns the value of lastNameDataSourceValue.
     * This is the last value returned by the data source for lastName.
     * @return The value of lastNameDataSourceValue.
     */
    public String getLastNameDataSourceValue() {
        return lastNameDataSourceValue;
    }

    /**
     * Returns true if the value of lastName
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if lastName has changed since it was loaded.
     */
    public boolean getLastNameChanged() {
        return !OpbComparisonHelper.isEqual(
                    lastName, lastNameDataSourceValue);
    }

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
    public void setAddressId(final Long a) {
        this.addressId = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private Long addressIdDataSourceValue = null;

    /**
     * Returns the value of addressIdDataSourceValue.
     * This is the last value returned by the data source for addressId.
     * @return The value of addressIdDataSourceValue.
     */
    public Long getAddressIdDataSourceValue() {
        return addressIdDataSourceValue;
    }

    /**
     * Returns true if the value of addressId
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if addressId has changed since it was loaded.
     */
    public boolean getAddressIdChanged() {
        return !OpbComparisonHelper.isEqual(
                    addressId, addressIdDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String firstName = null;

    /**
     * Returns the value of firstName.
     * @return The value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of firstName.
     * @param a The new value for firstName.
     */
    public void setFirstName(final String a) {
        this.firstName = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String firstNameDataSourceValue = null;

    /**
     * Returns the value of firstNameDataSourceValue.
     * This is the last value returned by the data source for firstName.
     * @return The value of firstNameDataSourceValue.
     */
    public String getFirstNameDataSourceValue() {
        return firstNameDataSourceValue;
    }

    /**
     * Returns true if the value of firstName
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if firstName has changed since it was loaded.
     */
    public boolean getFirstNameChanged() {
        return !OpbComparisonHelper.isEqual(
                    firstName, firstNameDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String addressLabel = null;

    /**
     * Returns the value of addressLabel.
     * @return The value of addressLabel.
     */
    public String getAddressLabel() {
        return addressLabel;
    }

    /**
     * Sets the value of addressLabel.
     * @param a The new value for addressLabel.
     */
    private void setAddressLabel(final String a) {
        this.addressLabel = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String cityLabel = null;

    /**
     * Returns the value of cityLabel.
     * @return The value of cityLabel.
     */
    public String getCityLabel() {
        return cityLabel;
    }

    /**
     * Sets the value of cityLabel.
     * @param a The new value for cityLabel.
     */
    private void setCityLabel(final String a) {
        this.cityLabel = a;
    }


    /**
     * Returns the address of this person.
     * Calls the database function get_address.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Address>
            getAddress(final Long pAddressId)
            throws OpbDataAccessException {
        final String methodName = "getAddress(Long)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);

        OpbId keyToResult = new OpbId(
                "person.get_address",
                pAddressId);

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
                "BEGIN ? := person.get_address(?); END;");

        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pAddressId);


        opbCallHelper.execute();

        result = opbDataObjectSource.getResult(
                Address.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * Calls getAddress using mapped parameters.
     * <ul>
     * <li>pAddressId is mapped to addressId</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Address>
            getAddress()
            throws OpbDataAccessException {
        final String methodName = "getAddress()";

        logger.entering(CLASS_NAME, methodName);

        java.util.List<Address> result = getAddress(
                getAddressId());


        return result;
    }


    /**
     * Deletes a Person by primary key.
     * Calls the database procedure del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void del(final Long pPersonId,
            final String pOldLastName,
            final Long pOldAddressId,
            final String pOldFirstName)
            throws OpbDataAccessException {
        final String methodName = "del(Long, String, Long, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN person.del(?, ?, ?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, pPersonId);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pOldLastName);

        opbCallHelper.setObject(
                3, java.sql.Types.BIGINT, pOldAddressId);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pOldFirstName);


        opbCallHelper.execute();

        opbDataObjectSource.clearCached(Person.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pPersonId is mapped to personId</li>
     * <li>pOldLastName is mapped to lastNameDataSourceValue</li>
     * <li>pOldAddressId is mapped to addressIdDataSourceValue</li>
     * <li>pOldFirstName is mapped to firstNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void del()
            throws OpbDataAccessException {
        final String methodName = "del()";

        logger.entering(CLASS_NAME, methodName);

        del(getPersonId(),
                    getLastNameDataSourceValue(),
                    getAddressIdDataSourceValue(),
                    getFirstNameDataSourceValue());

    }

    /**
     * Creates a Person returning it's new primary key value(s).
     * Calls the database procedure ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void ins(final OpbValueWrapper<Long> pPersonId,
            final String pLastName,
            final Long pAddressId,
            final String pFirstName)
            throws OpbDataAccessException {
        final String methodName = "ins(OpbValueWrapper, String, Long, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pPersonId", pPersonId);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN person.ins(?, ?, ?, ?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pLastName);

        opbCallHelper.setObject(
                3, java.sql.Types.BIGINT, pAddressId);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pFirstName);


        opbCallHelper.execute();

        pPersonId.setValue(opbCallHelper.get(Long.class, 1));

        opbDataObjectSource.invalidateCached(Person.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pPersonId is mapped to personId</li>
     * <li>pLastName is mapped to lastName</li>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pFirstName is mapped to firstName</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void ins()
            throws OpbDataAccessException {
        final String methodName = "ins()";

        logger.entering(CLASS_NAME, methodName);

        OpbValueWrapper<Long> pPersonIdValueWrapper =
                new OpbValueWrapperImpl<Long>();


        ins(pPersonIdValueWrapper,
                    getLastName(),
                    getAddressId(),
                    getFirstName());

        setPersonId(pPersonIdValueWrapper.getValue());


    }

    /**
     * Updates a Person by primary key.
     * Calls the database procedure upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void upd(final Long pPersonId,
            final String pLastName,
            final Long pAddressId,
            final String pFirstName,
            final String pOldLastName,
            final Long pOldAddressId,
            final String pOldFirstName)
            throws OpbDataAccessException {
        final String methodName = "upd(Long, String, Long, String, String, Long, String)";

        logger.entering(CLASS_NAME, methodName);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN person.upd(?, ?, ?, ?, ?, ?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, pPersonId);

        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pLastName);

        opbCallHelper.setObject(
                3, java.sql.Types.BIGINT, pAddressId);

        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pFirstName);

        opbCallHelper.setObject(
                5, java.sql.Types.VARCHAR, pOldLastName);

        opbCallHelper.setObject(
                6, java.sql.Types.BIGINT, pOldAddressId);

        opbCallHelper.setObject(
                7, java.sql.Types.VARCHAR, pOldFirstName);


        opbCallHelper.execute();

        opbDataObjectSource.invalidateCached(Person.class, getOpbId());

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pPersonId is mapped to personId</li>
     * <li>pLastName is mapped to lastName</li>
     * <li>pAddressId is mapped to addressId</li>
     * <li>pFirstName is mapped to firstName</li>
     * <li>pOldLastName is mapped to lastNameDataSourceValue</li>
     * <li>pOldAddressId is mapped to addressIdDataSourceValue</li>
     * <li>pOldFirstName is mapped to firstNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void upd()
            throws OpbDataAccessException {
        final String methodName = "upd()";

        logger.entering(CLASS_NAME, methodName);

        upd(getPersonId(),
                    getLastName(),
                    getAddressId(),
                    getFirstName(),
                    getLastNameDataSourceValue(),
                    getAddressIdDataSourceValue(),
                    getFirstNameDataSourceValue());

    }


}