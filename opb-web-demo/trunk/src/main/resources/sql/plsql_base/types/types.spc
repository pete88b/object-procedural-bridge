CREATE OR REPLACE PACKAGE types 
IS

  TYPE max_varchar2_table IS TABLE OF VARCHAR2(32767)
  INDEX BY BINARY_INTEGER;
  
  TYPE number_table IS TABLE OF NUMBER
  INDEX BY BINARY_INTEGER;
  
  TYPE integer_table IS TABLE OF INTEGER
  INDEX BY BINARY_INTEGER;
  
END types;
/
