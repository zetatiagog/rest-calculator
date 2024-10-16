package com.tgouveia.restCalculator.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculatorRequest implements Serializable {
    private String operator;
    private BigDecimal a;
    private BigDecimal b;
    private String id;

    public CalculatorRequest() {}

    public CalculatorRequest(String operator, BigDecimal a, BigDecimal b, String id) {
        this.operator = operator;
        this.a = a;
        this.b = b;
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
