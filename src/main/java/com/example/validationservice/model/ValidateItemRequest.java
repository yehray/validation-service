package com.example.validationservice.model;

import com.example.validationservice.annotations.ValidItemCondition;
import com.example.validationservice.annotations.ValidItemSpecifics;
import com.example.validationservice.annotations.ValidUrl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class ValidateItemRequest {

    @NotEmpty
    private String siteID;

    @NotEmpty
    private String categoryID;

    @NotEmpty
    private String title;

    @NotEmpty
    @ValidItemCondition
    private String condition;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @NotEmpty
    @ValidUrl
    private List<String> imageURLs;

    @NotEmpty
    @Size(max=2)
    @ValidItemSpecifics
    private List<String> itemSpecifics;

    @NotEmpty
    private String description;
}

