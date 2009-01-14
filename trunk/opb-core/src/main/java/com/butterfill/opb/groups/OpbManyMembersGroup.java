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

import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbExactMatchList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A group that can contain any number of objects.
 * null will never be considered to be a member of this group.
 * <br/>
 * If an OpbGroupMemberWrapper is passed to addMember(Object), the object
 * returned by the wrapper's getValue() method is considered to be a member
 * of this group.
 * <br/>
 * If a non-OpbGroupMemberWrapper is passed to addMember(Object), the
 * object passed is considered to be a member of this group.
 * <br/>
 * This group will never consider null to be a member.
 * <br/>
 * If a wrapper added to this group returns null, it will be removed from
 * the group.
 *
 * @author Peter Butterfill
 */
@SuppressWarnings(value = "unchecked")
public class OpbManyMembersGroup implements OpbGroup {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbManyMembersGroup.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * A group member wrapper used to wrap method arguments.
     */
    private final OpbGroupMemberWrapper reUseableArgWrapper =
            new OpbGroupMemberWrapperImpl();

    /**
     * Name of this group.
     */
    private final String name;

    /**
     * Collection of wrappers holding the objects that belong to this group.
     */
    private final List<OpbGroupMemberWrapper> memberWrappers =
            new OpbExactMatchList<OpbGroupMemberWrapper>();

    /**
     * Collection of objects that belong to this group.
     */
    private final List<Object> members = new OpbExactMatchList<Object>();


    /**
     * Creates a new instance of OpbManyMembersGroup with no group name.
     */
    public OpbManyMembersGroup() {
        logger.entering(CLASS_NAME, "OpbManyMembersGroup()");

        this.name = null;
    }

    /**
     * Creates a new instance of OpbManyMembersGroup with the specified name.
     * @param groupName A name for this group.
     */
    public OpbManyMembersGroup(final String groupName) {
        logger.entering(CLASS_NAME, "OpbManyMembersGroup(String)");

        this.name = groupName;
    }


    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbManyMembersGroup.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the name of this group.
     * Note: The group name is set by the constructor. If this group was
     * created using the no-args constructor the group name will be null.
     * @return The name of this group.
     */
    public String getGroupName() {
        return name;
    }

    /**
     * Refreshes the memberWrappers and members lists.
     * <br/>
     * If any wrapper returns a null member, the wrapper and the member will
     * be removed from their lists.
     */
    private void refreshMembers() {
        final String methodName  = "refreshMembers()";

        logger.entering(CLASS_NAME, methodName);

        // Note: call size on the list for every itteration as it may change
        for (int i = 0; i < memberWrappers.size(); i++) {
            Object member = memberWrappers.get(i).getValue();
            if (member == null) {
                memberWrappers.remove(i);
                members.remove(i);
                // the element that was at index i+1 will now be at i.
                i--;

            } else {
                members.set(i, member);

            }

        }

    }

    /**
     * Used to optionally wrap o with reUseableArgWrapper.
     * If o is an OpbGroupMemberWrapper, o is returned.
     * If o is not an OpbGroupMemberWrapper, reUseableArgWrapper is returned
     * with o as it's wrapped value.
     * 
     * @param o The object to wrap.
     * @return A wrapped object.
     */
    private OpbGroupMemberWrapper wrapArg(final Object o) {
        final String methodName = "wrapArg(Object)";

        if (o instanceof OpbGroupMemberWrapper) {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "found wrapper");
            return (OpbGroupMemberWrapper) o;

        } else {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "wrapping object");
            reUseableArgWrapper.setValue(o);
            return reUseableArgWrapper;

        }

    }

    /**
     * Adds an object to this group.
     * <br/>
     * If object is already a member of this group, this is a no-op.
     * If object is null, this is a no-op.
     * 
     * @param object The object to add to this group.
     */
    public void addMember(final Object object) {
        final String methodName = "addMember(Object)";

        logger.entering(CLASS_NAME, methodName);

        refreshMembers();

        OpbGroupMemberWrapper wrapper;

        if (object instanceof OpbGroupMemberWrapper) {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "found wrapper");
            wrapper = (OpbGroupMemberWrapper) object;

        } else {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "wrapping object");
            wrapper = new OpbGroupMemberWrapperImpl(object);

        }

        Object member = wrapper.getValue();

        if (member != null &&
                !members.contains(member)) {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "adding member");
            // add the object if it's not a member already and it's not null
            memberWrappers.add(wrapper);
            members.add(member);

        }

    } // End of addMember(Object)

    /**
     * Removes the specified object from this group.
     * <br/>
     * If object is an OpbGroupMemberWrapper, the object returned by the
     * wrapper's getValue() method is removed from this group.
     * <br/>
     * After calling this method, object will not be a member of this group.
     * <br/>
     * If object is not a member of this group, this is a no-op.
     * @param object The object to be removed from this group.
     */
    public void removeMember(final Object object) {
        logger.entering(CLASS_NAME, "removeMember(Object)");

        refreshMembers();

        int memberIdx = members.indexOf(wrapArg(object).getValue());

        if (memberIdx != -1) {
            members.remove(memberIdx);
            memberWrappers.remove(memberIdx);

        }

    }

    /**
     * Removes all members of this group.
     */
    public void removeAllMembers() {
        logger.entering(CLASS_NAME, "removeAllMembers()");

        memberWrappers.clear();
        members.clear();

    }

    /**
     * Removes all members of this group who's class is the same as
     * classOfobject.
     * If classOfObject is null, this is a no-op.
     * @param classOfObject The type of object to be removed.
     */
    public void removeMembersByClass(final Class classOfObject) {
        logger.entering(CLASS_NAME, "removeMembersByClass(Class)");

        refreshMembers();

        // Note: call size on the list for every itteration as it may change
        for (int i = 0; i < memberWrappers.size(); i++) {
            Object member = memberWrappers.get(i).getValue();

            if (member == null ||
                    member.getClass().equals(classOfObject)) {
                memberWrappers.remove(i);
                members.remove(i);

            }

        }

    } // End of removeMembersByClass(Class

    /**
     * Returns true if object is a member of this group, false otherwise.
     * @param object An object that may be a member of this group.
     * @return true if object is a member of this group.
     */
    public boolean isMember(final Object object) {
        logger.entering(CLASS_NAME, "isMember(Object)");

        refreshMembers();

        return members.contains(wrapArg(object).getValue());
    }

    /**
     * Returns a read-only list containing all members of this group.
     * @return All members of this group.
     */
    public List<Object> getMembers() {
        final String methodName = "getMembers()";

        logger.entering(CLASS_NAME, methodName);

        refreshMembers();

        logger.logp(Level.FINER, CLASS_NAME, methodName,
                "returning {0} members", members.size());

        return Collections.unmodifiableList(members);

    }

} // End of class OpbManyMembersGroup
