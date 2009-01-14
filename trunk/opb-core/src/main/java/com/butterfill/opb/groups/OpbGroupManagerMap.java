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

import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Provides access to the state of an Object 'object' in any group managed by
 * an OpbGroupManager 'manager'.
 *
 * @author Peter Butterfill
 * @see #get(Object)
 * @see #put(String, Boolean)
 * @see OpbGroupManager
 */
public class OpbGroupManagerMap implements Map<String, Boolean>  {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbGroupManagerMap.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The group manager of this map.
     */
    private final OpbGroupManager manager;

    /**
     * The object of this map.
     */
    private final Object object;

    /**
     * Creates a new instance of OpbGroupManagerMap associating a 'manager'
     * with an 'object'.
     *
     * @param manager
     *   The manager to associate with the specified object.
     * @param object
     *   The object to associate with the specified manager.
     * @see OpbGroupManager#newGroupManagerMap(Object)
     */
    OpbGroupManagerMap(final OpbGroupManager manager, final Object object) {
        final String methodName = "OpbGroupManagerMap(OpbGroupManager, Object)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "manager", manager);

        this.manager = manager;
        this.object = object;

    } // End of OpbGroupManagerMap()

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbGroupManagerMap.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @return n/a
     */
    public int size() {
        throw new UnsupportedOperationException("size()");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @return n/a
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException("isEmpty()");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @param key n/a
     * @return n/a
     */
    public boolean containsKey(final Object key) {
        throw new UnsupportedOperationException("containsKey(Object)");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @param value n/a
     * @return n/a
     */
    public boolean containsValue(final Object value) {
        throw new UnsupportedOperationException("containsValue(Object)");
    }

    /**
     * Returns true if 'object' is a member of the group identified by
     * groupName, managed by 'manager'.
     *
     * @return true or false. Never null
     * @param groupName Name of the group.
     */
    public Boolean get(final Object groupName) {
        return manager.isMember("" + groupName, object);
    }

    /**
     * Adds or removes 'object' from the group identifeid by groupName, managed
     * by 'manager'.
     *
     * @param groupName Name of the group.
     * @param value
     *   Pass true to add 'object' to the group.
     *   Pass false to remove 'object' from the group.
     * @return null.
     */
    public Boolean put(final String groupName, final Boolean value) {
        final String methodName = "put(String, Boolean)";

        logger.entering(CLASS_NAME, methodName);

        if (value) {
            manager.addMember(groupName, object);

        } else {
            manager.removeMember(groupName, object);

        }

        return null;

    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @param key n/a
     * @return n/a
     */
    public Boolean remove(final Object key) {
        throw new UnsupportedOperationException("remove(Object)");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @param m n/a
     */
    public void putAll(final Map m) {
        throw new UnsupportedOperationException("putAll(Map)");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     */
    public void clear() {
        throw new UnsupportedOperationException("clear()");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @return n/a
     */
    public Set<String> keySet() {
        throw new UnsupportedOperationException("keySet()");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @return n/a
     */
    public Collection<Boolean> values() {
        throw new UnsupportedOperationException("values()");
    }

    /**
     * Throws an UnsupportedOperationException as this is not a valid 
     * opperation.
     * @return n/a
     */
    public Set<Map.Entry<String, Boolean>> entrySet() {
        throw new UnsupportedOperationException("entrySet()");
    }

} // End of class OpbGroupManagerMap
