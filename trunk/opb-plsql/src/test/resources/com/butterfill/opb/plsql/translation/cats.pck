/*
For getting a list of cats.
See also cat.pck.
*/
CREATE OR REPLACE PACKAGE cats 
IS
  
  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;

  /*opb
    param
      name=return
      datatype=cursor?cat;
  */
  function get_cats
  return sys_refcursor;
  
END cats;
/
CREATE OR REPLACE PACKAGE BODY cats 
IS
  function get_cats
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select 'Cheshire' AS name, 1 AS type, 
           SYSDATE AS last_changed, 'cat 1' AS description
    from dual --1
    union all
    select 'Tom' AS name, 1 AS type, 
           SYSDATE AS last_changed, 'cat 2: First Tom' AS description
    from dual --2
    union all
    select 'Tom' AS name, 2 AS type, 
           SYSDATE AS last_changed, 'cat 3: Second Tom (different type)' AS description
    from dual --3
    union all
    select 'Frank' AS name, 1 AS type, 
           SYSDATE AS last_changed, 'cat4: First Frank' AS description
    from dual --4
    union all
    select 'Frank' AS name, 1 AS type, 
           SYSDATE AS last_changed, 'cat 5: Second Frank (same type)' AS description
    from dual; --5
    
    return l_result;
    
  end;

END cats;
/
