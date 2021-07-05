package com.example.mndc.dao;

import com.example.mndc.model.BoardEntity;
import com.example.mndc.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO {

    List<BoardDTO> selectAllInfoByUnit(int mu_pk, int begin, int end);
    BoardDTO selectInfoByBPk(int b_pk);
    int insertBoard(BoardDTO boardDTO);
    int updateBoard(BoardDTO boardDTO);
    int deleteBoard(BoardDTO boardDTO);
}
