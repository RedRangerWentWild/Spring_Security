package com.Week5.Security.SpringSecurity.Exceptions;

public class ResourceNotFound extends RuntimeException{
public ResourceNotFound(String message){
    super(message);
}
}
