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

CREATE PACKAGE embedded_comments
AS
  /*opb-package
    
    field
      name=include;

    --field
      name=exclude;

  */

  /*
  if the param element wasn't commented, this call would not be translated as
  the datatype of p_data would be set to something un-known.
  */
  /*opb
    --param
      name=p_data
      datatype=un_known;
  */
  procedure a(p_data in number);

  /*
  this call will not be translated.
  */
  /*opb
    param
      name=p_data
      datatype=un_known;
  */
  procedure a2(p_data in number);

END;
