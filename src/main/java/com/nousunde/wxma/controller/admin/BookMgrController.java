package com.nousunde.wxma.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/admin")
public class BookMgrController {

    @GetMapping("/booklist")
    public String bookList(@RequestParam String sessionid, Model model){
//        model.addAttribute("", "");
        return "booklist";
    }

    @GetMapping("/addbook")
    public String addBook(@RequestParam String sessionid, Model model){
//        model.addAttribute("", "");
        return "addbook";
    }
}
