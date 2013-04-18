CREATE OR REPLACE PACKAGE addresses
IS

  /*opb-package
    field
      name=city_id
      datatype=VARCHAR2
      in_load=ignored;

    field
      name=line_1
      datatype=VARCHAR2
      in_load=ignored;

    field
      name=line_2
      datatype=VARCHAR2
      in_load=ignored;

  */


  /*
    Returns all addresses that meet the search criteria.
  */
  /*opb
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
      name=RETURN
      datatype=CURSOR?address;

  */
  FUNCTION get_filtered(
    p_city_id IN VARCHAR2,
    p_line_1 IN VARCHAR2,
    p_line_2 IN VARCHAR2
  )
  RETURN SYS_REFCURSOR;


END addresses;
/