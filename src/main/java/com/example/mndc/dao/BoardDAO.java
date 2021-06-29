package com.example.mndc.dao;

import com.example.mndc.model.BoardEntity;
import com.example.mndc.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO {

    List<BoardDTO> selectAllInfoByUnit(int mu_pk);
}
