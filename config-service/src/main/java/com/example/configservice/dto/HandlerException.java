package com.example.configservice.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HandlerException {
    public static ResponseEntity<?> handlerException(Exception e) {
        try {
            throw e;
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Call API Fail!");
        }
    }
}
