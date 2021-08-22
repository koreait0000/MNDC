package com.example.mndc.dyn.controller;

import com.example.mndc.dyn.service.UserService;
import com.example.mndc.dyn.utils.Path;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.UserEntity;
import com.example.mndc.sta.recaptcha.VerifyRecaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController extends Path {

    @Autowired
    private UserService userService;

    @GetMapping(LOGIN)
    public String login(){
        return USER+LOGIN;
    }

    @ResponseBody
    @PostMapping("/valid-recaptcha")
    public int VerifyRecaptcha(HttpServletRequest request) {
        VerifyRecaptcha.setSecretKey("6Lf-IYQbAAAAADJZj_62RLCH0DULZ3hl3NV9f_EH");
        String gRecaptchaResponse = request.getParameter("recaptcha");
        try {
            if(VerifyRecaptcha.verify(gRecaptchaResponse))
                return 0; // 성공
            else return 1; // 실패
        } catch (Exception e) {
            e.printStackTrace();
            return -1; //에러
        }
    }

    @GetMapping(MYPAGE)
    public String mypage(){
        return USER+MYPAGE;
    }

    @GetMapping(USER)
    @ResponseBody
    public String user(){
        return USER;
    }

    @GetMapping(JOIN)
    public String join(){
        return USER+JOIN;
    }

    @PostMapping(JOIN)
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
