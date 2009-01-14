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

CREATE OR REPLACE PACKAGE constants
IS
  
  c_varchar_null constant varchar2(30);

  c_varchar_null2 constant varchar2(30) := NULL;

  c_varchar constant varchar2(30) := 'c_varchar_value';

  /*
    not a constant
  */
  g_varchar varchar2(30) := 'g_varchar_value';


  c_number_null constant number;

  c_number constant number := 3.2;

  c_integer_null constant integer;

  c_integer constant integer := 7;


END constants;
/
