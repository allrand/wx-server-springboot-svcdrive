package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class BookDAO {
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

    public List<Book> getBooks(){
        return this.getSession().createCriteria(Book.class).list();

    }

    public Book getBookById(String bookId){
        return (Book) this.getSession().createQuery("from Book where goods_id = ?")
                .setParameter(0, bookId).uniqueResult();
    }
    public Book getBookByBarCode(String barcode){
        return (Book) this.getSession().createQuery("from Book where barcode = ?")
                .setParameter(0, barcode).uniqueResult();
    }
    public void addBook(Book book){
        this.getSession().save(book);
    }

    public void updateBook(Book book){
        this.getSession().update(book);
    }

    public void deleteBookById(String bookId){
        this.getSession().createQuery("delete Book where goods_id = ?")
                .setParameter(0, bookId).executeUpdate();
    }
}
