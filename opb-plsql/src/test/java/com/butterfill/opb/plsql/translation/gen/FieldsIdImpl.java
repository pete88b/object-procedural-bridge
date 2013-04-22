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
 * fields_id.
 */
public class FieldsIdImpl implements FieldsId {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            FieldsIdImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of FieldsIdImpl.
     */
    public FieldsIdImpl() {
        logger.entering(CLASS_NAME, "FieldsIdImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this FieldsIdImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this FieldsIdImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this FieldsIdImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this FieldsIdImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this FieldsIdImpl.
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
        pk = null;

        pk2 = null;
        pk2DataSourceValue = null;

        a = null;


    } // End of opbClearState()

    /**
     * The id of this FieldsIdImpl.
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this FieldsIdImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>pk</li>
     * <li>pk2</li>
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
     * <li>pk is <em>mandatory</em></li>
     * <li>pk2 is <em>mandatory</em></li>
     * <li>a is <em>mandatory</em></li>
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
            // load pk from column pk
            pk = OpbSqlHelper.getValue(
                    pk, resultSet,
                    "pk", true);

            // load pk2 from column pk2
            pk2 = OpbSqlHelper.getValue(
                    pk2, resultSet,
                    "pk2", true);
            // save the value we just loaded as the datasource value
            pk2DataSourceValue = pk2;

            // load a from column a
            a = OpbSqlHelper.getValue(
                    a, resultSet,
                    "a", true);


            // create the id
            opbId = new OpbId(pk,
                pk2);

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
    private String pk = null;

    /**
     * Returns the value of pk.
     * @return The value of pk.
     */
    public String getPk() {
        return pk;
    }

    /**
     * Sets the value of pk.
     * @param a The new value for pk.
     */
    private void setPk(final String a) {
        this.pk = a;
    }

    /**
     * Derived from an opb-package field.
     */
    private String pk2 = null;

    /**
     * Returns the value of pk2.
     * @return The value of pk2.
     */
    public String getPk2() {
        return pk2;
    }

    /**
     * Sets the value of pk2.
     * @param a The new value for pk2.
     */
    public void setPk2(final String a) {
        this.pk2 = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String pk2DataSourceValue = null;

    /**
     * Returns the value of pk2DataSourceValue.
     * This is the last value returned by the data source for pk2.
     * @return The value of pk2DataSourceValue.
     */
    public String getPk2DataSourceValue() {
        return pk2DataSourceValue;
    }

    /**
     * Returns true if the value of pk2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if pk2 has changed since it was loaded.
     */
    public boolean getPk2Changed() {
        return !OpbComparisonHelper.isEqual(
                    pk2, pk2DataSourceValue);
    }

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
     * @param a The new value for a.
     */
    private void setA(final String a) {
        this.a = a;
    }


}