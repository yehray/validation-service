package com.example.validationservice.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.validationservice.constants.ErrorMessageConstants;
import com.example.validationservice.validator.ItemConditionValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = ItemConditionValidator.class)
@Documented
public @interface ValidItemCondition {
    String message() default ErrorMessageConstants.Constants.ITEM_CONDITION_ERROR;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
