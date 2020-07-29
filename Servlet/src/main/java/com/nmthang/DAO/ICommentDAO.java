package com.nmthang.DAO;

import com.nmthang.model.CommentModel;

public interface ICommentDAO {
	void insert(CommentModel commentModel);
	void update(CommentModel commentModel);
	void delete(CommentModel commentModel);
}
