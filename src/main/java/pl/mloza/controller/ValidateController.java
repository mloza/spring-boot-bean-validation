package pl.mloza.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mloza.controller.validate.PostBody;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Controller
@Validated  // #1
public class ValidateController {

    @GetMapping("/site/{id}")
    @ResponseBody
    public String validationInPath(
            @PathVariable("id") @Min(10) @Max(20) int id  // #2
    ) {
        return "OK! id: " + id;
    }

    @GetMapping("/query")
    @ResponseBody
    public String validationInQuery(
            @RequestParam(value = "id") @Min(10) int id  // #3
    ) {
        return "OK! id: " + id;
    }

    @PostMapping("/data")
    @ResponseBody
    public String validationBody(
            @RequestBody @Valid PostBody body // #1
    ) {
        return "OK! Everything is valid";
    }
}
