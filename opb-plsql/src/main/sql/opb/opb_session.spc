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

CREATE OR REPLACE PACKAGE opb_session 
IS
  
  /*
    This package represents a user's session and 
    provides access to session data (the table opb_session_data).
  */
  
  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;
  
  /*
    Status used to indicate that a session is inactive.
  */
  session_status_inactive_c CONSTANT INTEGER := 0;
  
  /*
    Status used to indicate that a session is active.
  */
  session_status_active_c CONSTANT INTEGER := 1;
  
  
  /*
    Returns the context name of this session.
    Note: This will be null unless the session is in an active phase.
  */
  FUNCTION get_context_name
  RETURN VARCHAR2;
  
  /*
    Returns the session ID of this session.
    Note: This will be null unless the session is in an active phase.
  */
  FUNCTION get_session_id
  RETURN VARCHAR2;
  
  /*
    Returns the username of this session.
    Note: This will be null unless the session is in an active phase.
  */
  FUNCTION get_username
  RETURN VARCHAR2;
  
  /*
    Returns the value of the property identified by key for the current
    session.
    This function will return null if the specified property does not exist
    or the session is not in an active phase.
  */
  FUNCTION get_property(
    p_key IN VARCHAR2
  )
  RETURN VARCHAR2;
  
  /*
    Sets the value of the property identified by key for the current session.
    
    Commits: Yes
  */
  PROCEDURE set_property(
    p_key IN VARCHAR2,
    p_value IN VARCHAR2
  );
  
  /*
    Returns the value of the property identified by key for the specified 
    session.
    This function will return null if either the specified property or session
    id do not exist.
  *
  FUNCTION get_property(
    p_session_id IN VARCHAR2,
    p_key IN VARCHAR2
  )
  RETURN VARCHAR2;
  
  /*
    Sets the value of the property identified by key for the specified session.
    
    Commits: Yes
  *
  PROCEDURE set_property(
    p_session_id IN VARCHAR2,
    p_key IN VARCHAR2,
    p_value IN VARCHAR2
  );
  */
  
  /*
    Creates a new session for the given context returning the session ID.
    Note: This does not start an active phase.
    
    Commits: Yes
  */
  PROCEDURE create_session(
    p_context_name IN VARCHAR2,
    p_session_id OUT VARCHAR2
  );
  
  /*
    Sets the username for a session.
    
    Commits: Yes
  */
  PROCEDURE set_username(
    p_session_id IN VARCHAR2,
    p_username IN VARCHAR2
  );
  
  /*
    Ends a session.
    
    Commits: Yes
  */
  PROCEDURE end_session(
    p_session_id IN VARCHAR2
  );
  
  /*
    Starts an active phase for the session.
    
    Note: 
      This notifies any observers of the 'username_changed' event,
      sending 'set_user(<username for session>)' via the event mediator.
      
    Exception:
      If p_session_id is not a valid session ID.
      
    Commits: Yes
  */
  PROCEDURE starting_active_phase(
    p_session_id IN VARCHAR2
  );

  /*
    Ends an active phase for the session.
    
    Note: 
      If constants.yes is passed into p_clear_temp_data, all messages added 
      for this session will be cleared.
      Any observers of the 'username_changed' event will be notified -
      sending 'set_user(NULL)' via the event mediator.
      
    Exception:
      If p_session_id is not a valid session ID.
      
    Commits: Yes
  */
  PROCEDURE ending_active_phase(
    p_session_id IN VARCHAR2,
    p_clear_temp_data IN VARCHAR2
  );
  
  /*
    Clears all session data for the specified context.
    
    Commits: Yes
  */
  PROCEDURE clear_session_data(
    p_context_name IN VARCHAR2
  );
  
  /*
    Clears all session data.
    
    Commits: Yes
  */
  PROCEDURE clear_all_session_data;
  
END opb_session;
/
