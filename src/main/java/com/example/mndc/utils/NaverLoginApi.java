package com.example.mndc.utils;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginApi extends DefaultApi20 {

    protected NaverLoginApi(){}

    private static class InstanceHolder{
        private static final NaverLoginApi INSTANCE = new NaverLoginApi();
    }
    public static NaverLoginApi instance(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        // 인증과정에 대한 구분값으로 발급 갱신 삭제가 있음
        // 갱신 : refresh_token // 발급후 1시간 이내 사용가능 만료되면 갱신토큰으로 재발급
        // 삭제 : delete 이건 로그아웃 할때 쓰나? <-- X 서비스 탈퇴 네이버 연동을 해제하는거임
        return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
    }

    @Override
    protected String getAuthorizationBaseUrl() { //요청 URL
        return "https://nid.naver.com/oauth2.0/authorize";
    }
}