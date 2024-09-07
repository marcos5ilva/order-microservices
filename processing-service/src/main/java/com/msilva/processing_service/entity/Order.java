package com.msilva.processing_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msilva.processing_service.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id = UUID.randomUUID();

    private String client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "order_items")
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name="email_notification")
    private String emailNotification;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "on_created")
    private LocalDateTime onCreated = LocalDateTime.now();

}
