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
 * permission_status.
 */
public class PermissionStatusImpl implements PermissionStatus {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PermissionStatusImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of PermissionStatusImpl.
     */
    public PermissionStatusImpl() {
        logger.entering(CLASS_NAME, "PermissionStatusImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this PermissionStatusImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this PermissionStatusImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this PermissionStatusImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this PermissionStatusImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this PermissionStatusImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this PermissionStatusImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this PermissionStatusImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this PermissionStatusImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this PermissionStatusImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this PermissionStatusImpl.
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
        value = null;
        
        label = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling 
     * opbClearState() and then sets all field values using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>value is <em>mandatory</em></li>
     * <li>label is <em>mandatory</em></li>
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
            // load value from column value
            value = OpbSqlHelper.getValue(
                    value, resultSet, 
                    "value", true);
            
            // load label from column label
            label = OpbSqlHelper.getValue(
                    label, resultSet, 
                    "label", true);
            

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
    private Long value = null;
    
    /**
     * Returns the value of value.
     * @return The value of value.
     */
    public Long getValue() {
        return value;
    }
    
    /**
     * Sets the value of value.
     * @param a The new value for value.
     */
    private void setValue(final Long a) {
        this.value = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String label = null;
    
    /**
     * Returns the value of label.
     * @return The value of label.
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * Sets the value of label.
     * @param a The new value for label.
     */
    private void setLabel(final String a) {
        this.label = a;
    }
    

}