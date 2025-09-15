package com.lorenzon.blogging_platform_api.api.assembler;

import com.lorenzon.blogging_platform_api.api.model.PostRepresentationModel;
import com.lorenzon.blogging_platform_api.api.model.input.PostInput;
import com.lorenzon.blogging_platform_api.domain.model.Post;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PostAssembler {

    private final ModelMapper modelMapper;

    public Post toEntity(PostInput postInput) {
        return modelMapper.map(postInput, Post.class);
    }

    public PostRepresentationModel toModel(Post post) {
        return modelMapper.map(post, PostRepresentationModel.class);
    }

    public List<PostRepresentationModel> toCollection(List<Post> posts) {
        return posts.stream().map(this::toModel).toList();
    }
}
