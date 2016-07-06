package com.car.service.impl;

import com.car.mapper.BaseMapper;
import com.car.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaserServiceImpl<T, PK> implements BaseService<T, PK> {

    private BaseMapper<T, PK> baseMapper;

    public void setBaseMapper(BaseMapper<T, PK> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public void add(T t) {
        baseMapper.insertSelective(t);
    }

    @Override
    public T findById(PK id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(PK id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(T t) {
        baseMapper.updateByPrimaryKeySelective(t);
    }


}
