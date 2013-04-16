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

CREATE OR REPLACE PACKAGE BODY array_demo
IS

  PROCEDURE demo_one(
    p_array IN DBMS_SQL.VARCHAR2_TABLE
  )
  IS
  BEGIN
    IF (p_array.LAST IS NOT NULL)
    THEN
      FOR i IN p_array.FIRST .. p_array.LAST
      LOOP
        dbms_output.put_line(i || '=' || p_array(i));
      END LOOP;
    END IF;
  END;

END array_demo;
/
