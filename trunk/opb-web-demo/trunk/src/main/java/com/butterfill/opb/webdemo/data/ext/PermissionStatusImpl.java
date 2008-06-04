
package com.butterfill.opb.webdemo.data.ext;

import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.data.OpbSqlHelper;
import com.butterfill.opb.groups.OpbGroupManagerMap;
import com.butterfill.opb.timing.OpbEventTimerProvider;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;

/**
 * PermissionStatus implementation that can be used as a JSF select item.
 * <br/>
 * This class demostrates the ext mechanism. 
 * i.e. This class will be used in preference to the Opb generated 
 * com.butterfill.opb.webdemo.data PermissionStatusImpl.
 * 
 * @author butterp
 */
public class PermissionStatusImpl extends SelectItem 
        implements com.butterfill.opb.webdemo.data.PermissionStatus {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            PermissionStatusImpl.class.getName();
            
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of PermissionStatusImpl.
     */
    public PermissionStatusImpl() {
        logger.entering(CLASS_NAME, "PermissionStatusImpl()");
    }

    /**
     * Returns a String representation of this PermissionStatusImpl
     * and it's values.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this PermissionStatusImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this PermissionStatusImpl.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this PermissionStatusImpl.
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
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * Resets the value and label of this select item to null.
     */
    public void opbClearState() {
        final String methodName = "opbClearState()";

        logger.entering(CLASS_NAME, methodName);

        // set all fields to their initial values
        super.setValue(null);
        
        super.setLabel(null);

    } // End of opbClearState()

    private Long value;
    
    private String label;

    /**
     * Resets the value and label of this select item to null by calling 
     * opbClearState() and then sets these properties using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>value is <em>mandatory</em></li>
     * <li>label is <em>mandatory</em></li>
     * </ul>
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
            // set the value from column value
            setValue(OpbSqlHelper.getValue(value, resultSet, "value", true));
            
            // set the label from column label
            setLabel(OpbSqlHelper.getValue(label, resultSet, "label", true));
            

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            logger.exiting(CLASS_NAME, methodName);

        }

    } // End of opbLoad(ResultSet resultSet)

    /**
     * Returns the value of this select item.
     * This method is required to implement the PermissionStatus interface.
     * @return The value of this select item.
     */
    @Override
    public Long getValue() {
        return (Long)super.getValue();
    }

}
