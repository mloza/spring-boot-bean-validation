package pl.mloza.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mloza.model.RequestWithZipCode;

import javax.validation.Valid;

@RestController
public class CustomValidatorController {
    @PostMapping("/zipCode")
    @ResponseBody
    public String zipCodeBody(
            @RequestBody @Valid RequestWithZipCode body // #1
    ) {
        return "OK! Everything is valid";
    }
}
