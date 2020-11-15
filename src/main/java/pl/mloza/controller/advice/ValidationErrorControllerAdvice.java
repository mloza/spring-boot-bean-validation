package pl.mloza.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice  // #1
public class ValidationErrorControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class) // #2
    @ResponseStatus(HttpStatus.BAD_REQUEST) // #3
    @ResponseBody
    public ValidationErrorResponse validationError(ConstraintViolationException exception) {
        ValidationErrorResponse response = new ValidationErrorResponse();

        for(ConstraintViolation error: exception.getConstraintViolations()) {
            response.addError(
                    new ValidationError(
                            error.getPropertyPath().toString(),
                            error.getMessage()));
        }

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse validationError(MethodArgumentNotValidException exception) {
        ValidationErrorResponse response = new ValidationErrorResponse();

        for(FieldError error: exception.getBindingResult().getFieldErrors()) {
            response.addError(
                    new ValidationError(
                            error.getField(),
                            error.getDefaultMessage()));
        }

        return response;
    }
}
