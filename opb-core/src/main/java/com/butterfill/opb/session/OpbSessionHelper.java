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

package com.butterfill.opb.session;

import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.List;
import java.util.logging.Logger;

/**
 * Provides access to a thread local OpbSession and shortcuts to some of the
 * most common session related tasks.
 * <br/>
 * The setSession method must be called before trying to use other methods of
 * this class.
 * <br/>
 * It is expected that in a web application, a servlet filter will be used to
 * set the session on receiving a request and clear it out when the reponse is
 * complete.
 * <br/>
 * This implementation uses java.lang.ThreadLocal.
 *
 * @see java.lang.ThreadLocal
 *
 * @author Peter Butterfill
 */
public class OpbSessionHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbSessionHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The thread local used to store the session.
     */
    private static ThreadLocal<OpbSession> threadLocal =
            new ThreadLocal<OpbSession>();

    /**
     * Creates a new instance of OpbSessionHelper.
     */
    public OpbSessionHelper() {
        logger.entering("OpbSessionHelper", "OpbSessionHelper()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this OpbSessionHelper and it's values.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the session associated with this thread.
     * 
     * @return The session associated with this thread.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     */
    public static OpbSession getSession() throws NullPointerException {
        final String methodName = "getSession()";

        logger.entering(CLASS_NAME, methodName);

        OpbSession session = threadLocal.get();

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "OpbSession", session,
                "The session has not been set for this thread");

        return session;
    }

    /**
     * Associates a session with this thread.
     * 
     * @param opbSession
     *   The session to associate with this thread.
     */
    public static void setSession(final OpbSession opbSession) {
        final String methodName = "setSession(OpbSession)";

        logger.entering(CLASS_NAME, methodName);

        threadLocal.set(opbSession);
    }

    /**
     * Returns a session attribute for the specified key.
     * 
     * @param key The key to the attribute.
     * @return The session attribute for the specified key.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     */
    public static Object getAttribute(final Object key) 
            throws NullPointerException {
        final String methodName = "getAttribute(Object)";

        logger.entering(CLASS_NAME, methodName);

        return getSession().getAttributes().get(key);
    }

    /**
     * Sets a session attribute for the specified key.
     * 
     * @param key The key to the attribute.
     * @param value The session attribute to set.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     */
    public static void putAttribute(final Object key, final Object value) 
            throws NullPointerException {
        final String methodName = "putAttribute(Object, Object)";

        logger.entering(CLASS_NAME, methodName);

        getSession().getAttributes().put(key, value);
    }

    /**
     * Clears the state of the session (without ending it).
     * 
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     */
    public static void clearSessionState() throws NullPointerException {
        final String methodName = "clearSessionState()";

        logger.entering(CLASS_NAME, methodName);

        OpbSession session = getSession();

        session.getDataObjectSource().clearCached();
        session.getDataObjectSource().clearInstances();
        session.getGroupManager().removeAllGroups();
        session.getScalarResultCache().clearCached();
        session.getAttributes().clear();
    }

    /**
     * Ends the session.
     * <br/>
     * If the opb session was associated with an http session, it is expected
     * that the opb session should be removed from the http session after
     * calling this method.
     * <br/>
     * It is expected that it will be more common to re-create a session than
     * it is to end a session.
     *
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see #reCreateSession()
     */
    public static void endSession() throws NullPointerException {
        final String methodName = "endSession()";

        logger.entering(CLASS_NAME, methodName);

        getSession().endSession();
    }

    /**
     * Re-creates the session.
     * <br/>
     * After calling this method the session will behave like a new session.
     * <br/>
     * This implementation will end the session, clear it's state and then
     * call createSession on the session - i.e. The session instance is re-used.
     * 
     * @throws NullPointerException
     *   If no session is associated with this thread.
     */
    public static void reCreateSession() throws NullPointerException {
        endSession();
        clearSessionState();
        getSession().createSession();
    }

    /**
     * Returns the data object source of the session.
     * 
     * @return The data object source of the session.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbSession#getDataObjectSource()
     */
    public static OpbDataObjectSource getDataObjectSource() 
            throws NullPointerException {
        final String methodName = "getDataObjectSource()";

        logger.entering(CLASS_NAME, methodName);

        return getSession().getDataObjectSource();
    }

    /**
     * Returns an instance created by the data object source of the session.
     * 
     * @param <T>
     *   The type of object to return.
     * @param classOfObject
     *   The type of object to return.
     * @param key
     *   The key to returning the same instance over multiple calls to this 
     *   method.
     * @return 
     *   An instance created by the data object source of the session.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbDataObjectSource#getInstance(Class, String)
     */
    public static <T extends Object> T getInstance(final Class<T> classOfObject,
            final String key) 
            throws NullPointerException {
        final String methodName = "getInstance(Class<T>, String)";

        logger.entering(CLASS_NAME, methodName);

        return getDataObjectSource().getInstance(classOfObject, key);
    }

    /**
     * Returns an instance created by the data object source of the session.
     * 
     * @param <T>
     *   The type of object to return.
     * @param  classOfObject
     *   The type of object to return.
     * @return 
     *   An instance created by the data object source of the session.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbDataObjectSource#newInstance(Class)
     */
    public static <T extends Object> T newInstance(
            final Class<T> classOfObject) 
            throws NullPointerException {
        final String methodName = "newInstance(Class<T>)";

        logger.entering(CLASS_NAME, methodName);

        return getDataObjectSource().newInstance(classOfObject);
    }

    /**
     * Returns the group manager of the session.
     * 
     * @return The group manager of the session.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbSession#getGroupManager()
     */
    public static OpbGroupManager getGroupManager() 
            throws NullPointerException {
        final String methodName = "getGroupManager()";

        logger.entering(CLASS_NAME, methodName);

        return getSession().getGroupManager();
    }

    /**
     * Returns the member of the specified group for the current session.
     * 
     * @param groupName
     *   Name of the single member group.
     * @return 
     *   The member of the specified group for the current session.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbSession#getGroupManager()
     * @see OpbGroupManager#getMember(String)
     */
    public static Object getMember(final String groupName) 
            throws NullPointerException {
        final String methodName = "getMember(String)";

        logger.entering(CLASS_NAME, methodName);

        return getSession().getGroupManager().getMember(groupName);
    }

    /**
     * Returns the members of the specified group for the current session.
     * 
     * @param groupName
     *   Name of the group.
     * @return 
     *   The members of the specified group for the current session.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbSession#getGroupManager()
     * @see OpbGroupManager#getMembers(String)
     */
    public static List<Object> getMembers(final String groupName) 
            throws NullPointerException {
        final String methodName = "getMembers(String)";

        logger.entering(CLASS_NAME, methodName);

        return getSession().getGroupManager().getMembers(groupName);
    }

    /**
     * Removes the members of the specified group for the current session.
     * 
     * @param groupName
     *   Name of the group.
     * @throws NullPointerException
     *   If no session is associated with this thread.
     * @see #setSession(OpbSession)
     * @see OpbSession#getGroupManager()
     * @see OpbGroupManager#removeAllMembers(String)
     */
    public static void removeAllMembers(final String groupName) 
            throws NullPointerException {
        final String methodName = "removeAllMembers(String)";

        logger.entering(CLASS_NAME, methodName);

        getSession().getGroupManager().removeAllMembers(groupName);
    }

} // End of class OpbSessionHelper
