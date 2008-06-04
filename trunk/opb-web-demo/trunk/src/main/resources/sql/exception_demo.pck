create or replace package exception_demo
is

  procedure raise_no_data_found;


end;
/

create or replace package body exception_demo
is

  procedure raise_no_data_found
  is
  begin
    raise no_data_found;
  exception
    when others
    then
      logger.error('logged in "when others" handler');
      raise;
  end;

end;
/

