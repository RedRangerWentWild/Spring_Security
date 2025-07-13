package com.Week5.Security.SpringSecurity.Repo;

import com.Week5.Security.SpringSecurity.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
