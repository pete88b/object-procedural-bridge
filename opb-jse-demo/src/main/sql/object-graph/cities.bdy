CREATE OR REPLACE PACKAGE BODY cities
IS

  FUNCTION get_filtered(
    p_city_name IN VARCHAR2
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;

  BEGIN
    dbms_output.put_line('get_filtered');

    dbms_output.put_line(
      'p_city_name=' || p_city_name);

    OPEN l_result FOR
    SELECT
      city_data.*
    FROM
      city_data
    WHERE (
      UPPER(city_name) LIKE '%' || UPPER(p_city_name) || '%'
      OR city_name IS NULL AND p_city_name IS NULL);

    RETURN l_result;

  END get_filtered;

  FUNCTION get_city_id(
    p_city_name IN VARCHAR2
  )
  RETURN INTEGER
  IS
    l_result integer;

  BEGIN
    dbms_output.put_line('get_city_id');

    dbms_output.put_line(
      'p_city_name=' || p_city_name);

    SELECT
      city_id
    INTO 
      l_result
    FROM
      city_data
    WHERE city_name = p_city_name;

    RETURN l_result;

  END get_city_id;

END cities;
/
