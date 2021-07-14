package com.example.mndc.sta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); //서버에서 응답할때 json을 자바스크립트에서 처리할 수 있게 설정, ajax같은거 사용가능
        config.addAllowedOrigin("*"); //모든 ip에 응답을 허용함
        config.addAllowedHeader("*");
        config.addAllowedMethod("*"); //post,get,put,delete,patch 요청 허용
        source.registerCorsConfiguration("*", config);
        return new CorsFilter(source);
    }
}
