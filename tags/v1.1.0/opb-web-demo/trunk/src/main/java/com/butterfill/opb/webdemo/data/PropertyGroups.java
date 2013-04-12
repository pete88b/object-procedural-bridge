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
 * property_groups.
 */
public interface PropertyGroups
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of groupName.
     * @return The value of groupName.
     */
    String getGroupName();
    
    /**
     * Sets the value of groupName.
     * @param a The new value for groupName.
     */
    void setGroupName(String a);
    
    /**
     * Returns the value of groupNameDataSourceValue.
     * This is the last value returned by the data source for groupName.
     * @return The value of groupNameDataSourceValue.
     */
    String getGroupNameDataSourceValue();
    
    /**
     * Returns true if the value of groupName 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if groupName has changed since it was loaded.
     */
    boolean getGroupNameChanged();
    
    /**
     * Returns the value of singleValuePerKey.
     * @return The value of singleValuePerKey.
     */
    String getSingleValuePerKey();
    
    /**
     * Sets the value of singleValuePerKey.
     * @param a The new value for singleValuePerKey.
     */
    void setSingleValuePerKey(String a);
    
    /**
     * Returns the value of singleValuePerKeyDataSourceValue.
     * This is the last value returned by the data source for singleValuePerKey.
     * @return The value of singleValuePerKeyDataSourceValue.
     */
    String getSingleValuePerKeyDataSourceValue();
    
    /**
     * Returns true if the value of singleValuePerKey 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if singleValuePerKey has changed since it was loaded.
     */
    boolean getSingleValuePerKeyChanged();
    
    /**
     * Returns the value of locked.
     * @return The value of locked.
     */
    String getLocked();
    
    /**
     * Sets the value of locked.
     * @param a The new value for locked.
     */
    void setLocked(String a);
    
    /**
     * Returns the value of lockedDataSourceValue.
     * This is the last value returned by the data source for locked.
     * @return The value of lockedDataSourceValue.
     */
    String getLockedDataSourceValue();
    
    /**
     * Returns true if the value of locked 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if locked has changed since it was loaded.
     */
    boolean getLockedChanged();
    
    /**
     * Returns the value of groupDescription.
     * @return The value of groupDescription.
     */
    String getGroupDescription();
    
    /**
     * Sets the value of groupDescription.
     * @param a The new value for groupDescription.
     */
    void setGroupDescription(String a);
    
    /**
     * Returns the value of groupDescriptionDataSourceValue.
     * This is the last value returned by the data source for groupDescription.
     * @return The value of groupDescriptionDataSourceValue.
     */
    String getGroupDescriptionDataSourceValue();
    
    /**
     * Returns true if the value of groupDescription 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if groupDescription has changed since it was loaded.
     */
    boolean getGroupDescriptionChanged();
    

    /**
     * 
     * Calls the database function get_property_groups.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<PropertyGroup> getPropertyGroups(String pGroupName,
            String pSingleValuePerKey,
            String pLocked,
            String pGroupDescription) 
            throws OpbDataAccessException; 
    
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
    java.util.List<PropertyGroup> getPropertyGroups() 
            throws OpbDataAccessException; 
    

}