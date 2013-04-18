CREATE OR REPLACE PACKAGE person
IS
  
  /*opb-package
    field
      name=person_id
      datatype=INTEGER  
      id=Y;
  
    field
      name=last_name
      datatype=VARCHAR2;
  
    field
      name=address_id
      datatype=INTEGER;
  
    field
      name=first_name
      datatype=VARCHAR2;
  
    field
      name=address_label
      datatype=VARCHAR2
      read_only=Y;

    field
      name=city_label
      datatype=VARCHAR2
      read_only=Y;

  */
  
  
  /*
    Deletes a Person by primary key.
  */
  /*opb
    param
      name=p_person_id
      field=person_id;
  
    param
      name=p_old_last_name
      field=last_name_data_source_value;
  
    param
      name=p_old_address_id
      field=address_id_data_source_value;
  
    param
      name=p_old_first_name
      field=first_name_data_source_value;
  
    clear_cached
      name=this;
  */
  PROCEDURE del(
    p_person_id IN INTEGER,
    p_old_last_name IN VARCHAR2,
    p_old_address_id IN INTEGER,
    p_old_first_name IN VARCHAR2);
  
  
  /*
    Creates a Person returning it's new primary key value(s).
  */
  /*opb
    param
      name=p_person_id
      field=person_id;
  
    param
      name=p_last_name
      field=last_name;
  
    param
      name=p_address_id
      field=address_id;
  
    param
      name=p_first_name
      field=first_name;
  
    invalidate_cached
      name=this;
  */
  PROCEDURE ins(
    p_person_id OUT INTEGER,
    p_last_name IN VARCHAR2,
    p_address_id IN INTEGER,
    p_first_name IN VARCHAR2);
  
  
  /*
    Updates a Person by primary key.
  */
  /*opb
    param
      name=p_person_id
      field=person_id;
  
    param
      name=p_last_name
      field=last_name;
  
    param
      name=p_address_id
      field=address_id;
  
    param
      name=p_first_name
      field=first_name;
  
    param
      name=p_old_last_name
      field=last_name_data_source_value;
  
    param
      name=p_old_address_id
      field=address_id_data_source_value;
  
    param
      name=p_old_first_name
      field=first_name_data_source_value;
  
    invalidate_cached
      name=this;
  */
  PROCEDURE upd(
    p_person_id IN INTEGER,
    p_last_name IN VARCHAR2,
    p_address_id IN INTEGER,
    p_first_name IN VARCHAR2,
    p_old_last_name IN VARCHAR2,
    p_old_address_id IN INTEGER,
    p_old_first_name IN VARCHAR2);

  /*
    Returns the address of this person.
  */
  /*opb
    param
      name=p_address_id
      field=address_id;

    param
      name=RETURN
      datatype=CURSOR?address;

  */
  FUNCTION get_address(
    p_address_id IN INTEGER
  )
  RETURN SYS_REFCURSOR;
  
END person;
/
