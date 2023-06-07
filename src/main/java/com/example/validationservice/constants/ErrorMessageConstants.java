package com.example.validationservice.constants;

public enum ErrorMessageConstants {
    ITEM_CONDITION_ERROR(Constants.ITEM_CONDITION_ERROR),
    ITEM_SPECIFICS_NORMALIZER_ERROR(Constants.ITEM_SPECIFICS_NORMALIZER_ERROR),
    IMAGE_URL_ERROR(Constants.IMAGE_URL_ERROR);

    public final String value;

    private ErrorMessageConstants(String value) {
        this.value = value;
    }
    public static class Constants {
        public static final String ITEM_CONDITION_ERROR = "Condition must be NEW, OPEN_BOX, CERTIFIED_REFURBISHED, SELLER_REFURBISHED,or USED.";
        public static final String ITEM_SPECIFICS_NORMALIZER_ERROR = "Error with ItemSpecificsNormalizerService.";
        public static final String IMAGE_URL_ERROR = "Inputs must be valid URLs.";
    }
}
