package com.example.validationservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ValidateItemResponse {
    private String status;
    private String message;
}
