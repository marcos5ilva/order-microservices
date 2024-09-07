package com.msilva.processing_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    private Product product;

    private Integer quantity;

    @ManyToOne
    private Order order;

}
