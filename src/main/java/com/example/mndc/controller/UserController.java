package com.example.mndc.controller;

import com.example.mndc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"","/"})
    public String getAuthorizationMessage(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

    @ResponseBody
    @GetMapping("/check/sendSMS")
    public String authSms(String phoneNumber){
        String rNum = userService.randNum();
        if(userService.certifiedPhoneNumber(phoneNumber,rNum) > 0){
            //coolsms의 일일 50회 test를 모두 사용했을때 302코드
            return "fail";
        }
        return rNum;
    }

    @GetMapping({"/loginSuccess", "/hello"})
    public String loginSuccess()
    {
        return "hello";
    }

    @GetMapping("/loginFailure")
    public String loginFailure()
    {
        return "loginFailure";
    }
}
