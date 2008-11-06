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
    logger.entering('test_one');
    
    logger.fb('p_array.LAST=' || p_array.LAST);
    
    IF (p_array.LAST IS NOT NULL)
    THEN
      FOR i IN p_array.FIRST .. p_array.LAST
      LOOP
        logger.fb(i || '=' || p_array(i));
      END LOOP;
    END IF;
  END;
  
  PROCEDURE test_two(
    p_array DBMS_SQL.NUMBER_TABLE
  )
  IS
  BEGIN
    logger.entering('test_two');
    
    logger.fb('p_array.LAST=' || p_array.LAST);
    
    IF (p_array.LAST IS NOT NULL)
    THEN
      FOR i IN p_array.FIRST .. p_array.LAST
      LOOP
        logger.fb(i || '=' || p_array(i));
      END LOOP;
    END IF;
  END;
  
END arrays_in;
/
