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
 * property_value.
 */
public interface PropertyValue
        extends OpbGroupable, OpbTimingEventPublisher, 
        OpbActiveCacheableEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of rowId.
     * @return The value of rowId.
     */
    String getRowId();
    
    /**
     * Returns the value of valueContainsCr.
     * @return The value of valueContainsCr.
     */
    Boolean getValueContainsCr();
    
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
     * Returns the value of key.
     * @return The value of key.
     */
    String getKey();
    
    /**
     * Sets the value of key.
     * @param a The new value for key.
     */
    void setKey(String a);
    
    /**
     * Returns the value of keyDataSourceValue.
     * This is the last value returned by the data source for key.
     * @return The value of keyDataSourceValue.
     */
    String getKeyDataSourceValue();
    
    /**
     * Returns true if the value of key 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if key has changed since it was loaded.
     */
    boolean getKeyChanged();
    
    /**
     * Returns the value of propertyDescription.
     * @return The value of propertyDescription.
     */
    String getPropertyDescription();
    
    /**
     * Sets the value of propertyDescription.
     * @param a The new value for propertyDescription.
     */
    void setPropertyDescription(String a);
    
    /**
     * Returns the value of propertyDescriptionDataSourceValue.
     * This is the last value returned by the data source for propertyDescription.
     * @return The value of propertyDescriptionDataSourceValue.
     */
    String getPropertyDescriptionDataSourceValue();
    
    /**
     * Returns true if the value of propertyDescription 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if propertyDescription has changed since it was loaded.
     */
    boolean getPropertyDescriptionChanged();
    
    /**
     * Returns the value of sortOrder.
     * @return The value of sortOrder.
     */
    String getSortOrder();
    
    /**
     * Sets the value of sortOrder.
     * @param a The new value for sortOrder.
     */
    void setSortOrder(String a);
    
    /**
     * Returns the value of sortOrderDataSourceValue.
     * This is the last value returned by the data source for sortOrder.
     * @return The value of sortOrderDataSourceValue.
     */
    String getSortOrderDataSourceValue();
    
    /**
     * Returns true if the value of sortOrder 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if sortOrder has changed since it was loaded.
     */
    boolean getSortOrderChanged();
    
    /**
     * Returns the value of value.
     * @return The value of value.
     */
    String getValue();
    
    /**
     * Sets the value of value.
     * @param a The new value for value.
     */
    void setValue(String a);
    
    /**
     * Returns the value of valueDataSourceValue.
     * This is the last value returned by the data source for value.
     * @return The value of valueDataSourceValue.
     */
    String getValueDataSourceValue();
    
    /**
     * Returns true if the value of value 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if value has changed since it was loaded.
     */
    boolean getValueChanged();
    

    /**
     * 
     * Calls the database function del.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String del(String pRowId,
            String pOldGroupName,
            String pOldKey,
            String pOldPropertyDescription,
            String pOldSortOrder,
            String pOldValue) 
            throws OpbDataAccessException; 
    
    /**
     * Calls del using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pOldGroupName is mapped to groupNameDataSourceValue</li>
     * <li>pOldKey is mapped to keyDataSourceValue</li>
     * <li>pOldPropertyDescription is mapped to propertyDescriptionDataSourceValue</li>
     * <li>pOldSortOrder is mapped to sortOrderDataSourceValue</li>
     * <li>pOldValue is mapped to valueDataSourceValue</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String del() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function ins.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String ins(String pGroupName,
            String pKey,
            String pPropertyDescription,
            String pSortOrder,
            String pValue) 
            throws OpbDataAccessException; 
    
    /**
     * Calls ins using mapped parameters.
     * <ul>
     * <li>pGroupName is mapped to groupName</li>
     * <li>pKey is mapped to key</li>
     * <li>pPropertyDescription is mapped to propertyDescription</li>
     * <li>pSortOrder is mapped to sortOrder</li>
     * <li>pValue is mapped to value</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String ins() 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function upd.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String upd(String pRowId,
            String pOldGroupName,
            String pOldKey,
            String pKey,
            String pOldPropertyDescription,
            String pPropertyDescription,
            String pOldSortOrder,
            String pSortOrder,
            String pOldValue,
            String pValue) 
            throws OpbDataAccessException; 
    
    /**
     * Calls upd using mapped parameters.
     * <ul>
     * <li>pRowId is mapped to rowId</li>
     * <li>pOldGroupName is mapped to groupNameDataSourceValue</li>
     * <li>pOldKey is mapped to keyDataSourceValue</li>
     * <li>pKey is mapped to key</li>
     * <li>pOldPropertyDescription is mapped to propertyDescriptionDataSourceValue</li>
     * <li>pPropertyDescription is mapped to propertyDescription</li>
     * <li>pOldSortOrder is mapped to sortOrderDataSourceValue</li>
     * <li>pSortOrder is mapped to sortOrder</li>
     * <li>pOldValue is mapped to valueDataSourceValue</li>
     * <li>pValue is mapped to value</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    String upd() 
            throws OpbDataAccessException; 
    

}