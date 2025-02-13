package com.br.example.eventdriven.controller;

import com.br.example.eventdriven.model.OrderEvent;
import com.br.example.eventdriven.service.OrderProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderProducer orderProducer;

    @InjectMocks
    private OrderController orderController;

    @Test
    void createOrder_ShouldSendEventAndReturnSuccessMessage() {
        // Given
        OrderEvent orderEvent = new OrderEvent("123", "João Silva", "PENDING");

        // When
        ResponseEntity<String> response = orderController.createOrder(orderEvent);

        // Then
        verify(orderProducer, times(1)).sendOrderEvent(orderEvent);
        assertEquals("Evento enviado com sucesso!", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}
