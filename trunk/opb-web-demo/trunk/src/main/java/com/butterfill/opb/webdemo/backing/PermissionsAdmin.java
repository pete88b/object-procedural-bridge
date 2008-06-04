
package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.session.OpbSessionHelper;
import com.butterfill.opb.webdemo.data.Permission;
import com.butterfill.opb.webdemo.data.Permissions;
import java.util.logging.Logger;

/**
 *
 * @author butterp
 */

public class PermissionsAdmin {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PermissionsAdmin.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /** 
     * Creates a new instance of PermissionsAdmin
     */
    public PermissionsAdmin() {
        logger.entering(CLASS_NAME, "PermissionsAdmin()");
    }

    public Permissions getPermissions() {
        return OpbSessionHelper.getInstance(Permissions.class, CLASS_NAME);
    }
    
    public Permission getNewPermission() {
        return OpbSessionHelper.getInstance(Permission.class, CLASS_NAME);
    }
    
}
