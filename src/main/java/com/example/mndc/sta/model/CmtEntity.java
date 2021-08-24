package com.example.mndc.sta.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CmtEntity {
    private int cpk;
    private String c_ctnt;
    private String c_regdt;
    private boolean c_alert;

    private int bpk;
    private Long mpk;
}
