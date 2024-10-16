package com.tgouveia.restCalculator.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculatorRequest implements Serializable {
    private String operator;
    private BigDecimal a;
    private BigDecimal b;

    public CalculatorRequest() {}

    public CalculatorRequest(String operator, BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }
}
