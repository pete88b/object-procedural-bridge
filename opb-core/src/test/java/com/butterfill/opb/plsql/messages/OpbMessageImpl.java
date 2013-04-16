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
import com.butterfill.opb.util.*;
import java.util.logging.Logger;
import java.sql.ResultSet;
import com.butterfill.opb.plsql.util.OpbPlsqlCallHelper;

/**
 * File created from the PL/SQL package specification
 * opb_message.
 */
public class OpbMessageImpl implements OpbMessage {
    private static final Logger logger = Logger.getLogger(
            "com.butterfill.opb.plsql.messages.OpbMessage");

    /**
     * The simple name of this class
     */
    public static final String CLASS_NAME = "OpbMessageImpl";

    // <editor-fold defaultstate="collapsed" desc="Fields section">

    /**
     * The id of this OpbMessage. Set by opbLoad(ResultSet).
     */
    private OpbId _opbId;

    /**
     * Derived from the opb-package field id.
     */
    private java.math.BigDecimal id;
    /**
     * Derived from the opb-package field context_name.
     */
    private String contextName;
    /**
     * Derived from the opb-package field session_id.
     */
    private String sessionId;
    /**
     * Derived from the opb-package field message_type.
     */
    private String messageType;
    /**
     * Derived from the opb-package field message_level.
     */
    private String messageLevel;
    /**
     * Derived from the opb-package field message_summary.
     */
    private String messageSummary;
    /**
     * Derived from the opb-package field message_detail.
     */
    private String messageDetail;

    // </editor-fold> End of Fields Section

    // <editor-fold defaultstate="collapsed" desc="Fields to hold data source values section">

    /**
     * Holds the last value of id loaded from the data source. Set by opbLoad(ResultSet).
     */
    private java.math.BigDecimal idDataSourceValue;
    /**
     * Holds the last value of context_name loaded from the data source. Set by opbLoad(ResultSet).
     */
    private String contextNameDataSourceValue;
    /**
     * Holds the last value of session_id loaded from the data source. Set by opbLoad(ResultSet).
     */
    private String sessionIdDataSourceValue;
    /**
     * Holds the last value of message_type loaded from the data source. Set by opbLoad(ResultSet).
     */
    private String messageTypeDataSourceValue;
    /**
     * Holds the last value of message_level loaded from the data source. Set by opbLoad(ResultSet).
     */
    private String messageLevelDataSourceValue;
    /**
     * Holds the last value of message_summary loaded from the data source. Set by opbLoad(ResultSet).
     */
    private String messageSummaryDataSourceValue;
    /**
     * Holds the last value of message_detail loaded from the data source. Set by opbLoad(ResultSet).
     */
    private String messageDetailDataSourceValue;

    // </editor-fold> End of Fields to hold data source values section

    /**
     * Creates a new instance of OpbMessageImpl.
     */
    public OpbMessageImpl() {
        logger.entering(CLASS_NAME, "OpbMessage()");
    }

    /**
     * Returns a String representation of this OpbMessage and it's values.
     */
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    // <editor-fold defaultstate="collapsed" desc="data object source section">

    /**
     * The data object source to be used by this OpbMessage.
     */
    private OpbDataObjectSource _opbDataObjectSource;

    /**
     * Sets the data object source to be used by this OpbMessage.
     */
    public void setOpbDataObjectSource(OpbDataObjectSource source) {
        this._opbDataObjectSource = source;
    }

    // </editor-fold> End of data object source Section

    // <editor-fold defaultstate="collapsed" desc="connection provider section">

    /**
     * The connection provider to be used by this OpbMessage.
     */
    private OpbConnectionProvider _opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this OpbMessage.
     */
    public void setOpbConnectionProvider(OpbConnectionProvider provider) {
        this._opbConnectionProvider = provider;
    }

    // </editor-fold> End of connection provider Section


    /**
     * Clears all field values of this OpbMessage.
     */
    public void opbClearState() {
        final String _method = "opbClearState()";

        logger.entering(CLASS_NAME, _method);

        // set the id to null
        _opbId = null;

        // set all fields to null
        id = null;
        idDataSourceValue = null;
        contextName = null;
        contextNameDataSourceValue = null;
        sessionId = null;
        sessionIdDataSourceValue = null;
        messageType = null;
        messageTypeDataSourceValue = null;
        messageLevel = null;
        messageLevelDataSourceValue = null;
        messageSummary = null;
        messageSummaryDataSourceValue = null;
        messageDetail = null;
        messageDetailDataSourceValue = null;

    }

    /**
     * Clears all field values of this OpbMessage.
     * Sets all field values of this OpbMessage
     * using values taken from the current row in resultSet.
     * <br/>
     * The following fields must be present in resultSet;
     * <ul>
     *   <li> id </li>
     *   <li> context_name </li>
     *   <li> session_id </li>
     *   <li> message_type </li>
     *   <li> message_level </li>
     *   <li> message_summary </li>
     *   <li> message_detail </li>
     * </ul>
     */
    public void opbLoad(ResultSet resultSet)
    throws OpbDataAccessException {
        final String _method = "opbLoad(ResultSet)";

        logger.entering(CLASS_NAME, _method);

        // Clear all field values
        opbClearState();

        // Make sure resultSet is not null
        OpbAssert.notNull(logger, CLASS_NAME, _method, "resultSet", resultSet);

        // Get field values from resultSet
        try {
            id = OpbSqlHelper.getValue(
                    id, resultSet, "id", true);
            idDataSourceValue = id;

            contextName = OpbSqlHelper.getValue(
                    contextName, resultSet, "context_name", true);
            contextNameDataSourceValue = contextName;

            sessionId = OpbSqlHelper.getValue(
                    sessionId, resultSet, "session_id", true);
            sessionIdDataSourceValue = sessionId;

            messageType = OpbSqlHelper.getValue(
                    messageType, resultSet, "message_type", true);
            messageTypeDataSourceValue = messageType;

            messageLevel = OpbSqlHelper.getValue(
                    messageLevel, resultSet, "message_level", true);
            messageLevelDataSourceValue = messageLevel;

            messageSummary = OpbSqlHelper.getValue(
                    messageSummary, resultSet, "message_summary", true);
            messageSummaryDataSourceValue = messageSummary;

            messageDetail = OpbSqlHelper.getValue(
                    messageDetail, resultSet, "message_detail", true);
            messageDetailDataSourceValue = messageDetail;

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, _method);

        }

        // create the id
        _opbId = new OpbId(
                id);

        logger.exiting(CLASS_NAME, _method);

    } // End of opbLoad(ResultSet resultSet)

    /*
     * Returns the id of this OpbMessage.
     * This ID is created using the field id.
     * Note: This method will return null opbLoad(ResultSet) has not been called.
     */
    public OpbId getOpbId() {
        return _opbId;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter section">

    /**
     * Returns the value of idDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for id.
     */
    public java.math.BigDecimal getIdDataSourceValue() {
        return idDataSourceValue;
    }

    /**
     * Returns the value of id for this OpbMessage.
     */
    public java.math.BigDecimal getId() {
        return id;
    }

    /**
     * Sets the value of id for this OpbMessage.
     */
    public void setId(java.math.BigDecimal id) {
        this.id = id;
    } // End of setId(java.math.BigDecimal)

    /**
     * Returns the value of contextNameDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for contextName.
     */
    public String getContextNameDataSourceValue() {
        return contextNameDataSourceValue;
    }

    /**
     * Returns the value of contextName for this OpbMessage.
     */
    public String getContextName() {
        return contextName;
    }

    /**
     * Sets the value of contextName for this OpbMessage.
     */
    public void setContextName(String contextName) {
        this.contextName = contextName;
    } // End of setContextName(String)

    /**
     * Returns the value of sessionIdDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for sessionId.
     */
    public String getSessionIdDataSourceValue() {
        return sessionIdDataSourceValue;
    }

    /**
     * Returns the value of sessionId for this OpbMessage.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of sessionId for this OpbMessage.
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    } // End of setSessionId(String)

    /**
     * Returns the value of messageTypeDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageType.
     */
    public String getMessageTypeDataSourceValue() {
        return messageTypeDataSourceValue;
    }

    /**
     * Returns the value of messageType for this OpbMessage.
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of messageType for this OpbMessage.
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    } // End of setMessageType(String)

    /**
     * Returns the value of messageLevelDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageLevel.
     */
    public String getMessageLevelDataSourceValue() {
        return messageLevelDataSourceValue;
    }

    /**
     * Returns the value of messageLevel for this OpbMessage.
     */
    public String getMessageLevel() {
        return messageLevel;
    }

    /**
     * Sets the value of messageLevel for this OpbMessage.
     */
    public void setMessageLevel(String messageLevel) {
        this.messageLevel = messageLevel;
    } // End of setMessageLevel(String)

    /**
     * Returns the value of messageSummaryDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageSummary.
     */
    public String getMessageSummaryDataSourceValue() {
        return messageSummaryDataSourceValue;
    }

    /**
     * Returns the value of messageSummary for this OpbMessage.
     */
    public String getMessageSummary() {
        return messageSummary;
    }

    /**
     * Sets the value of messageSummary for this OpbMessage.
     */
    public void setMessageSummary(String messageSummary) {
        this.messageSummary = messageSummary;
    } // End of setMessageSummary(String)

    /**
     * Returns the value of messageDetailDataSourceValue for this OpbMessage.
     * This is the last value returned by the data source for messageDetail.
     */
    public String getMessageDetailDataSourceValue() {
        return messageDetailDataSourceValue;
    }

    /**
     * Returns the value of messageDetail for this OpbMessage.
     */
    public String getMessageDetail() {
        return messageDetail;
    }

    /**
     * Sets the value of messageDetail for this OpbMessage.
     */
    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    } // End of setMessageDetail(String)

    // </editor-fold> End of Getter and Setter Section

    // <editor-fold defaultstate="collapsed" desc="value changed getter section">

    /**
     * Returns true if the value of id for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getIdChanged() {
        return !OpbComparisonHelper.isEqual(
                id, idDataSourceValue);

    }

    /**
     * Returns true if the value of contextName for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getContextNameChanged() {
        return !OpbComparisonHelper.isEqual(
                contextName, contextNameDataSourceValue);

    }

    /**
     * Returns true if the value of sessionId for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getSessionIdChanged() {
        return !OpbComparisonHelper.isEqual(
                sessionId, sessionIdDataSourceValue);

    }

    /**
     * Returns true if the value of messageType for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageTypeChanged() {
        return !OpbComparisonHelper.isEqual(
                messageType, messageTypeDataSourceValue);

    }

    /**
     * Returns true if the value of messageLevel for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageLevelChanged() {
        return !OpbComparisonHelper.isEqual(
                messageLevel, messageLevelDataSourceValue);

    }

    /**
     * Returns true if the value of messageSummary for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageSummaryChanged() {
        return !OpbComparisonHelper.isEqual(
                messageSummary, messageSummaryDataSourceValue);

    }

    /**
     * Returns true if the value of messageDetail for this OpbMessage
     * is different to the value that was loaded from the data source,
     * false otherwise.
     */
    public boolean getMessageDetailChanged() {
        return !OpbComparisonHelper.isEqual(
                messageDetail, messageDetailDataSourceValue);

    }

    // </editor-fold> End of value changed getter Section

    /**
     * Calls the database procedure delete_message(NUMBER).
     * Deletes a message by it's ID.
     */
    public void deleteMessage(java.math.BigDecimal pId)
    throws OpbDataAccessException {
        final String _method = "deleteMessage(java.math.BigDecimal)";

        logger.entering(CLASS_NAME, _method);

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, _method,
                _opbConnectionProvider,
                "{ CALL opb_message.delete_message(?) }",
                "DbCall:opb_message#delete_message(NUMBER)");

        opbCallHelper.setObject(
                1, java.sql.Types.DECIMAL, pId);

        opbCallHelper.execute();

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, _method);

    } // End of deleteMessage(java.math.BigDecimal)

    /**
     * Calls deleteMessage(java.math.BigDecimal pId)
     * using instance values for;
     * <ul>
     *   <li>pId -> id</li>
     * </ul>
     */
    public void deleteMessage()
    throws OpbDataAccessException {
        final String _method = "deleteMessage()";

        logger.entering(CLASS_NAME, _method);

        deleteMessage(id);

    } // End of deleteMessage()

} // End of class OpbMessage
