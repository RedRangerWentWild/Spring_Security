package com.Week5.Security.SpringSecurity.Service.Implementation;

import com.Week5.Security.SpringSecurity.Exceptions.ResourceNotFound;
import com.Week5.Security.SpringSecurity.Repo.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserRepo ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ur.findByEmail(username).orElseThrow(()-> new ResourceNotFound("user with email" +username+"not found"));
    }
}
