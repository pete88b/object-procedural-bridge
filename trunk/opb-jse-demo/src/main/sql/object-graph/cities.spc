CREATE OR REPLACE PACKAGE cities
IS

  /*opb-package
    field
      name=city_name
      datatype=VARCHAR2
      in_load=ignored;

  */


  /*
    Returns all cities that meet the search criteria.
  */
  /*opb
    param
      name=p_city_name
      field=city_name;

    param
      name=RETURN
      datatype=CURSOR?city;

  */
  FUNCTION get_filtered(
    p_city_name IN VARCHAR2
  )
  RETURN SYS_REFCURSOR;

  /*
    Returns the ID of the specified city.
  */
  FUNCTION get_city_id(
    p_city_name IN VARCHAR2
  )
  RETURN INTEGER;

END cities;
/
