package com.morkath.multilang.core;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseRowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
