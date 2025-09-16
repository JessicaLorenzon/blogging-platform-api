package com.lorenzon.blogging_platform_api.domain.exception;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(Long postId) {
        super("Post with ID " + postId + " not found");
    }
}
