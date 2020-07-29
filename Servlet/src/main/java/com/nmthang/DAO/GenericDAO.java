package com.nmthang.DAO;

import java.util.List;

import com.nmthang.mapper.IRowMapper;

public interface GenericDAO <T> {
	List<T> query(String sql, IRowMapper<T> mapper, Object...parameters);
	void update(String sql, Object...parameters);
	int count(String sql);
}
