package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.session.OpbSessionHelper;
import com.butterfill.opb.webdemo.data.Permission;
import com.butterfill.opb.webdemo.data.Permissions;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.myfaces.trinidad.model.ChildPropertyTreeModel;
import org.apache.myfaces.trinidad.model.TreeModel;

/**
 *
 * @author butterp
 */
public class PermissionSetsAdmin {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = PermissionSetsAdmin.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /** 
     * Creates a new instance of PermissionSetsAdmin 
     */
    public PermissionSetsAdmin() {
        logger.entering(CLASS_NAME, "PermissionSetsAdmin()");
    }
    
    /**
     * Permission name for the root node.
     */
    public static final String ROOT_NODE_NAME = "root";

    /**
     * Returns a Permissions instance.
     * @return A Permissions instance.
     */
    public Permissions getPermissions() {
        return OpbSessionHelper.getInstance(Permissions.class, CLASS_NAME);
    }

    /**
     * Returns a tree of Permissions.
     * @return A tree of Permissions.
     */
    public synchronized TreeModel getPermissionsTree() {

        if (OpbSessionHelper.getAttribute("permissionsTree") == null) {
            getPermissions().setPermission(ROOT_NODE_NAME);
            getPermissions().setPermissionSearchString("_upper_case_or_not_used_");
            OpbSessionHelper.putAttribute(
                    "permissionsTree",
                    new ChildPropertyTreeModel(
                    getPermissions(), "permissions"));
        }

        return (TreeModel) OpbSessionHelper.getAttribute("permissionsTree");

    }

    /**
     * Returns the name of the root node of the tree.
     * @return The name of the root node of the tree.
     */
    public String getRootNodeName() {
        return ROOT_NODE_NAME;
    }

    /**
     * Returns the root node of the tree.
     * @return The root node of the tree.
     */
    public Permissions getRootNode() {
        return getPermissions();
    }

    /**
     * Returns the permission that has been selected for allow.
     * The allow() method acts on the permission that has been selected for 
     * allow. 
     * @return The permission that has been selected for allow.
     */
    public Permission getPermissionSelectedForAllow() {
        return (Permission) OpbSessionHelper.getGroupManager().getMember(
                "selectedForAllow");
    }

    /**
     * Allows the permission selected for allow the permission identified by
     * the value of the allowPermission HTTP request parameter.
     * @return null
     */
    public String allow() {

        HttpServletRequest request = 
                (HttpServletRequest)FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequest();

        getPermissionSelectedForAllow().allow(
                getPermissionSelectedForAllow().getPermission(),
                request.getParameter("allowPermission"));

        return null;
    }
}
