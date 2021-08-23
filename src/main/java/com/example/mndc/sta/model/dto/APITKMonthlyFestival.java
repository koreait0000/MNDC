package com.example.mndc.sta.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class APITKMonthlyFestival {
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
            private String content;
            private String enddate;
            private String no;
            private String startdate;
            private String title;
        }
    }
}
