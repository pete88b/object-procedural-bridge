CREATE OR REPLACE PACKAGE opb_context 
IS
  

  /*
    Starts a context.
    
    The context is saved as started in the table opb_context_data and
    an opb_context_started event is published after the context has been 
    started.
    
    The opb_context_started event is published via the event_mediator and
    will call opb_context_started(p_context_name) on all listeners.
    
    Commits: Yes
    
    parameters
      p_context_name
        The name of the context.
      
      p_remote_host
        An identifier of the remote host that is starting the context.
        
      p_remote_user_name
        An identifier of the remote user that is starting the context.
        
      p_stop_context_first
        Pass 'Y' (or constants.yes) to call stop context before
        starting the context.
  */
  PROCEDURE start_context(
    p_context_name IN VARCHAR2,
    p_remote_host IN VARCHAR2,
    p_remote_user_name IN VARCHAR2,
    p_stop_context_first IN VARCHAR2);

  
  /*
    Stops a context.
    
    A stop date is saved for the context in the table opb_context_data and
    an opb_context_stopping event is published before the context is stopped.
    
    The opb_context_stopping event is published via the event_mediator and
    will call opb_context_stopping(p_context_name) on all listeners.
    
    Commits: Yes
    
    parameters
      p_context_name
        The name of the context.
      
      p_remote_host
        An identifier of the remote host that is starting the context.
        
      p_remote_user_name
        An identifier of the remote user that is starting the context.
  */
  PROCEDURE stop_context(
    p_context_name IN VARCHAR2,
    p_remote_host IN VARCHAR2,
    p_remote_user_name IN VARCHAR2);
  
END opb_context;
/
CREATE OR REPLACE PACKAGE BODY opb_context 
IS

  /*
    Starts a context.
  */
  PROCEDURE start_context(
    p_context_name IN VARCHAR2,
    p_remote_host IN VARCHAR2,
    p_remote_user_name IN VARCHAR2,
    p_stop_context_first IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('start_context');
    
    IF (p_stop_context_first = constants.yes)
    THEN
      stop_context(p_context_name, p_remote_host, p_remote_user_name);
      
    END IF;
    
    logger.info(
      'Starting context: context name=' || p_context_name ||
      ', remote host=' || p_remote_host || 
      ', remote user name=' || p_remote_user_name ||
      ', stop first=' || p_stop_context_first ||
      ', DB user name=' || USER);
    
    INSERT INTO opb_context_data(
      context_name, remote_host, remote_user_name,
      started, stopped)
    VALUES (
      p_context_name, p_remote_host, p_remote_user_name,
      SYSDATE, NULL);
      
    COMMIT;
    
    event_mediator.event(
      'opb_context_started', 
      'opb_context_started(''' || p_context_name || ''')');
    
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error('Failed to start context');
      RAISE;
    
  END start_context;


  /*
    Stops a context.
  */
  PROCEDURE stop_context(
    p_context_name IN VARCHAR2,
    p_remote_host IN VARCHAR2,
    p_remote_user_name IN VARCHAR2
  )
  IS
  BEGIN
    logger.entering('stop_context');
    
    logger.info(
      'Stopping context: context name=' || p_context_name ||
      ', remote host=' || p_remote_host || 
      ', remote user name=' || p_remote_user_name ||
      ', DB user name=' || USER);
    
    event_mediator.event(
      'opb_context_stopping',
      'opb_context_stopping''' || p_context_name || ''')');
    
    opb_messages.clear_messages_for_context(p_context_name);
    
    opb_session.clear_session_data(p_context_name);
    
    -- set the stopped date for this context
    UPDATE opb_context_data
       SET stopped = SYSDATE
     WHERE stopped IS NULL
       AND context_name = p_context_name;
    
    COMMIT;
    
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error('Failed to stop context');
      RAISE;
    
  END stop_context;
  
END opb_context;
/
