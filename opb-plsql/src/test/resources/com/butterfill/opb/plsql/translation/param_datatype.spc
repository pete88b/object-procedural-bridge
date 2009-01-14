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

package param_datatype
is
  -- these would never work but it shows datatype override

  /*opb
  param
    name=return
    datatype=number;
  */
  function invalid_1 return date;

  /*opb
    param
      name=p_1
      datatype=number;
  */
  procedure invalid_2(
    P_1 in date);

  /*opb
    param
      name=p_1
      datatype=integer;
    param
      name=p_2
      datatype=integer;
  */
  procedure dodgy(
    p_1 in out varchar2,
    p_2 in out number);

  /*opb
    param
      name=p_1
      datatype=integer;
    param
      name=p_2
      datatype=integer;
  */
  procedure a(
    p_1 in varchar2,
    p_2 in number);

end;
