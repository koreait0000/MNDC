package com.example.mndc.dyn.controller;

import com.example.mndc.dyn.service.BoardService;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String tilesTest(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//        UserEntity user = principalDetails.getUserEntity();
//        System.out.println(user);
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search,
                         Model model) {
        // TODO : 검색 한 결과를 보여줄 페이지
        // TODO : 게시글 검새
        // TODO : 게시판 검색
        model.addAttribute("boardList",boardService.searchBoard(search));
        model.addAttribute("unitList", boardService.searchMilitaryUnit(search));

        return "";
    }
}