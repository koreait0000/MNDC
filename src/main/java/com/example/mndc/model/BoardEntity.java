package com.example.mndc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
    private int b_pk;
    private String b_title;
    private String b_ctnt;
    private String b_regdt;
    private int b_like;
    private int b_view;
    private int b_type;
    private int m_pk;
    private int mu_pk;

}
