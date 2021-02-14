package com.devxschool.apiframework.api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private int id;
    private String name;
    private String description;
    private String image;
    private String price;
    @JsonProperty("discount_amount")
    private String discountAmount;
    private boolean status;
}
