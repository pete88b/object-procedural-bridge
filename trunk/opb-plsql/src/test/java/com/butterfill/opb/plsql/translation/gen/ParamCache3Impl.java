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
 * param_cache3.
 */
public class ParamCache3Impl implements ParamCache3 {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            ParamCache3Impl.class.getName();

    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);


    /**
     * Creates a new instance of ParamCache3Impl.
     */
    public ParamCache3Impl() {
        logger.entering(CLASS_NAME, "ParamCache3Impl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this ParamCache3Impl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }


    /**
     * The data object source to be used by this ParamCache3Impl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this ParamCache3Impl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this ParamCache3Impl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this ParamCache3Impl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }


    /**
     * functions that return cursors use the result cache by default -
     * unless they use OUT params.
     * Calls the database function use_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            useResultCacheB(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<OpbDynamicDataView> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_result_cache_b(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function use_result_cache_b_part2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            useResultCacheBPart2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useResultCacheBPart2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<OpbDynamicDataView> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_result_cache_b_part2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey.getValue());
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * explicitly use the result cache -
     * This should create a warning as out params can't be used as keys.
     * Calls the database function use_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            useResultCacheB2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<OpbDynamicDataView> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_result_cache_b2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function use_result_cache_b2_part2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            useResultCacheB2Part2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB2Part2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<OpbDynamicDataView> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_result_cache_b2_part2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey.getValue());
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView>
            useResultCacheB3(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB3(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<OpbDynamicDataView> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_result_cache_b3(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * functions do not use the scalar result cache by default.
     * Calls the database function use_scalar_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            useScalarResultCacheB(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        Long result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_scalar_result_cache_b(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function use_scalar_result_cache_b_p2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            useScalarResultCacheBP2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheBP2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        Long result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_scalar_result_cache_b_p2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey.getValue());
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * explicitly use the scalar result cache -
     * This should create a warning as out params can't be used as keys.
     * Calls the database function use_scalar_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            useScalarResultCacheB2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        Long result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_scalar_result_cache_b2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function use_scalar_result_cache_b2_p2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            useScalarResultCacheB2P2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB2P2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        Long result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_scalar_result_cache_b2_p2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey.getValue());
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long
            useScalarResultCacheB3(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB3(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        Long result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_scalar_result_cache_b3(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * 
     * Calls the database function use_data_object_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<FieldsId>
            useDataObjectCacheB(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useDataObjectCacheB(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<FieldsId> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_data_object_cache_b(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                FieldsId.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), true);
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * do not use data object cache.
     * Calls the database function use_data_object_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<FieldsId>
            useDataObjectCacheB2(final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useDataObjectCacheB2(OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<FieldsId> result = null;
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN ? := param_cache3.use_data_object_cache_b2(?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                FieldsId.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

    /**
     * 
     * Calls the database procedure use_data_object_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void useDataObjectCacheA(final OpbValueWrapper<java.util.List<FieldsId>> pResult,
            final OpbValueWrapper<Long> pKey)
            throws OpbDataAccessException {
        final String methodName = "useDataObjectCacheA(OpbValueWrapper, OpbValueWrapper)";
    
        logger.entering(CLASS_NAME, methodName);
    
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pResult", pResult);
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName,
                "pKey", pKey);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbConnectionProvider,
                "BEGIN param_cache3.use_data_object_cache_a(?, ?); END;");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
        
        opbCallHelper.registerOutParameter(
                2, java.sql.Types.BIGINT);
        
    
        opbCallHelper.execute();
    
        pResult.setValue(opbDataObjectSource.getResult(
                FieldsId.class,
                opbCallHelper.get(java.sql.ResultSet.class, 1), true));
        pKey.setValue(opbCallHelper.get(Long.class, 2));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}