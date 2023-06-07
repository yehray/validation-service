package com.example.validationservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Violation {
    private String fieldName;
    private String message;
}
