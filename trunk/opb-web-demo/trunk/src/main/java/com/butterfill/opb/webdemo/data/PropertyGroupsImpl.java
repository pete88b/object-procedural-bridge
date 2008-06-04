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
 * property_groups.
 */
public class PropertyGroupsImpl implements PropertyGroups {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PropertyGroupsImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of PropertyGroupsImpl.
     */
    public PropertyGroupsImpl() {
        logger.entering(CLASS_NAME, "PropertyGroupsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PropertyGroupsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this PropertyGroupsImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this PropertyGroupsImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this PropertyGroupsImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this PropertyGroupsImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this PropertyGroupsImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this PropertyGroupsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PropertyGroupsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PropertyGroupsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PropertyGroupsImpl.
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
        groupName = null;
        groupNameDataSourceValue = null;
        
        singleValuePerKey = null;
        singleValuePerKeyDataSourceValue = null;
        
        locked = null;
        lockedDataSourceValue = null;
        
        groupDescription = null;
        groupDescriptionDataSourceValue = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling 
     * opbClearState() and then sets all field values using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>group_name is <em>mandatory</em></li>
     * <li>single_value_per_key is <em>mandatory</em></li>
     * <li>locked is <em>mandatory</em></li>
     * <li>group_description is <em>mandatory</em></li>
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
     * 
     * Calls the database function get_property_groups.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<PropertyGroup> 
            getPropertyGroups(final String pGroupName,
            final String pSingleValuePerKey,
            final String pLocked,
            final String pGroupDescription) 
            throws OpbDataAccessException {
        final String methodName = "getPropertyGroups(String, String, String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "property_groups.get_property_groups",
                pGroupName,
                pSingleValuePerKey,
                pLocked,
                pGroupDescription);
    
        java.util.List<PropertyGroup> result = 
                opbDataObjectSource.getCachedResult(
                PropertyGroup.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := property_groups.get_property_groups(?, ?, ?, ?); END;",
                "DbCall:property_groups#get_property_groups(VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pGroupName);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pSingleValuePerKey);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pLocked);
        
        opbCallHelper.setObject(
                5, java.sql.Types.VARCHAR, pGroupDescription);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                PropertyGroup.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getPropertyGroups using mapped parameters.
     * <ul>
     * <li>pGroupName is mapped to groupName</li>
     * <li>pSingleValuePerKey is mapped to singleValuePerKey</li>
     * <li>pLocked is mapped to locked</li>
     * <li>pGroupDescription is mapped to groupDescription</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<PropertyGroup>
            getPropertyGroups() 
            throws OpbDataAccessException {
        final String methodName = "getPropertyGroups()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<PropertyGroup> result = getPropertyGroups(
                getGroupName(),
                getSingleValuePerKey(),
                getLocked(),
                getGroupDescription());
    
    
        return result;
    }
    

}