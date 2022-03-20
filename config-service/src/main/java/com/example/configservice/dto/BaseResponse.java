package com.example.configservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BaseResponse<T> {
    private boolean success;
    private T data;
    private ArrayList<BaseError> error = new ArrayList<>();

    public void addError(BaseError baseError) {
        this.error.add(baseError);
    }
}
