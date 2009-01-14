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
 * opb_messages.
 */
public interface OpbMessages
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbEntity {

    /**
     * Type used to indicate a message applies to a single session.
     */
    String MESSAGE_TYPE_SESSION = "SESSION";
    
    /**
     * Type used to indicate a message applies to a single context.
     */
    String MESSAGE_TYPE_CONTEXT = "CONTEXT";
    
    /**
     * Type used to indicate a message applies to all contexts.
     */
    String MESSAGE_TYPE_ALL_CONTEXTS = "ALL_CONTEXTS";
    
    /**
     * Level used to indicate that a message contains debug information.
     */
    String MESSAGE_LEVEL_DEBUG = "DEBUG";
    
    /**
     * Level used to indicate that a message contains error information.
     */
    String MESSAGE_LEVEL_ERROR = "ERROR";
    
    /**
     * Level used to indicate that a message contains fatal error information.
     */
    String MESSAGE_LEVEL_FATAL = "FATAL";
    
    /**
     * Level used to indicate that a message contains some information.
     */
    String MESSAGE_LEVEL_INFO = "INFO";
    
    /**
     * Level used to indicate that a message contains warning information.
     */
    String MESSAGE_LEVEL_WARNING = "WARN";
    

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of contextName
     */
    String getContextName();
    
    /**
     * Sets the value of contextName.
     */
    void setContextName(String a);
    
    /**
     * Returns the value of contextNameDataSourceValue.
     * This is the last value returned by the data source for contextName.
     */
    String getContextNameDataSourceValue();
    
    /**
     * Returns true if the value of contextName 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getContextNameChanged();
    
    /**
     * Returns the value of messageType
     */
    String getMessageType();
    
    /**
     * Sets the value of messageType.
     */
    void setMessageType(String a);
    
    /**
     * Returns the value of messageTypeDataSourceValue.
     * This is the last value returned by the data source for messageType.
     */
    String getMessageTypeDataSourceValue();
    
    /**
     * Returns true if the value of messageType 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageTypeChanged();
    
    /**
     * Returns the value of messageLevel
     */
    String getMessageLevel();
    
    /**
     * Sets the value of messageLevel.
     */
    void setMessageLevel(String a);
    
    /**
     * Returns the value of messageLevelDataSourceValue.
     * This is the last value returned by the data source for messageLevel.
     */
    String getMessageLevelDataSourceValue();
    
    /**
     * Returns true if the value of messageLevel 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageLevelChanged();
    
    /**
     * Returns the value of messageSummary
     */
    String getMessageSummary();
    
    /**
     * Sets the value of messageSummary.
     */
    void setMessageSummary(String a);
    
    /**
     * Returns the value of messageSummaryDataSourceValue.
     * This is the last value returned by the data source for messageSummary.
     */
    String getMessageSummaryDataSourceValue();
    
    /**
     * Returns true if the value of messageSummary 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageSummaryChanged();
    
    /**
     * Returns the value of messageDetail
     */
    String getMessageDetail();
    
    /**
     * Sets the value of messageDetail.
     */
    void setMessageDetail(String a);
    
    /**
     * Returns the value of messageDetailDataSourceValue.
     * This is the last value returned by the data source for messageDetail.
     */
    String getMessageDetailDataSourceValue();
    
    /**
     * Returns true if the value of messageDetail 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    boolean getMessageDetailChanged();
    

    /**
     * Returns all valid message types.
     * Calls the database function get_message_types.
     */
    java.util.List<OpbDynamicDataView> getMessageTypes() 
            throws OpbDataAccessException; 
    
    /**
     * Returns all valid message levels.
     * Calls the database function get_message_levels.
     */
    java.util.List<OpbDynamicDataView> getMessageLevels() 
            throws OpbDataAccessException; 
    
    /**
     * Returns all messages for the current session.
     * Calls the database function get_session_messages.
     */
    java.util.List<OpbMessage> getSessionMessages() 
            throws OpbDataAccessException; 
    
    /**
     * Returns messages for the specified context (using the LIKE condition).
     * Calls the database function get_context_messages.
     */
    java.util.List<OpbMessage> getContextMessages(String pContextName) 
            throws OpbDataAccessException; 
    
    /**
     * Calls getContextMessages using mapped parameters.
     * <ul>
     * <li>pContextName is mapped to contextName</li>
     * </ul>
     */
    java.util.List<OpbMessage> getContextMessages() 
            throws OpbDataAccessException; 
    
    /**
     * Returns messages that apply to all contexts.
     * Calls the database function get_all_context_messages.
     */
    java.util.List<OpbMessage> getAllContextMessages() 
            throws OpbDataAccessException; 
    

    /**
     * Adds a message to the message set for this session by calling
     * add_session_message.
     * Calls the database procedure add_message.
     */
    void addMessage(String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException;
    
    /**
     * Adds a message to the message set for this session.
     * Calls the database procedure add_session_message.
     */
    void addSessionMessage(String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException;
    
    /**
     * Calls addSessionMessage using mapped parameters.
     * <ul>
     * <li>pLevel is mapped to messageLevel</li>
     * <li>pSummary is mapped to messageSummary</li>
     * <li>pDetail is mapped to messageDetail</li>
     * </ul>
     */
    void addSessionMessage() 
            throws OpbDataAccessException;
    
    /**
     * Adds a message to the specified context.
     * Calls the database procedure add_context_message.
     */
    void addContextMessage(String pContextName,
            String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException;
    
    /**
     * Calls addContextMessage using mapped parameters.
     * <ul>
     * <li>pContextName is mapped to contextName</li>
     * <li>pLevel is mapped to messageLevel</li>
     * <li>pSummary is mapped to messageSummary</li>
     * <li>pDetail is mapped to messageDetail</li>
     * </ul>
     */
    void addContextMessage() 
            throws OpbDataAccessException;
    
    /**
     * Adds an all context message.
     * Calls the database procedure add_all_context_message.
     */
    void addAllContextMessage(String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException;
    
    /**
     * Calls addAllContextMessage using mapped parameters.
     * <ul>
     * <li>pLevel is mapped to messageLevel</li>
     * <li>pSummary is mapped to messageSummary</li>
     * <li>pDetail is mapped to messageDetail</li>
     * </ul>
     */
    void addAllContextMessage() 
            throws OpbDataAccessException;
    
    /**
     * Clears all messages for the specified session.
     * Calls the database procedure clear_session_messages.
     */
    void clearSessionMessages(String pSessionId) 
            throws OpbDataAccessException;
    
    /**
     * Clears all messages for the specified context.
     * Calls the database procedure clear_messages_for_context.
     */
    void clearMessagesForContext(String pContextName) 
            throws OpbDataAccessException;
    
    /**
     * Calls clearMessagesForContext using mapped parameters.
     * <ul>
     * <li>pContextName is mapped to contextName</li>
     * </ul>
     */
    void clearMessagesForContext() 
            throws OpbDataAccessException;
    
    /**
     * Clears all message data.
     * Calls the database procedure clear_all_messages.
     */
    void clearAllMessages() 
            throws OpbDataAccessException;
    

}
