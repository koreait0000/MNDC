package com.example.mndc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private int m_pk;
    private String m_id;
    private String m_pw;
    private int m_type;
    private int m_auth;
    private int mu_pk;

}
