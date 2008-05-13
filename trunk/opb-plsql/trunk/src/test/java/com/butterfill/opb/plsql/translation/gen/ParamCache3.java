/*
 * File created by opb-plsql.
 * 
 *  version: 
 * opb-core version: 1.0.0
 */

package com.butterfill.opb.plsql.translation.gen;

import com.butterfill.opb.data.*;
import com.butterfill.opb.groups.*;
import com.butterfill.opb.timing.*;
import com.butterfill.opb.util.*;

/**
 * File created from the PL/SQL package specification
 * param_cache3.
 */
public interface ParamCache3
        extends OpbGroupable, OpbTimingEventPublisher,
        OpbActiveDataObject {

    /**
     * functions that return cursors use the result cache by default -
     * unless they use OUT params.
     * Calls the database function use_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function use_result_cache_b_part2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheBPart2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * explicitly use the result cache -
     * This should create a warning as out params can't be used as keys.
     * Calls the database function use_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function use_result_cache_b2_part2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB2Part2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<OpbDynamicDataView> useResultCacheB3(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * functions do not use the scalar result cache by default.
     * Calls the database function use_scalar_result_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function use_scalar_result_cache_b_p2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheBP2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * explicitly use the scalar result cache -
     * This should create a warning as out params can't be used as keys.
     * Calls the database function use_scalar_result_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function use_scalar_result_cache_b2_p2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB2P2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * do not use the scalar result cache.
     * Calls the database function use_scalar_result_cache_b3.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    Long useScalarResultCacheB3(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * 
     * Calls the database function use_data_object_cache_b.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<FieldsId> useDataObjectCacheB(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    
    /**
     * do not use data object cache.
     * Calls the database function use_data_object_cache_b2.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    java.util.List<FieldsId> useDataObjectCacheB2(OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException; 
    

    /**
     * 
     * Calls the database procedure use_data_object_cache_a.
     * @throws OpbDataAccessException
     *   If we fail to make the database call.
     */
    void useDataObjectCacheA(OpbValueWrapper<java.util.List<FieldsId>> pResult,
            OpbValueWrapper<Long> pKey) 
            throws OpbDataAccessException;
    

}