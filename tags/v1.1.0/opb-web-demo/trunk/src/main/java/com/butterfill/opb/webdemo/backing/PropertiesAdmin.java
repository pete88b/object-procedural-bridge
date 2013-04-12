
package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.session.OpbSessionHelper;
import com.butterfill.opb.util.OpbComparisonHelper;
import com.butterfill.opb.webdemo.data.PropertyGroup;
import com.butterfill.opb.webdemo.data.PropertyGroups;
import com.butterfill.opb.webdemo.data.PropertyValue;
import java.util.logging.Logger;

/**
 * Backing beans for the properties admin page.
 * This bean can be configured as an application scoped bean as it has no state.
 */
public class PropertiesAdmin {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PropertiesAdmin.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /** 
     * Creates a new instance of PropertiesAdmin.
     */
    public PropertiesAdmin() {
        logger.entering(CLASS_NAME, "PropertiesAdmin()");
    }
    
    /**
     * Returns the PropertyGroups for the current session.
     * @return The PropertyGroups for the current session.
     */
    public PropertyGroups getPropertyGroups() {
        return OpbSessionHelper.getInstance(PropertyGroups.class, CLASS_NAME);
    }

    /**
     * Returns the selected property group for the current session.
     * @return The selected property group for the current session.
     */
    public PropertyGroup getSelectedPropertyGroup() {
        return (PropertyGroup) OpbSessionHelper.getGroupManager().getMember(
                "singleSelectedPropertyGroup");
    }

    /**
     * Returns true if the property group selected for the current session is single, 
     * false otherwise.
     * @return true if the property group selected for the current session is single.
     */
    public boolean getSelectedPropertyGroupIsSingle() {
        return "Y".equals(getSelectedPropertyGroup().getSingleValuePerKey());
    }

    /**
     * Returns a new property group for the current session. 
     * This is a property group that has not loaded from the database.
     * @return A new property group for the current session.
     */
    public PropertyGroup getNewPropertyGroup() {
        return OpbSessionHelper.getInstance(PropertyGroup.class, CLASS_NAME);
    }

    /**
     * Returns a new property group (as returned by getNewPropertyGroup()) as an array.
     * @return A new property group as an array.
     * @see #getNewPropertyGroup() 
     */
    public PropertyGroup[] getNewPropertyGroupAsArray() {
        return new PropertyGroup[]{getNewPropertyGroup()};
    }

    /**
     * Creates a new property group and sets it as the selected group for the current session. 
     * i.e. Calls ins() on the group returned by getNewPropertyGroup.
     * @return The result returned by PropertyGroup#ins().
     * @see PropertyGroup#ins() 
     * @see #getNewPropertyGroup() 
     */
    public String createNewGroup() {
        final String methodName = "createNewGroup()";
        
        logger.entering(CLASS_NAME, methodName);
        
        // create the new group (saving the return value to be returned)
        String result = getNewPropertyGroup().ins();
        
        // get the name of the new group
        String newGroupName = getNewPropertyGroup().getGroupName();
        
        // look through all groups for the one we just created and set it as the selected group
        for (PropertyGroup group : getPropertyGroups().getPropertyGroups()) {
            if (OpbComparisonHelper.isEqual(group.getGroupName(), newGroupName)) {
                OpbSessionHelper.getGroupManager().addMember(
                        "singleSelectedPropertyGroup", group);
                break;
            }
        }
        
        return result;
        
    } // End of createNewGroup()
    
    /**
     * Returns a new property for the current session having set it's group to the
     * selected group of this session. 
     * This is a property that has not loaded from the database.
     * @return A new property.
     */
    public PropertyValue getNewProperty() {
        PropertyValue p = OpbSessionHelper.getInstance(
                PropertyValue.class, CLASS_NAME);
        p.setGroupName(getSelectedPropertyGroup().getGroupName());
        return p;
    }

    /**
     * Returns a new property (as returned by getNewProperty()) as an array.
     * @return A new property as an array.
     * @see #getNewProperty() 
     */
    public PropertyValue[] getNewPropertyAsArray() {
        return new PropertyValue[]{getNewProperty()};
    }

    /**
     * Returns the selected property for the current session.
     * @return The selected property for the current session.
     */
    public PropertyValue getSelectedProperty() {
        return (PropertyValue) OpbSessionHelper.getGroupManager().getMember(
                "singleSelectedProperty");
    }

    /**
     * Returns a text description of the selected property.
     * @return A text description of the selected property.
     */
    public String getTextForSelectedProperty() {
        PropertyValue p = getSelectedProperty();
        if (p == null) {
            return "No Property Selected";

        } else {
            StringBuilder sb = new StringBuilder("Edit value of property <b>");
            sb.append((p.getKey() == null) ? "" : p.getKey());
            sb.append("</b> for group <b>");
            sb.append(p.getGroupName());
            sb.append("</b>");
            return sb.toString();
        }
    }
    
}
