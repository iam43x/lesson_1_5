package DAO;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    public UserJdbcDAO() {
    }


    public void createTable() throws SQLException {
        Statement stmt = DBHelper.getConnection().createStatement();
        stmt.execute("create table if not exists user_db (id bigint auto_increment," +
                " login varchar(256),password varchar(256),role varchar(6),primary key(id))");
        stmt.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {

        List<User> res = new ArrayList<>();

        Statement stmt = DBHelper.getConnection().createStatement();
        stmt.execute("select*from user_db");
        ResultSet resultSet = stmt.getResultSet();
        while (resultSet.next()) {
            res.add(new User(resultSet.getLong(1), resultSet.getString(2)
                    , resultSet.getString(3),resultSet.getString(4)));
        }
        stmt.close();
        return res;
    }

    @Override
    public void addUser(User user) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().
                prepareStatement("insert into user_db (login, password,role) value ((?),(?),(?))");
        pstmt.setString(1, user.getLogin());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3,user.getRole());
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public void updateUser(String login, String password,String role, Long id) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().
                prepareStatement("Update user_db set login=(?), password=(?),role=(?)" +
                        " where id=(?)");
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        pstmt.setString(3, role);
        pstmt.setLong(4,id);
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().
                prepareStatement("delete from user_db where id=(?)");
        pstmt.setLong(1, id);
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().
                prepareStatement("select*from user_db where id=(?)");
        pstmt.setLong(1, id);
        ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();
        String login = resultSet.getString(2);
        String password = resultSet.getString(3);
        String role = resultSet.getString(4);
        pstmt.close();
        return new User(id, login, password,role);
    }

    @Override
    public String availableUser(String login, String password) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().
                prepareStatement("select*from user_db where login=(?) and password=(?)");
        pstmt.setString(1, login);
        pstmt.setString(2,password);
        ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();
        String role=resultSet.getString(4);
        pstmt.close();
        return role;
    }
}
