package com.msilva.processing_service.listener;

import com.msilva.processing_service.entity.Order;
import com.msilva.processing_service.entity.enums.Status;
import com.msilva.processing_service.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class OrdersListener {

    private final Logger logger = LoggerFactory.getLogger(OrdersListener.class);
    private final OrderService orderService;

    public OrdersListener(OrderService orderService) {
        this.orderService = orderService;
    }


    @RabbitListener(queues = "orders.v1.order-created-generate-process")
    public void saveOrder(Order order) {
        order.setStatus(Status.PROCESSED);
        orderService.save(order);
        logger.info("Order processed: {}", order.toString());
    }
}
