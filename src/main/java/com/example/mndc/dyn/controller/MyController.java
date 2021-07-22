package com.example.mndc.dyn.controller;

import com.example.mndc.dyn.service.BoardService;
import com.example.mndc.dyn.utils.Path;
import com.example.mndc.dyn.utils.PathEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(Path.MY)
public class MyController extends Path{

    @Autowired
    private BoardService boardService;

    //TODO : 로그인 된 정보에 따라 m_pk값 가져오기
    //TODO : 로그인 여부 검사를 통해 접근 제어
    @GetMapping(MYLIST)
    public String viewMyList(Model model){
        int imsi = 0;
        model.addAttribute("list", boardService.getMyBoardsInfo(imsi));

        return MY+MYLIST;
    }

    // 내게 달린 게시물 알람
    @GetMapping(MYCONTENT)
    public String viewMyContent(Model model){
        int imsi = 0;
        model.addAttribute("list",boardService.getMyCmtsInfo(imsi));
        return MY+MYCONTENT;
//        return PathEnum.MYCONTENT.getRedirectUrl(MY, "dd");
    }
}
