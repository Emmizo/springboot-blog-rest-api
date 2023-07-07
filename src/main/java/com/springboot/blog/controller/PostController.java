package com.springboot.blog.controller;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.PostDto;
// import com.springboot.blog.payload.PostDtoV2;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;
import com.springboot.blog.utils.AppConstant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Tag(
    name= "CRUD REST APIs for post resource"
)
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post
    @Operation(
        summary= "Create Post REST API",
        description = "Create Post REST API is used to save post into database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(
    name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    // get all posts rest api
    @Operation(
        summary= "get all Post REST API",
        description = "get all Post REST API is used to get post into database with pagination, "
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 OK"
    )
    @GetMapping("/posts")
    // public List<PostDto> getAllPosts(
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstant.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstant.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }
    // get post by id
@Operation(
        summary= "get Post by Id REST API",
        description = "Get Post REST API is used to get post into database based on id"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 OK"
    )
    @GetMapping(value="/posts/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
// @Operation(
//         summary= "get Post by Id REST API with tags",
//         description = "Get Post REST API is used to get post into database based on id with tags"
//     )
//     @ApiResponse(
//         responseCode = "200",
//         description = "Http Status 200 OK"
//     )
//     @GetMapping(value="/api/posts/{id}", params="version=2")
//     public ResponseEntity<PostDtoV2> getPostByIdV2(@PathVariable(name = "id") long id) {
//  PostDto postDto = postService.getPostById(id);
//  PostDtoV2 postDtoV2= new PostDtoV2();
//  postDtoV2.setId(postDto.getId());
//  postDtoV2.setTitle(postDto.getTitle());
//  postDtoV2.setDescription(postDto.getDescription());
//  postDtoV2.setContent(postDto.getContent());
//  List<String> tags = new ArrayList<>();
//  tags.add("java");
//  tags.add("Spring Boot");
//  tags.add("AWA");
//  postDtoV2.setTags(tags);
//         return ResponseEntity.ok(postDtoV2);
//     }
    // update post by id
    @Operation(
        summary= "UPDATE Post REST API",
        description = "Update Post REST API is used to update post into database"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 OK"
    )
    @SecurityRequirement(
    name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDto> updatePostById(@Valid @RequestBody PostDto postDto, @PathVariable long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return ResponseEntity.ok(postResponse);
    }

    @Operation(
        summary= "Delete Post REST API",
        description = "Delete Post REST API is used to delete post into database  "
    )
    @ApiResponse(
        responseCode = "200",
        description = "Http Status 200 OK"
    )
@SecurityRequirement(
    name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post Deleted well", HttpStatus.OK);
    }

    //build api by get post with category
@GetMapping("/posts/category/{id}")
    public ResponseEntity<List<PostDto>>getPostByCategory(@PathVariable("id") Long categoryId){
        List<PostDto> postDtos = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postDtos);
    }
}
