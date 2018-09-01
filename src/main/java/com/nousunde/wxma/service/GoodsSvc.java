package com.nousunde.wxma.service;

import com.nousunde.wxma.dao.GoodsDAO;
import com.nousunde.wxma.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSvc {
    @Autowired
    private GoodsDAO goodsDAO;

    public List<Goods> getGoods(){
        return goodsDAO.getGoods();
    }

    public Goods getGoodsById(String goodsId){
        if(goodsId.isEmpty() || goodsId == null)
            return null;
        return goodsDAO.getGoodsById(goodsId);
    }

    public Goods getGoodsByBarcode(String barcode){
        if(barcode.isEmpty() || barcode == null)
            return null;
        return goodsDAO.getGoodsByBarcode(barcode);
    }

    public void addGoods(Goods goods){
        if (goods == null)
            return;
        goodsDAO.addGoods(goods);
    }

    public void updateGoods(Goods goods){
        if (goods == null)
            return;
        goodsDAO.updateGoods(goods);
    }

    public void deleteGoods(String goodsId){
        if(goodsId.isEmpty() || goodsId == null)
            return;
        goodsDAO.deleteGoods(goodsId);
    }
}
