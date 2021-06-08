package com.example.mndc.model.vo;

import lombok.Data;

@Data
public class ApiResult{
    private String resultcode;
    private String message;
    private ApiResponse response;
}

