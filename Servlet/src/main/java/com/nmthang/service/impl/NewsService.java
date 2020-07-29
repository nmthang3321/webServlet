package com.nmthang.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nmthang.DAO.impl.NewsDAO;
import com.nmthang.model.NewsModel;
import com.nmthang.page.PageRequest;
import com.nmthang.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private NewsDAO newsDAO;

	@Override
	public List<NewsModel> findAll(PageRequest page) {
		return newsDAO.findAll(page);
	}

	@Override
	public int totalItem() {
		return newsDAO.getTotalItem();
	}

	@Override
	public NewsModel findOneById(int id) {
		return newsDAO.findOneById(id);
	}

	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}

}
