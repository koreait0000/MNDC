package com.example.mndc.dyn.service;

import com.example.mndc.dyn.service.api.APIBHService;
import com.example.mndc.dyn.service.api.APIMNDService;
import com.example.mndc.dyn.service.api.APIXMLService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class APIServiceTest {

    APIMNDService apimndService = new APIMNDService();
    APIXMLService apiXmlService = new APIXMLService();
    APIBHService apibhService = new APIBHService();
    @Test
    void searchMNDSale() {
        apimndService.testPrint(apimndService.searchMndSale(1,5));
    }

    @Test
    void asd() {
        LocalDate date = LocalDate.now();
        System.out.println(date.getMonthValue());
        System.out.println(date.getYear());
    }
    @Test
    void searchMNDJob(){
        apimndService.testPrint(apimndService.searchMndJob(1,5));
    }

    @Test
    void searchBhJob(){
        apiXmlService.testPrint(apibhService.searchBhJob("1","1","1"));
    }

    @Test
    void searchCinema(){
        apiXmlService.testPrint(apiXmlService.searchTKCinema("2020","09","10","1"));
    }

    @Test
    void searchGyeonghuFood(){
        apiXmlService.testPrint(apiXmlService.searchTKGyeonjuFood());
    }

    @Test
    void searchFestival(){
        apiXmlService.testPrint(apiXmlService.searchTKFestival());
    }

    @Test
    void searchEvent(){
        apiXmlService.testPrint(apiXmlService.searchTKEvent("0"));
    }

    @Test
    void searchRecreation(){
        apiXmlService.testPrint(apiXmlService.searchRecreation());
    }

    @Test
    void searchTourism(){
        apiXmlService.testPrint(apiXmlService.searchTourism());
    }

    @Test
    void searchMonthlyFestival(){
        apiXmlService.testPrint(apiXmlService.searchMonthlyFestival("0","0"));
    }
}