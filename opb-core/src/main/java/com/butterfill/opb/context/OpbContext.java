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

package com.butterfill.opb.context;

import com.butterfill.opb.data.OpbDataAccessException;

/**
 * Encapsulates access to a context in the target system.
 * <br/>
 * It is expected, but not mandatory, that all Opb sessions will be associated
 * with a context.
 *
 * @author Peter Butterfill
 */
public interface OpbContext {

    /**
     * Returns the name of this context.
     * @return The name of this context.
     */
    String getContextName();

    /**
     * Start this context.
     *
     * @param stopContextFirst
     *   Pass true to stop this context if it has not yet been stopped.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to start this context.
     */
    void startContext(boolean stopContextFirst) throws OpbDataAccessException;

    /**
     * Stop this context.
     *
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to stop this context.
     */
    void stopContext() throws OpbDataAccessException;

} // End of OpbContext
