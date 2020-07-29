package com.nmthang.service;

import java.util.List;

import com.nmthang.model.NewsModel;
import com.nmthang.page.PageRequest;

public interface INewsService {
	List<NewsModel> findAll(PageRequest page);
	int totalItem();
	NewsModel findOneById(int id);
	List<NewsModel> findAll();
}
