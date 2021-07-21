package com.example.mndc.sta.jwt.jwt;

import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

//스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
// /login으로 요청 username, password 전송하면 (post)
// UsernamePasswordAuthenticationFilter가 동작함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter 로그인 시도중");

        try {
//            BufferedReader br = request.getReader();
//            String input = null;
//            while ((input = br.readLine()) != null){
//                System.out.println(input);
//            }
            ObjectMapper om = new ObjectMapper();
            UserEntity user = om.readValue(request.getInputStream(), UserEntity.class);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getMid(), user.getMpw());
            // principaldetailsservice의 loaduser()메소드 실행
            //authentication에 내 로그인 정보가 담긴다.
            //db에 있는 username과 password가 일치한다.
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            System.out.println(principalDetails.getUserEntity().getMpk());
            //리턴될때 authentication 객체가 session영역에 저장됨 => 로그인이 되었다는 뜻.
            //리턴을 하는 이유는 권한 관리를 security가 대신 해주기 때문에 편하려고 하는거임.
            //굳이 jwt 토큰을 사용하면서 세션을 만들 이유가 없음. 단지 권한 처리때문에 session에 넣어줌
            return authentication;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //attemptauthentication 실행후 인증이 정상적으로 되었으면 seccessful 함수가 실행된다.
    //jwt토큰을 만들어서 req요청한 사용자에게 jwt토큰을 response해주면됨
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successful 함수 실행됨 : 인증 완료되서 ㅇㅇ");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        //rsa방식보단 hmac방식을 많이 이용함
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
        response.addCookie(cookie);

    }
}
