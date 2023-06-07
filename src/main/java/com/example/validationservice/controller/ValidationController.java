package com.example.validationservice.controller;

import static com.example.validationservice.constants.StatusConstants.SUCCESS;
import static com.example.validationservice.constants.StatusConstants.VALID_ITEM;

import com.example.validationservice.model.ValidateItemRequest;
import com.example.validationservice.model.ValidateItemResponse;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller to validate Item objects
 * @author Raymond Yeh 2023-06-02 21:59:56
 */
@Controller
public class ValidationController {

    @PostMapping(value = "/api/validateItem", consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<ValidateItemResponse> validateItem(@Valid @RequestBody ValidateItemRequest request) {
        return ResponseEntity.ok(ValidateItemResponse.builder()
            .status(SUCCESS.value)
            .message(VALID_ITEM.value).
            build());
    }
}
