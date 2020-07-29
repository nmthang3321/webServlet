package com.nmthang.service.impl;

import javax.inject.Inject;

import com.nmthang.DAO.impl.UserDAO;
import com.nmthang.model.UserModel;
import com.nmthang.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private UserDAO userDAO;
	
	@Override
	public UserModel findByUserAndPassword(String user, String password) {
		return userDAO.findByUserAndPassword(user, password);
	}

	@Override
	public void insert(UserModel userModel) {
		userDAO.insert(userModel);
	}

}
