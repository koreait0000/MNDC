package com.example.mndc.sta.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class APISaleDTO {
    private DS DS_RCRT_RCRTMT_BLTNBD_MND;

    @Data
    public static class DS{
        private int list_total_count;
        private List<Row> row;

        @Data
        public static class Row{
            private String title;
            private String atchfl;
            private String ntcno;
            private String organ;
            private String bdbk_ctnt;
            private String orginl_site_url;
            private String wrtr;
            private String atchfl_downld_url;
            private String wrt_dttm;
        }
    }
}
