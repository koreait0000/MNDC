package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.FavEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FavDAO {
    int insertFav(FavEntity favEntity);
    int updateFav(FavEntity favEntity);
    int deleteFav(FavEntity favEntity);


}