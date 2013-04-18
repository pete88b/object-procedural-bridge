CREATE OR REPLACE PACKAGE BODY person
IS
  
  PROCEDURE del(
    p_person_id IN INTEGER,
    p_old_last_name IN VARCHAR2,
    p_old_address_id IN INTEGER,
    p_old_first_name IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('del');
  
    dbms_output.put_line(
      'p_person_id=' || p_person_id || 
      ', p_old_last_name=' || p_old_last_name || 
      ', p_old_address_id=' || p_old_address_id || 
      ', p_old_first_name=' || p_old_first_name);
  
    DELETE FROM 
      person_data
    WHERE
      person_id = p_person_id  
    AND (
      last_name = p_old_last_name OR
      (last_name IS NULL AND p_old_last_name IS NULL))  
    AND (
      address_id = p_old_address_id OR
      (address_id IS NULL AND p_old_address_id IS NULL))  
    AND (
      first_name = p_old_first_name OR
      (first_name IS NULL AND p_old_first_name IS NULL));
  
    IF (SQL%ROWCOUNT = 0)
    THEN
      dbms_output.put_line(
        'Person not deleted. ' ||
        'This data has been deleted or changed by another session');
  
    ELSE
      dbms_output.put_line(
        'Person deleted');
  
    END IF;
  
    COMMIT;
  
  END del;
  
  
  PROCEDURE ins(
    p_person_id OUT INTEGER,
    p_last_name IN VARCHAR2,
    p_address_id IN INTEGER,
    p_first_name IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('ins');
  
    dbms_output.put_line(
      'p_last_name=' || p_last_name || 
      ', p_address_id=' || p_address_id || 
      ', p_first_name=' || p_first_name);
  
    INSERT INTO person_data(
      last_name,
      address_id,
      first_name)
    VALUES(
      p_last_name,
      p_address_id,
      p_first_name)
    RETURNING
      person_id  
    INTO
      p_person_id;
  
    dbms_output.put_line(
      'Person created');
  
    COMMIT;
  
  END ins;
  
  
  PROCEDURE upd(
    p_person_id IN INTEGER,
    p_last_name IN VARCHAR2,
    p_address_id IN INTEGER,
    p_first_name IN VARCHAR2,
    p_old_last_name IN VARCHAR2,
    p_old_address_id IN INTEGER,
    p_old_first_name IN VARCHAR2  
  )
  IS
  BEGIN
    dbms_output.put_line('upd');
  
    dbms_output.put_line(
      'p_person_id=' || p_person_id || 
      ', p_last_name=' || p_last_name || 
      ', p_address_id=' || p_address_id || 
      ', p_first_name=' || p_first_name || 
      ', p_old_last_name=' || p_old_last_name || 
      ', p_old_address_id=' || p_old_address_id || 
      ', p_old_first_name=' || p_old_first_name);
  
    UPDATE
      person_data
    SET
      last_name = p_last_name,
      address_id = p_address_id,
      first_name = p_first_name  
    WHERE
      person_id = p_person_id  
    AND (
      last_name = p_old_last_name OR
      (last_name IS NULL AND p_old_last_name IS NULL))  
    AND (
      address_id = p_old_address_id OR
      (address_id IS NULL AND p_old_address_id IS NULL))  
    AND (
      first_name = p_old_first_name OR
      (first_name IS NULL AND p_old_first_name IS NULL));
  
    IF (SQL%ROWCOUNT = 0)
    THEN
      dbms_output.put_line(
        'Person not updated. ' ||
        'This data has been deleted or changed by another session');
  
    ELSE
      dbms_output.put_line(
        'Person updated');
  
    END IF;
  
    COMMIT;
  
  END upd;
  
  FUNCTION get_address(
    p_address_id IN INTEGER
  )
  RETURN SYS_REFCURSOR
  IS
    l_result SYS_REFCURSOR;

  BEGIN
    dbms_output.put_line('get_address');

    dbms_output.put_line(
      'p_address_id=' || p_address_id);

    OPEN l_result FOR
    SELECT
      address_data.*
    FROM
      address_data
    WHERE address_id = p_address_id;

    RETURN l_result;

  END get_address;

END person;
/
