package com.example.controller;

import com.example.commonresponse.CommonResponse;
import com.example.model.TestModel;
import com.example.service.ServiceI;
import com.example.service.TestSerivceI;
import com.example.specification.TestListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Provider;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestSerivceI<TestModel> testService;

    @Autowired
    private Provider<CommonResponse> commonResponseProvider;

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getTest(@PathVariable("id") Long id){
//        return commonResponseProvider.get().getSuccessFullResponse(testService.get(id),true);
//    }

    @GetMapping("")
    public ResponseEntity<Object> getTest(TestListRequest request, Pageable pageRequest){
        return commonResponseProvider.get().getSuccessFullResponse(testService.findAll(request,pageRequest),true);
    }

    @PostMapping
    public ResponseEntity<Object> createTest(@Valid @RequestBody TestModel TestModel){
        return commonResponseProvider.get().getSuccessFullResponse(testService.add(TestModel),true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTest(@Valid @RequestBody TestModel TestModel, @PathVariable("id") Long id){
        return commonResponseProvider.get().getSuccessFullResponse(testService.add(TestModel),true);
    }

    @DeleteMapping("/{id}")
    public TestModel inactiveTest(@PathVariable("id") Long id){
        // just set isActive column -> false for inactive
        return null;
    }

}