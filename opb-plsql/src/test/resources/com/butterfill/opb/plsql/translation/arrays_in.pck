/*
For testing passing arrays as IN parameters.
*/
CREATE OR REPLACE PACKAGE arrays_in IS

  /*opb
    param
      name=p_array
      datatype=VARCHAR2[];
  */
  PROCEDURE test_one(
    p_array IN DBMS_SQL.VARCHAR2_TABLE
  );

  -- Note: missing IN is intentional.
  /*opb
    param
      name=p_array
      datatype=NUMBER[];
  */
  PROCEDURE test_two(
    p_array DBMS_SQL.NUMBER_TABLE
  );


END arrays_in;
/
CREATE OR REPLACE PACKAGE BODY arrays_in IS

  PROCEDURE test_one(
    p_array IN DBMS_SQL.VARCHAR2_TABLE
  )
  IS
  BEGIN
    dbms_output.put_line('test_one');

    dbms_output.put_line('p_array.LAST=' || p_array.LAST);

    IF (p_array.LAST IS NOT NULL)
    THEN
      FOR i IN p_array.FIRST .. p_array.LAST
      LOOP
        dbms_output.put_line(i || '=' || SUBSTR(p_array(i), 1, 200));
      END LOOP;
    END IF;
  END;

  PROCEDURE test_two(
    p_array DBMS_SQL.NUMBER_TABLE
  )
  IS
  BEGIN
    dbms_output.put_line('test_two');

    dbms_output.put_line('p_array.LAST=' || p_array.LAST);

    IF (p_array.LAST IS NOT NULL)
    THEN
      FOR i IN p_array.FIRST .. p_array.LAST
      LOOP
        dbms_output.put_line(i || '=' || p_array(i));
      END LOOP;
    END IF;
  END;

END arrays_in;
/
