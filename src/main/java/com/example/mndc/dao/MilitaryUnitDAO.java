package com.example.mndc.dao;

import com.example.mndc.model.MilitaryUnitEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MilitaryUnitDAO {
    List<MilitaryUnitEntity> selectAllInfoByType(int type);
    List<MilitaryUnitEntity> selectAllInfoBySearch(String search);

}
