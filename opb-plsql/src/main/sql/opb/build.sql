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

PROMPT ___ Start of opb build.sql ___

DECLARE
  PROCEDURE p(
    p_data IN VARCHAR2
  )
  IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE(p_data);
    
  END p;

  PROCEDURE drop_object(
    p_type_and_name IN VARCHAR2
  )
  IS
  BEGIN
    p('Dropping ' || p_type_and_name);
    EXECUTE IMMEDIATE 'DROP ' || p_type_and_name;
    p(p_type_and_name || ' dropped');
    p('-');
    
  EXCEPTION
    WHEN OTHERS
    THEN
      p(p_type_and_name || ' not found');
      p('-');
      
  END drop_object;

BEGIN
  IF (UPPER('&&drop_existing.') = 'YES' OR
      UPPER('&&drop_existing.') = 'Y')
  THEN
    drop_object('TABLE opb_message_data');
    drop_object('TABLE opb_session_properties_data');
    drop_object('SEQUENCE opb_message_id');
    drop_object('TABLE opb_session_data');
    drop_object('SEQUENCE opb_session_id');
    drop_object('TABLE opb_context_data');

  END IF;
END;
/


PROMPT Creating table opb_context_data

CREATE TABLE opb_context_data(
  context_name VARCHAR2(200),
  remote_host VARCHAR2(200),
  remote_user_name VARCHAR2(200),
  started DATE,
  stopped DATE
);


PROMPT Creating opb_session_data

CREATE TABLE opb_session_data (
  context_name VARCHAR2(2000),
  session_id VARCHAR2(2000) NOT NULL,
  username VARCHAR2(2000),
  last_accessed DATE NOT NULL,
  status INTEGER NOT NULL,
  CONSTRAINT session_id_unique UNIQUE (session_id)
);


PROMPT Creating sequence opb_session_id

CREATE SEQUENCE opb_session_id
MINVALUE -99999999999999999999999999
MAXVALUE 99999999999999999999999999
START WITH -99999999999999999999999999
INCREMENT BY 1
CACHE 10
CYCLE
ORDER;


PROMPT Creating table opb_message_data

CREATE TABLE opb_message_data (
  id INTEGER,
  context_name VARCHAR2(2000),
  session_id REFERENCES opb_session_data(session_id) ON DELETE CASCADE,
  message_type VARCHAR2(20),
  message_level VARCHAR2(20),
  message_summary VARCHAR2(2000),
  message_detail VARCHAR2(4000)
);


PROMPT Creating sequence opb_message_id

CREATE SEQUENCE opb_message_id
MINVALUE -99999999999999999999999999
MAXVALUE 99999999999999999999999999
START WITH -99999999999999999999999999
INCREMENT BY 1
CACHE 10
CYCLE
ORDER;

PROMPT Creating table opb_session_properties_data

CREATE TABLE opb_session_properties_data (
  session_id REFERENCES opb_session_data(session_id) ON DELETE CASCADE,
  key VARCHAR2(200),
  value VARCHAR2(2000)
);

PROMPT Creating opb_message specificaton
@@opb_message.spc

PROMPT Creating opb_messages specificaton
@@opb_messages.spc

PROMPT Creating opb session specificaton
@@opb_session.spc

PROMPT Creating opb context package
@@opb_context.pck

PROMPT Creating opb_message body
@@opb_message.bdy

PROMPT Creating opb_messages body
@@opb_messages.bdy

PROMPT Creating opb session body
@@opb_session.bdy

PROMPT ___ End of opb build.sql ___
