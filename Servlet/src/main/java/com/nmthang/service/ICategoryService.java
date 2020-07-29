package com.nmthang.service;

import java.util.List;

import com.nmthang.model.CategoryModel;

public interface ICategoryService {
//	CategoryModel findAllById(int id);
	List<CategoryModel> findAll();
}
