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

CREATE OR REPLACE PACKAGE BODY opb_messages 
IS
  
  /*
    Returns all valid message types.
  */
  FUNCTION get_message_types
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;
    
  BEGIN
    logger.entering('get_message_types');
    
    OPEN l_result FOR
    SELECT message_type_all_contexts AS value,
           'All Contexts' AS label
    FROM   DUAL
    UNION ALL
    SELECT message_type_context AS value,
           'Context' AS label
    FROM   DUAL
    UNION ALL
    SELECT message_type_session AS value,
           'Session' AS label
    FROM   DUAL;
    
    RETURN l_result;
    
  END get_message_types;
  
  
  /*
    Returns all valid message levels.
  */
  FUNCTION get_message_levels
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;
    
  BEGIN
    logger.entering('get_message_levels');
    
    OPEN l_result FOR
    SELECT message_level_debug AS value,
           'Debug' AS label
    FROM   DUAL
    UNION ALL
    SELECT message_level_info AS value,
           'Info' AS label
    FROM   DUAL
    UNION ALL
    SELECT message_level_warning AS value,
           'Warning' AS label
    FROM   DUAL
    UNION ALL
    SELECT message_level_error AS value,
           'Error' AS label
    FROM   DUAL
    UNION ALL
    SELECT message_level_fatal AS value,
           'Fatal' AS label
    FROM   DUAL;
    
    RETURN l_result;
    
  END get_message_levels;
  
  
  /*
    Inserts a message into opb_message_data.
    This procedure handles summary and details that are too long to insert
    into the table (by truncating them).
  */
  PROCEDURE ins(
    p_context_name IN VARCHAR2,
    p_session_id IN VARCHAR2,
    p_message_type IN VARCHAR2, 
    p_message_level IN VARCHAR2, 
    p_message_summary IN VARCHAR2, 
    p_message_detail IN VARCHAR2
  )
  IS
    l_summary VARCHAR2(2000);
    l_detail VARCHAR2(4000);
    
  BEGIN
    IF (LENGTH(p_message_summary) > 2000)
    THEN
      l_summary := SUBSTR(p_message_summary, 1, 1996) || ' ...';
          
    ELSE
      l_summary := p_message_summary;
          
    END IF;
        
    IF (LENGTH(p_message_detail) > 4000)
    THEN
      l_detail := SUBSTR(p_message_detail, 1, 3996) || ' ...';
          
    ELSE
      l_detail := p_message_detail;
          
    END IF;
        
    INSERT INTO opb_message_data(
      id, context_name, session_id,
      message_type, message_level, 
      message_summary, message_detail)
    VALUES (
      opb_message_id.NEXTVAL, p_context_name, p_session_id, 
      p_message_type, p_message_level, 
      l_summary, l_detail);
    
  END ins;
  
  
  /*
    Adds a message to the message set for this session by calling 
    add_session_message.
    This is needed so we can accept messages sent from the messages package.
  */
  PROCEDURE add_message(
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('add_message');
    
    add_session_message(p_level, p_summary, p_detail);
    
  END add_message;
  
  
  /*
    Adds a message to the message set for this session.
  */
  PROCEDURE add_session_message(
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
    PRAGMA AUTONOMOUS_TRANSACTION;
    l_session_id VARCHAR2(32767) := opb_session.get_session_id;
    l_context_name VARCHAR2(32767) := opb_session.get_context_name;
    
  BEGIN
    logger.entering('add_session_message');

    logger.fb(
      'p_level=' || p_level ||
      ', p_summary=' || p_summary ||
      ', p_detail=' || p_detail ||
      ', l_context_name=' || l_context_name ||
      ', l_session_id=' || l_session_id);

    IF (l_session_id IS NOT NULL)
    THEN
      messages.check_message_level(p_level);
      
      ins(
        l_context_name, l_session_id, 
        message_type_session, p_level, 
        p_summary, p_detail);
        
    END IF;
    
    COMMIT;
    
  END add_session_message;
  
  
  /*
    Returns all messages set for this session during the current 
    active phase.
    Note: Session messages are cleared upon ending an active phase.
  */
  FUNCTION get_session_messages
  RETURN SYS_REFCURSOR
  IS
    l_session_id VARCHAR2(32767) := opb_session.get_session_id;
    l_context_name VARCHAR2(32767) := opb_session.get_context_name;
    l_result SYS_REFCURSOR;
    
  BEGIN
    logger.entering('get_session_messages');
    
    logger.fb(
      'l_session_id=' || l_session_id);
    
    OPEN l_result FOR
    SELECT   *
    FROM     opb_message_data
    WHERE    session_id = l_session_id
    OR       (message_type = message_type_context AND 
             context_name = l_context_name)
    OR       message_type = message_type_all_contexts
    ORDER BY id;
    
    RETURN l_result;
    
  END get_session_messages;
  
  
  /*
    Adds a message to the specified context.
  */
  PROCEDURE add_context_message(
    p_context_name IN VARCHAR2,
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
    PRAGMA AUTONOMOUS_TRANSACTION;

  BEGIN
    logger.entering('add_context_message');
    
    logger.fb(
      'p_context_name=' || p_context_name ||
      ', p_level=' || p_level ||
      ', p_summary=' || p_summary ||
      ', p_detail=' || p_detail);
      
    messages.check_message_level(p_level);
      
    ins(
      p_context_name, NULL, 
      message_type_context, p_level, 
      p_summary, p_detail);
    
    COMMIT;
    
  END add_context_message;
  
  
  /*
    Returns messages for the specified context (using the LIKE condition).
  */
  FUNCTION get_context_messages(
    p_context_name IN VARCHAR2
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;
    
  BEGIN
    logger.entering('get_context_messages');
    
    logger.fb(
      'p_context_name=' || p_context_name);
    
    OPEN l_result FOR
    SELECT   *
    FROM     opb_message_data
    WHERE    message_type = message_type_context
    AND      context_name LIKE p_context_name
    ORDER BY id;
    
    RETURN l_result;
    
  END get_context_messages;
  
  
  /*
    Adds an all context message. This is a message that applies to all contexts.
  */
  PROCEDURE add_all_context_message(
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
    PRAGMA AUTONOMOUS_TRANSACTION;

  BEGIN
    logger.entering('add_all_context_message');
    
    logger.fb(
      'p_level=' || p_level ||
      ', p_summary=' || p_summary ||
      ', p_detail=' || p_detail);
      
    messages.check_message_level(p_level);
      
    ins(
      NULL, NULL,
      message_type_all_contexts, p_level,
      p_summary, p_detail);
    
    COMMIT;
    
  END add_all_context_message;
  
  
  /*
    Returns messages that apply to all contexts.
  */
  FUNCTION get_all_context_messages
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;
    
  BEGIN
    logger.entering('get_all_context_messages');
    
    OPEN l_result FOR
    SELECT   *
    FROM     opb_message_data
    WHERE    message_type = message_type_all_contexts
    ORDER BY context_name, id;
    
    RETURN l_result;
    
  END get_all_context_messages;
  
  
  /*
    Clears all messages for the specified session.
    
    Commits: Yes
  */
  PROCEDURE clear_session_messages(
    p_session_id IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('clear_session_messages');
    
    logger.fb(
      'p_session_id=' || p_session_id);
      
    DELETE FROM opb_message_data
    WHERE  session_id = p_session_id;
    
    logger.fb(SQL%ROWCOUNT || ' rows deleted');
    
    COMMIT;
    
  END clear_session_messages;
  
  
  /*
    Clears all messages for the specified context.
    
    Commits: Yes
  */
  PROCEDURE clear_messages_for_context(
    p_context_name IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('clear_messages_for_context');
    
    logger.fb(
      'p_context_name=' || p_context_name);
      
    DELETE FROM opb_message_data
    WHERE  context_name = p_context_name;
    
    logger.fb(SQL%ROWCOUNT || ' rows deleted');
    
    COMMIT;
    
  END clear_messages_for_context;
  
  
  /*
    Clears all message data.
    
    Commits: Yes
  */
  PROCEDURE clear_all_messages
  IS
  BEGIN
    logger.entering('clear_all_messages');
    
    DELETE FROM opb_message_data;
    
    logger.fb(SQL%ROWCOUNT || ' rows deleted');
    
    COMMIT;
    
  END clear_all_messages;
  
  
END opb_messages;
/
