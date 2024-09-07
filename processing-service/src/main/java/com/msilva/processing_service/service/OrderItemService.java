package com.msilva.processing_service.service;

import com.msilva.processing_service.entity.Order;
import com.msilva.processing_service.entity.OrderItem;
import com.msilva.processing_service.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;


    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> save(List<OrderItem> orderItems) {
        return orderItemRepository.saveAll(orderItems);
    }

    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void updateOrder(List<OrderItem> orderItemList, Order order) {
        orderItemList.forEach(item -> {
            item.setOrder(order);
            this.save(item);
        });
    }
}
