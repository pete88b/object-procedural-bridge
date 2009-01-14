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
import java.sql.ResultSet;

/**
 * File created from the PL/SQL package specification 
 * opb_message.
 */
public interface OpbMessage
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveCacheableEntity {

    /**
     * Clears all field values of this OpbMessage.
     */
    void opbClearState();

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter section">

    /**
     * Returns the value of idDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for id.
     */
    java.math.BigDecimal getIdDataSourceValue();

    /**
     * Returns the value of id for this OpbMessage.
     */
    java.math.BigDecimal getId();

    /**
     * Sets the value of id for this OpbMessage.
     */
    public void setId(java.math.BigDecimal id);

    /**
     * Returns the value of contextNameDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for contextName.
     */
    String getContextNameDataSourceValue();

    /**
     * Returns the value of contextName for this OpbMessage.
     */
    String getContextName();

    /**
     * Sets the value of contextName for this OpbMessage.
     */
    public void setContextName(String contextName);

    /**
     * Returns the value of sessionIdDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for sessionId.
     */
    String getSessionIdDataSourceValue();

    /**
     * Returns the value of sessionId for this OpbMessage.
     */
    String getSessionId();

    /**
     * Sets the value of sessionId for this OpbMessage.
     */
    public void setSessionId(String sessionId);

    /**
     * Returns the value of messageTypeDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageType.
     */
    String getMessageTypeDataSourceValue();

    /**
     * Returns the value of messageType for this OpbMessage.
     */
    String getMessageType();

    /**
     * Sets the value of messageType for this OpbMessage.
     */
    public void setMessageType(String messageType);

    /**
     * Returns the value of messageLevelDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageLevel.
     */
    String getMessageLevelDataSourceValue();

    /**
     * Returns the value of messageLevel for this OpbMessage.
     */
    String getMessageLevel();

    /**
     * Sets the value of messageLevel for this OpbMessage.
     */
    public void setMessageLevel(String messageLevel);

    /**
     * Returns the value of messageSummaryDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageSummary.
     */
    String getMessageSummaryDataSourceValue();

    /**
     * Returns the value of messageSummary for this OpbMessage.
     */
    String getMessageSummary();

    /**
     * Sets the value of messageSummary for this OpbMessage.
     */
    public void setMessageSummary(String messageSummary);

    /**
     * Returns the value of messageDetailDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageDetail.
     */
    String getMessageDetailDataSourceValue();

    /**
     * Returns the value of messageDetail for this OpbMessage.
     */
    String getMessageDetail();

    /**
     * Sets the value of messageDetail for this OpbMessage.
     */
    public void setMessageDetail(String messageDetail);

    // </editor-fold> End of Getter and Setter Section

    // <editor-fold defaultstate="collapsed" desc="value changed getter section">

    /**
     * Returns true if the value of id for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getIdChanged();

    /**
     * Returns true if the value of contextName for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getContextNameChanged();

    /**
     * Returns true if the value of sessionId for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getSessionIdChanged();

    /**
     * Returns true if the value of messageType for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageTypeChanged();

    /**
     * Returns true if the value of messageLevel for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageLevelChanged();

    /**
     * Returns true if the value of messageSummary for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageSummaryChanged();

    /**
     * Returns true if the value of messageDetail for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageDetailChanged();

    // </editor-fold> End of value changed getter Section

    /**
     * Calls the database procedure delete_message(NUMBER).
     * Deletes a message by it's ID.
     */
    void deleteMessage(java.math.BigDecimal pId)
    throws OpbDataAccessException;

    /**
     * Calls deleteMessage(java.math.BigDecimal pId)
     * using instance values for;
     * <ul>
     *   <li>pId -> id</li>
     * </ul>
     */
    void deleteMessage()
    throws OpbDataAccessException;

} // End of interface OpbMessage
