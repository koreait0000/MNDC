package com.example.mndc.service;

import com.example.mndc.dao.BoardDAO;
import com.example.mndc.dao.MilitaryUnitDAO;
import com.example.mndc.model.BoardEntity;
import com.example.mndc.model.CmtEntity;
import com.example.mndc.model.MilitaryUnitEntity;
import com.example.mndc.model.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
}
