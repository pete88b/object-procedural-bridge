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

import com.butterfill.opb.data.OpbConnectionProvider;
import com.butterfill.opb.data.OpbDataAccessException;
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.groups.OpbGroupManager;
import com.butterfill.opb.timing.OpbEventTimerProvider;
import com.butterfill.opb.util.OpbScalarResultCache;
import com.butterfill.opb.util.OpbScalarResultCacheProvider;
import java.util.Map;

/**
 * A session encapsulates access to a session in the target system and
 * provides access to session specific resources.
 *
 * @author Peter Butterfill
 */
public interface OpbSession
        extends OpbConnectionProvider, OpbEventTimerProvider,
        OpbScalarResultCacheProvider {

    /**
     * Checks current memory use and may act to reduce memory used by this session.
     */
    void checkMemoryUse();

    /**
     * Creates a session and assigns this session an ID.
     * <br/>
     * Note: This does not start an active phase.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to create the session.
     */
    void createSession() throws OpbDataAccessException;

    /**
     * End this session.
     * <br/>
     * Do not attempt data access via this session after calling this method.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to end the session.
     */
    void endSession() throws OpbDataAccessException;

    /**
     * Returns a map of attributes for this sesson.
     * @return A map of attributes for this sesson.
     */
    Map<Object, Object> getAttributes();

    /**
     * Returns the data object source that this session is using.
     * @return The data object source that this session is using.
     */
    OpbDataObjectSource getDataObjectSource();

    /**
     * Returns the group manager that this session is using.
     * @return The group manager that this session is using.
     */
    OpbGroupManager getGroupManager();

    /**
     * Returns the ID of this session.
     * <br/>
     * Note: This will be null until createSession() has been called.
     * @see #createSession()
     * @return ID of this session.
     */
    String getId();

    /**
     * Returns the scalar result cache that this session is using.
     * @return The scalar result cache that this session is using.
     */
    OpbScalarResultCache getScalarResultCache();

    /**
     * Returns the username of the user of this session.
     * @see #setUsername(String)
     * @return The username of the user of this session.
     */
    String getUsername();

    /**
     * Sets the username for this session.
     *
     * @param username
     *   The username for this session.
     * @throws OpbDataAccessException
     *   If we fail to set the username.
     * @throws NullPointerException
     *   If username is null or this session has not been started.
     */
    void setUsername(String username)
    throws OpbDataAccessException, NullPointerException;

    /**
     * Releases the connection being used by this session optionally clearing
     * any temporary data saved in the database for this session.
     * <br/>
     * <em>Do not call close() on a connection returned by a session.</em>
     *
     * @param clearTempData
     *   Pass true to clear temp data, false otherwise.
     * @throws OpbDataAccessException
     *   If we can't release the connection.
     */
    void releaseConnection(boolean clearTempData) throws OpbDataAccessException;

}
