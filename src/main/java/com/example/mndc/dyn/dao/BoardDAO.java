package com.example.mndc.dyn.dao;

import com.example.mndc.sta.model.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardDAO {
    List<BoardEntity> selectBoardByType(int type);
}
