package com.example.mndc.sta.model.dto;

import lombok.Data;

import java.util.List;
@Data
public class APITKTourism {
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
            private String address;
            private String category;
            private String content;
            private String manage;
            private String subject;
            private String telephone;
        }
    }
}
