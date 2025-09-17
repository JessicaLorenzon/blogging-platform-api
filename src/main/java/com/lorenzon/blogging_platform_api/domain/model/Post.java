package com.lorenzon.blogging_platform_api.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String title;
    private String content;
    private String category;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public void updateWith(Post source) {
        this.title = source.getTitle();
        this.content = source.getContent();
        this.category = source.getCategory();
    }
}
