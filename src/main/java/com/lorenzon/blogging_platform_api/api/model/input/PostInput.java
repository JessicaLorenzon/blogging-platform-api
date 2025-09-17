package com.lorenzon.blogging_platform_api.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostInput {

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    @Size(max = 255)
    private String content;

    @NotBlank
    @Size(max = 50)
    private String category;

    @NotEmpty
    private List<String> tags;
}
