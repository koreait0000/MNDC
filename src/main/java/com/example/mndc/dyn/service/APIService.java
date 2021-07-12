package com.example.mndc.dyn.service;

import com.example.mndc.sta.model.dto.JobDTO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {
    private static final String MND_URL = "https://openapi.mnd.go.kr";

    // API URL 적기
    // 이거는 고정
    private static final String KEY = "/3938313633333537323131313732313334";
    private static final String TYPE = "/json";
    // 해당 SERVICE들
    //
    private static final String MND_JOB = "DS_RCRT_RCRTMT_BLTNBD_MND";

    private static Integer startIndex;
    private static Integer endIndex;


    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    Gson gson;

    public static <T> HttpEntity<T> setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<T>(headers);
    }

    public JobDTO getSummonerInfo(String id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        String url = String.format("%s%s%s%s/%d/%d",MND_URL,KEY,TYPE, MND_JOB,startIndex,endIndex);
        HttpEntity<JobDTO> httpEntity = setHeaders();


        ResponseEntity<String> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET,null,String.class);

        String data = responseEntity.getBody();
        JobDTO jobDTO = null;

        jobDTO = gson.fromJson(data,JobDTO.class);


        return jobDTO;
    }



}