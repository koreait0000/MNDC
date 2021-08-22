package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.CmtEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtDAO {
    List<CmtEntity> selectCmtsByMpk(int mpk);

    void insertCmt(CmtEntity cmtEntity);

    void deleteCmtByCpk(int cpk);
    void deleteCmtByBpk(int bpk);

}
