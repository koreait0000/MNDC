package com.example.mndc.sta.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
    private int bpk;
    private String b_title;
    private String b_ctnt;
    private String b_regdt;
    private int b_view;
    private int b_type;
    private Long mpk;

}
