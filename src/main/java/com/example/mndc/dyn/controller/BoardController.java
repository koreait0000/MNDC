package com.example.mndc.dyn.controller;


import com.example.mndc.dyn.service.*;
import com.example.mndc.dyn.utils.APIData;
import com.example.mndc.dyn.utils.Path;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "/index";
    }

    @GetMapping(BOARD+WRITE)
    public String write(){

        return BOARD+WRITE;
    }
    @GetMapping(BOARD+VIEW)
    public String view(){

        return BOARD+VIEW;
    }

    @GetMapping("/history")
    public String goHistory(){
        //
        return "/board/history";
    }

    @GetMapping("jobSearch")
    public String goJobSearch(Model model,
                              @RequestParam(defaultValue = "1") String page,
                              @RequestParam(defaultValue = "0") String location,
                              @RequestParam(defaultValue = "0") String category){

        model.addAttribute("locations", APIData.getJobSearchLocations());
        model.addAttribute("categories",APIData.getJobSearchCategories());
        model.addAttribute("list",apiService.searchJob(page, location, category));
        return "/board/jobSearch";
    }
    @GetMapping("benefitZone")
    public String goBenefitZone(Model model){
        // 페이지 값 어떻게  받아서 어떻게 넘길지!
        model.addAttribute("list",apiService.searchSale(1,10));

        return "/board/benefitZone";
    }

}
