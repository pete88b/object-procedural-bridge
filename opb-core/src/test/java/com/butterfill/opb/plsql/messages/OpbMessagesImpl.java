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

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * opb_messages.
 */
public class OpbMessagesImpl implements OpbMessages {
    private static final Logger logger = Logger.getLogger(
            OpbMessagesImpl.class.getName());

    public static final String CLASS_NAME = "OpbMessagesImpl";
    
    /**
     * Creates a new instance of OpbMessagesImpl.
     */
    public OpbMessagesImpl() {
        logger.entering(CLASS_NAME, "OpbMessagesImpl()");
    }

    /**
     * Returns a String representation of this OpbMessagesImpl
     * and it's values.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this OpbMessagesImpl.
     */
    private OpbGroupManagerMap _opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this OpbMessagesImpl.
     */
    public void setGroupManagerMap(OpbGroupManagerMap map) {
        _opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this OpbMessagesImpl.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return _opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this OpbMessagesImpl.
     */
    private OpbEventTimerProvider _opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this OpbMessagesImpl.
     */
    public void setOpbEventTimerProvider(OpbEventTimerProvider provider) {
        this._opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this OpbMessagesImpl.
     */
    private OpbDataObjectSource _opbDataObjectSource;

    /**
     * Sets the data object source to be used by this OpbMessagesImpl.
     */
    public void setOpbDataObjectSource(OpbDataObjectSource source) {
        this._opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this OpbMessagesImpl.
     */
    private OpbConnectionProvider _opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this OpbMessagesImpl.
     */
    public void setOpbConnectionProvider(OpbConnectionProvider provider) {
        this._opbConnectionProvider = provider;
    }

    
    /**
     * Resets all field values to their initial values.
     */
    public void opbClearState() {
        final String _method = "opbClearState()";

        logger.entering(CLASS_NAME, _method);

        // set all fields to their initial values
        contextName = null;
        contextNameDataSourceValue = null;
        
        messageType = null;
        messageTypeDataSourceValue = null;
        
        messageLevel = null;
        messageLevelDataSourceValue = null;
        
        messageSummary = null;
        messageSummaryDataSourceValue = null;
        
        messageDetail = null;
        messageDetailDataSourceValue = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling 
     * opbClearState() and then sets all field values using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>context_name is <em>mandatory</em></li>
     * <li>message_type is <em>mandatory</em></li>
     * <li>message_level is <em>mandatory</em></li>
     * <li>message_summary is <em>mandatory</em></li>
     * <li>message_detail is <em>mandatory</em></li>
     * </ul>
     */
    public void opbLoad(java.sql.ResultSet resultSet) 
            throws OpbDataAccessException {
        final String _method = "opbLoad(ResultSet)";

        logger.entering(CLASS_NAME, _method);

        // Clear all field values
        opbClearState();

        // Make sure resultSet is not null
        OpbAssert.notNull(logger, CLASS_NAME, _method, "resultSet", resultSet);

        // Get field values from resultSet
        try {
            // load contextName from column context_name
            contextName = OpbSqlHelper.getValue(
                    contextName, resultSet, 
                    "context_name", true);
            // save the value we just loaded as the datasource value
            contextNameDataSourceValue = contextName;
            
            // load messageType from column message_type
            messageType = OpbSqlHelper.getValue(
                    messageType, resultSet, 
                    "message_type", true);
            // save the value we just loaded as the datasource value
            messageTypeDataSourceValue = messageType;
            
            // load messageLevel from column message_level
            messageLevel = OpbSqlHelper.getValue(
                    messageLevel, resultSet, 
                    "message_level", true);
            // save the value we just loaded as the datasource value
            messageLevelDataSourceValue = messageLevel;
            
            // load messageSummary from column message_summary
            messageSummary = OpbSqlHelper.getValue(
                    messageSummary, resultSet, 
                    "message_summary", true);
            // save the value we just loaded as the datasource value
            messageSummaryDataSourceValue = messageSummary;
            
            // load messageDetail from column message_detail
            messageDetail = OpbSqlHelper.getValue(
                    messageDetail, resultSet, 
                    "message_detail", true);
            // save the value we just loaded as the datasource value
            messageDetailDataSourceValue = messageDetail;
            

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, _method);

        } finally {
            logger.exiting(CLASS_NAME, _method);

        }

    } // End of opbLoad(ResultSet resultSet)


    /**
     * Derived from an opb-package field.
     */
    private String contextName = null;
    
    /**
     * Returns the value of contextName.
     */
    public String getContextName() {
        return contextName;
    }
    
    /**
     * Sets the value of contextName.
     */
    public void setContextName(String a) {
        this.contextName = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String contextNameDataSourceValue = null;
    
    /**
     * Returns the value of contextNameDataSourceValue.
     * This is the last value returned by the data source for contextName.
     */
    public String getContextNameDataSourceValue() {
        return contextNameDataSourceValue;
    }
    
    /**
     * Returns true if the value of contextName 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getContextNameChanged() {
        return !OpbComparisonHelper.isEqual(
                    contextName, contextNameDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String messageType = null;
    
    /**
     * Returns the value of messageType.
     */
    public String getMessageType() {
        return messageType;
    }
    
    /**
     * Sets the value of messageType.
     */
    public void setMessageType(String a) {
        this.messageType = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String messageTypeDataSourceValue = null;
    
    /**
     * Returns the value of messageTypeDataSourceValue.
     * This is the last value returned by the data source for messageType.
     */
    public String getMessageTypeDataSourceValue() {
        return messageTypeDataSourceValue;
    }
    
    /**
     * Returns true if the value of messageType 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageTypeChanged() {
        return !OpbComparisonHelper.isEqual(
                    messageType, messageTypeDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String messageLevel = null;
    
    /**
     * Returns the value of messageLevel.
     */
    public String getMessageLevel() {
        return messageLevel;
    }
    
    /**
     * Sets the value of messageLevel.
     */
    public void setMessageLevel(String a) {
        this.messageLevel = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String messageLevelDataSourceValue = null;
    
    /**
     * Returns the value of messageLevelDataSourceValue.
     * This is the last value returned by the data source for messageLevel.
     */
    public String getMessageLevelDataSourceValue() {
        return messageLevelDataSourceValue;
    }
    
    /**
     * Returns true if the value of messageLevel 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageLevelChanged() {
        return !OpbComparisonHelper.isEqual(
                    messageLevel, messageLevelDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String messageSummary = null;
    
    /**
     * Returns the value of messageSummary.
     */
    public String getMessageSummary() {
        return messageSummary;
    }
    
    /**
     * Sets the value of messageSummary.
     */
    public void setMessageSummary(String a) {
        this.messageSummary = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String messageSummaryDataSourceValue = null;
    
    /**
     * Returns the value of messageSummaryDataSourceValue.
     * This is the last value returned by the data source for messageSummary.
     */
    public String getMessageSummaryDataSourceValue() {
        return messageSummaryDataSourceValue;
    }
    
    /**
     * Returns true if the value of messageSummary 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageSummaryChanged() {
        return !OpbComparisonHelper.isEqual(
                    messageSummary, messageSummaryDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String messageDetail = null;
    
    /**
     * Returns the value of messageDetail.
     */
    public String getMessageDetail() {
        return messageDetail;
    }
    
    /**
     * Sets the value of messageDetail.
     */
    public void setMessageDetail(String a) {
        this.messageDetail = a;
    }
    
    /**
     * Derived from a read-write opb-package field.
     */
    private String messageDetailDataSourceValue = null;
    
    /**
     * Returns the value of messageDetailDataSourceValue.
     * This is the last value returned by the data source for messageDetail.
     */
    public String getMessageDetailDataSourceValue() {
        return messageDetailDataSourceValue;
    }
    
    /**
     * Returns true if the value of messageDetail 
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageDetailChanged() {
        return !OpbComparisonHelper.isEqual(
                    messageDetail, messageDetailDataSourceValue);
    }


    /**
     * Returns all valid message types.
     * Calls the database function get_message_types.
     */
    public java.util.List<OpbDynamicDataView> 
            getMessageTypes() 
            throws OpbDataAccessException {
        final String _method = "getMessageTypes()";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "DataObjectSource", _opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "opb_messages.getMessageTypes");
    
        java.util.List<OpbDynamicDataView> result = 
                _opbDataObjectSource.getCachedResult(
                OpbDynamicDataView.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, _method,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL ? := opb_messages.get_message_types() }",
                "DbCall:opb_messages#get_message_types()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = _opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
        return result;
    
    }
    
    /**
     * Returns all valid message levels.
     * Calls the database function get_message_levels.
     */
    public java.util.List<OpbDynamicDataView> 
            getMessageLevels() 
            throws OpbDataAccessException {
        final String _method = "getMessageLevels()";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "DataObjectSource", _opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "opb_messages.getMessageLevels");
    
        java.util.List<OpbDynamicDataView> result = 
                _opbDataObjectSource.getCachedResult(
                OpbDynamicDataView.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, _method,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL ? := opb_messages.get_message_levels() }",
                "DbCall:opb_messages#get_message_levels()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = _opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
        return result;
    
    }
    
    /**
     * Returns all messages for the current session.
     * Calls the database function get_session_messages.
     */
    public java.util.List<OpbMessage> 
            getSessionMessages() 
            throws OpbDataAccessException {
        final String _method = "getSessionMessages()";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "DataObjectSource", _opbDataObjectSource);
    
        java.util.List<OpbMessage> result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL ? := opb_messages.get_session_messages() }",
                "DbCall:opb_messages#get_session_messages()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = _opbDataObjectSource.getResult(
                OpbMessage.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
        return result;
    
    }
    
    /**
     * Returns messages for the specified context (using the LIKE condition).
     * Calls the database function get_context_messages.
     */
    public java.util.List<OpbMessage> 
            getContextMessages(String pContextName) 
            throws OpbDataAccessException {
        final String _method = "getContextMessages(String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "DataObjectSource", _opbDataObjectSource);
    
        java.util.List<OpbMessage> result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL ? := opb_messages.get_context_messages(?) }",
                "DbCall:opb_messages#get_context_messages(VARCHAR2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pContextName);
        
    
        opbCallHelper.execute();
    
        result = _opbDataObjectSource.getResult(
                OpbMessage.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
        return result;
    
    }
    
    /**
     * Calls getContextMessages using mapped parameters.
     * <ul>
     * <li>pContextName is mapped to contextName</li>
     * </ul>
     */
    public java.util.List<OpbMessage>
            getContextMessages() 
            throws OpbDataAccessException {
        final String _method = "getContextMessages()";
    
        logger.entering(CLASS_NAME, _method);
    
        java.util.List<OpbMessage> result = getContextMessages(getContextName());
    
    
        return result;
    }
    
    /**
     * Returns messages that apply to all contexts.
     * Calls the database function get_all_context_messages.
     */
    public java.util.List<OpbMessage> 
            getAllContextMessages() 
            throws OpbDataAccessException {
        final String _method = "getAllContextMessages()";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, _method, 
                "DataObjectSource", _opbDataObjectSource);
    
        java.util.List<OpbMessage> result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL ? := opb_messages.get_all_context_messages() }",
                "DbCall:opb_messages#get_all_context_messages()");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.execute();
    
        result = _opbDataObjectSource.getResult(
                OpbMessage.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
        return result;
    
    }
    

    /**
     * Adds a message to the message set for this session by calling
     * add_session_message.
     * Calls the database procedure add_message.
     */
    public void addMessage(String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException {
        final String _method = "addMessage(String, String, String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.add_message(?, ?, ?) }",
                "DbCall:opb_messages#add_message(VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pLevel);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pSummary);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDetail);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    
    /**
     * Adds a message to the message set for this session.
     * Calls the database procedure add_session_message.
     */
    public void addSessionMessage(String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException {
        final String _method = "addSessionMessage(String, String, String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.add_session_message(?, ?, ?) }",
                "DbCall:opb_messages#add_session_message(VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pLevel);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pSummary);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDetail);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    
    /**
     * Calls addSessionMessage using mapped parameters.
     * <ul>
     * <li>pLevel is mapped to messageLevel</li>
     * <li>pSummary is mapped to messageSummary</li>
     * <li>pDetail is mapped to messageDetail</li>
     * </ul>
     */
    public void addSessionMessage() 
            throws OpbDataAccessException {
        final String _method = "addSessionMessage()";
    
        logger.entering(CLASS_NAME, _method);
    
        addSessionMessage(getMessageLevel(),
                getMessageSummary(),
                getMessageDetail());
    
    }
    
    /**
     * Adds a message to the specified context.
     * Calls the database procedure add_context_message.
     */
    public void addContextMessage(String pContextName,
            String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException {
        final String _method = "addContextMessage(String, String, String, String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.add_context_message(?, ?, ?, ?) }",
                "DbCall:opb_messages#add_context_message(VARCHAR2, VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pContextName);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pLevel);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pSummary);
        
        opbCallHelper.setObject(
                4, java.sql.Types.VARCHAR, pDetail);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    
    /**
     * Calls addContextMessage using mapped parameters.
     * <ul>
     * <li>pContextName is mapped to contextName</li>
     * <li>pLevel is mapped to messageLevel</li>
     * <li>pSummary is mapped to messageSummary</li>
     * <li>pDetail is mapped to messageDetail</li>
     * </ul>
     */
    public void addContextMessage() 
            throws OpbDataAccessException {
        final String _method = "addContextMessage()";
    
        logger.entering(CLASS_NAME, _method);
    
        addContextMessage(getContextName(),
                getMessageLevel(),
                getMessageSummary(),
                getMessageDetail());
    
    }
    
    /**
     * Adds an all context message.
     * Calls the database procedure add_all_context_message.
     */
    public void addAllContextMessage(String pLevel,
            String pSummary,
            String pDetail) 
            throws OpbDataAccessException {
        final String _method = "addAllContextMessage(String, String, String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.add_all_context_message(?, ?, ?) }",
                "DbCall:opb_messages#add_all_context_message(VARCHAR2, VARCHAR2, VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pLevel);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pSummary);
        
        opbCallHelper.setObject(
                3, java.sql.Types.VARCHAR, pDetail);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    
    /**
     * Calls addAllContextMessage using mapped parameters.
     * <ul>
     * <li>pLevel is mapped to messageLevel</li>
     * <li>pSummary is mapped to messageSummary</li>
     * <li>pDetail is mapped to messageDetail</li>
     * </ul>
     */
    public void addAllContextMessage() 
            throws OpbDataAccessException {
        final String _method = "addAllContextMessage()";
    
        logger.entering(CLASS_NAME, _method);
    
        addAllContextMessage(getMessageLevel(),
                getMessageSummary(),
                getMessageDetail());
    
    }
    
    /**
     * Clears all messages for the specified session.
     * Calls the database procedure clear_session_messages.
     */
    public void clearSessionMessages(String pSessionId) 
            throws OpbDataAccessException {
        final String _method = "clearSessionMessages(String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.clear_session_messages(?) }",
                "DbCall:opb_messages#clear_session_messages(VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pSessionId);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    
    /**
     * Clears all messages for the specified context.
     * Calls the database procedure clear_messages_for_context.
     */
    public void clearMessagesForContext(String pContextName) 
            throws OpbDataAccessException {
        final String _method = "clearMessagesForContext(String)";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.clear_messages_for_context(?) }",
                "DbCall:opb_messages#clear_messages_for_context(VARCHAR2)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.VARCHAR, pContextName);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    
    /**
     * Calls clearMessagesForContext using mapped parameters.
     * <ul>
     * <li>pContextName is mapped to contextName</li>
     * </ul>
     */
    public void clearMessagesForContext() 
            throws OpbDataAccessException {
        final String _method = "clearMessagesForContext()";
    
        logger.entering(CLASS_NAME, _method);
    
        clearMessagesForContext(getContextName());
    
    }
    
    /**
     * Clears all message data.
     * Calls the database procedure clear_all_messages.
     */
    public void clearAllMessages() 
            throws OpbDataAccessException {
        final String _method = "clearAllMessages()";
    
        logger.entering(CLASS_NAME, _method);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbEventTimerProvider,
                _opbConnectionProvider,
                "{ CALL opb_messages.clear_all_messages() }",
                "DbCall:opb_messages#clear_all_messages()");
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, _method);
    
    }
    

}
