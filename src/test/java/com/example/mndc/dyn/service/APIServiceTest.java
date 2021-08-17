package com.example.mndc.dyn.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.mndc.sta.model.dto.APISaleDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class APIServiceTest {


    @Test
    void searchJob() {
        APIService apiService = new APIService();
        /*apiService.searchJob("1","j","1");*/
        List<APISaleDTO.DS.Row> jobList = apiService.searchSale(1,5);

        System.out.println(jobList.get(0).getTitle());
    }
}