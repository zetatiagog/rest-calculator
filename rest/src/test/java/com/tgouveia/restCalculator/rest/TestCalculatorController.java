package com.tgouveia.restCalculator.rest;

import com.tgouveia.restCalculator.RestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = RestApplication.class)
@AutoConfigureMockMvc
class TestCalculatorController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSum() throws Exception {
        mockMvc.perform(get("/api/sum?a=2&b=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(3))
                .andExpect(jsonPath("$.error").doesNotExist());
    }

    @Test
    void testSub() throws Exception {
        mockMvc.perform(get("/api/sub?a=2&b=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1))
                .andExpect(jsonPath("$.error").doesNotExist());
    }

    @Test
    void testMul() throws Exception {
        mockMvc.perform(get("/api/mul?a=2&b=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2))
                .andExpect(jsonPath("$.error").doesNotExist());
    }

    @Test
    void testDiv() throws Exception {
        mockMvc.perform(get("/api/div?a=2&b=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2))
                .andExpect(jsonPath("$.error").doesNotExist());
    }
}
