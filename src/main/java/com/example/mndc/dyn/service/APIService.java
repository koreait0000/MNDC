package com.example.mndc.dyn.service;

import com.example.mndc.sta.model.dto.APIJobDTO;
import com.example.mndc.sta.model.dto.APISaleDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class APIService {
    @Autowired
    Gson gson;

    public <T> HttpEntity<T> setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<T>(headers);
    }

    public List searchSale(int startIndex, int endIndex) {
        final String MND_URL = "https://openapi.mnd.go.kr";
        final String KEY = "/3938313633333537323131313732313334";
        final String TYPE = "/json";
        final String MND_JOB = "/DS_RCRT_RCRTMT_BLTNBD_MND";
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("%s%s%s%s/%d/%d",MND_URL,KEY,TYPE, MND_JOB, startIndex, endIndex);
        HttpEntity<APISaleDTO> httpEntity = setHeaders();


        ResponseEntity<String> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET,null,String.class);

        String data = responseEntity.getBody();
//        System.out.println(data);

        Gson gson = new Gson();

        APISaleDTO apiSaleDTO = gson.fromJson(data,APISaleDTO.class);

        List<APISaleDTO.DS.Row> list = apiSaleDTO.getDS_RCRT_RCRTMT_BLTNBD_MND().getRow();
        for (APISaleDTO.DS.Row row : list){
            System.out.println(row);
        }

        return list;
    }



    public List searchJob(String page, String location, String category){
        final String SEARCH_JOB = "https://vnet.go.kr/empn/jobsearchxml.do";
        final String PAGE = "page";
        final String LOCATION = "location";
        final String CATEGORY = "category";
        RestTemplate restTemplate = new RestTemplate();


        // String query 날리기

        HttpEntity<APIJobDTO.APIJobArticleDTO> httpEntity = setHeaders();

        String url = SEARCH_JOB;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(SEARCH_JOB)
            .queryParam(PAGE,page);
        if (!location.equals("0")) builder.queryParam(LOCATION,location);
        if (!category.equals("0")) builder.queryParam(CATEGORY,category);

        UriComponents uri = builder.build();


        ResponseEntity<String> responseEntity
            = restTemplate.exchange(uri.toUriString(), HttpMethod.GET,null,String.class);
        String data = responseEntity.getBody();

        APIJobDTO apiJobDTO = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            apiJobDTO = xmlMapper.readValue(data,APIJobDTO.class);
        }catch (Exception e){}

        List<APIJobDTO.APIJobArticleDTO> list = apiJobDTO.getArticles();

//        for (APIJobDTO.APIJobArticleDTO apiJobArticleDTO : list){
//            System.out.println(apiJobArticleDTO);
//        }


        return list;
    }

}