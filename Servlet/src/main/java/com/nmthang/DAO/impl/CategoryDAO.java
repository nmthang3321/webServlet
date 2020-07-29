package com.nmthang.DAO.impl;

import java.util.List;

import com.nmthang.DAO.ICategoryDAO;
import com.nmthang.mapper.CategoryMapper;
import com.nmthang.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

//	@Override
//	public CategoryModel findAllById(int id) {
//		String sql = "SELECT * FROM category WHERE id = ?";
//		List<CategoryModel> result = query(sql, new CategoryMapper(), id);
//		return result != null ? result.get(0) : null;
//	}

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}
