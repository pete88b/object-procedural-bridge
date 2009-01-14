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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A group that contains no more than one member at any time.
 * null will never be considered to be a member of this group.
 * <br/>
 * If an OpbGroupMemberWrapper is passed to addMember(Object), the object
 * returned by the wrapper's getValue() method is considered to be the member
 * of this group.
 * <br/>
 * If a non-OpbGroupMemberWrapper is passed to addMember(Object), the
 * object passed is considered to be the member of this group.
 * <br/>
 * If the member of this group is found to be null (by getMember(),
 * getMembers(), isMember(Object), removeMember(Object) or
 * removeMembersByClass(Class)), the member of this group will be considered to
 * be null until addMember(Object) has been called.
 *
 * @author Peter Butterfill
 */
@SuppressWarnings(value = "unchecked")
public class OpbSingleMemberGroup implements OpbGroup {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbSingleMemberGroup.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * A group member wrapper used to (sometimes) save the member of this group.
     */
    private final OpbGroupMemberWrapper reUseableMemberWrapper =
            new OpbGroupMemberWrapperImpl();

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
     * The wrapper holding the member of this group. Never let this be null.
     */
    private OpbGroupMemberWrapper memberWrapper = reUseableMemberWrapper;


    /**
     * Creates a new instance of OpbSingleMemberGroup with no group name.
     */
    public OpbSingleMemberGroup() {
        logger.entering(CLASS_NAME, "OpbSingleMemberGroup()");

        this.name = null;
    }

    /**
     * Creates a new instance of OpbSingleMemberGroup with the specified name.
     * 
     * @param groupName A name for this group.
     */
    public OpbSingleMemberGroup(final String groupName) {
        final String methodName = "OpbSingleMemberGroup(String)";

        logger.entering(CLASS_NAME, methodName);

        this.name = groupName;

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}", groupName);

    }


    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbSingleMemberGroup.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the name of this group.
     * Note: The group name is set by the constructor. If this group was
     * created using the no-args constructor the group name will be null.
     * 
     * @return The name of this group.
     */
    public String getGroupName() {
        return name;
    }

    /**
     * Used to optionally wrap o with w.
     * If o is an OpbGroupMemberWrapper, o is returned.
     * If o is not an OpbGroupMemberWrapper, w is returned with o as it's
     * member.
     * 
     * @param o The object to wrap.
     * @param w The wrapper to use if it's needed.
     * @return A wrapped object.
     */
    private OpbGroupMemberWrapper wrap(final Object o, 
            final OpbGroupMemberWrapper w) {
        final String methodName = "wrap(Object, OpbGroupMemberWrapper)";

        if (o instanceof OpbGroupMemberWrapper) {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "found wrapper");
            return (OpbGroupMemberWrapper) o;

        } else {
            logger.logp(Level.FINER, CLASS_NAME, methodName, "wrapping object");
            w.setValue(o);
            return w;

        }

    } // End of wrap(Object)

    /**
     * Sets the member of this group.
     * <br/>
     * If object is an OpbGroupMemberWrapper, it is saved as is.
     * If object is not an OpbGroupMemberWrapper, object is wrapped in an
     * OpbGroupMemberWrapper and the wrapper is saved.
     * 
     * @param object The object to add to this group.
     */
    public void addMember(final Object object) {
        final String methodName = "addMember(Object)";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}, object={1}", new Object[] {name, object});

        memberWrapper = wrap(object, reUseableMemberWrapper);

    } // End of addMember(Object)

    /**
     * Removes the specified object from this group.
     * <br/>
     * If object is an OpbGroupMemberWrapper, the object returned by the
     * wrapper's getValue() method is removed from this group.
     * <br/>
     * After calling this method, object will not be a member of this group.
     * If object is not a member of this group, this is a no-op.
     * <br/>
     * This method calls removeAllMembers() to remove the member of this group.
     * 
     * @param object The object to remove from this group.
     */
    public void removeMember(final Object object) {
        final String methodName = "removeMember(Object)";

        logger.entering(CLASS_NAME, methodName);

        Object member = memberWrapper.getValue();

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}, object={1}, member={2}",
                new Object[] {name, object, member});

        if (member == null ||
                member == wrap(object, reUseableArgWrapper).getValue()) {
            removeAllMembers();
            logger.logp(Level.FINER, CLASS_NAME, methodName, "member removed");

        }

    } // End of removeMember(Object)

    /**
     * Removes the member of this group.
     */
    public void removeAllMembers() {
        final String methodName = "removeAllMembers()";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}", name);

        reUseableMemberWrapper.setValue(null);
        memberWrapper = reUseableMemberWrapper;

    }

    /**
     * Removes the member of this group if it's class is the same as
     * classOfobject.
     * This method calls removeAllMembers() to remove the member of this group.
     * If classOfObject is null, this is a no-op.
     * 
     * @param classOfObject The type of object to remove from this group.
     */
    public void removeMembersByClass(final Class classOfObject) {
        final String methodName = "removeMembersByClass(Class)";

        logger.entering(CLASS_NAME, methodName);

        Object member = memberWrapper.getValue();

        if (logger.isLoggable(Level.FINEST)) {
            String classOfObjectName =
                    (classOfObject == null) ? "null" : classOfObject.getName();

            logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "groupName={0}, classOfObject={1}, member={2}",
                    new Object[] {name, classOfObjectName, member});

        } // End of if (logger.isLoggable(Level.FINEST))

        if (member == null ||
                member.getClass() == classOfObject) {
            removeAllMembers();
            logger.logp(Level.FINER, CLASS_NAME, methodName, "member removed");

        }

    } // End of removeMembersByClass(Class)

    /**
     * Returns true if object is a member of this group, false otherwise.
     * If object is an OpbGroupMemberWrapper, return true if the object returned
     * by the wrapper's getValue() method is a member of this group.
     * 
     * @param object An object that may be a member of this group.
     * @return true if object is a member of this group.
     */
    public boolean isMember(final Object object) {
        final String methodName = "isMember(Object object)";

        logger.entering(CLASS_NAME, methodName);

        Object member = memberWrapper.getValue();

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}, object={1}, member={2}",
                new Object[] {name, object, member});

        if (member == null) {
            removeAllMembers();
            return false;
        }

        return member == wrap(object, reUseableArgWrapper).getValue();

    }

    /**
     * Returns the member of this group.
     * <br/>
     * If no member has been added to this group, this method will return null.
     * <br/>
     * If an OpbGroupMemberWrapper was passed to addMember(Object), the object
     * returned by the wrapper's getValue() method is returned.
     * <br/>
     * If a non-OpbGroupMemberWrapper was passed to addMember(Object), the
     * object passed to addMember(Object) is returned.
     * <br/>
     * If this method returns null, it will return null until addMember(Object)
     * has been called.
     * 
     * @return The member of this group.
     */
    public Object getMember() {
        final String methodName = "getMember()";

        logger.entering(CLASS_NAME, methodName);

        Object member = memberWrapper.getValue();

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}, member={1}",
                new Object[] {name, member});

        if (member == null) {
            removeAllMembers();
        }

        return member;

    }

    /**
     * Returns an unmodifiable list containing the member of this group.
     * <br/>
     * The list returned will contain no elements if no members have been
     * added to this group.
     * <br/>
     * If an OpbGroupMemberWrapper was passed to addMember(Object), the list
     * will contain the object returned by the wrapper's getValue() method.
     * <br/>
     * If a non-OpbGroupMemberWrapper was passed to addMember(Object), the list
     * will contain the object passed to addMember(Object).
     * <br/>
     * If this method returns an empty list, it will return an empty list until
     * addMember(Object) has been called.
     * 
     * @return The member of this group.
     */
    public List<Object> getMembers() {
        final String methodName = "getMembers()";

        logger.entering(CLASS_NAME, methodName);

        List<Object> result = new ArrayList<Object>();

        Object member = memberWrapper.getValue();

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "groupName={0}, member={1}",
                new Object[] {name, member});

        if (member == null) {
            removeAllMembers();

        } else {
            result.add(member);

        }

        return Collections.unmodifiableList(result);

    }

} // End of class OpbSingleMemberGroup
