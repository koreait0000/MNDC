package com.example.mndc.sta.model.dto.api;

import lombok.Data;

import java.util.List;

@Data
public class APIMNDSaleDTO {
    private DS DS_MND_ENLSTMN_DCNT_BEF_INF;

    @Data
    public static class DS{
        private int list_total_count;
        private List<DS.Row> row;

        @Data
        public static class Row{
            private String fnshday;
            private String dcntenatvnm;
            private String dtlexpln;
            private String cntadr;
            private String instltnnm;
            private String hmpg;
            private String rowno;
            private String startday;
            private String rgn;
        }
    }
}
