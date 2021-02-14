package com.devxschool.apiframework.api.pojos;

import lombok.Data;

import java.util.List;

@Data
public class BlogPost {
    private String id;
    private String userId;
    private String title;
    private String description;
    private List<PostComment> comments;
}
