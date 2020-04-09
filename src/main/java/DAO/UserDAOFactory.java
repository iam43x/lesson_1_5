package DAO;

import util.DBHelper;

import java.io.IOException;
import java.util.Properties;

public class UserDAOFactory {

    private static UserDAOFactory daoFactory;

    private UserDAO dao;

    private UserDAOFactory(UserDAO dao) {
        this.dao = dao;
    }

    public static UserDAOFactory getInstance() {
        return daoFactory == null ? new UserDAOFactory(getDAOType()) : daoFactory;
    }

    private static UserDAO getDAOType() {
        try {
            Properties config = new Properties();
            config.load(UserDAOFactory.class
                    .getClassLoader().getResourceAsStream("dao.properties"));
            return config.getProperty("daotype").equalsIgnoreCase("jdbc") ?
                    new UserJdbcDAO() : new UserHibernateDAO();
        } catch (IOException e) {
            return new UserHibernateDAO();
        }
    }

    public UserDAO getDAO() {
        return this.dao;
    }
}
