PROMPT Cleaning OPB_JSE_DEMO (i.e. dropping all OPB_JSE_DEMO objects)

DECLARE
  l_drop_table_retry_limit INTEGER := 15;

  e_table_or_view_not_found EXCEPTION;
  PRAGMA EXCEPTION_INIT(e_table_or_view_not_found, -00942);

  e_sequence_not_found EXCEPTION;
  PRAGMA EXCEPTION_INIT(e_sequence_not_found, -02289);

  e_object_not_found EXCEPTION;
  PRAGMA EXCEPTION_INIT(e_object_not_found, -04043);

  e_trigger_not_found EXCEPTION;
  PRAGMA EXCEPTION_INIT(e_trigger_not_found, -04080);

  -- ORA-24344 success with compilation error
  e_success_with_compilation_err EXCEPTION;
  PRAGMA EXCEPTION_INIT(e_success_with_compilation_err, -24344);

  /*
    Send some data to dbms_output.
  */
  PROCEDURE p
    (s IN VARCHAR2)
  IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE(s);

  END p;

  /*
    Execute a piece of sql.
  */
  PROCEDURE exec(
    p_sql IN VARCHAR2,
    p_handle_exceptions IN BOOLEAN := FALSE
  )
  IS
  BEGIN
    -- Always feedback the statement that we're about to execute
    p(p_sql);

    IF (p_handle_exceptions)
    THEN
      -- If we're handling exceptions we'll attempt to execute the
      -- statement within an anonymous block, handling 'not found' execptions.
      -- Anything other than e_table_or_view_not_found, e_sequence_not_found,
      -- e_object_not_found or e_trigger_not_found will propogate to the caller
      <<try_sql>>
      BEGIN
        EXECUTE IMMEDIATE p_sql;
        -- Feedback done only if the statement ran without error
        p('Done');

      EXCEPTION
        WHEN e_table_or_view_not_found
        THEN
          p('Table or View not found');

        WHEN e_sequence_not_found
        THEN
          p('Sequence not found');

        WHEN e_object_not_found
        THEN
          p('Object not found');

        WHEN e_trigger_not_found
        THEN
          p('Trigger not found');

        WHEN OTHERS
        THEN
          p(SQLERRM);

      END try_sql;

    ELSE
      -- If we're not handling exceptions, we'll let all exceptions
      -- propogate to the caller
      EXECUTE IMMEDIATE p_sql;
      -- feedback done only if the statement ran without error
      p('Done');

    END IF; -- IF (UPPER(feedback) = yes_C)

  EXCEPTION
    WHEN e_success_with_compilation_err
    THEN
      RAISE_APPLICATION_ERROR(
        -20000,
        'Success with compilation error');

  END exec;

  procedure drop_tables(
    p_handle_exceptions IN BOOLEAN
  )
  is
  begin
    for i in (select *
                from all_objects
               where owner = 'OPB_JSE_DEMO'
                 and object_type = 'TABLE'
                 and object_name not like 'BIN$%')
    loop
      exec('DROP TABLE ' || i.object_name, p_handle_exceptions);
    end loop;
  end;

BEGIN
  dbms_output.enable(1000000);

  exec('PURGE RECYCLEBIN', FALSE);

  for i in (select *
              from all_objects
             where owner = 'OPB_JSE_DEMO'
               and object_type in ('SEQUENCE', 'PACKAGE', 'VIEW', 'SYNONYM', 'TYPE'))
  loop
    exec('DROP ' || i.object_type || ' ' || i.object_name, FALSE);

  end loop;

  for i in 1 .. l_drop_table_retry_limit
  loop
    drop_tables(i != l_drop_table_retry_limit);
  end loop;

  exec('PURGE RECYCLEBIN', FALSE);

END;
/

PROMPT Clean OPB_JSE_DEMO complete
