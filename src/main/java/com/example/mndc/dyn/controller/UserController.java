package com.example.mndc.dyn.controller;

import com.example.mndc.dyn.service.UserService;
import com.example.mndc.dyn.utils.Path;
import com.example.mndc.sta.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController extends Path {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String join(UserEntity userEntity){
//        UserEntity loginUser = principalDetails.getUserEntity();

//        else if(loginUser.get() == null){
//            loginUser.setPhoneNum(userEntity.getPhoneNum());
//            userRepository.updatePhoneNum(loginUser.getPhoneNum(), loginUser.getId());
//        }
        if(userService.join(userEntity) == 0){
            return REDIRECT+JOIN+"?error=1";
        };

        return REDIRECT+LOGIN+"?auth=0";
    }

    @GetMapping("/auth")
    public String auth (UserEntity userEntity){
        userService.auth(userEntity);
        return REDIRECT+LOGIN+"?auth=1";
    }
}
