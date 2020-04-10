package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers() throws SQLException;

    void addUser(User user) throws SQLException;

    void deleteUser(Long id) throws SQLException;

    void updateUser(String login, String password, String role, Long id) throws SQLException;

    User getUserById(Long id) throws SQLException;

    String availableUser(String login, String password) throws SQLException;
}
