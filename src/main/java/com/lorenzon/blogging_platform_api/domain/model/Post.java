package com.lorenzon.blogging_platform_api.domain.model;


import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.OffsetDateTime;
import java.util.List;

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

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private List<String> tags;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public void updateWith(Post source) {
        this.title = source.getTitle();
        this.content = source.getContent();
        this.category = source.getCategory();
        this.tags = source.getTags();
    }
}
