package pl.mloza.programmatic;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProgrammaticValidation {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setName("");
        user.setAge(10);
        user.setAboutMe("short");
        user.setEmail("notAnEmail");
        user.setNotARobot(false);
        user.setPet(new Pet(""));
        user.setZipCode(Optional.of("123"));

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        System.out.println(violations);

        User validUser = new User();
        validUser.setName("Michal");
        validUser.setAge(30);
        validUser.setAboutMe("A little bit longer about me text. Text length should be in size constraints");
        validUser.setEmail("valid@email.com");
        validUser.setNotARobot(true);
        validUser.setPet(new Pet("Azor"));
        user.setZipCode(Optional.of("35-123"));

        Set<ConstraintViolation<User>> noViolations = validator.validate(validUser);
        System.out.println(noViolations);
    }
}
