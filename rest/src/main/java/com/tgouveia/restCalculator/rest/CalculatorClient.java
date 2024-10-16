package com.tgouveia.restCalculator.rest;

import com.tgouveia.restCalculator.calculator.model.CalculatorRequest;
import com.tgouveia.restCalculator.calculator.model.CalculatorResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorClient {
    private final RabbitTemplate rabbitTemplate;

    public static final String REQUEST_QUEUE = "request.queue";
    public static final String RESPONSE_QUEUE = "response.queue";

    @Autowired
    public CalculatorClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public CalculatorResponse calculate(String operation, BigDecimal a, BigDecimal b) {
        CalculatorRequest calculatorRequest = new CalculatorRequest(operation, a, b);
        rabbitTemplate.convertAndSend(REQUEST_QUEUE, calculatorRequest);
        return (CalculatorResponse) rabbitTemplate.receiveAndConvert(RESPONSE_QUEUE, 5000);
    }

}
