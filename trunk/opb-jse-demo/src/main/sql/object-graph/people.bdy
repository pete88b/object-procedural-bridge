CREATE OR REPLACE PACKAGE BODY people
IS

  FUNCTION get_filtered(
    p_last_name IN VARCHAR2,
    p_first_name IN VARCHAR2,
    p_address IN VARCHAR2,
    p_city IN VARCHAR2
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;

  BEGIN
    dbms_output.put_line('get_filtered');

    dbms_output.put_line(
      'p_last_name=' || p_last_name ||
      ', p_first_name=' || p_first_name ||
      ', p_address=' || p_address ||
      ', p_city=' || p_city);

    OPEN l_result FOR
    SELECT
      person_data.*,
      address_data.line_1 as address_label,
      city_data.city_name as city_label
    FROM
      person_data,   
      address_data,
      city_data
    WHERE 
      person_data.address_id = address_data.address_id
    AND
      address_data.city_id = city_data.city_id
    AND (
      UPPER(person_data.last_name) LIKE '%' || UPPER(p_last_name) || '%'
      OR person_data.last_name IS NULL AND p_last_name IS NULL)
    AND (
      UPPER(person_data.first_name) LIKE '%' || UPPER(p_first_name) || '%'
      OR person_data.first_name IS NULL AND p_first_name IS NULL)
    AND (
      UPPER(address_data.line_1) LIKE '%' || UPPER(p_address) || '%'
      OR address_data.line_1 IS NULL AND p_address IS NULL)
    AND (
      UPPER(city_data.city_name) LIKE '%' || UPPER(p_city) || '%'
      OR city_data.city_name IS NULL AND p_city IS NULL);

    RETURN l_result;

  END get_filtered;


END people;
/
