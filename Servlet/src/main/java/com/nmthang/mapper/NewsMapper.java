package com.nmthang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nmthang.model.CategoryModel;
import com.nmthang.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel>{
	
	@Override
	public NewsModel mappRow(ResultSet rs) {
		NewsModel newsModel = new NewsModel();
		CategoryModel categoryModel = new CategoryModel();
		try {
			newsModel.setId(rs.getInt("id"));
			newsModel.setTitle(rs.getString("title"));
			newsModel.setThumnail(rs.getString("thumnail"));
			newsModel.setCategoryId(rs.getInt("category_id"));
			newsModel.setContent(rs.getString("content"));
			newsModel.setShortDescription(rs.getString("short_description"));
			newsModel.setCreateBy(rs.getString("create_by"));
			newsModel.setModifyBy(rs.getString("modify_by"));
			newsModel.setCreateDate(rs.getTimestamp("create_date"));
			newsModel.setModifyDate(rs.getTimestamp("modify_date"));
			
			categoryModel.setCategoryType(rs.getString("category_type"));
			newsModel.setCategoryModel(categoryModel);
			return newsModel;
		} catch (SQLException e) {
			return null;
		}
	}	
}

	

