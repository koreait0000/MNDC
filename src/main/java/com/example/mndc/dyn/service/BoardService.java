package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.BoardDAO;
import com.example.mndc.dyn.dao.MilitaryUnitDAO;
import com.example.mndc.sta.model.BoardEntity;
import com.example.mndc.sta.model.CmtEntity;
import com.example.mndc.sta.model.MilitaryUnitEntity;
import com.example.mndc.sta.model.dto.BoardDTO;
import com.example.mndc.sta.model.dto.MilitaryUnitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    MilitaryUnitDAO militaryUnitDAO;
    @Autowired
    BoardDAO boardDAO;

    private final int PAGE_ROW = 10;

    public List<MilitaryUnitEntity> getUnitInfo(int type){
        // 부대 목록 불러오기
        return militaryUnitDAO.selectAllInfoByType(type);
    }
    public List<MilitaryUnitEntity> getUnitInfoSearch(String search, int type){
        return militaryUnitDAO.selectAllInfoBySearch(search, type);
    }
    public List<BoardDTO> getBoardsInfo(int mu_pk,int page){
        //게시물 목록 불러오기
        int begin = (page-1)*PAGE_ROW;
        int end = page*PAGE_ROW;
        return boardDAO.selectAllInfoByUnit(mu_pk,begin,end);
    }
    public List<BoardDTO> getMyBoardsInfo(int m_pk){
        // 회원 정보로 게시글 가져오기
        return boardDAO.selectAllInfoByMPk(m_pk);
    }
    public List<CmtEntity> getMyCmtsInfo(int m_pk){
        // 회원 정보로 댓글들 가져오기
        return boardDAO.selectAllCmtByMPk(m_pk);
    }
    public BoardDTO getBoardInfo(int b_pk){
        // 게시물 불러오기
        return boardDAO.selectInfoByBPk(b_pk);
    }
    public int writeBoard(BoardDTO boardDTO){
        // 게시물 쓰기
        return boardDAO.insertBoard(boardDTO);
    }
    public int modifyBoard(BoardDTO boardDTO){
        // 게시물 수정하기
        return boardDAO.updateBoard(boardDTO);
    }
    public int deleteBoard(BoardDTO boardDTO){
        // 게시물 지우기
        return boardDAO.deleteBoard(boardDTO);
    }
    public List<BoardEntity> searchBoard(String search){
        return boardDAO.selectAllInfoBySearch(search);
    }
    public List<MilitaryUnitEntity> searchMilitaryUnit(String search){
        return militaryUnitDAO.selectAllInfoBySearch(search,0);
    }
    public String getUnitName(int mu_pk){
        return militaryUnitDAO.selectNameByMuPk(mu_pk);
    }

}
