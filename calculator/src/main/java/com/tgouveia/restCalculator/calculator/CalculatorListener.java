package com.tgouveia.restCalculator.calculator;

import com.tgouveia.restCalculator.calculator.model.CalculatorRequest;
import com.tgouveia.restCalculator.calculator.model.CalculatorResponse;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatorListener {
    private RabbitTemplate rabbitTemplate;
    private CalculatorService calculatorService;

    private static final String REQUEST_QUEUE = "request.queue";
    private static final String RESPONSE_QUEUE = "response.queue";

    @Autowired
    public CalculatorListener(RabbitTemplate rabbitTemplate, CalculatorService calculatorService) {
        this.rabbitTemplate = rabbitTemplate;
        this.calculatorService = calculatorService;
    }

    @RabbitListener(queues = REQUEST_QUEUE)
    public void receive(CalculatorRequest request) {
        String id = request.getId();
        MDC.put("id", id);
        try {
            CalculatorResponse response = new CalculatorResponse(
                    calculatorService.calculate(request.getOperator(), request.getA(), request.getB()),
                    id, null
            );
            rabbitTemplate.convertAndSend(RESPONSE_QUEUE, response);
        } catch (Exception e) {
            CalculatorResponse response = new CalculatorResponse(null, id, e.getMessage());
            rabbitTemplate.convertAndSend(RESPONSE_QUEUE, response);
        } finally {
            MDC.remove("id");
        }
    }
}
