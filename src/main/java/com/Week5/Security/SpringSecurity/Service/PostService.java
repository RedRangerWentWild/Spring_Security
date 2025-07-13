package com.Week5.Security.SpringSecurity.Service;

import com.Week5.Security.SpringSecurity.DTO.PostDto;
import com.Week5.Security.SpringSecurity.Exceptions.ResourceNotFound;

import java.util.List;

public interface PostService {
    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    PostDto createnew(PostDto dto);

    PostDto UpdatePost(Long id, PostDto dto);
}
