/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.0.0
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.webdemo.data;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * property_group.
 */
public class PropertyGroupImpl implements PropertyGroup {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PropertyGroupImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of PropertyGroupImpl.
     */
    public PropertyGroupImpl() {
        logger.entering(CLASS_NAME, "PropertyGroupImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PropertyGroupImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this PropertyGroupImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this PropertyGroupImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this PropertyGroupImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this PropertyGroupImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this PropertyGroupImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this PropertyGroupImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PropertyGroupImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PropertyGroupImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PropertyGroupImpl.
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
        rowId = null;
        
        groupName = null;
        groupNameDataSourceValue = null;
        
        singleValuePerKey = null;
        singleValuePerKeyDataSourceValue = null;
        
        locked = null;
        lockedDataSourceValue = null;
        
        groupDescription = null;
        groupDescriptionDataSourceValue = null;
        
        forceDelete = null;
        

    } // End of opbClearState()

    /**
     * The id of this PropertyGroupImpl. 
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this PropertyGroupImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>rowId</li>
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
     * <li>row_id is <em>mandatory</em></li>
     * <li>group_name is <em>mandatory</em></li>
     * <li>single_value_per_key is <em>mandatory</em></li>
     * <li>locked is <em>mandatory</em></li>
     * <li>group_description is <em>mandatory</em></li>
     * 
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
            // load rowId from column row_id
            rowId = OpbSqlHelper.getValue(
                    rowId, resultSet, 
                    "row_id", true);
            
            // load groupName from column group_name
            groupName = OpbSqlHelper.getValue(
                    groupName, resultSet, 
                    "group_name", true);
            // save the value we just loaded as the datasource value
            groupNameDataSourceValue = groupName;
            
            // load singleValuePerKey from column single_value_per_key
            singleValuePerKey = OpbSqlHelper.getValue(
                    singleValuePerKey, resultSet, 
                    "single_value_per_key", true);
            // save the value we just loaded as the datasource value
            singleValuePerKeyDataSourceValue = singleValuePerKey;
            
            // load locked from column locked
            locked = OpbSqlHelper.getValue(
                    locked, resultSet, 
                    "locked", true);
            // save the value we just loaded as the datasource value
            lockedDataSourceValue = locked;
            
            // load groupDescription from column group_description
            groupDescription = OpbSqlHelper.getValue(
                    groupDescription, resultSet, 
                    "group_description", true);
            // save the value we just loaded as the datasource value
            groupDescriptionDataSourceValue = groupDescription;
            

            // create the id
            opbId = new OpbId(rowId);

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
    private String rowId = null;
    
    /**
     * Returns the value of rowId.
     * @return The value of rowId.
     */
    public String getRowId() {
        return rowId;
    }
    
    /**
     * Sets the value of rowId.
     * @param a The new value for rowId.
     */
    private void setRowId(final String a) {
        this.rowId = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String groupName = null;
    
    /**
     * Returns the value of groupName.
     * @return The value of groupName.
     */
    public String getGroupName() {
        return groupName;
    }
    
    /**
     * Sets the value of groupName.
     * @param a The new value for groupName.
     */
    public void setGroupName(final String a) {
        this.groupName = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String groupNameDataSourceValue = null;
    
    /**
     * Returns the value of groupNameDataSourceValue.
     * This is the last value returned by the data source for groupName.
     * @return The value of groupNameDataSourceValue.
     */
    public String getGroupNameDataSourceValue() {
        return groupNameDataSourceValue;
    }
    
    /**
     * Returns true if the value of groupName 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if groupName has changed since it was loaded.
     */
    public boolean getGroupNameChanged() {
        return !OpbComparisonHelper.isEqual(
                    groupName, groupNameDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String singleValuePerKey = null;
    
    /**
     * Returns the value of singleValuePerKey.
     * @return The value of singleValuePerKey.
     */
    public String getSingleValuePerKey() {
        return singleValuePerKey;
    }
    
    /**
     * Sets the value of singleValuePerKey.
     * @param a The new value for singleValuePerKey.
     */
    public void setSingleValuePerKey(final String a) {
        this.singleValuePerKey = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String singleValuePerKeyDataSourceValue = null;
    
    /**
     * Returns the value of singleValuePerKeyDataSourceValue.
     * This is the last value returned by the data source for singleValuePerKey.
     * @return The value of singleValuePerKeyDataSourceValue.
     */
    public String getSingleValuePerKeyDataSourceValue() {
        return singleValuePerKeyDataSourceValue;
    }
    
    /**
     * Returns true if the value of singleValuePerKey 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if singleValuePerKey has changed since it was loaded.
     */
    public boolean getSingleValuePerKeyChanged() {
        return !OpbComparisonHelper.isEqual(
                    singleValuePerKey, singleValuePerKeyDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String locked = null;
    
    /**
     * Returns the value of locked.
     * @return The value of locked.
     */
    public String getLocked() {
        return locked;
    }
    
    /**
     * Sets the value of locked.
     * @param a The new value for locked.
     */
    public void setLocked(final String a) {
        this.locked = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String lockedDataSourceValue = null;
    
    /**
     * Returns the value of lockedDataSourceValue.
     * This is the last value returned by the data source for locked.
     * @return The value of lockedDataSourceValue.
     */
    public String getLockedDataSourceValue() {
        return lockedDataSourceValue;
    }
    
    /**
     * Returns true if the value of locked 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if locked has changed since it was loaded.
     */
    public boolean getLockedChanged() {
        return !OpbComparisonHelper.isEqual(
                    locked, lockedDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String groupDescription = null;
    
    /**
     * Returns the value of groupDescription.
     * @return The value of groupDescription.
     */
    public String getGroupDescription() {
        return groupDescription;
    }
    
    /**
     * Sets the value of groupDescription.
     * @param a The new value for groupDescription.
     */
    public void setGroupDescription(final String a) {
        this.groupDescription = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String groupDescriptionDataSourceValue = null;
    
    /**
     * Returns the value of groupDescriptionDataSourceValue.
     * This is the last value returned by the data source for groupDescription.
     * @return The value of groupDescriptionDataSourceValue.
     */
    public String getGroupDescriptionDataSourceValue() {
        return groupDescriptionDataSourceValue;
    }
    
    /**
     * Returns true if the value of groupDescription 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if groupDescription has changed since it was loaded.
     */
    public boolean getGroupDescriptionChanged() {
        return !OpbComparisonHelper.isEqual(
                    groupDescription, groupDescriptionDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private Boolean forceDelete = null;
    
    /**
     * Returns the value of forceDelete.
     * @return The value of forceDelete.
     */
    public Boolean getForceDelete() {
        return forceDelete;
    }
    
    /**
     * Sets the value of forceDelete.
     * @param a The new value for forceDelete.
     */
    public void setForceDelete(final Boolean a) {
        this.forceDelete = a;
    }
    

    /**
     * 
     * Calls the database function ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            ins(final String pGroupName,
            final String pSingleValuePerKey,
            final String pGroupDescription) 
            throws OpbDataAccessException {
        final String methodName = "ins(String, String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := property_group.ins(?, ?, ?); END;",
                "DbCall:property_group#ins(VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pGroupName);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pSingleValuePerKey);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pGroupDescription);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbDataObjectSource.invalidateCached(PropertyGroup.class, getOpbId());
        opbDataObjectSource.invalidateCached(PropertyValue.class);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pGroupName is mapped to groupName</li>
     * <li>pSingleValuePerKey is mapped to singleValuePerKey</li>
     * <li>pGroupDescription is mapped to groupDescription</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            ins() 
            throws OpbDataAccessException {
        final String methodName = "ins()";
    
        logger.entering(CLASS_NAME, methodName);
    
        String result = ins(
                getGroupName(),
                getSingleValuePerKey(),
                getGroupDescription());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            del(final String pRowId,
            final Boolean pForce,
            final String pOldGroupName,
            final String pOldSingleValuePerKey,
            final String pOldLocked,
            final String pOldGroupDescription) 
            throws OpbDataAccessException {
        final String methodName = "del(String, Boolean, String, String, String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := property_group.del(?, ?, ?, ?, ?, ?); END;",
                "DbCall:property_group#del(VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pRowId);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pForce);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pOldGroupName);
        
        opbCallHelper.setObject(
                5, java.sql.Types.VARCHAR, pOldSingleValuePerKey);
        
        opbCallHelper.setObject(
                6, java.sql.Types.VARCHAR, pOldLocked);
        
        opbCallHelper.setObject(
                7, java.sql.Types.VARCHAR, pOldGroupDescription);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbDataObjectSource.clearCached(PropertyGroup.class, getOpbId());
        opbDataObjectSource.clearCached(PropertyValue.class);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pForce is mapped to forceDelete</li>
     * <li>pOldGroupName is mapped to groupNameDataSourceValue</li>
     * <li>pOldSingleValuePerKey is mapped to singleValuePerKeyDataSourceValue</li>
     * <li>pOldLocked is mapped to lockedDataSourceValue</li>
     * <li>pOldGroupDescription is mapped to groupDescriptionDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            del() 
            throws OpbDataAccessException {
        final String methodName = "del()";
    
        logger.entering(CLASS_NAME, methodName);
    
        String result = del(
                getRowId(),
                getForceDelete(),
                getGroupNameDataSourceValue(),
                getSingleValuePerKeyDataSourceValue(),
                getLockedDataSourceValue(),
                getGroupDescriptionDataSourceValue());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            upd(final String pRowId,
            final String pOldGroupName,
            final String pOldSingleValuePerKey,
            final String pSingleValuePerKey,
            final String pOldLocked,
            final String pLocked,
            final String pOldGroupDescription,
            final String pGroupDescription) 
            throws OpbDataAccessException {
        final String methodName = "upd(String, String, String, String, String, String, String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := property_group.upd(?, ?, ?, ?, ?, ?, ?, ?); END;",
                "DbCall:property_group#upd(VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pRowId);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pOldGroupName);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pOldSingleValuePerKey);
        
        opbCallHelper.setObject(
                5, java.sql.Types.VARCHAR, pSingleValuePerKey);
        
        opbCallHelper.setObject(
                6, java.sql.Types.VARCHAR, pOldLocked);
        
        opbCallHelper.setObject(
                7, java.sql.Types.VARCHAR, pLocked);
        
        opbCallHelper.setObject(
                8, java.sql.Types.VARCHAR, pOldGroupDescription);
        
        opbCallHelper.setObject(
                9, java.sql.Types.VARCHAR, pGroupDescription);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbDataObjectSource.invalidateCached(PropertyGroup.class, getOpbId());
        opbDataObjectSource.invalidateCached(PropertyValue.class);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pOldGroupName is mapped to groupNameDataSourceValue</li>
     * <li>pOldSingleValuePerKey is mapped to singleValuePerKeyDataSourceValue</li>
     * <li>pSingleValuePerKey is mapped to singleValuePerKey</li>
     * <li>pOldLocked is mapped to lockedDataSourceValue</li>
     * <li>pLocked is mapped to locked</li>
     * <li>pOldGroupDescription is mapped to groupDescriptionDataSourceValue</li>
     * <li>pGroupDescription is mapped to groupDescription</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            upd() 
            throws OpbDataAccessException {
        final String methodName = "upd()";
    
        logger.entering(CLASS_NAME, methodName);
    
        String result = upd(
                getRowId(),
                getGroupNameDataSourceValue(),
                getSingleValuePerKeyDataSourceValue(),
                getSingleValuePerKey(),
                getLockedDataSourceValue(),
                getLocked(),
                getGroupDescriptionDataSourceValue(),
                getGroupDescription());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_property_values.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<PropertyValue> 
            getPropertyValues(final String pOldGroupName) 
            throws OpbDataAccessException {
        final String methodName = "getPropertyValues(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "property_group.get_property_values",
                pOldGroupName);
    
        java.util.List<PropertyValue> result = 
                opbDataObjectSource.getCachedResult(
                PropertyValue.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := property_group.get_property_values(?); END;",
                "DbCall:property_group#get_property_values(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pOldGroupName);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                PropertyValue.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getPropertyValues using mapped parameters.
     * <ul>
     * <li>pOldGroupName is mapped to groupNameDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<PropertyValue>
            getPropertyValues() 
            throws OpbDataAccessException {
        final String methodName = "getPropertyValues()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<PropertyValue> result = getPropertyValues(
                getGroupNameDataSourceValue());
    
    
        return result;
    }
    

}