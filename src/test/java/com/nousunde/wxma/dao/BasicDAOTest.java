package com.nousunde.wxma.dao;

import com.nousunde.wxma.entity.*;
import com.nousunde.wxma.service.DockSvc;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicDAOTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserDAO userDAO;
    @Autowired
    AcsDAO acsDAO;
    @Autowired
    GoodsDAO goodsDAO;
    @Autowired
    BookDAO bookDAO;
    @Autowired
    ChapterDAO chapterDAO;

    @Autowired
    DockSvc dockSvc;

    @Ignore
    @Test
    public void getBasicData(){
        List<User> list = userDAO.getUsers();
        User user = list.get(0);
        logger.info("user:{}", user.toString());

        Acs acs = acsDAO.getAcsByUserId(user.getUserId());
        logger.info("acs :{}", acs);

        List<Book> books = bookDAO.getBooks();
        logger.info("book:{}", books.get(0));

        List<Goods> goodsList = goodsDAO.getGoods();
        logger.info("goods:{}", goodsList.get(0));

    }

    @Ignore
    @Test
    public void fillBasicData() {
        User user = new User();
        user.setUserName("a10");
        user.setCreateTime(new Date().getTime());
        user.setDisplayName("快樂使者");
        user.setSignature("I want to be happy forever!");
        user.setDisplayName("業務員1");
        userDAO.addUser(user);
        User user1 = new User();
        user1.setUserName("sdriver");
        user1.setSignature("I want to keep happy forever!");
        user1.setDisplayName("管理員1");
        userDAO.addUser(user1);

        User user12 = new User();
        user12.setUserName("sdx");
        user12.setSignature("I want to keep happy forever!");
        user12.setDisplayName("超級管理員");
        user12.setCreateTime(new Date().getTime());
        userDAO.addUser(user12);

        User u = userDAO.getUserByAccount("a10");
        Acs acs = new Acs();
        acs.setUserId(u.getUserId());
        acs.setKeytab("123123");
        acs.setUserMod((short) 4430);
        acsDAO.addAcs(acs);

        acs = new Acs();
        u = userDAO.getUserByAccount("sdriver");
        acs.setUserId(u.getUserId());
        acs.setKeytab("123123");
        acs.setUserMod((short) 4130);
        acsDAO.addAcs(acs);

        acs = new Acs();
        u = userDAO.getUserByAccount("sdx");
        acs.setUserId(u.getUserId());
        acs.setKeytab("123123");
        acs.setUserMod((short) 3030);
        acsDAO.addAcs(acs);


        Goods goods = new Goods();
        goods.setGoodsName("Textsurfer red");
        goods.setBarCode("4007817304440");
        goods.setBarCodeType("EAN_13");
        goods.setCategoryId(574710238);//stationery
        goodsDAO.addGoods(goods);
        Goods goods1 = new Goods();
        goods1.setGoodsName("Textsurfer yellow");
        goods1.setBarCode("4007817304679");
        goods1.setBarCodeType("EAN_13");
        goods1.setCategoryId(574710238);
        goodsDAO.addGoods(goods1);

        Book book = new Book();
        book.setGoodsName("菩提道次第廣論");
        book.setAuthors("宗喀巴大師");
        book.setLang("漢語");
        book.setPublisher("莆田廣化寺");
        book.setBarCode("6950674001542");
        book.setPubDate(new Date().getTime());
        book.setCategoryId(60013);
        book.setDescription("殊勝至極啊");
        book.setShowUrl("");
        book.setPicUrl("");
        book.setQuantity(3);
        Book book2 = new Book();
        book2.setGoodsName("感悟人生");
        book2.setAuthors("學誠");
        book2.setLang("漢語");
        book2.setPublisher("中国物资出版社");
        book2.setBarCode("9787504737045");
        book2.setPubDate(new Date().getTime());//2011-02-01
        book2.setCategoryId(60013);
        book2.setDescription("心灵的教育。。。");
        book2.setChapterList("[[1,[2,3,4,5,6]],[7,[8,9,10]],[11,[12,13,14,15,16,17]]]");
        book2.setShowUrl("");
        book2.setPicUrl("https://img3.doubanio.com/view/subject/l/public/s6287441.jpg");
        book2.setQuantity(7);
        bookDAO.addBook(book);
        bookDAO.addBook(book2);
        Book b = new Book();
        b.setGoodsName("信仰與對話");
        b.setLang("越南语");
        b.setAuthors("學誠");
        b.setPublisher("宗教文化出版社");
        b.setBarCode("1234567890000");
        b.setBarCodeType("EAN_13");
        bookDAO.addBook(b);
        b = new Book();
        b.setGoodsName("皈依之路");
        b.setLang("越南语");
        b.setAuthors("學誠");
        b.setPublisher("宗教文化出版社");
        b.setBarCode("1234567890123");
        b.setBarCodeType("EAN_13");
        bookDAO.addBook(b);

        Chapter c1 = new Chapter();
        Book book1 = bookDAO.getBookByBarCode("9787504737045");
        c1.setChapterName("第一章 对皈依心中信众对教育");
        c1.setChapter("皈依三宝，目的要非常明确，为了要究竟成佛。皈依才是开始的第一步。怎么修行，怎么成佛，这个过程是很长的。 佛不是要解决我们眼前的一些小事情，他要解决我们生命的大事——生死大事。学佛法要把握住宗旨，牢记宗旨，我们才不会迷惑，才能够学到佛法。 学佛法，为了得到觉悟，觉悟人间的一切，觉悟之后自然就能超越外在种种对我们的障碍，觉悟之后就能解决内在的烦恼。所以佛法就像雨露，就像阳光，就像空气，我们一刻也离不开。 ");
        c1.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c1);
        Chapter c2 = new Chapter();
        c2.setChapterName("  皈依——次第学修的开始");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);
        c2 = new Chapter();
        c2.setChapterName("  皈依的意义是要让生命觉悟起来");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);
        c2 = new Chapter();
        c2.setChapterName("  皈依之后要认认真真地去实践");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);
        c2 = new Chapter();
        c2.setChapterName("  皈依学法的意义和目的");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);
        c2 = new Chapter();
        c2.setChapterName("  皈依佛法僧 开发戒定慧");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);
        c2 = new Chapter();
        c2.setChapterName("第二章 对学佛小组学员对教育");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);
        c2 = new Chapter();
        c2.setChapterName("  树立正确的人生目标");
        c2.setGoodsId(book1.getGoodsId());
        chapterDAO.addChapter(c2);

        Dock dock = new Dock();
        dock.setBarcode("9787504737045");
        dock.setOwner("季瑞");
        dock.setPC(0.56);
        dock.setDOA("180722-180729=暂无进展");
        dockSvc.addDock(dock);

        dock = new Dock();
        dock.setBarcode("9787504737045");
        dock.setOwner("季瑞");
        dock.setPC(0.56);
        dock.setDOA("180730-180805=暂无进展");
        dockSvc.addDock(dock);
    }


}
