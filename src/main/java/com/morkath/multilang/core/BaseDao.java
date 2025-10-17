package com.morkath.multilang.core;

import java.util.List;

public interface BaseDao<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    T update(T entity);
    void delete(T entity);
}
