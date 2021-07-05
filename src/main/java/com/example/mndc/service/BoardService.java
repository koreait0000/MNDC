package com.example.mndc.service;

import com.example.mndc.dao.BoardDAO;
import com.example.mndc.dao.MilitaryUnitDAO;
import com.example.mndc.model.BoardEntity;
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

    private final int PAGE_ROW = 15;

    public List<MilitaryUnitEntity> getUnitInfo(int type){
        return militaryUnitDAO.selectAllInfoByType(type);
    }
    public List<BoardDTO> getBoardsInfo(int mu_pk,int page){
        int begin = (page-1)*PAGE_ROW;
        int end = page*PAGE_ROW;
        return boardDAO.selectAllInfoByUnit(mu_pk,begin,end);
    }
    public BoardDTO getBoard(int b_pk){
        return boardDAO.selectInfoByBPk(b_pk);
    }
    public int writeBoard(BoardDTO boardDTO){
        return boardDAO.insertBoard(boardDTO);
    }
    public int modifyBoard(BoardDTO boardDTO){
        return boardDAO.updateBoard(boardDTO);
    }
    public int deleteBoard(BoardDTO boardDTO){
        return boardDAO.deleteBoard(boardDTO);
    }
}
