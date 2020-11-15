package pl.mloza.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mloza.controller.validate.PostBody;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ValidationInServiceTest {

    @Autowired
    private ValidationInService validationInService;

    @Test
    public void shouldValidateDataPassedToService() {
        assertThrows(
                ConstraintViolationException.class,
                () -> validationInService.validatePostBody(invalidBody()));
    }

    private PostBody invalidBody() {
        return new PostBody(
                "not-valid-email",
                2,
                "Very long name that is beyond constraint",
                "10-1000");
    }
}
