package com.Week5.Security.SpringSecurity.Advices;

import com.Week5.Security.SpringSecurity.Exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResourceNotFound.class)
public ResponseEntity<ApiError>Resource(ResourceNotFound ex){
ApiError a=new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
    ResponseEntity<ApiError> apiErrorResponseEntity = new ResponseEntity<>(a, HttpStatus.NOT_FOUND);
    return apiErrorResponseEntity;
}
}
