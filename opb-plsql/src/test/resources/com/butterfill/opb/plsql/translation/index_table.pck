/*
For testing making calls invlolving PL/SQL index-by tables.
*/
create or replace package index_table is

/*opb-package
  field
    name=number_array
    datatype=number[];

  field
    name=varchar_array
    datatype=varchar[];
*/

type extra_ibt_type is table of varchar2(20) index by binary_integer;

procedure a(
p_data in dbms_sql.varchar2_table);

procedure a2(
p_data in dbms_sql.Number_Table);


/*opb
  param
    name=p_data
    datatype=integer[];
*/
procedure a3(
p_data in dbms_sql.Number_Table);

procedure x(
p_data in types.max_varchar2_table);

procedure x2(
p_data in types.number_table);

procedure x3(
p_data in types.integer_table);

/*
  unknown datatype
*/
procedure y(
  p_data IN extra_ibt_type);

/*opb
  param
    name=p_data
    datatype=varchar[];
*/
procedure y2(
  p_data IN extra_ibt_type);

/*opb
  param
    name=p_data
    datatype=varchar[];
*/
procedure z(
  p_data IN extra_ibt_type,
  p_data2 IN types.integer_table,
  p_data3 in dbms_sql.varchar2_table);

/*
  index-by tables can't be used as out params
*/
procedure b(
  p_data out dbms_sql.varchar2_table
);

/*
  index-by tables can't be used as out params
*/
procedure c(
  p_data in out dbms_sql.varchar2_table
);

/*
  can't pass dates with index-by tables
*/
procedure d(
p_data in dbms_sql.Date_Table);

/*
  index-by tables can't be used as return values
*/
function f
return dbms_sql.varchar2_table;

end;
/
create or replace package body index_table is



procedure a(
p_data in dbms_sql.varchar2_table)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('a (' || i || ') ' || p_data(i));
    end loop;
  end if;
end;


procedure a2(
p_data in dbms_sql.Number_Table)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('a2 (' || i || ') ' || p_data(i));
    end loop;
  end if;
end;

procedure a3(
p_data in dbms_sql.Number_Table)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('a3 (' || i || ') ' || p_data(i));
    end loop;
  end if;
end;

procedure x(
p_data in types.max_varchar2_table)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('x (' || i || ') ' || SUBSTR(p_data(i), 1, 200));
    end loop;
  end if;
end;

procedure x2(
p_data in types.number_table)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('x2 (' || i || ') ' || p_data(i));
    end loop;
  end if;
end;

procedure x3(
p_data in types.integer_table)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('x3 (' || i || ') ' || p_data(i));
    end loop;
  end if;
end;

procedure y(
  p_data IN extra_ibt_type)
IS BEGIN null; END;

/*opb
  param
    name=p_data
    datatype=varchar[];
*/
procedure y2(
  p_data IN extra_ibt_type
)
is
begin
  if (p_data.last is not null)
  then
    for i in p_data.first .. p_data.last
    loop
      dbms_output.put_line('x3 (' || i || ') ' || p_data(i));
    end loop;
  end if;
end;

/*opb
  param
    name=p_data
    datatype=varchar[];
*/
procedure z(
  p_data IN extra_ibt_type,
  p_data2 IN types.integer_table,
  p_data3 in dbms_sql.varchar2_table)
IS BEGIN null; END;

procedure b(
  p_data out dbms_sql.varchar2_table
) IS BEGIN null; END;

procedure c(
  p_data in out dbms_sql.varchar2_table
) IS BEGIN null; END;

procedure d(
  p_data in dbms_sql.date_table
) IS BEGIN null; END;

function f
return dbms_sql.varchar2_table
IS BEGIN null; END;
end;
/
