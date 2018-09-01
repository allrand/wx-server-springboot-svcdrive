package com.nousunde.wxma.controller.cmn;

import net.sf.json.JSONObject;
import com.nousunde.wxma.entity.Chapter;

import java.util.ArrayList;
import java.util.List;

public class InavChapter {
    @Override
    public String toString() {
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    public static List<InavChapter> getInavList(List<Chapter> chapters){
        if (chapters.isEmpty())
            return null;
        else {
            List<InavChapter> newList = new ArrayList<>();
            int i = 0;
            for (Chapter c :
                    chapters) {
                InavChapter ic = new InavChapter();
                ic.setChapter(c.getChapter());
                ic.setChapterName(c.getChapterName());
                ic.setChapterId(c.getChapterId());
                newList.add(i++, ic);
            }
            return newList;
        }
    }
    private Long ChapterId;
    private String ChapterName;
    private String Chapter;

    public Long getChapterId() {
        return ChapterId;
    }

    public void setChapterId(Long chapterId) {
        ChapterId = chapterId;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public String getChapter() {
        return Chapter;
    }

    public void setChapter(String chapter) {
        Chapter = chapter;
    }
}
