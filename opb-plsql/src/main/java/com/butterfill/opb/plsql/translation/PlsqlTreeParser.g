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

/*
 Grammar for parsing the AST created by the PlsqlParser (see Plsql.g).
 The parser generated from this grammar will create and configure a
 com.butterfill.opb.plsql.translation.PlsqlPackage.
*/

tree grammar PlsqlTreeParser;

options {
  superClass=PlsqlTreeParserSuperClass;
  tokenVocab=Plsql;
  ASTLabelType=CommonTree;
}

@header {
package com.butterfill.opb.plsql.translation;
}

startRule
  :  createOrReplacePackage
     element*
  ;

createOrReplacePackage
  :  ^(PACKAGE ID) {setPlsqlPackageName($ID.text);}
  ;
  
element
  :  mlComment
  |  constantDeclaration
  |  function
  |  procedure
  |  ignore
  ;

mlComment
  :  ML_COMMENT {setMlComment($text);}
  ;

constantDeclaration
  @after {clearTempData();}
  :  ^(CONSTANT l_id=ID l_datatype=dataType l_value=literal?)
     {addConstant($l_id.text, $l_datatype.text, (l_value == null) ? null : $l_value.text);}
  ;

literal
  :  NUMBER
  |  QUOTED_LITERAL
  |  NULL
  ;
  
function
  @init {initFunction();}
  @after {clearTempData();}
  :  ^(FUNCTION l_id=ID ^(T_PARAMS param*) ^(RETURN l_returnType=dataType))
     {setFunctionInfo($l_id.text, $l_returnType.a, $l_returnType.b);}
  ;

procedure
  @init {initProcedure();}
  @after {clearTempData();}
  :  ^(PROCEDURE l_id=ID ^(T_PARAMS param*))
     {setProcedureInfo($l_id.text);}
  ;

ignore
  :  T_IGNORE {clearTempData();}
  ;
  
param  
  :  ^(T_PARAM l_id=ID l_dataType=dataType ^(T_PARAM_MODE l_in=IN? l_out=OUT?))
     {addParam($l_id.text, $l_dataType.a, $l_dataType.b, $l_in, $l_out);}
  ;

dataType returns[String a, String b]
  :  (l_a=id '.')? l_b=id ('(' NUMBER (',' NUMBER)? ')')?
     {$a=(l_a == null) ? null : $l_a.text; $b=$l_b.text;}
  ;

id
  :  ID          
  |  QUOTED_ID   
  ;
