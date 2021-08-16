package com.example.mndc.sta.handler;

import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.jwt.jwt.JwtProperties;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("핸들러 실행됨");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        String jwtToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("fresh") // (2)
                .setIssuedAt(new Date()) // (3)
                .setExpiration(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATTION_TIME))
                .claim("iuser", principalDetails.getUserEntity().getMpk())
                .claim("id", principalDetails.getUserEntity().getMid())
                .claim("nickname", principalDetails.getUserEntity().getMnm())
                .claim("role", principalDetails.getUserEntity().getMrole())
                .signWith(SignatureAlgorithm.HS512, JwtProperties.SECRET)
                .compact();

        Cookie cookie = new Cookie(JwtProperties.HEADER_STRING, jwtToken);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(3600); //60*60
        httpServletResponse.addCookie(cookie);
        httpServletResponse.sendRedirect("/");
    }
}
