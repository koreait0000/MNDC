package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.*;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.BoardEntity;
import com.example.mndc.sta.model.CmtEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService extends CommonService{

    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private CmtDAO cmtDAO;

    private final int PAGE_ROW = 10;

    public List<BoardEntity> getBoardList(int b_type){
        return boardDAO.selectBoardByType(b_type);
    }

    public List<BoardEntity> getMyBoardsInfo(PrincipalDetails principalDetails){
        return boardDAO.selectBoardsByMpk(getMpk(principalDetails));
    }

    public List<CmtEntity> getMyCmtsInfo(PrincipalDetails principalDetails){
        return cmtDAO.selectCmtsByMpk(getMpk(principalDetails));
    }


}
