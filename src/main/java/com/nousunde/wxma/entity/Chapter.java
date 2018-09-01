package com.nousunde.wxma.entity;

import net.sf.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "tb_chapter")
public class Chapter {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    @Id
    @GeneratedValue
    @Column(name = "chapter_id")
    public Long getChapterId() {
        return ChapterId;
    }

    public void setChapterId(Long chapterId) {
        ChapterId = chapterId;
    }
    @Column(name = "goods_id")
    public String getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(String goodsId) {
        GoodsId = goodsId;
    }
    @Column(name = "chapter_name")
    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }
    @Column(name = "chapter")
    public String getChapter() {
        return Chapter;
    }

    public void setChapter(String chapter) {
        Chapter = chapter;
    }

    private Long ChapterId;
    private String GoodsId;
    private String ChapterName;
    private String Chapter;
}
