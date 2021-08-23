package com.example.mndc.dyn.service.api;

import com.example.mndc.sta.model.dto.APIBhJobDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class APIBHService extends APIService{
    public List<APIBhJobDTO.APIJobArticleDTO> searchBhJob(String page, String location, String category){
        final String TK_JOB = "https://vnet.go.kr/empn/jobsearchxml.do";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TK_JOB)
                .queryParam("page",page);
        if (!location.equals("0")) builder.queryParam("location",location);
        if (!category.equals("0")) builder.queryParam("category",category);
        UriComponents uri = builder.build();

        String data = requestData(uri.toUri(),null);
        System.out.println(data);

        APIBhJobDTO aPITKJobDTO = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            aPITKJobDTO = xmlMapper.readValue(data, APIBhJobDTO.class);
        }catch (Exception e){}

        return aPITKJobDTO.getArticles();
    }

}
