package com.example.mndc.controller;

import com.example.mndc.auth.PrincipalDetails;
import com.example.mndc.model.UserEntity;
import com.example.mndc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String join(@AuthenticationPrincipal PrincipalDetails principalDetails){

        return "join";
    }

    @PostMapping("/join")
    public String join(UserEntity userEntity){
        if(userEntity.getId() != null && userEntity.getPw() != null && userEntity.getName() != null && userEntity.getEmail() != null){
            String hashPw = bCryptPasswordEncoder.encode(userEntity.getPw());
            userEntity.setRole("ROLE_USER");
            userEntity.setNickname(userEntity.getId());
            userEntity.setPw(hashPw);
            userRepository.save(userEntity);
            return "redirect:login";
        }
        return "join";
    }

//    @ResponseBody
//    @GetMapping("/check/sendSMS")
//    public String authSms(String phoneNumber){
//        String rNum = userService.randNum();
//        if(userService.certifiedPhoneNumber(phoneNumber,rNum) > 0){
//            //coolsms의 일일 50회 test를 모두 사용했을때 302코드
//            return "fail";
//        }
//        return rNum;
//    }
//    @PostMapping("/join")
//    public String join(com.example.mndc.model.vo.UserEntity userEntity){
//        if(userEntity.getId() != null && userEntity.getPw() != null && userEntity.getPhoneNum() != null && userEntity.getName() != null &&
//        userEntity.getBirth() != null && userEntity.getEmail() != null){
//            String hashPw = bCryptPasswordEncoder.encode(userEntity.getPw());
//            userEntity.setPw(hashPw);
//            userRepository.save(userEntity);
//            return "redirect:login";
//        }
//        return "join";
//    }
}
