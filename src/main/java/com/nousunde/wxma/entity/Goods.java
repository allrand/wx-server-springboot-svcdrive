package com.nousunde.wxma.entity;


import net.sf.json.JSONObject;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_goods")
//
public class Goods {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    @Id
    @Column(name = "goods_id", nullable = false, unique = true)
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    public String getGoodsId() {
        return GoodsId;
    }

//    @GenericGenerator(name = "increment", strategy = "increment")
//    @GeneratedValue(generator = "increment")
//    @Id
//    @Column(name = "goods_id", unique = true, nullable = false)
//    public Long getGoodId() {
//        return GoodId;
//    }
//
    public void setGoodsId(String goodsId) {
        GoodsId = goodsId;
    }

    @Column(name = "goods_name")
    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    @Column(name = "barcode")
    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }

    @Column(name = "barcode_type")
    public String getBarCodeType() {
        return BarCodeType;
    }

    public void setBarCodeType(String barCodeType) {
        BarCodeType = barCodeType;
    }

    @Column(name = "category_id")
    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    @Column(name = "price")
    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Column(name = "producer")
    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    @Column(name = "prod_date")
    public Long getProdDate() {
        return ProdDate;
    }

    public void setProdDate(Long prodDate) {
        ProdDate = prodDate;
    }

    @Column(name = "expiry")
    public int getExpiry() {
        return Expiry;
    }

    public void setExpiry(int expiry) {
        Expiry = expiry;
    }

    @Column(name = "description")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Column(name = "pic_url")
    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    @Column(name = "show_url")
    public String getShowUrl() {
        return ShowUrl;
    }

    public void setShowUrl(String showUrl) {
        ShowUrl = showUrl;
    }

    @Column(name = "created_on")
    public Long getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Long createdOn) {
        CreatedOn = createdOn;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    private String GoodsId;
//    private Long GoodId;
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
    private Long CreatedOn;
    private String GoodsName;
    private String BarCode;
    private String BarCodeType;
    private int CategoryId;
    private double Price;
    private String Producer;
    private Long ProdDate;
    private int Expiry;
    private int Quantity;
    private String Description;
    private String PicUrl;
    private String ShowUrl;
}
