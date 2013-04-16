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
import com.butterfill.opb.data.OpbDataObjectSource;
import com.butterfill.opb.util.OpbScalarResultCache;

/**
 * A session encapsulates access to a session in the target system and
 * provides access to session specific resources.
 *
 * @author Peter Butterfill
 */
public interface OpbSession {

    /**
     * Returns the connection provider that this session is using.
     * @return The connection provider that this session is using.
     */
    OpbConnectionProvider getOpbConnectionProvider();

    /**
     * Returns the data object source that this session is using.
     * @return The data object source that this session is using.
     */
    OpbDataObjectSource getDataObjectSource();

    /**
     * Returns the scalar result cache that this session is using.
     * @return The scalar result cache that this session is using.
     */
    OpbScalarResultCache getOpbScalarResultCache();

}
