package com.nmthang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nmthang.model.CommentModel;

public class CommentMapper implements IRowMapper<CommentModel>{

	@Override
	public CommentModel mappRow(ResultSet rs) {
		CommentModel commentModel = new CommentModel();
		
		try {
			commentModel.setUserId(rs.getInt("user_id"));
			commentModel.setNewsId(rs.getInt("news_id"));
			commentModel.setContent(rs.getString("content"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
