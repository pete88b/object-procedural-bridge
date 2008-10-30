lexer grammar Plsql;
@header {
package com.butterfill.opb.plsql.translation;
}

T46 : '.' ;
T47 : ':=' ;
T48 : '(' ;
T49 : ')' ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 204
CURSOR  
  :  ('c'|'C') ('u'|'U') ('r'|'R') ('s'|'S') ('o'|'O') ('r'|'R') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 208
AS  
  :  ('a'|'A') ('s'|'S') 
  ;
    
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 212
IS  
  :  ('i'|'I') ('s'|'S') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 216
RETURN 
  :  ('r'|'R') ('e'|'E') ('t'|'T') ('u'|'U') ('r'|'R') ('n'|'N') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 220
PACKAGE
  :  ('p'|'P') ('a'|'A') ('c'|'C') ('k'|'K') ('a'|'A') ('g'|'G') ('e'|'E') 
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 224
END
  :  ('e'|'E') ('n'|'N') ('d'|'D') 
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 228
AUTHID
  :  ('a'|'A') ('u'|'U') ('t'|'T') ('h'|'H') ('i'|'I') ('d'|'D') 
  ;
    
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 232
FUNCTION
  :  ('f'|'F') ('u'|'U') ('n'|'N') ('c'|'C') ('t'|'T') ('i'|'I') ('o'|'O') ('n'|'N')
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 236
PROCEDURE
  :  ('p'|'P') ('r'|'R') ('o'|'O') ('c'|'C') ('e'|'E') ('d'|'D') ('u'|'U') ('r'|'R') ('e'|'E') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 240
IN
  :  ('i'|'I') ('n'|'N') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 244
OUT
  :  ('o'|'O') ('u'|'U') ('t'|'T') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 248
NOCOPY
  :  ('n'|'N') ('o'|'O') ('c'|'C') ('o'|'O') ('p'|'P') ('y'|'Y') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 252
DEFAULT
  :  ('d'|'D') ('e'|'E') ('f'|'F') ('a'|'A') ('u'|'U') ('l'|'L') ('t'|'T') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 256
EXCEPTION
  :  ('e'|'E') ('x'|'X') ('c'|'C') ('e'|'E') ('p'|'P') ('t'|'T') ('i'|'I') ('o'|'O') ('n'|'N') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 260
CONSTANT
  :  ('c'|'C') ('o'|'O') ('n'|'N') ('s'|'S') ('t'|'T') ('a'|'A') ('n'|'N') ('t'|'T') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 264
PRAGMA  
  :  ('p'|'P') ('r'|'R') ('a'|'A') ('g'|'G') ('m'|'M') ('a'|'A') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 268
TYPE   
  :  ('t'|'T') ('y'|'Y') ('p'|'P') ('e'|'E') 
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 272
SUBTYPE
  :  ('s'|'S') ('u'|'U') ('b'|'B') ('t'|'T') ('y'|'Y') ('p'|'P') ('e'|'E') 
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 276
NULL
  :  ('n'|'N') ('u'|'U') ('l'|'L') ('l'|'L')
  ;

// End of keywords  
  
  
// Not really true PL/SQL ID definition but Opb needs the [] and ?
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 284
ID  
  :  ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '_' | '$' | '#' | '0'..'9' | '%' | '[' | ']' | '?')*
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 288
QUOTED_ID
  :  '"' ( options {greedy=false;} : .)+ '"'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 292
NUMBER
  :  '-'? '0'..'9'+ ('.' '0'..'9'+)?
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 296
QUOTED_LITERAL
  :  '\'' ( options {greedy=false;} : .)* '\''
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 300
fragment
NEWLINE  
  :  '\r'? '\n'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 305
SL_COMMENT
  :   '--' .* NEWLINE { $channel=HIDDEN; }
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 309
ML_COMMENT
  :  '/*' ( options {greedy=false;} : .)* '*/'
  ;
      
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 313
COMMA
  :  ','
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 317
EQUALS
  :  '='
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 321
SEMI
  :  ';'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 325
QUESTION_MARK
  :  '?'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 329
FORWARD_SLASH
  :  '/'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 333
PERCENT
  :  '%'
  ;
  
// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 337
PIPE
  :  '|'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 341
STAR
  :  '*'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 345
EXCLAMATION
  :  '!'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 349
GREATERTHAN
  :  '>'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 353
LESSTHAN
  :  '<'
  ;

// $ANTLR src "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g" 357
WS  
  :  (' ' | '\t' | '\n' | '\r')+ { $channel=HIDDEN; }
  ;
