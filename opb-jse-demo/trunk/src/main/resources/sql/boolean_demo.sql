CREATE OR REPLACE PACKAGE boolean_demo
IS
  /*opb
    param
      name=RETURN
      datatype=BOOLEAN;
  */
  FUNCTION get_true
  RETURN VARCHAR2;

END;
/

CREATE OR REPLACE PACKAGE BODY boolean_demo
IS
  FUNCTION get_true
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN 'Y';
  END;
END;
/
