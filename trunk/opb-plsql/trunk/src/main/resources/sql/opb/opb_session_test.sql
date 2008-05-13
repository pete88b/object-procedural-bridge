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

DECLARE
  l_id VARCHAR2(2000);
  l_boolean BOOLEAN;
  
BEGIN
  logger.set_feedback_level(0);
  
  -- add logger_utils as an observer of the username changed event
  BEGIN
    event_mediator.add_observer('username_changed', 'logger_utils');
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX
    THEN
      NUll;
  END;
  
  -- Clear all session data for test
  opb_session.clear_all_session_data;
  
  assert.is_true(
    opb_session.get_session_id IS NULL,
    'opb_session.get_session_id should be null');
  assert.is_true(
    opb_session.get_username IS NULL,
    'opb_session.get_username');
  
  BEGIN
    l_boolean := opb_session.property_exists('x');
  EXCEPTION
    WHEN OTHERS
    THEN
      IF (SQLCODE != assert.assertion_error_code_C)
      THEN
        RAISE;
      END IF;
  END;
    
  -- create the session
  opb_session.create_session(l_id, 'me');
  assert.is_true(
    opb_session.get_session_id IS NULL,
    'opb_session.get_session_id should be null');
  assert.is_true(
    opb_session.get_username IS NULL,
    'opb_session.get_username');
  
  -- #1 call set property. 
  --This property will not have been set as we're not in an active phase
  opb_session.set_property('x', 'XxX');
  
  assert.is_true(
    opb_session.get_property('x') IS NULL,
    'all calls to get_property should return NULL during inactive phase');
  
  -- Start an active phase
  opb_session.starting_active_phase(l_id);
  assert.is_true(
    opb_session.get_session_id = l_id,
    'opb_session.get_session_id should be ' || l_id);
  assert.is_true(
    opb_session.get_username = 'me',
    'opb_session.get_username should be me');
    
  -- Check logger_utils was notified
  assert.is_true(
    logger_utils.get_user = 'me',
    'logger_utils was not notified of username change');
    
  -- check the property was not set. See #1
  assert.is_true(
    opb_session.get_property('x') IS NULL,
    'set_property should do nothing during inactive phase');
    
  assert.is_true(
    NOT opb_session.property_exists('x'),
    'expected FALSE as x not set');
  
  -- set a property
  opb_session.set_property('x', 'XxX');
  -- check the property was set
  assert.is_true(
    opb_session.get_property('x') = 'XxX',
    'get_property should have returned XxX');
  assert.is_true(
    opb_session.property_exists('x'),
    'expected TRUE as x set');
    
  -- end the active phase
  opb_session.ending_active_phase(l_id);
  assert.is_true(
    opb_session.get_session_id IS NULL,
    'opb_session.get_session_id should be null');
  assert.is_true(
    opb_session.get_username IS NULL,
    'opb_session.get_username');
    
  -- Check logger_utils was notified
  assert.is_true(
    logger_utils.get_user IS NULL,
    'logger_utils was not notified of username change');
    
  assert.is_true(
    opb_session.get_property('x') IS NULL,
    'all calls to get_property should return NULL during inactive phase');
    
  opb_session.starting_active_phase(l_id);
  -- check the property is still set
  assert.is_true(
    opb_session.get_property('x') = 'XxX',
    'get_property should have returned XxX');
  assert.is_true(
    opb_session.property_exists('x'),
    'expected TRUE as x set');

  opb_session.ending_active_phase(l_id);
  
  BEGIN
    l_boolean := opb_session.property_exists('x');
  EXCEPTION
    WHEN OTHERS
    THEN
      IF (SQLCODE != assert.assertion_error_code_C)
      THEN
        RAISE;
      END IF;
  END;
  
  -- end the session
  opb_session.end_session(l_id);
  
  -- Check that a sesison can end during an active phase
  opb_session.create_session(l_id, 'me');
  opb_session.starting_active_phase(l_id);
  assert.is_true(
    NOT opb_session.property_exists('x'),
    'expected FALSE as x not set');
  opb_session.end_session(l_id);
  
END;
