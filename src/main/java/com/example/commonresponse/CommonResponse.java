package com.example.commonresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CommonResponse {

    @Autowired
    private SuccessFullResponse successFullResponse;

    @Autowired
    private PagebleResponseModel pagebleResponseModel;

    public ResponseEntity<Object> getSuccessFullResponse(Object data,boolean flag){
        if(flag) {
            successFullResponse.setCode("200");
            successFullResponse.setStatus("success");
            if(data instanceof  Page){
                Page page=(Page)data;
                pagebleResponseModel.setData(page.getContent());
                pagebleResponseModel.setTotalElements(Long.valueOf(page.getTotalElements()));
                pagebleResponseModel.setTotalPages(page.getTotalPages());
                pagebleResponseModel.setSize(page.getSize());
                pagebleResponseModel.setPageSize(page.getPageable().getPageSize());
                pagebleResponseModel.setPageNumber(page.getPageable().getPageNumber());
                pagebleResponseModel.setNumberOfElements(page.getNumberOfElements());
                successFullResponse.setData(pagebleResponseModel);
            }else{
                successFullResponse.setData(data);
            }
            return new ResponseEntity<>(successFullResponse, HttpStatus.OK);
        }else{
            ErrorResponse errorResponse=(ErrorResponse)data;
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
