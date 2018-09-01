package com.nousunde.wxma.service;

import com.nousunde.wxma.entity.Book;
import com.nousunde.wxma.entity.Dock;
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
public class DockSvcTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DockSvc dockSvc;
    @Autowired
    private BookSvc bookSvc;

    @Ignore
    @Test
    public void getDockInfoByBookISBN() {
        List<Book> books = bookSvc.getBooks();
        Book book = books.get(0);
        logger.info("Name:{} Barcode:{}", book.getGoodsName(), book.getBarCode());
        List<Dock> dockInfoByBookISBN = null;
        for (Book b :
                books) {
            dockInfoByBookISBN = dockSvc.getDockInfoByBookISBN(b.getBarCode());
            for (Dock d :
                    dockInfoByBookISBN) {
                logger.info("--- {}", d.toString());
            }
        }

    }
    @Ignore
    @Test
    public void addDock() {

    }

    @Test
    public void functionnalTest(){
        List<Dock> dockInfoByBookISBN = null;

        List<String> bookRefLangs = bookSvc.getRefLangs();

        for (String lang :
                bookRefLangs) {
            List<Book> booklist = bookSvc.getBookByLang(lang);
            for (Book b :
                    booklist) {
                dockInfoByBookISBN = dockSvc.getDockInfoByBookISBN(b.getBarCode());
                for (Dock d :
                        dockInfoByBookISBN) {
                    logger.info("--- {} {} {} {}", b.getGoodsName(), d.getOwner(), d.getPC(), d.getDOA());
                }

            }
        }
    }
}