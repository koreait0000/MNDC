package com.example.mndc.dyn.service.api;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class APIService {
    @Autowired
    Gson gson;

    protected <T> HttpEntity<T> setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<T>(headers);
    }

    protected String requestData(URI url, HttpEntity headers){
        System.out.println(url.toString());
        return new RestTemplate().exchange(url, HttpMethod.GET,headers,String.class).getBody();

    }

//    public List searchSale(){
//        final String URL = "https://infuser.odcloud.kr/oas/docs?namespace=15083053/v1";
//    }

    public <T> void testPrint(List<T> list){
        for (T t : list){
            System.out.println(t);
        }
    }
}