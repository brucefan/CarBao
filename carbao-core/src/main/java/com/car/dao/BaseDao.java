package com.car.dao;/**
 * Created by fanguiming on 16/7/9.
 */

import org.springframework.stereotype.Repository;

/**
 * BaseDao
 *
 * @author Bruce01.fan
 * @date 16/7/9
 */
public interface BaseDao<T, PK> {

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);


}
