CREATE OR REPLACE PACKAGE address
IS
  
  /*opb-package
    field
      name=address_id
      datatype=INTEGER  
      id=Y;
  
    field
      name=city_id
      datatype=INTEGER;
  
    field
      name=line_1
      datatype=VARCHAR2;
  
    field
      name=line_2
      datatype=VARCHAR2;
  
  */
  
  
  /*
    Deletes a Address by primary key.
  */
  /*opb
    param
      name=p_address_id
      field=address_id;
  
    param
      name=p_old_city_id
      field=city_id_data_source_value;
  
    param
      name=p_old_line_1
      field=line_1_data_source_value;
  
    param
      name=p_old_line_2
      field=line_2_data_source_value;
  
    clear_cached
      name=this;
  */
  PROCEDURE del(
    p_address_id IN INTEGER,
    p_old_city_id IN INTEGER,
    p_old_line_1 IN VARCHAR2,
    p_old_line_2 IN VARCHAR2);
  
  
  /*
    Creates a Address returning it's new primary key value(s).
  */
  /*opb
    param
      name=p_address_id
      field=address_id;
  
    param
      name=p_city_id
      field=city_id;
  
    param
      name=p_line_1
      field=line_1;
  
    param
      name=p_line_2
      field=line_2;
  
    invalidate_cached
      name=this;
  */
  PROCEDURE ins(
    p_address_id OUT INTEGER,
    p_city_id IN INTEGER,
    p_line_1 IN VARCHAR2,
    p_line_2 IN VARCHAR2);
  
  
  /*
    Updates a Address by primary key.
  */
  /*opb
    param
      name=p_address_id
      field=address_id;
  
    param
      name=p_city_id
      field=city_id;
  
    param
      name=p_line_1
      field=line_1;
  
    param
      name=p_line_2
      field=line_2;
  
    param
      name=p_old_city_id
      field=city_id_data_source_value;
  
    param
      name=p_old_line_1
      field=line_1_data_source_value;
  
    param
      name=p_old_line_2
      field=line_2_data_source_value;
  
    invalidate_cached
      name=this;
  */
  PROCEDURE upd(
    p_address_id IN INTEGER,
    p_city_id IN INTEGER,
    p_line_1 IN VARCHAR2,
    p_line_2 IN VARCHAR2,
    p_old_city_id IN INTEGER,
    p_old_line_1 IN VARCHAR2,
    p_old_line_2 IN VARCHAR2);
  
  /*
    Returns all people for the specified address.
  */
  /*opb
    param
      name=p_address_id
      field=address_id;

    param
      name=RETURN
      datatype=CURSOR?person;

  */
  FUNCTION get_people(
    p_address_id IN INTEGER
  )
  RETURN SYS_REFCURSOR;

END address;
/
