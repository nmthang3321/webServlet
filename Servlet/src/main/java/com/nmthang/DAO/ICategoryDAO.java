package com.nmthang.DAO;

import java.util.List;

import com.nmthang.model.CategoryModel;

public interface ICategoryDAO {
//	CategoryModel findAllById(int id);
	List<CategoryModel> findAll();
}
