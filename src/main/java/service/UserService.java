package service;

import DAO.UserDAOFactory;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static final UserService userService;
    private static final UserDAOFactory userDAOFactory;

    private UserService() {
    }

    static {
        userService = new UserService();
        userDAOFactory = UserDAOFactory.getInstance();
    }

    public static UserService getInstance() {
        return userService;
    }


    public List<User> getAllUsers() throws SQLException {
        return userDAOFactory.getDAO().getAllUsers();
    }

    public void addUser(User user) throws SQLException {
        userDAOFactory.getDAO().addUser(user);
    }

    public void deleteUser(Long id) throws SQLException {
        userDAOFactory.getDAO().deleteUser(id);
    }

    public void updateUser(String firstName, String lastName, Long id) throws SQLException {
        userDAOFactory.getDAO().updateUser(firstName, lastName, id);
    }

    public User getUserById(Long id) throws SQLException {
        return userDAOFactory.getDAO().getUserById(id);
    }
}
