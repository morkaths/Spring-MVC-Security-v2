package com.morkath.multilang.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class BaseDaoImpl<T, ID> implements BaseDao<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public BaseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }
    
    @Override
    public List<T> findAllByField(String fieldName, Object value) {
		String queryString = "FROM " + entityClass.getSimpleName() + " WHERE " + fieldName + " = :value";
		return entityManager.createQuery(queryString, entityClass)
				.setParameter("value", value)
				.getResultList();
	}

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }
    
    @Override
    public T findOneByField(String fieldName, Object value) {
		String queryString = "FROM " + entityClass.getSimpleName() + " WHERE " + fieldName + " = :value";
		List<T> results = entityManager.createQuery(queryString, entityClass)
	            .setParameter("value", value)
	            .getResultList();
	    return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        T savedEntity = entityManager.merge(entity);
        entityManager.flush();
        return savedEntity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(ID id) {
		T entity = findById(id);
		if (entity != null) {
			entityManager.remove(entity);
		}
	}
}
