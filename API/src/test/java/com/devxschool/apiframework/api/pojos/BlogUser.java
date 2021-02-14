package com.devxschool.apiframework.api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogUser {
    private String id;
    private String name;
    private String email;
    private int age;
}
