CREATE OR REPLACE PACKAGE messages 
IS

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type debug.
  */
  PROCEDURE add_debug_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type error.
  */
  PROCEDURE add_error_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type fatal.
  */
  PROCEDURE add_fatal_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type info.
  */
  PROCEDURE add_info_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type warning.
  */
  PROCEDURE add_warning_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  );

  
END messages;
/
CREATE OR REPLACE PACKAGE BODY messages 
IS
  
  --pri xxx
  PROCEDURE add_message(
    p_call_name IN VARCHAR2,
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.ms('add_message');
    
    logger.fb(
      'p_call_name=' || p_call_name ||
      ', p_summary=' || p_summary ||
      ', p_detail=' || p_detail);
      
    event_mediator.event(
      'message',
      p_call_name || '(''' || p_summary || ''', ''' || p_detail || ''')');
    
  END;
  
  /*
    Sends a "message" event via the event_mediator to add a 
    message of type debug.
  */
  PROCEDURE add_debug_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.ms('add_debug_message');
    
    add_message('add_debug_message', p_summary, p_detail);
    
  END add_debug_message;

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type error.
  */
  PROCEDURE add_error_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.ms('add_error_message');
    
    add_message('add_error_message', p_summary, p_detail);
    
  END add_error_message;

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type fatal.
  */
  PROCEDURE add_fatal_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.ms('add_fatal_message');
    
    add_message('add_fatal_message', p_summary, p_detail);
    
  END add_fatal_message;

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type info.
  */
  PROCEDURE add_info_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.ms('add_info_message');
    
    add_message('add_info_message', p_summary, p_detail);
    
  END add_info_message;

  /*
    Sends a "message" event via the event_mediator to add a 
    message of type warning.
  */
  PROCEDURE add_warning_message(
    p_summary IN VARCHAR2,
    p_detail IN VARCHAR2
  )
  IS
  BEGIN
    logger.ms('add_warning_message');
    
    add_message('add_warning_message', p_summary, p_detail);
    
  END add_warning_message;
  
END messages;
/
