package com.nousunde.wxma.service;

import com.nousunde.wxma.dao.ChapterDAO;
import com.nousunde.wxma.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterSvc {
    @Autowired
    private ChapterDAO chapterDAO;

    public List<Chapter> getChapterByBookId(String bookId){
       return chapterDAO.getChapterByBookId(bookId);
    }

    public void addChapter(Chapter chapter){
        this.chapterDAO.addChapter(chapter);
    }

    public void updateChapter(Chapter chapter){
        this.chapterDAO.updateChapter(chapter);
    }

    public void deleteChapter(String chapterId){
        this.chapterDAO.deleteChaterById(chapterId);
    }
}
