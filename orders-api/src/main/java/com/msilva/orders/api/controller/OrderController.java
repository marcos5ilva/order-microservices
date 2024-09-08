package com.msilva.orders.api.controller;

import com.msilva.orders.api.entity.Order;
import com.msilva.orders.api.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Orders", description = "Resource to create a new order")
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create a new order", description = "Order creation",
            responses = @ApiResponse(responseCode = "201", description = "Resource successfully created",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Order.class))))
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        logger.info("Order received: " + order.toString());
        var response = orderService.queueOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
