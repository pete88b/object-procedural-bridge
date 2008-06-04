SET VERIFY OFF

@plsql_base/logger/build.sql
@plsql_base/constants/build.sql
@plsql_base/event_mediator/build.sql
@plsql_base/messages/build.sql

@opb/build.sql

@plsql_base/logger/admin/build.sql

PROMPT adding opb_messages as an observer of the message event
BEGIN
  event_mediator.add_observer('message', 'opb_messages');
EXCEPTION
  WHEN DUP_VAL_ON_INDEX
  THEN
    -- opb_messages is already an observer of the message event
    NULL;
END;
/

@plsql_base/exceptions/build.sql

@plsql_base/types/build.sql

@plsql_base/properties/build.sql

@plsql_base/properties/admin/build.sql

@plsql_base/permissions/build.sql

BEGIN
  DBMS_OUTPUT.PUT_LINE('Loading properties for permissions');
  properties.set_property('permission', 'case_of_permission', 'sensitive');
  properties.set_locked('permission', 'Y');
END;
/

@load_permissions.sql

@exception_demo.pck

