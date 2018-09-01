package com.nousunde.wxma.controller;

import com.nousunde.wxma.controller.cmn.InavBook;
import com.nousunde.wxma.entity.Book;
import com.nousunde.wxma.entity.Dock;
import com.nousunde.wxma.service.BookSvc;
import com.nousunde.wxma.service.DockSvc;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "info")
public class FicialAccessController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookSvc bookSvc;
    @Autowired
    private DockSvc dockSvc;

    @GetMapping(path = "/0A626F6F6B73") // Map ONLY GET Requests
    public @ResponseBody
    Map<String, Object> getbooks(@RequestParam String sessionid) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("getbooks()...");

        List<Book> books = bookSvc.getBooks();
        if (books.isEmpty()) {
            modelMap.put("state", 204);
            modelMap.put("books", "");
            modelMap.put("errmsg", "no books");
        } else {
            List<InavBook> invaList = InavBook.getInavBooks(books);
            logger.info("***get book{} success! \n{}", (invaList.size() > 1 ? "s" : ""), invaList.toArray());
            modelMap.put("state", 0);
            modelMap.put("books", invaList.toArray());

        }
        return modelMap;
    }

    @RequestMapping(value = "/0A646F636B696E666F")
    public @ResponseBody
    Map<String, Object> getBookDockInfo(@RequestParam String sessionid) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("getBookDockInfo()...");

        List<Dock> bookDockInfo = null;
        Map<String, Object> map = null;
        JSONArray array = null;
        JSONObject jsonObject = null;

        List<String> bookRefLangs = bookSvc.getRefLangs();
        JSONArray dockinfo = new JSONArray();
        for (String lang :
                bookRefLangs) {
            List<Book> booklist = bookSvc.getBookByLang(lang);
            for (Book b :
                    booklist) {

                bookDockInfo = dockSvc.getDockInfoByBookISBN(b.getBarCode());
                if (bookDockInfo.isEmpty()) {
                    map = null;
                    array = null;
                    continue;
                }
                array = new JSONArray();
                for (Dock d :
                        bookDockInfo) {
//                    Object objuserId = storedSession.getAttribute("UserId");
//                    if (objuserId != null){
//                        if (d.getOwner().equals(objuserId.toString())){
                    map = new HashMap<>();
                    logger.info("--- {} {} {}", b.getGoodsName(), d.getPC(), d.getDOA());
//                    map.put("bookName", b.getGoodsName());
                    map.put("pc", d.getPC());
                    map.put("doa", d.getDOA());
                    array.add(map);
//                        }
//                    }
                }
                if (array != null) {

                    if (array.size() > 0) {
                        jsonObject = new JSONObject();
                        jsonObject.accumulate("bookName", b.getGoodsName());
                        jsonObject.accumulate("barcode", b.getBarCode());
                        jsonObject.accumulate("dock", array);
                        dockinfo.add(jsonObject);
                        array = null;
                    }
                }
            }
        }
        modelMap.put("state", 0);
        modelMap.put("dockinfo", dockinfo.toArray());
        return modelMap;
    }
}
