CREATE OR REPLACE PACKAGE BODY array_demo
IS

  PROCEDURE demo_one(
    p_array IN DBMS_SQL.VARCHAR2_TABLE
  )
  IS
  BEGIN
    logger.fb('Start of test_one');

    logger.fb('p_array.LAST=' || p_array.LAST);

    IF (p_array.LAST IS NOT NULL)
    THEN
      FOR i IN p_array.FIRST .. p_array.LAST
      LOOP
        logger.log(101, i || '=' || p_array(i));
      END LOOP;
    END IF;
  END;

END array_demo;
/
