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
 * people.
 */
public class PeopleImpl implements People {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PeopleImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of PeopleImpl.
     */
    public PeopleImpl() {
        logger.entering(CLASS_NAME, "PeopleImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PeopleImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this PeopleImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PeopleImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PeopleImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PeopleImpl.
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
        lastName = null;
        
        addressId = null;
        
        firstName = null;
        

    } // End of opbClearState()

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
     * Derived from an opb-package field.
     */
    private String addressId = null;
    
    /**
     * Returns the value of addressId.
     * @return The value of addressId.
     */
    public String getAddressId() {
        return addressId;
    }
    
    /**
     * Sets the value of addressId.
     * @param a The new value for addressId.
     */
    public void setAddressId(final String a) {
        this.addressId = a;
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
     * Returns all people that meet the search criteria.
     * Calls the database function get_filtered.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Person>
            getFiltered(final String pLastName,
            final String pFirstName,
            final String pAddress,
            final String pCity)
            throws OpbDataAccessException {
        final String methodName = "getFiltered(String, String, String, String)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "people.get_filtered",
                pLastName,
                pFirstName,
                pAddress,
                pCity);
    
        java.util.List<Person> result =
                opbDataObjectSource.getCachedResult(
                Person.class, keyToResult);
    
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := people.get_filtered(?, ?, ?, ?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pLastName);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pFirstName);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pAddress);
        
        opbCallHelper.setObject(
                5, java.sql.Types.VARCHAR, pCity);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                Person.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

}