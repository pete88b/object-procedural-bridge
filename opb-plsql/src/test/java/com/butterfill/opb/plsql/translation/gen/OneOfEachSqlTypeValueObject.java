/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

/**
 * File created from the PL/SQL package specification
 * one_of_each_sql_type.
 */
public class OneOfEachSqlTypeValueObject {

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this OneOfEachSqlTypeValueObject.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }

    /**
     * Derived from an opb-package field.
     */
    public Double aBinaryDouble;

    /**
     * Derived from a read-write opb-package field.
     */
    public Double aBinaryDoubleDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public Float aBinaryFloat;

    /**
     * Derived from a read-write opb-package field.
     */
    public Float aBinaryFloatDataSourceValue;

    // The field aBlob has been excluded. See OpbField#JAVA_DATATYPES_TO_EXCLUDE_FROM_VALUE_OBJECT

    /**
     * Derived from an opb-package field.
     */
    public String aChar;

    /**
     * Derived from a read-write opb-package field.
     */
    public String aCharDataSourceValue;

    // The field aClob has been excluded. See OpbField#JAVA_DATATYPES_TO_EXCLUDE_FROM_VALUE_OBJECT

    /**
     * Derived from an opb-package field.
     */
    public java.util.Date aDate;

    /**
     * Derived from a read-write opb-package field.
     */
    public java.util.Date aDateDataSourceValue;

    // The field aNclob has been excluded. See OpbField#JAVA_DATATYPES_TO_EXCLUDE_FROM_VALUE_OBJECT

    /**
     * Derived from an opb-package field.
     */
    public java.math.BigDecimal aNumber;

    /**
     * Derived from a read-write opb-package field.
     */
    public java.math.BigDecimal aNumberDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public String aNvarchar2;

    /**
     * Derived from a read-write opb-package field.
     */
    public String aNvarchar2DataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public byte[] aRaw;

    /**
     * Derived from a read-write opb-package field.
     */
    public byte[] aRawDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public java.sql.Timestamp aTimestamp;

    /**
     * Derived from a read-write opb-package field.
     */
    public java.sql.Timestamp aTimestampDataSourceValue;

    /**
     * Derived from an opb-package field.
     */
    public String aVarchar2;

    /**
     * Derived from a read-write opb-package field.
     */
    public String aVarchar2DataSourceValue;


}