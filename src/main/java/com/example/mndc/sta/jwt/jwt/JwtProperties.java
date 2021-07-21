package com.example.mndc.sta.jwt.jwt;

public interface JwtProperties {
    String SECRET = "mndc"; //우리 서버만 알고 있는 비밀값
    int EXPIRATTION_TIME = 3600000; //(1000 * 60 * 60)1시간
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
