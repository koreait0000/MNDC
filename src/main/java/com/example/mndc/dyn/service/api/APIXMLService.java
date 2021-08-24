package com.example.mndc.dyn.service.api;

import com.example.mndc.sta.model.dto.api.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class APIXMLService extends APIService{
    private final String KEY = "K%2FhDtuwgRPJ287yiPCY4lRN9nbdVwy6%2FqDM9BFW%2FImn7TpcqXMI%2BS4%2F6%2F5GuRyoMudE5SnR6a4xpj62S2OnIjw%3D%3D";

    public List searchMonthlyFestival(String smonth, String emonth){
        final String TK_MONTHLY_FESTIVAL = "http://data.gb.go.kr/opendata/service/rest/monthlyFestival/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_MONTHLY_FESTIVAL)
                .queryParam("serviceKey",KEY);
        if (!smonth.equals("0")) builder.queryParam("smonth",smonth);
        if (!emonth.equals("0")) builder.queryParam("emonth",emonth);

        String data = requestTKData(builder.build().toUriString());

        APITKMonthlyFestival apitkMonthlyFestival = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apitkMonthlyFestival = xmlMapper.readValue(data, APITKMonthlyFestival.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apitkMonthlyFestival.getBody().getItems();
    }

    public List searchTourism(){
        final String TK_TOURISM = "http://data.gb.go.kr/opendata/service/rest/touristComplex/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_TOURISM)
                .queryParam("serviceKey",KEY);

        String data = requestTKData(builder.build().toUriString());

        APITKRecriation apitkRecriation = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apitkRecriation = xmlMapper.readValue(data, APITKRecriation.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apitkRecriation.getBody().getItems();
    }

    public List searchRecreation(){
        final String TK_RECREATION = "http://data.gb.go.kr/opendata/service/rest/recreationFacilities/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_RECREATION)
                .queryParam("serviceKey",KEY);

        String data = requestTKData(builder.build().toUriString());

        APITKRecriation apitkRecriation = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apitkRecriation = xmlMapper.readValue(data, APITKRecriation.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apitkRecriation.getBody().getItems();
    }
    public List<APITKEventDTO.Body.Item> searchTKEvent(String sigunNo){
        final String TK_EVENT = "http://data.gb.go.kr/opendata/service/rest/standardEventInformation/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_EVENT)
                .queryParam("serviceKey",KEY);
        if (!sigunNo.equals("0")) builder.queryParam("sigunNo",sigunNo);

        String data = requestTKData(builder.build().toUriString());

        APITKEventDTO apitkEvent = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apitkEvent = xmlMapper.readValue(data, APITKEventDTO.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apitkEvent.getBody().getItems();
    }

    public List<APITKFestival.Body.Item> searchTKFestival(){
        final String TK_Festival = "http://data.gb.go.kr/opendata/service/rest/standardFestival/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_Festival)
                .queryParam("serviceKey",KEY);

        String data = requestTKData(builder.build().toUriString());

        APITKFestival apiTkFestival = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apiTkFestival = xmlMapper.readValue(data, APITKFestival.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apiTkFestival.getBody().getItems();
    }

    public List<APITKHGyeonghuFoodDTO.Body.Item> searchTKGyeonjuFood(){
        final String TK_GYEONGJU_FOOD = "http://data.gb.go.kr/opendata/service/rest/gyeongjuFood/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_GYEONGJU_FOOD)
                .queryParam("serviceKey",KEY);

        String data = requestTKData(builder.build().toUriString());

        APITKHGyeonghuFoodDTO apitkhGyeonghuFoodDTO = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apitkhGyeonghuFoodDTO = xmlMapper.readValue(data, APITKHGyeonghuFoodDTO.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return apitkhGyeonghuFoodDTO.getBody().getItems();
    }

    public List<APITKCinemaDTO.Body.Item> searchTKCinema(String b_year, String b_month, String numOfRows, String pageNo){
        final String TK_CINEMA = "http://data.gb.go.kr/opendata/service/rest/gbDongrak/getRecordList";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_CINEMA)
                .queryParam("numOfRows",numOfRows)
                .queryParam("pageNo",pageNo)
                .queryParam("serviceKey",KEY);
        if (!b_year.equals("0")) builder.queryParam("b_year",b_year);
        if (!b_month.equals("0")) builder.queryParam("b_month",b_month);

        String data = requestTKData(builder.build().toUriString());
        //
        data = data
                .replace("BMonth","bmonth")
                .replace("BNum","bnum")
                .replace("BPlace","bplace")
                .replace("BPlaydate","bplaydate")
                .replace("BPlaytime","bplaytime")
                .replace("BSubject","bsubject")
                .replace("BYear","byear");

        APITKCinemaDTO apitkCinemaDTO = null;

        try {
            XmlMapper xmlMapper = new XmlMapper();
            apitkCinemaDTO = xmlMapper.readValue(data, APITKCinemaDTO.class);
        }catch (Exception e){
            e.printStackTrace();
        }


        return apitkCinemaDTO.getBody().getItems();
    }



    public String requestTKData(String uri) {
        System.out.println(uri);
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(uri);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
