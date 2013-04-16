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
 * embedded_comments.
 */
public class EmbeddedCommentsImpl implements EmbeddedComments {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            EmbeddedCommentsImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of EmbeddedCommentsImpl.
     */
    public EmbeddedCommentsImpl() {
        logger.entering(CLASS_NAME, "EmbeddedCommentsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this EmbeddedCommentsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this EmbeddedCommentsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this EmbeddedCommentsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this EmbeddedCommentsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this EmbeddedCommentsImpl.
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
        include = null;
        includeDataSourceValue = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>include is <em>mandatory</em></li>
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
            // load include from column include
            include = OpbSqlHelper.getValue(
                    include, resultSet,
                    "include", true);
            // save the value we just loaded as the datasource value
            includeDataSourceValue = include;
            

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
    private String include = null;
    
    /**
     * Returns the value of include.
     * @return The value of include.
     */
    public String getInclude() {
        return include;
    }
    
    /**
     * Sets the value of include.
     * @param a The new value for include.
     */
    public void setInclude(final String a) {
        this.include = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String includeDataSourceValue = null;
    
    /**
     * Returns the value of includeDataSourceValue.
     * This is the last value returned by the data source for include.
     * @return The value of includeDataSourceValue.
     */
    public String getIncludeDataSourceValue() {
        return includeDataSourceValue;
    }
    
    /**
     * Returns true if the value of include
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if include has changed since it was loaded.
     */
    public boolean getIncludeChanged() {
        return !OpbComparisonHelper.isEqual(
                    include, includeDataSourceValue);
    }


    /**
     * if the param element wasn't commented, this call would not be translated as
     * the datatype of p_data would be set to something un-known.
     * Calls the database procedure a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void a(final java.math.BigDecimal pData)
            throws OpbDataAccessException {
        final String methodName = "a(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN embedded_comments.a(?); END;");
    
        opbCallHelper.setObject(
                1, java.sql.Types.DECIMAL, pData);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}