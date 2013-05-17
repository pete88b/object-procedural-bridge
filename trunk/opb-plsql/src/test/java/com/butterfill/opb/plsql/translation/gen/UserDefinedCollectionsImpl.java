/*
 * File created by opb-plsql.
 *
 *  version: 
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * user_defined_collections.
 */
public class UserDefinedCollectionsImpl implements UserDefinedCollections {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            UserDefinedCollectionsImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of UserDefinedCollectionsImpl.
     */
    public UserDefinedCollectionsImpl() {
        logger.entering(CLASS_NAME, "UserDefinedCollectionsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this UserDefinedCollectionsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this UserDefinedCollectionsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this UserDefinedCollectionsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this UserDefinedCollectionsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this UserDefinedCollectionsImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }



    /**
     * 
     * Calls the database function get_null.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal[]
            getNull()
            throws OpbDataAccessException {
        final String methodName = "getNull()";

        logger.entering(CLASS_NAME, methodName);

        java.math.BigDecimal[] result = null;

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collections.get_null(); END;");

        opbCallHelper.registerOutArray(
                1, "NUMBER_TABLE");

        opbCallHelper.execute();

        result = opbCallHelper.getArray(java.math.BigDecimal[].class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * 
     * Calls the database function echo_number_table.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal[]
            echoNumberTable(final Object[] pData)
            throws OpbDataAccessException {
        final String methodName = "echoNumberTable(java.math.BigDecimal[])";

        logger.entering(CLASS_NAME, methodName);

        java.math.BigDecimal[] result = null;

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collections.echo_number_table(?); END;");

        opbCallHelper.registerOutArray(
                1, "NUMBER_TABLE");

        opbCallHelper.setArray(
                2, "NUMBER_TABLE", pData);


        opbCallHelper.execute();

        result = opbCallHelper.getArray(java.math.BigDecimal[].class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * 
     * Calls the database function format_number_table.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            formatNumberTable(final Object[] pData)
            throws OpbDataAccessException {
        final String methodName = "formatNumberTable(java.math.BigDecimal[])";

        logger.entering(CLASS_NAME, methodName);

        String result = null;

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collections.format_number_table(?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);

        opbCallHelper.setArray(
                2, "NUMBER_TABLE", pData);


        opbCallHelper.execute();

        result = opbCallHelper.get(String.class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }

    /**
     * 
     * Calls the database function how_long.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public String
            howLong(final Object[] pData,
            final OpbValueWrapper<String[]> pResults)
            throws OpbDataAccessException {
        final String methodName = "howLong(String[], OpbValueWrapper)";

        logger.entering(CLASS_NAME, methodName);

        String result = null;

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pResults", pResults);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collections.how_long(?, ?); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.VARCHAR);

        opbCallHelper.setArray(
                2, "VARCHAR_TABLE", pData);

        opbCallHelper.registerOutArray(
                3, "VARCHAR_TABLE");


        opbCallHelper.execute();

        result = opbCallHelper.get(String.class, 1);

        pResults.setValue(opbCallHelper.getArray(String[].class, 3));

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }


    /**
     * 
     * Calls the database procedure get_null_proc.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void getNullProc(final OpbValueWrapper<java.math.BigDecimal[]> pData)
            throws OpbDataAccessException {
        final String methodName = "getNullProc(OpbValueWrapper)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN user_defined_collections.get_null_proc(?); END;");

        opbCallHelper.registerOutArray(
                1, "NUMBER_TABLE");


        opbCallHelper.execute();

        pData.setValue(opbCallHelper.getArray(java.math.BigDecimal[].class, 1));

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * 
     * Calls the database procedure simple_in_out.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void simpleInOut(final OpbValueWrapper<String[]> pData)
            throws OpbDataAccessException {
        final String methodName = "simpleInOut(OpbValueWrapper)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pData", pData);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN user_defined_collections.simple_in_out(?); END;");

        opbCallHelper.setArray(
                1, "VARCHAR_TABLE", pData.getValue());

        opbCallHelper.registerOutArray(
                1, "VARCHAR_TABLE");


        opbCallHelper.execute();

        pData.setValue(opbCallHelper.getArray(String[].class, 1));

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }


}