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

CREATE OR REPLACE PACKAGE array_demo
IS

  /*
    Logs the elements of the specified collection at level 101.
  */
  /*opb
    param
      name=p_array
      datatype=VARCHAR2[];
  */
  PROCEDURE demo_one(
    p_array IN DBMS_SQL.VARCHAR2_TABLE
  );

END array_demo;
/
