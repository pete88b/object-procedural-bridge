CREATE OR REPLACE PACKAGE BODY city
IS
  
  PROCEDURE del(
    p_city_id IN INTEGER,
    p_old_city_name IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('del');
  
    dbms_output.put_line(
      'p_city_id=' || p_city_id || 
      ', p_old_city_name=' || p_old_city_name);
  
    DELETE FROM 
      city_data
    WHERE
      city_id = p_city_id  
    AND (
      city_name = p_old_city_name OR
      (city_name IS NULL AND p_old_city_name IS NULL));
  
    IF (SQL%ROWCOUNT = 0)
    THEN
      dbms_output.put_line(
        'City not deleted. ' ||
        'This data has been deleted or changed by another session');
  
    ELSE
      dbms_output.put_line(
        'City deleted');
  
    END IF;
  
    COMMIT;
  
  END del;
  
  
  PROCEDURE ins(
    p_city_id OUT INTEGER,
    p_city_name IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('ins');
  
    dbms_output.put_line(
      'p_city_name=' || p_city_name);
  
    INSERT INTO city_data(
      city_name)
    VALUES(
      p_city_name)
    RETURNING
      city_id  
    INTO
      p_city_id;
  
    dbms_output.put_line(
      'City created');
  
    COMMIT;
  
  END ins;
  
  
  PROCEDURE upd(
    p_city_id IN INTEGER,
    p_city_name IN VARCHAR2,
    p_old_city_name IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('upd');
  
    dbms_output.put_line(
      'p_city_id=' || p_city_id || 
      ', p_city_name=' || p_city_name || 
      ', p_old_city_name=' || p_old_city_name);
  
    UPDATE
      city_data
    SET
      city_name = p_city_name  
    WHERE
      city_id = p_city_id  
    AND (
      city_name = p_old_city_name OR
      (city_name IS NULL AND p_old_city_name IS NULL));
  
    IF (SQL%ROWCOUNT = 0)
    THEN
      dbms_output.put_line(
        'City not updated. ' ||
        'This data has been deleted or changed by another session');
  
    ELSE
      dbms_output.put_line(
        'City updated');
  
    END IF;
  
    COMMIT;
  
  END upd;
  
  FUNCTION get_addresses(
    p_city_id IN INTEGER
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;

  BEGIN
    dbms_output.put_line('get_addresses');

    dbms_output.put_line(
      'p_city_id=' || p_city_id);

    OPEN l_result FOR
    SELECT
      address_data.*
    FROM
      address_data
    WHERE city_id = p_city_id;

    RETURN l_result;

  END get_addresses;

END city;
/
