package com.nmthang.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.nmthang.DAO.GenericDAO;
import com.nmthang.mapper.IRowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	public Connection getConnection() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> mapper, Object... parameters) {
		List<T> result = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			rs = statement.executeQuery();
			while (rs.next()) {
				result.add(mapper.mappRow(rs));
			}
			return result;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void setParameters(PreparedStatement statement, Object... parameters) {
		try {
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					if (parameters[i] instanceof String) {
						statement.setString(i + 1, (String) parameters[i]);
					} else if (parameters[i] instanceof Integer) {
						statement.setInt(i + 1, (int) parameters[i]);
					} else if (parameters[i] instanceof Double) {
						statement.setDouble(i + 1, (Double) parameters[i]);
					} else if (parameters[i] instanceof Timestamp) {
						statement.setTimestamp(i + 1, (Timestamp) parameters[i]);
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.getMessage();
			}

		}
	}

	@Override
	public int count(String sql) {
		java.sql.Statement statement = null;
		Connection connection = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		return count;
	}
	
	
}
