package com.example.mndc.dyn.controller;

import com.example.mndc.sta.model.UserEntity;
import com.example.mndc.sta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }
    @PostMapping("/join")
    public String join(UserEntity userEntity){
        if(userEntity.getId() != null && userEntity.getPw() != null && userEntity.getPhoneNum() != null && userEntity.getName() != null &&
        userEntity.getBirth() != null && userEntity.getEmail() != null){
            String hashPw = bCryptPasswordEncoder.encode(userEntity.getPw());
            userEntity.setPw(hashPw);
            userRepository.save(userEntity);
            return "redirect:login";
        }
        return "join";
    }
}
