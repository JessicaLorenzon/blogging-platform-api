package com.lorenzon.blogging_platform_api.domain.service;

import com.lorenzon.blogging_platform_api.domain.exception.PostNotFoundException;
import com.lorenzon.blogging_platform_api.domain.model.Post;
import com.lorenzon.blogging_platform_api.domain.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final EntityManager entityManager;

    @Transactional
    public Post create(Post post) {
        post.setCreatedAt(OffsetDateTime.now());
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Long postId, Post postUpdate) {
        Post post = findById(postId);
        post.updateWith(postUpdate);
        post.setUpdatedAt(OffsetDateTime.now());

        return post;
    }

    @Transactional
    public void delete(Long postId) {
        Post post = findById(postId);
        postRepository.delete(post);
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByTerm(String term) {
        String jpql = """
                SELECT p FROM Post p
                WHERE lower(p.title)  LIKE :term
                  OR lower(p.content) LIKE :term
                  OR lower(p.category) LIKE :term
                """;
        TypedQuery<Post> query = entityManager.createQuery(jpql, Post.class);
        query.setParameter("term", "%" + term.toLowerCase() + "%");
        return query.getResultList();
    }
}
