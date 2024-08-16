package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void createUsersTable() {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        UserDao userDao = new UserDaoHibernateImpl();
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.cleanUsersTable();
    }
}
