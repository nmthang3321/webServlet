package com.nmthang.DAO.impl;

import java.util.List;

import com.nmthang.DAO.IUserDAO;
import com.nmthang.mapper.UserMapper;
import com.nmthang.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserAndPassword(String user, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user");
		sql.append(" INNER JOIN role ON user.role_id = role.id");
		sql.append(" WHERE user_name = ? AND password = ?");
		List<UserModel> result = query(sql.toString(), new UserMapper(), user, password);
		return !result.isEmpty() ? result.get(0) : null;
	}

	@Override
	public void insert(UserModel userModel) {
		String sql = "INSERT INTO user (user_name, password, role_id) VALUES (?, ?, 2)";
		update(sql, userModel.getUserName(), userModel.getPassword());
	}

	@Override
	public UserModel findUsernameById(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> result = query(sql, new UserMapper(), id);
		return !result.isEmpty() ? result.get(0) : null;
	}

}
