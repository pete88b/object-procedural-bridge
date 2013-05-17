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
 * cats.
 */
public class CatsImpl implements Cats {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            CatsImpl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of CatsImpl.
     */
    public CatsImpl() {
        logger.entering(CLASS_NAME, "CatsImpl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this CatsImpl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this CatsImpl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this CatsImpl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this CatsImpl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this CatsImpl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }



    /**
     * 
     * Calls the database function get_cats.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<Cat>
            getCats()
            throws OpbDataAccessException {
        final String methodName = "getCats()";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);

        OpbId keyToResult = new OpbId(
                "cats.get_cats");

        java.util.List<Cat> result =
                opbDataObjectSource.getCachedResult(
                Cat.class, keyToResult);

        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }

        final OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := cats.get_cats(); END;");

        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);

        opbCallHelper.execute();

        result = opbDataObjectSource.getResult(
                Cat.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);

        opbCallHelper.callComplete();

        logger.exiting(CLASS_NAME, methodName);

        return result;

    }


}