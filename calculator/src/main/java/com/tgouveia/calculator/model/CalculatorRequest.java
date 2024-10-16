package com.tgouveia.calculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculatorRequest {
    private BigDecimal a;
    private BigDecimal b;
    private String operator;

    public CalculatorRequest() {}

    public CalculatorRequest(BigDecimal a, BigDecimal b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }
}
