package com.msilva.notifications_service.service;


import com.msilva.notifications_service.entity.Order;
import com.msilva.notifications_service.entity.enums.Status;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Order order) {
        var simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("orders-api@companny.com");
        simpleMailMessage.setTo(order.getEmailNotification());
        simpleMailMessage.setSubject("Selling Order");
        simpleMailMessage.setText(this.generateMessage(order));
        javaMailSender.send(simpleMailMessage);
    }

    private String generateMessage(Order order) {
        UUID orderId = order.getId();
        String orderClient = order.getClient();
        Double orderTotalValue = order.getTotalValue();
        Status orderStatus = order.getStatus();

        return String.format("""
                        Dear %s,
                        
                        Thank you for your order! Here are the details of your recent purchase:
                        
                        Order ID: %s
                        Total Value: $%.2f
                        Status: %s
                        
                        We appreciate your business and will notify you of any updates regarding your order status.
                        
                        Best regards,
                        
                        This Company.
                        """,
                orderClient, orderId, orderTotalValue, orderStatus
        );
    }


}
