package com.br.example.eventdriven.service;

import com.br.example.eventdriven.model.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${order.queue.name}")
    private String queueName;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderEvent(OrderEvent event) {
        rabbitTemplate.convertAndSend(queueName, event);
    }
}
