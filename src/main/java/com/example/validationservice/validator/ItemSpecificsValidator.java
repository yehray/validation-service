package com.example.validationservice.validator;

import com.example.validationservice.annotations.ValidItemSpecifics;
import com.example.validationservice.service.ItemSpecificsNormalizerService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemSpecificsValidator implements ConstraintValidator<ValidItemSpecifics, List<String>> {

    @Autowired
    ItemSpecificsNormalizerService itemSpecificsNormalizerService;

    @Override
    public boolean isValid(List<String> itemSpecifics, ConstraintValidatorContext context) {
        if (itemSpecifics != null) {
            for (String itemSpecific : itemSpecifics) {
                try {
                    itemSpecificsNormalizerService.normalize(itemSpecific);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
        }
        return true;
    }
}
