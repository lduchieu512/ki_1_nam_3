package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import entities.User;
import utils.DBUtils;

/**
 * The class contains methods to update and retrieve data from database
 *
 * @author FA
 *
 */
public class UserDao {

	/**
	 * The method to insert a new user into database.
	 *
	 * @param user an user object.
	 * @return true if register successfully.
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean registerUser(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = null;
		try {
			connection = DBUtils.getConnection();
			CallableStatement callableStatement = connection.prepareCall("{call usp_registerUser(?,?,?,?,?)}");
			int param = 0;
			callableStatement.setString(++param, user.getFirstName());
			callableStatement.setString(++param, user.getLastName());
			callableStatement.setString(++param, user.getEmail());
			callableStatement.setString(++param, user.getUserName());
			callableStatement.setString(++param, user.getPassword());
			int result = callableStatement.executeUpdate();

			if (result > 0) {
				return true;
			}
			return false;

		} finally {
			DBUtils.closeConnection(connection);
		}

	}

	public boolean login(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBUtils.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call usp_login(?,?,?)}");
		int param = 0;
		callableStatement.setString(++param, user.getUserName());
		callableStatement.setString(++param, user.getPassword());
		callableStatement.registerOutParameter(++param, java.sql.Types.INTEGER);
		callableStatement.executeUpdate();
		int result = callableStatement.getInt(param);
		DBUtils.closeConnection(connection);
		if (result > 0) {
			return true;
		}
		return false;
	}

	public User findUserByUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBUtils.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call usp_findUserByUserName(?)}");
		int param = 0;
		callableStatement.setString(++param, userName);
		ResultSet resultSet = callableStatement.executeQuery();
		try {
			if (resultSet.next()) {
				User user = new User();
				user.setFirstName(resultSet.getString("FirstName"));
				user.setLastName(resultSet.getString("LastName"));
				user.setEmail(resultSet.getString("Email"));
				user.setUserName(resultSet.getString("UserName"));
				user.setPassword(resultSet.getString("Password"));
				return user;
			}
			return null;
		} finally {
			DBUtils.closeConnection(connection);
		}
	}

	public boolean isExistedEmail(String email) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBUtils.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call usp_findUserByEmail(?)}");
		int param = 0;
		callableStatement.setString(++param, email);
		ResultSet resultSet = callableStatement.executeQuery();
		try {
			if (resultSet.next()) {
				return true;
			}
			return false;
		} finally {
			DBUtils.closeConnection(connection);
		}
	}

	public boolean isExistedUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBUtils.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call usp_findUserByUserName(?)}");
		int param = 0;
		callableStatement.setString(++param, userName);
		ResultSet resultSet = callableStatement.executeQuery();
		try {
			if (resultSet.next()) {
				return true;
			}
			return false;
		} finally {
			DBUtils.closeConnection(connection);
		}
	}

	public void updateUserProfile(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBUtils.getConnection();
		CallableStatement callableStatement = connection.prepareCall("{call usp_updateUserProfile(?,?,?,?)}");
		int param = 0;
		callableStatement.setString(++param, user.getFirstName());
		callableStatement.setString(++param, user.getLastName());
		callableStatement.setString(++param, user.getEmail());
		callableStatement.setString(++param, user.getUserName());
		callableStatement.executeUpdate();
		DBUtils.closeConnection(connection);
	}
}
