package pl.mloza.programmatic;

import javax.validation.constraints.NotBlank;

public class Pet {
    @NotBlank
    private String name;

    public Pet(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }
}
