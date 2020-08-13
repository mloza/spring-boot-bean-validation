package pl.mloza.programmatic;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Optional;

public class User {

    @NotBlank
    private String name;

    @Min(value = 18, message = "You are to young to use our service")
    @Max(value = 150, message = "People are not live that long")
    private int age;

    @AssertTrue
    private boolean notARobot;

    @Email
    private String email;

    @Size(min = 50, max = 255, message = "Create a text that is between 50 and 255 charters long")
    private String aboutMe;

    @Valid
    @NotNull
    private Pet pet;

    private Optional<@Pattern(regexp = "\\d{2}-\\d{3}") String> zipCode;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isNotARobot() {
        return notARobot;
    }

    public User setNotARobot(boolean notARobot) {
        this.notARobot = notARobot;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public User setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public Pet getPet() {
        return pet;
    }

    public User setPet(Pet pet) {
        this.pet = pet;
        return this;
    }

    public Optional<String> getZipCode() {
        return zipCode;
    }

    public User setZipCode(Optional<String> zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
