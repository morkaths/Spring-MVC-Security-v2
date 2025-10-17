package com.morkath.multilang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.morkath.multilang.core.BaseRowMapper;
import com.morkath.multilang.model.Language;

public final class LanguageMapper implements BaseRowMapper<Language> {
	public static final LanguageMapper INSTANCE = new LanguageMapper();

    private LanguageMapper() {}
    
	@Override
	public Language mapRow(ResultSet rs) throws SQLException {
		return new Language(
			rs.getString("LanguageID"), 
			rs.getString("Language")
		);
	}
	
}
