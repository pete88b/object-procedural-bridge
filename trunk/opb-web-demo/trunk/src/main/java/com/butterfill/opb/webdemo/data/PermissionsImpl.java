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
 * permissions.
 */
public class PermissionsImpl implements Permissions {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PermissionsImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of PermissionsImpl.
     */
    public PermissionsImpl() {
        logger.entering(CLASS_NAME, "PermissionsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PermissionsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this PermissionsImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this PermissionsImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this PermissionsImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this PermissionsImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this PermissionsImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this PermissionsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PermissionsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PermissionsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PermissionsImpl.
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
        permission = null;
        permissionDataSourceValue = null;
        
        description = null;
        descriptionDataSourceValue = null;
        
        status = null;
        statusDataSourceValue = null;
        
        permissionSearchString = null;
        permissionSearchStringDataSourceValue = null;
        
        descriptionSearchString = null;
        descriptionSearchStringDataSourceValue = null;
        
        statusSearchValue = null;
        statusSearchValueDataSourceValue = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling 
     * opbClearState() and then sets all field values using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>permission is optional</li>
     * <li>description is optional</li>
     * <li>status is optional</li>
     * <li>permission_search_string is optional</li>
     * <li>description_search_string is optional</li>
     * <li>status_search_value is optional</li>
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
            // load permission from column permission
            permission = OpbSqlHelper.getValue(
                    permission, resultSet, 
                    "permission", false);
            // save the value we just loaded as the datasource value
            permissionDataSourceValue = permission;
            
            // load description from column description
            description = OpbSqlHelper.getValue(
                    description, resultSet, 
                    "description", false);
            // save the value we just loaded as the datasource value
            descriptionDataSourceValue = description;
            
            // load status from column status
            status = OpbSqlHelper.getValue(
                    status, resultSet, 
                    "status", false);
            // save the value we just loaded as the datasource value
            statusDataSourceValue = status;
            
            // load permissionSearchString from column permission_search_string
            permissionSearchString = OpbSqlHelper.getValue(
                    permissionSearchString, resultSet, 
                    "permission_search_string", false);
            // save the value we just loaded as the datasource value
            permissionSearchStringDataSourceValue = permissionSearchString;
            
            // load descriptionSearchString from column description_search_string
            descriptionSearchString = OpbSqlHelper.getValue(
                    descriptionSearchString, resultSet, 
                    "description_search_string", false);
            // save the value we just loaded as the datasource value
            descriptionSearchStringDataSourceValue = descriptionSearchString;
            
            // load statusSearchValue from column status_search_value
            statusSearchValue = OpbSqlHelper.getValue(
                    statusSearchValue, resultSet, 
                    "status_search_value", false);
            // save the value we just loaded as the datasource value
            statusSearchValueDataSourceValue = statusSearchValue;
            

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
    private String permission = null;
    
    /**
     * Returns the value of permission.
     * @return The value of permission.
     */
    public String getPermission() {
        return permission;
    }
    
    /**
     * Sets the value of permission.
     * @param a The new value for permission.
     */
    public void setPermission(final String a) {
        this.permission = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String permissionDataSourceValue = null;
    
    /**
     * Returns the value of permissionDataSourceValue.
     * This is the last value returned by the data source for permission.
     * @return The value of permissionDataSourceValue.
     */
    public String getPermissionDataSourceValue() {
        return permissionDataSourceValue;
    }
    
    /**
     * Returns true if the value of permission 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permission has changed since it was loaded.
     */
    public boolean getPermissionChanged() {
        return !OpbComparisonHelper.isEqual(
                    permission, permissionDataSourceValue);
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
     * Derived from an opb-package field.
     */
    private Long status = null;
    
    /**
     * Returns the value of status.
     * @return The value of status.
     */
    public Long getStatus() {
        return status;
    }
    
    /**
     * Sets the value of status.
     * @param a The new value for status.
     */
    public void setStatus(final Long a) {
        this.status = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private Long statusDataSourceValue = null;
    
    /**
     * Returns the value of statusDataSourceValue.
     * This is the last value returned by the data source for status.
     * @return The value of statusDataSourceValue.
     */
    public Long getStatusDataSourceValue() {
        return statusDataSourceValue;
    }
    
    /**
     * Returns true if the value of status 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if status has changed since it was loaded.
     */
    public boolean getStatusChanged() {
        return !OpbComparisonHelper.isEqual(
                    status, statusDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String permissionSearchString = null;
    
    /**
     * Returns the value of permissionSearchString.
     * @return The value of permissionSearchString.
     */
    public String getPermissionSearchString() {
        return permissionSearchString;
    }
    
    /**
     * Sets the value of permissionSearchString.
     * @param a The new value for permissionSearchString.
     */
    public void setPermissionSearchString(final String a) {
        this.permissionSearchString = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String permissionSearchStringDataSourceValue = null;
    
    /**
     * Returns the value of permissionSearchStringDataSourceValue.
     * This is the last value returned by the data source for permissionSearchString.
     * @return The value of permissionSearchStringDataSourceValue.
     */
    public String getPermissionSearchStringDataSourceValue() {
        return permissionSearchStringDataSourceValue;
    }
    
    /**
     * Returns true if the value of permissionSearchString 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionSearchString has changed since it was loaded.
     */
    public boolean getPermissionSearchStringChanged() {
        return !OpbComparisonHelper.isEqual(
                    permissionSearchString, permissionSearchStringDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String descriptionSearchString = null;
    
    /**
     * Returns the value of descriptionSearchString.
     * @return The value of descriptionSearchString.
     */
    public String getDescriptionSearchString() {
        return descriptionSearchString;
    }
    
    /**
     * Sets the value of descriptionSearchString.
     * @param a The new value for descriptionSearchString.
     */
    public void setDescriptionSearchString(final String a) {
        this.descriptionSearchString = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String descriptionSearchStringDataSourceValue = null;
    
    /**
     * Returns the value of descriptionSearchStringDataSourceValue.
     * This is the last value returned by the data source for descriptionSearchString.
     * @return The value of descriptionSearchStringDataSourceValue.
     */
    public String getDescriptionSearchStringDataSourceValue() {
        return descriptionSearchStringDataSourceValue;
    }
    
    /**
     * Returns true if the value of descriptionSearchString 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if descriptionSearchString has changed since it was loaded.
     */
    public boolean getDescriptionSearchStringChanged() {
        return !OpbComparisonHelper.isEqual(
                    descriptionSearchString, descriptionSearchStringDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private Long statusSearchValue = null;
    
    /**
     * Returns the value of statusSearchValue.
     * @return The value of statusSearchValue.
     */
    public Long getStatusSearchValue() {
        return statusSearchValue;
    }
    
    /**
     * Sets the value of statusSearchValue.
     * @param a The new value for statusSearchValue.
     */
    public void setStatusSearchValue(final Long a) {
        this.statusSearchValue = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private Long statusSearchValueDataSourceValue = null;
    
    /**
     * Returns the value of statusSearchValueDataSourceValue.
     * This is the last value returned by the data source for statusSearchValue.
     * @return The value of statusSearchValueDataSourceValue.
     */
    public Long getStatusSearchValueDataSourceValue() {
        return statusSearchValueDataSourceValue;
    }
    
    /**
     * Returns true if the value of statusSearchValue 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if statusSearchValue has changed since it was loaded.
     */
    public boolean getStatusSearchValueChanged() {
        return !OpbComparisonHelper.isEqual(
                    statusSearchValue, statusSearchValueDataSourceValue);
    }


    /**
     * 
     * Calls the database function get_permissions.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission> 
            getPermissions(final String pPermissionSearchString,
            final String pDescriptionSearchString,
            final Long pStatusSearchValue) 
            throws OpbDataAccessException {
        final String methodName = "getPermissions(String, String, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "permissions.get_permissions",
                pPermissionSearchString,
                pDescriptionSearchString,
                pStatusSearchValue);
    
        java.util.List<Permission> result = 
                opbDataObjectSource.getCachedResult(
                Permission.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permissions.get_permissions(?, ?, ?); END;",
                "DbCall:permissions#get_permissions(VARCHAR2, VARCHAR2, INTEGER)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermissionSearchString);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDescriptionSearchString);
        
        opbCallHelper.setObject(
                4, java.sql.Types.BIGINT, pStatusSearchValue);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                Permission.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getPermissions using mapped parameters.
     * <ul>
     * <li>pPermissionSearchString is mapped to permissionSearchString</li>
     * <li>pDescriptionSearchString is mapped to descriptionSearchString</li>
     * <li>pStatusSearchValue is mapped to statusSearchValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission>
            getPermissions() 
            throws OpbDataAccessException {
        final String methodName = "getPermissions()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<Permission> result = getPermissions(
                getPermissionSearchString(),
                getDescriptionSearchString(),
                getStatusSearchValue());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_permission_sets.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission> 
            getPermissionSets(final String pPermissionSearchString,
            final String pDescriptionSearchString,
            final Long pStatusSearchValue) 
            throws OpbDataAccessException {
        final String methodName = "getPermissionSets(String, String, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "permissions.get_permission_sets",
                pPermissionSearchString,
                pDescriptionSearchString,
                pStatusSearchValue);
    
        java.util.List<Permission> result = 
                opbDataObjectSource.getCachedResult(
                Permission.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permissions.get_permission_sets(?, ?, ?); END;",
                "DbCall:permissions#get_permission_sets(VARCHAR2, VARCHAR2, INTEGER)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermissionSearchString);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDescriptionSearchString);
        
        opbCallHelper.setObject(
                4, java.sql.Types.BIGINT, pStatusSearchValue);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                Permission.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getPermissionSets using mapped parameters.
     * <ul>
     * <li>pPermissionSearchString is mapped to permissionSearchString</li>
     * <li>pDescriptionSearchString is mapped to descriptionSearchString</li>
     * <li>pStatusSearchValue is mapped to statusSearchValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission>
            getPermissionSets() 
            throws OpbDataAccessException {
        final String methodName = "getPermissionSets()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<Permission> result = getPermissionSets(
                getPermissionSearchString(),
                getDescriptionSearchString(),
                getStatusSearchValue());
    
    
        return result;
    }
    

}