package com.car.service.impl;

import com.car.dao.BaseDao;
import com.car.mapper.BaseMapper;
import com.car.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaserServiceImpl<T, PK> implements BaseService<T, PK> {

    private BaseDao<T, PK> baseDao;

    public void setBaseDao(BaseDao<T, PK> baseMapper) {
        this.baseDao = baseDao;
    }

    @Override
    public void add(T t) {
        baseDao.insertSelective(t);
    }

    @Override
    public T findById(PK id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public int delete(PK id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    @Override
    public void update(T t) {
        baseDao.updateByPrimaryKeySelective(t);
    }


}
