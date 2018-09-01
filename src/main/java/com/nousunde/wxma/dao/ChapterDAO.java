package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.Chapter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class ChapterDAO {
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

    public List<Chapter> getChapters(){
        return this.getSession().createCriteria(Chapter.class).list();
    }

    public List<Chapter> getChapterByBookId(String bookId){
        return this.getSession().createQuery("from Chapter where goods_id = ?")
                .setParameter(0, bookId).list();
    }

    public void addChapter(Chapter chapter){
        this.getSession().save(chapter);
    }

    public void updateChapter(Chapter chapter){
        this.getSession().update(chapter);
    }

    public void deleteChaterById(String chapterId){
        this.getSession().createQuery("delete Chapter where chapter_id = ?")
                .setParameter(0, chapterId).executeUpdate();
    }
}
