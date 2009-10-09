/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.1.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.*;
import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;
import com.butterfill.opb.plsql.util.*;
import java.util.logging.*;

/**
 * File created from the PL/SQL package specification
 * param_cache2.
 */
public class ParamCache2Impl implements ParamCache2 {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            ParamCache2Impl.class.getName();
            
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    
    /**
     * Creates a new instance of ParamCache2Impl.
     */
    public ParamCache2Impl() {
        logger.entering(CLASS_NAME, "ParamCache2Impl()");
    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return A String representation of this ParamCache2Impl.
     */
    @Override
    public String toString() {
        return com.butterfill.opb.util.OpbToStringHelper.toString(this);
    }
    
    /**
     * The group mananger map to be used by this ParamCache2Impl.
     */
    private OpbGroupManagerMap opbGroupManagerMap;

    /**
     * Sets the group manager map to be used by this ParamCache2Impl.
     * @param map The group manager map to use.
     */
    public void setGroupManagerMap(final OpbGroupManagerMap map) {
        this.opbGroupManagerMap = map;
    }

    /**
     * Returns the group manager map used by this ParamCache2Impl.
     * @return The group manager map used by this instance.
     */
    public OpbGroupManagerMap getGroupManagerMap() {
        return opbGroupManagerMap;
    }
    

    /**
     * The event timer provider to be used by this ParamCache2Impl.
     */
    private OpbEventTimerProvider opbEventTimerProvider;

    /**
     * Sets the event timer to be used by this ParamCache2Impl.
     * @param provider The event timer to use.
     */
    public void setOpbEventTimerProvider(final OpbEventTimerProvider provider) {
        this.opbEventTimerProvider = provider;
    }

    
    /**
     * The data object source to be used by this ParamCache2Impl.
     */
    private OpbDataObjectSource opbDataObjectSource;

    /**
     * Sets the data object source to be used by this ParamCache2Impl.
     * @param source The data object source to use.
     */
    public void setOpbDataObjectSource(final OpbDataObjectSource source) {
        this.opbDataObjectSource = source;
    }


    /**
     * The connection provider to be used by this ParamCache2Impl.
     */
    private OpbConnectionProvider opbConnectionProvider;

    /**
     * Sets the connection provider to be used by this ParamCache2Impl.
     * @param provider The connection provider to use.
     */
    public void setOpbConnectionProvider(final OpbConnectionProvider provider) {
        this.opbConnectionProvider = provider;
    }

    /**
     * The scalar result cache provider to be used by this DiscrepancyImpl.
     */
    private OpbScalarResultCacheProvider opbScalarResultCacheProvider;

    /**
     * Sets the scalar result cache provider to be used by this DiscrepancyImpl.
     * @param provider The scalar result cache provider to use.
     */
    public void setOpbScalarResultCacheProvider(final OpbScalarResultCacheProvider provider) {
        this.opbScalarResultCacheProvider = provider;
    }
    
    /**
     * functions that return cursors use the result cache by default -
     * use_data_object_cache=Y will be ignored
     * use_scalar_result_cache=Y will be ignored.
     * Calls the database function use_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView> 
            useResultCacheB(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "param_cache2.use_result_cache_b",
                pKey);
    
        java.util.List<OpbDynamicDataView> result = 
                opbDataObjectSource.getCachedResult(
                OpbDynamicDataView.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_result_cache_b(?); END;",
                "DbCall:param_cache2#use_result_cache_b(integer)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * explicitly use the result cache.
     * Calls the database function use_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public java.util.List<OpbDynamicDataView> 
            useResultCacheB2(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB2(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "param_cache2.use_result_cache_b2",
                pKey);
    
        java.util.List<OpbDynamicDataView> result = 
                opbDataObjectSource.getCachedResult(
                OpbDynamicDataView.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_result_cache_b2(?); END;",
                "DbCall:param_cache2#use_result_cache_b2(integer)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
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
            useResultCacheB3(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useResultCacheB3(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        java.util.List<OpbDynamicDataView> result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_result_cache_b3(?); END;",
                "DbCall:param_cache2#use_result_cache_b3(integer)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1));
    
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
            useScalarResultCacheB(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_scalar_result_cache_b(?); END;",
                "DbCall:param_cache2#use_scalar_result_cache_b(integer)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    
    /**
     * explicitly use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public Long 
            useScalarResultCacheB2(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB2(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "Scalar Result Cache Provider", opbScalarResultCacheProvider);
        
        OpbId keyToResult = new OpbId(
                "param_cache2.use_scalar_result_cache_b2",
                pKey);
        
        OpbScalarResultCache opbScalarResultCache = 
                opbScalarResultCacheProvider.getScalarResultCache();
    
        if (opbScalarResultCache.isCached(keyToResult)) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return opbScalarResultCache.getCached(Long.class, keyToResult);
        }
    
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_scalar_result_cache_b2(?); END;",
                "DbCall:param_cache2#use_scalar_result_cache_b2(integer)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
        opbScalarResultCache.cache(keyToResult, result);
    
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
            useScalarResultCacheB3(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheB3(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        Long result = null;
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_scalar_result_cache_b3(?); END;",
                "DbCall:param_cache2#use_scalar_result_cache_b3(integer)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbCallHelper.get(Long.class, 1);
    
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
            useDataObjectCacheB(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useDataObjectCacheB(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "param_cache2.use_data_object_cache_b",
                pKey);
    
        java.util.List<FieldsId> result = 
                opbDataObjectSource.getCachedResult(
                FieldsId.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_data_object_cache_b(?); END;",
                "DbCall:param_cache2#use_data_object_cache_b(integer)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                FieldsId.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult, true);
    
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
            useDataObjectCacheB2(final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useDataObjectCacheB2(Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "DataObjectSource", opbDataObjectSource);
    
        OpbId keyToResult = new OpbId(
                "param_cache2.use_data_object_cache_b2",
                pKey);
    
        java.util.List<FieldsId> result = 
                opbDataObjectSource.getCachedResult(
                FieldsId.class, keyToResult);
        
        if (result != null) {
            logger.logp(Level.FINER, CLASS_NAME, methodName,
                    "cached result found. returning");
            return result;
        }
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN ? := param_cache2.use_data_object_cache_b2(?); END;",
                "DbCall:param_cache2#use_data_object_cache_b2(integer)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
    
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        result = opbDataObjectSource.getResult(
                FieldsId.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), keyToResult);
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
        return result;
    
    }
    

    /**
     * out params can't use the result cache.
     * Calls the database procedure use_result_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void useResultCacheA(final OpbValueWrapper<java.util.List<OpbDynamicDataView>> pData,
            final String pKey) 
            throws OpbDataAccessException {
        final String methodName = "useResultCacheA(OpbValueWrapper, String)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pData", pData);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN param_cache2.use_result_cache_a(?, ?); END;",
                "DbCall:param_cache2#use_result_cache_a(sys_refcursor, varchar2)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
        
        opbCallHelper.setObject(
                2, java.sql.Types.VARCHAR, pKey);
        
    
        opbCallHelper.execute();
    
        pData.setValue(opbDataObjectSource.getResult(
                OpbDynamicDataView.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1)));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * out params can't use the scalar result cache.
     * Calls the database procedure use_scalar_result_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void useScalarResultCacheA(final OpbValueWrapper<Long> pData,
            final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useScalarResultCacheA(OpbValueWrapper, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pData", pData);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN param_cache2.use_scalar_result_cache_a(?, ?); END;",
                "DbCall:param_cache2#use_scalar_result_cache_a(integer, integer)");
    
        opbCallHelper.registerOutParameter(
                1, java.sql.Types.BIGINT);
        
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        pData.setValue(opbCallHelper.get(Long.class, 1));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    
    /**
     * 
     * Calls the database procedure use_data_object_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    public void useDataObjectCacheA(final OpbValueWrapper<java.util.List<FieldsId>> pResult,
            final Long pKey) 
            throws OpbDataAccessException {
        final String methodName = "useDataObjectCacheA(OpbValueWrapper, Long)";
    
        logger.entering(CLASS_NAME, methodName);
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, 
                "pResult", pResult);
    
        OpbPlsqlCallHelper opbCallHelper = new OpbPlsqlCallHelper(
                logger, CLASS_NAME, methodName,
                opbEventTimerProvider,
                opbConnectionProvider,
                "BEGIN param_cache2.use_data_object_cache_a(?, ?); END;",
                "DbCall:param_cache2#use_data_object_cache_a(sys_refcursor, integer)");
    
        opbCallHelper.registerOutParameter(
                1, oracle.jdbc.OracleTypes.CURSOR);
        
        opbCallHelper.setObject(
                2, java.sql.Types.BIGINT, pKey);
        
    
        opbCallHelper.execute();
    
        pResult.setValue(opbDataObjectSource.getResult(
                FieldsId.class, 
                opbCallHelper.get(java.sql.ResultSet.class, 1), true));
    
        opbCallHelper.callComplete();
    
        logger.exiting(CLASS_NAME, methodName);
    
    }
    

}