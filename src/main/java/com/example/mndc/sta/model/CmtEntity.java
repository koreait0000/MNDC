package com.example.mndc.sta.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CmtEntity {
    private int cpk;
    private String c_ctnt;
    private String c_regdt;
    private boolean c_alert;

    private int bpk;
    private int mpk;
}
