CREATE OR REPLACE PACKAGE BODY logger_flag
AS
  FUNCTION del(
    p_row_id IN VARCHAR2,
    p_old_log_level IN NUMBER,
    p_old_log_user IN VARCHAR2
  )
  RETURN VARCHAR2
  IS
    l_message_summary VARCHAR2(32767);
    l_message_detail VARCHAR2(32767);

  BEGIN
    logger.ms('del');

    DELETE FROM logger_flags
     WHERE rowid = p_row_id
       AND (log_level = p_old_log_level OR
           (log_level IS NULL AND p_old_log_level IS NULL))
       AND (log_user = p_old_log_user OR
           (log_user IS NULL AND p_old_log_user IS NULL));

    IF (SQL%ROWCOUNT = 0)
    THEN
      l_message_summary := 'logger flag not deleted';
      l_message_detail := 'This logger flag may have been deleted or updated by another session';
    ELSE
      l_message_summary := 'logger flag deleted';
    END IF;

    COMMIT;

    messages.add_message(
      messages.message_level_info,
      l_message_summary, l_message_detail);

    RETURN NULL;

  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error('Failed to delete logger flag');

      messages.add_message(
        messages.message_level_error,
        'Failed to delete logger flag',
        SQLERRM);

    RETURN 'error';

  END del;

  FUNCTION ins(
    p_row_id OUT VARCHAR2,
    p_log_level IN NUMBER,
    p_log_user IN VARCHAR2
  )
  RETURN VARCHAR2
  IS
  BEGIN
    logger.ms('ins');

    INSERT INTO logger_flags(
      log_level,
      log_user
    )
    VALUES (
      p_log_level,
      p_log_user
    )
    RETURNING ROWID INTO p_row_id;

    COMMIT;

    messages.add_message(
      messages.message_level_info,
      'logger flag created', NULL);

    RETURN NULL;

  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error('Failed to create logger flag');

      messages.add_message(
        messages.message_level_error,
        'Failed to create logger flag',
        SQLERRM);

    RETURN 'error';

  END ins;

  FUNCTION upd(
    p_row_id IN VARCHAR2,
    p_old_log_level IN NUMBER,
    p_log_level IN NUMBER,
    p_old_log_user IN VARCHAR2,
    p_log_user IN VARCHAR2
  )
  RETURN VARCHAR2
  IS
    l_message_summary VARCHAR2(32767);
    l_message_detail VARCHAR2(32767);

  BEGIN
    logger.ms('upd');

    UPDATE logger_flags
       SET log_level = p_log_level,
           log_user = p_log_user
     WHERE rowid = p_row_id
       AND ((log_level = p_old_log_level) OR
           (log_level IS NULL AND p_old_log_level IS NULL))
       AND ((log_user = p_old_log_user) OR
           (log_user IS NULL AND p_old_log_user IS NULL));

    IF (SQL%ROWCOUNT = 0)
    THEN
      l_message_summary := 'logger flag not updated';
      l_message_detail := 'This logger flag may have been deleted or updated by another session';
    ELSE
      l_message_summary := 'logger flag updated';
    END IF;

    COMMIT;

    messages.add_message(
      messages.message_level_info,
      l_message_summary, l_message_detail);

    RETURN NULL;

  EXCEPTION
    WHEN OTHERS
    THEN
      logger.error('Failed to update logger flag');

      messages.add_message(
        messages.message_level_error,
        'Failed to update logger flag',
        SQLERRM);

    RETURN 'error';

  END upd;

END logger_flag;
/
