package com.car.service;


public interface BaseService<T, PK> {

    public void add(T t);

    public T findById(PK id);

    public int delete(PK id);

    public void update(T t);

}
