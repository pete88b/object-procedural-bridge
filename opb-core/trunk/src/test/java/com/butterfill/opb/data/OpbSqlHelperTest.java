/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.butterfill.opb.data;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import junit.framework.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.Set;
import com.butterfill.opb.util.OpbBooleanHelper;
import helpers.TestHelper;

/**
 *
 * @author Peter Butterfill
 */
public class OpbSqlHelperTest extends TestCase {
    
    public OpbSqlHelperTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public void testCloseResultSet() {
        System.out.format("close(ResultSet)%n");
        
        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        ResultSet rs = null;
        
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        
        sourceLogger = Logger.getLogger("x");
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        
        sourceClass = "Test";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        
        sourceMethod = "testCloseResultSet()";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        
        rs = new ResultSetCloseOk();
        assertFalse(((ResultSetCloseOk)rs).closed);
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        assertTrue(((ResultSetCloseOk)rs).closed);
        
        rs = new ResultSetCloseThrowSqlEx();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        
        rs = new ResultSetCloseThrowRuntimeEx();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, rs);
        
    }

    public void testCloseStatement() {
        System.out.format("close(Statement)%n");
        
        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        Statement stmt = null;
        
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        
        sourceLogger = Logger.getLogger("name");
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        
        sourceClass = getClass().getName();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        
        sourceMethod = "meth";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        
        stmt = new StatementCloseOk();
        assertFalse(((StatementCloseOk)stmt).closed);
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        assertTrue(((StatementCloseOk)stmt).closed);
        
        stmt = new StatementCloseThrowSqlEx();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        
        stmt = new StatementCloseThrowRuntimeEx();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, stmt);
        
    }
    
    public void testCloseConnection() {
        System.out.format("close(Connection)%n");
        
        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        Connection con = null;
        
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        
        sourceLogger = Logger.getAnonymousLogger();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        
        sourceClass = "x";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        
        sourceMethod = "";
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        
        con = new ConnectionCloseOk();
        assertFalse(((ConnectionCloseOk)con).closed);
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        assertTrue(((ConnectionCloseOk)con).closed);
        
        con = new ConnectionCloseThrowRuntimeEx();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
     
        con = new ConnectionCloseThrowSqlEx();
        OpbSqlHelper.close(
                sourceLogger, sourceClass, sourceMethod, con);
        
    }
    
    /**
     * See test cases for overloaded method calls.
     */
    public void testClose() {
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="rs section">
    
    static class ResultSetCloseOk implements ResultSet {
        public boolean next() throws SQLException {
            throw new SQLException("invalid opperation");
        }
        public boolean closed = false;
        public void close() throws SQLException {
            closed = true;
        }

        public boolean wasNull() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public String getString(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean getBoolean(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public byte getByte(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public short getShort(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getInt(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public long getLong(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public float getFloat(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public double getDouble(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        @Deprecated
        public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public byte[] getBytes(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Date getDate(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Time getTime(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Timestamp getTimestamp(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public InputStream getAsciiStream(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        @Deprecated
        public InputStream getUnicodeStream(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public InputStream getBinaryStream(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public String getString(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean getBoolean(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public byte getByte(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public short getShort(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getInt(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public long getLong(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public float getFloat(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public double getDouble(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        @Deprecated
        public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public byte[] getBytes(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Date getDate(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Time getTime(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Timestamp getTimestamp(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public InputStream getAsciiStream(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        @Deprecated
        public InputStream getUnicodeStream(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public InputStream getBinaryStream(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public SQLWarning getWarnings() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void clearWarnings() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public String getCursorName() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public ResultSetMetaData getMetaData() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Object getObject(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Object getObject(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int findColumn(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Reader getCharacterStream(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Reader getCharacterStream(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public BigDecimal getBigDecimal(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean isBeforeFirst() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean isAfterLast() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean isFirst() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean isLast() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void beforeFirst() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void afterLast() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean first() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean last() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean absolute(int row) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean relative(int rows) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean previous() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void setFetchDirection(int direction) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getFetchDirection() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void setFetchSize(int rows) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getFetchSize() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getType() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public int getConcurrency() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean rowUpdated() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean rowInserted() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public boolean rowDeleted() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateNull(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBoolean(int columnIndex, boolean x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateByte(int columnIndex, byte x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateShort(int columnIndex, short x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateInt(int columnIndex, int x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateLong(int columnIndex, long x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateFloat(int columnIndex, float x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateDouble(int columnIndex, double x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateString(int columnIndex, String x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBytes(int columnIndex, byte[] x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateDate(int columnIndex, Date x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateTime(int columnIndex, Time x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateObject(int columnIndex, Object x, int scale) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateObject(int columnIndex, Object x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateNull(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBoolean(String columnName, boolean x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateByte(String columnName, byte x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateShort(String columnName, short x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateInt(String columnName, int x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateLong(String columnName, long x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateFloat(String columnName, float x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateDouble(String columnName, double x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBigDecimal(String columnName, BigDecimal x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateString(String columnName, String x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBytes(String columnName, byte[] x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateDate(String columnName, Date x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateTime(String columnName, Time x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateTimestamp(String columnName, Timestamp x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateAsciiStream(String columnName, InputStream x, int length) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBinaryStream(String columnName, InputStream x, int length) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateCharacterStream(String columnName, Reader reader, int length) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateObject(String columnName, Object x, int scale) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateObject(String columnName, Object x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void insertRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void deleteRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void refreshRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void cancelRowUpdates() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void moveToInsertRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void moveToCurrentRow() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Statement getStatement() throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Ref getRef(int i) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Blob getBlob(int i) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Clob getClob(int i) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Array getArray(int i) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Object getObject(String colName, Map<String, Class<?>> map) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Ref getRef(String colName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Blob getBlob(String colName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Clob getClob(String colName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Array getArray(String colName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Date getDate(int columnIndex, Calendar cal) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Date getDate(String columnName, Calendar cal) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Time getTime(int columnIndex, Calendar cal) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Time getTime(String columnName, Calendar cal) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public Timestamp getTimestamp(String columnName, Calendar cal) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public URL getURL(int columnIndex) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public URL getURL(String columnName) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateRef(int columnIndex, Ref x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateRef(String columnName, Ref x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBlob(int columnIndex, Blob x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateBlob(String columnName, Blob x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateClob(int columnIndex, Clob x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateClob(String columnName, Clob x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateArray(int columnIndex, Array x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public void updateArray(String columnName, Array x) throws SQLException {
            throw new SQLException("invalid opperation");
        }

        public RowId getRowId(int arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public RowId getRowId(String arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateRowId(int arg0, RowId arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateRowId(String arg0, RowId arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public int getHoldability() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isClosed() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNString(int arg0, String arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNString(String arg0, String arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNClob(int arg0, NClob arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNClob(String arg0, NClob arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public NClob getNClob(int arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public NClob getNClob(String arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public SQLXML getSQLXML(int arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public SQLXML getSQLXML(String arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public String getNString(int arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public String getNString(String arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Reader getNCharacterStream(int arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Reader getNCharacterStream(String arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateCharacterStream(int arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateCharacterStream(String arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBlob(int arg0, InputStream arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateBlob(String arg0, InputStream arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateClob(int arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateClob(String arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNClob(int arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void updateNClob(String arg0, Reader arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public <T> T unwrap(Class<T> arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isWrapperFor(Class<?> arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    static class ResultSetCloseThrowSqlEx extends ResultSetCloseOk {
        public void close() throws SQLException {
            throw new SQLException("");
        }
    }
    
    static class ResultSetCloseThrowRuntimeEx extends ResultSetCloseOk {
        public void close() throws SQLException {
            throw new RuntimeException("");
        }   
    }
    
    // </editor-fold> End of rs Section
    
    // <editor-fold defaultstate="collapsed" desc="stmt section">
    
    static class StatementCloseOk implements Statement {
        public ResultSet executeQuery(String sql) throws SQLException { throw new SQLException("yyy");
        }

        public int executeUpdate(String sql) throws SQLException { throw new SQLException("yyy");
        }
        public boolean closed = false;
        public void close() throws SQLException { 
            closed = true;
        }

        public int getMaxFieldSize() throws SQLException { throw new SQLException("yyy");
        }

        public void setMaxFieldSize(int max) throws SQLException { throw new SQLException("yyy");
        }

        public int getMaxRows() throws SQLException { throw new SQLException("yyy");
        }

        public void setMaxRows(int max) throws SQLException { throw new SQLException("yyy");
        }

        public void setEscapeProcessing(boolean enable) throws SQLException { throw new SQLException("yyy");
        }

        public int getQueryTimeout() throws SQLException { throw new SQLException("yyy");
        }

        public void setQueryTimeout(int seconds) throws SQLException { throw new SQLException("yyy");
        }

        public void cancel() throws SQLException { throw new SQLException("yyy");
        }

        public SQLWarning getWarnings() throws SQLException { throw new SQLException("yyy");
        }

        public void clearWarnings() throws SQLException { throw new SQLException("yyy");
        }

        public void setCursorName(String name) throws SQLException { throw new SQLException("yyy");
        }

        public boolean execute(String sql) throws SQLException { throw new SQLException("yyy");
        }

        public ResultSet getResultSet() throws SQLException { throw new SQLException("yyy");
        }

        public int getUpdateCount() throws SQLException { throw new SQLException("yyy");
        }

        public boolean getMoreResults() throws SQLException { throw new SQLException("yyy");
        }

        public void setFetchDirection(int direction) throws SQLException { throw new SQLException("yyy");
        }

        public int getFetchDirection() throws SQLException { throw new SQLException("yyy");
        }

        public void setFetchSize(int rows) throws SQLException { throw new SQLException("yyy");
        }

        public int getFetchSize() throws SQLException { throw new SQLException("yyy");
        }

        public int getResultSetConcurrency() throws SQLException { throw new SQLException("yyy");
        }

        public int getResultSetType() throws SQLException { throw new SQLException("yyy");
        }

        public void addBatch(String sql) throws SQLException { throw new SQLException("yyy");
        }

        public void clearBatch() throws SQLException { throw new SQLException("yyy");
        }

        public int[] executeBatch() throws SQLException { throw new SQLException("yyy");
        }

        public Connection getConnection() throws SQLException { throw new SQLException("yyy");
        }

        public boolean getMoreResults(int current) throws SQLException { throw new SQLException("yyy");
        }

        public ResultSet getGeneratedKeys() throws SQLException { throw new SQLException("yyy");
        }

        public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException { throw new SQLException("yyy");
        }

        public int executeUpdate(String sql, int[] columnIndexes) throws SQLException { throw new SQLException("yyy");
        }

        public int executeUpdate(String sql, String[] columnNames) throws SQLException { throw new SQLException("yyy");
        }

        public boolean execute(String sql, int autoGeneratedKeys) throws SQLException { throw new SQLException("yyy");
        }

        public boolean execute(String sql, int[] columnIndexes) throws SQLException { throw new SQLException("yyy");
        }

        public boolean execute(String sql, String[] columnNames) throws SQLException { throw new SQLException("yyy");
        }

        public int getResultSetHoldability() throws SQLException { throw new SQLException("yyy");
        }

        public boolean isClosed() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void setPoolable(boolean arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isPoolable() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public <T> T unwrap(Class<T> arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isWrapperFor(Class<?> arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    static class StatementCloseThrowSqlEx extends StatementCloseOk {
        public void close() throws SQLException {
            throw new SQLException("");
        }
    }
    
    static class StatementCloseThrowRuntimeEx extends StatementCloseOk {
        public void close() throws SQLException {
            throw new RuntimeException("");
        }
    }
    
    // </editor-fold> End of stmt Section
    
    // <editor-fold defaultstate="collapsed" desc="con section">
    
    static class ConnectionCloseOk implements Connection {
        public Statement createStatement() throws SQLException { throw new SQLException("zzz");
        }

        public PreparedStatement prepareStatement(String sql) throws SQLException { throw new SQLException("zzz");
        }

        public CallableStatement prepareCall(String sql) throws SQLException { throw new SQLException("zzz");
        }

        public String nativeSQL(String sql) throws SQLException { throw new SQLException("zzz");
        }

        public void setAutoCommit(boolean autoCommit) throws SQLException { throw new SQLException("zzz");
        }

        public boolean getAutoCommit() throws SQLException { throw new SQLException("zzz");
        }

        public void commit() throws SQLException { throw new SQLException("zzz");
        }

        public void rollback() throws SQLException { throw new SQLException("zzz");
        }
        public boolean closed = false;
        public void close() throws SQLException { 
            closed = true;
        }

        public boolean isClosed() throws SQLException { throw new SQLException("zzz");
        }

        public DatabaseMetaData getMetaData() throws SQLException { throw new SQLException("zzz");
        }

        public void setReadOnly(boolean readOnly) throws SQLException { throw new SQLException("zzz");
        }

        public boolean isReadOnly() throws SQLException { throw new SQLException("zzz");
        }

        public void setCatalog(String catalog) throws SQLException { throw new SQLException("zzz");
        }

        public String getCatalog() throws SQLException { throw new SQLException("zzz");
        }

        public void setTransactionIsolation(int level) throws SQLException { throw new SQLException("zzz");
        }

        public int getTransactionIsolation() throws SQLException { throw new SQLException("zzz");
        }

        public SQLWarning getWarnings() throws SQLException { throw new SQLException("zzz");
        }

        public void clearWarnings() throws SQLException { throw new SQLException("zzz");
        }

        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException { throw new SQLException("zzz");
        }

        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException { throw new SQLException("zzz");
        }

        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException { throw new SQLException("zzz");
        }

        public Map<String, Class<?>> getTypeMap() throws SQLException { throw new SQLException("zzz");
        }

        public void setTypeMap(Map<String, Class<?>> map) throws SQLException { throw new SQLException("zzz");
        }

        public void setHoldability(int holdability) throws SQLException { throw new SQLException("zzz");
        }

        public int getHoldability() throws SQLException { throw new SQLException("zzz");
        }

        public Savepoint setSavepoint() throws SQLException { throw new SQLException("zzz");
        }

        public Savepoint setSavepoint(String name) throws SQLException { throw new SQLException("zzz");
        }

        public void rollback(Savepoint savepoint) throws SQLException { throw new SQLException("zzz");
        }

        public void releaseSavepoint(Savepoint savepoint) throws SQLException { throw new SQLException("zzz");
        }

        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException { throw new SQLException("zzz");
        }

        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException { throw new SQLException("zzz");
        }

        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException { throw new SQLException("zzz");
        }

        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException { throw new SQLException("zzz");
        }

        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException { throw new SQLException("zzz");
        }

        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException { throw new SQLException("zzz");
        }

        public Clob createClob() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Blob createBlob() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public NClob createNClob() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public SQLXML createSQLXML() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isValid(int arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void setClientInfo(Properties arg0) throws SQLClientInfoException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public String getClientInfo(String arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Properties getClientInfo() throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public <T> T unwrap(Class<T> arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isWrapperFor(Class<?> arg0) throws SQLException {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    static class ConnectionCloseThrowSqlEx extends ConnectionCloseOk {
        public void close() throws SQLException {
            throw new SQLException("zzz");
        }
    }
    
    static class ConnectionCloseThrowRuntimeEx extends ConnectionCloseOk {
        public void close() throws SQLException {
            throw new RuntimeException("zzz");
        }
    }
    
    // </editor-fold> End of con Section

    public static Test suite() {
        TestSuite suite = new TestSuite(OpbSqlHelperTest.class);
        
        return suite;
    }

    /**
     * Test of getReTryableErrorCodes method, of class com.butterfill.opb.data.OpbSqlHelper.
     */
    public void testGetReTryableErrorCodes() {
        System.out.println("getReTryableErrorCodes");
        
        Set<Integer> result = OpbSqlHelper.getReTryableErrorCodes();
        assertEquals(2, result.size());
        assertTrue(result.contains(4061));
        assertTrue(result.contains(4068));
        
    }

    /**
     * Test of execute method, of class com.butterfill.opb.data.OpbSqlHelper.
     */
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        Logger sourceLogger = null;
        String sourceClass = null;
        String sourceMethod = null;
        CallableStatement statement = null;
        
        boolean created = false;
        
        try {
            try {
                OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
                fail();
            } catch (NullPointerException ex) {
                //ok
            }

            Connection con2 = TestHelper.getOracleDataSource().getConnection();

            CallableStatement statement2 = con2.prepareCall(
                    "BEGIN" +
                    "  EXECUTE IMMEDIATE " +
                    "  'CREATE PACKAGE opb_sql_helper_test AS " +
                    "     call_count NUMBER := 0;" +
                    "     PROCEDURE x; " +
                    "   END;';" +
                    "END;");
            statement2.execute();
            statement2 = con2.prepareCall(
                    "BEGIN" +
                    "  EXECUTE IMMEDIATE " +
                    "  'CREATE PACKAGE BODY opb_sql_helper_test AS " +
                    "     PROCEDURE x IS BEGIN " +
                    "       call_count := call_count + 1; " +
                    "     END; " +
                    "   END;';" +
                    "END;");
            statement2.execute();
            
            created = true;
            
            Connection con = TestHelper.getOracleDataSource().getConnection();
            
            statement = con.prepareCall("{ CALL opb_sql_helper_test.x }");
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);

            sourceLogger = Logger.getLogger("OpbSqlHelperTest");
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            
            sourceClass = "OpbSqlHelperTest";
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            
            sourceMethod = "testExecute()";
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            
            statement = con.prepareCall("{ CALL opb_sql_helper_testX }");
            try {
                OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
                fail();
            } catch (SQLException ex) {
                //ok
            }

            statement = con.prepareCall("{ CALL opb_sql_helper_test.x }");
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            statement.execute();
            
            // re-create package to make statement.execute() fail due to
            // existing state  discarded
            statement2 = con2.prepareCall(
                    "BEGIN" +
                    "  EXECUTE IMMEDIATE " +
                    "  'CREATE OR REPLACE PACKAGE opb_sql_helper_test AS " +
                    "     /* */" +
                    "     call_count NUMBER := 0;" +
                    "     PROCEDURE x; " +
                    "   END;';" +
                    "END;");
            statement2.execute();
            
            try {
                statement.execute();
                fail();
            } catch (SQLException ex) {
                //ok
            }
            
            statement = con.prepareCall("{ CALL opb_sql_helper_test.x }");
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            statement.execute();
            
            statement2 = con2.prepareCall(
                    "BEGIN" +
                    "  EXECUTE IMMEDIATE " +
                    "  'CREATE OR REPLACE PACKAGE opb_sql_helper_test AS " +
                    "     /* comment 2 */" +
                    "     call_count NUMBER := 0;" +
                    "     PROCEDURE x; " +
                    "   END;';" +
                    "END;");
            statement2.execute();
            
            OpbSqlHelper.execute(sourceLogger, sourceClass, sourceMethod, statement);
            
            con2.close();
            
        } finally {
            if (created) {
                Connection con = TestHelper.getOracleDataSource().getConnection();

                statement = con.prepareCall(
                        "BEGIN" +
                        "  EXECUTE IMMEDIATE 'DROP PACKAGE opb_sql_helper_test';" +
                        "END;");
                statement.execute();
            }
            
        }
    }
    
    
    /**
     * Test of getValue method, of class com.butterfill.opb.data.OpbSqlHelper.
     */
    public void testGetValue() throws Exception {
        System.out.println("getValue");
        
        OpbBooleanHelper.setValueForTrue("Y");
        OpbBooleanHelper.setValueForFalse("N");
        OpbBooleanHelper.setIgnoreCase(true);
        
        Clob type = null;
        ResultSet resultSet = null;
        String columnName = null;
        boolean failOnInvalidColumnName = false;
        
        try {
            OpbSqlHelper.getValue(type, resultSet, columnName, failOnInvalidColumnName);
            fail();
        } catch (NullPointerException ex) {
            //ok
        }
        
        String sql = 
                "SELECT 'y' AS t, " +
                "       'n' AS f," +
                "       '' AS null_boolean," +
                "       '" + Integer.MIN_VALUE + "' AS i_min," +
                "       '" + Integer.MAX_VALUE + "' AS i_max," +
                "       '" + Long.MIN_VALUE + "' AS l_min," +
                "       '" + Long.MAX_VALUE + "' AS l_max" +
                "  FROM dual";
        
        Connection con = TestHelper.getOracleDataSource().getConnection();
        
        resultSet = con.createStatement().executeQuery(sql);
        resultSet.next();
        
        failOnInvalidColumnName = true;
        try {
            OpbSqlHelper.getValue(type, resultSet, columnName, failOnInvalidColumnName);
            fail();
        } catch (OpbDataAccessException ex) {
            //ok
        }
        
        // <editor-fold defaultstate="collapsed" desc="integer section">
        
        Integer integer = null;
        assertNull(OpbSqlHelper.getValue(integer, resultSet, "x", false));
        
        try {
            OpbSqlHelper.getValue(integer, resultSet, "x", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to get") != -1);
        }
        Object o = Integer.MIN_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(integer, resultSet, "i_min", true));
        
        o = Integer.MAX_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(integer, resultSet, "i_max", true));
        
        try {
            OpbSqlHelper.getValue(integer, resultSet, "l_max", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }
        
        try {
            OpbSqlHelper.getValue(integer, resultSet, "l_min", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }
        
        // </editor-fold> End of integer Section
        
        
        // <editor-fold defaultstate="collapsed" desc="long section">
        
        Long longish = null;
        
        assertNull(OpbSqlHelper.getValue(longish, resultSet, "x", false));
        
        try {
            OpbSqlHelper.getValue(longish, resultSet, "x", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to get") != -1);
        }
        o = Long.valueOf(Integer.MIN_VALUE);
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "i_min", true));
        
        o = Long.valueOf(Integer.MAX_VALUE);
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "i_max", true));
        
        o = Long.MIN_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "l_min", true));
        
        o = Long.MAX_VALUE;
        assertEquals(
                o,
                OpbSqlHelper.getValue(longish, resultSet, "l_max", true));
        
        try {
            OpbSqlHelper.getValue(longish, resultSet, "t", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }
        
        // </editor-fold> End of long Section
        
        
        // <editor-fold defaultstate="collapsed" desc="boolean section">
        
        Boolean b = null;
        assertNull(OpbSqlHelper.getValue(b, resultSet, "x", false));
        
        try {
            OpbSqlHelper.getValue(b, resultSet, "x", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to get") != -1);
        }
        
        assertTrue(OpbSqlHelper.getValue(b, resultSet, "t", true));
        assertFalse(OpbSqlHelper.getValue(b, resultSet, "f", true));
        assertNull(OpbSqlHelper.getValue(b, resultSet, "null_boolean", true));
        
        try {
            OpbSqlHelper.getValue(b, resultSet, "l_max", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }
        
        try {
            OpbSqlHelper.getValue(b, resultSet, "l_min", true);
            fail();
        } catch (OpbDataAccessException ex) {
            assertTrue(ex.getMessage().indexOf("Failed to convert") != -1);
        }
        
        assertNull(OpbSqlHelper.getValue(b, resultSet, "x", false));
        
        b = true;
        assertTrue(OpbSqlHelper.getValue(b, resultSet, "x", false));
        
        b = false;
        assertFalse(OpbSqlHelper.getValue(b, resultSet, "x", false));
        
        // </editor-fold> End of boolean Section
        
        
        // <editor-fold defaultstate="collapsed" desc="String section">
        
        String s = null;
        
        assertNull(OpbSqlHelper.getValue(s, resultSet, "x", false));
        
        s = "testDefaultValue";
        assertEquals(s, OpbSqlHelper.getValue(s, resultSet, "x", false));
        
        s = "x";
        assertEquals(s, OpbSqlHelper.getValue(s, resultSet, "x", false));
        
        // </editor-fold> End of String Section
        
        
        con.close();
        
    }
    
}
