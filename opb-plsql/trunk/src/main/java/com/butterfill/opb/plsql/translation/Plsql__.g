lexer grammar Plsql;
@header {
package com.butterfill.opb.plsql.translation;
}

T43 : '.' ;
T44 : ':=' ;
T45 : '(' ;
T46 : ')' ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 194
CURSOR  
  :  ('c'|'C') ('u'|'U') ('r'|'R') ('s'|'S') ('o'|'O') ('r'|'R') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 198
AS  
  :  ('a'|'A') ('s'|'S') 
  ;
    
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 202
IS  
  :  ('i'|'I') ('s'|'S') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 206
RETURN 
  :  ('r'|'R') ('e'|'E') ('t'|'T') ('u'|'U') ('r'|'R') ('n'|'N') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 210
PACKAGE
  :  ('p'|'P') ('a'|'A') ('c'|'C') ('k'|'K') ('a'|'A') ('g'|'G') ('e'|'E') 
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 214
END
  :  ('e'|'E') ('n'|'N') ('d'|'D') 
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 218
AUTHID
  :  ('a'|'A') ('u'|'U') ('t'|'T') ('h'|'H') ('i'|'I') ('d'|'D') 
  ;
    
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 222
FUNCTION
  :  ('f'|'F') ('u'|'U') ('n'|'N') ('c'|'C') ('t'|'T') ('i'|'I') ('o'|'O') ('n'|'N')
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 226
PROCEDURE
  :  ('p'|'P') ('r'|'R') ('o'|'O') ('c'|'C') ('e'|'E') ('d'|'D') ('u'|'U') ('r'|'R') ('e'|'E') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 230
IN
  :  ('i'|'I') ('n'|'N') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 234
OUT
  :  ('o'|'O') ('u'|'U') ('t'|'T') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 238
NOCOPY
  :  ('n'|'N') ('o'|'O') ('c'|'C') ('o'|'O') ('p'|'P') ('y'|'Y') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 242
DEFAULT
  :  ('d'|'D') ('e'|'E') ('f'|'F') ('a'|'A') ('u'|'U') ('l'|'L') ('t'|'T') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 246
EXCEPTION
  :  ('e'|'E') ('x'|'X') ('c'|'C') ('e'|'E') ('p'|'P') ('t'|'T') ('i'|'I') ('o'|'O') ('n'|'N') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 250
CONSTANT
  :  ('c'|'C') ('o'|'O') ('n'|'N') ('s'|'S') ('t'|'T') ('a'|'A') ('n'|'N') ('t'|'T') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 254
PRAGMA  
  :  ('p'|'P') ('r'|'R') ('a'|'A') ('g'|'G') ('m'|'M') ('a'|'A') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 258
TYPE   
  :  ('t'|'T') ('y'|'Y') ('p'|'P') ('e'|'E') 
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 262
SUBTYPE
  :  ('s'|'S') ('u'|'U') ('b'|'B') ('t'|'T') ('y'|'Y') ('p'|'P') ('e'|'E') 
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 266
NULL
  :  ('n'|'N') ('u'|'U') ('l'|'L') ('l'|'L')
  ;

// End of keywords  
  
  
// Not really true PL/SQL ID definition but Opb needs the [] and ?
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 274
ID  
  :  ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '_' | '$' | '#' | '0'..'9' | '%' | '[' | ']' | '?')*
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 278
QUOTED_ID
  :  '"' ( options {greedy=false;} : .)+ '"'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 282
NUMBER
  :  '-'? '0'..'9'+ ('.' '0'..'9'+)?
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 286
QUOTED_LITERAL
  :  '\'' ( options {greedy=false;} : .)* '\''
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 290
fragment
NEWLINE  
  :  '\r'? '\n'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 295
SL_COMMENT
  :   '--' .* NEWLINE { $channel=HIDDEN; }
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 299
ML_COMMENT
  :  '/*' ( options {greedy=false;} : .)* '*/'
  ;
      
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 303
COMMA
  :  ','
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 307
EQUALS
  :  '='
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 311
SEMI
  :  ';'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 315
QUESTION_MARK
  :  '?'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 319
FORWARD_SLASH
  :  '/'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 323
PERCENT
  :  '%'
  ;
  
// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 327
PIPE
  :  '|'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 331
STAR
  :  '*'
  ;

// $ANTLR src "src/com/butterfill/opb/plsql/translation/Plsql.g" 335
WS  
  :  (' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; }
  ;
