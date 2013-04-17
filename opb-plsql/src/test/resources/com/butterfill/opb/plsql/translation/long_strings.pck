/*
For testing passing long strings.
*/
create or replace package long_strings
is

  function how_long(
    p_data in varchar2
  )
  return integer;

  procedure in_out(
    p_data in out varchar2);

  function get_long(
    p_how_long in integer
  )
  return varchar2;

end long_strings;
/
create or replace package body long_strings
is
  function how_long(
    p_data in varchar2
  )
  return integer
  is
    l_result integer := length(p_data);
  begin
    dbms_output.put_line('how_long; result=' || l_result);
    return l_result;
  end;

  procedure in_out(
    p_data in out varchar2)
  is
  begin
    null;
  end;


  function get_long(
    p_how_long in integer
  )
  return varchar2
  is
    l_result varchar2(32767) := rpad('a', p_how_long, 'a');
  begin
    if (p_how_long != length(l_result))
    then
      raise_application_error(
        -20000,
        'bad result length. requested=' || p_how_long ||
        ', actual=' || length(l_result));
    end if;
    return l_result;
  end;

end long_strings;
/
