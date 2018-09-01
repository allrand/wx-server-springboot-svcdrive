package com.nousunde.wxma.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.nousunde.wxma.controller.cmn.InavBook;
import com.nousunde.wxma.controller.cmn.InavChapter;
import com.nousunde.wxma.entity.*;
import com.nousunde.wxma.repository.GoodsRepository;
import com.nousunde.wxma.repository.SessionRepository;
import com.nousunde.wxma.service.*;
import com.nousunde.wxma.utils.FormatStr;
import me.chanjar.weixin.common.session.WxSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(path = "/inav")
public class InavInfoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookSvc bookSvc;
    @Autowired
    private ChapterSvc chapterSvc;
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private DockSvc dockSvc;

    private final SessionRepository sessionRepository;
    @Autowired
    public InavInfoController(SessionRepository springSessionRepository) {
        sessionRepository = springSessionRepository;
    }

    /**
     * Get chapters info for book
     * @param sessionid
     * @param bookisbn
     * @return
     */
    @RequestMapping(value = "/0A6368617074657273")
    public @ResponseBody Map<String, Object> getchapters(@RequestParam String sessionid, @RequestParam String bookisbn) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("getcontents({})...", sessionid);

        Book book = bookSvc.getBookByBarcode(bookisbn);
        List<Chapter> chapters = chapterSvc.getChapterByBookId(book.getGoodsId());

        if (chapters.isEmpty()) {
            modelMap.put("state", 204);
            modelMap.put("chapters", "");
            modelMap.put("errmsg", "no chapters");
        } else {
            List<InavChapter> invaList = InavChapter.getInavList(chapters);
            logger.info("***get chapter{} success! \n{}", (invaList.size() > 1 ? "s" : ""), invaList.toArray());
            modelMap.put("state", 0);
            modelMap.put("chapters", invaList.toArray());
        }

        return modelMap;
    }

    /**
     * Get the books ref lang
     * @param sessionId
     * @return
     */
    @RequestMapping(value = "/0A5265664C616E6773")
    public @ResponseBody
    Map<String, Object> getRefLangs(@RequestParam String sessionId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("getRefLangs({})...", sessionId);

        List<String> list = bookSvc.getRefLangs();
        modelMap.put("state", 0);
        modelMap.put("reflangs", list.toArray());
        return modelMap;
    }


    @RequestMapping(value = "/0A526566426F6F6B73")
    public @ResponseBody
    Map<String, Object> getRefBooksByLang(@RequestParam String sessionId, @RequestParam String lang) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("getRefBooksByLangs({})...", sessionId);

        List<Book> booklist = bookSvc.getBookByLang(lang);
        modelMap.put("state", 0);
        modelMap.put("refbooks", booklist.toArray());
        return modelMap;
    }


    @RequestMapping(value = "/0A757064617465446F63")
    public @ResponseBody
    Map<String, Object> updateDockInfo(@RequestParam String sessionid, @RequestParam String bookisbn, @RequestParam String latestdoa) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        logger.info("updateDockInfo({})...", sessionid);
        Dock dock = null;
        String userId = null;
        WxSession storedSession = sessionRepository.getWxSessionResult(sessionid);
        userId = storedSession.getAttribute("UserId").toString();
        if (userId.isEmpty() || userId == "") {
            modelMap.put("state", 401);
            modelMap.put("errmsg", "Unauthorized error, invalid user");
            return modelMap;
        }
        List<Dock> docks = dockSvc.getDockInfoByBookISBN(bookisbn);
        for (Dock d :
                docks) {
            if (d.getOwner().equals(userId) && d.getBarcode().equals(bookisbn) && d.getDOA().contains(FormatStr.getThisWeek())) {
                dock = d;
                break;
            }
        }
        if (dock == null){
            dock = new Dock();
            dock.setDOA(FormatStr.getThisWeek() + "=" + latestdoa);
            dock.setBarcode(bookisbn);
            dock.setPC(0.00);
            dock.setOwner(userId);
            dockSvc.addDock(dock);
        }else {
            dock.setDOA(FormatStr.getThisWeek() + "=" + latestdoa);
            dockSvc.updateDock(dock);
        }

        modelMap.put("state", 0);
        modelMap.put("dockinfo", dock.toString());
        return modelMap;
    }
}
