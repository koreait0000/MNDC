package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.CmtEntity;
import com.example.mndc.sta.model.dto.CmtDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtDAO {
    List<CmtEntity> selectCmtsByMpk(int mpk);
    List<CmtDTO> selectCmtsByBpk(int bpk);

    int insertCmt(CmtEntity cmtEntity);

    int deleteCmtByCpk(CmtEntity cmtEntity);
    int deleteCmtByBpk(int bpk);

}
