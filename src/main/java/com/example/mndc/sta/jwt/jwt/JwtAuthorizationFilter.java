package com.example.mndc.sta.jwt.jwt;

import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.UserEntity;
import com.example.mndc.sta.model.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

// basicAuthentication filter : 권한이나 인증이 필요한 특정 주소를 요청했을때 이 필터를 타게됨
// 권한이나 인증이 필요한 주소가 아니라면 이 필터를 안탄다
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    //jwt토큰을 받고 내어보내는 endpoint?  인증
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("인증이나 권한이 필요한 주소 basicAuthenticationFitler");
        String reqToken = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals(JwtProperties.HEADER_STRING))
                .findFirst() .map(Cookie::getValue)
                .orElse(null);

        if(reqToken == null){
            chain.doFilter(request,response);
            return;
        }
        String id = Jwts.parser().setSigningKey(JwtProperties.SECRET).parseClaimsJws(reqToken).getBody()
                .get("id").toString();
//        if(header ==null || !header.startsWith(JwtProperties.TOKEN_PREFIX)){
//            chain.doFilter(request,response);
//            return;
//        }
        //jwt 토큰을 검증해서 정상적인 사용자인지 확인
//        String token = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX,"");
//        String username =
//                JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token).getClaim("username").asString();
//        Claims claims=
//                Jwts.parser()
//                .setSigningKey(JwtProperties.SECRET)
//                .parseClaimsJws(token).getBody();
//        String username = (String) claims.get("username");
//        //서명이 정상적으로 됨
        System.out.println("=====================");
        System.out.println(id);
        if(id !=null){
            UserEntity user = userRepository.findByMid(id);

            PrincipalDetails principalDetails = new PrincipalDetails(user);
            //authentication 객체를 강제로 만듬 정상적인 이용자이기때문에 상관이없음
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

            //강제로 시큐리티세션에 접근하여 authentication객체를 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);

            chain.doFilter(request,response);
        }
    }
}
