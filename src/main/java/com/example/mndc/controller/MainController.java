package com.example.mndc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String tilesTest() {
        // TODO : MainController 주소 "/"로 추후 변경 바랍니다.
        return "user/content";
    }

    @GetMapping("/home2")
    public String tilesTest2() {

        return "user/content2";
    }


    @PostMapping("/search")
    public String search() {
        // TODO : 검색 한 결과를 보여줄 페이지
        return "";
    }
}
