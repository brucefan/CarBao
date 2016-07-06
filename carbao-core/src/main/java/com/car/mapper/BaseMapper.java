package com.car.mapper;


/**
 * mapper 基类，封装公用的查询方法
 *
 * @param <T>
 * @param <PK>
 * @author fgm
 */
public interface BaseMapper<T, PK> {

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
