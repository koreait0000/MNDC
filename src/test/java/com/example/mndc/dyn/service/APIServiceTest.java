package com.example.mndc.dyn.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class APIServiceTest {


    @Test
    void searchJob() {
        APIService apiService = new APIService();
//        apiService.searchJob(1,"a",1);
        apiService.searchSale(1,5);
    }
}