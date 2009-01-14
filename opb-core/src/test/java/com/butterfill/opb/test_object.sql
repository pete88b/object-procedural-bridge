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

create or replace package test_object
as
  
  /*opb-package
    
    field
      name=id
      id=Y;
    field
      name=description
      observable=Y;
    field
      name=status
      observable=Y
      datatype=INTEGER;
  */
  
  yes_c constant varchar2(1) := 'y';

  /*opb
    param
      name=RETURN
      datatype=cursor.test_object;
  */
  FUNCTION get_test_objects
  RETURN SYS_REFCURSOR;

end;
/
