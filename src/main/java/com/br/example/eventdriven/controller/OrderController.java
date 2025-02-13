package com.br.example.eventdriven.controller;

import com.br.example.eventdriven.model.OrderEvent;
import com.br.example.eventdriven.service.OrderProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order API", description = "APIs relacionadas a pedidos")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    @Operation(summary = "Criar novo pedido", description = "Publica um evento de criação de pedido.")
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent orderEvent) {
        orderProducer.sendOrderEvent(orderEvent);
        return ResponseEntity.ok("Evento enviado com sucesso!");
    }
}
