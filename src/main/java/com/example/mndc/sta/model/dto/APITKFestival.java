package com.example.mndc.sta.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class APITKFestival {
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
            private String addr;
            private String content;
            private String eday;
            private String homepage;
            private String latitude;
            private String longitude;
            private String name;
            private String organizers;
            private String place;
            private String roadaddr;
            private String sday;
            private String sigunname;
            private String sinfo;
            private String sponsor;
            private String tel;
            private String wdate;

        }
    }
}
