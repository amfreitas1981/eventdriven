package com.br.example.eventdriven.model;

import java.io.Serial;
import java.io.Serializable;

public class OrderEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String orderId;
    private String customerName;
    private String status;

    public OrderEvent(String orderId, String customerName, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.status = status;
    }

    // Getters e Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
