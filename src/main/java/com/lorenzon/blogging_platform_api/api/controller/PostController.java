package com.lorenzon.blogging_platform_api.api.controller;

import com.lorenzon.blogging_platform_api.api.assembler.PostAssembler;
import com.lorenzon.blogging_platform_api.api.model.PostRepresentationModel;
import com.lorenzon.blogging_platform_api.api.model.input.PostInput;
import com.lorenzon.blogging_platform_api.domain.model.Post;
import com.lorenzon.blogging_platform_api.domain.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final PostAssembler postAssembler;

    @PostMapping
    public ResponseEntity<PostRepresentationModel> createPost(@Valid @RequestBody PostInput postInput) {
        Post post = postAssembler.toEntity(postInput);
        PostRepresentationModel postModel = postAssembler.toModel(postService.create(post));
        return ResponseEntity.status(HttpStatus.CREATED).body(postModel);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostRepresentationModel> updatePost(@PathVariable Long postId, @Valid @RequestBody PostInput postInput) {
        Post post = postAssembler.toEntity(postInput);
        Post postUpdated = postService.update(postId, post);
        PostRepresentationModel postModel = postAssembler.toModel(postUpdated);
        return ResponseEntity.ok(postModel);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{postId}")
    public PostRepresentationModel getPost(@PathVariable Long postId) {
        return postAssembler.toModel(postService.findById(postId));
    }

    @GetMapping
    public List<PostRepresentationModel> getAllPosts() {
        return postAssembler.toCollection(postService.findAll());
    }

}
