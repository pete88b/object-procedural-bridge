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
 * opb_message.
 */
public class OpbMessageImpl implements OpbMessage {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbMessageImpl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of OpbMessageImpl.
     */
    public OpbMessageImpl() {
        logger.entering(CLASS_NAME, "OpbMessageImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this OpbMessageImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this OpbMessageImpl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this OpbMessageImpl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this OpbMessageImpl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this OpbMessageImpl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this OpbMessageImpl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this OpbMessageImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this OpbMessageImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this OpbMessageImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this OpbMessageImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    
    /**
     * Resets all field values to their initial values.
     */
    public void opbClearState() {
        final String methodName = "opbClearState()";

        logger.entering(CLASS_NAME, methodName);

        // set all fields to their initial values
        id = null;
        
        contextName = null;
        
        sessionId = null;
        
        messageType = null;
        
        messageLevel = null;
        
        messageSummary = null;
        
        messageDetail = null;
        

    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling 
     * opbClearState() and then sets all field values using values taken from 
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>id is <em>mandatory</em></li>
     * <li>context_name is <em>mandatory</em></li>
     * <li>session_id is <em>mandatory</em></li>
     * <li>message_type is <em>mandatory</em></li>
     * <li>message_level is <em>mandatory</em></li>
     * <li>message_summary is <em>mandatory</em></li>
     * <li>message_detail is <em>mandatory</em></li>
     * </ul>
     * 
     * @param resultSet The result set from which this instance should be loaded.
     * @throws OpbDataAccessException If we fail to load this instance.
     */
    public void opbLoad(final java.sql.ResultSet resultSet) 
            throws OpbDataAccessException {
        final String methodName = "opbLoad(ResultSet)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure resultSet is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "resultSet", resultSet);

        // Get field values from resultSet
        try {
            // load id from column id
            id = OpbSqlHelper.getValue(
                    id, resultSet, 
                    "id", true);
            
            // load contextName from column context_name
            contextName = OpbSqlHelper.getValue(
                    contextName, resultSet, 
                    "context_name", true);
            
            // load sessionId from column session_id
            sessionId = OpbSqlHelper.getValue(
                    sessionId, resultSet, 
                    "session_id", true);
            
            // load messageType from column message_type
            messageType = OpbSqlHelper.getValue(
                    messageType, resultSet, 
                    "message_type", true);
            
            // load messageLevel from column message_level
            messageLevel = OpbSqlHelper.getValue(
                    messageLevel, resultSet, 
                    "message_level", true);
            
            // load messageSummary from column message_summary
            messageSummary = OpbSqlHelper.getValue(
                    messageSummary, resultSet, 
                    "message_summary", true);
            
            // load messageDetail from column message_detail
            messageDetail = OpbSqlHelper.getValue(
                    messageDetail, resultSet, 
                    "message_detail", true);
            

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            logger.exiting(CLASS_NAME, methodName);

        }

    } // End of opbLoad(ResultSet resultSet)


    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal id = null;
    
    /**
     * Returns the value of id.
     * @return The value of id.
     */
    public java.math.BigDecimal getId() {
        return id;
    }
    
    /**
     * Sets the value of id.
     * @param a The new value for id.
     */
    private void setId(final java.math.BigDecimal a) {
        this.id = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String contextName = null;
    
    /**
     * Returns the value of contextName.
     * @return The value of contextName.
     */
    public String getContextName() {
        return contextName;
    }
    
    /**
     * Sets the value of contextName.
     * @param a The new value for contextName.
     */
    private void setContextName(final String a) {
        this.contextName = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String sessionId = null;
    
    /**
     * Returns the value of sessionId.
     * @return The value of sessionId.
     */
    public String getSessionId() {
        return sessionId;
    }
    
    /**
     * Sets the value of sessionId.
     * @param a The new value for sessionId.
     */
    private void setSessionId(final String a) {
        this.sessionId = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String messageType = null;
    
    /**
     * Returns the value of messageType.
     * @return The value of messageType.
     */
    public String getMessageType() {
        return messageType;
    }
    
    /**
     * Sets the value of messageType.
     * @param a The new value for messageType.
     */
    private void setMessageType(final String a) {
        this.messageType = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String messageLevel = null;
    
    /**
     * Returns the value of messageLevel.
     * @return The value of messageLevel.
     */
    public String getMessageLevel() {
        return messageLevel;
    }
    
    /**
     * Sets the value of messageLevel.
     * @param a The new value for messageLevel.
     */
    private void setMessageLevel(final String a) {
        this.messageLevel = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String messageSummary = null;
    
    /**
     * Returns the value of messageSummary.
     * @return The value of messageSummary.
     */
    public String getMessageSummary() {
        return messageSummary;
    }
    
    /**
     * Sets the value of messageSummary.
     * @param a The new value for messageSummary.
     */
    private void setMessageSummary(final String a) {
        this.messageSummary = a;
    }
    
    /**
     * Derived from an opb-package field.
     */
    private String messageDetail = null;
    
    /**
     * Returns the value of messageDetail.
     * @return The value of messageDetail.
     */
    public String getMessageDetail() {
        return messageDetail;
    }
    
    /**
     * Sets the value of messageDetail.
     * @param a The new value for messageDetail.
     */
    private void setMessageDetail(final String a) {
        this.messageDetail = a;
    }
    

    /**
     * Deletes a message by it's ID.
     * Calls the database procedure delete_message.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deleteMessage(final java.math.BigDecimal pId) 
            throws OpbDataAccessException {
        final String methodName = "deleteMessage(java.math.BigDecimal)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN opb_message.delete_message(?); END;",
                "DbCall:opb_message#delete_message(NUMBER)");
    
        opbCallHelper.setObject(
                1, java.sql.Types.DECIMAL, pId);
        
    
        opbCallHelper.execute();
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * Calls deleteMessage using mapped parameters.
     * <ul>
     * <li>pId is mapped to id</li>
     * </ul>
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void deleteMessage() 
            throws OpbDataAccessException {
        final String methodName = "deleteMessage()";
    
        logger.entering(CLASS_NAME, methodName);
    
        deleteMessage(getId());
    
    }
    

}