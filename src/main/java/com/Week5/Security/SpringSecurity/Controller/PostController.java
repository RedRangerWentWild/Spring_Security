package com.Week5.Security.SpringSecurity.Controller;

import com.Week5.Security.SpringSecurity.DTO.PostDto;
import com.Week5.Security.SpringSecurity.Service.Implementation.PostServiceImpl;
import com.Week5.Security.SpringSecurity.Service.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/post")
public class PostController {
    private final PostService ps;
    @GetMapping
    private ResponseEntity<List<PostDto>> getAll(){
        return ResponseEntity.ok(ps.getAllPosts());
    }
    @GetMapping(path = "/{PostId}")
    private ResponseEntity<PostDto>getPostById(@PathVariable(name="PostId")Long id){
        return ResponseEntity.ok(ps.getPostById(id));
    }
    @PostMapping
    private ResponseEntity<PostDto>createNewPost(PostDto dto){
        PostDto p=ps.createnew(dto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
@PutMapping(path ="PostId")
private ResponseEntity<PostDto>updatePost(@PathVariable(name="PostId")Long id,PostDto dto)throws Exception{
        return ResponseEntity.ok(ps.UpdatePost(id,dto));
}
}
