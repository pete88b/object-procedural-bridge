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

package com.butterfill.opb.data;

import java.sql.Connection;

/**
 * Provides a SQL connection and a way to close the connection.
 * @author Peter Butterfill
 */
public interface OpbConnectionProvider {

    /**
     * Returns a SQL connection.
     * <br/>
     * <em>Do not call close() on a connection returned by a connection provider.</em>
     *
     * @see #releaseConnection(boolean)
     * @throws OpbDataAccessException If we fail to get a connection.
     * @return A connection.
     */
    Connection getConnection() throws OpbDataAccessException;

    /**
     * Releases the connection being used by this session optionally clearing
     * any temporary data saved by this session.
     * <br/>
     * <em>Do not call close() on a connection returned by a session.</em>
     */
    void releaseConnection();

}
