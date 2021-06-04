                                                                                                                                    package com.example.mndc.controller;

import com.example.mndc.model.vo.MemberVO;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

                                                                                                                                    @Controller
@RequestMapping("/user/*")
public class MemberController {

    private MemberVO memberVO;
    private String apiResult = null;

    @Autowired
    private void setNaverLoginvo(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    @GetMapping("login")
    public String login(Model model, HttpSession session){
        //naver id로 인증 url을 생성
        String naverAuthUrl = memberVO.getAuthorizationUrl(session);
        System.out.println("naver : " + naverAuthUrl);

        model.addAttribute("url",naverAuthUrl);
        return "index";
    }

    //로그인 성공시 callback호출
    @PostMapping("/http://localhost:8080/user/callback")
    public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
        System.out.println("callback넘어옴");
        OAuth2AccessToken oAuth2AccessToken;
        oAuth2AccessToken = memberVO.getAccessToken(session,code,state);
        //String형식의 json데이터
        apiResult = memberVO.getUserProfile(oAuth2AccessToken);
        /* apiResult json 구조
         {"resultcode":"00",
         "message":"success",
         "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
         */

        Gson gson = new Gson();
        String json = gson.toJson(apiResult);
        System.out.println(json);

        model.addAttribute("result",apiResult);
        return "index";

    }
}
