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

package com.butterfill.opb.util;

import com.butterfill.opb.OpbException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Wraps a list to keep track of and provide access to a "working" object.
 * <p>
 * Initially the working object is the first object in the list.
 * To make the next element in the list the working object, call next().
 * To make either the first or the last element in the list the working object,
 * call first() or last() respectively.
 * </p>
 *
 * @param <T> The type of object being wrapped.
 *
 * @author Peter Butterfill
 */
public abstract class OpbWorkingObjectListWrapper<T> {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbWorkingObjectListWrapper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The position of the working object in the list.
     */
    private int workingObjectIndex;

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbWorkingObjectListWrapper.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }


    /**
     * Implement this method to return the list to be wrapped.
     * <br/>
     * The list returned by this method does not have to be the same list
     * across multiple invocations of this method.
     * <br/>
     * The list returned by this method can be modified between invocations of
     * this method.
     * <br/>
     * <br/>
     * One approach could be to create an anonymous inner class that declares a
     * list as an instance variable. In this case getList() returns the instance
     * variable. e.g.
     * <pre>
     *  OpbWorkingObjectListWrapper&gt;String> wrapper =
     *          new OpbWorkingObjectListWrapper&gt;String>() {
     *
     *      List&gt;String> list = new ArrayList&gt;String>();
     *
     *      public List&gt;String> getList() throws OpbException {
     *          return list;
     *      }
     *
     *  };
     * </pre>
     *
     * Another approach could be to create an anonymous inner class to return
     * a list retrieved from another object. e.g.
     * <pre>
     * OpbWorkingObjectListWrapper&gt;String> wrapper =
     *         new OpbWorkingObjectListWrapper&gt;String>() {
     *
     *     public List&gt;Query> getList() throws OpbException {
     *         OpbSessionHelper.getInstance(Queries.class, "demo").getQueries();
     *     }
     *
     * };
     * </pre>
     * In this example, OpbSessionHelper is used to get an instance of a Queries
     * object. The queries object can return a list of Query objects via it's
     * getQueries() method.
     *
     * @return The list to be wrapped.
     * @throws com.butterfill.opb.OpbException
     *   If we fail to return the list.
     */
    public abstract List<T> getList() throws OpbException;

    /**
     * Returns the size of the list being wrapped.
     *
     * @return The size of the list being wrapped.
     * @throws OpbException
     *   If getList() throws an OpbException.
     * @throws NullPointerException
     *   If getList() returns null.
     */
    public int getListSize() throws OpbException, NullPointerException {
        logger.entering(CLASS_NAME, "getListSize()");

        return getList().size();
    }

    /**
     * Returns the index of the working object.
     *
     * @return The index of the working object.
     */
    public int getWorkingObjectIndex() {
        logger.entering(CLASS_NAME, "getWorkingObjectIndex()");

        return workingObjectIndex;
    }

    /**
     * Returns true if the list returned by getList() is not null and has at
     * least one element.
     *
     *
     * @return true if the wrapped list is not empty.
     * @throws com.butterfill.opb.OpbException
     *   If getList() fails.
     */
    public boolean isListNotEmpty() throws OpbException {
        logger.entering(CLASS_NAME, "isListNotEmpty()");

        final List<T> list = getList();

        return list != null && list.size() > 0;
    }

    /**
     * Returns the "working" object. This is the object in the list returned by
     * getList() at the position defined by the working object index.
     * <br/>
     * If getList() returns null or a list with no elements, this method set the
     * working object index to 0 and returns null.
     * <br/>
     * If the working object index has been set to a negative number (by calling
     * previous() when the working object is 0), this method sets the working
     * object index to 0 before returning the working object.
     * <br/>
     * If the working object index has been set to a number greater than the
     * last index in the list returned by getList() (by calling next() after
     * reaching the last object), this method sets the working object index to
     * the last index available before returning the working object.
     * @throws com.butterfill.opb.OpbException If get list fails.
     * @return The "working" object.
     */
    public T getWorkingObject() throws OpbException {
        logger.entering(CLASS_NAME, "getWorkingObject()");

        final List<T> list = getList();

        if (list == null || list.isEmpty()) {
            workingObjectIndex = 0;
            return null;
        }

        if (workingObjectIndex < 0) {
            workingObjectIndex = 0;
        } else if (workingObjectIndex > (list.size() - 1)) {
            workingObjectIndex = (list.size() - 1);
        }

        return list.get(workingObjectIndex);
    }

    /**
     * Increments the working object index by 1.
     * @return null.
     */
    public String next() {
        logger.entering(CLASS_NAME, "next()");

        workingObjectIndex++;
        return null;
    }

    /**
     * Decrements the working object index by 1.
     * @return null.
     */
    public String previous() {
        logger.entering(CLASS_NAME, "previous()");

        workingObjectIndex--;
        return null;
    }

    /**
     * Sets the working object index to 0.
     * @return null.
     */
    public String first() {
        logger.entering(CLASS_NAME, "first()");

        workingObjectIndex = 0;
        return null;
    }

    /**
     * Sets the working object index to the last available index in the list
     * returned by getList().
     *
     * @throws com.butterfill.opb.OpbException
     *   If getList() fails.
     * @return null.
     */
    public String last() throws OpbException {
        logger.entering(CLASS_NAME, "last()");

        final List<T> list = getList();

        if (list == null || list.isEmpty()) {
            workingObjectIndex = 0;

        } else {
            workingObjectIndex = list.size() - 1;

        }

        return null;
    }

    /**
     * Returns true if the "working" object is the last available object in the
     * list returned by getList().
     * This will return false if getList() returns null or a list with no
     * elements.
     *
     * @throws com.butterfill.opb.OpbException
     *   If getList() fails.
     * @return
     *   true if the "working" object is the last available object in the list.
     */
    public boolean isWorkingObjectLast() throws OpbException {
        logger.entering(CLASS_NAME, "isWorkingObjectLast()");

        final List<T> list = getList();

        return list != null
                && workingObjectIndex >= (list.size() - 1)
                && list.size() > 0;
    }

    /**
     * Returns true if the "working" object is the first available object in the
     * list returned by getList().
     * This will return false if getList() returns null or a list with no
     * elements.
     *
     * @throws com.butterfill.opb.OpbException
     *   If getList() fails.
     * @return
     *   true if the "working" object is the first available object in the list.
     */
    public boolean isWorkingObjectFirst() throws OpbException {
        logger.entering(CLASS_NAME, "isWorkingObjectFirst()");

        final List<T> list = getList();

        return list != null
                && workingObjectIndex <= 0
                && list.size() > 0;
    }

} // End of class OpbWorkingObjectListWrapper
