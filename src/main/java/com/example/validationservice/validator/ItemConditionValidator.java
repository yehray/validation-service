package com.example.validationservice.validator;

import com.example.validationservice.annotations.ValidItemCondition;
import com.example.validationservice.constants.Conditions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ItemConditionValidator implements ConstraintValidator<ValidItemCondition, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Conditions.isCondition(value);
    }
}