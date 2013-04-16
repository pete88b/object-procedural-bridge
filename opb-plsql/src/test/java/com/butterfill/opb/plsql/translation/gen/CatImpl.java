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
 * cat.
 */
public class CatImpl implements Cat {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            CatImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of CatImpl.
     */
    public CatImpl() {
        logger.entering(CLASS_NAME, "CatImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this CatImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this CatImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this CatImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this CatImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this CatImpl.
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
        name = null;
        
        type = null;
        
        lastChanged = null;
        
        description = null;
        descriptionDataSourceValue = null;
        

    } // End of opbClearState()

    /**
     * The id of this CatImpl.
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this CatImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>name</li>
     * <li>type</li>
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
     * <li>name is <em>mandatory</em></li>
     * <li>type is <em>mandatory</em></li>
     * <li>last_changed is <em>mandatory</em></li>
     * <li>description is <em>mandatory</em></li>
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
            // load name from column name
            name = OpbSqlHelper.getValue(
                    name, resultSet,
                    "name", true);
            
            // load type from column type
            type = OpbSqlHelper.getValue(
                    type, resultSet,
                    "type", true);
            
            // load lastChanged from column last_changed
            lastChanged = OpbSqlHelper.getValue(
                    lastChanged, resultSet,
                    "last_changed", true);
            
            // load description from column description
            description = OpbSqlHelper.getValue(
                    description, resultSet,
                    "description", true);
            // save the value we just loaded as the datasource value
            descriptionDataSourceValue = description;
            

            // create the id
            opbId = new OpbId(name,
                type);

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
    private String name = null;
    
    /**
     * Returns the value of name.
     * @return The value of name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the value of name.
     * @param a The new value for name.
     */
    private void setName(final String a) {
        this.name = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private Long type = null;
    
    /**
     * Returns the value of type.
     * @return The value of type.
     */
    public Long getType() {
        return type;
    }
    
    /**
     * Sets the value of type.
     * @param a The new value for type.
     */
    private void setType(final Long a) {
        this.type = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private java.util.Date lastChanged = null;
    
    /**
     * Returns the value of lastChanged.
     * @return The value of lastChanged.
     */
    public java.util.Date getLastChanged() {
        return lastChanged;
    }
    
    /**
     * Sets the value of lastChanged.
     * @param a The new value for lastChanged.
     */
    private void setLastChanged(final java.util.Date a) {
        this.lastChanged = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String description = null;
    
    /**
     * Returns the value of description.
     * @return The value of description.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the value of description.
     * @param a The new value for description.
     */
    public void setDescription(final String a) {
        this.description = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String descriptionDataSourceValue = null;
    
    /**
     * Returns the value of descriptionDataSourceValue.
     * This is the last value returned by the data source for description.
     * @return The value of descriptionDataSourceValue.
     */
    public String getDescriptionDataSourceValue() {
        return descriptionDataSourceValue;
    }
    
    /**
     * Returns true if the value of description
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if description has changed since it was loaded.
     */
    public boolean getDescriptionChanged() {
        return !OpbComparisonHelper.isEqual(
                    description, descriptionDataSourceValue);
    }


    /**
     * invalidate this instance when update_description is called.
     * Calls the database procedure update_description.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void updateDescription(final String pName,
            final Long pType,
            final String pDescription)
            throws OpbDataAccessException {
        final String methodName = "updateDescription(String, Long, String)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN cat.update_description(?, ?, ?); END;");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pName);
        
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pType);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDescription);
        
    
        opbCallHelper.execute();
    
        opbDataObjectSource.invalidateCached(Cat.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls updateDescription using mapped parameters.
     * <ul>
     * <li>pName is mapped to name</li>
     * <li>pType is mapped to type</li>
     * <li>pDescription is mapped to description</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void updateDescription()
            throws OpbDataAccessException {
        final String methodName = "updateDescription()";
    
        logger.entering(CLASS_NAME, methodName);
    
        updateDescription(getName(),
                    getType(),
                    getDescription());
    
    }
    
    /**
     * clear this instance when delete_cat is called.
     * Calls the database procedure delete_cat.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deleteCat(final String pName,
            final Long pType)
            throws OpbDataAccessException {
        final String methodName = "deleteCat(String, Long)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN cat.delete_cat(?, ?); END;");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pName);
        
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pType);
        
    
        opbCallHelper.execute();
    
        opbDataObjectSource.clearCached(Cat.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls deleteCat using mapped parameters.
     * <ul>
     * <li>pName is mapped to name</li>
     * <li>pType is mapped to type</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deleteCat()
            throws OpbDataAccessException {
        final String methodName = "deleteCat()";
    
        logger.entering(CLASS_NAME, methodName);
    
        deleteCat(getName(),
                    getType());
    
    }
    
    /**
     * 
     * Calls the database procedure clear_cached_all.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void clearCachedAll()
            throws OpbDataAccessException {
        final String methodName = "clearCachedAll()";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN cat.clear_cached_all(); END;");
    
        opbCallHelper.execute();
    
        opbDataObjectSource.clearCached();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure invalidate_cached_all.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void invalidateCachedAll()
            throws OpbDataAccessException {
        final String methodName = "invalidateCachedAll()";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN cat.invalidate_cached_all(); END;");
    
        opbCallHelper.execute();
    
        opbDataObjectSource.invalidateCached();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure clear_cached_cats.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void clearCachedCats()
            throws OpbDataAccessException {
        final String methodName = "clearCachedCats()";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN cat.clear_cached_cats(); END;");
    
        opbCallHelper.execute();
    
        opbDataObjectSource.clearCached(Cat.class);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure invalidate_cached_cats.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void invalidateCachedCats()
            throws OpbDataAccessException {
        final String methodName = "invalidateCachedCats()";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN cat.invalidate_cached_cats(); END;");
    
        opbCallHelper.execute();
    
        opbDataObjectSource.invalidateCached(Cat.class);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}