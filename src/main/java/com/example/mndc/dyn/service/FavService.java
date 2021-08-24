package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.FavDAO;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.FavEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavService {
    @Autowired
    FavDAO favDAO;

    public int favProc(FavEntity favEntity,int flag){
        // TODO : 에러 제어는 어떻게?
        switch (flag){
            case 0: // 0 0 => 왼 클릭
                favEntity.setToggle(1);
                return favDAO.insertFav(favEntity);
            case 1: // 0 0 => 좌 클릭
                favEntity.setToggle(0);
                return favDAO.insertFav(favEntity);
            case 2: // 1 0 => 좌 클릭
            case 5: // 0 1 => 우 클릭
                return favDAO.deleteFav(favEntity);
            case 3: // 1 0 => 우 클릭
                favEntity.setToggle(0);
                return favDAO.updateFav(favEntity);
            case 4: // 0 1 => 좌 클릭
                favEntity.setToggle(1);
                return favDAO.updateFav(favEntity);
            default:
                return 0;
        }

    }

    public int configFav(FavEntity favEntity){
        boolean flag = checkFav(favEntity);
        System.out.println(flag);
        if (flag) favDAO.insertFav(favEntity);
        else favDAO.deleteFav(favEntity);

        return favDAO.selectFavCount(favEntity);
    }

    public boolean checkFav(FavEntity favEntity){
        return 0==favDAO.selectFavByMpkBpk(favEntity);
    }

}
