CREATE OR REPLACE PACKAGE city
IS
  
  /*opb-package
    field
      name=city_id
      datatype=INTEGER  
      id=Y;
  
    field
      name=city_name
      datatype=VARCHAR2;
  
  */
  
  
  /*
    Deletes a City by primary key.
  */
  /*opb
    param
      name=p_city_id
      field=city_id;
  
    param
      name=p_old_city_name
      field=city_name_data_source_value;
  
    clear_cached
      name=this;
  */
  PROCEDURE del(
    p_city_id IN INTEGER,
    p_old_city_name IN VARCHAR2);
  
  
  /*
    Creates a City returning it's new primary key value(s).
  */
  /*opb
    param
      name=p_city_id
      field=city_id;
  
    param
      name=p_city_name
      field=city_name;
  
    invalidate_cached
      name=this;
  */
  PROCEDURE ins(
    p_city_id OUT INTEGER,
    p_city_name IN VARCHAR2);
  
  
  /*
    Updates a City by primary key.
  */
  /*opb
    param
      name=p_city_id
      field=city_id;
  
    param
      name=p_city_name
      field=city_name;
  
    param
      name=p_old_city_name
      field=city_name_data_source_value;
  
    invalidate_cached
      name=this;
  */
  PROCEDURE upd(
    p_city_id IN INTEGER,
    p_city_name IN VARCHAR2,
    p_old_city_name IN VARCHAR2);
  
  /*
    Returns all addresses of the specified city.
  */
  /*opb
    param
      name=p_city_id
      field=city_id;

    param
      name=RETURN
      datatype=CURSOR?address;

  */
  FUNCTION get_addresses(
    p_city_id IN INTEGER
  )
  RETURN SYS_REFCURSOR;

END city;
/
