/*
For tesing simple calls that use the use_???_cache properties of an opb comment.
*/
CREATE OR REPLACE PACKAGE param_cache 
IS

  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;

  /*
  out params can't use the result cache
  */
  /*opb
    param
      name=p_data
      use_result_cache=Y;
  */
  procedure use_result_cache_a(
    p_data out sys_refcursor);
  
  /*
  functions that return cursors use the result cache by default -
  use_data_object_cache=Y will be ignored
  use_scalar_result_cache=Y will be ignored
  */
  /*opb
    param
      name=RETURN
      use_data_object_cache=Y
      use_scalar_result_cache=Y;
  */
  function use_result_cache_b
  return sys_refcursor;
  
  /*
  explicitly use the result cache
  */
  /*opb
    param
      name=RETURN
      use_result_cache=Y;
  */
  function use_result_cache_b2
  return sys_refcursor;
  
  
  /*
  do not use the scalar result cache.
  */
  /*opb
    param
      name=RETURN
      use_result_cache=N;
  */
  function use_result_cache_b3
  return sys_refcursor;




  /*
  out params can't use the scalar result cache
  */
  /*opb
    param
      name=p_data
      use_scalar_result_cache=Y;
  */
  procedure use_scalar_result_cache_a(
    p_data out integer);
  
  /*
  functions do not use the scalar result cache by default
  */
  function use_scalar_result_cache_b
  return integer;
  
  /*
  explicitly use the scalar result cache
  */
  /*opb
    param
      name=RETURN
      use_scalar_result_cache=Y;
  */
  function use_scalar_result_cache_b2
  return integer;
  
  /*
  do not use the scalar result cache.
  */
  /*opb
    param
      name=RETURN
      use_scalar_result_cache=N;
  */
  function use_scalar_result_cache_b3
  return integer;



  /*opb
    param
      name=p_result
      datatype=cursor?fields_id;
  */
  procedure use_data_object_cache_a(
    p_result out sys_refcursor);
    
  /*opb
    param
      name=return
      datatype=cursor?fields_id;
  */
  function use_data_object_cache_b
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
  function use_data_object_cache_b2
  return sys_refcursor;

END param_cache;
/
CREATE OR REPLACE PACKAGE BODY param_cache 
IS

  procedure use_result_cache_a(
    p_data out sys_refcursor)
  is
  begin
    open p_data for select * from dual;
  end;
  
  function use_result_cache_b
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
  function use_result_cache_b2
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
  function use_result_cache_b3
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for select * from dual;
    return l_result;
  end;
  
  
  
  procedure use_scalar_result_cache_a(
    p_data out integer)
  is
  begin
    p_data := 97645438;
  end;
  
  function use_scalar_result_cache_b
  return integer
  is
  begin
    return 97645438;
  end;
  
  function use_scalar_result_cache_b2
  return integer
  is
  begin
    return 97645438;
  end;
  
  function use_scalar_result_cache_b3
  return integer
  is
  begin
    return 97645438;
  end;
  
  
  
  procedure use_data_object_cache_a(
    p_result out sys_refcursor
    )
  is
  begin
    open p_result for
    select 'pk_value' AS pk, 'pk2_value' AS pk2, 'a_value' AS a
    from dual;
  end;
  
  function use_data_object_cache_b
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select 'pk_value' AS pk, 'pk2_value' AS pk2, 'a_value' AS a
    from dual;
    return l_result;
  end;
  
  function use_data_object_cache_b2
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select 'pk_value' AS pk, 'pk2_value' AS pk2, 'a_value' AS a
    from dual;
    return l_result;
  end;
END param_cache;
/
