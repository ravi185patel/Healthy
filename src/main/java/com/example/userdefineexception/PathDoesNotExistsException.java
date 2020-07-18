package com.example.userdefineexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PathDoesNotExistsException extends StorageException {

    public PathDoesNotExistsException(String message) {
        super(message);
    }

    public PathDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}