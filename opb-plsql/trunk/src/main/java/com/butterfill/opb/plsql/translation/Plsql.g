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
 A grammar for PL/SQL package source code.
 The parser generated from this grammar will recognise a PL/SQL package 
 specification at the start of a file and create an AST using the 
 constructs of interest during Opb translation.
*/
 
grammar Plsql;

options {
  output=AST;
}

tokens {
  T_PARAM;
  T_PARAMS;
  T_PARAM_MODE;
  T_IGNORE;
}

@header {
package com.butterfill.opb.plsql.translation;
}

@lexer::header{
package com.butterfill.opb.plsql.translation;
}


startRule
  :  createOrReplacePackage
     invokerRights?
     isOrAS
     element*
     endOfPackage
  ;
  
createOrReplacePackage  
  :  dotStar PACKAGE (ID '.')? packageName=ID -> ^(PACKAGE $packageName)
  /*  dotStar matches CREATE (OR REPLACE)? . Use dotStar for simplicity */
  ;

invokerRights
  :  AUTHID ID ->
  /*  Use ID so we don't need to worry about keyword case (CURRENST_USER or DEFINER) */
  ;
  
isOrAS
  :  IS ->
  |  AS ->
  ;  

endOfPackage
  :  END ID? SEMI .*
  ;
  
element
  :  constantDeclaration
  |  function
  |  procedure
  |  mlComment
  |  slComment
  |  pragma 
  |  typeDefinition 
  |  subtypeDefinition
  |  cursorDeclaration 
  |  variableDeclaration 
  |  exceptionDeclaration 
  ;

constantDeclaration
  :  l_id=ID CONSTANT l_dataType=dataType ((':=' | DEFAULT) l_literal=literal)? SEMI
     -> ^(CONSTANT $l_id $l_dataType $l_literal?)              
  ;

literal
  :  NUMBER
  |  QUOTED_LITERAL
  |  NULL
  ;

function
  :  FUNCTION l_id=ID
    (
    '(' l_params+=param
      (',' l_params+=param
      )*
    ')'
    )?
    RETURN l_dataType=dataType
    isOrAS? ID* QUOTED_LITERAL? /* needed for "as language java name 'xxx'" */  
    SEMI
    ->
    ^(FUNCTION $l_id ^(T_PARAMS $l_params*) ^(RETURN $l_dataType))
  ;

procedure
  :  PROCEDURE l_id=ID
     (
     '(' l_params+=param
       (',' l_params+=param
       )*
     ')'
     )?
     isOrAS? ID* QUOTED_LITERAL? /* needed for "as language java name 'xxx'" */  
     SEMI
     ->
     ^(PROCEDURE $l_id ^(T_PARAMS $l_params*))
  ;

pragmaDummy
  :  PRAGMA .* SEMI 
  ;

pragma
  :  pragmaDummy -> ^(T_IGNORE)
  ;

typeDefinitionDummy
  :  TYPE .* SEMI 
  ;

typeDefinition
  :  typeDefinitionDummy -> ^(T_IGNORE)
  ;
  
subtypeDefinitionDummy
  :  SUBTYPE .* SEMI 
  ;
  
subtypeDefinition
  :  subtypeDefinitionDummy -> ^(T_IGNORE)
  ;

cursorDeclarationDummy
  :  CURSOR .* SEMI 
  ;

cursorDeclaration
  :  cursorDeclarationDummy -> ^(T_IGNORE)
  ;

variableDeclarationDummy
  :  id dataType (':=' | DEFAULT) .* SEMI
  ;

variableDeclaration
  :  variableDeclarationDummy -> ^(T_IGNORE)
  ;

exceptionDeclaration
  :  id EXCEPTION SEMI
     -> ^(T_IGNORE)
  ;
  
mlComment
  :  l_comment=ML_COMMENT
     -> ^($l_comment)
  ;

slComment
  :  SL_COMMENT
    -> ^(T_IGNORE)
  ;

param  
  :  l_id=ID IN? OUT? NOCOPY? l_dataType=dataType ((':=' | DEFAULT) dotStar)? 
     -> ^(T_PARAM $l_id $l_dataType ^(T_PARAM_MODE IN? OUT?))
  ;

dataType
  :  (id '.')? id ('(' NUMBER (',' NUMBER)? ')')?
  ;

id
  :  ID          
  |  QUOTED_ID
  ;

/* There's a bug in ANTLR 3 rules with tree re-writes so we need to factor out all .*'s*/
dotStar
  :  .* 
     { if (false) throw new RecognitionException(); }
     /* this is needed to keep the Java compiler happy. .* does not throw a RecognitionException */
  ;

// Start of keywords
CURSOR  
  :  ('c'|'C') ('u'|'U') ('r'|'R') ('s'|'S') ('o'|'O') ('r'|'R') 
  ;
  
AS  
  :  ('a'|'A') ('s'|'S') 
  ;
    
IS  
  :  ('i'|'I') ('s'|'S') 
  ;
  
RETURN 
  :  ('r'|'R') ('e'|'E') ('t'|'T') ('u'|'U') ('r'|'R') ('n'|'N') 
  ;
  
PACKAGE
  :  ('p'|'P') ('a'|'A') ('c'|'C') ('k'|'K') ('a'|'A') ('g'|'G') ('e'|'E') 
  ;

END
  :  ('e'|'E') ('n'|'N') ('d'|'D') 
  ;

AUTHID
  :  ('a'|'A') ('u'|'U') ('t'|'T') ('h'|'H') ('i'|'I') ('d'|'D') 
  ;
    
FUNCTION
  :  ('f'|'F') ('u'|'U') ('n'|'N') ('c'|'C') ('t'|'T') ('i'|'I') ('o'|'O') ('n'|'N')
  ;
  
PROCEDURE
  :  ('p'|'P') ('r'|'R') ('o'|'O') ('c'|'C') ('e'|'E') ('d'|'D') ('u'|'U') ('r'|'R') ('e'|'E') 
  ;
  
IN
  :  ('i'|'I') ('n'|'N') 
  ;
  
OUT
  :  ('o'|'O') ('u'|'U') ('t'|'T') 
  ;
  
NOCOPY
  :  ('n'|'N') ('o'|'O') ('c'|'C') ('o'|'O') ('p'|'P') ('y'|'Y') 
  ;
  
DEFAULT
  :  ('d'|'D') ('e'|'E') ('f'|'F') ('a'|'A') ('u'|'U') ('l'|'L') ('t'|'T') 
  ;
  
EXCEPTION
  :  ('e'|'E') ('x'|'X') ('c'|'C') ('e'|'E') ('p'|'P') ('t'|'T') ('i'|'I') ('o'|'O') ('n'|'N') 
  ;
  
CONSTANT
  :  ('c'|'C') ('o'|'O') ('n'|'N') ('s'|'S') ('t'|'T') ('a'|'A') ('n'|'N') ('t'|'T') 
  ;
  
PRAGMA  
  :  ('p'|'P') ('r'|'R') ('a'|'A') ('g'|'G') ('m'|'M') ('a'|'A') 
  ;
  
TYPE   
  :  ('t'|'T') ('y'|'Y') ('p'|'P') ('e'|'E') 
  ;
  
SUBTYPE
  :  ('s'|'S') ('u'|'U') ('b'|'B') ('t'|'T') ('y'|'Y') ('p'|'P') ('e'|'E') 
  ;

NULL
  :  ('n'|'N') ('u'|'U') ('l'|'L') ('l'|'L')
  ;

// End of keywords  
  
  
// Not really true PL/SQL ID definition but Opb needs the [] and ?
ID  
  :  ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '_' | '$' | '#' | '0'..'9' | '%' | '[' | ']' | '?')*
  ;

QUOTED_ID
  :  '"' ( options {greedy=false;} : .)+ '"'
  ;

NUMBER
  :  '-'? '0'..'9'+ ('.' '0'..'9'+)?
  ;

QUOTED_LITERAL
  :  '\'' ( options {greedy=false;} : .)* '\''
  ;

fragment
NEWLINE  
  :  '\r'? '\n'
  ;

SL_COMMENT
  :   '--' .* NEWLINE { $channel=HIDDEN; }
  ;
  
ML_COMMENT
  :  '/*' ( options {greedy=false;} : .)* '*/'
  ;
      
COMMA
  :  ','
  ;
  
EQUALS
  :  '='
  ;
  
SEMI
  :  ';'
  ;

QUESTION_MARK
  :  '?'
  ;

FORWARD_SLASH
  :  '/'
  ;

PERCENT
  :  '%'
  ;
  
PIPE
  :  '|'
  ;

STAR
  :  '*'
  ;

WS  
  :  (' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; }
  ;
