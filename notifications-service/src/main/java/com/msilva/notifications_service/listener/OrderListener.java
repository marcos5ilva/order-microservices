package com.msilva.notifications_service.listener;

import com.msilva.notifications_service.entity.Order;
import com.msilva.notifications_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
    private final Logger logger = LoggerFactory.getLogger(OrderListener.class);
    private final EmailService emailService;

    public OrderListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "orders.v1.order-created-generate-notification")
    private void sendNotification(Order order) {
        emailService.sendEmail(order);
        logger.info("Notification generated: {}", order.toString());
    }
}
