package com.morkath.multilang.dao.impl;

import javax.persistence.*;
import org.springframework.stereotype.Repository;

import com.morkath.multilang.core.BaseDaoImpl;
import com.morkath.multilang.dao.UserDao;
import com.morkath.multilang.entity.UserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity, Long> implements UserDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	public UserDaoImpl() {
        super(UserEntity.class);
    }

    @Override
    public UserEntity findByUsername(String username) {
        TypedQuery<UserEntity> query = entityManager.createQuery(
            "SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public UserEntity findByEmail(String email) {
        TypedQuery<UserEntity> query = entityManager.createQuery(
            "SELECT u FROM UserEntity u WHERE u.email = :email", UserEntity.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst().orElse(null);
    }
	
	
}
