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

SET VERIFY OFF

PROMPT Creating user defined collection types
CREATE OR REPLACE TYPE varchar_table IS TABLE OF VARCHAR2(4000);
/

CREATE OR REPLACE TYPE number_table IS TABLE OF NUMBER;
/

PROMPT
PROMPT Creating types
@@types/build.sql

PROMPT
PROMPT Creating opb_plsql_call_help_test
@@../com/butterfill/opb/plsql/util/opb_plsql_call_help_test.pck

PROMPT
PROMPT Creating arrays_in
@@../com/butterfill/opb/plsql/translation/arrays_in.pck

PROMPT Creating test_table for calls package

DECLARE
  db_version VARCHAR2(2000);
  db_compatibility VARCHAR2(2000);

BEGIN
  -- Get the database version for test_table creation
  DBMS_UTILITY.DB_VERSION(db_version, db_compatibility);
  
  DBMS_OUTPUT.PUT_LINE('Found database version: ' || db_version || CHR(10));

  BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE test_table';
  EXCEPTION
    WHEN OTHERS THEN NULL; -- we don't care if this fails
  END;

  IF (INSTR(db_version, '.') > 2)
  THEN
    DBMS_OUTPUT.PUT_LINE('building 10g test_table');

    EXECUTE IMMEDIATE '
      CREATE TABLE test_table(
        a_binary_double BINARY_DOUBLE,
        a_binary_float  BINARY_FLOAT,
        a_char          CHAR(10),
        a_date          DATE,
        a_number        NUMBER,
        a_nvarchar2     NVARCHAR2(10),
        a_raw           RAW(10),
        a_timestamp     TIMESTAMP(6),
        a_varchar2      VARCHAR2(10),
        a_blob          BLOB,
        a_clob          CLOB,
        a_nclob         NCLOB)';

      DBMS_OUTPUT.PUT_LINE('Inserting row into 10g test_table');

      EXECUTE IMMEDIATE '
        INSERT INTO test_table(
          a_binary_double, 
          a_binary_float, 
          a_char, 
          a_date, 
          a_number, 
          a_nvarchar2, 
          a_raw, 
          a_timestamp, 
          a_varchar2,
          a_blob, a_clob, a_nclob)
       VALUES(
         3.14159265358979E+000, 
         3.14159274E+000, 
         ''Pi'', 
         TO_DATE(''01-02-0003 04:05:06'', ''dd-mm-yyyy hh24:mi:ss''), 
         3.14159265358979, 
         ''Pi'', 
         ''03'', 
         TO_TIMESTAMP(''01-02-0003 04:05:06.000007'', ''dd-mm-yyyy hh24:mi:ss.ff''), 
         ''Pi'',
         EMPTY_BLOB(), EMPTY_CLOB(), EMPTY_CLOB())';

  ELSE
    DBMS_OUTPUT.PUT_LINE('building pre-10g test_table');

    EXECUTE IMMEDIATE '
      CREATE TABLE test_table(
        a_char          CHAR(10),
        a_date          DATE,
        a_number        NUMBER,
        a_nvarchar2     NVARCHAR2(10),
        a_raw           RAW(10),
        a_varchar2      VARCHAR2(10),
        a_blob          BLOB,
        a_clob          CLOB,
        a_nclob         NCLOB)';
        
      DBMS_OUTPUT.PUT_LINE('Inserting row into pre 10g test_table');

      EXECUTE IMMEDIATE '
        INSERT INTO test_table(
          a_char, 
          a_date, 
          a_number, 
          a_nvarchar2, 
          a_raw, 
          a_varchar2,
          a_blob, a_clob, a_nclob)
        VALUES(
          ''Pi'', 
          TO_DATE(''01-02-0003 04:05:06'', ''dd-mm-yyyy hh24:mi:ss''), 
          3.14159265358979, 
          NULL, 
          ''03'', 
          ''Pi'',
          EMPTY_BLOB(), EMPTY_CLOB(), EMPTY_CLOB())';

  END IF;

  COMMIT;

END;
/

PROMPT 
PROMPT Creating calls 10g
PROMPT This will create with compilation errors on pre-10g databases
@@../com/butterfill/opb/plsql/translation/calls10g.pck

PROMPT 
PROMPT Creating calls 8i
@@../com/butterfill/opb/plsql/translation/calls8i.pck

PROMPT 
PROMPT Creating cat
@@../com/butterfill/opb/plsql/translation/cat.pck

PROMPT 
PROMPT Creating cats
@@../com/butterfill/opb/plsql/translation/cats.pck

PROMPT 
PROMPT Creating index_table
@@../com/butterfill/opb/plsql/translation/index_table.pck

PROMPT 
PROMPT Creating long_strings
@@../com/butterfill/opb/plsql/translation/long_strings.pck

PROMPT 
PROMPT Creating param_cache
@@../com/butterfill/opb/plsql/translation/param_cache.pck

PROMPT 
PROMPT Creating param_cache2
@@../com/butterfill/opb/plsql/translation/param_cache2.pck

PROMPT 
PROMPT Creating param_cache3
@@../com/butterfill/opb/plsql/translation/param_cache3.pck

PROMPT 
PROMPT Creating param_cache
@@../com/butterfill/opb/plsql/translation/user_defined_collections.pck

PROMPT
PROMPT ___ Listing of invalid objects ___

COLUMN object_name FORMAT A40

SELECT object_type, object_name
FROM user_objects
WHERE status != 'VALID';

UNDEFINE drop_existing