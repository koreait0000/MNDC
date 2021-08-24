package com.example.mndc.sta.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class APIBhJobDTO {
    private String title;
    private String total_count;
    private String category;
    private String jobtype;
    private String location;
    private List<APIJobArticleDTO> articles;

    @Data
    public static class APIJobArticleDTO {
        private String company;
        private String link;
        private String contents;
        private String area;
        private String pay;
        private String regdate;
        private String enddate;
    }
}
