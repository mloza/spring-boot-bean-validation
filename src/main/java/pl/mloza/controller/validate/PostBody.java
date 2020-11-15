package pl.mloza.controller.validate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PostBody {
    @Email
    private String email;

    @Min(value = 18, message = "You're too young")
    private int age;

    @Size(min = 2, max = 10)
    private String name;

    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String zipCode;

    public PostBody(@Email String email, @Min(value = 18, message = "You're too young") int age, @Size(min = 2, max = 10) String name, @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$") String zipCode) {
        this.email = email;
        this.age = age;
        this.name = name;
        this.zipCode = zipCode;
    }

    public PostBody() {
    }

    public String getEmail() {
        return email;
    }

    public PostBody setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PostBody setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public PostBody setName(String name) {
        this.name = name;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PostBody setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
