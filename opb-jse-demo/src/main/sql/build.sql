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

PROMPT Opb JSE demo build

@@array_demo_spc.sql
@@array_demo_bdy.sql
@@boolean_demo.sql
@@user_defined_collection_demo.sql

CREATE SEQUENCE shared_data_id_sequence
MINVALUE 0
MAXVALUE 99999999999999999999999999
START WITH 0
INCREMENT BY 1
CACHE 10
CYCLE
ORDER;

CREATE TABLE city_data (
  city_id INTEGER CONSTRAINT city_pk PRIMARY KEY,
  city_name VARCHAR2(2000)
);

CREATE TRIGGER bi_fer_city
BEFORE INSERT ON city_data
FOR EACH ROW
BEGIN
  SELECT shared_data_id_sequence.NEXTVAL
    INTO :NEW.city_id
    FROM DUAL;
END;
/

CREATE TABLE address_data (
  address_id INTEGER CONSTRAINT address_pk PRIMARY KEY,
  line_1 VARCHAR2(2000),
  line_2 VARCHAR2(2000),
  city_id INTEGER
    CONSTRAINT address_needs_city
      REFERENCES city_data(city_id)
      ON DELETE CASCADE
);

CREATE TRIGGER bi_fer_address
BEFORE INSERT ON address_data
FOR EACH ROW
BEGIN
  SELECT shared_data_id_sequence.NEXTVAL
    INTO :NEW.address_id
    FROM DUAL;
END;
/

CREATE TABLE person_data (
  person_id INTEGER CONSTRAINT person_pk PRIMARY KEY,
  first_name VARCHAR2(2000),
  last_name VARCHAR2(2000),
  address_id INTEGER
    CONSTRAINT person_needs_address
      REFERENCES address_data(address_id)
      ON DELETE CASCADE
);

CREATE TRIGGER bi_fer_person
BEFORE INSERT ON person_data
FOR EACH ROW
BEGIN
  SELECT shared_data_id_sequence.NEXTVAL
    INTO :NEW.person_id
    FROM DUAL;
END;
/

@@object-graph/address.spc
@@object-graph/addresses.spc
@@object-graph/city.spc
@@object-graph/cities.spc
@@object-graph/person.spc
@@object-graph/people.spc

@@object-graph/address.bdy
@@object-graph/addresses.bdy
@@object-graph/city.bdy
@@object-graph/cities.bdy
@@object-graph/person.bdy
@@object-graph/people.bdy

PROMPT
PROMPT ___ Listing of invalid objects ___

COLUMN object_name FORMAT A40

SELECT object_type, object_name
FROM user_objects
WHERE status != 'VALID';
