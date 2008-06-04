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
 * permission.
 */
public class PermissionImpl implements Permission {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PermissionImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of PermissionImpl.
     */
    public PermissionImpl() {
        logger.entering(CLASS_NAME, "PermissionImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PermissionImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this PermissionImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this PermissionImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this PermissionImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this PermissionImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this PermissionImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this PermissionImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PermissionImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PermissionImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PermissionImpl.
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
        permission = null;
        
        description = null;
        descriptionDataSourceValue = null;
        
        status = null;
        statusDataSourceValue = null;
        
        newPermission = null;
        newPermissionDataSourceValue = null;
        
        permissionAllowed = null;
        permissionAllowedDataSourceValue = null;
        
        permissionDenied = null;
        permissionDeniedDataSourceValue = null;
        
        permissionSet = null;
        
        permissionRequired = null;
        permissionRequiredDataSourceValue = null;
        
        permissionSearchString = null;
        permissionSearchStringDataSourceValue = null;
        
        allowableSearchString = null;
        allowableSearchStringDataSourceValue = null;
        

    } // End of opbClearState()

    /**
     * The id of this PermissionImpl. 
     * Set by opbLoad(ResultSet).
     */
    private OpbId opbId;

    /**
     * Returns the id of this PermissionImpl.
     * This ID is created using the field(s):
     * <ul>
     * <li>permission</li>
     * <li>permissionSet</li>
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
     * <li>permission is <em>mandatory</em></li>
     * <li>description is <em>mandatory</em></li>
     * <li>status is <em>mandatory</em></li>
     * <li>new_permission is optional</li>
     * <li>permission_allowed is optional</li>
     * <li>permission_denied is optional</li>
     * <li>permission_set is optional</li>
     * <li>permission_required is optional</li>
     * <li>permission_search_string is optional</li>
     * <li>allowable_search_string is optional</li>
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
                    "permission", true);
            
            // load description from column description
            description = OpbSqlHelper.getValue(
                    description, resultSet, 
                    "description", true);
            // save the value we just loaded as the datasource value
            descriptionDataSourceValue = description;
            
            // load status from column status
            status = OpbSqlHelper.getValue(
                    status, resultSet, 
                    "status", true);
            // save the value we just loaded as the datasource value
            statusDataSourceValue = status;
            
            // load newPermission from column new_permission
            newPermission = OpbSqlHelper.getValue(
                    newPermission, resultSet, 
                    "new_permission", false);
            // save the value we just loaded as the datasource value
            newPermissionDataSourceValue = newPermission;
            
            // load permissionAllowed from column permission_allowed
            permissionAllowed = OpbSqlHelper.getValue(
                    permissionAllowed, resultSet, 
                    "permission_allowed", false);
            // save the value we just loaded as the datasource value
            permissionAllowedDataSourceValue = permissionAllowed;
            
            // load permissionDenied from column permission_denied
            permissionDenied = OpbSqlHelper.getValue(
                    permissionDenied, resultSet, 
                    "permission_denied", false);
            // save the value we just loaded as the datasource value
            permissionDeniedDataSourceValue = permissionDenied;
            
            // load permissionSet from column permission_set
            permissionSet = OpbSqlHelper.getValue(
                    permissionSet, resultSet, 
                    "permission_set", false);
            
            // load permissionRequired from column permission_required
            permissionRequired = OpbSqlHelper.getValue(
                    permissionRequired, resultSet, 
                    "permission_required", false);
            // save the value we just loaded as the datasource value
            permissionRequiredDataSourceValue = permissionRequired;
            
            // load permissionSearchString from column permission_search_string
            permissionSearchString = OpbSqlHelper.getValue(
                    permissionSearchString, resultSet, 
                    "permission_search_string", false);
            // save the value we just loaded as the datasource value
            permissionSearchStringDataSourceValue = permissionSearchString;
            
            // load allowableSearchString from column allowable_search_string
            allowableSearchString = OpbSqlHelper.getValue(
                    allowableSearchString, resultSet, 
                    "allowable_search_string", false);
            // save the value we just loaded as the datasource value
            allowableSearchStringDataSourceValue = allowableSearchString;
            

            // create the id
            opbId = new OpbId(permission,
                permissionSet);

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
    private void setPermission(final String a) {
        this.permission = a;
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
    private String newPermission = null;
    
    /**
     * Returns the value of newPermission.
     * @return The value of newPermission.
     */
    public String getNewPermission() {
        return newPermission;
    }
    
    /**
     * Sets the value of newPermission.
     * @param a The new value for newPermission.
     */
    public void setNewPermission(final String a) {
        this.newPermission = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String newPermissionDataSourceValue = null;
    
    /**
     * Returns the value of newPermissionDataSourceValue.
     * This is the last value returned by the data source for newPermission.
     * @return The value of newPermissionDataSourceValue.
     */
    public String getNewPermissionDataSourceValue() {
        return newPermissionDataSourceValue;
    }
    
    /**
     * Returns true if the value of newPermission 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if newPermission has changed since it was loaded.
     */
    public boolean getNewPermissionChanged() {
        return !OpbComparisonHelper.isEqual(
                    newPermission, newPermissionDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String permissionAllowed = null;
    
    /**
     * Returns the value of permissionAllowed.
     * @return The value of permissionAllowed.
     */
    public String getPermissionAllowed() {
        return permissionAllowed;
    }
    
    /**
     * Sets the value of permissionAllowed.
     * Calls allow() 
     * if this call changes the value of permissionAllowed.
     * @param a The new value for permissionAllowed.
     */
    public void setPermissionAllowed(final String a) {
        if (!OpbComparisonHelper.isEqual(this.permissionAllowed, a)) {
            // If the new value is different, save it
            this.permissionAllowed = a;
            // and make the "on change" calls
            allow();
        }
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String permissionAllowedDataSourceValue = null;
    
    /**
     * Returns the value of permissionAllowedDataSourceValue.
     * This is the last value returned by the data source for permissionAllowed.
     * @return The value of permissionAllowedDataSourceValue.
     */
    public String getPermissionAllowedDataSourceValue() {
        return permissionAllowedDataSourceValue;
    }
    
    /**
     * Returns true if the value of permissionAllowed 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionAllowed has changed since it was loaded.
     */
    public boolean getPermissionAllowedChanged() {
        return !OpbComparisonHelper.isEqual(
                    permissionAllowed, permissionAllowedDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String permissionDenied = null;
    
    /**
     * Returns the value of permissionDenied.
     * @return The value of permissionDenied.
     */
    public String getPermissionDenied() {
        return permissionDenied;
    }
    
    /**
     * Sets the value of permissionDenied.
     * Calls deny() 
     * if this call changes the value of permissionDenied.
     * @param a The new value for permissionDenied.
     */
    public void setPermissionDenied(final String a) {
        if (!OpbComparisonHelper.isEqual(this.permissionDenied, a)) {
            // If the new value is different, save it
            this.permissionDenied = a;
            // and make the "on change" calls
            deny();
        }
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String permissionDeniedDataSourceValue = null;
    
    /**
     * Returns the value of permissionDeniedDataSourceValue.
     * This is the last value returned by the data source for permissionDenied.
     * @return The value of permissionDeniedDataSourceValue.
     */
    public String getPermissionDeniedDataSourceValue() {
        return permissionDeniedDataSourceValue;
    }
    
    /**
     * Returns true if the value of permissionDenied 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionDenied has changed since it was loaded.
     */
    public boolean getPermissionDeniedChanged() {
        return !OpbComparisonHelper.isEqual(
                    permissionDenied, permissionDeniedDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String permissionSet = null;
    
    /**
     * Returns the value of permissionSet.
     * @return The value of permissionSet.
     */
    public String getPermissionSet() {
        return permissionSet;
    }
    
    /**
     * Sets the value of permissionSet.
     * @param a The new value for permissionSet.
     */
    private void setPermissionSet(final String a) {
        this.permissionSet = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String permissionRequired = null;
    
    /**
     * Returns the value of permissionRequired.
     * @return The value of permissionRequired.
     */
    public String getPermissionRequired() {
        return permissionRequired;
    }
    
    /**
     * Sets the value of permissionRequired.
     * @param a The new value for permissionRequired.
     */
    public void setPermissionRequired(final String a) {
        this.permissionRequired = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String permissionRequiredDataSourceValue = null;
    
    /**
     * Returns the value of permissionRequiredDataSourceValue.
     * This is the last value returned by the data source for permissionRequired.
     * @return The value of permissionRequiredDataSourceValue.
     */
    public String getPermissionRequiredDataSourceValue() {
        return permissionRequiredDataSourceValue;
    }
    
    /**
     * Returns true if the value of permissionRequired 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionRequired has changed since it was loaded.
     */
    public boolean getPermissionRequiredChanged() {
        return !OpbComparisonHelper.isEqual(
                    permissionRequired, permissionRequiredDataSourceValue);
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
    private String allowableSearchString = null;
    
    /**
     * Returns the value of allowableSearchString.
     * @return The value of allowableSearchString.
     */
    public String getAllowableSearchString() {
        return allowableSearchString;
    }
    
    /**
     * Sets the value of allowableSearchString.
     * @param a The new value for allowableSearchString.
     */
    public void setAllowableSearchString(final String a) {
        this.allowableSearchString = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String allowableSearchStringDataSourceValue = null;
    
    /**
     * Returns the value of allowableSearchStringDataSourceValue.
     * This is the last value returned by the data source for allowableSearchString.
     * @return The value of allowableSearchStringDataSourceValue.
     */
    public String getAllowableSearchStringDataSourceValue() {
        return allowableSearchStringDataSourceValue;
    }
    
    /**
     * Returns true if the value of allowableSearchString 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if allowableSearchString has changed since it was loaded.
     */
    public boolean getAllowableSearchStringChanged() {
        return !OpbComparisonHelper.isEqual(
                    allowableSearchString, allowableSearchStringDataSourceValue);
    }


    /**
     * 
     * Calls the database function permission_exists.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            permissionExists(final String pPermission) 
            throws OpbDataAccessException {
        final String methodName = "permissionExists(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permission.permission_exists(?); END;",
                "DbCall:permission#permission_exists(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Returns the status of the permission or NULL if the permission
     * does not exist.
     * Calls the database function get_permission_status.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            getPermissionStatus(final String pPermission) 
            throws OpbDataAccessException {
        final String methodName = "getPermissionStatus(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permission.get_permission_status(?); END;",
                "DbCall:permission#get_permission_status(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function get_permission_description.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            getPermissionDescription(final String pPermission) 
            throws OpbDataAccessException {
        final String methodName = "getPermissionDescription(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permission.get_permission_description(?); END;",
                "DbCall:permission#get_permission_description(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function update_permission.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            updatePermission(final String pPermission,
            final String pDescription,
            final String pDescriptionOld,
            final Long pStatus,
            final Long pStatusOld) 
            throws OpbDataAccessException {
        final String methodName = "updatePermission(String, String, String, Long, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permission.update_permission(?, ?, ?, ?, ?); END;",
                "DbCall:permission#update_permission(VARCHAR2, VARCHAR2, VARCHAR2, INTEGER, INTEGER)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDescription);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pDescriptionOld);
        
        opbCallHelper.setObject(
                5, java.sql.Types.BIGINT, pStatus);
        
        opbCallHelper.setObject(
                6, java.sql.Types.BIGINT, pStatusOld);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbDataObjectSource.invalidateCached(Permission.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls updatePermission using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pDescription is mapped to description</li>
     * <li>pDescriptionOld is mapped to descriptionDataSourceValue</li>
     * <li>pStatus is mapped to status</li>
     * <li>pStatusOld is mapped to statusDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            updatePermission() 
            throws OpbDataAccessException {
        final String methodName = "updatePermission()";
    
        logger.entering(CLASS_NAME, methodName);
    
        String result = updatePermission(
                getPermission(),
                getDescription(),
                getDescriptionDataSourceValue(),
                getStatus(),
                getStatusDataSourceValue());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_allowable_permissions.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission> 
            getAllowablePermissions(final String pPermission,
            final String pSearchString) 
            throws OpbDataAccessException {
        final String methodName = "getAllowablePermissions(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "permission.get_allowable_permissions",
                pPermission,
                pSearchString);
    
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
                "BEGIN ? := permission.get_allowable_permissions(?, ?); END;",
                "DbCall:permission#get_allowable_permissions(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pSearchString);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                Permission.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls getAllowablePermissions using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pSearchString is mapped to allowableSearchString</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission>
            getAllowablePermissions() 
            throws OpbDataAccessException {
        final String methodName = "getAllowablePermissions()";
    
        logger.entering(CLASS_NAME, methodName);
    
        java.util.List<Permission> result = getAllowablePermissions(
                getPermission(),
                getAllowableSearchString());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function is_allowed.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String 
            isAllowed(final String pPermission,
            final String pPermissionRequired) 
            throws OpbDataAccessException {
        final String methodName = "isAllowed(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        String result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permission.is_allowed(?, ?); END;",
                "DbCall:permission#is_allowed(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pPermissionRequired);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(String.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * Calls isAllowed using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pPermissionRequired is mapped to permissionRequired</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            isAllowed() 
            throws OpbDataAccessException {
        final String methodName = "isAllowed()";
    
        logger.entering(CLASS_NAME, methodName);
    
        String result = isAllowed(
                getPermission(),
                getPermissionRequired());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_permissions.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission> 
            getPermissions(final String pPermission,
            final String pSearchString) 
            throws OpbDataAccessException {
        final String methodName = "getPermissions(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "permission.get_permissions",
                pPermission,
                pSearchString);
    
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
                "BEGIN ? := permission.get_permissions(?, ?); END;",
                "DbCall:permission#get_permissions(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pSearchString);
        
    
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
     * <li>pPermission is mapped to permission</li>
     * <li>pSearchString is mapped to permissionSearchString</li>
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
                getPermission(),
                getPermissionSearchString());
    
    
        return result;
    }
    
    /**
     * Returns the permission sets of this permission.
     * Calls the database function get_permission_sets.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Permission> 
            getPermissionSets(final String pPermission,
            final String pSearchString) 
            throws OpbDataAccessException {
        final String methodName = "getPermissionSets(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "permission.get_permission_sets",
                pPermission,
                pSearchString);
    
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
                "BEGIN ? := permission.get_permission_sets(?, ?); END;",
                "DbCall:permission#get_permission_sets(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pSearchString);
        
    
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
     * <li>pPermission is mapped to permission</li>
     * <li>pSearchString is mapped to permissionSearchString</li>
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
                getPermission(),
                getPermissionSearchString());
    
    
        return result;
    }
    
    /**
     * 
     * Calls the database function get_permission_statuses.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<PermissionStatus> 
            getPermissionStatuses() 
            throws OpbDataAccessException {
        final String methodName = "getPermissionStatuses()";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "permission.get_permission_statuses");
    
        java.util.List<PermissionStatus> result = 
                opbDataObjectSource.getCachedResult(
                PermissionStatus.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := permission.get_permission_statuses(); END;",
                "DbCall:permission#get_permission_statuses()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                PermissionStatus.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

    /**
     * 
     * Calls the database procedure create_permission.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void createPermission(final String pPermission,
            final String pDescription,
            final Long pStatus) 
            throws OpbDataAccessException {
        final String methodName = "createPermission(String, String, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.create_permission(?, ?, ?); END;",
                "DbCall:permission#create_permission(VARCHAR2, VARCHAR2, INTEGER)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pDescription);
        
        opbCallHelper.setObject(
                3, java.sql.Types.BIGINT, pStatus);
        
    
        opbCallHelper.execute();
    
        opbDataObjectSource.clearCached(Permission.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls createPermission using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to newPermission</li>
     * <li>pDescription is mapped to description</li>
     * <li>pStatus is mapped to status</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void createPermission() 
            throws OpbDataAccessException {
        final String methodName = "createPermission()";
    
        logger.entering(CLASS_NAME, methodName);
    
        createPermission(getNewPermission(),
                    getDescription(),
                    getStatus());
    
    }
    
    /**
     * 
     * Calls the database procedure delete_permission.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deletePermission(final String pPermission) 
            throws OpbDataAccessException {
        final String methodName = "deletePermission(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.delete_permission(?); END;",
                "DbCall:permission#delete_permission(VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
    
        opbCallHelper.execute();
    
        opbDataObjectSource.clearCached(Permission.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls deletePermission using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deletePermission() 
            throws OpbDataAccessException {
        final String methodName = "deletePermission()";
    
        logger.entering(CLASS_NAME, methodName);
    
        deletePermission(getPermission());
    
    }
    
    /**
     * 
     * Calls the database procedure assert_permission_exists.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void assertPermissionExists(final String pPermission) 
            throws OpbDataAccessException {
        final String methodName = "assertPermissionExists(String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.assert_permission_exists(?); END;",
                "DbCall:permission#assert_permission_exists(VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure set_permission_status.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void setPermissionStatus(final String pPermission,
            final Long pStatus) 
            throws OpbDataAccessException {
        final String methodName = "setPermissionStatus(String, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.set_permission_status(?, ?); END;",
                "DbCall:permission#set_permission_status(VARCHAR2, INTEGER)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pStatus);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure set_permission_description.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void setPermissionDescription(final String pPermission,
            final String pPermissionDescription) 
            throws OpbDataAccessException {
        final String methodName = "setPermissionDescription(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.set_permission_description(?, ?); END;",
                "DbCall:permission#set_permission_description(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermissionDescription);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * xxx
     * explain permission loop
     * exceptions.
     * Calls the database procedure allow.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void allow(final String pPermission,
            final String pPermissionAllowed) 
            throws OpbDataAccessException {
        final String methodName = "allow(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.allow(?, ?); END;",
                "DbCall:permission#allow(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermissionAllowed);
        
    
        opbCallHelper.execute();
    
        opbDataObjectSource.invalidateCached(Permission.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls allow using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pPermissionAllowed is mapped to permissionAllowed</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void allow() 
            throws OpbDataAccessException {
        final String methodName = "allow()";
    
        logger.entering(CLASS_NAME, methodName);
    
        allow(getPermission(),
                    getPermissionAllowed());
    
    }
    
    /**
     * 
     * Calls the database procedure deny.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deny(final String pPermission,
            final String pPermissionDenied) 
            throws OpbDataAccessException {
        final String methodName = "deny(String, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN permission.deny(?, ?); END;",
                "DbCall:permission#deny(VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pPermission);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pPermissionDenied);
        
    
        opbCallHelper.execute();
    
        opbDataObjectSource.invalidateCached(Permission.class, getOpbId());
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls deny using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permissionSet</li>
     * <li>pPermissionDenied is mapped to permission</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deny() 
            throws OpbDataAccessException {
        final String methodName = "deny()";
    
        logger.entering(CLASS_NAME, methodName);
    
        deny(getPermissionSet(),
                    getPermission());
    
    }
    

}