package com.Week5.Security.SpringSecurity.Configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    @Bean
    public ModelMapper create() {
        return new ModelMapper();
    }
}
