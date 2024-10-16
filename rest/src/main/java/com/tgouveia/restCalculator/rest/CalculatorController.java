package com.tgouveia.restCalculator.rest;

import com.tgouveia.restCalculator.calculator.model.CalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @Autowired
    private CalculatorClient calculatorClient;

    @GetMapping("/sum")
    public CalculatorResponse sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        return calculatorClient.calculate("sum", a, b);
    }

    @GetMapping("/sub")
    public CalculatorResponse sub(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        return calculatorClient.calculate("sub", a, b);
    }

    @GetMapping("/mul")
    public CalculatorResponse mul(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        return calculatorClient.calculate("mul", a, b);
    }

    @GetMapping("/div")
    public CalculatorResponse div(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
        return calculatorClient.calculate("div", a, b);
    }
}
