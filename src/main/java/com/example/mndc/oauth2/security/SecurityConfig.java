package com.example.mndc.oauth2.security;

import com.example.oauth2.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static com.example.mndc.oauth2.security.SocialType.*;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests()
                .antMatcher("/","/js/**","/css/**","/img/**","/login/**","/join/**")
    }

    @Override public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/oauth2/**", "/login/**", "/css/**", "/images/**", "/js/**", "/console/**", "/favicon.ico/**")
                .permitAll()
                //permitAll 까지의 antMatchers 설정한 페이지는 인증절차없이 들어갈수있음
                .antMatchers("/kakao")
                .hasAuthority(KAKAO.getRoleType())
                .antMatchers("/naver")
                .hasAuthority(NAVER.getRoleType())
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(new CustomOAuth2UserService()) // 네이버 USER INFO의 응답을 처리하기 위한 설정 .and() .defaultSuccessUrl("/loginSuccess") .failureUrl("/loginFailure") .and() .exceptionHandling() .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")); }
    }

}
