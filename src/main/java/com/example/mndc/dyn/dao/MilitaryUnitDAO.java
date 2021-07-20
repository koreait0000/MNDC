package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.MilitaryUnitEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MilitaryUnitDAO {
    List<MilitaryUnitEntity> selectAllInfoByType(int mu_type);
    List<MilitaryUnitEntity> selectAllInfoBySearch(String search);
    String selectNameByMuPk(int mu_pk);
}
