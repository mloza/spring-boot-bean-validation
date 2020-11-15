package pl.mloza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class ValidEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Min(18)
    @Max(130)
    private Integer age;

    @Size(min = 2, max=128)
    @Column
    private String name;

    @Column
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    public ValidEntity(Integer age, String name, String zipCode) {
        this.age = age;
        this.name = name;
        this.zipCode = zipCode;
    }

    public ValidEntity() {
    }

    public Long getId() {
        return id;
    }

    public ValidEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ValidEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public ValidEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public ValidEntity setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
