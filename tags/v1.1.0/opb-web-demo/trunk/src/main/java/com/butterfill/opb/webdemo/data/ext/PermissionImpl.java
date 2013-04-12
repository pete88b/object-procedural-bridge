
package com.butterfill.opb.webdemo.data.ext;

import java.util.logging.Logger;


/**
 * File created from the PL/SQL package specification
 * permission.
 */
public class PermissionImpl extends com.butterfill.opb.webdemo.data.PermissionImpl {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PermissionImpl.class.getName();
            
    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Sets the value of description calling updatePermission() if the new
     * description is different to the old description.
     */
//    @Override
    public void setPermissionDescription(final String a) {
//        if (super.getOpbId() != null &&
//                !OpbComparisonHelper.isEqual(a, getDescription())) {
//            super.setPermissionDescription(a);
//            super.updatePermission();
//        }
    }
    
    /**
     * Sets the value of status calling updatePermission() if the new
     * status is different to the old status.
     */
//    @Override
    public void setPermissionStatus(Long a) {
//        if (super.getOpbId() != null &&
//                !OpbComparisonHelper.isEqual(a, getDescription())) {
//            super.setStatus(a);
//            super.updatePermission();
//        }
    }
    
}