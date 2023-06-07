package com.example.validationservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class ValidationErrorResponse {
    private String status;
    private List<Violation> violations;
}