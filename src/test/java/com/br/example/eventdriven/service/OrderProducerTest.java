package com.br.example.eventdriven.service;

import com.br.example.eventdriven.model.OrderEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderProducerTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private OrderProducer orderProducer;

    @BeforeEach
    void setUp() {
        // Definindo manualmente o nome da fila para evitar erro de null
        orderProducer = new OrderProducer(rabbitTemplate);
        org.springframework.test.util.ReflectionTestUtils.setField(orderProducer, "queueName", "order-queue");
    }

    @Test
    void sendOrderEvent_ShouldSendMessageToQueue() {
        // Given
        OrderEvent orderEvent = new OrderEvent("123", "João Silva", "PENDING");

        // When
        orderProducer.sendOrderEvent(orderEvent);

        // Then
        verify(rabbitTemplate, times(1)).convertAndSend(eq("order-queue"), eq(orderEvent));
    }
}
