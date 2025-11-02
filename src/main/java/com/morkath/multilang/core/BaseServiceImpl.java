package com.morkath.multilang.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseServiceImpl<T, E, ID> implements BaseService<T, ID> {
  protected final JpaRepository<E, ID> repository;

  @Autowired
  public BaseServiceImpl(JpaRepository<E, ID> repository) {
    this.repository = repository;
  }
}
