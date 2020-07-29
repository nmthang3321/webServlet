package com.nmthang.service;

import com.nmthang.model.UserModel;

public interface IUserService {
	UserModel findByUserAndPassword(String user, String password);
	void insert(UserModel userModel);
}
