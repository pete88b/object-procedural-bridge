/*
For testing simple calls with different datatypes.
Aimed at testing datatypes available in 8i.

*/
create or replace package calls8i
is

  /*
    Define SYS_REFCURSOR so this package can be used in pre-10g databases.
  */
  TYPE SYS_REFCURSOR IS REF CURSOR;

  function echo(
    p_data in varchar2
  )
  return varchar2;

  procedure echo(
    p_data in varchar2,
    p_result out varchar2
  );

  FUNCTION f_CHAR (
    p_data IN CHAR
  )
  RETURN VARCHAR2;

  FUNCTION f_VARCHAR2 (
    p_data IN VARCHAR2
  )
  RETURN VARCHAR2;

  /*
  should not be translated
  */
  FUNCTION f_LONG (
    p_data IN LONG
  )
  RETURN VARCHAR2;

  FUNCTION f_NUMBER (
    p_data IN NUMBER
  )
  RETURN VARCHAR2;

  FUNCTION f_INTEGER (
    p_data IN INTEGER
  )
  RETURN VARCHAR2;

  FUNCTION f_RAW (
    p_data IN RAW
  )
  RETURN VARCHAR2;
/*
  FUNCTION f_LONGRAW (
    p_data IN LONGRAW
  )
  RETURN VARCHAR2;
*/
  FUNCTION f_DATE (
    p_data IN DATE
  )
  RETURN VARCHAR2;

  function get_blob
  return blob;

  FUNCTION f_BLOB (
    p_data IN BLOB
  )
  RETURN VARCHAR2;

  function get_clob
  return CLOB;

  FUNCTION f_CLOB (
    p_data IN CLOB
  )
  RETURN VARCHAR2;

  FUNCTION f_SYS_REFCURSOR (
    p_data IN SYS_REFCURSOR
  )
  RETURN VARCHAR2;

  /*opb
    param
      name=p_data
      datatype=BOOLEAN;
  */
  FUNCTION f_BOOLEAN (
    p_data IN VARCHAR2
  )
  RETURN VARCHAR2;

  FUNCTION f_DBMS_SQL_VARCHAR2_TABLE (
    p_data IN DBMS_SQL.VARCHAR2_TABLE
  )
  RETURN VARCHAR2;

  /*opb
    param
      name=p_data
      datatype=number[];
  */
  FUNCTION f_DBMS_SQL_NUMBER_TABLE (
    p_data IN DBMS_SQL.NUMBER_TABLE
  )
  RETURN VARCHAR2;





  FUNCTION f_BINARY_INTEGER (
    p_data IN BINARY_INTEGER
  )
  RETURN VARCHAR2;

  FUNCTION f_DEC (
    p_data IN DEC
  )
  RETURN VARCHAR2;

  FUNCTION f_DECIMAL (
    p_data IN DECIMAL
  )
  RETURN VARCHAR2;

  FUNCTION f_FLOAT (
    p_data IN FLOAT
  )
  RETURN VARCHAR2;

  FUNCTION f_INT (
    p_data IN INT
  )
  RETURN VARCHAR2;

  FUNCTION f_NUMERIC (
    p_data IN NUMERIC
  )
  RETURN VARCHAR2;

  FUNCTION f_PLS_INTEGER (
    p_data IN PLS_INTEGER
  )
  RETURN VARCHAR2;

  FUNCTION f_POSITIVE (
    p_data IN POSITIVE
  )
  RETURN VARCHAR2;

  FUNCTION f_SMALLINT (
    p_data IN SMALLINT
  )
  RETURN VARCHAR2;

  FUNCTION f_CHARACTER (
    p_data IN CHARACTER
  )
  RETURN VARCHAR2;

  FUNCTION f_NCHAR (
    p_data IN NCHAR
  )
  RETURN VARCHAR2;

  FUNCTION f_NVARCHAR2 (
    p_data IN NVARCHAR2
  )
  RETURN VARCHAR2;

  FUNCTION f_ROWID (
    p_data IN ROWID
  )
  RETURN VARCHAR2;

  FUNCTION f_STRING (
    p_data IN STRING
  )
  RETURN VARCHAR2;

  FUNCTION f_UROWID (
    p_data IN UROWID
  )
  RETURN VARCHAR2;

  FUNCTION f_VARCHAR (
    p_data IN VARCHAR
  )
  RETURN VARCHAR2;




  FUNCTION get_CHAR
  RETURN CHAR;

  FUNCTION get_VARCHAR2
  RETURN VARCHAR2;

  FUNCTION get_NUMBER
  RETURN NUMBER;

  FUNCTION get_INTEGER
  RETURN INTEGER;

  FUNCTION get_RAW
  RETURN RAW;

  FUNCTION get_DATE
  RETURN DATE;


  /*opb
  param
  name=return
  datatype=boolean;
  */
  FUNCTION get_BOOLEAN
  RETURN varchar2;





  FUNCTION get_BINARY_INTEGER
  RETURN BINARY_INTEGER;

  FUNCTION get_DEC
  RETURN DEC;

  FUNCTION get_DECIMAL
  RETURN DECIMAL;

  FUNCTION get_FLOAT
  RETURN FLOAT;

  FUNCTION get_INT
  RETURN INT;

  FUNCTION get_NUMERIC
  RETURN NUMERIC;

  FUNCTION get_PLS_INTEGER
  RETURN PLS_INTEGER;

  FUNCTION get_POSITIVE
  RETURN POSITIVE;

  FUNCTION get_SMALLINT
  RETURN SMALLINT;

  FUNCTION get_CHARACTER
  RETURN CHARACTER;

  FUNCTION get_NCHAR
  RETURN NCHAR;

  FUNCTION get_NVARCHAR2
  RETURN NVARCHAR2;

  FUNCTION get_ROWID
  RETURN ROWID;

  FUNCTION get_STRING
  RETURN STRING;

  FUNCTION get_UROWID
  RETURN UROWID;

  FUNCTION get_VARCHAR
  RETURN VARCHAR;






  /*opb
    param
      name=p_boolean
      datatype=BOOLEAN;
  */
  function data_types(
    p_CHAR IN char,
    p_VARCHAR2 IN varchar2,
    p_number in NUMBER,
    p_integer IN INTEGER,
    p_RAW IN RAW,
    p_date in date,
    p_BLOB in blob,
    p_clob in CLOB,
    p_boolean in VARCHAR2,
    p_VARCHAR2_array in dbms_sql.varchar2_table,
    p_NUMBER_array IN DBMS_SQL.NUMBER_TABLE
  )
  RETURN VARCHAR2;


  function get_from_test_table
  return sys_refcursor;

  /*opb
    param
      name=return
      datatype=cursor?one_of_each_sql_type
      use_data_object_cache=N;
  */
  function get_one_of_each_sql_type
  return sys_refcursor;

end calls8i;
/
create or replace package body calls8i
is
  function echo(
    p_data in varchar2
  )
  return varchar2
  is
  begin
    dbms_output.put_line('echo (function)');

    dbms_output.put_line('p_data=' || p_data);

    return p_data;

  end echo;

  procedure echo(
    p_data in varchar2,
    p_result out varchar2
  )
  is
  begin
    dbms_output.put_line('echo (procedure)');

    dbms_output.put_line('p_data=' || p_data);

    p_result := p_data;

  end echo;

  FUNCTION f_CHAR(
    p_data IN CHAR
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_CHAR');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_VARCHAR2(
    p_data IN VARCHAR2
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_VARCHAR2');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_LONG(
    p_data IN LONG
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_LONG');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_NUMBER(
    p_data IN NUMBER
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_NUMBER');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_INTEGER(
    p_data IN INTEGER
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_INTEGER');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_RAW(
    p_data IN RAW
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_RAW');

    dbms_output.put_line('(RAW)p_data=' || p_data);

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;
/*
  FUNCTION f_LONGRAW(
    p_data IN LONGRAW
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_LONGRAW');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;
*/
  FUNCTION f_DATE(
    p_data IN DATE
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_DATE');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;


  function get_blob
  return BLOB
  is
    l_blob blob;
  begin
    dbms_lob.createtemporary(l_blob, false);

    return l_blob;

  end;

  FUNCTION f_BLOB(
    p_data IN BLOB
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_BLOB');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    dbms_output.put_line('length=' || DBMS_LOB.GETLENGTH(p_data));

    RETURN 'ok';

  END;

  function get_clob
  return CLOB
  is
    l_clob clob;
  begin
    dbms_lob.createtemporary(l_clob, false);

    return l_clob;

  end;

  FUNCTION f_CLOB(
    p_data IN CLOB
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_CLOB');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    dbms_output.put_line(
      '(expect testClobStringThatsNotVeryLarge) p_data=' ||
      dbms_lob.substr(p_data, 100, 1));

    RETURN 'ok';

  END;

  FUNCTION f_SYS_REFCURSOR(
    p_data IN SYS_REFCURSOR
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_SYS_REFCURSOR');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_BOOLEAN(
    p_data IN VARCHAR2
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_BOOLEAN');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_DBMS_SQL_VARCHAR2_TABLE(
    p_data IN DBMS_SQL.VARCHAR2_TABLE
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_DBMS_SQL_VARCHAR2_TABLE');

    IF (p_data.LAST IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data.LAST is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_DBMS_SQL_NUMBER_TABLE(
    p_data IN DBMS_SQL.NUMBER_TABLE
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_DBMS_SQL_NUMBER_TABLE');

    IF (p_data.LAST IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data.LAST is null');
    END IF;

    RETURN 'ok';

  END;








  FUNCTION f_BINARY_INTEGER(
    p_data IN BINARY_INTEGER
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_BINARY_INTEGER');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_DEC(
    p_data IN DEC
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_DEC');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_DECIMAL(
    p_data IN DECIMAL
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_DECIMAL');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_FLOAT(
    p_data IN FLOAT
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_FLOAT');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_INT(
    p_data IN INT
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_INT');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_NUMERIC(
    p_data IN NUMERIC
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_NUMERIC');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_PLS_INTEGER(
    p_data IN PLS_INTEGER
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_PLS_INTEGER');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_POSITIVE(
    p_data IN POSITIVE
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_POSITIVE');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_SMALLINT(
    p_data IN SMALLINT
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_SMALLINT');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_CHARACTER(
    p_data IN CHARACTER
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_CHARACTER');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_NCHAR(
    p_data IN NCHAR
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_NCHAR');

    RETURN 'ok';

  END;

  FUNCTION f_NVARCHAR2(
    p_data IN NVARCHAR2
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_NVARCHAR2');

    RETURN 'ok';

  END;

  FUNCTION f_ROWID(
    p_data IN ROWID
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_ROWID');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    dbms_output.put_line('p_data=' || p_data);

    RETURN 'ok';

  END;

  FUNCTION f_STRING(
    p_data IN STRING
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_STRING');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;

  FUNCTION f_UROWID(
    p_data IN UROWID
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_UROWID');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    dbms_output.put_line('p_data=' || p_data);

    RETURN 'ok';

  END;

  FUNCTION f_VARCHAR(
    p_data IN VARCHAR
  )
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('f_VARCHAR');

    IF (p_data IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_data is null');
    END IF;

    RETURN 'ok';

  END;





  FUNCTION get_CHAR
  RETURN CHAR
  IS
  BEGIN
    dbms_output.put_line('get_CHAR');

    RETURN 78;

  END;

  FUNCTION get_VARCHAR2
  RETURN VARCHAR2
  IS
  BEGIN
    dbms_output.put_line('get_VARCHAR2');

    RETURN 78;

  END;

  FUNCTION get_NUMBER
  RETURN NUMBER
  IS
  BEGIN
    dbms_output.put_line('get_NUMBER');

    RETURN 78;

  END;

  FUNCTION get_INTEGER
  RETURN INTEGER
  IS
  BEGIN
    dbms_output.put_line('get_INTEGER');

    RETURN 78;

  END;

  FUNCTION get_RAW
  RETURN RAW
  IS
  BEGIN
    dbms_output.put_line('get_RAW');

    RETURN '0708';

  END;


  FUNCTION get_DATE
  RETURN DATE
  IS
  BEGIN
    dbms_output.put_line('get_DATE');

    RETURN to_date('23dec1845 23:05:11', 'ddmonyyyy hh24:mi:ss');

  END;



  FUNCTION get_BOOLEAN
  RETURN varchar2
  IS
  BEGIN
    dbms_output.put_line('get_BOOLEAN');

    RETURN 'y';

  END;




  FUNCTION get_BINARY_INTEGER
  RETURN BINARY_INTEGER
  IS
  BEGIN
    dbms_output.put_line('get_BINARY_INTEGER');

    RETURN 78;

  END;

  FUNCTION get_DEC
  RETURN DEC
  IS
  BEGIN
    dbms_output.put_line('get_DEC');

    RETURN 78;

  END;

  FUNCTION get_DECIMAL
  RETURN DECIMAL
  IS
  BEGIN
    dbms_output.put_line('get_DECIMAL');

    RETURN 78;

  END;

  FUNCTION get_FLOAT
  RETURN FLOAT
  IS
  BEGIN
    dbms_output.put_line('get_FLOAT');

    RETURN 78;

  END;

  FUNCTION get_INT
  RETURN INT
  IS
  BEGIN
    dbms_output.put_line('get_INT');

    RETURN 78;

  END;

  FUNCTION get_NUMERIC
  RETURN NUMERIC
  IS
  BEGIN
    dbms_output.put_line('get_NUMERIC');

    RETURN 78;

  END;

  FUNCTION get_PLS_INTEGER
  RETURN PLS_INTEGER
  IS
  BEGIN
    dbms_output.put_line('get_PLS_INTEGER');

    RETURN 78;

  END;

  FUNCTION get_POSITIVE
  RETURN POSITIVE
  IS
  BEGIN
    dbms_output.put_line('get_POSITIVE');

    RETURN 78;

  END;

  FUNCTION get_SMALLINT
  RETURN SMALLINT
  IS
  BEGIN
    dbms_output.put_line('get_SMALLINT');

    RETURN 78;

  END;

  FUNCTION get_CHARACTER
  RETURN CHARACTER
  IS
  BEGIN
    dbms_output.put_line('get_CHARACTER');

    RETURN 78;

  END;

  FUNCTION get_NCHAR
  RETURN NCHAR
  IS
  BEGIN
    dbms_output.put_line('get_NCHAR');

    RETURN null;

  END;

  FUNCTION get_NVARCHAR2
  RETURN NVARCHAR2
  IS
  BEGIN
    dbms_output.put_line('get_NVARCHAR2');

    RETURN null;

  END;

  FUNCTION get_ROWID
  RETURN ROWID
  IS
    l_result rowid;
  BEGIN
    dbms_output.put_line('get_ROWID');

    select rowid into l_result from dual;
    RETURN l_result;

  END;

  FUNCTION get_STRING
  RETURN STRING
  IS
  BEGIN
    dbms_output.put_line('get_STRING');

    RETURN 78;

  END;

  FUNCTION get_UROWID
  RETURN UROWID
  IS
    l_result urowid;
  BEGIN
    dbms_output.put_line('get_UROWID');

    select rowid into l_result from dual;
    RETURN l_result;

  END;

  FUNCTION get_VARCHAR
  RETURN VARCHAR
  IS
  BEGIN
    dbms_output.put_line('get_VARCHAR');

    RETURN 78;

  END;







  function data_types(
    p_CHAR IN char,
    p_VARCHAR2 IN varchar2,
    p_number in NUMBER,
    p_integer IN INTEGER,
    p_RAW IN RAW,
    p_date in date,
    p_BLOB in blob,
    p_clob in CLOB,
    p_boolean in VARCHAR2,
    p_VARCHAR2_array in dbms_sql.varchar2_table,
    p_NUMBER_array IN DBMS_SQL.NUMBER_TABLE
  )
  RETURN VARCHAR2
  IS
  BEGIN
    IF (p_char IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_char is null');
    END IF;

    IF (p_varchar2 IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_varchar2 is null');
    END IF;

    IF (p_number IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_number is null');
    END IF;

    IF (p_integer IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_integer is null');
    END IF;

    IF (p_raw IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_raw is null');
    END IF;

    IF (p_date IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_date is null');
    END IF;

    IF (p_blob IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_blob is null');
    END IF;

    IF (p_clob IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_clob is null');
    END IF;

    IF (p_boolean IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_boolean is null');
    END IF;

    IF (p_varchar2_array IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_varchar2_array is null');
    END IF;

    IF (p_number_array IS NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001, 'p_number_array is null');
    END IF;

    RETURN 'ok';

  END data_types;


  function get_from_test_table
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select * from test_table;
    return l_result;
  end;

  function get_one_of_each_sql_type
  return sys_refcursor
  is
    l_result sys_refcursor;
  begin
    open l_result for
    select * from test_table;
    return l_result;
  end;

end calls8i;
/
