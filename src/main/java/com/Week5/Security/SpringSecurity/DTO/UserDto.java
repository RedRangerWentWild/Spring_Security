package com.Week5.Security.SpringSecurity.DTO;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String password;
}
