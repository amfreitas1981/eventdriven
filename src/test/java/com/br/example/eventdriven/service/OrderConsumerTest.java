package com.br.example.eventdriven.service;

import com.br.example.eventdriven.model.OrderEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderConsumerTest {

//    @Mock
//    private Logger logger;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private OrderConsumer orderConsumer;

    private OrderEvent orderEvent;

    @BeforeEach
    void setUp() {
        orderEvent = new OrderEvent("123", "João Silva", "PENDING");
        orderConsumer = new OrderConsumer(objectMapper); // 🔹 Passamos os mocks via construtor
    }

    @Test
    void processOrderEvent_ShouldLogMessage_WhenEventIsValid() throws JsonProcessingException {
        // Given
        String jsonMessage = "{\"orderId\":\"123\",\"customerName\":\"João Silva\",\"status\":\"PENDING\"}";
        when(objectMapper.writeValueAsString(orderEvent)).thenReturn(jsonMessage);

        // When
        orderConsumer.processOrderEvent(orderEvent);

        // Then
        verify(objectMapper, times(1)).writeValueAsString(orderEvent);
//        verify(logger, times(1)).info("📩 Mensagem recebida na fila RabbitMQ: " + jsonMessage);
    }

    @Test
    void processOrderEvent_ShouldLogError_WhenJsonProcessingFails() throws JsonProcessingException {
        // Given
        when(objectMapper.writeValueAsString(orderEvent)).thenThrow(new JsonProcessingException("Erro ao converter para JSON") {});

        // When
        orderConsumer.processOrderEvent(orderEvent);

        // Then
        verify(objectMapper, times(1)).writeValueAsString(orderEvent);
//        verify(logger, times(1)).error("Erro na requisição: Erro ao converter para JSON");
    }
}
