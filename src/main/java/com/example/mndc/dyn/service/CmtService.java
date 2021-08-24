package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.CmtDAO;
import com.example.mndc.sta.model.CmtEntity;
import com.example.mndc.sta.model.dto.CmtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    @Autowired
    private CmtDAO cmtDAO;

    public int addCmt(CmtEntity cmtEntity){
        return cmtDAO.insertCmt(cmtEntity);
    }

    public List<CmtDTO> getCmtList(int bpk){
        return cmtDAO.selectCmtsByBpk(bpk);
    }

    public int delCmt(CmtEntity cmtEntity){
        return cmtDAO.deleteCmtByCpk(cmtEntity);
    }
}
