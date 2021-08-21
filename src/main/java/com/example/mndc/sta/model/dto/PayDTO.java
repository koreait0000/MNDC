package com.example.mndc.sta.model.dto;

import lombok.Data;

@Data
public class PayDTO {
    private String secret;
    private String status;
    private String orderId;
}
