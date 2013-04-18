CREATE OR REPLACE PACKAGE people
IS

  /*opb-package
    field
      name=last_name
      datatype=VARCHAR2
      in_load=ignored;

    field
      name=address_id
      datatype=VARCHAR2
      in_load=ignored;

    field
      name=first_name
      datatype=VARCHAR2
      in_load=ignored;

  */


  /*
    Returns all people that meet the search criteria.
  */
  /*opb
    param
      name=RETURN
      datatype=CURSOR?person;

  */
  FUNCTION get_filtered(
    p_last_name IN VARCHAR2,
    p_first_name IN VARCHAR2,
    p_address IN VARCHAR2,
    p_city IN VARCHAR2
  )
  RETURN SYS_REFCURSOR;


END people;
/
