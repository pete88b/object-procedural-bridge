/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.butterfill.opb.groups;

import com.butterfill.opb.util.OpbExceptionHelper;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Provides access to a set of groups.
 * <br/>
 * Group manager provides access to two kinds of groups;
 * <ul>
 *   <li>Single member groups that contain no more than one member</li>
 *   <li>Many member groups that can contain any number of members</li>
 * </ul>
 * Groups are accessed via group names.
 * <br/>
 * If you access a group with a name that starts with "multiple" (case
 * sensitive), you will be using a many member group.
 * <br/>
 * If you access a group with a name that starts with anything other than
 * "multiple" (case sensitive), you will be using a single member group.
 *
 * @author Peter Butterfill
 */
public class OpbGroupManager {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbGroupManager.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * All groups being managed, keyed by group name.
     */
    private Map<String, OpbGroup> groupMap = new HashMap<String, OpbGroup>();


    /**
     * Creates a new instance of OpbGroupManager.
     */
    public OpbGroupManager() {
        logger.entering(CLASS_NAME, "OpbGroupManager()");

    } // End of OpbGroupManager()

    /**
     * Returns a String representation of this OpbGroupManager and it's values.
     * @return String representation of this OpbGroupManager.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }


    /**
     * Returns a new OpbGroupManagerMap associating this group manager with
     * the specified object.
     * @see OpbGroupManagerMap
     * @param object The object to map to this group manager.
     * @return A new OpbGroupManagerMap.
     */
    public OpbGroupManagerMap newGroupManagerMap(final Object object) {
        logger.entering(CLASS_NAME, "newGroupManagerMap(Object)");

        return new OpbGroupManagerMap(this, object);
    }

    /**
     * Return the group that is mapped to the specified name. If no group is
     * mapped to the specified name, this method will create a group and add
     * if to the group map.
     *
     * If the specified name starts with multiple (case sensitive) a group that
     * will allow multiple members will be created, otherwise a single member
     * group will be created.
     *
     * @param groupName The name of the group.
     * @return The group that is mapped to the specified name.
     */
    private synchronized OpbGroup getGroup(final String groupName) {
        logger.entering(CLASS_NAME, "getGroup(String)");

        if (!groupMap.containsKey(groupName)) {
            OpbGroup newGroup = null;
            if (groupName != null && groupName.startsWith("multiple")) {
                // if the specified name starts with multiple,
                // create a group that will allow multiple members
                newGroup = new OpbManyMembersGroup(groupName);
            } else {
                // otherwise, create a single member group
                newGroup = new OpbSingleMemberGroup(groupName);
            }
            // add the group to the group map
            groupMap.put(groupName, newGroup);

        } // End of if (!_groupMap.containsKey(groupName))

        // return the group mapped to the specified name
        return groupMap.get(groupName);
    }

    /**
     * Adds a member to the specified group.
     * @param groupName Name of the group to which object should be added.
     * @param object The object to add to the group.
     */
    public void addMember(final String groupName, final Object object) {
        logger.entering(CLASS_NAME, "addMember(String, Object)");

        getGroup(groupName).addMember(object);
    }

    /**
     * Removes a member from the specified group.
     * @param groupName Name of the group from which object should be removed.
     * @param object The object to remove.
     */
    public void removeMember(final String groupName, final Object object) {
        logger.entering(CLASS_NAME, "removeMember(String, Object)");

        getGroup(groupName).removeMember(object);
    }

    /**
     * Removes the specified member from all groups.
     * @param object The object to be removed.
     */
    public void removeMember(final Object object) {
        logger.entering(CLASS_NAME, "removeMember(Object)");

        for (OpbGroup group : groupMap.values()) {
            group.removeMember(object);
        }
    }

    /**
     * Removes all members from the specified group.
     * @param groupName
     *   The name of the group from which all groups should be removed.
     */
    public void removeAllMembers(final String groupName) {
        logger.entering(CLASS_NAME, "removeAllMembers(String");

        groupMap.remove(groupName);
    }

    /**
     * Removes all members from the specified group that are of the specified
     * class.
     * @param groupName
     *   Name of the group from which object should be removed.
     * @param classOfObject
     *   The type of object to remove from the specified group.
     */
    public void removeMembersByClass(final String groupName,
            final Class classOfObject) {
        logger.entering(CLASS_NAME, "removeMembersByClass(String, Class)");

        getGroup(groupName).removeMembersByClass(classOfObject);
    }

    /**
     * Removes all members that are of the specified class from all groups.
     * @param classOfObject The type of object to remove.
     */
    public void removeMembersByClass(final Class classOfObject) {
        logger.entering(CLASS_NAME, "removeMembersByClass(Class)");

        for (OpbGroup group : groupMap.values()) {
            group.removeMembersByClass(classOfObject);
        }
    }

    /**
     * Removes all groups. After calling this method, no objects will be
     * members of ant groups.
     */
    public void removeAllGroups() {
        logger.entering(CLASS_NAME, "removeAllGroups()");

        groupMap.clear();
    }

    /**
     * Returns true if object is a member of the specified group,
     * false otherwise.
     * @param groupName Name of the group of which object may be a member.
     * @param object An object that may be a member of the specified group.
     * @return true if object is a member of the specified group.
     */
    public boolean isMember(final String groupName, final Object object) {
        logger.entering(CLASS_NAME, "isMember(String, Object)");

        return getGroup(groupName).isMember(object);
    }

    /**
     * Returns the member of the spcified group if the spcified group is a
     * single member group.
     *
     * @param groupName Name of the single member group.
     * @return The member of the spcified group.
     * @throws UnsupportedOperationException
     *   If the specified group is not a single member group.
     */
    public Object getMember(final String groupName)
            throws UnsupportedOperationException {
        final String methodName = "getMember(String)";

        logger.entering(CLASS_NAME, methodName);

        OpbGroup group = getGroup(groupName);

        if (group instanceof OpbSingleMemberGroup) {
            return ((OpbSingleMemberGroup) group).getMember();
        }

        throw OpbExceptionHelper.throwException(
                new UnsupportedOperationException(
                "getMember is only valid for OpbSingleMemberGroup. found " +
                group.getClass().getName()),
                logger, CLASS_NAME, methodName);

    } // End of getMember(String)

    /**
     * Returns a read-only list of the members of the specified group.
     * @param groupName Name of the group.
     * @return All members of the specified group.
     */
    public List<Object> getMembers(final String groupName) {
        logger.entering(CLASS_NAME, "getMembers(String)");

        return getGroup(groupName).getMembers();

    } // End of getMembers(String)

} // End of class OpbGroupManager

