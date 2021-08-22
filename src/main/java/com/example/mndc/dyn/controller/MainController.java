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

    @GetMapping("/about/privacy")
    public void privacy(){
    }
    @GetMapping("/about/policy")
    public void policy(){
    }
}