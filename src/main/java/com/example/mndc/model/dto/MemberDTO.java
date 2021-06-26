package com.example.mndc.model.dto;

import com.example.mndc.utils.NaverLoginApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Component
public class MemberDTO {
//    private int m_pk;
//    private String m_id;
//    private String m_pw;
//    private int m_type;
//    private int m_auth;
//    private int mu_pk;
    private final static String CLIENT_ID = "HUlPJQ3woHNacSAPETZg";
    private final static String CLIENT_SECRET="UDPdHO0ViQ";
    //로그인 인증 결과를 받을 콜백주소
    private final static String REDIRECT_URI = "http://localhost:8080/user/callback";
    //애플리케이션이 생성한 상태 토큰??
    private final static String SESSION_STATE = "oauth_state";
    private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

    //네이버 아이디로 인증 URL생성하는 메소드
    public String getAuthorizationUrl(HttpSession session){
        String state = generateRandomString();
        //생성한 난수값을 session에 저장
        setSession(session,state);
        //scribe에서 제공하는 인증 url생성기능을 이용해서 네아로 인증 url을 생성함
        OAuth20Service oAuth20Service = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .state(state)
                .build(NaverLoginApi.instance());
        return oAuth20Service.getAuthorizationUrl();
    }
    //네이버아이디로 콜백 처리 및 액세스토큰 획득하는 메소드
    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {
        String sessionState = getSession(session);
        //콜백으로 전달받은 세션 검증하는거
        if(StringUtils.pathEquals(sessionState, state)){
            OAuth20Service oAuth20Service = new ServiceBuilder()
                    .apiKey(CLIENT_ID)
                    .apiSecret(CLIENT_SECRET)
                    .callback(state)
                    .build(NaverLoginApi.instance());

            OAuth2AccessToken accessToken = oAuth20Service.getAccessToken(code);
            return accessToken;
        }
        return null;
    }

    //세션 유효성 검증을 하기 위한 난수 생성
    private String generateRandomString(){
        return UUID.randomUUID().toString();
    }
    private void setSession(HttpSession session, String state){
        session.setAttribute(SESSION_STATE, state);
    }
    private String getSession(HttpSession session){
        return (String) session.getAttribute(SESSION_STATE);
    }

    public String getUserProfile(OAuth2AccessToken oAuth2AccessToken)throws IOException{
        OAuth20Service oAuth20Service = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI).build(NaverLoginApi.instance());

        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oAuth20Service);
        oAuth20Service.signRequest(oAuth2AccessToken,request);
        Response response = request.send();
        return response.getBody();
    }
}
