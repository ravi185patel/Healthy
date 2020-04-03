package com.example.commonresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
public class CommonResponse {

    @Autowired
    private SuccessFullResponse successFullResponse;

    public ResponseEntity<Object> getSuccessFullResponse(Object data,boolean flag){
        if(flag) {
            successFullResponse.setCode("200");
            successFullResponse.setData(data);
            successFullResponse.setStatus("success");
            return new ResponseEntity<>(successFullResponse, HttpStatus.OK);
        }else{
            ErrorResponse errorResponse=(ErrorResponse)data;
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
