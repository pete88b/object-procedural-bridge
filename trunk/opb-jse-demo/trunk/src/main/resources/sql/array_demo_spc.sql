CREATE OR REPLACE PACKAGE array_demo
IS

  /*
    Logs the elements of the specified collection at level 101.
  */
  /*opb
    param
      name=p_array
      datatype=VARCHAR2[];
  */
  PROCEDURE demo_one(
    p_array IN DBMS_SQL.VARCHAR2_TABLE
  );

END array_demo;
/
