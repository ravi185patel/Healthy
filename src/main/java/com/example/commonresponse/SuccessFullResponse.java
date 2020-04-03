package com.example.commonresponse;

import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class SuccessFullResponse<T>{
    private String code;
    private String status;
    @Valid
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
