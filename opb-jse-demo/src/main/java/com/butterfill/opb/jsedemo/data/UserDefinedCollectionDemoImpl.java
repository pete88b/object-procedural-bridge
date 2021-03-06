/*
 * File created by opb-plsql.
 *
 * opb-plsql version: 2.0.0
 * opb-core version: 2.0.0
 */

package com.butterfill.opb.jsedemo.data;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * user_defined_collection_demo.
 */
public class UserDefinedCollectionDemoImpl implements UserDefinedCollectionDemo {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            UserDefinedCollectionDemoImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of UserDefinedCollectionDemoImpl.
     */
    public UserDefinedCollectionDemoImpl() {
        logger.entering(CLASS_NAME, "UserDefinedCollectionDemoImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this UserDefinedCollectionDemoImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this UserDefinedCollectionDemoImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this UserDefinedCollectionDemoImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this UserDefinedCollectionDemoImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this UserDefinedCollectionDemoImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }



    /**
     * 
     * Calls the database function echo.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.math.BigDecimal[]
            echo(final Object[] pData)
            throws OpbDataAccessException {
        final String methodName = "echo(java.math.BigDecimal[])";

        logger.entering(CLASS_NAME, methodName);

        java.math.BigDecimal[] result = null;

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := user_defined_collection_demo.echo(?); END;");

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


}