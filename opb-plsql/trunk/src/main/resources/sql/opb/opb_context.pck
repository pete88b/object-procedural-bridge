CREATE OR REPLACE PACKAGE opb_context 
IS
  --xxx todo add global message support to opb_context?
  --xxx i.e. message can be added info/warning for everyone to see. not cleared when active phase ends
  --xxx provide effective from time / expires time
  --xxx access through opbContext

  --xxx return a client ID. use this as part of the session / when creating sessions???
  -- clients can specify context name
  -- published an opb_context_started event to call opb_context_started(ctx name) on all listeners
  PROCEDURE start_context(
    p_context_name IN VARCHAR2,
    p_remote_host IN VARCHAR2,
    p_remote_user_name IN VARCHAR2,
    p_stop_context_first IN VARCHAR2); -- Y/N constants.yes / constants.no

  -- published an opb_context_stopping event to call opb_context_stopping(ctx name) on all listeners
  PROCEDURE stop_context(
    p_context_name IN VARCHAR2,
    p_remote_host IN VARCHAR2,
    p_remote_user_name IN VARCHAR2);

  --xxx stop_all_contexts???
  --xxx clear all ctx data
  
END opb_context;
/
CREATE OR REPLACE PACKAGE BODY opb_context 
IS

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
    
    UPDATE opb_context_data
    SET    stopped = SYSDATE
    WHERE  stopped IS NULL
    AND    context_name = p_context_name;
    
    COMMIT;
    
    --xxx block all connections for context???
    
  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error('Failed to stop context');
      RAISE;
    
  END stop_context;
  
END opb_context;
/
