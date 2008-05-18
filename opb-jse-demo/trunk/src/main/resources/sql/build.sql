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

@array_demo_spc.sql
@array_demo_bdy.sql
@boolean_demo.sql
@user_defined_collection_demo.sql

PROMPT
PROMPT ___ Listing of invalid objects ___

COLUMN object_name FORMAT A40

SELECT object_type, object_name
FROM user_objects
WHERE status != 'VALID';
