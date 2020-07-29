package com.nmthang.DAO.impl;

import java.sql.Timestamp;
import java.util.List;

import com.nmthang.DAO.INewsDAO;
import com.nmthang.mapper.NewsMapper;
import com.nmthang.model.NewsModel;
import com.nmthang.model.UserModel;
import com.nmthang.page.PageRequest;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

	
	@Override
	public List<NewsModel> findAll (PageRequest page) {
		String sql = "SELECT * FROM news INNER JOIN category ON news.category_id = category.id ORDER BY news."+
						page.getSoter().getSortBy() + " " + page.getSoter().getSortName() + "  LIMIT " + 
						page.minLimit() + ", " +  page.maxLimit();
		return query(sql.toString(), new NewsMapper());
	}
	
	@Override
	public List<NewsModel> findAll(){
		String sql = "SELECT * FROM news INNER JOIN category ON news.category_id = category.id";
		return query(sql, new NewsMapper());
	}

	@Override
	public void insert (NewsModel newsModel, String userName) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		newsModel.setCreateDate(timestamp);
		newsModel.setModifyDate(timestamp);
		newsModel.setCreateBy(userName);
		StringBuilder sql = new StringBuilder();
		sql.append ("INSERT INTO news (title, category_id, short_description, content, create_date, modify_date, create_by) ");
		sql.append ("VALUES (?, ?, ?, ?, ?, ?, ?)");
		update (sql.toString(), newsModel.getTitle(), newsModel.getCategoryId(), newsModel.getShortDescription(), 
				newsModel.getContent(), newsModel.getCreateDate(), newsModel.getModifyDate(), newsModel.getCreateBy());
	}

	@Override
	public void update(NewsModel newsModel, String userName) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		newsModel.setModifyDate(timestamp);
		newsModel.setModifyBy(userName);
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE news SET title = ?, category_id = ?, short_description = ?, ");
		sql.append("content = ?, modify_date = ?, modify_by = ?  WHERE id = ?");
		update (sql.toString(), newsModel.getTitle(), newsModel.getCategoryId(), newsModel.getShortDescription(),
						newsModel.getContent(), newsModel.getModifyDate(), newsModel.getModifyBy(), newsModel.getId());
	}

	@Override
	public void delete(int[] ids) {
		String sql = "DELETE FROM news WHERE id = ?";
		for (int i : ids) {
			update (sql, i);
		}
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) from news";
		return count(sql);
	}

	@Override
	public NewsModel findOneById(int id) {
		String sql = "SELECT * FROM news INNER JOIN category ON news.category_id = category.id WHERE news.id = ?";
		List<NewsModel> result = query(sql, new NewsMapper(), id);
		return result != null ? result.get(0) : null;
	}

}
