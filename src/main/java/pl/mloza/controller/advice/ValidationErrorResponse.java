package pl.mloza.controller.advice;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {

    private List<ValidationError> errors = new ArrayList<>();

    public List<ValidationError> getErrors() {
        return errors;
    }

    public ValidationErrorResponse setErrors(List<ValidationError> errors) {
        this.errors = errors;
        return this;
    }

    public ValidationErrorResponse addError(ValidationError error) {
        this.errors.add(error);
        return this;
    }
}
