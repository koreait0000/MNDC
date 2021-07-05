package com.example.mndc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CmtEntity {
    private int c_pk;
    private String c_ctnt;
    private String c_regdt;
    private int c_name;

    private int b_pk;
    private int m_pk;
}
