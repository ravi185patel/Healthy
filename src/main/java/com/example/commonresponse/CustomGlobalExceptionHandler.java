package com.example.commonresponse;


import com.example.userdefineexception.FileNotFoundException;
import com.example.userdefineexception.PathDoesNotExistsException;
import com.example.userdefineexception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value( "${application.versionno}" )
    private String version;
    @Autowired
    private ErrorResponse errorResponse;
    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());
        body.put("version", version);

        Map<String,String> errors=new LinkedHashMap<>();
        for(FieldError fieldError:ex.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        errorResponse.setCode(status.value()+"");
        errorResponse.setMessage("Validation Failed");
        errorResponse.setErrors(errors);
        body.put("error", errorResponse);
        return new ResponseEntity<>(body, headers, status);
    }
    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<Object> handleNoRecordFound(RecordNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("version", version);
        errorResponse.setMessage(ex.getLocalizedMessage());
        body.put("error", errorResponse);
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FileNotFoundException.class)
    protected ResponseEntity<Object> handleNoFileNotFoundException(FileNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("version", version);
        errorResponse.setMessage(ex.getLocalizedMessage());
        body.put("error", errorResponse);
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PathDoesNotExistsException.class)
    protected ResponseEntity<Object> handlePathDoesNotExistsException(PathDoesNotExistsException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("version", version);
        errorResponse.setMessage(ex.getLocalizedMessage());
        body.put("error", errorResponse);
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
}

