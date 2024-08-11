package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //UserDaoJDBCImpl dao = new UserDaoJDBCImpl();
        //dao.createUsersTable();
        //dao.dropUsersTable();

        //dao.saveUser("Bruce", "Lee", (byte) 20);
        //dao.removeUserById(5);

        //dao.getAllUsers();
        //dao.cleanUsersTable();


        UserDaoHibernateImpl daoHibernate = new UserDaoHibernateImpl();
        //daoHibernate.dropUsersTable();
        //daoHibernate.createUsersTable();

        //daoHibernate.saveUser("Olegator", "Gorodenskiy", (byte) 21);
        //daoHibernate.removeUserById(2);

        daoHibernate.getAllUsers();
        //daoHibernate.cleanUsersTable();
    }
    }
