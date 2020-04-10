package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    public UserHibernateDAO() {
    }

    @Override
    public List<User> getAllUsers() {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> res = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return res;
    }

    @Override
    public void addUser(User user) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    @Override
    public void deleteUser(Long id) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(String login, String password, String role, Long id) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("update from User u set u.login=:login, u.password=:password,u.role=:role where id=:id").
                setParameter("id", id).
                setParameter("login", login).
                setParameter("password", password).
                setParameter("role", role).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User where id=:id").
                setParameter("id", id).list();
        transaction.commit();
        session.close();
        return users.get(0);
    }

    @Override
    public String availableUser(String login, String password) throws SQLException {
        Session session = DBHelper.getSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("from User where login=:login and password=:password").
                setParameter("login", login).setParameter("password", password).list();
        transaction.commit();
        session.close();
        if(!users.isEmpty()){
            return users.get(0).getRole();
        }
        return "";
    }
}
