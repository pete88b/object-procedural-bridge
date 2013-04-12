/*
For tesing multi-param calls that use the use_???_cache properties of an opb 
comment - where the "key" params of the calls are of OUT mode.
*/
CREATE OR REPLACE PACKAGE param_cache3 
IS

  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;
  
  /*
  functions that return cursors use the result cache by default -
  unless they use OUT params.
  */
  function use_result_cache_b(
    p_key out integer)
  return sys_refcursor;
  
  function use_result_cache_b_part2(
    p_key in out integer)
  return sys_refcursor;
  
  /*
  explicitly use the result cache -
  This should create a warning as out params can't be used as keys
  */
  /*opb
    param
      name=RETURN
      use_result_cache=Y;
  */
  function use_result_cache_b2(
    p_key out integer)
  return sys_refcursor;
  
  function use_result_cache_b2_part2(
    p_key in out integer)
  return sys_refcursor;
  
  /*
  do not use the scalar result cache.
  */
  /*opb
    param
      name=RETURN
      use_result_cache=N;
  */
  function use_result_cache_b3(
    p_key out integer)
  return sys_refcursor;



  
  /*
  functions do not use the scalar result cache by default
  */
  function use_scalar_result_cache_b(
    p_key out integer)
  return integer;
  
  function use_scalar_result_cache_b_p2(
    p_key in out integer)
  return integer;
  
  /*
  explicitly use the scalar result cache - 
  This should create a warning as out params can't be used as keys
  */
  /*opb
    param
      name=RETURN
      use_scalar_result_cache=Y;
  */
  function use_scalar_result_cache_b2(
    p_key out integer)
  return integer;
  
  function use_scalar_result_cache_b2_p2(
    p_key in out integer)
  return integer;
  
  /*
  do not use the scalar result cache.
  */
  /*opb
    param
      name=RETURN
      use_scalar_result_cache=N;
  */
  function use_scalar_result_cache_b3(
    p_key out integer)
  return integer;


  
  /*opb
    param
      name=p_result
      datatype=cursor?fields_id;
  */
  procedure use_data_object_cache_a(
    p_result out sys_refcursor,
    p_key out integer);
    
  /*opb
    param
      name=return
      datatype=cursor?fields_id;
  */
  function use_data_object_cache_b(
    p_key out integer)
  return sys_refcursor;
  
  /*
  do not use data object cache
  */
  /*opb
    param
      name=return
      datatype=cursor?fields_id
      use_data_object_cache=N;
  */
  function use_data_object_cache_b2(
    p_key out integer)
  return sys_refcursor;

END param_cache3;
/
CREATE OR REPLACE PACKAGE BODY param_cache3 
IS
  
  function use_result_cache_b(
    p_key out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
  function use_result_cache_b_part2(
    p_key in out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
  function use_result_cache_b2(
    p_key out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
  function use_result_cache_b2_part2(
    p_key in out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
    
  function use_result_cache_b3(
    p_key out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
    
  function use_scalar_result_cache_b(
    p_key out integer)
  return integer
  is
  begin
    return 97645438;
  end;
  
  function use_scalar_result_cache_b_p2(
    p_key in out integer)
  return integer
  is
  begin
    return 97645438;
  end;
  
  function use_scalar_result_cache_b2(
    p_key out integer)
  return integer
  is
  begin
    return 97645438;
  end;
  
  function use_scalar_result_cache_b2_p2(
    p_key in out integer)
  return integer
  is
  begin
    return 97645438;
  end;
  
  function use_scalar_result_cache_b3(
    p_key out integer)
  return integer
  is
  begin
    return 97645438;
  end;
  
  
  procedure use_data_object_cache_a(
    p_result out sys_refcursor,
    p_key out integer)
  is
  begin
    open p_result for
    select 'pk_value' AS pk, 'pk2_value' AS pk2, 'a_value' AS a
    from dual;
  end;
  
  function use_data_object_cache_b(
    p_key out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select 'pk_value' AS pk, 'pk2_value' AS pk2, 'a_value' AS a
    from dual;
    return l_result;
  end;
  
  function use_data_object_cache_b2(
    p_key out integer)
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select 'pk_value' AS pk, 'pk2_value' AS pk2, 'a_value' AS a
    from dual;
    return l_result;
  end;
END param_cache3;
/
