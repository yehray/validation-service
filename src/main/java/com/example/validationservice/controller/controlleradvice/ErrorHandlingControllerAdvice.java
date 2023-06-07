package com.example.validationservice.controller.controlleradvice;

import static com.example.validationservice.constants.StatusConstants.ERROR;

import com.example.validationservice.model.ValidationErrorResponse;
import com.example.validationservice.model.Violation;

import java.util.ArrayList;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
class ErrorHandlingControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationErrorResponse error = ValidationErrorResponse.builder()
            .status(ERROR.value)
            .violations(new ArrayList<>())
            .build();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            Violation violation = Violation.builder()
                .fieldName(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
            error.getViolations().add(violation);
        }
        return error;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ValidationErrorResponse error = ValidationErrorResponse.builder()
            .status(ERROR.value)
            .violations(new ArrayList<>())
            .build();
        Violation violation = Violation.builder()
            .message(e.getMessage())
            .build();
        error.getViolations().add(violation);
        return error;
    }

}
