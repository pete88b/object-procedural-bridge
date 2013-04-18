CREATE OR REPLACE PACKAGE BODY addresses
IS

  FUNCTION get_filtered(
    p_city_id IN VARCHAR2,
    p_line_1 IN VARCHAR2,
    p_line_2 IN VARCHAR2
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;

  BEGIN
    dbms_output.put_line('get_filtered');

    dbms_output.put_line(
      'p_city_id=' || p_city_id ||
      ', p_line_1=' || p_line_1 ||
      ', p_line_2=' || p_line_2);

    OPEN l_result FOR
    SELECT
      address_data.*
    FROM
      address_data
    WHERE (
      UPPER(city_id) LIKE '%' || UPPER(p_city_id) || '%'
      OR city_id IS NULL AND p_city_id IS NULL)
    AND (
      UPPER(line_1) LIKE '%' || UPPER(p_line_1) || '%'
      OR line_1 IS NULL AND p_line_1 IS NULL)
    AND (
      UPPER(line_2) LIKE '%' || UPPER(p_line_2) || '%'
      OR line_2 IS NULL AND p_line_2 IS NULL);

    RETURN l_result;

  END get_filtered;


END addresses;
/