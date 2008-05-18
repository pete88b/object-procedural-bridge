CREATE OR REPLACE PACKAGE user_defined_collections 
IS

  function echo_number_table(
    p_data in number_table
  )
  return number_table;
  
  procedure simple_in_out(
    p_data in out varchar_table);

  function how_long(
    p_data in varchar_table,
    p_results out varchar_table
  )
  return varchar2;

END user_defined_collections;
/
CREATE OR REPLACE PACKAGE BODY user_defined_collections 
IS

  function echo_number_table(
    p_data in number_table
  )
  return number_table
  is
  begin
    logger.entering('echo_number_table');
    if (p_data is null)
    then
      logger.fb('p_data is null');
    else
      logger.fb('p_data is not null. last=' || p_data.last);
    end if;
    return p_data;
  end;
  
  procedure simple_in_out(
    p_data in out varchar_table
  )
  is
  begin
    logger.entering('simple_in_out');
    if (p_data is null)
    then
      logger.fb('p_data is null');
    else
      logger.fb('p_data is not null. last=' || p_data.last);
    end if;
  end;
  
  function how_long(
    p_data in varchar_table,
    p_results out varchar_table
  )
  return varchar2
  is
  begin
    if (p_data.last is not null)
    then
      p_results := varchar_table();
      p_results.extend(p_data.last);
      for i in p_data.first .. p_data.last
      loop
        p_results(i) := length(p_data(i));
        
      end loop;
    
      return 'notnull';
    
    end if;
    
    return 'null';
    
  end;
  
END user_defined_collections;
/