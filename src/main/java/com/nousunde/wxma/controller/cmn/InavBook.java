package com.nousunde.wxma.controller.cmn;

import com.nousunde.wxma.entity.Book;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InavBook {
    private String isbn;
    private String name;
    private String description;
    private String showUrl;
    private String picUrl;
    private String lang;
    private int cnt;
    private String foreword;
    private String authors;
    private String publisher;
    private String chapterList;
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    public static List<InavBook> getInavBooks(List<Book> bookList) {
        if (bookList.isEmpty())
            return null;
        else {
            List<InavBook> newList = new ArrayList<>(bookList.size());
            int i = 0;
            for (Book b: bookList) {
                InavBook ib = new InavBook();
                ib.setIsbn(b.getBarCode());
                ib.name = b.getGoodsName();
                ib.description = b.getDescription();
                ib.showUrl = b.getShowUrl();
                ib.picUrl = b.getPicUrl();
                ib.lang = b.getLang();
                ib.cnt = b.getQuantity();
                ib.setForeword(b.getForeword());
                ib.setAuthors(b.getAuthors());
                ib.setPublisher(b.getPublisher());
                ib.setChapterList(b.getChapterList());
                newList.add(i++, ib);
            }
            return newList;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getForeword() {
        return foreword;
    }

    public void setForeword(String foreword) {
        this.foreword = foreword;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getChapterList() {
        return chapterList;
    }

    public void setChapterList(String chapterList) {
        this.chapterList = chapterList;
    }
}
