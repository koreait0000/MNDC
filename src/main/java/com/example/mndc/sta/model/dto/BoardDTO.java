package com.example.mndc.sta.model.dto;

import com.example.mndc.sta.model.BoardEntity;
import lombok.Data;

@Data
public class BoardDTO extends BoardEntity {
    private String mnm;
    private int b_like;
}
