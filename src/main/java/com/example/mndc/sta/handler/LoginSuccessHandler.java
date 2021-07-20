package com.example.mndc.sta.handler;

import com.example.mndc.sta.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("핸들러 실행됨");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        if(principalDetails.getUserEntity().getM_id() == null){
            httpServletResponse.sendRedirect("/join");
        }else{
            httpServletResponse.sendRedirect("/");
        }
    }
}
