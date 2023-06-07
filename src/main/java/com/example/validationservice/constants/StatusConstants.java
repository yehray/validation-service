package com.example.validationservice.constants;

public enum StatusConstants {
    SUCCESS("success"),
    ERROR("error"),
    VALID_ITEM("Item is valid.");

    public final String value;

    private StatusConstants(String value) {
        this.value = value;
    }
}
