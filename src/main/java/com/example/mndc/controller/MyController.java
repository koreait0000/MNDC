package com.example.mndc.controller;

import com.example.mndc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/my")
public class MyController {

    @Autowired
    BoardService boardService;

    @GetMapping("/mylist")
    public String viewMyList(Model model){
        int imsi = 0;
        model.addAttribute("list", boardService.getMyBoardsInfo(imsi));

        return "/my/mylist";
    }

    // 내게 달린 게시물 알람
    @GetMapping("/mycontent")
    public String viewMyContent(Model model){
        int imsi = 0;
        model.addAttribute("list",boardService.getMyCmtsInfo(imsi));
        return "/my/mycontent";
    }
}
