package com.Week5.Security.SpringSecurity.Configs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.
                authorizeHttpRequests(authorize->authorize.
                        requestMatchers("/post").permitAll()
                        .requestMatchers("/post/**").hasAnyRole("ADMIN").
                        anyRequest().
                        authenticated()
                ).formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }
    @Bean
    UserDetailsService myInMemory(){
        UserDetails userDetails= User.withUsername("Aadi")
                .password(encode().encode("aadi01022007"))
                .roles("ADMIN")
                .build();
        UserDetails userDetails1=User.withUsername("Madhav")
                .password(encode().encode("Madhav01022007"))
                .roles("USER")
                .build();
     return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }
    @Bean
    PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
            }
}



