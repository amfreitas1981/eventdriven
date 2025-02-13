package com.br.example.eventdriven.service;

import com.br.example.eventdriven.model.OrderEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

//    private final Logger logger;
    private final ObjectMapper objectMapper;

    // 🔹 Injeção de dependência para permitir mock nos testes
    public OrderConsumer(ObjectMapper objectMapper) {
//        this.logger = logger;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "${order.queue.name}")
    public void processOrderEvent(OrderEvent event) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(event);
            System.out.println("📩 Mensagem recebida na fila: " + jsonMessage);
            log.info("📩 Mensagem recebida na fila RabbitMQ: " + jsonMessage);
        } catch (JsonProcessingException e) {
            System.err.println("Erro ao converter mensagem para JSON: " + e.getMessage());
            log.error("Erro na requisição: " + e.getMessage());
        }
    }
}
