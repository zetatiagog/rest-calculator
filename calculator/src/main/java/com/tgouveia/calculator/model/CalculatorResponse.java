package com.tgouveia.calculator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorResponse {
    private String result;
    private String error;

    public CalculatorResponse() {}

    public CalculatorResponse(String result, String error) {
        this.result = result;
        this.error = error;
    }
}
