/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.util.data;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * one_of_each_sql_type.
 */
public class OneOfEachSqlTypeImpl implements OneOfEachSqlType {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OneOfEachSqlTypeImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of OneOfEachSqlTypeImpl.
     */
    public OneOfEachSqlTypeImpl() {
        logger.entering(CLASS_NAME, "OneOfEachSqlTypeImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this OneOfEachSqlTypeImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this OneOfEachSqlTypeImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this OneOfEachSqlTypeImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this OneOfEachSqlTypeImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this OneOfEachSqlTypeImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }


    /**
     * Resets all field values to their initial values.
     */
    public void opbClearState() {
        final String methodName = "opbClearState()";

        logger.entering(CLASS_NAME, methodName);

        // set all fields to their initial values
        aBinaryDouble = null;
        aBinaryDoubleDataSourceValue = null;

        aBinaryFloat = null;
        aBinaryFloatDataSourceValue = null;

        aBlob = null;
        aBlobDataSourceValue = null;

        aChar = null;
        aCharDataSourceValue = null;

        aClob = null;
        aClobDataSourceValue = null;

        aDate = null;
        aDateDataSourceValue = null;

        aNclob = null;
        aNclobDataSourceValue = null;

        aNumber = null;
        aNumberDataSourceValue = null;

        aNvarchar2 = null;
        aNvarchar2DataSourceValue = null;

        aRaw = null;
        aRawDataSourceValue = null;

        aTimestamp = null;
        aTimestampDataSourceValue = null;

        aVarchar2 = null;
        aVarchar2DataSourceValue = null;


    } // End of opbClearState()


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the current row in resultSet.
     * <br/>
     * This method will look for the following fields in resultSet;
     * <ul>
     * <li>a_binary_double is optional</li>
     * <li>a_binary_float is optional</li>
     * <li>a_blob is <em>mandatory</em></li>
     * <li>a_char is <em>mandatory</em></li>
     * <li>a_clob is <em>mandatory</em></li>
     * <li>a_date is <em>mandatory</em></li>
     * <li>a_nclob is <em>mandatory</em></li>
     * <li>a_number is <em>mandatory</em></li>
     * <li>a_nvarchar2 is <em>mandatory</em></li>
     * <li>a_raw is <em>mandatory</em></li>
     * <li>a_timestamp is optional</li>
     * <li>a_varchar2 is <em>mandatory</em></li>
     * </ul>
     *
     * @param resultSet The result set from which this instance should be loaded.
     * @throws OpbDataAccessException If we fail to load this instance.
     */
    public void opbLoad(final java.sql.ResultSet resultSet)
            throws OpbDataAccessException {
        final String methodName = "opbLoad(ResultSet)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure resultSet is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "resultSet", resultSet);

        // Get field values from resultSet
        try {
            // load aBinaryDouble from column a_binary_double
            aBinaryDouble = OpbSqlHelper.getValue(
                    aBinaryDouble, resultSet,
                    "a_binary_double", false);
            // save the value we just loaded as the datasource value
            aBinaryDoubleDataSourceValue = aBinaryDouble;

            // load aBinaryFloat from column a_binary_float
            aBinaryFloat = OpbSqlHelper.getValue(
                    aBinaryFloat, resultSet,
                    "a_binary_float", false);
            // save the value we just loaded as the datasource value
            aBinaryFloatDataSourceValue = aBinaryFloat;

            // load aBlob from column a_blob
            aBlob = OpbSqlHelper.getValue(
                    aBlob, resultSet,
                    "a_blob", true);
            // save the value we just loaded as the datasource value
            aBlobDataSourceValue = aBlob;

            // load aChar from column a_char
            aChar = OpbSqlHelper.getValue(
                    aChar, resultSet,
                    "a_char", true);
            // save the value we just loaded as the datasource value
            aCharDataSourceValue = aChar;

            // load aClob from column a_clob
            aClob = OpbSqlHelper.getValue(
                    aClob, resultSet,
                    "a_clob", true);
            // save the value we just loaded as the datasource value
            aClobDataSourceValue = aClob;

            // load aDate from column a_date
            aDate = OpbSqlHelper.getValue(
                    aDate, resultSet,
                    "a_date", true);
            // save the value we just loaded as the datasource value
            aDateDataSourceValue = aDate;

            // load aNclob from column a_nclob
            aNclob = OpbSqlHelper.getValue(
                    aNclob, resultSet,
                    "a_nclob", true);
            // save the value we just loaded as the datasource value
            aNclobDataSourceValue = aNclob;

            // load aNumber from column a_number
            aNumber = OpbSqlHelper.getValue(
                    aNumber, resultSet,
                    "a_number", true);
            // save the value we just loaded as the datasource value
            aNumberDataSourceValue = aNumber;

            // load aNvarchar2 from column a_nvarchar2
            aNvarchar2 = OpbSqlHelper.getValue(
                    aNvarchar2, resultSet,
                    "a_nvarchar2", true);
            // save the value we just loaded as the datasource value
            aNvarchar2DataSourceValue = aNvarchar2;

            // load aRaw from column a_raw
            aRaw = OpbSqlHelper.getValue(
                    aRaw, resultSet,
                    "a_raw", true);
            // save the value we just loaded as the datasource value
            aRawDataSourceValue = aRaw;

            // load aTimestamp from column a_timestamp
            aTimestamp = OpbSqlHelper.getValue(
                    aTimestamp, resultSet,
                    "a_timestamp", false);
            // save the value we just loaded as the datasource value
            aTimestampDataSourceValue = aTimestamp;

            // load aVarchar2 from column a_varchar2
            aVarchar2 = OpbSqlHelper.getValue(
                    aVarchar2, resultSet,
                    "a_varchar2", true);
            // save the value we just loaded as the datasource value
            aVarchar2DataSourceValue = aVarchar2;


        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbDataAccessException("failed to load", ex),
                    logger, CLASS_NAME, methodName);

        } finally {
            logger.exiting(CLASS_NAME, methodName);

        }

    } // End of opbLoad(ResultSet)


    /**
     * Resets all field values to their initial values by calling
     * opbClearState() and then sets all field values using values taken from
     * the value object.
     *
     * @param valueObject The value object from which this instance should be loaded.
     */
    public void opbLoad(final OneOfEachSqlTypeValueObject valueObject) {
        final String methodName = "opbLoad(OneOfEachSqlTypeValueObject)";

        logger.entering(CLASS_NAME, methodName);

        // Clear all field values
        opbClearState();

        // Make sure valueObject is not null
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "valueObject", valueObject);

        // Get field values from valueObject
        aBinaryDouble = valueObject.aBinaryDouble;
        aBinaryDoubleDataSourceValue = valueObject.aBinaryDoubleDataSourceValue;

        aBinaryFloat = valueObject.aBinaryFloat;
        aBinaryFloatDataSourceValue = valueObject.aBinaryFloatDataSourceValue;

        aChar = valueObject.aChar;
        aCharDataSourceValue = valueObject.aCharDataSourceValue;

        aDate = valueObject.aDate;
        aDateDataSourceValue = valueObject.aDateDataSourceValue;

        aNumber = valueObject.aNumber;
        aNumberDataSourceValue = valueObject.aNumberDataSourceValue;

        aNvarchar2 = valueObject.aNvarchar2;
        aNvarchar2DataSourceValue = valueObject.aNvarchar2DataSourceValue;

        aRaw = valueObject.aRaw;
        aRawDataSourceValue = valueObject.aRawDataSourceValue;

        aTimestamp = valueObject.aTimestamp;
        aTimestampDataSourceValue = valueObject.aTimestampDataSourceValue;

        aVarchar2 = valueObject.aVarchar2;
        aVarchar2DataSourceValue = valueObject.aVarchar2DataSourceValue;


    } // End of opbLoad(OneOfEachSqlTypeValueObject)

    /**
     * Returns a value object for this instance.
     * @return A value object for this OneOfEachSqlTypeImpl.
     */
    public OneOfEachSqlTypeValueObject opbToValueObject() {
        final String methodName = "opbToValueObject()";

        logger.entering(CLASS_NAME, methodName);

        final OneOfEachSqlTypeValueObject valueObject = new OneOfEachSqlTypeValueObject();

        valueObject.aBinaryDouble = aBinaryDouble;
        valueObject.aBinaryDoubleDataSourceValue = aBinaryDoubleDataSourceValue;

        valueObject.aBinaryFloat = aBinaryFloat;
        valueObject.aBinaryFloatDataSourceValue = aBinaryFloatDataSourceValue;

        valueObject.aChar = aChar;
        valueObject.aCharDataSourceValue = aCharDataSourceValue;

        valueObject.aDate = aDate;
        valueObject.aDateDataSourceValue = aDateDataSourceValue;

        valueObject.aNumber = aNumber;
        valueObject.aNumberDataSourceValue = aNumberDataSourceValue;

        valueObject.aNvarchar2 = aNvarchar2;
        valueObject.aNvarchar2DataSourceValue = aNvarchar2DataSourceValue;

        valueObject.aRaw = aRaw;
        valueObject.aRawDataSourceValue = aRawDataSourceValue;

        valueObject.aTimestamp = aTimestamp;
        valueObject.aTimestampDataSourceValue = aTimestampDataSourceValue;

        valueObject.aVarchar2 = aVarchar2;
        valueObject.aVarchar2DataSourceValue = aVarchar2DataSourceValue;


        return valueObject;

    } // End of opbToValueObject()

    /**
     * Derived from an opb-package field.
     */
    private Double aBinaryDouble = null;

    /**
     * Returns the value of aBinaryDouble.
     * @return The value of aBinaryDouble.
     */
    public Double getABinaryDouble() {
        return aBinaryDouble;
    }

    /**
     * Sets the value of aBinaryDouble.
     * @param a The new value for aBinaryDouble.
     */
    public void setABinaryDouble(final Double a) {
        this.aBinaryDouble = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private Double aBinaryDoubleDataSourceValue = null;

    /**
     * Returns the value of aBinaryDoubleDataSourceValue.
     * This is the last value returned by the data source for aBinaryDouble.
     * @return The value of aBinaryDoubleDataSourceValue.
     */
    public Double getABinaryDoubleDataSourceValue() {
        return aBinaryDoubleDataSourceValue;
    }

    /**
     * Returns true if the value of aBinaryDouble
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aBinaryDouble has changed since it was loaded.
     */
    public boolean getABinaryDoubleChanged() {
        return !OpbComparisonHelper.isEqual(
                    aBinaryDouble, aBinaryDoubleDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private Float aBinaryFloat = null;

    /**
     * Returns the value of aBinaryFloat.
     * @return The value of aBinaryFloat.
     */
    public Float getABinaryFloat() {
        return aBinaryFloat;
    }

    /**
     * Sets the value of aBinaryFloat.
     * @param a The new value for aBinaryFloat.
     */
    public void setABinaryFloat(final Float a) {
        this.aBinaryFloat = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private Float aBinaryFloatDataSourceValue = null;

    /**
     * Returns the value of aBinaryFloatDataSourceValue.
     * This is the last value returned by the data source for aBinaryFloat.
     * @return The value of aBinaryFloatDataSourceValue.
     */
    public Float getABinaryFloatDataSourceValue() {
        return aBinaryFloatDataSourceValue;
    }

    /**
     * Returns true if the value of aBinaryFloat
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aBinaryFloat has changed since it was loaded.
     */
    public boolean getABinaryFloatChanged() {
        return !OpbComparisonHelper.isEqual(
                    aBinaryFloat, aBinaryFloatDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.sql.Blob aBlob = null;

    /**
     * Returns the value of aBlob.
     * @return The value of aBlob.
     */
    public java.sql.Blob getABlob() {
        return aBlob;
    }

    /**
     * Sets the value of aBlob.
     * @param a The new value for aBlob.
     */
    public void setABlob(final java.sql.Blob a) {
        this.aBlob = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.sql.Blob aBlobDataSourceValue = null;

    /**
     * Returns the value of aBlobDataSourceValue.
     * This is the last value returned by the data source for aBlob.
     * @return The value of aBlobDataSourceValue.
     */
    public java.sql.Blob getABlobDataSourceValue() {
        return aBlobDataSourceValue;
    }

    /**
     * Returns true if the value of aBlob
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aBlob has changed since it was loaded.
     */
    public boolean getABlobChanged() {
        return !OpbComparisonHelper.isEqual(
                    aBlob, aBlobDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String aChar = null;

    /**
     * Returns the value of aChar.
     * @return The value of aChar.
     */
    public String getAChar() {
        return aChar;
    }

    /**
     * Sets the value of aChar.
     * @param a The new value for aChar.
     */
    public void setAChar(final String a) {
        this.aChar = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String aCharDataSourceValue = null;

    /**
     * Returns the value of aCharDataSourceValue.
     * This is the last value returned by the data source for aChar.
     * @return The value of aCharDataSourceValue.
     */
    public String getACharDataSourceValue() {
        return aCharDataSourceValue;
    }

    /**
     * Returns true if the value of aChar
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aChar has changed since it was loaded.
     */
    public boolean getACharChanged() {
        return !OpbComparisonHelper.isEqual(
                    aChar, aCharDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.sql.Clob aClob = null;

    /**
     * Returns the value of aClob.
     * @return The value of aClob.
     */
    public java.sql.Clob getAClob() {
        return aClob;
    }

    /**
     * Sets the value of aClob.
     * @param a The new value for aClob.
     */
    public void setAClob(final java.sql.Clob a) {
        this.aClob = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.sql.Clob aClobDataSourceValue = null;

    /**
     * Returns the value of aClobDataSourceValue.
     * This is the last value returned by the data source for aClob.
     * @return The value of aClobDataSourceValue.
     */
    public java.sql.Clob getAClobDataSourceValue() {
        return aClobDataSourceValue;
    }

    /**
     * Returns true if the value of aClob
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aClob has changed since it was loaded.
     */
    public boolean getAClobChanged() {
        return !OpbComparisonHelper.isEqual(
                    aClob, aClobDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.util.Date aDate = null;

    /**
     * Returns the value of aDate.
     * @return The value of aDate.
     */
    public java.util.Date getADate() {
        return aDate;
    }

    /**
     * Sets the value of aDate.
     * @param a The new value for aDate.
     */
    public void setADate(final java.util.Date a) {
        this.aDate = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.util.Date aDateDataSourceValue = null;

    /**
     * Returns the value of aDateDataSourceValue.
     * This is the last value returned by the data source for aDate.
     * @return The value of aDateDataSourceValue.
     */
    public java.util.Date getADateDataSourceValue() {
        return aDateDataSourceValue;
    }

    /**
     * Returns true if the value of aDate
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aDate has changed since it was loaded.
     */
    public boolean getADateChanged() {
        return !OpbComparisonHelper.isEqual(
                    aDate, aDateDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.sql.Clob aNclob = null;

    /**
     * Returns the value of aNclob.
     * @return The value of aNclob.
     */
    public java.sql.Clob getANclob() {
        return aNclob;
    }

    /**
     * Sets the value of aNclob.
     * @param a The new value for aNclob.
     */
    public void setANclob(final java.sql.Clob a) {
        this.aNclob = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.sql.Clob aNclobDataSourceValue = null;

    /**
     * Returns the value of aNclobDataSourceValue.
     * This is the last value returned by the data source for aNclob.
     * @return The value of aNclobDataSourceValue.
     */
    public java.sql.Clob getANclobDataSourceValue() {
        return aNclobDataSourceValue;
    }

    /**
     * Returns true if the value of aNclob
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNclob has changed since it was loaded.
     */
    public boolean getANclobChanged() {
        return !OpbComparisonHelper.isEqual(
                    aNclob, aNclobDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.math.BigDecimal aNumber = null;

    /**
     * Returns the value of aNumber.
     * @return The value of aNumber.
     */
    public java.math.BigDecimal getANumber() {
        return aNumber;
    }

    /**
     * Sets the value of aNumber.
     * @param a The new value for aNumber.
     */
    public void setANumber(final java.math.BigDecimal a) {
        this.aNumber = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.math.BigDecimal aNumberDataSourceValue = null;

    /**
     * Returns the value of aNumberDataSourceValue.
     * This is the last value returned by the data source for aNumber.
     * @return The value of aNumberDataSourceValue.
     */
    public java.math.BigDecimal getANumberDataSourceValue() {
        return aNumberDataSourceValue;
    }

    /**
     * Returns true if the value of aNumber
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNumber has changed since it was loaded.
     */
    public boolean getANumberChanged() {
        return !OpbComparisonHelper.isEqual(
                    aNumber, aNumberDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String aNvarchar2 = null;

    /**
     * Returns the value of aNvarchar2.
     * @return The value of aNvarchar2.
     */
    public String getANvarchar2() {
        return aNvarchar2;
    }

    /**
     * Sets the value of aNvarchar2.
     * @param a The new value for aNvarchar2.
     */
    public void setANvarchar2(final String a) {
        this.aNvarchar2 = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String aNvarchar2DataSourceValue = null;

    /**
     * Returns the value of aNvarchar2DataSourceValue.
     * This is the last value returned by the data source for aNvarchar2.
     * @return The value of aNvarchar2DataSourceValue.
     */
    public String getANvarchar2DataSourceValue() {
        return aNvarchar2DataSourceValue;
    }

    /**
     * Returns true if the value of aNvarchar2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aNvarchar2 has changed since it was loaded.
     */
    public boolean getANvarchar2Changed() {
        return !OpbComparisonHelper.isEqual(
                    aNvarchar2, aNvarchar2DataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private byte[] aRaw = null;

    /**
     * Returns the value of aRaw.
     * @return The value of aRaw.
     */
    public byte[] getARaw() {
        return aRaw;
    }

    /**
     * Sets the value of aRaw.
     * @param a The new value for aRaw.
     */
    public void setARaw(final byte[] a) {
        this.aRaw = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private byte[] aRawDataSourceValue = null;

    /**
     * Returns the value of aRawDataSourceValue.
     * This is the last value returned by the data source for aRaw.
     * @return The value of aRawDataSourceValue.
     */
    public byte[] getARawDataSourceValue() {
        return aRawDataSourceValue;
    }

    /**
     * Returns true if the value of aRaw
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aRaw has changed since it was loaded.
     */
    public boolean getARawChanged() {
        return !OpbComparisonHelper.isEqual(
                    aRaw, aRawDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private java.sql.Timestamp aTimestamp = null;

    /**
     * Returns the value of aTimestamp.
     * @return The value of aTimestamp.
     */
    public java.sql.Timestamp getATimestamp() {
        return aTimestamp;
    }

    /**
     * Sets the value of aTimestamp.
     * @param a The new value for aTimestamp.
     */
    public void setATimestamp(final java.sql.Timestamp a) {
        this.aTimestamp = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private java.sql.Timestamp aTimestampDataSourceValue = null;

    /**
     * Returns the value of aTimestampDataSourceValue.
     * This is the last value returned by the data source for aTimestamp.
     * @return The value of aTimestampDataSourceValue.
     */
    public java.sql.Timestamp getATimestampDataSourceValue() {
        return aTimestampDataSourceValue;
    }

    /**
     * Returns true if the value of aTimestamp
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aTimestamp has changed since it was loaded.
     */
    public boolean getATimestampChanged() {
        return !OpbComparisonHelper.isEqual(
                    aTimestamp, aTimestampDataSourceValue);
    }

    /**
     * Derived from an opb-package field.
     */
    private String aVarchar2 = null;

    /**
     * Returns the value of aVarchar2.
     * @return The value of aVarchar2.
     */
    public String getAVarchar2() {
        return aVarchar2;
    }

    /**
     * Sets the value of aVarchar2.
     * @param a The new value for aVarchar2.
     */
    public void setAVarchar2(final String a) {
        this.aVarchar2 = a;
    }

    /**
     * Derived from a read-write opb-package field.
     */
    private String aVarchar2DataSourceValue = null;

    /**
     * Returns the value of aVarchar2DataSourceValue.
     * This is the last value returned by the data source for aVarchar2.
     * @return The value of aVarchar2DataSourceValue.
     */
    public String getAVarchar2DataSourceValue() {
        return aVarchar2DataSourceValue;
    }

    /**
     * Returns true if the value of aVarchar2
     * is different to the value that was loaded from the data source,
     * false otherwise.
     * @return true if aVarchar2 has changed since it was loaded.
     */
    public boolean getAVarchar2Changed() {
        return !OpbComparisonHelper.isEqual(
                    aVarchar2, aVarchar2DataSourceValue);
    }


}