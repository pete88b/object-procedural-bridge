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

package com.butterfill.opb.plsql.messages;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * opb_message.
 */
public interface OpbMessage
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of id.
     * @return The value of id.
     */
    java.math.BigDecimal getId();
    
    /**
     * Returns the value of contextName.
     * @return The value of contextName.
     */
    String getContextName();
    
    /**
     * Returns the value of sessionId.
     * @return The value of sessionId.
     */
    String getSessionId();
    
    /**
     * Returns the value of messageType.
     * @return The value of messageType.
     */
    String getMessageType();
    
    /**
     * Returns the value of messageLevel.
     * @return The value of messageLevel.
     */
    String getMessageLevel();
    
    /**
     * Returns the value of messageSummary.
     * @return The value of messageSummary.
     */
    String getMessageSummary();
    
    /**
     * Returns the value of messageDetail.
     * @return The value of messageDetail.
     */
    String getMessageDetail();
    

    /**
     * Deletes a message by it's ID.
     * Calls the database procedure delete_message.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deleteMessage(java.math.BigDecimal pId) 
            throws OpbDataAccessException;
    
    /**
     * Calls deleteMessage using mapped parameters.
     * <ul>
     * <li>pId is mapped to id</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void deleteMessage() 
            throws OpbDataAccessException;
    

}