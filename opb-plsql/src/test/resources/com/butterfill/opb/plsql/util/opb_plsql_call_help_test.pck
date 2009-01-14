CREATE OR REPLACE PACKAGE opb_plsql_call_help_test IS

  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;

  FUNCTION VARCHAR2_test(
    a OUT VARCHAR2
  )
  RETURN VARCHAR2;
  
  FUNCTION set_object_test(
    a in VARCHAR2
  )
  RETURN VARCHAR2;

  /*opb
    param
      name=a
      datatype=boolean;
  */
  FUNCTION set_object_test2(
    a in VARCHAR2
  )
  RETURN VARCHAR2;
  
  procedure get_object_test(
    a out varchar2
  );
  
  procedure call_complete_test;
  
  function get_rs_test
  return sys_refcursor;
  
  /*opb
    param
      name=p_result
      datatype=BOOLEAN;
  */
  procedure boolean_test(
    p_what in INTEGER,
    p_result OUT varchar2
  );
  
  procedure increment(
    p_data IN OUT INTEGER
  );
  
  function index_table(
    p_data in dbms_sql.varchar2_table
  )
  return integer;

END opb_plsql_call_help_test;
/
CREATE OR REPLACE PACKAGE BODY opb_plsql_call_help_test IS

  
  FUNCTION VARCHAR2_test(
    a OUT VARCHAR2
  )
  RETURN VARCHAR2
  IS
  BEGIN
    a := 'VARCHAR2_pos_2';
    RETURN 'VARCHAR2_pos_1';
  END;
  
  FUNCTION set_object_test(
    a in VARCHAR2
  )
  RETURN VARCHAR2
  is
  begin
    return a || '#appended';
  end;
  
  FUNCTION set_object_test2(
    a in VARCHAR2
  )
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN a;
  END;

  procedure get_object_test(
    a out varchar2
  )
  is
  begin
    a := 'abc';
  end;
  
  procedure call_complete_test
  is
  begin
    null;
  end;
  
  function get_rs_test
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result
    for select 'x' from dual;
    
    return l_result;
  end;
  
  procedure boolean_test(
    p_what in INTEGER,
    p_result OUT varchar2
  )
  IS
  BEGIN
    IF (p_what = 0)
    THEN
      p_result := 'n';
    ELSIF (p_what = 1)
    THEN
      p_result := 'y';
    ELSE
      p_result := NULL;
    END IF;
  END;
  
  procedure increment(
    p_data IN OUT INTEGER
  )
  IS
  BEGIN
    p_data := p_data + 1;
  END;
  
  function index_table(
    p_data in dbms_sql.varchar2_table
  )
  return integer
  is
  begin
    return p_data.count;
  end;

END opb_plsql_call_help_test;
/
