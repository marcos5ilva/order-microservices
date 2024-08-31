package com.msilva.notifications_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msilva.notifications_service.entity.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {
    private UUID id = UUID.randomUUID();
    private String client;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double totalValue;
    private String emailNotification;
    private Status status = Status.PENDING;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime onCreated = LocalDateTime.now();


    public Order() {
    }

    public Order(UUID id, String client, List<OrderItem> orderItems, Double totalValue, String emailNotification, Status status, LocalDateTime onCreated) {
        this.id = id;
        this.client = client;
        this.orderItems = orderItems;
        this.totalValue = totalValue;
        this.emailNotification = emailNotification;
        this.status = status;
        this.onCreated = onCreated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(String emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getOnCreated() {
        return onCreated;
    }

    public void setOnCreated(LocalDateTime onCreated) {
        this.onCreated = onCreated;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", orderItems=" + orderItems +
                ", totalValue=" + totalValue +
                ", emailNotification='" + emailNotification + '\'' +
                ", status=" + status +
                ", onCreated=" + onCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getClient(), order.getClient()) && Objects.equals(getOrderItems(), order.getOrderItems()) && Objects.equals(getTotalValue(), order.getTotalValue()) && Objects.equals(getEmailNotification(), order.getEmailNotification()) && getStatus() == order.getStatus() && Objects.equals(getOnCreated(), order.getOnCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient(), getOrderItems(), getTotalValue(), getEmailNotification(), getStatus(), getOnCreated());
    }
}
