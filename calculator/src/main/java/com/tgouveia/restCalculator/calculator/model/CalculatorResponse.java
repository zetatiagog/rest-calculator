package com.tgouveia.restCalculator.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculatorResponse implements Serializable {
    private BigDecimal result;
    private String id;
    private String error;

    public CalculatorResponse() {}

    public CalculatorResponse(BigDecimal result, String id, String error) {
        this.result = result;
        this.id = id;
        this.error = error;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
