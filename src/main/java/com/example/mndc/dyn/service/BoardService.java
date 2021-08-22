package com.example.mndc.dyn.service;

import com.example.mndc.dyn.dao.*;
import com.example.mndc.sta.model.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardDAO boardDAO;

    private final int PAGE_ROW = 10;

    public List<BoardEntity> getBoardList(int type){
        return boardDAO.selectBoardByType(type);
    }


}
