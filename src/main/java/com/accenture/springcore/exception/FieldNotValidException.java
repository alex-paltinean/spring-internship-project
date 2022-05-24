package com.accenture.springcore.exception;

public class FieldNotValidException extends RuntimeException {

    private final String fieldName;

    public FieldNotValidException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
