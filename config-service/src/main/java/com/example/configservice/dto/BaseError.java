package com.example.configservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseError {
    private String message;
    private String error;

    public BaseError(String message, String error) {
        this.message = message;
        this.error = error;
    }
}
