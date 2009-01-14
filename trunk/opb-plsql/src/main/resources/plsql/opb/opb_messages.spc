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

CREATE OR REPLACE PACKAGE opb_messages 
IS

  /*opb-package
    
    field
      name=context_name;
    
    field
      name=message_type;
    
    field
      name=message_level;
    
    field
      name=message_summary;
    
    field
      name=message_detail;
    
  */
  
  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;
  
  /*
    Type used to indicate a message applies to a single session.
  */
  message_type_session CONSTANT VARCHAR2(7) := 'SESSION';
  
  /*
    Type used to indicate a message applies to a single context.
  */
  message_type_context CONSTANT VARCHAR2(7) := 'CONTEXT';
  
  /*
    Type used to indicate a message applies to all contexts.
  */
  message_type_all_contexts CONSTANT VARCHAR2(12) := 'ALL_CONTEXTS';
  
  
  /*
    Level used to indicate that a message contains debug information.
  */
  message_level_debug CONSTANT VARCHAR2(5) := 'DEBUG';
  
  /*
    Level used to indicate that a message contains error information.
  */
  message_level_error CONSTANT VARCHAR2(5) := 'ERROR';
  
  /*
    Level used to indicate that a message contains fatal error information.
  */
  message_level_fatal CONSTANT VARCHAR2(5) := 'FATAL';
  
  /*
    Level used to indicate that a message contains some information.
  */
  message_level_info CONSTANT VARCHAR2(4) := 'INFO';
  
  /*
    Level used to indicate that a message contains warning information.
  */
  message_level_warning CONSTANT VARCHAR2(7) := 'WARN';
  
  /*
    Returns all valid message types.
    The cursor returned will contain two columns: value and label.
    The value column will contain the value of one of the message_type_
    constants. 
    The label column will contain a text description of the value.
  */
  FUNCTION get_message_types
  RETURN SYS_REFCURSOR;
  
  /*
    Returns all valid message levels.
    The cursor returned will contain two columns: value and label.
    The value column will contain the value of one of the message_level_
    constants. 
    The label column will contain a text description of the value.
  */
  FUNCTION get_message_levels
  RETURN SYS_REFCURSOR;
  
  /*
    Adds a message to the message set for this session by calling 
    add_session_message.
    This is needed so we can accept messages sent from the messages package.
  */
  PROCEDURE add_message(
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );
  
  /*
    Adds a message to the message set for this session.
    Notes: 
      If opb_session.get_session_id returns null, this does nothing.
      p_level should be one of the levels defined in this package.
      Session messages are cleared upon ending an active phase.
  */
  /*opb
    param
      name=p_level
      field=message_level;
      
    param
      name=p_summary
      field=message_summary;
    
    param
      name=p_detail
      field=message_detail;
    
  */
  PROCEDURE add_session_message(
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );
  
  /*
    Returns all messages for the current session.
    This will include;
      Messages added for the current session (during the current active phase), 
      Messages added for the current context and
      Messages added for all contexts.
    Note: Session messages are cleared upon ending an active phase.
  */
  /*opb
    param
      name=RETURN
      datatype=cursor?opb_message
      use_result_cache=N
      use_data_object_cache=N;
  */
  FUNCTION get_session_messages
  RETURN SYS_REFCURSOR;
  
  /*
    Adds a message to the specified context.
    Note: The context name is not checked. This makes it possible to add a
    message to a context that has not yet started.
  */
  /*opb
    param
      name=p_context_name
      field=context_name;
    
    param
      name=p_level
      field=message_level;
      
    param
      name=p_summary
      field=message_summary;
    
    param
      name=p_detail
      field=message_detail;
  */
  PROCEDURE add_context_message(
    p_context_name IN VARCHAR2,
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );
  
  /*
    Returns messages for the specified context (using the LIKE condition).
  */
  /*opb
    param
      name=RETURN
      datatype=cursor?opb_message
      use_result_cache=N
      use_data_object_cache=N;
      
    param
      name=p_context_name
      field=context_name;
  */
  FUNCTION get_context_messages(
    p_context_name IN VARCHAR2
  )
  RETURN SYS_REFCURSOR;
  
  /*
    Adds an all context message. This is a message that applies to all contexts.
  */
  /*opb
    param
      name=p_level
      field=message_level;
      
    param
      name=p_summary
      field=message_summary;
    
    param
      name=p_detail
      field=message_detail;
  */
  PROCEDURE add_all_context_message(
    p_level IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );
  
  /*
    Returns messages that apply to all contexts.
  */
  /*opb
    param
      name=RETURN
      datatype=cursor?opb_message
      use_result_cache=N
      use_data_object_cache=N;
  */
  FUNCTION get_all_context_messages
  RETURN SYS_REFCURSOR;
  
  /*
    Clears all messages for the specified session.
    
    Commits: Yes
  */
  PROCEDURE clear_session_messages(
    p_session_id IN VARCHAR2);
  
  /*
    Clears all messages for the specified context.
    
    Commits: Yes
  */
  /*opb
    param
      name=p_context_name
      field=context_name;
  */
  PROCEDURE clear_messages_for_context(
    p_context_name IN VARCHAR2
  );
  
  /*
    Clears all message data.
    
    Commits: Yes
  */
  PROCEDURE clear_all_messages;
  
END opb_messages;
/
