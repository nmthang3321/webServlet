package com.nmthang.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nmthang.model.RoleModel;
import com.nmthang.model.UserModel;

public class UserMapper implements IRowMapper<UserModel>{

	@Override
	public UserModel mappRow(ResultSet rs) {
		UserModel userModel = new UserModel();
		try {
			userModel.setId(rs.getInt("id"));
			userModel.setPassword(rs.getString("password"));
			userModel.setUserName(rs.getString("user_name"));
			userModel.setRoleId(rs.getInt("role_id"));
			
			RoleModel roleModel = new RoleModel();
			roleModel.setCode(rs.getString("code"));
			userModel.setRole(roleModel);
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
