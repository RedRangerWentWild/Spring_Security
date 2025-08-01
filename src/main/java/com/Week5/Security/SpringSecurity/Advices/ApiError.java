package com.Week5.Security.SpringSecurity.Advices;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
public class ApiError {
    private LocalDateTime timestamp;
    private String error;
    private HttpStatus status;
public ApiError(){
    timestamp=LocalDateTime.now();
}
public ApiError(String error,HttpStatus status){
    this();
    this.error=error;
    this.status=status;
}
}
