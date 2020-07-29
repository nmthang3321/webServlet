package com.nmthang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nmthang.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel>{

	@Override
	public CategoryModel mappRow(ResultSet rs) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setId(rs.getInt("id"));
			categoryModel.setCategoryType(rs.getString("category_type"));
			return categoryModel;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

}
