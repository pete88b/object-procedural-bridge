CREATE OR REPLACE PACKAGE BODY address
IS
  
  PROCEDURE del(
    p_address_id IN INTEGER,
    p_old_city_id IN INTEGER,
    p_old_line_1 IN VARCHAR2,
    p_old_line_2 IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('del');
  
    dbms_output.put_line(
      'p_address_id=' || p_address_id || 
      ', p_old_city_id=' || p_old_city_id || 
      ', p_old_line_1=' || p_old_line_1 || 
      ', p_old_line_2=' || p_old_line_2);
  
    DELETE FROM 
      address_data
    WHERE
      address_id = p_address_id  
    AND (
      city_id = p_old_city_id OR
      (city_id IS NULL AND p_old_city_id IS NULL))  
    AND (
      line_1 = p_old_line_1 OR
      (line_1 IS NULL AND p_old_line_1 IS NULL))  
    AND (
      line_2 = p_old_line_2 OR
      (line_2 IS NULL AND p_old_line_2 IS NULL));
  
    IF (SQL%ROWCOUNT = 0)
    THEN
      dbms_output.put_line(
        'Address not deleted. ' ||
        'This data has been deleted or changed by another session');
  
    ELSE
      dbms_output.put_line(
        'Address deleted');
  
    END IF;
  
    COMMIT;
  
  END del;
  
  
  PROCEDURE ins(
    p_address_id OUT INTEGER,
    p_city_id IN INTEGER,
    p_line_1 IN VARCHAR2,
    p_line_2 IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('ins');
  
    dbms_output.put_line(
      'p_city_id=' || p_city_id || 
      ', p_line_1=' || p_line_1 || 
      ', p_line_2=' || p_line_2);
  
    INSERT INTO address_data(
      city_id,
      line_1,
      line_2)
    VALUES(
      p_city_id,
      p_line_1,
      p_line_2)
    RETURNING
      address_id  
    INTO
      p_address_id;
  
    dbms_output.put_line(
      'Address created');
  
    COMMIT;
  
  END ins;
  
  
  PROCEDURE upd(
    p_address_id IN INTEGER,
    p_city_id IN INTEGER,
    p_line_1 IN VARCHAR2,
    p_line_2 IN VARCHAR2,
    p_old_city_id IN INTEGER,
    p_old_line_1 IN VARCHAR2,
    p_old_line_2 IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('upd');
  
    dbms_output.put_line(
      'p_address_id=' || p_address_id || 
      ', p_city_id=' || p_city_id || 
      ', p_line_1=' || p_line_1 || 
      ', p_line_2=' || p_line_2 || 
      ', p_old_city_id=' || p_old_city_id || 
      ', p_old_line_1=' || p_old_line_1 || 
      ', p_old_line_2=' || p_old_line_2);
  
    UPDATE
      address_data
    SET
      city_id = p_city_id,
      line_1 = p_line_1,
      line_2 = p_line_2  
    WHERE
      address_id = p_address_id  
    AND (
      city_id = p_old_city_id OR
      (city_id IS NULL AND p_old_city_id IS NULL))  
    AND (
      line_1 = p_old_line_1 OR
      (line_1 IS NULL AND p_old_line_1 IS NULL))  
    AND (
      line_2 = p_old_line_2 OR
      (line_2 IS NULL AND p_old_line_2 IS NULL));
  
    IF (SQL%ROWCOUNT = 0)
    THEN
      dbms_output.put_line(
        'Address not updated. ' ||
        'This data has been deleted or changed by another session');
  
    ELSE
      dbms_output.put_line(
        'Address updated');
  
    END IF;
  
    COMMIT;
  
  END upd;
  
  FUNCTION get_people(
    p_address_id IN INTEGER
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;

  BEGIN
    dbms_output.put_line('get_people');

    dbms_output.put_line(
      ', p_address_id=' || p_address_id);

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
    AND 
      address_data.address_id = p_address_id;

    RETURN l_result;

  END get_people;
  
END address;
/
