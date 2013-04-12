/*
 * File created by opb-plsql.
 * 
 * opb-plsql version: 1.0.0
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.webdemo.data;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * permission.
 */
public interface Permission
        extends OpbGroupable, OpbTimingEventPublisher, 
        OpbActiveCacheableEntity {

    /**
     * anything goes.
     */
    Long STATUS_NO_RESTRICTIONS = 0L;
    
    /**
     * permission can't be deleted.
     */
    Long STATUS_NO_DELETE = 1L;
    
    /**
     * permission can't be deleted,
     * no changes to what this permission is allowed to do.
     */
    Long STATUS_NO_CHANGE = 2L;
    
    /**
     * permission can't be deleted,
     * no changes to what this permission is allowed to do and
     * no other permission will be allowed this permission.
     */
    Long STATUS_NO_ALLOW = 3L;
    
    /**
     * permission can't be deleted,
     * no changes to what this permission is allowed to do,
     * no other permission will be allowed this permission and
     * permission can't be removed from a permission set.
     */
    Long STATUS_NO_DENY = 4L;
    

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of permission.
     * @return The value of permission.
     */
    String getPermission();
    
    /**
     * Returns the value of description.
     * @return The value of description.
     */
    String getDescription();
    
    /**
     * Sets the value of description.
     * @param a The new value for description.
     */
    void setDescription(String a);
    
    /**
     * Returns the value of descriptionDataSourceValue.
     * This is the last value returned by the data source for description.
     * @return The value of descriptionDataSourceValue.
     */
    String getDescriptionDataSourceValue();
    
    /**
     * Returns true if the value of description 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if description has changed since it was loaded.
     */
    boolean getDescriptionChanged();
    
    /**
     * Returns the value of status.
     * @return The value of status.
     */
    Long getStatus();
    
    /**
     * Sets the value of status.
     * @param a The new value for status.
     */
    void setStatus(Long a);
    
    /**
     * Returns the value of statusDataSourceValue.
     * This is the last value returned by the data source for status.
     * @return The value of statusDataSourceValue.
     */
    Long getStatusDataSourceValue();
    
    /**
     * Returns true if the value of status 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if status has changed since it was loaded.
     */
    boolean getStatusChanged();
    
    /**
     * Returns the value of newPermission.
     * @return The value of newPermission.
     */
    String getNewPermission();
    
    /**
     * Sets the value of newPermission.
     * @param a The new value for newPermission.
     */
    void setNewPermission(String a);
    
    /**
     * Returns the value of newPermissionDataSourceValue.
     * This is the last value returned by the data source for newPermission.
     * @return The value of newPermissionDataSourceValue.
     */
    String getNewPermissionDataSourceValue();
    
    /**
     * Returns true if the value of newPermission 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if newPermission has changed since it was loaded.
     */
    boolean getNewPermissionChanged();
    
    /**
     * Returns the value of permissionAllowed.
     * @return The value of permissionAllowed.
     */
    String getPermissionAllowed();
    
    /**
     * Sets the value of permissionAllowed.
     * @param a The new value for permissionAllowed.
     */
    void setPermissionAllowed(String a);
    
    /**
     * Returns the value of permissionAllowedDataSourceValue.
     * This is the last value returned by the data source for permissionAllowed.
     * @return The value of permissionAllowedDataSourceValue.
     */
    String getPermissionAllowedDataSourceValue();
    
    /**
     * Returns true if the value of permissionAllowed 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionAllowed has changed since it was loaded.
     */
    boolean getPermissionAllowedChanged();
    
    /**
     * Returns the value of permissionDenied.
     * @return The value of permissionDenied.
     */
    String getPermissionDenied();
    
    /**
     * Sets the value of permissionDenied.
     * @param a The new value for permissionDenied.
     */
    void setPermissionDenied(String a);
    
    /**
     * Returns the value of permissionDeniedDataSourceValue.
     * This is the last value returned by the data source for permissionDenied.
     * @return The value of permissionDeniedDataSourceValue.
     */
    String getPermissionDeniedDataSourceValue();
    
    /**
     * Returns true if the value of permissionDenied 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionDenied has changed since it was loaded.
     */
    boolean getPermissionDeniedChanged();
    
    /**
     * Returns the value of permissionSet.
     * @return The value of permissionSet.
     */
    String getPermissionSet();
    
    /**
     * Returns the value of permissionRequired.
     * @return The value of permissionRequired.
     */
    String getPermissionRequired();
    
    /**
     * Sets the value of permissionRequired.
     * @param a The new value for permissionRequired.
     */
    void setPermissionRequired(String a);
    
    /**
     * Returns the value of permissionRequiredDataSourceValue.
     * This is the last value returned by the data source for permissionRequired.
     * @return The value of permissionRequiredDataSourceValue.
     */
    String getPermissionRequiredDataSourceValue();
    
    /**
     * Returns true if the value of permissionRequired 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionRequired has changed since it was loaded.
     */
    boolean getPermissionRequiredChanged();
    
    /**
     * Returns the value of permissionSearchString.
     * @return The value of permissionSearchString.
     */
    String getPermissionSearchString();
    
    /**
     * Sets the value of permissionSearchString.
     * @param a The new value for permissionSearchString.
     */
    void setPermissionSearchString(String a);
    
    /**
     * Returns the value of permissionSearchStringDataSourceValue.
     * This is the last value returned by the data source for permissionSearchString.
     * @return The value of permissionSearchStringDataSourceValue.
     */
    String getPermissionSearchStringDataSourceValue();
    
    /**
     * Returns true if the value of permissionSearchString 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if permissionSearchString has changed since it was loaded.
     */
    boolean getPermissionSearchStringChanged();
    
    /**
     * Returns the value of allowableSearchString.
     * @return The value of allowableSearchString.
     */
    String getAllowableSearchString();
    
    /**
     * Sets the value of allowableSearchString.
     * @param a The new value for allowableSearchString.
     */
    void setAllowableSearchString(String a);
    
    /**
     * Returns the value of allowableSearchStringDataSourceValue.
     * This is the last value returned by the data source for allowableSearchString.
     * @return The value of allowableSearchStringDataSourceValue.
     */
    String getAllowableSearchStringDataSourceValue();
    
    /**
     * Returns true if the value of allowableSearchString 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if allowableSearchString has changed since it was loaded.
     */
    boolean getAllowableSearchStringChanged();
    

    /**
     * 
     * Calls the database function permission_exists.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String permissionExists(String pPermission) 
            throws OpbDataAccessException; 
    
    /**
     * Returns the status of the permission or NULL if the permission
     * does not exist.
     * Calls the database function get_permission_status.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long getPermissionStatus(String pPermission) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_permission_description.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String getPermissionDescription(String pPermission) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function update_permission.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String updatePermission(String pPermission,
            String pDescription,
            String pDescriptionOld,
            Long pStatus,
            Long pStatusOld) 
            throws OpbDataAccessException; 
    
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
    String updatePermission() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_allowable_permissions.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Permission> getAllowablePermissions(String pPermission,
            String pSearchString) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getAllowablePermissions using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pSearchString is mapped to allowableSearchString</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Permission> getAllowablePermissions() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function is_allowed.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String isAllowed(String pPermission,
            String pPermissionRequired) 
            throws OpbDataAccessException; 
    
    /**
     * Calls isAllowed using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pPermissionRequired is mapped to permissionRequired</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String isAllowed() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_permissions.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Permission> getPermissions(String pPermission,
            String pSearchString) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getPermissions using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pSearchString is mapped to permissionSearchString</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Permission> getPermissions() 
            throws OpbDataAccessException; 
    
    /**
     * Returns the permission sets of this permission.
     * Calls the database function get_permission_sets.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Permission> getPermissionSets(String pPermission,
            String pSearchString) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getPermissionSets using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pSearchString is mapped to permissionSearchString</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<Permission> getPermissionSets() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function get_permission_statuses.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<PermissionStatus> getPermissionStatuses() 
            throws OpbDataAccessException; 
    

    /**
     * 
     * Calls the database procedure create_permission.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void createPermission(String pPermission,
            String pDescription,
            Long pStatus) 
            throws OpbDataAccessException;
    
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
    void createPermission() 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure delete_permission.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deletePermission(String pPermission) 
            throws OpbDataAccessException;
    
    /**
     * Calls deletePermission using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deletePermission() 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure assert_permission_exists.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void assertPermissionExists(String pPermission) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure set_permission_status.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void setPermissionStatus(String pPermission,
            Long pStatus) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure set_permission_description.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void setPermissionDescription(String pPermission,
            String pPermissionDescription) 
            throws OpbDataAccessException;
    
    /**
     * xxx
     * explain permission loop
     * exceptions.
     * Calls the database procedure allow.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void allow(String pPermission,
            String pPermissionAllowed) 
            throws OpbDataAccessException;
    
    /**
     * Calls allow using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permission</li>
     * <li>pPermissionAllowed is mapped to permissionAllowed</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void allow() 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure deny.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deny(String pPermission,
            String pPermissionDenied) 
            throws OpbDataAccessException;
    
    /**
     * Calls deny using mapped parameters.
     * <ul>
     * <li>pPermission is mapped to permissionSet</li>
     * <li>pPermissionDenied is mapped to permission</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deny() 
            throws OpbDataAccessException;
    

}