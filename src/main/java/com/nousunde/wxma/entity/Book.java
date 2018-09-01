package com.nousunde.wxma.entity;

import net.sf.json.JSONObject;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_book")
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Book extends Goods {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    private String Authors;
    private String Publisher;
    private Long PubDate;

    private String Foreword;
    private String Verbose;
    private String ChapterList;
    private String Lang;

    private String Translator;


    @Column(name = "authors")
    public String getAuthors() {
        return Authors;
    }

    public void setAuthors(String authors) {
        Authors = authors;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    @Column(name = "pub_date")
    public Long getPubDate() {
        return PubDate;
    }

    public void setPubDate(Long pubDate) {
        PubDate = pubDate;
    }

    @Column(name = "lang")
    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    @Column(name = "foreword")
    public String getForeword() {
        return Foreword;
    }

    public void setForeword(String foreword) {
        Foreword = foreword;
    }

    @Column(name = "verbose")
    public String getVerbose() {
        return Verbose;
    }

    public void setVerbose(String verbose) {
        Verbose = verbose;
    }

    @Column(name = "chapter_list")
    public String getChapterList() {
        return ChapterList;
    }

    public void setChapterList(String chapterList) {
        ChapterList = chapterList;
    }

    public String getTranslator() {
        return Translator;
    }

    public void setTranslator(String translator) {
        Translator = translator;
    }


}
