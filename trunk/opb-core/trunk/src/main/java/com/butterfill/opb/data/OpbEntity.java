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

import java.sql.ResultSet;

/**
 * An OpbEntity is an object that can be represented by a single row in a sql
 * result set.
 *
 * @author Peter Butterfill
 */
public interface OpbEntity {

    /**
     * Loads the entity using the current row in resultSet.
     * <br/>
     * Implementations of this method must ensure that no changes are made to
     * resultSet.
     * @param resultSet
     *   The result set containing data that can be used to load this entity.
     * @throws com.butterfill.opb.data.OpbDataAccessException
     *   If we fail to load the entity.
     */
    void opbLoad(ResultSet resultSet)
    throws OpbDataAccessException;

}
