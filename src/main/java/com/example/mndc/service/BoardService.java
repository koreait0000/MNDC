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

    public List<MilitaryUnitEntity> getUnitInfo(int type){
        return militaryUnitDAO.selectAllInfoByType(type);
    }
    public List<BoardDTO> getBoardInfo(int mu_pk){
        return boardDAO.selectAllInfoByUnit(mu_pk);
    }
}
