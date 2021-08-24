package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.BoardEntity;
import com.example.mndc.sta.model.CmtEntity;
import com.example.mndc.sta.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardDAO {
    List<BoardDTO> selectBoardByType(int startIdx, int endIdx);
    int insertBoard(BoardEntity boardEntity);
    BoardDTO selectBoardByBPk(int bpk);
    List<BoardEntity> selectBoardsByMpk(int mpk);
    int upCount(int bpk);
    int selectBoardCount();
    int delBoard(BoardEntity boardEntity);
}
