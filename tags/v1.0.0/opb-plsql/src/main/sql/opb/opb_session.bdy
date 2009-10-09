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

CREATE OR REPLACE PACKAGE BODY opb_session 
IS
  
  /*
    Private global to hold the current context name.
    Note: This will be null unless the session is in an active phase.
  */
  g_context_name opb_session_data.context_name%TYPE;
  
  /*
    Private global to hold the current session ID.
    Note: This will be null unless the session is in an active phase.
  */
  g_session_id opb_session_data.session_id%TYPE;
  
  /*
    Private global to hold the current username.
    Note: This will be null unless the session is in an active phase.
  */
  g_username opb_session_data.username%TYPE;
  
  /*
    Notify anyone interested that the username has changed
  */
  PROCEDURE notify_username_changed
  IS
    l_event VARCHAR2(32767);
    
  BEGIN
    l_event := 'set_user(''' || REPLACE(g_username, '''', '''''') || ''')';
    
    logger.fb('l_event=' || l_event);
    
    event_mediator.event('username_changed', l_event);
    
  END notify_username_changed;
  
  /*
  */
  PROCEDURE assert_is_true(
    p_condition IN BOOLEAN,
    p_message IN VARCHAR2  := NULL
  )
  IS
  BEGIN
    IF (p_condition IS NULL OR NOT p_condition)
    THEN
      RAISE_APPLICATION_ERROR(
        -20000, p_message);
        
    END IF;
         
  END assert_is_true;
  
  /*
  */
  FUNCTION get_context_name
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN g_context_name;
  END get_context_name;
  
  /*
  */
  FUNCTION get_session_id
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN g_session_id;
  END get_session_id;
  
  /*
  */
  FUNCTION get_username
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN g_username;
  END get_username;
  
  FUNCTION get_property(
    p_key IN VARCHAR2
  )
  RETURN VARCHAR2
  IS
    l_result VARCHAR2(32767);
    
  BEGIN
    logger.entering('get_property');
    
    logger.fb(
      'p_key=' || p_key ||
      ', g_session_id=' || g_session_id);
    
    SELECT value
      INTO l_result
      FROM opb_session_properties_data
     WHERE session_id = g_session_id
       AND (key = p_key OR (key IS NULL AND p_key IS NULL));
    
    logger.fb('property found. value=' || l_result);
    
    RETURN l_result;
    
  EXCEPTION
    WHEN NO_DATA_FOUND
    THEN
      logger.fb('property not found. returning null');
      RETURN NULL;
    
  END get_property;
  
  /*
  */
  PROCEDURE set_property(
    p_key IN VARCHAR2,
    p_value IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('set_property');
    
    logger.fb(
      'p_key=' || p_key ||
      ', p_value=' || p_value ||
      ', g_session_id=' || g_session_id);
    
    UPDATE opb_session_properties_data
       SET value = p_value
     WHERE (key = p_key OR (key IS NULL AND p_key IS NULL))
       AND session_id = g_session_id;
    
    IF (SQL%ROWCOUNT = 0)
    THEN
      INSERT INTO opb_session_properties_data(
        session_id, key, value)
      VALUES(
        g_session_id, p_key, p_value);
        
      logger.fb('property inserted');
      
    ELSE
      logger.fb('property value updated');
      
    END IF;
    
    COMMIT;
    
  END set_property;
  
  /*
  */
  PROCEDURE create_session(
    p_context_name IN VARCHAR2,
    p_session_id OUT VARCHAR2
  )
  IS
  BEGIN
    logger.entering('create_session');
    
    logger.fb(
      'p_context_name=' || p_context_name);
    
    --xxx block creation of new sessions here. 
    
    INSERT INTO opb_session_data (
      context_name, session_id, last_accessed, status)
    VALUES (
      p_context_name, opb_session_id.NEXTVAL, SYSDATE, session_status_inactive_c)
    RETURNING session_id INTO p_session_id;
    
    COMMIT;
    
    logger.fb('session created. returning ID=' || p_session_id);
      
  END create_session;
  
  /*
  */
  PROCEDURE set_username(
    p_session_id IN VARCHAR2,
    p_username IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('set_username');
    
    logger.fb(
      'p_session_id=' || p_session_id ||
      ', p_username=' || p_username);
      
    UPDATE opb_session_data
       SET username = p_username
     WHERE session_id = p_session_id;
    
    assert_is_true(
      SQL%ROWCOUNT = 1,
      'Failed to update username. session ID not found');
    
    COMMIT;
    
    g_username := p_username;
    
    notify_username_changed;
    
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error(
        'Failed to update username. p_session_id=' || 
        p_session_id || ', p_username=' || p_username);
        
      RAISE;
      
  END set_username;
  
  /*
  */
  PROCEDURE end_session(
    p_session_id IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('end_session');
    
    -- Note: session messages are taken care of via delete cascade
    
    DELETE FROM opb_session_data
     WHERE session_id = p_session_id;
    
    logger.fb(SQL%ROWCOUNT || ' rows deleted from opb_session_data');
    
    COMMIT;
    
    g_username := NULL;
    g_session_id := NULL;
    g_context_name := NULL;
    
    notify_username_changed;
      
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error(
        'Failed to end session. p_session_id=' || p_session_id);
        
      RAISE;
        
  END end_session;
  
  /*
  */
  PROCEDURE starting_active_phase(
    p_session_id IN VARCHAR2)
  IS
  BEGIN
    logger.entering('starting_active_phase');
    
    logger.fb(
      'p_session_id=' || p_session_id);
    
    UPDATE 
      opb_session_data
    SET 
      last_accessed = SYSDATE,
      status = session_status_active_c
    WHERE 
      session_id = p_session_id
    RETURNING 
      username, session_id, context_name
    INTO 
      g_username, g_session_id, g_context_name;
    
    assert_is_true(
      SQL%ROWCOUNT = 1,
      'Failed to start active phase. session ID not found');
    
    COMMIT;
    
    notify_username_changed;
      
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error(
        'Failed to start active phase. p_session_id=' || p_session_id);
        
      RAISE;
      
  END starting_active_phase;
  
  /*
  */
  PROCEDURE ending_active_phase(
    p_session_id IN VARCHAR2,
    p_clear_temp_data IN VARCHAR2
  )
  IS 
  BEGIN
    logger.entering('ending_active_phase');
    
    logger.fb(
      'p_session_id=' || p_session_id ||
      ', p_clear_temp_data=' || p_clear_temp_data);
    
    UPDATE opb_session_data
    SET    last_accessed = SYSDATE,
           status = session_status_inactive_c
    WHERE  session_id = p_session_id;
    
    assert_is_true(
      SQL%ROWCOUNT = 1,
      'Failed to end active phase. session ID not found');
    
    -- clear session messages
    IF (p_clear_temp_data = constants.yes)
    THEN
      opb_messages.clear_session_messages(p_session_id);
    END IF;
    
    COMMIT;
    
    g_username := NULL;
    g_session_id := NULL;
    g_context_name := NULL;
    
    notify_username_changed;
      
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error(
        'Failed to end active phase. p_session_id=' || p_session_id);
        
      RAISE;
      
  END ending_active_phase;
  
  /*
  */
  PROCEDURE clear_session_data(
    p_context_name IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('clear_session_data');
    
    logger.fb(
      'p_context_name=' || p_context_name);
    
    -- Note: session messages are taken care of via delete cascade
    
    DELETE FROM opb_session_data
     WHERE context_name = p_context_name 
        OR (context_name IS NULL AND p_context_name IS NULL);
    
    logger.fb(SQL%ROWCOUNT || ' rows deleted from opb_session_data');
    
    COMMIT;
    
  END clear_session_data;
  
  /*
  */
  PROCEDURE clear_all_session_data
  IS
  BEGIN
    logger.entering('clear_all_session_data');
    
    -- Note: session messages are taken care of via delete cascade
    
    DELETE FROM opb_session_data;
    
    logger.fb(SQL%ROWCOUNT || ' rows deleted from opb_session_data');
    
    COMMIT;
    
  END clear_all_session_data;
  
END opb_session;
/
