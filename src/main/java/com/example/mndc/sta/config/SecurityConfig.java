package com.example.mndc.sta.config;

import com.example.mndc.sta.handler.LoginSuccessHandler;
import com.example.mndc.sta.handler.LoginSuccessHandler2;
import com.example.mndc.sta.jwt.jwt.JwtAuthenticationFilter;
import com.example.mndc.sta.jwt.jwt.JwtAuthorizationFilter;
import com.example.mndc.sta.jwt.jwt.JwtProperties;
import com.example.mndc.sta.model.repository.UserRepository;
import com.example.mndc.sta.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(securedEnabled = true) //secured 어노테이션 활성화, preAuthorize 어노테이션 활성화
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    private final UserRepository userRepository;

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .antMatchers("/auth", "/oauth2/**", "/login/**", "/join/**", "/css/**", "/js/**", "/img/**", "/favicon.ico/**","/main/**","/jobSearch/**","/benefitZone/**").permitAll()
            .antMatchers("/user/**","/board/**").authenticated() //인증만 되면 들어갈수 있는 주소
            //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
            //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
            .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
            .anyRequest().permitAll()
            .and()

            .addFilter(corsFilter)
            .addFilter(new JwtAuthenticationFilter(authenticationManager()))
            .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))

            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("mid")
            .passwordParameter("mpw")
            .defaultSuccessUrl("/")
            .and()

            .logout()
            .logoutSuccessUrl("/")
            .deleteCookies(JwtProperties.HEADER_STRING)
            .and()

            .oauth2Login()
            .loginPage("/login")
            .successHandler(new LoginSuccessHandler())
            .userInfoEndpoint()//구글 로그인이 완료된 뒤의 후처리가 필요함. 코드X (액세스 토큰 + 사용자 프로필 정보O)
            .userService(principalOauth2UserService);

        // 1. 코드 받기(인증) 2. 액세스 토큰(권한) 3. 사용자 프로필 정보를 가져오고 4. 그 정보를 토대로 회원가입을 자동으로 진행시키도록.
    }
}