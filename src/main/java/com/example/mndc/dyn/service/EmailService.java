package com.example.mndc.dyn.service;


public interface EmailService {
    void sendMimeMessage(String to, String subject, String text);
}
