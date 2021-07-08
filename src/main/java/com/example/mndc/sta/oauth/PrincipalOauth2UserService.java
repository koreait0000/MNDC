package com.example.mndc.sta.oauth;

import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.UserEntity;
import com.example.mndc.sta.provider.FacebookUserInfo;
import com.example.mndc.sta.provider.GoogleUserInfo;
import com.example.mndc.sta.provider.NaverUserInfo;
import com.example.mndc.sta.provider.Oauth2UserInfo;
import com.example.mndc.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("loadUser 실행됨" );
        System.out.println("getClientRegistration : " + userRequest.getClientRegistration()); //registrationId로 어떤 oauth로 로그인했는지 확인가능
        System.out.println("액세스 토큰: "+userRequest.getAccessToken().getTokenValue());
        OAuth2User oauth2User = super.loadUser(userRequest);
        //구글 로그인버튼 클릭 -> 구글로그인창 -> 로그인 완료 -> code를 리턴(oauth-client라이브러리) -> access token 요청
        // userrequest 정보 -> loaduser함수 호출 -> 구글로 부터 회원프로필 받아줌
        System.out.println("getAttribute: " + oauth2User.getAttributes());

        Oauth2UserInfo oauth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            oauth2UserInfo = new GoogleUserInfo(oauth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            oauth2UserInfo = new FacebookUserInfo(oauth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            oauth2UserInfo = new NaverUserInfo((Map<String, Object>) oauth2User.getAttributes().get("response"));
        }else{
            System.out.println("XXXX");
        }

        String provider = oauth2UserInfo.getProvider(); // google
        String providerId = oauth2UserInfo.getProviderId();
        String username = provider+"_"+providerId;
        String role = "ROLE_USER";
        String name = oauth2UserInfo.getName();
        String pw = bCryptPasswordEncoder.encode("password");
        String email = oauth2UserInfo.getEmail();

        UserEntity userEntity = userRepository.findById(email);
        if(userEntity == null) {
            userEntity = userEntity.builder()
                    .id(email)
                    .pw(pw)
                    .email(email)
                    .name(name)
                    .nickname(name)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }
        //회원가입을 강제로 진행시킬것
        return new PrincipalDetails(userEntity,oauth2User.getAttributes());
    }
}
