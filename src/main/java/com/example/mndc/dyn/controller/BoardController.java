package com.example.mndc.dyn.controller;


import com.example.mndc.dyn.service.*;
import com.example.mndc.dyn.utils.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController extends Path {

    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @Autowired
    private FavService favService;
    @Autowired
    private APIService apiService;

    @GetMapping("/")
    public String gomain(){
        // todo : type을 enum 또는 interface로 관리하여 값을 넣기
        boardService.getBoardList(1);
        return "/main";
    }

    @GetMapping(BOARD+WRITE)
    public String write(){

        return BOARD+WRITE;
    }

    @GetMapping("/history")
    public String goHistory(){
        return "board/history";
    }

}
