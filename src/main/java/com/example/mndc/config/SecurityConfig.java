package com.example.mndc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(securedEnabled = true) //secured 어노테이션 활성화, preAuthorize 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() //인증만 되면 들어갈수 있는 주소
                //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("login")
                .usernameParameter("id")
                .passwordParameter("pw")
                .loginProcessingUrl("login")
                .defaultSuccessUrl("/");
//                .and()
//                .oauth2Login()
//                .loginPage("/loginForm") //구글 로그인이 완료된 뒤의 후처리가 필요함. 코드X (액세스 토큰 + 사용자 프로필 정보O)
//                .userInfoEndpoint()
//                .userService(principalOauth2UserService);
        // 1. 코드 받기(인증) 2. 액세스 토큰(권한) 3. 사용자 프로필 정보를 가져오고 4. 그 정보를 토대로 회원가입을 자동으로 진행시키도록.
    }
}