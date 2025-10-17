package com.morkath.multilang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.morkath.multilang.core.BaseRowMapper;
import com.morkath.multilang.model.User;

public class UserMapper implements BaseRowMapper<User> {
	public static final UserMapper INSTANCE = new UserMapper();

    private UserMapper() {}

    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        User user = new User(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("email"),
            rs.getInt("status")
        );
        return user;
    }
}
