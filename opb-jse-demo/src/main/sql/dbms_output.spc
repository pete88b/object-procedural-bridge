create or replace package sys.dbms_output as

-- DE-HEAD     <- tell SED where to cut when generating fixed package

  ------------
  --  OVERVIEW
  --
  --  These procedures accumulate information in a buffer (via "put" and
  --  "put_line") so that it can be retrieved out later (via "get_line" or
  --  "get_lines").  If this package is disabled then all
  --  calls to this package are simply ignored.  This way, these routines
  --  are only active when the client is one that is able to deal with the
  --  information.  This is good for debugging, or SP's that want to want
  --  to display messages or reports to sql*dba or plus (like 'describing
  --  procedures', etc.).  The default buffer size is 20000 bytes.  The
  --  minimum is 2000 and the maximum is 1,000,000.

  -----------
  --  EXAMPLE
  --
  --  A trigger might want to print out some debugging information.  To do
  --  do this the trigger would do
  --    dbms_output.put_line('I got here:'||:new.col||' is the new value');
  --  If the client had enabled the dbms_output package then this put_line
  --  would be buffered and the client could, after executing the statement
  --  (presumably some insert, delete or update that caused the trigger to
  --  fire) execute
  --    begin dbms_output.get_line(:buffer, :status); end;
  --  to get the line of information back.  It could then display the
  --  buffer on the screen.  The client would repeat calls to get_line
  --  until status came back as non-zero.  For better performance, the
  --  client would use calls to get_lines which can return an array of
  --  lines.
  --
  --  SQL*DBA and SQL*PLUS, for instance, implement a 'SET SERVEROUTPUT
  --  ON' command so that they know whether to make calls to get_line(s)
  --  after issuing insert, update, delete or anonymous PL/SQL calls
  --  (these are the only ones that can cause triggers or stored procedures
  --  to be executed).

  ------------
  --  SECURITY
  --
  --  At the end of this script, a public synonym (dbms_output) is created
  --  and execute permission on this package is granted to public.

  ----------------------------
  --  PROCEDURES AND FUNCTIONS
  --
  procedure enable (buffer_size in integer default 20000);
  pragma restrict_references(enable,WNDS,RNDS);
  --  Enable calls to put, put_line, new_line, get_line and get_lines.
  --    Calls to these procedures are noops if the package has
  --    not been enabled.  Set default amount of information to buffer.
  --    Cleanup data buffered from any dead sessions.  Multiple calls to
  --    enable are allowed.
  --  Input parameters:
  --    buffer_size
  --      Amount of information, in bytes, to buffer.  Varchar2, number and
  --      date items are stored in their internal representation.  The
  --      information is stored in the SGA. An error is raised if the
  --      buffer size is exceeded.  If there are multiple calls to enable,
  --      then the buffer_size is generally the largest of the values
  --      specified, and will always be >= than the smallest value
  --      specified.  Currently a more accurate determination is not
  --      possible.  The maximum size is 1,000,000, the minimum is 2000.

  procedure disable;
  pragma restrict_references(disable,WNDS,RNDS);
  --  Disable calls to put, put_line, new_line, get_line and get_lines.
  --    Also purge the buffer of any remaining information.

  procedure put(a varchar2);
  pragma restrict_references(put,WNDS,RNDS);
  --  Put a piece of information in the buffer.  When retrieved by
  --    get_line(s), the number and date items will be formated with
  --    to_char using the default formats. If you want another format
  --    then format it explicitly.
  --  Input parameters:
  --    a
  --      Item to buffer

  procedure put_line(a varchar2);
  pragma restrict_references(put_line,WNDS,RNDS);
  --  Put a piece of information in the buffer followed by an end-of-line
  --    marker.  When retrieved by get_line(s), the number and date items
  --    will be formated with to_char using the default formats.  If you
  --    want another format then format it explicitly. get_line(s) return
  --    "lines" as delimited by "newlines". So every call to put_line or
  --    new_line will generate a line that will be returned by get_line(s).
  --  Input parameters:
  --    a
  --      Item to buffer
  --  Errors raised:
  --    -20000, ORU-10027: buffer overflow, limit of <buf_limit> bytes.
  --    -20000, ORU-10028:line length overflow, limit of 32767 bytes per line.

  procedure new_line;
  pragma restrict_references(new_line,WNDS,RNDS);
  --  Put an end-of-line marker.  get_line(s) return "lines" as delimited
  --    by "newlines".  So every call to put_line or new_line will generate
  --    a line that will be returned by get_line(s).

  procedure get_line(line out varchar2, status out integer);
  pragma restrict_references(get_line,WNDS,RNDS);
  --  Get a single line back that has been buffered.  The lines are
  --    delimited by calls to put_line or new_line.  The line will be
  --    constructed taking all the items up to a newline, converting all
  --    the items to varchar2, and concatenating them into a single line.
  --    If the client fails to retrieve all lines before the next put,
  --    put_line or new_line, the non-retrieved lines will be discarded.
  --    This is so if the client is interrupted while selecting back
  --    the information, there will not be junk left over which would
  --    look like it was part of the NEXT set of lines.
  --  Output parameters:
  --    line
  --      This line will hold the line - it may be up to 32767 bytes long.
  --    status
  --      This will be 0 upon successful completion of the call.  1 means
  --      that there are no more lines.

  type chararr is table of varchar2(32767) index by binary_integer;
  procedure get_lines(lines out chararr, numlines in out integer);
  pragma restrict_references(get_lines,WNDS,RNDS);
  --  Get multiple lines back that have been buffered.  The lines are
  --    delimited by calls to put_line or new_line.  The line will be
  --    constructed taking all the items up to a newline, converting all
  --    the items to varchar2, and concatenating them into a single line.
  --    Once get_lines is executed, the client should continue to retrieve
  --    all lines because the next put, put_line or new_line will first
  --    purge the buffer of leftover data.  This is so if the client is
  --    interrupted while selecting back the information, there will not
  --    be junk left over.
  --  Input parameters:
  --    numlines
  --      This is the maximum number of lines that the caller is prepared
  --      to accept.  This procedure will not return more than this number
  --      of lines.
  --  Output parameters:
  --    lines
  --      This array will line will hold the lines - they may be up to 32767
  --      bytes long each.  The array is indexed beginning with 0 and
  --      increases sequentially.  From a 3GL host program the array begins
  --      with whatever is the convention for that language.
  --    numlines
  --      This will be the number of lines actually returned.  If it is
  --      less than the value passed in, then there are no more lines.

  --FIXED_ONLYTYPE dbmsoutput_linesarray IS VARRAY(2147483647) OF
  --FIXED_ONLY     VARCHAR2(32767);
  procedure get_lines(lines out dbmsoutput_linesarray, numlines in out integer);
  --  get_lines overload with dbmsoutput_linesarray varray type for lines.
  --  It is recommended that you use this overload in a 3GL host program to
  --  execute get_lines from a PL/SQL anonymous block.
  pragma restrict_references(get_lines,WNDS,RNDS);

  pragma TIMESTAMP('2000-06-22:11:21:00');

end;

-- CUT_HERE    <- tell sed where to chop off the rest
