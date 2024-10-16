package com.tgouveia.restCalculator.calculator.model;

import java.io.Serializable;

public class CalculatorResponse implements Serializable {
    private String result;
    private String error;

    public CalculatorResponse() {}

    public CalculatorResponse(String result, String error) {
        this.result = result;
        this.error = error;
    }
}
