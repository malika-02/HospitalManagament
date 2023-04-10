package com.hospital.ns.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.models.Login;

@Repository
@EnableTransactionManagement
@Transactional
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Login validateLogin(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query<Login> query = session.createQuery("from Login where username=:username and password=:password", Login.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Login> logins = query.getResultList();
        if (!logins.isEmpty()) {
            return logins.get(0);
        }
        return null;
    }
}

