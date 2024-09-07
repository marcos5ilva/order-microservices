package com.msilva.processing_service.service;

import com.msilva.processing_service.entity.OrderItem;
import com.msilva.processing_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(List<OrderItem> orderItems) {
        orderItems.forEach(item -> productRepository.save(item.getProduct()));
    }
}
