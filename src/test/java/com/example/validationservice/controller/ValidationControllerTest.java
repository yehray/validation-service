package com.example.validationservice.controller;

import static com.example.validationservice.constants.StatusConstants.SUCCESS;
import static com.example.validationservice.constants.StatusConstants.VALID_ITEM;

import com.example.validationservice.model.ValidateItemRequest;
import com.example.validationservice.model.ValidateItemResponse;

import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ValidationControllerTest {

    @InjectMocks
    private ValidationController validationController;

    @Test
    public void testValidateItem() {
        ValidateItemRequest request = ValidateItemRequest.builder()
            .siteID("testId")
            .categoryID("testId")
            .title("testTitle")
            .condition("NEW")
            .price(BigDecimal.valueOf(10.99))
            .quantity(5)
            .imageURLs(Arrays.asList("http://testImageUrl/image"))
            .itemSpecifics(Arrays.asList("testItemSpecific"))
            .description("testDescription")
            .build();

        ResponseEntity<ValidateItemResponse> responseEntity = validationController.validateItem(request);
        Assertions.assertEquals(responseEntity.getStatusCode().value(), 200);
        Assertions.assertEquals(responseEntity.getBody().getStatus(), SUCCESS.value);
        Assertions.assertEquals(responseEntity.getBody().getMessage(), VALID_ITEM.value);
    }

}