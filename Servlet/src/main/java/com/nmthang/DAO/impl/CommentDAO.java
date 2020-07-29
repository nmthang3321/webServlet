package com.nmthang.DAO.impl;

import java.sql.Timestamp;

import com.nmthang.DAO.ICommentDAO;
import com.nmthang.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO{

	@Override
	public void insert(CommentModel commentModel) {
		String sql = "INSERT INTO comment (content, user_id, news_id, create_date) VALUES (?, ?, ?, ?)";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		commentModel.setCreateDate(timestamp);
		update(sql, commentModel.getContent(), commentModel.getUserId(), commentModel.getNewsId(), commentModel.getCreateDate());
	}

	@Override
	public void update(CommentModel commentModel) {
		String sql = "UPDATE comment SET content = ? WHERE id = ?";
		update(sql, commentModel.getId());
	}

	@Override
	public void delete(CommentModel commentModel) {
		String sql = "DELETE FROM comment WHERE id = ?";
		update(sql, commentModel.getId());
		
	}

}
