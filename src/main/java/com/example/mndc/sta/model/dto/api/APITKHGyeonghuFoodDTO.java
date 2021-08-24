package com.example.mndc.sta.model.dto.api;

import lombok.Data;

import java.util.List;
@Data
public class APITKHGyeonghuFoodDTO {
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
            private String address_01;
            private String address_02;
            private String business;
            private String categoryid;
            private String close_01;
            private String close_02;
            private String contentsId;
            private String credit;
            private String gps_01;
            private String gps_02;
            private String img1;
            private String img2;
            private String img3;
            private String img4;
            private String img5;
            private String img6;
            private String img7;
            private String img8;
            private String img9;
            private String img10;
            private String img11;
            private String img12;
            private String img13;
            private String img14;
            private String img15;
            private String img16;
            private String img17;
            private String img18;
            private String img19;
            private String img20;
            private String img21;
            private String img22;
            private String img23;
            private String img24;
            private String img25;
            private String img26;
            private String img27;
            private String img28;
            private String img29;
            private String intro_03;
            private String loc;
            private String menu;
            private String pack_01;
            private String pack_02;
            private String parking_01;
            private String smoking_01;
            private String smoking_02;
            private String smoking_03;
            private String subTitle;
            private String tel_01;
            private String title;
            private String usetime;
            private String vod1;
            private String vod1Img;
            private String vr1;
            private String vrCheck;
        }
    }
}
