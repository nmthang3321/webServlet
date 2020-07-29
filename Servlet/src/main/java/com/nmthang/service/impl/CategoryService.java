package com.nmthang.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nmthang.DAO.impl.CategoryDAO;
import com.nmthang.model.CategoryModel;
import com.nmthang.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private CategoryDAO categoryDAO;
	
//	@Override
//	public CategoryModel findAllById(int id) {
//		return categoryDAO.findAllById(id);
//	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
