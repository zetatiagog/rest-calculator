package com.tgouveia.calculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorService {
    public BigDecimal calculate(BigDecimal a, BigDecimal b, String operator) {
        switch (operator) {
            case "sum":
                return a.add(b);
            case "sub":
                return a.subtract(b);
            case "mul":
                return a.multiply(b);
            case "div":
                return a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }
}
