package com.nousunde.wxma.service;

import com.nousunde.wxma.entity.Goods;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsSvcTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    GoodsSvc goodsSvc;


    @Ignore
    @Test
    public void getGoods() {
        List<Goods> goodsList = goodsSvc.getGoods();
        assertEquals(2, goodsList.size());
    }

    @Ignore
    @Test
    public void getGoodsById() {
        Goods goods = goodsSvc.getGoodsById("ff808081651768c501651768d3d10000");
        //ff808081651729480165172954f30001
        assertEquals("Textsurfer red", goods.getGoodsName());
    }

    @Ignore
    @Test
    public void addGoods() {
        Goods goods = new Goods();
        goods.setGoodsName("Textsurfer red");
        goods.setBarCode("4007817304440");
//        goods.setBarCode("4007817304679");
        goods.setBarCodeType("EAN_13");
//        goods.setCategoryId(60013);//book
        goods.setCategoryId(574710238);//stationery
        goodsSvc.addGoods(goods);

        Goods goods1 = new Goods();
        goods1.setGoodsName("Textsurfer yellow");
        goods1.setBarCode("4007817304679");
        goods1.setBarCodeType("EAN_13");
        goods1.setCategoryId(574710238);
        goodsSvc.addGoods(goods1);
    }

    @Ignore
    @Test
    public void updateGoods() {
    }

    @Ignore
    @Test
    public void deleteGoods() {
    }
}