package com.lorenzon.blogging_platform_api.domain.service;

import com.lorenzon.blogging_platform_api.domain.exception.PostNotFoundException;
import com.lorenzon.blogging_platform_api.domain.model.Post;
import com.lorenzon.blogging_platform_api.domain.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Long postId, Post postUpdate) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        post.setTitle(postUpdate.getTitle());
        post.setContent(postUpdate.getContent());
        post.setCategory(postUpdate.getCategory());
        post.setUpdatedAt(OffsetDateTime.now());

        return postRepository.save(post);
    }

    @Transactional
    public void delete(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
        postRepository.delete(post);
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
