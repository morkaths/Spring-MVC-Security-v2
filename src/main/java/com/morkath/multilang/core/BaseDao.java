package com.morkath.multilang.core;

import java.util.List;

public interface BaseDao<T, ID> {
    public List<T> findAll();
    public List<T> findAllByField(String fieldName, Object value);
    public T findById(ID id);
    public T findOneByField(String fieldName, Object value);
    public T save(T entity);
    public T update(T entity);
    public void delete(ID id);
}
