package com.example.mndc.dyn.service;

import com.example.mndc.dyn.service.api.APIBHService;
import com.example.mndc.dyn.service.api.APIMNDService;
import com.example.mndc.dyn.service.api.APIXMLService;
import org.junit.jupiter.api.Test;

class APIServiceTest {

    APIMNDService apimndService = new APIMNDService();
    APIXMLService apiXmlService = new APIXMLService();
    APIBHService apibhService = new APIBHService();
    @Test // 국방부_병사 할인 혜택 정보
    void searchMNDSale() { apimndService.testPrint(apimndService.searchMndSale(1,5)); }

    @Test // 국방부_제대군인 공고
    void searchMNDJob(){
        apimndService.testPrint(apimndService.searchMndJob(1,1));
    }

    @Test // 국가보훈처_제대군인공고
    void searchBhJob(){
        apiXmlService.testPrint(apibhService.searchBhJob("1","1","1"));
    }

    @Test //경상북도_청사 주말시네마 상영 현황 서비스
    void searchCinema(){
        apiXmlService.testPrint(apiXmlService.searchTKCinema("2020","09","10","1"));
    }

    @Test // 경상북도_경주시_ 먹을거리 조회
    void searchGyeonghuFood(){
        apiXmlService.testPrint(apiXmlService.searchTKGyeonjuFood());
    }

    @Test // 경상북도 문화축제 정보조회
    void searchFestival(){
        apiXmlService.testPrint(apiXmlService.searchTKFestival());
    }

    @Test // 경상북도 공연행사 정보
    void searchEvent(){
        apiXmlService.testPrint(apiXmlService.searchTKEvent("0"));
    }

    @Test // 경상북도 휴양시설 정보조회
    void searchRecreation(){
        apiXmlService.testPrint(apiXmlService.searchRecreation());
    }

    @Test // 경상북도내 관광(단)지 정보조회
    void searchTourism(){
        apiXmlService.testPrint(apiXmlService.searchTourism());
    }

    @Test //경상북도 시군의 월별 주요 축제 정보조회
    void searchMonthlyFestival(){
        apiXmlService.testPrint(apiXmlService.searchMonthlyFestival("0","0"));
    }
}