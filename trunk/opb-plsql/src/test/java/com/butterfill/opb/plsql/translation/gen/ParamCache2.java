/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.1.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * param_cache2.
 */
public interface ParamCache2
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject, OpbScalarResultCacheUser {

    /**
     * functions that return cursors use the result cache by default -
     * use_data_object_cache=Y will be ignored
     * use_scalar_result_cache=Y will be ignored.
     * Calls the database function use_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * explicitly use the result cache.
     * Calls the database function use_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB2(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB3(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * functions do not use the scalar result cache by default.
     * Calls the database function use_scalar_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * explicitly use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB2(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB3(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function use_data_object_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<FieldsId> useDataObjectCacheB(Long pKey) 
            throws OpbDataAccessException; 
    
    /**
     * do not use data object cache.
     * Calls the database function use_data_object_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<FieldsId> useDataObjectCacheB2(Long pKey) 
            throws OpbDataAccessException; 
    

    /**
     * out params can't use the result cache.
     * Calls the database procedure use_result_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useResultCacheA(OpbValueWrapper<java.util.List<OpbDynamicDataView>> pData,
            String pKey) 
            throws OpbDataAccessException;
    
    /**
     * out params can't use the scalar result cache.
     * Calls the database procedure use_scalar_result_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useScalarResultCacheA(OpbValueWrapper<Long> pData,
            Long pKey) 
            throws OpbDataAccessException;
    
    /**
     * 
     * Calls the database procedure use_data_object_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useDataObjectCacheA(OpbValueWrapper<java.util.List<FieldsId>> pResult,
            Long pKey) 
            throws OpbDataAccessException;
    

}