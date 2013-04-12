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

import java.util.List;

/**
 * A group of objects.
 *
 * @author Peter Butterfill
 */
public interface OpbGroup {

    /**
     * Adds an object to this group.
     * @param object The object to add to this group.
     */
    void addMember(Object object);

    /**
     * Returns the name of this group.
     * @return The name of this group.
     */
    String getGroupName();

    /**
     * Returns a list containing all members of this group.
     * @return All members of this group.
     */
    List<Object> getMembers();

    /**
     * Returns true if object is a member of this group, false otherwise.
     * @param object An object that may be a member of this group.
     * @return true if object is a member of this group.
     */
    boolean isMember(Object object);

    /**
     * Removes all members of this group.
     */
    void removeAllMembers();

    /**
     * Removes the specified object from this group.
     * After calling this method, object will not be a member of this group.
     * @param object The object to remove from this group.
     */
    void removeMember(Object object);

    /**
     * Removes all members of this group who's class is the same as
     * classOfobject.
     * @param classOfObject The type of object to remove from this group.
     */
    void removeMembersByClass(Class classOfObject);

}
