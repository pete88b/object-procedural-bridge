CREATE OR REPLACE PACKAGE user_defined_collections
IS
  function get_null
  return number_table;

  procedure get_null_proc(
    p_data out number_table
  );

  function echo_number_table(
    p_data in number_table
  )
  return number_table;

  function format_number_table(
    p_data in number_table
  )
  return varchar2;

  procedure simple_in_out(
    p_data in out varchar_table
  );

  function how_long(
    p_data in varchar_table,
    p_results out varchar_table
  )
  return varchar2;

END user_defined_collections;
/
CREATE OR REPLACE PACKAGE BODY user_defined_collections
IS
  function get_null
  return number_table
  is
  begin
    return NULL;
  end;

  procedure get_null_proc(
    p_data out number_table
  )
  is
  begin
    p_data := NULL;
  end;

  function echo_number_table(
    p_data in number_table
  )
  return number_table
  is
  begin
    dbms_output.put_line('echo_number_table');
    if (p_data is null)
    then
      dbms_output.put_line('p_data is null');
    else
      dbms_output.put_line('p_data is not null. last=' || p_data.last);
    end if;
    return p_data;
  end;

  function format_number_table(
    p_data in number_table
  )
  return varchar2
  is
    l_result varchar2(32767);

  begin
    dbms_output.put_line('format_number_table');

    for i in p_data.first .. p_data.last
    loop
      if (i = p_data.first)
      then
        l_result := p_data(i);
      else
        l_result := l_result || ', ' || p_data(i);
      end if;
    end loop;

    return l_result;

  end;

  procedure simple_in_out(
    p_data in out varchar_table
  )
  is
  begin
    dbms_output.put_line('simple_in_out');
    if (p_data is null)
    then
      dbms_output.put_line('p_data is null');
    else
      dbms_output.put_line('p_data is not null. last=' || p_data.last);
    end if;
  end;

  function how_long(
    p_data in varchar_table,
    p_results out varchar_table
  )
  return varchar2
  is
  begin
    if (p_data.last is not null)
    then
      p_results := varchar_table();
      p_results.extend(p_data.last);
      for i in p_data.first .. p_data.last
      loop
        p_results(i) := length(p_data(i));

      end loop;

      return 'notnull';

    end if;

    return 'null';

  end;

END user_defined_collections;
/
