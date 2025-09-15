package com.lorenzon.blogging_platform_api.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class PostRepresentationModel {

    private Long id;
    private String title;
    private String content;
    private String category;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
