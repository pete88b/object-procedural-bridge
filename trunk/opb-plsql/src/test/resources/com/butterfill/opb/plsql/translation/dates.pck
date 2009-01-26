CREATE OR REPLACE PACKAGE dates 
IS

  /*opb-package
    field
      name=a_date
      datatype=DATE;
      
    field
      name=b_date
      datatype=date;
      
  */
  
  /*opb
    param
      name=p_date
      field=a_date;
  */
  PROCEDURE date_in_out(
    p_date IN OUT DATE
  );
  
  /*opb
    param
      name=p_date
      field=b_date;
  */
  function add_one_day(
    p_date in date
  )
  return date;

  function today
  return date;

END dates;
/
CREATE OR REPLACE PACKAGE BODY dates 
IS
  PROCEDURE date_in_out(
    p_date IN OUT DATE
  )
  IS
  BEGIN
    p_date := p_date + 1;
  END;
  
  
  function add_one_day(
    p_date in date
  )
  return date
  IS
  BEGIN
    RETURN p_date + 1;
  END;
  
  function today
  return date
  is
  begin
    return sysdate;
  end;
  
END dates;
/
