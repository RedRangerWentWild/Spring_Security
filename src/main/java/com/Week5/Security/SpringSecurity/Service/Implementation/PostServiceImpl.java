package com.Week5.Security.SpringSecurity.Service.Implementation;

import ch.qos.logback.core.model.Model;
import com.Week5.Security.SpringSecurity.DTO.PostDto;
import com.Week5.Security.SpringSecurity.Entity.Post;
import com.Week5.Security.SpringSecurity.Exceptions.ResourceNotFound;
import com.Week5.Security.SpringSecurity.Repo.PostRepo;
import com.Week5.Security.SpringSecurity.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepo pr;
    private ModelMapper model;
    @Override
    public List<PostDto> getAllPosts() {
          List<Post>li=pr.findAll();
          return li.stream()
                  .map(list->model.map(list, PostDto.class))
                  .collect(Collectors.toList());
    }
    @Override
    public PostDto getPostById(Long id)  {
        Post p=pr.findById(id).orElseThrow(()->new ResourceNotFound("not found"));
        return model.map(p, PostDto.class);
    }

    @Override
    public PostDto createnew(PostDto dto) {
        Post p=model.map(dto, Post.class);
        Post k=pr.save(p);
        return model.map(k, PostDto.class);
    }

    @Override
    public PostDto UpdatePost(Long id, PostDto dto) {
      Post old=pr.findById(id).orElseThrow(()->new ResourceNotFound("Post with id"+id+"not found"));
      dto.setId(id);
      model.map(dto,old);
      Post j=pr.save(old);
      return model.map(j, PostDto.class);
    }
}
