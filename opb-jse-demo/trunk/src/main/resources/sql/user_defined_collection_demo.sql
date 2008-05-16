create or replace type number_table is table of number;
/

create or replace package user_defined_collection_demo
is
  function echo(
    p_data in number_table
  )
  return number_table;

end;
/

create or replace package body user_defined_collection_demo
is
  function echo(
    p_data in number_table
  )
  return number_table
  is
  begin
    return p_data;
  end;
end;
/