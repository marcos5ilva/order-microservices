package com.msilva.orders.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msilva.orders.api.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private UUID id = UUID.randomUUID();
    private String client;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Double totalValue;
    private String emailNotification;
    private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataTime;

}
