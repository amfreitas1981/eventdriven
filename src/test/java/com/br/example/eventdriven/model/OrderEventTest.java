package com.br.example.eventdriven.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderEventTest {

    @Test
    void testOrderEvent() {

        OrderEvent orderEvent = new OrderEvent("1", "João Silva", "PENDING");
        orderEvent.setOrderId("1");
        orderEvent.setCustomerName("João Silva");
        orderEvent.setStatus("PENDING");

        assertNotNull(orderEvent);

        assertEquals("1", orderEvent.getOrderId());
        assertEquals("João Silva", orderEvent.getCustomerName());
        assertEquals("PENDING", orderEvent.getStatus());
    }
}
