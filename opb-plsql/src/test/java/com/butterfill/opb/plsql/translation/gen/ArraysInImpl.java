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
 * arrays_in.
 */
public class ArraysInImpl implements ArraysIn {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            ArraysInImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of ArraysInImpl.
     */
    public ArraysInImpl() {
        logger.entering(CLASS_NAME, "ArraysInImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this ArraysInImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this ArraysInImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this ArraysInImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this ArraysInImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this ArraysInImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }


    /**
     * 
     * Calls the database procedure test_one.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void testOne(final String[] pArray)
            throws OpbDataAccessException {
        final String methodName = "testOne(String[])";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pArray", pArray,
                "PL/SQL index-by tables cannot be set to null");

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN arrays_in.test_one(?); END;");

        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.VARCHAR, pArray);


        opbCallHelper.execute();

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }

    /**
     * 
     * Calls the database procedure test_two.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void testTwo(final java.math.BigDecimal[] pArray)
            throws OpbDataAccessException {
        final String methodName = "testTwo(java.math.BigDecimal[])";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pArray", pArray,
                "PL/SQL index-by tables cannot be set to null");

        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN arrays_in.test_two(?); END;");

        opbCallHelper.setPlsqlIndexTable(
                1, java.sql.Types.DECIMAL, pArray);


        opbCallHelper.execute();

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

    }


}