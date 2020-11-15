package pl.mloza.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.mloza.controller.validate.PostBody;

import javax.validation.Valid;

@Validated
@Service
public class ValidationInService {

    void validatePostBody(@Valid PostBody postBody) {
        System.out.println("PostBody is valid!");
    }

}
