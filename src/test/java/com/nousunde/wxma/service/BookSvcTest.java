package com.nousunde.wxma.service;

import com.nousunde.wxma.entity.Book;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookSvcTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BookSvc bookSvc;
    @Ignore
    @Test
    public void getBookLags() {
        List<String> list = bookSvc.getRefLangs();
        logger.info("{}", list.toString());
    }
    @Ignore
    @Test
    public void getBookByLang() {
    }
    @Ignore
    @Test
    public void getBookById() {
    }
    @Ignore
    @Test
    public void getBookByBarcode() {
    }
    @Ignore
    @Test
    public void addBook() {
        Book b = new Book();
        b.setGoodsName("信仰與對話");
        b.setLang("越南语");
        b.setAuthors("學誠");
        b.setPublisher("宗教文化出版社");
        b.setBarCode("1234567890000");
        b.setBarCodeType("EAN_13");
        bookSvc.addBook(b);
    }
    @Ignore
    @Test
    public void updateBook() {
        Book b;
        b = bookSvc.getBookById("ff808081652427f701652428054e0000");
        b.setBarCode("1234567890123");
        b.setBarCodeType("EAN_13");
        bookSvc.updateBook(b);
    }
    @Ignore
    @Test
    public void deleteBook() {
    }
}