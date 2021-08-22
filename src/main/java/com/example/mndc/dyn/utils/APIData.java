package com.example.mndc.dyn.utils;

import com.example.mndc.sta.model.dto.HashMapDTO;

import java.util.ArrayList;
import java.util.List;

public class APIData {

    private static List<HashMapDTO> insertData(String[] data){
        List<HashMapDTO> list = new ArrayList();
        for (int i=0; i< data.length;i++){
            list.add(new HashMapDTO(i,data[i]));
        }
        return list;
    }


    public static List<HashMapDTO> getJobSearchLocations(){
        String[] locations = {
                "전국","서울","경기","인천","부산","대구","광주","대전","울산","세종","강원","경남","경북","전남","전북","충남","충북","제주","해외"
        };

        return insertData(locations);
    }
    public static List<HashMapDTO> getJobSearchCategories(){
        String[] categories = {
                "분류없음","군관련직위","사무관리","교육교사강사","법률경찰보안경비","보건의료사회복지","문화예술방송디자인","운정운송여행영업판매","건설건축토목시설관리","기게재료화학섬유","전기전자항공조선","IT전산정보통신","음식식품단순노무해외일자리"
        };

        return insertData(categories);
    }
}
