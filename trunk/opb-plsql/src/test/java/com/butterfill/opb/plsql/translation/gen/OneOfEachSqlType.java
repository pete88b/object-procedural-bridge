/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * one_of_each_sql_type.
 */
public interface OneOfEachSqlType
        extends OpbActiveDataObject, OpbEntity {

    /**
     * Resets all field values to their initial values.
     */
    void opbClearState();

    /**
     * Returns the value of aBinaryDouble.
     * @return The value of aBinaryDouble.
     */
    Double getABinaryDouble();

    /**
     * Sets the value of aBinaryDouble.
     * @param a The new value for aBinaryDouble.
     */
    void setABinaryDouble(Double a);

    /**
     * Returns the value of aBinaryDoubleDataSourceValue.
     * This is the last value returned by the data source for aBinaryDouble.
     * @return The value of aBinaryDoubleDataSourceValue.
     */
    Double getABinaryDoubleDataSourceValue();

    /**
     * Returns true if the value of aBinaryDouble
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aBinaryDouble has changed since it was loaded.
     */
    boolean getABinaryDoubleChanged();

    /**
     * Returns the value of aBinaryFloat.
     * @return The value of aBinaryFloat.
     */
    Float getABinaryFloat();

    /**
     * Sets the value of aBinaryFloat.
     * @param a The new value for aBinaryFloat.
     */
    void setABinaryFloat(Float a);

    /**
     * Returns the value of aBinaryFloatDataSourceValue.
     * This is the last value returned by the data source for aBinaryFloat.
     * @return The value of aBinaryFloatDataSourceValue.
     */
    Float getABinaryFloatDataSourceValue();

    /**
     * Returns true if the value of aBinaryFloat
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aBinaryFloat has changed since it was loaded.
     */
    boolean getABinaryFloatChanged();

    /**
     * Returns the value of aBlob.
     * @return The value of aBlob.
     */
    java.sql.Blob getABlob();

    /**
     * Sets the value of aBlob.
     * @param a The new value for aBlob.
     */
    void setABlob(java.sql.Blob a);

    /**
     * Returns the value of aBlobDataSourceValue.
     * This is the last value returned by the data source for aBlob.
     * @return The value of aBlobDataSourceValue.
     */
    java.sql.Blob getABlobDataSourceValue();

    /**
     * Returns true if the value of aBlob
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aBlob has changed since it was loaded.
     */
    boolean getABlobChanged();

    /**
     * Returns the value of aChar.
     * @return The value of aChar.
     */
    String getAChar();

    /**
     * Sets the value of aChar.
     * @param a The new value for aChar.
     */
    void setAChar(String a);

    /**
     * Returns the value of aCharDataSourceValue.
     * This is the last value returned by the data source for aChar.
     * @return The value of aCharDataSourceValue.
     */
    String getACharDataSourceValue();

    /**
     * Returns true if the value of aChar
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aChar has changed since it was loaded.
     */
    boolean getACharChanged();

    /**
     * Returns the value of aClob.
     * @return The value of aClob.
     */
    java.sql.Clob getAClob();

    /**
     * Sets the value of aClob.
     * @param a The new value for aClob.
     */
    void setAClob(java.sql.Clob a);

    /**
     * Returns the value of aClobDataSourceValue.
     * This is the last value returned by the data source for aClob.
     * @return The value of aClobDataSourceValue.
     */
    java.sql.Clob getAClobDataSourceValue();

    /**
     * Returns true if the value of aClob
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aClob has changed since it was loaded.
     */
    boolean getAClobChanged();

    /**
     * Returns the value of aDate.
     * @return The value of aDate.
     */
    java.util.Date getADate();

    /**
     * Sets the value of aDate.
     * @param a The new value for aDate.
     */
    void setADate(java.util.Date a);

    /**
     * Returns the value of aDateDataSourceValue.
     * This is the last value returned by the data source for aDate.
     * @return The value of aDateDataSourceValue.
     */
    java.util.Date getADateDataSourceValue();

    /**
     * Returns true if the value of aDate
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aDate has changed since it was loaded.
     */
    boolean getADateChanged();

    /**
     * Returns the value of aNclob.
     * @return The value of aNclob.
     */
    java.sql.Clob getANclob();

    /**
     * Sets the value of aNclob.
     * @param a The new value for aNclob.
     */
    void setANclob(java.sql.Clob a);

    /**
     * Returns the value of aNclobDataSourceValue.
     * This is the last value returned by the data source for aNclob.
     * @return The value of aNclobDataSourceValue.
     */
    java.sql.Clob getANclobDataSourceValue();

    /**
     * Returns true if the value of aNclob
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNclob has changed since it was loaded.
     */
    boolean getANclobChanged();

    /**
     * Returns the value of aNumber.
     * @return The value of aNumber.
     */
    java.math.BigDecimal getANumber();

    /**
     * Sets the value of aNumber.
     * @param a The new value for aNumber.
     */
    void setANumber(java.math.BigDecimal a);

    /**
     * Returns the value of aNumberDataSourceValue.
     * This is the last value returned by the data source for aNumber.
     * @return The value of aNumberDataSourceValue.
     */
    java.math.BigDecimal getANumberDataSourceValue();

    /**
     * Returns true if the value of aNumber
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumber has changed since it was loaded.
     */
    boolean getANumberChanged();

    /**
     * Returns the value of aNvarchar2.
     * @return The value of aNvarchar2.
     */
    String getANvarchar2();

    /**
     * Sets the value of aNvarchar2.
     * @param a The new value for aNvarchar2.
     */
    void setANvarchar2(String a);

    /**
     * Returns the value of aNvarchar2DataSourceValue.
     * This is the last value returned by the data source for aNvarchar2.
     * @return The value of aNvarchar2DataSourceValue.
     */
    String getANvarchar2DataSourceValue();

    /**
     * Returns true if the value of aNvarchar2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNvarchar2 has changed since it was loaded.
     */
    boolean getANvarchar2Changed();

    /**
     * Returns the value of aRaw.
     * @return The value of aRaw.
     */
    byte[] getARaw();

    /**
     * Sets the value of aRaw.
     * @param a The new value for aRaw.
     */
    void setARaw(byte[] a);

    /**
     * Returns the value of aRawDataSourceValue.
     * This is the last value returned by the data source for aRaw.
     * @return The value of aRawDataSourceValue.
     */
    byte[] getARawDataSourceValue();

    /**
     * Returns true if the value of aRaw
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aRaw has changed since it was loaded.
     */
    boolean getARawChanged();

    /**
     * Returns the value of aTimestamp.
     * @return The value of aTimestamp.
     */
    java.sql.Timestamp getATimestamp();

    /**
     * Sets the value of aTimestamp.
     * @param a The new value for aTimestamp.
     */
    void setATimestamp(java.sql.Timestamp a);

    /**
     * Returns the value of aTimestampDataSourceValue.
     * This is the last value returned by the data source for aTimestamp.
     * @return The value of aTimestampDataSourceValue.
     */
    java.sql.Timestamp getATimestampDataSourceValue();

    /**
     * Returns true if the value of aTimestamp
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aTimestamp has changed since it was loaded.
     */
    boolean getATimestampChanged();

    /**
     * Returns the value of aVarchar2.
     * @return The value of aVarchar2.
     */
    String getAVarchar2();

    /**
     * Sets the value of aVarchar2.
     * @param a The new value for aVarchar2.
     */
    void setAVarchar2(String a);

    /**
     * Returns the value of aVarchar2DataSourceValue.
     * This is the last value returned by the data source for aVarchar2.
     * @return The value of aVarchar2DataSourceValue.
     */
    String getAVarchar2DataSourceValue();

    /**
     * Returns true if the value of aVarchar2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aVarchar2 has changed since it was loaded.
     */
    boolean getAVarchar2Changed();


}