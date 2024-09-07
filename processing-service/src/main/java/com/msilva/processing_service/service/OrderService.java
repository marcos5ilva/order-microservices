package com.msilva.processing_service.service;

import com.msilva.processing_service.entity.Order;
import com.msilva.processing_service.entity.OrderItem;
import com.msilva.processing_service.listener.OrdersListener;
import com.msilva.processing_service.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrdersListener.class);

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, OrderItemService orderItemService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
        this.productService = productService;
    }

    public void save(Order order) {
        productService.save(order.getOrderItems());

        List<OrderItem> orderItemList = orderItemService.save(order.getOrderItems());

        orderRepository.save(order);

        orderItemService.updateOrder(orderItemList, order);

        logger.info("Order successfully saved: {}", order.toString());


    }
}
