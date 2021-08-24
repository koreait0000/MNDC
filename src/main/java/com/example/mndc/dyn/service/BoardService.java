package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.*;
import com.example.mndc.sta.auth.PrincipalDetails;
import com.example.mndc.sta.model.BoardEntity;
import com.example.mndc.sta.model.CmtEntity;
import com.example.mndc.sta.model.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService extends CommonService{

    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private CmtDAO cmtDAO;

    private final int PAGE_ROW = 15;

    public int delBoard(BoardEntity boardEntity){
        return boardDAO.delBoard(boardEntity);
    }

    public List<BoardDTO> getBoardList(int page){
        int startIdx = (page-1)*PAGE_ROW;
        int endIdx = page*PAGE_ROW;
        return boardDAO.selectBoardByType(startIdx,endIdx);
    }

    public int upCount(int bpk){
        return boardDAO.upCount(bpk);
    }

    public BoardDTO getBoard(int bpk){
        return boardDAO.selectBoardByBPk(bpk);
    }

    public List<BoardEntity> getMyBoardsInfo(PrincipalDetails principalDetails){
        return boardDAO.selectBoardsByMpk(getMpk(principalDetails));
    }

    public List<CmtEntity> getMyCmtsInfo(PrincipalDetails principalDetails){
        return cmtDAO.selectCmtsByMpk(getMpk(principalDetails));
    }

    public int writeBoard(BoardEntity boardEntity){
        return boardDAO.insertBoard(boardEntity);
    }

    // 추후 파라미터로 int type등을 통하여 게시판 별로 검색하기
    public int getPage(){
        return boardDAO.selectBoardCount()/PAGE_ROW + 1;
    }

}
