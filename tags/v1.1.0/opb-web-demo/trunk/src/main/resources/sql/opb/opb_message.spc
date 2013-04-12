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

CREATE OR REPLACE PACKAGE opb_message 
IS
  
  /*opb-package
    
    field
      name=id
      datatype=NUMBER
      read_only=Y;

    field
      name=context_name
      read_only=Y;
    
    field
      name=session_id
      read_only=Y;
    
    field
      name=message_type
      read_only=Y;
    
    field
      name=message_level
      read_only=Y;
    
    field
      name=message_summary
      read_only=Y;
    
    field
      name=message_detail
      read_only=Y;
    
  */
  
  /*
    Deletes a message by it's ID.
  */
  /*opb
    param
      name=p_id
      field=id;
  */
  PROCEDURE delete_message(
    p_id IN NUMBER
  );
  
END opb_message;
/
