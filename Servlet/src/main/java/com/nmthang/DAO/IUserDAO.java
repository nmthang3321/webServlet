package com.nmthang.DAO;

import com.nmthang.model.UserModel;

public interface IUserDAO {
	UserModel findByUserAndPassword(String user, String password);
	void insert(UserModel userModel);
	UserModel findUsernameById(int id);
}
