package model;

import repository.impl.IUserDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDao implements IUserDao {

    private boolean registerUser(User user) throws ClassNotFoundException, IOException, SQLException {
        Connection connection = null;

        return false;
    }
    private boolean login(User user) throws ClassNotFoundException, IOException, SQLException {
        return false;
    }
    private User findUserByUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
        return null;
    }
    private boolean isExistedEmail(String email) throws ClassNotFoundException, IOException, SQLException {
        return false;
    }
    private boolean isExistedUserName(String userName) throws ClassNotFoundException, IOException, SQLException {
        return false;
    }
    private void updateUserProfile(User user) throws ClassNotFoundException, IOException, SQLException {

    }
}
