package com.devxschool.apiframework.api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({"code", "meta"})
public class UserResponseObject {
    @JsonProperty("data")
    private User user;
}
