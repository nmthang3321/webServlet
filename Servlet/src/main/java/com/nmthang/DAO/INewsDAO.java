package com.nmthang.DAO;

import java.util.List;

import com.nmthang.model.NewsModel;
import com.nmthang.model.UserModel;
import com.nmthang.page.PageRequest;

public interface INewsDAO {
	List<NewsModel> findAll(PageRequest page);
	int getTotalItem();
	void insert(NewsModel newsModel, String userName);
	void update(NewsModel newsModel, String userName);
	void delete (int ids[]);
	NewsModel findOneById(int id);
	List<NewsModel> findAll();
}
