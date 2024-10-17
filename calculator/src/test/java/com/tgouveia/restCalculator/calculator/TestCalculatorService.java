package com.tgouveia.restCalculator.calculator;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class TestCalculatorService {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testSum() {
        BigDecimal result = calculatorService.calculate("sum", new BigDecimal("2"), new BigDecimal("1"));
        assertEquals(new BigDecimal("3"), result);
    }

    @Test
    void testSubtract() {
        BigDecimal result = calculatorService.calculate("sub",new BigDecimal("2"), new BigDecimal("1"));
        assertEquals(new BigDecimal("1"), result);
    }

    @Test
    void testMultiply() {
        BigDecimal result = calculatorService.calculate("mul",new BigDecimal("2"), new BigDecimal("1"));
        assertEquals(new BigDecimal("2"), result);
    }

    @Test
    void testDivide() {
        BigDecimal result = calculatorService.calculate("div",new BigDecimal("2"), new BigDecimal("1"));
        assertEquals(new BigDecimal("2.00"), result);
    }
}
