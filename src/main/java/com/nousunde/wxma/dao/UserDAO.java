package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class UserDAO {
    @Resource
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public List<User> getUsers() {
        return this.getSession().createCriteria(User.class).list();
    }

    public void addUser(User user) {
        this.getSession().save(user);
    }

    public User getUserByUserId(String userId) {
        return (User) this.getSession().createQuery("from User where user_id = ?")
                .setParameter(0, userId).uniqueResult();
    }

    public User getUserByAccount(String account) {
        Query query = this.getSession().createQuery("from User where user_name = ?")
                .setParameter(0, account);
        return (User) query.uniqueResult();
    }

    public void updateUser(User user) {
        this.getSession().update(user);
    }

    public void deleteUserById(String userId) {
        this.getSession().createQuery("delete User where user_id = ?")
                .setParameter(0, userId).executeUpdate();
    }
}
