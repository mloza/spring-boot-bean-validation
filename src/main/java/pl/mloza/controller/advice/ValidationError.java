package pl.mloza.controller.advice;

public class ValidationError {

    private String fieldName;
    private String message;

    public ValidationError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public ValidationError() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public ValidationError setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ValidationError setMessage(String message) {
        this.message = message;
        return this;
    }
}
