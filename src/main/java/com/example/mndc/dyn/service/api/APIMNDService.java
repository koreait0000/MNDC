package com.example.mndc.dyn.service.api;

import com.example.mndc.sta.model.dto.api.APIMNDJobDTO;
import com.example.mndc.sta.model.dto.api.APIMNDSaleDTO;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class APIMNDService extends APIService{
    public final String MND_URL = "https://openapi.mnd.go.kr";
    public final String KEY = "/3938313633333537323131313732313334";
    public final String TYPE = "/json";

    public final String MND_JOB = "/DS_RCRT_RCRTMT_BLTNBD_MND";
    public final String MND_SALE = "/DS_MND_ENLSTMN_DCNT_BEF_INF";

    public List<APIMNDJobDTO.DS.Row> searchMndJob( int startIndex, int endIndex) {
        APIMNDJobDTO apiSaleDTO = new Gson().fromJson(getData(startIndex,endIndex,MND_JOB), APIMNDJobDTO.class);

        return apiSaleDTO.getDS_RCRT_RCRTMT_BLTNBD_MND().getRow();
    }

    public List<APIMNDSaleDTO.DS.Row> searchMndSale( int startIndex, int endIndex) {
        APIMNDSaleDTO apiSaleDTO = new Gson().fromJson(getData(startIndex,endIndex,MND_SALE),APIMNDSaleDTO.class);

        return apiSaleDTO.getDS_MND_ENLSTMN_DCNT_BEF_INF().getRow();
    }

    public String getData(int startIndex,int endIndex,String type){
        String url = String.format("%s%s%s%s/%d/%d",MND_URL,KEY,TYPE, type, startIndex, endIndex);
        URI uri = URI.create(url);

        return requestData(uri,null);
    }
}
