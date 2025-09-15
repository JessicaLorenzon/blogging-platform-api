package com.lorenzon.blogging_platform_api.api.controller;

import com.lorenzon.blogging_platform_api.api.assembler.PostAssembler;
import com.lorenzon.blogging_platform_api.api.model.PostRepresentationModel;
import com.lorenzon.blogging_platform_api.api.model.input.PostInput;
import com.lorenzon.blogging_platform_api.domain.model.Post;
import com.lorenzon.blogging_platform_api.domain.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final PostAssembler postAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostRepresentationModel addPost(@Valid @RequestBody PostInput postInput) {
        Post post = postAssembler.toEntity(postInput);
        post.setCreatedAt(OffsetDateTime.now());
        return postAssembler.toModel(postService.save(post));
    }

    @PutMapping("/{postId}")
    public PostRepresentationModel updatePost(@PathVariable Long postId, @Valid @RequestBody PostInput postInput) {
        Post post = postAssembler.toEntity(postInput);
        Post postUpdated = postService.update(postId, post);
        return postAssembler.toModel(postUpdated);
    }

    @DeleteMapping("{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.delete(postId);
    }

    @GetMapping("{postId}")
    public PostRepresentationModel getPost(@PathVariable Long postId) {
        return postAssembler.toModel(postService.findById(postId));
    }

    @GetMapping
    public List<PostRepresentationModel> getAllPosts() {
        return postAssembler.toCollection(postService.findAll());
    }

}
