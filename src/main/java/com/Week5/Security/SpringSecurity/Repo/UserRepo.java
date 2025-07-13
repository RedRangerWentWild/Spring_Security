package com.Week5.Security.SpringSecurity.Repo;

import com.Week5.Security.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String username);
}
