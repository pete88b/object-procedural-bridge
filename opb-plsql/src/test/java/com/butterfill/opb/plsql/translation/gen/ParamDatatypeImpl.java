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
 * param_datatype.
 */
public class ParamDatatypeImpl implements ParamDatatype {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            ParamDatatypeImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of ParamDatatypeImpl.
     */
    public ParamDatatypeImpl() {
        logger.entering(CLASS_NAME, "ParamDatatypeImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this ParamDatatypeImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this ParamDatatypeImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this ParamDatatypeImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this ParamDatatypeImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this ParamDatatypeImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }



    /**
     * 
     * Calls the database function invalid_1.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal
            invalid1()
            throws OpbDataAccessException {
        final String methodName = "invalid1()";

        logger.entering(CLASS_NAME, methodName);

        java.math.BigDecimal result = null;

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_datatype.invalid_1(); END;");

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.DECIMAL);

        opbCallHelper.execute();

        result = opbCallHelper.get(java.math.BigDecimal.class, 1);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }


    /**
     * 
     * Calls the database procedure invalid_2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void invalid2(final java.math.BigDecimal p1)
            throws OpbDataAccessException {
        final String methodName = "invalid2(java.math.BigDecimal)";

        logger.entering(CLASS_NAME, methodName);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN param_datatype.invalid_2(?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.DECIMAL, p1);


        opbCallHelper.execute();

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * 
     * Calls the database procedure dodgy.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void dodgy(final OpbValueWrapper<Long> p1,
            final OpbValueWrapper<Long> p2)
            throws OpbDataAccessException {
        final String methodName = "dodgy(OpbValueWrapper, OpbValueWrapper)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "p1", p1);
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "p2", p2);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN param_datatype.dodgy(?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, p1.getValue());

        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, p2.getValue());

        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);


        opbCallHelper.execute();

        p1.setValue(opbCallHelper.get(Long.class, 1));
        p2.setValue(opbCallHelper.get(Long.class, 2));

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * 
     * Calls the database procedure a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void a(final Long p1,
            final Long p2)
            throws OpbDataAccessException {
        final String methodName = "a(Long, Long)";

        logger.entering(CLASS_NAME, methodName);

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN param_datatype.a(?, ?); END;");

        opbCallHelper.setObject(
                1, java.sql.Types.BIGINT, p1);

        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, p2);


        opbCallHelper.execute();

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }


}