package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.Goods;
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
public class GoodsDAO {
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

    public List<Goods> getGoods(){
        return this.getSession().createCriteria(Goods.class).list();
    }

    public Goods getGoodsById(String goodsId){
        return (Goods)this.getSession().createQuery("from Goods where goods_id = ?")
                .setParameter(0, goodsId).uniqueResult();
    }

    public Goods getGoodsByBarcode(String barcode){
        return (Goods)this.getSession().createQuery("from Goods where barcode = ?")
                .setParameter(0, barcode).uniqueResult();
    }
    public void addGoods(Goods goods){
        this.getSession().save(goods);
    }

    public void updateGoods(Goods goods){
        this.getSession().update(goods);
    }

    public void deleteGoods(String goodsId){
        this.getSession().createQuery("delete Goods where goods_id = ?")
                .setParameter(0, goodsId).executeUpdate();
    }
}
