package com.example.validationservice.validator;

import com.example.validationservice.annotations.ValidUrl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.net.URL;
import java.util.List;

public class UrlValidator implements ConstraintValidator<ValidUrl, List<String>> {

    @Override
    public boolean isValid(List<String> urlList, ConstraintValidatorContext context) {
        if (urlList != null) {
            for (String url : urlList) {
                try {
                    new URL(url);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
}