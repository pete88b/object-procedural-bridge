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
 * fields_in_load.
 */
public class FieldsInLoadImpl implements FieldsInLoad {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            FieldsInLoadImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of FieldsInLoadImpl.
     */
    public FieldsInLoadImpl() {
        logger.entering(CLASS_NAME, "FieldsInLoadImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this FieldsInLoadImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this FieldsInLoadImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this FieldsInLoadImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this FieldsInLoadImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this FieldsInLoadImpl.
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
        fDefault = null;

        fOptional = null;

        fIgnored = null;


    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>f_default is <em>mandatory</em></li>
     * <li>f_optional is optional</li>
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
            // load fDefault from column f_default
            fDefault = OpbSqlHelper.getValue(
                    fDefault, resultSet,
                    "f_default", true);

            // load fOptional from column f_optional
            fOptional = OpbSqlHelper.getValue(
                    fOptional, resultSet,
                    "f_optional", false);


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
    private String fDefault = null;

    /**
     * Returns the value of fDefault.
     * @return The value of fDefault.
     */
    public String getFDefault() {
        return fDefault;
    }

    /**
     * Sets the value of fDefault.
     * @param a The new value for fDefault.
     */
    private void setFDefault(final String a) {
        this.fDefault = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String fOptional = null;

    /**
     * Returns the value of fOptional.
     * @return The value of fOptional.
     */
    public String getFOptional() {
        return fOptional;
    }

    /**
     * Sets the value of fOptional.
     * @param a The new value for fOptional.
     */
    private void setFOptional(final String a) {
        this.fOptional = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String fIgnored = null;

    /**
     * Returns the value of fIgnored.
     * @return The value of fIgnored.
     */
    public String getFIgnored() {
        return fIgnored;
    }

    /**
     * Sets the value of fIgnored.
     * @param a The new value for fIgnored.
     */
    private void setFIgnored(final String a) {
        this.fIgnored = a;
    }


}