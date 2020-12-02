package pl.mloza.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.mloza.model.RequestWithZipCode;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CustomValidatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnErrorWhenInputIsInvalid() throws Exception {
        mvc.perform(post("/zipCode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidBody()))
                .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnOkWhenInputIsValid() throws Exception {
        mvc.perform(post("/zipCode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(validBody()))
                .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
                .andExpect(status().is2xxSuccessful());
    }

    private String invalidBody() throws JsonProcessingException {
        return objectMapper.writeValueAsString(
                new RequestWithZipCode("1-21"));
    }

    private String validBody() throws JsonProcessingException {
        return objectMapper.writeValueAsString(
                new RequestWithZipCode("31-521"));
    }
}
