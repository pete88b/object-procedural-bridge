******************************
readme for opb-plsq unit tests
******************************

Database connection details for the test suite can be found in
helpers.TestHelper.java. See TestHelper#getOracleDataSource().

The default connection details are;

  url=jdbc:oracle:thin:@//localhost:1521/xe
  user=opb_test
  password=weak_pw

This URL will work if you have a local copy of Oracle XE running.
To create the opb_test user;

  CREATE USER opb_test DEFAULT TABLESPACE users IDENTIFIED BY weak_pw;

Note: "DEFAULT TABLESPACE users" can be ommited but you don't want opb_test to
use your system tablespace.

The simplest way to ensure that the test user has enough privs is to grant it
the DBA role. e.g.

  GRANT DBA TO opb_test;

The unit tests for this project rely on several database objects.
To create the necessary objects, run sql/test/build.sql via SQL*Plus using the
connection details from helpers.TestHelper.java.


If any of these tests fail with an AbstractMethodError or
ClassNotFoundException, make sure all generated code has been compiled and try
running the tests again.
