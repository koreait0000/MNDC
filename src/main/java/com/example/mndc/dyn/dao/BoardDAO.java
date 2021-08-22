package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.BoardEntity;
import com.example.mndc.sta.model.CmtEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardDAO {
    List<BoardEntity> selectBoardByType(int b_type);

    BoardEntity selectBoardByBPk(int bpk);
    List<BoardEntity> selectBoardsByMpk(int mpk);

}
