package com.morkath.multilang.core;

import java.util.List;
import java.util.Map;

public interface BaseService<T, ID> {
  List<T> findAll();
  T findById(ID id);
  T create(T dto);
  T update(T dto);
  T partialUpdate(ID id, Map<String, Object> fields);
  boolean delete(ID id);
}
