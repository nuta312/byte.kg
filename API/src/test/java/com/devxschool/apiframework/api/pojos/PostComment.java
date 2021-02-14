package com.devxschool.apiframework.api.pojos;

import lombok.Data;

@Data
public class PostComment {
    private String id;
    private String postId;
    private String comment;
}
