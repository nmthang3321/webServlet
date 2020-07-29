package com.nmthang.mapper;

import java.sql.ResultSet;

public interface IRowMapper <T>{
	T mappRow(ResultSet rs);
}
