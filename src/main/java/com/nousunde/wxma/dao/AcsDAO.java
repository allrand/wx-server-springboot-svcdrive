package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.Acs;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class AcsDAO {
    @Resource
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public List<Acs> getAcs() {
        return this.getSession().createCriteria(Acs.class).list();
    }

    public Acs getAcsById(String acsId) {
        return (Acs) this.getSession().createQuery("from Acs where acs_id = ?")
                .setParameter(0, acsId).uniqueResult();
    }

    public Acs getAcsByUserId(String UserId) {
        return (Acs) this.getSession().createQuery("from Acs where user_id = ?")
                .setParameter(0, UserId).uniqueResult();
    }

    public void addAcs(Acs acs) {
        this.getSession().save(acs);
    }

    public void updateAcs(Acs acs) {
        this.getSession().update(acs);
    }

    public void deleteAcsById(String acsId) {
        this.getSession().createQuery("delete Acs where acs_id = ?")
                .setParameter(0, acsId).executeUpdate();

    }
}
