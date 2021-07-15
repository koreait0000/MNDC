package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.CmtEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtDAO {
    List<CmtEntity> selectAllInfoByMpk(int m_pk); // 내가 쓴 모든 댓글
    List<CmtEntity> selectUnreadInfoByBpk(int m_pk); // 내게 쓰인 안 읽은 댓글들
    int updateCAlertByCpk(int c_pk);
    int insertCmt(CmtEntity cmtEntity);
    int deleteCmtByCpk(int c_pk);
    int deleteCmtByBpk(int b_pk);

}
