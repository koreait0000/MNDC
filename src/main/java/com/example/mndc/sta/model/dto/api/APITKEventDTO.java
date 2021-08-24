package com.example.mndc.sta.model.dto.api;

import lombok.Data;

import java.util.List;

@Data
public class APITKEventDTO {
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
            private String discountinfo;
            private String edate;
            private String entryage;
            private String fee;
            private String feeinfo;
            private String homepage;
            private String instructions;
            private String latitude;
            private String longitude;
            private String name;
            private String org1;
            private String org2;
            private String parkingyn;
            private String pcount;
            private String place;
            private String roadaddr;
            private String sdate;
            private String sigunname;
            private String sponsor;
            private String stime;
            private String tel;
            private String ticketinfo;
            private String wdate;


        }
    }
}
