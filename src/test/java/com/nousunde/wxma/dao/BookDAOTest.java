package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.Book;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDAOTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookDAO bookDAO;

    @Ignore
    @Test
    public void getBooks() {
        List<Book> books = bookDAO.getBooks();
        logger.info("{}", books.toString());
        assertEquals(2, books.size());
    }
    @Ignore
    @Test
    public void getBookById() {
        Book book = bookDAO.getBookById("ff808081651773a801651773b77a0001");
        logger.info("{}", book.toString());
    }

    @Ignore
    @Test
    public void addBook() {
        Book book = new Book();
        book.setGoodsName("菩提道次第廣論");
        book.setAuthors("宗喀巴大師");
        book.setLang("漢語");
        book.setPublisher("莆田廣化寺");
        book.setBarCode("6950674001542");
        book.setPubDate(new Date().getTime());
        book.setCategoryId(60013);
        Book book2 = new Book();
        book2.setGoodsName("感悟人生");
        book2.setAuthors("學誠");
        book2.setLang("漢語");
        book2.setPublisher("華文出版社");
        book2.setBarCode("1051530239691");
        book2.setPubDate(new Date().getTime());
        book2.setCategoryId(60013);
        bookDAO.addBook(book);
        bookDAO.addBook(book2);
    }

    @Test
    @Ignore
    public void updateBook() {
    }

    @Test
    @Ignore
    public void deleteBookById() {
    }
}