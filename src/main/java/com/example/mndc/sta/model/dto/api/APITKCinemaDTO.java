package com.example.mndc.sta.model.dto.api;

import lombok.Data;

import java.util.List;

@Data
public class APITKCinemaDTO {
//    private String numOfRows;
//    private String pageNo;
//    private String totalCount;
//    private String b_num;
//    private String b_subject;
//    private String b_playdate;
//    private String b_place;
//    private String b_playtime;
    private Header header;
    private Body body;

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }
    @Data
    public static class Body{
        private List<Item> items;
        private int numOfRows;
        private int pageNo;
        private int totalCount;

        @Data
        public static class Item{
            private String bmonth;
            private String bnum;
            private String bplace;
            private String bplaydate;
            private String bplaytime;
            private String bsubject;
            private String byear;
        }
    }
}
