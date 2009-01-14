/*
For testing clear_cached and invalidate_cached properties of an opb comment.
*/
CREATE OR REPLACE PACKAGE cat 
IS
  /*opb-package
  
    field
      name=name
      id=y;
      
    field
      name=type
      datatype=integer
      id=y;
    
    field
      name=last_changed
      datatype=date
      read_only=Y;
    
    field
      name=description
      optional_in_load=Y;
  */
  
  
  /*
  invalidate this instance when update_description is called.
  */
  /*opb
    param
      name=p_name
      field=name;
      
    param
      name=p_type
      field=type;
      
    param
      name=p_description
      field=description;
      
    invalidate_cached
      name=this;
  */
  procedure update_description(
    p_name in varchar2,
    p_type in integer,
    p_description in varchar2);
  
  /*
  clear this instance when delete_cat is called.
  */
  /*opb
    param
      name=p_name
      field=name;
      
    param
      name=p_type
      field=type;
      
    clear_cached
      name=this;
  */
  procedure delete_cat(
    p_name in varchar2,
    p_type in integer);
  
  /*opb
    clear_cached
      name=all;
  */
  procedure clear_cached_all;
  
  /*opb
    invalidate_cached
      name=all;
  */
  procedure invalidate_cached_all;
  
  /*opb
    clear_cached
      name=cat;
  */
  procedure clear_cached_cats;
  
  /*opb
    invalidate_cached
      name=cat;
  */
  procedure invalidate_cached_cats;
  
END cat;
/
CREATE OR REPLACE PACKAGE BODY cat 
IS

  procedure update_description(
    p_name in varchar2,
    p_type in integer,
    p_description in varchar2) is begin null; end;
  
  procedure delete_cat(
    p_name in varchar2,
    p_type in integer) is begin null; end;
    
  procedure clear_cached_all is begin null; end;
  
  procedure invalidate_cached_all is begin null; end;
  
  procedure clear_cached_cats is begin null; end;
  
  procedure invalidate_cached_cats is begin null; end;
  
END cat;
/
