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
 * param_cache.
 */
public interface ParamCache
        extends OpbActiveDataObject, OpbScalarResultCacheUser {

    /**
     * functions that return cursors use the result cache by default -
     * use_data_object_cache=Y will be ignored
     * use_scalar_result_cache=Y will be ignored.
     * Calls the database function use_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB()
            throws OpbDataAccessException;
    
    /**
     * explicitly use the result cache.
     * Calls the database function use_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB2()
            throws OpbDataAccessException;
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB3()
            throws OpbDataAccessException;
    
    /**
     * functions do not use the scalar result cache by default.
     * Calls the database function use_scalar_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB()
            throws OpbDataAccessException;
    
    /**
     * explicitly use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB2()
            throws OpbDataAccessException;
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB3()
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database function use_data_object_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<FieldsId> useDataObjectCacheB()
            throws OpbDataAccessException;
    
    /**
     * do not use data object cache.
     * Calls the database function use_data_object_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<FieldsId> useDataObjectCacheB2()
            throws OpbDataAccessException;
    

    /**
     * out params can't use the result cache.
     * Calls the database procedure use_result_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useResultCacheA(OpbValueWrapper<java.util.List<OpbDynamicDataView>> pData)
            throws OpbDataAccessException;
    
    /**
     * out params can't use the scalar result cache.
     * Calls the database procedure use_scalar_result_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useScalarResultCacheA(OpbValueWrapper<Long> pData)
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure use_data_object_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useDataObjectCacheA(OpbValueWrapper<java.util.List<FieldsId>> pResult)
            throws OpbDataAccessException;
    

}