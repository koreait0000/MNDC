package com.example.mndc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String tilesTest() {
        return "/";
    }



    @PostMapping("/search")
    public String search(@RequestParam String search) {
        // TODO : 검색 한 결과를 보여줄 페이지
        return "";
    }
}
